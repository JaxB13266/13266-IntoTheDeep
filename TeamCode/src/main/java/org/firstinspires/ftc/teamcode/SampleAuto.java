package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.newRoadRunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Slides;

@Autonomous
public class SampleAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
            Slides slide= new Slides(this);
        Pose2d beginPose = new Pose2d(-18, 65, 300);
        MecanumDrive drive= new MecanumDrive(hardwareMap, beginPose);
            waitForStart();
                slide.moveHighBasket();
    }
}

