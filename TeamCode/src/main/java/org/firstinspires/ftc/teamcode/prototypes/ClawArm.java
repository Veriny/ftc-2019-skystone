package org.firstinspires.ftc.teamcode.prototypes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ClawArm {
    public DcMotor armMotor;
    public Servo clawServo;
    public Servo wristServo;

    public int armValue = 0;

    protected int armGrabPosition = -50;
    protected int armDumpPosition1 = -400;
    protected int armDumpPosition2 = -550;
    protected int armDumpPosition3 = -700;
    //protected int[] armPosition = {armGrabPosition, armDumpPosition1, armDumpPosition2, armDumpPosition3};

    protected double wristGrabPosition = 0.0;
    protected double wristDumpPosition1 = 1.0;
    protected double wristDumpPosition2 = 1.1;
    protected double wristDumpPosition3 = 1.2;
    //protected double[] wristPosition = {wristGrabPosition, wristDumpPosition1, wristDumpPosition2, wristDumpPosition3};


    public ClawArm(DcMotor aM) { //, Servo cS, Servo wS) {
        armMotor = aM;
       // clawServo = cS;
        //wristServo = wS;
        //do I need to move anything on init?
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

        //TODO: fix the jump of armValue from 0 to 3 - wait on input?
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
    }


    public void dump() {
        if(armValue == 0) {
            armValue++;
            armMotor.setTargetPosition(armDumpPosition1);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            //wristServo.setPosition(wristPosition[armValue]);
        }
        if(armValue == 1) {
            armValue++;
            armMotor.setTargetPosition(armDumpPosition2);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
        }
        if(armValue == 2) {
            armValue++;
            armMotor.setTargetPosition(armDumpPosition3);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
        }
    }


    public void grab() {
        if(armValue == 1) {
            armValue--;
            armMotor.setTargetPosition(armGrabPosition);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            //wristServo.setPosition(wristPosition[armValue]);
        }
        if(armValue == 2) {
            armValue--;
            armMotor.setTargetPosition(armDumpPosition1);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            //wristServo.setPosition(wristPosition[armValue]);
        }
        if(armValue == 3) {
            armValue--;
            armMotor.setTargetPosition(armDumpPosition2);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            //wristServo.setPosition(wristPosition[armValue]);
        }
    }

    public void jigglypuff() {
        while (armMotor.isBusy()) {


        }


    }
}
