// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;


public class PIDDriveCmd extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private double setpoint;
    private double motorValue;
    private final PIDController PIDcontroller = new PIDController(1, 0, 0);
  
  
  
  public PIDDriveCmd(DriveSubsystem driveSubsystem, double setpoint) {

    this.driveSubsystem = driveSubsystem;
    this.setpoint = setpoint;
    addRequirements(driveSubsystem);
    
  }
  
  @Override
  public void initialize() {
    PIDcontroller.reset();
    PIDcontroller.setSetpoint(setpoint);
  }
  
  @Override
  public void execute() {
    
    motorValue = PIDcontroller.calculate(driveSubsystem.getEncoderValue());
    driveSubsystem.setMotors(motorValue, motorValue);

  }

  @Override
  public void end(boolean interrupted) {
    //last end stuff ran at end
    //bool interupted is true if command is stoped
    driveSubsystem.setMotors(0, 0);
  }
  @Override
  public boolean isFinished() {
    return false;
    //if ture will have the command finnish and let the next command run
  }
}
