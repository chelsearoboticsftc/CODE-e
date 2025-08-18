package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Connor extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("Left the stick", gamepad2.left_stick_x);
            telemetry.update();
            sleep(1000);

        }
    }
}
