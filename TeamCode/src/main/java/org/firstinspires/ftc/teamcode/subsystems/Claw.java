
package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class    Claw {
    public Servo claw;
    public final Gamepad gamepad2;
    public HardwareMap hardwareMap;
    public Telemetry telemetry;
    public final double OPENED = 0.6;
    public final double CLOSED = 0.2;
    public Claw(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.gamepad2 = opMode.gamepad2;
        this.telemetry = opMode.telemetry;
        claw = (Servo) hardwareMap.get("clawServo");

        claw.setDirection(Servo.Direction.FORWARD);
        claw.setPosition(CLOSED);
    }
    public void clawTeleOp() {
        if (gamepad2.left_trigger>0.1) clawS(OPENED);
        else if (gamepad2.right_trigger>0.1) clawS(CLOSED);
    }
    public void clawSoloTeleOp() {
        if (gamepad2.left_trigger>0.1) clawS(CLOSED);
        else if (gamepad2.right_trigger>0.1) clawS(OPENED);
    }
    public void clawS(double position) {
        claw.setPosition(position);
    }
}
