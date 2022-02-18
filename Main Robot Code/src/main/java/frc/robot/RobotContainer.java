// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.ControlCon;
import frc.robot.commands.PIDDriveCmd;
import frc.robot.commands.TankDriveCmd;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ArcadeDriveCmd;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



public class RobotContainer {
  
  
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();

  private final Joystick leftStick = new Joystick(ControlCon.kLeftStickPort);
  private final Joystick rightStick = new Joystick(ControlCon.kRightStickPort);

  
  
  

  public RobotContainer() {
    
    if(ControlCon.Drive.kEnableDefaltDrive){
    if(ControlCon.Drive.kDefaltDrive){
      driveSubsystem.setDefaultCommand(
      new ArcadeDriveCmd(driveSubsystem, 
        () -> ControlCon.Drive.sArcadeDrive.getRawAxis(ControlCon.Drive.kSpeedDriveAxis), 
        () -> ControlCon.Drive.sArcadeDrive.getRawAxis(ControlCon.Drive.kTurnDriveAxis)
        )
      );
    }else{
    driveSubsystem.setDefaultCommand(
      new TankDriveCmd(driveSubsystem, 
        () -> leftStick.getRawAxis(ControlCon.Drive.kLeftDriveAxis), 
        () -> rightStick.getRawAxis(ControlCon.Drive.kRightDriveAxis), 
        () -> ControlCon.Drive.sStraitDriveBut.getRawButton(ControlCon.Drive.kStraitDriveBut)
        )
    );
    }
    }
    

    configureButtonBindings();
  }
    

  private void configureButtonBindings() {
    
    new JoystickButton(ControlCon.PID.sPIDActiveBut1, ControlCon.PID.kPIDActiveBut1).whenHeld(new PIDDriveCmd(driveSubsystem, ControlCon.PID.mButton1Rotation));
    new JoystickButton(ControlCon.PID.sPIDActiveBut2, ControlCon.PID.kPIDActiveBut2).whenHeld(new PIDDriveCmd(driveSubsystem, ControlCon.PID.mButton1Rotation));
    
    if(ControlCon.Drive.kEnableDriveSwitch){
    new JoystickButton(ControlCon.Drive.sTankDriveBut, ControlCon.Drive.kTankDriveBut).whenPressed(
      new TankDriveCmd(driveSubsystem, 
        () -> rightStick.getRawAxis(ControlCon.Drive.kRightDriveAxis), 
        () -> leftStick.getRawAxis(ControlCon.Drive.kLeftDriveAxis), 
        () -> ControlCon.Drive.sStraitDriveBut.getRawButton(ControlCon.Drive.kStraitDriveBut)
        )
      );
    

    
    new JoystickButton(ControlCon.Drive.sArcadeDriveBut, ControlCon.Drive.kArcadeDriveBut).whenPressed(
      new ArcadeDriveCmd(driveSubsystem, 
      () -> rightStick.getRawAxis(ControlCon.Drive.kSpeedDriveAxis), 
      () -> rightStick.getRawAxis(ControlCon.Drive.kTurnDriveAxis)
      )
    );
    }
    
    
  }

  
  public Command getAutonomousCommand() {

    return null;
  }
}
