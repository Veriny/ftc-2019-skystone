package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawArm {
    public DcMotor armMotor;
    public Servo clawServo;
    public Servo wristServo;
    public CRServo servo;

    public int armValue = 0;

    protected int armGrabPosition = -50;
    protected int armDumpPosition1 = -400;
    protected int armDumpPosition2 = -550;
    protected int armDumpPosition3 = -700;


    protected double wristGrabPosition = 0.45;
    protected double wristDumpPosition1 = 0.6;
    protected double wristDumpPosition2 = 0.75;
    protected double wristDumpPosition3 = 0.9;

    double clawReleasePosition = 0.0;
    double clawHoldPosition = 0.5;

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

        if(gp.a) {
            //armValue--;
            if(!armMotor.isBusy()) {
                grab();
                telemetry.addData("armValue ", armValue);
                telemetry.update();
            }
        }

        if(gp.b) {
            //armValue++;
            if(!armMotor.isBusy()) {
                dump();
                telemetry.addData("armValue ", armValue);
                telemetry.update();
            }
        }

        if(gp.x) {
            release();
        }
        else if(gp.y) {
            hold();
        }
    }



    public void dump() {
        if(armValue == 0) {
            armValue++;
            armMotor.setTargetPosition(armDumpPosition1);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            wristServo.setPosition(wristDumpPosition1);
            //wristServo.setPosition(wristPosition[armValue]);
        }
        else if(armValue == 1) {
            armValue++;
            armMotor.setTargetPosition(armDumpPosition2);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            wristServo.setPosition(wristDumpPosition2);
        }
        else if(armValue == 2) {
            armValue++;
            armMotor.setTargetPosition(armDumpPosition3);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            wristServo.setPosition(wristDumpPosition3);
        }
    }


    public void grab() {

        if(armValue == 3) {
        armValue--;
        armMotor.setTargetPosition(armDumpPosition2);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.2);
        wristServo.setPosition(wristDumpPosition2);
        //wristServo.setPosition(wristPosition[armValue]);
    }
        else if(armValue == 2) {
            armValue--;
            armMotor.setTargetPosition(armDumpPosition1);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            wristServo.setPosition(wristDumpPosition1);
            //wristServo.setPosition(wristPosition[armValue]);
        }
        else if(armValue == 1) {
            armValue--;
            armMotor.setTargetPosition(armGrabPosition);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            wristServo.setPosition(wristGrabPosition);
            //wristServo.setPosition(wristPosition[armValue]);
        }
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
