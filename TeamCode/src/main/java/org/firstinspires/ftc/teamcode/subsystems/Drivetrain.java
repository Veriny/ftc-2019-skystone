package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
public class Drivetrain {
    private DcMotor topRight;
    private DcMotor bottomRight;
    private DcMotor topLeft;
    private DcMotor bottomLeft;
    public static final int TICKS_PER_ROTATION = 1440;
    public static final int WHEEL_DIAMETER = 4;
    public static final double BOT_DIAMETER = 17.5;
    public static final double BOT_CIRCUMFERENCE = Math.PI*BOT_DIAMETER;
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

        }
    }
    //김정은
    public void controls(Gamepad gp) {
        //TODO: Code Mecanum Bullshit
        float x = (float)(Math.pow(gp.left_stick_y, 3));
        float y = (float)(Math.pow(gp.left_stick_x, 3));
        float z = (float)(Math.pow(gp.right_stick_x, 3));
        bottomLeft.setPower((x)+(y)+(-z));
        topLeft.setPower((x)+(-y)+(-z));
        bottomRight.setPower((-x)+(y)+(-z));
        topRight.setPower((-x)+(-y)+(-z));
    }

    public void drive(double distance, double power) {
        //TODO: Write method for driving
        double position  = calculateTicks(distance);
        motorDrive(bottomLeft, position, power);
        motorDrive(bottomRight, position, -power);
        motorDrive(topLeft, position, power);
        motorDrive(topRight, position, -power);


    }

    public void strafe(double distance) {
        //TODO: Write code for strafing

    }

    public void turn(double degrees) {
        //TODO: Write method for turning

    }

    public void motorDrive(DcMotor motor, double ticks, double power) {
        //TODO: MotorDrive
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition((int) ticks);
        motor.setPower(power);
    }

    public double calculateTicks(double inches) {
        return (inches / WHEEL_DIAMETER) * TICKS_PER_ROTATION;

    }

}

