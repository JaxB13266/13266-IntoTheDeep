
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
    public Gamepad driver1;
    public HardwareMap hardwareMap;


    public final double scorePosition = 0;
    public double intakePosition = .39;
    public double rest = 0;

    public Arm(OpMode opMode) {
        driver2 = opMode.gamepad2;
        driver1 = opMode.gamepad1;
        hardwareMap = opMode.hardwareMap;

        armLeftServo = opMode.hardwareMap.get(Servo.class, "armLeftServo");
        armRightServo = opMode.hardwareMap.get(Servo.class, "armRightServo");

        armLeftServo.setDirection(Servo.Direction.FORWARD);
        armRightServo.setDirection(Servo.Direction.REVERSE);

        //what happens on init
        rightServo(rest);
        leftServo(rest);
    }

    public  void armTeleOp() {
        if (driver2.dpad_down) {
            rightServo(intakePosition);
            leftServo(intakePosition);
        } else if (driver2.dpad_up) {
            leftServo(scorePosition);
            rightServo(scorePosition);
        }

    }
    public void rightServo(double position) {
        armRightServo.setPosition(position);
    }
    public void leftServo(double position) {
        armLeftServo.setPosition(position);
    }


    public void armSoloTeleOP() {
        if (driver1.a){
            rightServo(intakePosition);
            leftServo(intakePosition);
        }
        if (driver1.x){
            rightServo(scorePosition);
            leftServo(scorePosition);
        }
    }
    public void setArmUp(){
        armLeftServo.setPosition(scorePosition);
        armRightServo.setPosition(scorePosition);
    }
    public void setArmDown(){
        armRightServo.setPosition(intakePosition);
        armLeftServo.setPosition(intakePosition);
    }
}