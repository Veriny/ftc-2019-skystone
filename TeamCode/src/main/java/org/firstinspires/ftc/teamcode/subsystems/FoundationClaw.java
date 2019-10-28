package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class FoundationClaw {
    public Servo servoA;
    public Servo servoB;
    public Gamepad gp;

    //servos in same orientation I think
    double pushPosition = 0.5;
    double restPosition = 0.0;

    public FoundationClaw(Servo a, Servo b) {
        this.servoA = a;
        this.servoB = b;
        servoA.setPosition(restPosition);
        servoB.setPosition(restPosition);
    }

    public void controls() {
        if(gp.dpad_up) {
            push();
        }

        else if(gp.dpad_down) {
            rest();
        }
    }

    public void push() {
        servoA.setPosition(pushPosition);
        servoA.setPosition(pushPosition);
    }

    public void rest() {
        servoA.setPosition(restPosition);
        servoA.setPosition(restPosition);
    }

}