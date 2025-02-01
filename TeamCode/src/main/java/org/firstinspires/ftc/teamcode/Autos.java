/*

package org.firstinspires.ftc.teamcode;


import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.oldRoadRunner.drive.SampleMecanumDrive;
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
                       // .lineToYSplineHeading(48,0.75)
                        .strafeTo(new Vector2d(56,55))

                        .build()

                );
    }

}
*/
