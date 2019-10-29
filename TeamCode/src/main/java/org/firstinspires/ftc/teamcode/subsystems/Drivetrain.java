package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
public class Drivetrain {
    private DcMotor topRight;
    private DcMotor bottomRight;
    private DcMotor topLeft;
    private DcMotor bottomLeft;
    private static final int TICKS_PER_ROTATION = 1440;
    private static final int WHEEL_DIAMETER = 4;
    private static final double BOT_DIAMETER = 17.5;
    private static final double BOT_CIRCUMFERENCE = Math.PI*BOT_DIAMETER;
    public Drivetrain(DcMotor tr, DcMotor br, DcMotor tl, DcMotor bl, Boolean isAuto) {
        this.topLeft = tl;
        this.bottomRight = br;
        this.topRight = tr;
        this.bottomLeft = bl;

        if(isAuto) {
            topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bottomLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bottomRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            topRight.setDirection(DcMotorSimple.Direction.REVERSE);
            bottomRight.setDirection(DcMotorSimple.Direction.REVERSE);

        }
    }
    //김정은
    public void controls(Gamepad gp) {
        //TODO: Code Mecanum Bullshit
        float x = (float)(Math.pow(-gp.left_stick_y, 3));
        float y = (float)(Math.pow(gp.left_stick_x, 3));
        float z = (float)(Math.pow(gp.right_stick_x, 3));
        bottomLeft.setPower((x)+(y)+(-z));
        topLeft.setPower((x)+(-y)+(-z));
        bottomRight.setPower((-x)+(y)+(-z));
        topRight.setPower((-x)+(-y)+(-z));
    }

    public void drive(double distance, double power) {
        //TODO: Write method for driving
        //This code is written such that forward is positive.
        double position  = calculateTicks(distance);
        motorDrive(bottomLeft, position, power);
        motorDrive(bottomRight, position, power);
        motorDrive(topLeft, position, power);
        motorDrive(topRight, position, power);
        jigglypuff();


    }

    public void strafe(double distance, double power) {
        //TODO: Write code for strafing
        //This code is written such that right is positive.
        double position  = calculateTicks(distance);
        motorDrive(bottomLeft, position, -power);
        motorDrive(bottomRight, position, power);
        motorDrive(topLeft, position, power);
        motorDrive(topRight, position, -power);
        jigglypuff();
    }

    public void turn(double degrees, double power) {
        //TODO: Write method for turning
        double rotations = degrees / 360;
        double position = calculateTicksRot(rotations * BOT_CIRCUMFERENCE);
        motorDrive(bottomLeft, position, -power);
        motorDrive(bottomRight, position, -power);
        motorDrive(topLeft, position, -power);
        motorDrive(topRight, position, -power);
        jigglypuff();
    }

    private void motorDrive(DcMotor motor, double ticks, double power) {
        //TODO: MotorDrive
        motor.setTargetPosition((int) ticks);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(power);
    }

    private double calculateTicksRot(double inches) {
        return (inches / WHEEL_DIAMETER) * TICKS_PER_ROTATION * Math.sqrt(2);
    }

    private double calculateTicks(double inches) {
        return (inches / (WHEEL_DIAMETER * Math.PI) * TICKS_PER_ROTATION * Math.sqrt(2));
    }

    private void jigglypuff() {
        while (bottomLeft.isBusy() || topLeft.isBusy() || bottomRight.isBusy() || topRight.isBusy()) {
            //do nothing
        }
        //I'm not sure if it's good practice to reset encoders every time we move - this may slow things down and we may have to change this in order to squeeze a few extra seconds out of auto in the future
        bottomRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


}

