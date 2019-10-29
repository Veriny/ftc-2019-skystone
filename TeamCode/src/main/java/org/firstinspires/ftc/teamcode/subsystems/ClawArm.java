package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawArm {
    public DcMotor armMotor;
    public Servo clawServo;
    public Servo wristServo;

    public int armValue = 0;

    protected int armGrabPosition = 50;
    protected int armDumpPosition1 = 400;
    protected int armDumpPosition2 = 550;
    protected int armDumpPosition3 = 700;


    protected double wristGrabPosition = 0.0;
    protected double wristDumpPosition1 = 0.25;
    protected double wristDumpPosition2 = 0.50;
    protected double wristDumpPosition3 = 0.75;

    double clawReleasePosition = 0.0;
    double clawHoldPosition = 0.6;

    public ClawArm(DcMotor aM, Servo cS, Servo wS) {
        armMotor = aM;
        clawServo = cS;
        wristServo = wS;
        //do I need to move anything on init? c
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setPower(0.0);
        //armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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
            grab();
        }

        if (gp.b) {
            wristPos1();
        }

        if(gp.y) {
            wristPos2();
        }

        if(gp.x) {
            wristPos3();
        }


        if (gp.dpad_left) {
            wrist0();
        }

        if (gp.dpad_right) {
            wrist1();
        }

        if (gp.dpad_up) {
            release();
        } else if (gp.dpad_down) {
            hold();
        }



        if (gp.left_bumper) {
            armDown();
        }

        else if (gp.right_bumper) {
            armUp();
        }

        else {
            armMotor.setPower(0.0);
        }
    }


    public void armUp() {
        armMotor.setPower(0.25);
    }

    public void armDown() {
        armMotor.setPower(-0.25);
    }

    public void grab() {
            /*armMotor.setTargetPosition(armDumpPosition1);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2); */
            wristServo.setPosition(wristGrabPosition);
            //wristServo.setPosition(wristPosition[armValue]);
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


    public void wrist1() {
        wristServo.setPosition(1.0);
    }
    public void wrist0() {
        wristServo.setPosition(0.0);
    }

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
