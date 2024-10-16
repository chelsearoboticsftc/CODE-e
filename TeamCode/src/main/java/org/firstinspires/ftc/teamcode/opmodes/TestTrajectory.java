package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class TestTrajectory extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);

        Pose2d startingPose = new Pose2d(-28,64,Math.toRadians(270));

        drivetrain.setPoseEstimate(startingPose);

        Trajectory goForward = drivetrain.trajectoryBuilder(startingPose,false)
                .forward(30)
                .build();

        Trajectory goToSample = drivetrain.trajectoryBuilder(startingPose,false)
                .strafeTo(new Vector2d(-36,15))
                .build();

        /*Trajectory driveBackwards = drivetrain.trajectoryBuilder(strafeRight.end())
                .back(40)
                .build();*/

        Trajectory splineToSample = drivetrain.trajectoryBuilder(goToSample.end())
                .splineTo(new Vector2d(-50,15),0)
                .build();
        
        waitForStart();

        //drivetrain.followTrajectory(goForward);
        drivetrain.followTrajectory(goToSample);

        /*while(opModeIsActive() && !isStopRequested()){
            drivetrain.followTrajectory(goForward);
        }*/

    }
}
