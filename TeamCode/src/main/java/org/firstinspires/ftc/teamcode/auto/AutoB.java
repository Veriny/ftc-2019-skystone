package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.FoundationClaw;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@Autonomous(name = "owo", group = "pepegahands")
public class AutoB extends LinearOpMode {
    public Drivetrain robot;
    public ClawArm clawArm;
    public Intake intake;
    public FoundationClaw foundationClaw;
    private ElapsedTime time;
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Drivetrain(hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"), true, telemetry);
        clawArm = new ClawArm(hardwareMap.dcMotor.get("armMotor"), hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));// hardwareMap.servo.get("clawServo"), hardwareMap.servo.get("wristServo"));
        intake = new Intake(hardwareMap.dcMotor.get("leftIntake"), hardwareMap.dcMotor.get("rightIntake"));
        foundationClaw = new FoundationClaw(hardwareMap.servo.get("leftFoundationServo"), hardwareMap.servo.get("rightFoundationServo"));
        time = new ElapsedTime();

        waitForStart();
        robot.update();
        robot.strafe(16,0.8);
        time.reset();
        while(time.milliseconds() < 250) {
        }
        //robot.drive(-10,0.8);
        robot.drive(4,0.8);
        time.reset();
        while(time.milliseconds() < 250) {
        }
        robot.strafe(14,0.8);
        robot.update();

        //start to collect stone
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

        //done with collection
        robot.strafe(-12, 0.8);
        clawArm.wrist1();
        time.reset();
        while(time.milliseconds() < 500) {
        }
        clawArm.wrist0();
        robot.drive(-58,1.0);
        robot.turn(-90,0.8);
        clawArm.hold();
        robot.drive(-8,0.5);

        //start to deposit
        time.reset();
        while(time.milliseconds() < 500) {
        }
        clawArm.armDump1();
        time.reset();
        while(time.milliseconds() < 600) {
        }
        clawArm.armDump3();
        time.reset();
        while(time.milliseconds() < 500) {
        }
        foundationClaw.push();
        clawArm.release();  //dumps here
        time.reset();
        while(time.milliseconds() < 250) {
        }
        clawArm.armDump1();
        time.reset();
        while(time.milliseconds() < 250) {
        }
        clawArm.armGrab();

        //drags foundation
        robot.drive(-1,0.4);
        robot.drive(26,0.35);
        foundationClaw.rest();

        //parks
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
