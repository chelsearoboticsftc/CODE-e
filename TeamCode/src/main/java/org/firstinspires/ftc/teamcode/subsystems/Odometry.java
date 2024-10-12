package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;
import com.qualcomm.hardware.digitalchickenlabs.OctoQuadBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Odometry {

    private OctoQuad octoquad;

    private int[] positions;
    private short[] velocities;
    private int[] velSampleIvlMs;
    private OctoQuadBase.ChannelBankConfig channelConfig;

    public Odometry(HardwareMap hardwareMap){
        this.octoquad = hardwareMap.get(OctoQuad.class, "octoquad");
    }

    public void init(){
        // Reverse the count-direction of any encoder that is not what you require.
        // e.g. if you push the robot forward and the left encoder counts down, then reverse it so it counts up.

        //octoquad.resetEverything();

        octoquad.setSingleEncoderDirection(OdometryConstants.ODO_LEFT,
                                                    OdometryConstants.ODO_LEFT_DIRECTION);
        octoquad.setSingleEncoderDirection(OdometryConstants.ODO_RIGHT,
                                                    OdometryConstants.ODO_RIGHT_DIRECTION);
        octoquad.setSingleEncoderDirection(OdometryConstants.ODO_CENTER,
                                                    OdometryConstants.ODO_CENTER_DIRECTION);

        //octoquad.setChannelBankConfig(OctoQuad.ChannelBankConfig.BANK1_QUADRATURE_BANK2_PULSE_WIDTH);

        octoquad.setAllVelocitySampleIntervals(20);

        // Any changes that are made should be saved in FLASH just in case there is a sensor power glitch.
        octoquad.saveParametersToFlash();

        // Set all the encoder inputs to zero.
        octoquad.resetAllPositions();

        channelConfig = octoquad.getChannelBankConfig();
    }

    public int readChannelBankConfig(){
        return channelConfig.bVal;
    }

    public int readChannelMinPulseWidthMs(int index){
        return octoquad.getSingleChannelPulseWidthParams(index).min_length_us;
    }

    public int readChannelMaxPulseWidthMs(int index){
        return octoquad.getSingleChannelPulseWidthParams(index).max_length_us;
    }

    public int readVelocitySampleInterval(int index){
        return octoquad.getSingleVelocitySampleInterval(index);
    }

    public void updatePositions(){
        positions = octoquad.readAllPositions();
    }

    public void updateVelocities() {velocities = octoquad.readAllVelocities(); }

    public int getLeftEncoderCounts(){
        return positions[OdometryConstants.ODO_LEFT];
    }

    public int getRightEncoderCounts(){
        return positions[OdometryConstants.ODO_RIGHT];
    }

    public int getCenterEncoderCounts(){
        return positions[OdometryConstants.ODO_CENTER];
    }

    public short getLeftEncoderVelocity(){
        return velocities[OdometryConstants.ODO_LEFT];
    }

    public short getRightEncoderVelocity(){
        return velocities[OdometryConstants.ODO_RIGHT];
    }

    public short getCenterEncoderVelocity(){
        return velocities[OdometryConstants.ODO_CENTER];
    }

    public void resetEncoderCounts(){
        octoquad.resetAllPositions();
    }
}
