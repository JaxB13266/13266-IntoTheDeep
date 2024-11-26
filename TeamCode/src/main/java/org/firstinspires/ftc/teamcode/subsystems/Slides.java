package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Slides {

    public static double POWER = .7;
    public static int HighBasket =1750;
    public static int SpecimenIntake = 100;
    public static int HighRung = 700;
    public static int RESET = 0;
    public static int MANUAL_MOVE_SPEED = 10;
    private int position = 0;

    public final DcMotor leftSlide;
    public final DcMotor rightSLide;

    private final HardwareMap hardwareMap;
    private final Gamepad Driver2;
    public final Telemetry telemetry;

    public Slides(OpMode opMode) {
        Driver2 = opMode.gamepad2;
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;

        leftSlide = hardwareMap.get(DcMotor.class,"leftSlide");
        leftSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        leftSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightSLide = hardwareMap.get(DcMotor.class, "rightSlide");
        rightSLide.setDirection(DcMotorSimple.Direction.REVERSE);
        rightSLide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSLide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftSlide.setTargetPosition(0);
        rightSLide.setTargetPosition(0);

        leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightSLide.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

    public void slidesTeleOp(){
        if (Driver2.a) moveLowBasket();
        if (Driver2.b) moveHighRung();
        if (Driver2.x) moveHighBasket();


        // Add telemetry data
        telemetry.addData("Slide Position", leftSlide.getCurrentPosition());
        //Telemetry provide a means by which data can be transmitted from the robot controller
        // to the driver station and displayed on the driver station screen

        // Update the telemetry to reflect the changes on the Driver Hub
        telemetry.update();
    }


    public void moveHighBasket(){
        leftSlide.setPower(POWER);
        leftSlide.setTargetPosition(HighBasket);

        rightSLide.setPower(POWER);
        rightSLide.setTargetPosition(HighBasket);
    }
    public void moveLowBasket() {
        leftSlide.setPower(POWER);
        leftSlide.setTargetPosition(SpecimenIntake);

        rightSLide.setPower(POWER);
        rightSLide.setTargetPosition(SpecimenIntake);

    }
    public void moveHighRung() {
        leftSlide.setPower(POWER);
        leftSlide.setTargetPosition(HighRung);

        rightSLide.setPower(POWER);
        rightSLide.setTargetPosition(HighRung);

    }
    public void Reset(){
        leftSlide.setPower(POWER);
        leftSlide.setTargetPosition(RESET);

        rightSLide.setPower(POWER);
        rightSLide.setTargetPosition(RESET);
    }
    public void moveMotors(int position){
        this.position = position;
        leftSlide.setTargetPosition(position);
        rightSLide.setTargetPosition(position);
        leftSlide.setPower(POWER);
        rightSLide.setPower(POWER);

    }

}