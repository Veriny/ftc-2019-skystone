package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
public class Drivetrain {
    public DcMotor topRight;
    public DcMotor bottomRight;
    public DcMotor topLeft;
    public DcMotor bottomLeft;
    public Drivetrain(DcMotor tr, DcMotor br, DcMotor tl, DcMotor bl) {
        this.topLeft = tl;
        this.bottomRight = br;
        this.topRight = tr;
        this.bottomLeft = bl;
    }

    public void controls(Gamepad gp) {
        
    }

}
