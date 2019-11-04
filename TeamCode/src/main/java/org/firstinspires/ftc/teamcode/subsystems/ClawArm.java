package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawArm {
    public DcMotor armMotor;
    public Servo clawServo;
    public Servo wristServo;

    //public int armValue = 0;

    protected int armGrabPosition = 0;
    int armGrabPosition2 = 450;
    protected int armDumpPosition1 = 700;
    protected int armDumpPosition2 = 850;
    protected int armDumpPosition3 = 1000;


    protected double wristGrabPosition = 0.0;
    protected double wristDumpPosition1 = 0.64;
    protected double wristDumpPosition2 = 0.73;
    protected double wristDumpPosition3 = 0.83;

    double clawReleasePosition = 0.2;
    double clawHoldPosition = 0.82;

    public ClawArm(DcMotor aM, Servo cS, Servo wS) {
        armMotor = aM;
        clawServo = cS;
        wristServo = wS;
        //do I need to move anything on init? c
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setPower(0.0);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void controls(Gamepad gp, Telemetry telemetry) {
     /*   if(gp.x || gp.a || gp.y || gp.b || gp.right_bumper || gp.left_bumper || gp.right_trigger > 0.1 ||
        gp.left_trigger > 0.1 || gp.dpad_down || gp.dpad_left || gp.dpad_right || gp.dpad_up) {
            armMotor.setPower(1);
            clawServo.setPosition(0.5);
            wristServo.setPosition(0.25);
        }   //max.jpeg
      */

        if (gp.a) {
            armGrab();
        }

        else if(gp.b) {
            armDump1();
        }

        else if(gp.y) {
            armDump2();
        }

        else if(gp.x) {
            armDump3();
        }

        /*else {
            armMotor.setPower(0.0);
        } */




      /*  if (gp.dpad_left) {
            wrist0();
        }

        else if (gp.dpad_right) {
            wrist1();
        } */

        if (gp.dpad_up) {
            release();
        }
        else if (gp.dpad_down) {
            hold();
        }



       /* if (gp.left_bumper) {
            armDown();
        }

        else if (gp.right_bumper) {
            armUp();
        }

        else {
            armMotor.setPower(0.0);
        } */
    }


    /*public void armUp() {
        armMotor.setPower(0.35);
    }

    public void armDown() {
        armMotor.setPower(-0.35);
    }*/

    public void armGrab() {
            armMotor.setTargetPosition(armGrabPosition);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.15);
            wristServo.setPosition(wristGrabPosition);
    }

    public void armDump1() {
        armMotor.setTargetPosition(armGrabPosition2);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.13);
        wristServo.setPosition(wristDumpPosition1);
        while(armMotor.isBusy());

        armMotor.setTargetPosition(armDumpPosition1);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.05);

    }

    public void armDump2() {
        armMotor.setTargetPosition(armDumpPosition2);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.13);
        wristServo.setPosition(wristDumpPosition2);
        jigglypuff();
    }

    public void armDump3() {
        armMotor.setTargetPosition(armDumpPosition3);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.12);
        wristServo.setPosition(wristDumpPosition3);
    }

    public void wristPos1() {
        wristServo.setPosition(wristDumpPosition1);
    }

    public void wristPos2() {
            /*armMotor.setTargetPosition(armDumpPosition2);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2); */
        wristServo.setPosition(wristDumpPosition2);
    }

    public void wristPos3() {
            /*armMotor.setTargetPosition(armDumpPosition3);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2); */
            wristServo.setPosition(wristDumpPosition3);
        }


  /*  public void wrist1() {
        wristServo.setPosition(1.0);
    }
    public void wrist0() {
        wristServo.setPosition(0.0);
    }   */

    public void hold() {
        clawServo.setPosition(clawHoldPosition);
    }

    public void release() {
        clawServo.setPosition(clawReleasePosition);
    }

    public void jigglypuff() {
        while (armMotor.isBusy()) {


        }


    }
}
