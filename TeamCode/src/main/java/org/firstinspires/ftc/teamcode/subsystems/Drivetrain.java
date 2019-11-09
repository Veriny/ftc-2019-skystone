package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drivetrain {
    private DcMotor topRight;
    private DcMotor bottomRight;
    private DcMotor topLeft;
    private DcMotor bottomLeft;
    private Telemetry telemetry;
    private static final int TICKS_PER_ROTATION = 1440;
    private static final int WHEEL_DIAMETER = 4;
    private static final double BOT_DIAMETER = 17.5;
    private static final double BOT_CIRCUMFERENCE = Math.PI*BOT_DIAMETER;
    public Drivetrain(DcMotor tr, DcMotor br, DcMotor tl, DcMotor bl, Boolean isAuto, Telemetry t) {
        this.topLeft = tl;
        this.bottomRight = br;
        this.topRight = tr;
        this.bottomLeft = bl;
        this.telemetry = t;

        if(isAuto) {
            topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            bottomLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            bottomRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bottomLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bottomRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //topRight.setDirection(DcMotorSimple.Direction.REVERSE);
            //bottomRight.setDirection(DcMotorSimple.Direction.REVERSE);
            topLeft.setDirection(DcMotor.Direction.FORWARD);
            topRight.setDirection(DcMotor.Direction.REVERSE);
            bottomLeft.setDirection(DcMotor.Direction.FORWARD);
            bottomRight.setDirection(DcMotor.Direction.REVERSE);
        }

        else {
            /*topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            bottomLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            bottomRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bottomLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bottomRight.t.setMode(DcMotor.RunMode.RUN_USING_ENCODER); */
            //            topRighsetDirection(DcMotorSimple.Direction.REVERSE);
            //bottomRight.setDirection(DcMotorSimple.Direction.REVERSE);
            topLeft.setDirection(DcMotor.Direction.FORWARD);
            topRight.setDirection(DcMotor.Direction.REVERSE);
            bottomLeft.setDirection(DcMotor.Direction.FORWARD);
            bottomRight.setDirection(DcMotor.Direction.REVERSE);
        }
    }
    //김정은
    public void controls(Gamepad gp) {
        //TODO: Code Mecanum Bullshit
        float z = (float)(Math.pow(gp.left_stick_y, 3));
        float y = (float)(Math.pow(-gp.left_stick_x, 3));
        float x = (float)(Math.pow(gp.right_stick_x, 3));
        if (gp.left_trigger != 0) {
            x /=3;
            y /=3;
            z/= 3;
        }
        bottomLeft.setPower(-((x)+(y)+(-z)));
        topLeft.setPower(-((x)+(-y)+(-z)));
        bottomRight.setPower(-((-x)+(-y)+(-z)));
        topRight.setPower(-((-x)+(y)+(-z)));
    }

    public void drive(double distance, double power) {
        //TODO: Write method for driving
        //This code is written such that forward is positive.
        double position  = calculateTicks(distance);
        telemetry.addLine("Moved with position ticks: " + position);
        motorDrive(bottomLeft, position, -power);
        motorDrive(bottomRight, position, -power);
        motorDrive(topLeft, position, -power);
        motorDrive(topRight, position, -power);
        jigglypuff();
        resetEncoders();
    }

    public void strafe(double distance, double power) {
        //TODO: Write code for strafing
        //This code is written such that right is positive.
        double position  = calculateTicks(distance);
        telemetry.addLine("Moved with position ticks: " + position);
        motorDrive(bottomLeft, position, power);
        motorDrive(bottomRight, position, -power);
        motorDrive(topLeft, position, -power);
        motorDrive(topRight, position, power);
        jigglypuff();
        resetEncoders();
    }

    public void turn(double degrees, double power) {
        //TODO: Write method for turning
        double rotations = degrees / 360 / 2.67;
        double position = calculateTicksRot(rotations * BOT_CIRCUMFERENCE);
        motorDrive(bottomLeft, position, -power);
        motorDrive(bottomRight, position, power);
        motorDrive(topLeft, position, -power);
        motorDrive(topRight, position, power);
        jigglypuff();
        resetEncoders();
        telemetry.addLine("Moved with position ticks: " + position);
    }

    private void motorDrive(DcMotor motor, double ticks, double power) {
        //TODO: MotorDrive
        motor.setTargetPosition((int) ticks);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(power);
    }

    private void intakeMotors(DcMotor motor, double power) {
        motor.setPower(power);
    }

    private double calculateTicksRot(double inches) {
        return (inches / WHEEL_DIAMETER) * TICKS_PER_ROTATION;
    }

    private double calculateTicks(double inches) {
        return (inches / (WHEEL_DIAMETER * Math.PI) * TICKS_PER_ROTATION);
    }

    private void jigglypuff() {
        while (topRight.isBusy() || topLeft.isBusy() || bottomLeft.isBusy() || bottomRight.isBusy()) {
            //do nothing
        }
        //I'm not sure if it's good practice to reset encoders every time we move - this may slow things down and we may have to change this in order to squeeze a few extra seconds out of auto in the future

    }

    public void update() {
        telemetry.addData("BL: ", bottomLeft.getCurrentPosition());
        telemetry.addData("TL: " , topLeft.getCurrentPosition());
        telemetry.addData("BR: " , bottomRight.getCurrentPosition());
        telemetry.addData("TR: " , topRight.getCurrentPosition());
        telemetry.update();
    }

    public void resetEncoders(){
        bottomRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }



}

