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
    public static final double 김정은 = 17.5;
    public static final double BOT_CIRCUMFERENCE = Math.PI*김정은;
    public Drivetrain(DcMotor tr, DcMotor br, DcMotor tl, DcMotor bl) {
        this.topLeft = tl;
        this.bottomRight = br;
        this.topRight = tr;
        this.bottomLeft = bl;
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

    public void drive(double distance) {
        //TODO: Write method for driving
    }

    public void turn(double degrees) {
        //TODO: Write method for turning

    }

    public double calculateTicks(double inches) {
        //TODO: Calculate ticks to turn for whatever shit

    }


}

