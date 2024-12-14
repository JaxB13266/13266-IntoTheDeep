
package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist {
    public Servo wristServo;
    public Gamepad driver2;
    public HardwareMap hardwareMap;
    public Telemetry telemetry;


    public final double Score = 0.1;
    public final double Intake = 0.7;
    public final double rest = 0;


    public Wrist(OpMode opMode) {
        driver2 = opMode.gamepad2;
        hardwareMap = opMode.hardwareMap;

        wristServo = opMode.hardwareMap.get(Servo.class, "wristServo");

        wristServo.setDirection(Servo.Direction.FORWARD);

        wristS(rest);
    }

    public void wristSoloTeleOp() {
        if (driver2.b) wristS(Score);
        if (driver2.y) wristS(Intake);
    }

    public void wristTeleOp(){
        if (driver2.left_bumper) wristS(Intake);
        else if (driver2.right_bumper) wristS(Score);
    }
    public void wristS(double rest){wristServo.setPosition(rest);}
}


