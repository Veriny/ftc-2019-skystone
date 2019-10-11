package org.firstinspires.ftc.teamcode.prototypes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Intake {
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public Intake(DcMotor lM, DcMotor rM) {
        this.leftMotor = lM;
        this.rightMotor = rM;
    }

    public void controls(Gamepad gp) {
        if(gp.left_bumper) {
            intake();
        }
        if(gp.right_bumper) {
            outturn();
        }
    }

    public void intake() {
        leftMotor.setPower(1.0);
        rightMotor.setPower(-1.0);
    }

    public void outturn() {
        leftMotor.setPower(-1.0);
        rightMotor.setPower(1.0);
    }
}
