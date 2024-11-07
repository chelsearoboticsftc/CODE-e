package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
//import org.firstinspires.ftc.teamcode.subsystems.IntakeConstants;
//import org.firstinspires.ftc.teamcode.subsystems.IntakeConstants;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
public class LowSpecimenRight extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drivetrain = new SampleMecanumDrive(hardwareMap);
        Intake intake = new Intake(hardwareMap);

        Pose2d startingPose = new Pose2d(39.5,62,Math.toRadians(270));//TODO: Update this with starting position
        int wristPosition = 1234;

        TrajectoryVelocityConstraint velocityConstraint;

        drivetrain.setPoseEstimate(startingPose);

        TrajectorySequence smurfNeutralSamples = drivetrain.trajectorySequenceBuilder(startingPose)
                .forward(2)
                .addTemporalMarker(()->intake.setWristPosition(wristPosition))
                .waitSeconds(1)
                //.addTemporalMarker(()->intake.setIntakeState(IntakeConstants.IntakeState.OUT))
                .build();

        waitForStart();

        drivetrain.followTrajectorySequence(smurfNeutralSamples);

    }
}
