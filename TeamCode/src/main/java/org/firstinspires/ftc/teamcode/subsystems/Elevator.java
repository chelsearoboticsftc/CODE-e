package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

final class ElevatorConstants {
    final static DcMotor.ZeroPowerBehavior ZERO_POWER_MODE = DcMotor.ZeroPowerBehavior.BRAKE;
    final static DcMotorSimple.Direction MOTOR_DIRECTION = DcMotorSimple.Direction.FORWARD;
    final static double VELOCITY_P = 5.285;
    final static double VELOCITY_I = 0.5285;
    final static double VELOCITY_D = 0.0;
    final static double VELOCITY_F = 52.85;
    final static double POSITION_P = 5.0;
}

public class Elevator{

    DcMotorEx liftMotor;

    public Elevator(HardwareMap hardwareMap){
        this.liftMotor = hardwareMap.get(DcMotorEx.class,"liftMotor");
        //Configure what the motor does when unpowered (brake or coast)
        liftMotor.setZeroPowerBehavior(ElevatorConstants.ZERO_POWER_MODE);
        //Configure the motor direction
        liftMotor.setDirection(ElevatorConstants.MOTOR_DIRECTION);
        //Configure motor PID Coefficients
        //Velocity PIDF
        liftMotor.setVelocityPIDFCoefficients(
                ElevatorConstants.VELOCITY_P,
                ElevatorConstants.VELOCITY_I,
                ElevatorConstants.VELOCITY_D,
                ElevatorConstants.VELOCITY_F
        );
        //Position PID (uses Velocity coefficients for velocity control when using RUN_WITH_ENCODER)
        liftMotor.setPositionPIDFCoefficients(ElevatorConstants.POSITION_P);

    }

    public void init(){
        //Put initialization code here
    }

    public void update(){
        //Put periodic code here
    }

    public void setElevatorPosition(int position){
        liftMotor.setTargetPosition(position);
    }

}
