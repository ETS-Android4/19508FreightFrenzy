package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.ftc11392.sequoia.SequoiaOpMode;
import com.ftc11392.sequoia.task.StartEndTask;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrainMecanumBasic;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SwingArm;
import org.firstinspires.ftc.teamcode.tasks.GamepadDriveTask;

import java.util.concurrent.atomic.AtomicInteger;

@TeleOp(name = "swing arm", group = "Quackology")
public class SwingArmOpMode extends OpMode {
    //private final Mecanum drivetrain = new Mecanum();
    private DriveTrainMecanumBasic drive;
    private Intake intake;
    private SwingArm arm;
    //    private final Arm arm = new Arm();
    //private final SwingArm arm = new SwingArm();
    // final Rotator rotator = new Rotator();
//    private final Gripper gripper = new Gripper();

    @Override
    public void init() {
        drive = new DriveTrainMecanumBasic(hardwareMap, telemetry);
        intake = new Intake(hardwareMap);
        intake.init();
        arm = new SwingArm(hardwareMap);
        arm.init();
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }


    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        drive.humanControl(gamepad1);
        if (gamepad1.dpad_right) intake.in();
        else if (gamepad1.dpad_down) intake.stop();
        else if (gamepad1.dpad_left) intake.out();

        if (gamepad2.dpad_right) arm.right();
        else if (gamepad2.dpad_left) arm.left();
        else if (gamepad2.dpad_up) arm.lift();
        else if (gamepad2.dpad_down) arm.intake();

        if (gamepad2.a) arm.test();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}