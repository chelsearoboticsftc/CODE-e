package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Timer;

public class Drive {
    private DcMotorEx frontLeft;
    private DcMotorEx frontRight;
    private DcMotorEx backRight;
    private DcMotorEx backLeft;
    private double motorPower;
    public Drive(HardwareMap hardwareMap){
        //this.frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        this.frontRight = hardwareMap.get(DcMotorEx.class, "MotorTest");
        //this.backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        //this.backRight = hardwareMap.get(DcMotorEx.class, "backRight");
    }

    public void init() {

    }
    public void run(){
        frontRight.setPower(motorPower);
    }
    public void set(double power) {
        motorPower = power;


    }
    public void stop() {
    frontRight.setPower(0);
    motorPower = 0;
    }
}
