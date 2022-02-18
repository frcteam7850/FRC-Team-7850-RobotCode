// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.ControlCon;
import frc.robot.commands.PIDDriveCmd;
import frc.robot.commands.TankDriveCmd;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {
  
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();

  private final Joystick leftStick = new Joystick(ControlCon.kLeftStickPort);
  private final Joystick rightStick = new Joystick(ControlCon.kRightStickPort);
  

  public RobotContainer() {
    

    driveSubsystem.setDefaultCommand(
      new TankDriveCmd(driveSubsystem, () -> leftStick.getRawAxis(ControlCon.kLeftDriveAxis), () -> rightStick.getRawAxis(ControlCon.kRightDriveAxis)) 
    );

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(rightStick, ControlCon.kPIDActiveBut).whenHeld(new PIDDriveCmd(driveSubsystem, 10));
    //SmartDashboard.putNumber("LeftStick Drive Axis", leftStick.getRawAxis(ControlCon.kLeftDriveAxis));
    //SmartDashboard.putNumber("RightStick Drive Axis", leftStick.getRawAxis(ControlCon.kRightDriveAxis));
    Shuffleboard.getTab("Drive Varables").add("left control", leftStick.getRawAxis(ControlCon.kLeftDriveAxis));
    Shuffleboard.getTab("Drive Varables").add("right control", rightStick.getRawAxis(ControlCon.kRightDriveAxis));
    
  }

  
  public Command getAutonomousCommand() {

    return null;
  }
}
