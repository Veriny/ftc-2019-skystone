package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.FoundationClaw;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@Autonomous(name="Blue(Buildside)_Collect_Deposit_FoundationDrag_Park", group = "pepega")
public class AutoC extends LinearOpMode {
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


        //done with collection
        robot.strafe(12, 0.7);
        //robot.turn(-3,0.7);
        clawArm.armFlick();
        robot.residentSleeper(400);
        clawArm.wrist1();
        robot.residentSleeper(400);
        clawArm.armGrab();
        robot.drive(-28,0.8);
        robot.turn(-90,0.8);
        clawArm.hold();
        robot.drive(-12,0.5);



        //drags foundation
        robot.drive(-1,0.4);
        robot.drive(30,1);
        foundationClaw.rest();
        //robot.drive(-0.5,0.4);

        //parks
        robot.strafe(24,1);
        robot.residentSleeper(250);
        robot.drive(-16,0.9);
        robot.strafe(-8,0.8);
        robot.drive(-4,1.0);
        robot.residentSleeper(250);
        robot.strafe(18,1.0);
    }
}
