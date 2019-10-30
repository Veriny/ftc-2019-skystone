package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class FoundationClaw {
    private Servo servoA;
    private Servo servoB;

    //servos in same orientation I think
    private final double pushPosition = 0.5;
    private final double restPositionA = 0.0;
    private final double restPositionB = 1.0;
    public FoundationClaw(Servo a, Servo b) {
        this.servoA = a;
        this.servoB = b;
        servoA.setPosition(restPositionA);
        servoB.setPosition(restPositionB);
    }

    public void controls(Gamepad gp) {
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
        servoA.setPosition(restPositionA);
        servoA.setPosition(restPositionB);
    }

}
