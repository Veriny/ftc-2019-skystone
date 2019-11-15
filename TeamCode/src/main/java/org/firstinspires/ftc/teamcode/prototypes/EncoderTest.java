package org.firstinspires.ftc.teamcode.prototypes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
@Disabled
@Autonomous(name = "͕PE̸̯͍̲̹̳̤P͟E҉̺̙G͟Ḁ", group = "tests")
public class EncoderTest extends LinearOpMode {
    //public Drivetrain robot;
    public DcMotor motor;
    @Override
    public void runOpMode() throws InterruptedException {
        //robot = new Drivetrain(hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"), true);
        motor = hardwareMap.dcMotor.get("motor");
        waitForStart();
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(168000);
        motor.setPower(1);
        while (motor.isBusy()) {


        }
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //robot.drive(10, 1);
    }
}
