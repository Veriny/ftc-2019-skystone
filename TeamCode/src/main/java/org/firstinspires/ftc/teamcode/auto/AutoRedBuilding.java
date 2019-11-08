package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.FoundationClaw;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@Autonomous(name="AutoRedBuilding", group = "pepega")
public class AutoRedBuilding extends LinearOpMode {
    public Drivetrain robot;
    public ClawArm clawArm;
    public Intake intake;
    public FoundationClaw foundationClaw;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Drivetrain(hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"), true, telemetry);
        intake = new Intake(hardwareMap.dcMotor.get("leftIntake"), hardwareMap.dcMotor.get("rightIntake"));
        clawArm = new ClawArm(hardwareMap.dcMotor.get("armMotor"), hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));
        foundationClaw = new FoundationClaw(hardwareMap.servo.get("leftFoundationServo"), hardwareMap.servo.get("rightFoundationServo"));

        waitForStart();
        //robot.drive(-12, 0.8);
        robot.strafe(24, 0.8);
        clawArm.armUp();
        intake.intake();
        robot.drive(12, 0.33);
        intake.stop();
        clawArm.armGrab();
        clawArm.hold();
        robot.strafe(-18, 0.8);
        robot.drive(-72,0.8);
        robot.turn(-90,0.8);
        robot.drive(-12,0.8);
        foundationClaw.push();
        robot.drive(24,0.3);
        foundationClaw.rest();
        robot.strafe(20,0.8);
        robot.drive(-10,0.8);
        robot.strafe(16,0.8);
    }
}
