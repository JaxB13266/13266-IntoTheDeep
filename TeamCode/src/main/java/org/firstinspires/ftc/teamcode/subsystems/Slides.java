package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Slides {

    public static double POWER = .4;
    public static int HIGH = 3000;
    public static int MID = 1550;
    public static int DOWN = 0;

    public final DcMotor leftSlide;
    public final DcMotor rightSLide;

    public final HardwareMap hardwareMap;
    public final Gamepad Driver2;
    public final Gamepad Driver1;
    public final Telemetry telemetry;

    public Slides(OpMode opMode) {
        Driver2 = opMode.gamepad2;
        Driver1 = opMode.gamepad1;
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;

        leftSlide = hardwareMap.get(DcMotor.class, "leftSlide");
        leftSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        leftSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightSLide = hardwareMap.get(DcMotor.class, "rightSlide");
        rightSLide.setDirection(DcMotorSimple.Direction.FORWARD);
        rightSLide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSLide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftSlide.setTargetPosition(0);
        rightSLide.setTargetPosition(0);

        leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightSLide.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

    public void slidesTeleOp() {
        if (Driver2.a) moveLow();
        if (Driver2.x) moveMidBasket();
        if (Driver2.y) moveHighBasket();


        // Add telemetry data
        telemetry.addData("Slide Position", leftSlide.getCurrentPosition());
        //Telemetry provide a means by which data can be transmitted from the robot controller
        // to the driver station and displayed on the driver station screen

        // Update the telemetry to reflect the changes on the Driver Hub
        telemetry.update();
    }

    public void slidesSoloTeleOp() {
        if (Driver1.dpad_up) moveHighBasket();
        if (Driver1.dpad_down) moveLow();




        // Add telemetry data
        telemetry.addData("Slide Position", leftSlide.getCurrentPosition());
        //Telemetry provide a means by which data can be transmitted from the robot controller
        // to the driver station and displayed on the driver station screen

        // Update the telemetry to reflect the changes on the Driver Hub
        telemetry.update();
    }

    public void moveMidBasket() {
        leftSlide.setPower(POWER);
        leftSlide.setTargetPosition(MID);

        rightSLide.setPower(POWER);
        rightSLide.setTargetPosition(MID);
    }

    public void moveLow() {
        leftSlide.setPower(POWER);
        leftSlide.setTargetPosition(DOWN);

        rightSLide.setPower(POWER);
        rightSLide.setTargetPosition(DOWN);

    }
    public void moveHighBasket(){
        leftSlide.setPower(POWER);
        leftSlide.setTargetPosition(HIGH);

        rightSLide.setPower(POWER);
        rightSLide.setTargetPosition(HIGH);
    }
}