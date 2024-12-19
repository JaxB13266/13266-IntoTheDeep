
package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Slides;

@Autonomous

public class Autos extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{
        SampleMecanumDrive sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        Slides slides = new Slides(this );
        Arm arm = new Arm(this);
        waitForStart();
        if (isStopRequested()) return;
        sampleMecanumDrive.followTrajectory(
                sampleMecanumDrive.trajectoryBuilder(new Pose2d())
                        //.forward(3)

                        .build()

                );
        slides.moveMidBasket();


    }

}
