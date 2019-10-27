package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;


@TeleOp(name = "TestOPMode", group = "jerW" )
public class teleOP extends OpMode {
    //TODO: Create instance variable for drivetrain
    public Drivetrain drivetrain;
    public ClawArm clawArm;
    public Intake intake;
    @Override
    public void init() {
        //TODO: Initialize Drivetrain Object
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"), false);
        clawArm = new ClawArm(hardwareMap.dcMotor.get("armMotor"), hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));// hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));
        intake = new Intake(hardwareMap.dcMotor.get("leftIntake"), hardwareMap.dcMotor.get("rightIntake"));
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        //TODO: Controls
        drivetrain.controls(gamepad1);
        clawArm.controls(gamepad1, telemetry);
        intake.controls(gamepad1);

    }

    @Override
    public void stop() {
        super.stop();
    }
}
