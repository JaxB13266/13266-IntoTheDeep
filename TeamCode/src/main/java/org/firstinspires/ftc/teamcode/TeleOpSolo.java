package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.FieldCentric;
import org.firstinspires.ftc.teamcode.subsystems.Slides;
import org.firstinspires.ftc.teamcode.subsystems.Wrist;


@TeleOp
public class TeleOpSolo extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        FieldCentric fieldCentricDrive= new FieldCentric(this);
        Arm arm= new Arm(this);
        Wrist wrist= new Wrist(this);
        Slides slides= new Slides(this);
        Claw claw= new Claw(this);
        waitForStart();
        while (opModeIsActive()) {
            fieldCentricDrive.fieldCentric();
            arm.armSoloTeleOP();
            wrist.wristSoloTeleOp();
            slides.slidesSoloTeleOp();
            claw.clawSoloTeleOp();
        }
    }
}