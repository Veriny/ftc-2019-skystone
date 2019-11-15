package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class FoundationClaw {
    private Servo servoA;
    private Servo servoB;

    //servos in same orientation I think
    private final double pushPositionA = 0.63;
    private final double pushPositionB = 0.45;
    private final double restPositionA = 0.08;
    private final double restPositionB = 1.0;
    public FoundationClaw(Servo a, Servo b) {
        this.servoA = a;
        this.servoB = b;
        servoA.setPosition(restPositionA);
        servoB.setPosition(restPositionB);
    }

    public void controls(Gamepad gp) {
        if(gp.a) {
            push();
        }

        else if(gp.b) {
            rest();
        }
    }

    public void push() {
        servoA.setPosition(pushPositionA);
        servoB.setPosition(pushPositionB);
    }

    public void rest() {
        servoA.setPosition(restPositionA);
        servoB.setPosition(restPositionB);
    }

}
