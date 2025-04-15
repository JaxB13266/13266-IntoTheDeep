package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.newRoadRunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Slides;
import org.firstinspires.ftc.teamcode.subsystems.Wrist;

@Config
@Autonomous
public class SampleAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(-18, 65, 300);


        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);


        Slides slide = new Slides(this);
        Claw claw = new Claw(this);
        Arm arm = new Arm(this);
        Wrist wrist = new Wrist(this);

        while (!opModeIsActive() && !isStopRequested()) {

            waitForStart();
            claw.setClawClosed();
            arm.setArmUp();
            wrist.setWristBack();

        if (opModeIsActive()) {
            slide.moveHighBasket();
            wrist.setWristForward();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .splineToLinearHeading(new Pose2d(60, 56,Math.toRadians(45)), Math.toRadians(35))
                            .build());
            sleep(1000);
            claw.setClawOpened();
            sleep(1000);
        }
        }
    }
}

