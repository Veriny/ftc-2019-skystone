package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.prototypes.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;


@TeleOp(name = "TestOPMode", group = "jerW" )
public class teleOP extends OpMode {
    //TODO: Create instance variable for drivetrain
    public Drivetrain drivetrain;
    public ClawArm clawArm;

    @Override
    public void init() {
        //TODO: Initialize Drivetrain Object
        //drivetrain = new Drivetrain(hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"));
        clawArm = new ClawArm(hardwareMap.dcMotor.get("armMotor"), hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));// hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        //TODO: Controls
        //drivetrain.controls(gamepad1);
        clawArm.controls(gamepad1, telemetry);

    }

    @Override
    public void stop() {
        super.stop();
    }
}
