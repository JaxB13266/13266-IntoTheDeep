package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.FieldCentric;
import org.firstinspires.ftc.teamcode.subsystems.Slides;
import org.firstinspires.ftc.teamcode.subsystems.Wrist;

@TeleOp
public class TeleOpMain extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        FieldCentric fieldCentricDrive= new FieldCentric(this);
        /*Slides slide= new Slides(this);
        Wrist wrist= new Wrist(this);
        Claw claw= new Claw(this);
        Arm arm= new Arm(this);*/
        waitForStart();
        while (opModeIsActive()) {
            fieldCentricDrive.fieldCentric();
            /*slide.slidesTeleOp();
            wrist.wristTeleOp();
            claw.clawTeleOp();
            arm.armTeleOp();*/
        }
    }
}
