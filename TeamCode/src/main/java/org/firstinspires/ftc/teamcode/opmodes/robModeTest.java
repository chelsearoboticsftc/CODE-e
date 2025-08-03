package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name = "Rob's Test")
public class robModeTest extends LinearOpMode {
    private DcMotor motor1 = null;

    @Override
    public void runOpMode() throws InterruptedException {
        new ElapsedTime()
        motor1 = hardwareMap.get(DcMotor.class, "motorTest");
        telemetry.addData("Status", "Initialize");
        telemetry.update();
        waitForStart();
        telemetry.addData("Status", "Started");
        telemetry.update();
        motor1.setPower(0.5);
        sleep(1000);
        motor1.setPower(0);
        telemetry.addData("Status", "Stopped");
        telemetry.update();
    }
}
