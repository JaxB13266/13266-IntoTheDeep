
package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class    Claw {
    public Servo claw;
    public final Gamepad gamepad2;
    public HardwareMap hardwareMap;
    public final double OPENED = 0.45;
    public final double CLOSED = 0.57;
    public Claw(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.gamepad2 = opMode.gamepad2;

        claw = (Servo) hardwareMap.get("clawServo");

        claw.setDirection(Servo.Direction.REVERSE);
        clawS(OPENED);
    }
    public void clawTeleOp() {
        if (gamepad2.left_trigger>0.1) clawS(OPENED);
        else if (gamepad2.right_trigger>0.1) clawS(CLOSED);
    }
    public void clawS(double position) {
        claw.setPosition(position);
    }
}
