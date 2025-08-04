package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drive;

import java.util.Timer;

@Autonomous
public class Matthew_Danny extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        double speed;
        final double SPEED_1 = 0.5;
        final double SPEED_2 = 0.75;

        final double TIME_1 = 2.0;
        final double TIME_2 = 4.0;

        Drive drive = new Drive(hardwareMap);
        ElapsedTime timer = new ElapsedTime();

        waitForStart();
        drive.set(SPEED_1);
        timer.reset();
        while (opModeIsActive()) {
            if (timer.seconds() >= TIME_1) {
                drive.set(SPEED_2);

            }
            if (timer.seconds() >= TIME_2){
                drive.set(0);
            }
            drive.run();
        }

        drive.stop();
    }
}


