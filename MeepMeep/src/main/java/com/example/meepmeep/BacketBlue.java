package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


public class BacketBlue {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(12,12)
                .build();



        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-16, 65, 300))
                                //.lineToYSplineHeading(new Vector2d(0,98,97,98))
                // .strafeTo(new Vector2d(56,56))
                        //.lineToXSplineHeading(-56,0)
                        .strafeTo(new Vector2d(-52,65))
                               // .splineToLinearHeading(new Pose2d(60, 48, Math.toRadians(-90)), Math.toRadians(50))
                // .splineToLinearHeading(new Pose2d(40, 38, Math.toRadians(-90)), Math.toRadians(50))
               // .splineToLinearHeading(new Pose2d(40, 38, Math.toRadians(-90)), Math.toRadians(50))
                .build());








// LineToX, LineToY
        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}