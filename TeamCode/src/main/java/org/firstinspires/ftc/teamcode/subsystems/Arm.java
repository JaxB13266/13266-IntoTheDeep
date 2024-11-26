
package org.firstinspires.ftc.teamcode.subsystems;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    public  Servo armLeftServo;
    public  Servo armRightServo;

    public  Gamepad driver2;
    public HardwareMap hardwareMap;


    public final double scorePosition = .3;
    public double intakePosition = 0;
    public double rest = 0;

    public Arm(OpMode opMode) {
        driver2 = opMode.gamepad2;
        hardwareMap = opMode.hardwareMap;

        armLeftServo = opMode.hardwareMap.get(Servo.class, "armLeftServo");
        armRightServo = opMode.hardwareMap.get(Servo.class, "armRightServo");

        armLeftServo.setDirection(Servo.Direction.REVERSE);
        armRightServo.setDirection(Servo.Direction.FORWARD);
        //what happens on init
        rightServo(rest);
    }

    public  void armTeleOp() {
        if (driver2.dpad_down) {
            rightServo(intakePosition);
            leftServo(intakePosition);
        }
        if (driver2.dpad_right) {
            leftServo(scorePosition);
            rightServo(scorePosition);
        }
        //if statements


    }
    public void rightServo(double position) {
        armRightServo.setPosition(position);
    }
    public void leftServo(double position) {
        armLeftServo.setPosition(position);
    }



}

