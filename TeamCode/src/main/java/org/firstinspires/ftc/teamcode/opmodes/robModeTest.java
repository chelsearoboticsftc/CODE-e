package org.firstinspires.ftc.teamcode.opmodes;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.subsystems.RobDrive;



@TeleOp(name = "Rob's Test")
public class robModeTest extends LinearOpMode {
    ElapsedTime driveTimer = new ElapsedTime();
    RobDrive driveCommands = new RobDrive();
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        driveTimer.reset();
        driveCommands.driveInit();
        while(opModeIsActive() == true) {
            sleep(10);
            driveCommands.driveUpdate();
            telemetry.addData("Timer = ", driveTimer.seconds());
            telemetry.update();
        }
    }
}
