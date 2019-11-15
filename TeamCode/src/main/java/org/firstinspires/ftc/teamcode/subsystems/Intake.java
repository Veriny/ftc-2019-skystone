package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Intake {
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public Intake(DcMotor lM, DcMotor rM) {
        this.leftMotor = lM;
        this.rightMotor = rM;

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void controls(Gamepad gp) {
        if(gp.left_bumper && !gp.right_bumper) {
            intake();
        }
        else if(gp.right_bumper && !gp.left_bumper) {
            outtake();
        }
        else {
            stop();
        }
    }

    public void autoIntake() {
        leftMotor.setPower(-0.8);
        rightMotor.setPower(0.8);
    }

    public void intake() {
        leftMotor.setPower(0.8);
        rightMotor.setPower(-0.8);
    }

    public void outtake() {
        leftMotor.setPower(-0.8);
        rightMotor.setPower(0.8);
    }

    public void stop() {
        leftMotor.setPower(0.0);
        rightMotor.setPower(0.0);
    }
}
