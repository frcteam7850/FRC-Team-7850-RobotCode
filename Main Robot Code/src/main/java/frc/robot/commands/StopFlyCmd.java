// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlywheelSubsystem;


public class StopFlyCmd extends CommandBase {
  
  private final FlywheelSubsystem flywheelSubsystem; //new ExampleSubsystem();
  //use private final varable_type varable_name; to make new varable wich you can grab in constructor
  
  public StopFlyCmd(FlywheelSubsystem flywheelSubsystem) {
    this.flywheelSubsystem = flywheelSubsystem;
    //use this.varable_name = varable_name; to get varables into command 
    //also make sure to add varable_name in parameters
    addRequirements(flywheelSubsystem);
  }
  
  @Override
  public void initialize() {
    //put setup code here
    flywheelSubsystem.stopFly();
  }
  
  @Override
  public void execute() {
    //this function called repetivly while command is running
  }

  @Override
  public void end(boolean interrupted) {
    //last end stuff ran at end
    //bool interupted is true if command is stoped
  }
  @Override
  public boolean isFinished() {
    return false;
    //if ture will have the command finnish and let the next command run
  }
}
