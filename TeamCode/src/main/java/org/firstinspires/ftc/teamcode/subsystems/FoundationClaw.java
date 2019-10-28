package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class FoundationClaw {
    public Servo servoA;
    public Servo servoB;
    public FoundationClaw(Servo a, Servo b) {
        this.servoA = a;
        this.servoB = b;
    }


}
