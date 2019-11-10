package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.FoundationClaw;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

import java.sql.Driver;

@Autonomous(name="Red(Stoneside)_Collect_Deposit_FoundationDrag_Park", group = "pepega")
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
        robot.update();
        robot.strafe(16,0.7);
        robot.residentSleeper(125);
        robot.drive(-10,0.8);
        robot.residentSleeper(125);
        robot.strafe(15,0.8);
        robot.update();

        //start to collect stone
        clawArm.release();
        clawArm.armUp();
        intake.autoIntake();
        robot.drive(6, 0.5);
        intake.stop();
        robot.residentSleeper(500);
        intake.stop();
        clawArm.armGrab();

        //done with collection
        robot.strafe(-12.5, 0.7);
        //robot.turn(-3,0.7);
        clawArm.armFlick();
        robot.residentSleeper(400);
        clawArm.wrist1();
        robot.residentSleeper(400);
        clawArm.armGrab();
        robot.drive(-62,0.8);
        robot.turn(-90,0.8);
        clawArm.hold();
        robot.drive(-8,0.5);

        //start to deposit
        clawArm.armDump1();
        robot.residentSleeper(600);
        clawArm.armDump3();
        robot.residentSleeper(600);
        foundationClaw.push();
        clawArm.release();  //dumps here
        robot.residentSleeper(200);
        clawArm.armDump1();
        robot.residentSleeper(250);
        clawArm.armGrab();

        //drags foundation
        robot.drive(-1,0.4);
        robot.drive(31,1);
        foundationClaw.rest();
        //robot.drive(-0.5,0.4);

        //parks
        robot.strafe(25,1);
        robot.residentSleeper(250);
        robot.drive(-16,0.9);
        robot.strafe(-8,0.8);
        robot.drive(-4,1.0);
        robot.residentSleeper(250);
        robot.strafe(20,1.0);
    }
}
