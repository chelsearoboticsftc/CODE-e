package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.StandardTrackingWheelLocalizer;
import org.firstinspires.ftc.teamcode.subsystems.Odometry;

@TeleOp
public class TestOdoPods extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status:","Initialized");
        telemetry.update();

        Odometry odometry = new Odometry(hardwareMap);

        odometry.init();
        telemetry.addData("OctoQuad Bank Config", odometry.readChannelBankConfig());
        telemetry.addData("Channel 0 Sample Interval", odometry.readVelocitySampleInterval(0));
        telemetry.addData("Channel 0 Min Pulse Width", odometry.readChannelMinPulseWidthMs(0));
        telemetry.addData("Channel 0 Max Pulse Width", odometry.readChannelMaxPulseWidthMs(0));
        telemetry.addData("Channel 1 Min Pulse Width", odometry.readChannelMinPulseWidthMs(1));
        telemetry.addData("Channel 1 Max Pulse Width", odometry.readChannelMaxPulseWidthMs(1));
        telemetry.addData("Channel 2 Min Pulse Width", odometry.readChannelMinPulseWidthMs(2));
        telemetry.addData("Channel 2 Max Pulse Width", odometry.readChannelMaxPulseWidthMs(2));
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){

            odometry.updatePositions();
            odometry.updateVelocities();

            if(gamepad1.x){
                odometry.resetEncoderCounts();
            }

            telemetry.addData("Left Opopod Count", odometry.getLeftEncoderCounts());
            telemetry.addData("Left Odopod Velocity", odometry.getLeftEncoderVelocity());
            telemetry.addData("Right Opopod Count", odometry.getRightEncoderCounts());
            telemetry.addData("Right Odopod Velocity", odometry.getRightEncoderVelocity());
            telemetry.addData("Center Opopod Count", odometry.getCenterEncoderCounts());
            telemetry.addData("Center Opopod Velocity", odometry.getCenterEncoderVelocity());
            telemetry.update();
        }
    }
}
