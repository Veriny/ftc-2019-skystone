package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

import java.sql.Driver;

@Autonomous(name="bruhchamp", group = "pepega")
public class AutoA extends LinearOpMode {
    public Drivetrain robot;
    public ClawArm clawArm;
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Drivetrain(hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"), true, telemetry);
        waitForStart();
        robot.drive(12, 1.0);
        robot.strafe(8, 1.0);
        robot.turn(45,0.75);
    }
}
