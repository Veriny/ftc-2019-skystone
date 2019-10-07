package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawArm {
    public DcMotor armMotor;
    public Servo clawServo;
    public Servo wristServo;


    protected int armValue = 0;

    protected int armGrabPosition = 50;
    protected int armDumpPosition1 = 800;
    protected int armDumpPosition2 = 900;
    protected int armDumpPosition3 = 1000;
    protected int[] armPosition = {armGrabPosition, armDumpPosition1, armDumpPosition2, armDumpPosition3};

    protected double wristGrabPosition = 0.0;
    protected double wristDumpPosition1 = 1.0;
    protected double wristDumpPosition2 = 1.1;
    protected double wristDumpPosition3 = 1.2;
    protected double[] wristPosition = {wristGrabPosition, wristDumpPosition1, wristDumpPosition2, wristDumpPosition3};


    public ClawArm(DcMotor aM, Servo cS, Servo wS) {
        armMotor = aM;
        clawServo = cS;
        wristServo = wS;
        //do I need to move anything on init?
    }

    public void controls(Gamepad gp) {
     /*   if(gp.x || gp.a || gp.y || gp.b || gp.right_bumper || gp.left_bumper || gp.right_trigger > 0.1 ||
        gp.left_trigger > 0.1 || gp.dpad_down || gp.dpad_left || gp.dpad_right || gp.dpad_up) {
            armMotor.setPower(1);
            clawServo.setPosition(0.5);
            wristServo.setPosition(0.25);
        }   //max.jpeg
      */

        if(gp.a && armValue <= 3) {
            dump();
        }

        if(gp.b && armValue >= 0) {
            grab();
        }
    }

    public void dump() {
        armValue++;
        armMotor.setTargetPosition(armPosition[armValue]);
        wristServo.setPosition(wristPosition[armValue]);
    }

    public void grab() {
        armValue--;
        armMotor.setTargetPosition(armPosition[armValue]);
        wristServo.setPosition(wristPosition[armValue]);
    }
}
