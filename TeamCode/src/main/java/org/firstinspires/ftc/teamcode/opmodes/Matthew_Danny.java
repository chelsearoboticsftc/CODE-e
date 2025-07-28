package org.firstinspires.ftc.teamcode.opmodes;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous
public class Matthew_Danny extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotorEx MotorTest = hardwareMap.get(DcMotorEx.class, "MotorTest");
        DistanceSensor distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
        waitForStart();
        double speed;
        while (opModeIsActive()) {

            telemetry.addData("Gamepad Rightstick Y value",gamepad1.right_stick_y);
            telemetry.update();

            speed = -1 * gamepad1.right_stick_y;
            MotorTest.setPower(speed);




        }


    }
}

