package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;



public class RobDrive{

    DCMotorEx testMotor = new DcMotorEx();

    public RobDrive(HardwareMap){
        //Constructor
        this.testMotor = HardwareMap.class(DCMotorEx.class, "testMotor")
    }
    public static void driveInit(){
        // initialize code here that runs before the opmode is started
        // Get all Hardware
        DistanceSensor F_Dist = new DistanceSensor();
    }
    public static void driveUpdate(){
// to be run during opmode active

    }

    public static void driveStop(){

    }

}
