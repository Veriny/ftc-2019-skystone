package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;


@TeleOp(name = "TestOPMode", group = "jerW" )
public class teleOP extends OpMode {
    //TODO: Create instance variable for drivetrain
    public Drivetrain drivetrain;
    public ClawArm clawArm;

    @Override
    public void init() {
        //TODO: Initialize Drivetrain Object
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"));
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        //TODO: Controls
        drivetrain.controls(gamepad1);
        clawArm.controls(gamepad2);
    }

    @Override
    public void stop() {
        super.stop();
    }
}
