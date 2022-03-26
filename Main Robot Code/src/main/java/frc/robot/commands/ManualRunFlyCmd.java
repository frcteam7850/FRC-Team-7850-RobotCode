// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import frc.robot.subsystems.FlywheelSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class ManualRunFlyCmd extends CommandBase {
  
  //private final ExampleSubsystem m_subsystem; //new ExampleSubsystem();
  //use private final varable_type varable_name; to make new varable wich you can grab in constructor
  private final FlywheelSubsystem flywheelSubsystem;
  private final Supplier<Double> speedFunction;

  public ManualRunFlyCmd(FlywheelSubsystem flywheelSubsystem, Supplier<Double> speedFunction) {
    this.flywheelSubsystem = flywheelSubsystem;
    this.speedFunction = speedFunction;
    //use this.varable_name = varable_name; to get varables into command 
    //also make sure to add varable_name in parameters
    //addRequirements(m_subsystem);
  }
  
  @Override
  public void initialize() {
    //put setup code here
    System.out.println("ManualRunFly Started");
  }
  
  @Override
  public void execute() {
      flywheelSubsystem.valueSetFly(speedFunction.get());
    //this function called repetivly while command is running
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("ManualRunFly Ended");
    //last end stuff ran at end
    //bool interupted is true if command is stoped
  }
  @Override
  public boolean isFinished() {
    return false;
    //if ture will have the command finnish and let the next command run
  }
}
