package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.FoundationClaw;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

import java.sql.Driver;

@Autonomous(name="bruhchamp", group = "pepega")
public class AutoA extends LinearOpMode {
    public Drivetrain robot;
    public ClawArm clawArm;
    public Intake intake;
    public FoundationClaw foundationClaw;
    private ElapsedTime time;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Drivetrain(hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"), hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), true, telemetry);
        clawArm = new ClawArm(hardwareMap.dcMotor.get("armMotor"), hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));// hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));
        intake = new Intake(hardwareMap.dcMotor.get("leftIntake"), hardwareMap.dcMotor.get("rightIntake"));
        foundationClaw = new FoundationClaw(hardwareMap.servo.get("leftFoundationServo"), hardwareMap.servo.get("rightFoundationServo"));
        time = new ElapsedTime();

        waitForStart();
        //robot.drive(-12, 0.8);
        robot.update();
        //robot.strafe(24, 0.8);

        robot.strafe(16,0.8);
        time.reset();
        while(time.milliseconds() < 250) {
        }

        robot.drive(-10,0.8);
        time.reset();
        while(time.milliseconds() < 250) {
        }

        robot.strafe(14,0.8);
        robot.update();
        clawArm.release();
        clawArm.armUp();
        intake.autoIntake();
        robot.drive(6, 0.3);
        intake.stop();
        time.reset();
        while(time.milliseconds() < 750) {
        }
        intake.stop();

        clawArm.armGrab();
        robot.strafe(-18, 0.8);
        clawArm.wrist1();
        time.reset();
        while(time.milliseconds() < 500) {
        }
        clawArm.wrist0();

        robot.drive(-60,1.0);
        robot.turn(-90,0.8);
        clawArm.hold();
        robot.drive(-15,0.5);

        time.reset();
        while(time.milliseconds() < 500) {
        }

        clawArm.armDump1();
        time.reset();
        while(time.milliseconds() < 750) {
        }

        clawArm.armDump3();
        time.reset();
        while(time.milliseconds() < 500) {
        }

        foundationClaw.push();

        clawArm.release();
        time.reset();
        while(time.milliseconds() < 250) {
        }
        clawArm.armDump1();
        time.reset();
        while(time.milliseconds() < 250) {
        }
        clawArm.armGrab();
        robot.drive(-1,0.4);

        robot.drive(26,0.35);
        foundationClaw.rest();
        robot.strafe(22,0.8);
        time.reset();
        while(time.milliseconds() < 250) {
        }

        robot.drive(-14,0.8);
        time.reset();
        while(time.milliseconds() < 250) {
        }
        robot.strafe(14,0.8);
    }
}
