
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


    public final double Score = .7;
    public final double Intake = -.3;
    public final double turnRight = -.4;
    public final double turnLeft = -.3;



    public Wrist(OpMode opMode) {
        driver2 = opMode.gamepad2;
        driver1 = opMode.gamepad1;
        hardwareMap = opMode.hardwareMap;

        wristServo = opMode.hardwareMap.get(Servo.class, "wristServo");
        turnWristServo = opMode.hardwareMap.get(Servo.class,"turnServo");

        wristServo.setDirection(Servo.Direction.FORWARD);
        turnWristServo.setDirection(Servo.Direction.FORWARD);

        wristS(0);
        turnS(.1);

    }

    public void wristSoloTeleOp() {
        if (driver1.b) wristS(Score);
        if (driver1.y) wristS(Intake);
    }

    public void wristTeleOp(){
        if (driver2.left_bumper) wristS(0);
        else if (driver2.right_bumper) wristS(Score);
        if (driver2.dpad_up) turnS(.4);
       // else if (driver2.dpad_left) turnS(-1);
        if (driver2.b) turnS(.1);

    }
    public void wristS(double rest){wristServo.setPosition(rest);}
    public void turnS (double rest){turnWristServo.setPosition(rest);}

}


