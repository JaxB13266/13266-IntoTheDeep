
package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist {
    public Servo wristServo;
    public Servo turnWristServo;
    public Gamepad driver2;
    public Gamepad driver1;
    public HardwareMap hardwareMap;
    public Telemetry telemetry;


    public final double Score = 0.1;
    public final double Intake = 0.7;
    public final double turnRight = .3;
    public final double turnLeft = .1;


    public Wrist(OpMode opMode) {
        driver2 = opMode.gamepad2;
        driver1 = opMode.gamepad1;
        hardwareMap = opMode.hardwareMap;

        wristServo = opMode.hardwareMap.get(Servo.class, "wristServo");
        turnWristServo = opMode.hardwareMap.get(Servo.class,"turnServo");

        wristServo.setDirection(Servo.Direction.FORWARD);
        turnWristServo.setDirection(Servo.Direction.FORWARD);

        wristS(Intake);

    }

    public void wristSoloTeleOp() {
        if (driver1.b) wristS(Score);
        if (driver1.y) wristS(Intake);
    }

    public void wristTeleOp(){
        if (driver2.left_bumper) wristS(Intake);
        else if (driver2.right_bumper) wristS(Score);
        if (driver2.b) turnS(turnLeft);
        else if (driver2.y) turnS(turnRight);

    }
    public void wristS(double rest){wristServo.setPosition(rest);}
    public void turnS (double rest){turnWristServo.setPosition(rest);}

}


