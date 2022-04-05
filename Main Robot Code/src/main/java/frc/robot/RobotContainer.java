// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.BallStopSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.ControlCon;
import frc.robot.commands.PIDDriveCmd;
import frc.robot.commands.RaiseIntakeCmd;
import frc.robot.commands.RunFlyCmd;
import frc.robot.commands.RunIntakeWheels;
import frc.robot.commands.TankDriveCmd;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.CloseBallStopCmd;
import frc.robot.commands.StopFlyCmd;
import frc.robot.commands.LowerIntakeCmd;
import frc.robot.commands.ManualRunFlyCmd;
import frc.robot.commands.OpenBallStopCmd;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final BallStopSubsystem ballStopSubsystem = new BallStopSubsystem();

  private final Joystick leftStick = new Joystick(ControlCon.kLeftStickPort);
  private final Joystick rightStick = new Joystick(ControlCon.kRightStickPort);

  public RobotContainer() {

    //determains what drive system and if to enable a drive system
    if (ControlCon.Drive.kEnableDefaltDrive) {
      if (ControlCon.Drive.kDefaltDrive) {
        driveSubsystem.setDefaultCommand(
            new ArcadeDriveCmd(driveSubsystem,
                () -> ControlCon.Drive.sArcadeDrive.getRawAxis(ControlCon.Drive.kSpeedDriveAxis),
                () -> ControlCon.Drive.sArcadeDrive.getRawAxis(ControlCon.Drive.kTurnDriveAxis)));
      } else {
        driveSubsystem.setDefaultCommand(
            new TankDriveCmd(driveSubsystem,
                () -> leftStick.getRawAxis(ControlCon.Drive.kLeftDriveAxis),
                () -> rightStick.getRawAxis(ControlCon.Drive.kRightDriveAxis),
                () -> ControlCon.Drive.sStraitDriveBut.getRawButton(ControlCon.Drive.kStraitDriveBut)));
        flywheelSubsystem.setDefaultCommand(new ManualRunFlyCmd(flywheelSubsystem, () -> leftStick.getRawAxis(1)));
      }
    }

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    //Drive PID to Buttons
    /*new JoystickButton(ControlCon.PID.sPIDActiveBut1, ControlCon.PID.kPIDActiveBut1)
        .whenHeld(new PIDDriveCmd(driveSubsystem, ControlCon.PID.mButton1Rotation));
    new JoystickButton(ControlCon.PID.sPIDActiveBut2, ControlCon.PID.kPIDActiveBut2)
        .whenHeld(new PIDDriveCmd(driveSubsystem, ControlCon.PID.mButton1Rotation));*/ 

    // lower intake button
    new JoystickButton(rightStick, ControlCon.Intake.lowerIntakeBut).whenPressed(new LowerIntakeCmd(intakeSubsystem));
    // raise intake button
    new JoystickButton(rightStick, ControlCon.Intake.raiseIntakeBut).whenPressed(new RaiseIntakeCmd(intakeSubsystem));
    // run intake forward (intaking)
    new JoystickButton(rightStick, ControlCon.Intake.intakeInBut).whileHeld(new RunIntakeWheels(intakeSubsystem, true));
    // run intake reverse (outaking)
    new JoystickButton(rightStick, ControlCon.Intake.intakeOutBut).whileHeld(new RunIntakeWheels(intakeSubsystem, false));

    
    //run flywheel
    new JoystickButton(rightStick, 1).whileHeld(
      new RunFlyCmd(flywheelSubsystem, () -> rightStick.getRawAxis(1))
    );
    //stop flywheel
    new JoystickButton(rightStick, 2).whileHeld(
      new StopFlyCmd(flywheelSubsystem)
    );
    //open ball stop
    new JoystickButton(rightStick, 3).whileHeld(new OpenBallStopCmd(ballStopSubsystem));
    //close ball stop
    new JoystickButton(rightStick, 4).whileHeld(new CloseBallStopCmd(ballStopSubsystem));

  }

  public Command getAutonomousCommand() {

    return null;
  }
}
