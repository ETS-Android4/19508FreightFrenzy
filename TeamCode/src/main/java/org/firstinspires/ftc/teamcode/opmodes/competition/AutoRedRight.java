package org.firstinspires.ftc.teamcode.opmodes.competition;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.ftc11392.sequoia.SequoiaOpMode;
import com.ftc11392.sequoia.task.InstantTask;
import com.ftc11392.sequoia.task.SequentialTaskBundle;
import com.ftc11392.sequoia.task.SwitchTask;
import com.ftc11392.sequoia.task.Task;
import com.ftc11392.sequoia.task.WaitTask;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.DuckDetector;
import org.firstinspires.ftc.teamcode.subsystems.Gripper;
import org.firstinspires.ftc.teamcode.subsystems.Mecanum;
import org.firstinspires.ftc.teamcode.subsystems.Rotator;
import org.firstinspires.ftc.teamcode.tasks.FollowTrajectoryTask;
import org.firstinspires.ftc.teamcode.tasks.TimedDriveTask;

@Autonomous(name = "Auto Red Right", group = "Quackology")
public class AutoRedRight extends SequoiaOpMode {

    DuckDetector duckDetector = new DuckDetector(0, 105, 185);
    Mecanum mecanum = new Mecanum();
//    Rotator rotator = new Rotator();
//    Arm arm = new Arm();
//    Gripper gripper = new Gripper();
    ElapsedTime runtime = new ElapsedTime();
    //this code does not work


    Map<Object, Task> positionMap = new HashMap<Object, Task>(){{
        put(DuckDetector.DuckPipeline.DuckPosition.LEFT,
                new TimedDriveTask(runtime, mecanum));

//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(-12,-60,Math.PI/2))
//                        .build()),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(-12,-53,Math.PI/2))
//                        .build())
//
//        ));
        put(DuckDetector.DuckPipeline.DuckPosition.CENTER,
                        new TimedDriveTask(runtime, mecanum));


//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(-12,-60,Math.PI/2))
//                        .build()),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(-12,-51,Math.PI/2))
//                        .build())

        put(DuckDetector.DuckPipeline.DuckPosition.RIGHT,
                        new TimedDriveTask(runtime, mecanum));
//                    arm.setMode(Arm.ArmMode.HORIZONTAL);
//                    arm.modifySetpoint(18); // 11 18
//                }),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(-12,-58,Math.PI/2))
//                        .build()),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(-12,-51,Math.PI/2))
//                        .build())

    }};

    @Override
    public void initTriggers() {
        mecanum.mecanum().setPoseEstimate(new Pose2d(-33,-63.5));
    }

    @Override
    public void runTriggers() {
        DuckDetector.DuckPipeline.DuckPosition position = duckDetector.getAnalysis();
        scheduler.schedule(new SequentialTaskBundle(
                new WaitTask(10),
//                new SwitchTask(positionMap, () -> position),
////                new InstantTask(() -> gripper.setState(Gripper.GripperState.OPEN)),
//                new WaitTask(1),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(mecanum.mecanum().getPoseEstimate()
//                                .plus(new Pose2d(0,-5)))
//                        .build()),
////                new InstantTask(() -> arm.setMode(Arm.ArmMode.HOME)),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(-66.5,-59.5,-Math.PI/2))
//                        .build()),
////                new InstantTask(() -> rotator.setSetpoint(-10)),
//                new WaitTask(3),
////                new InstantTask(() -> rotator.setSetpoint(0)),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(0,-72.5,Math.PI))
//                        .build()),
//                new FollowTrajectoryTask(mecanum, () -> mecanum.mecanum()
//                        .trajectoryBuilder(mecanum.mecanum().getPoseEstimate())
//                        .lineToLinearHeading(new Pose2d(48,-72.5,Math.PI))
//                        .build()),
                new InstantTask(this::requestOpModeStop)
        ));
    }
}