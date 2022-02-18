// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.DriveCon;
import frc.robot.subsystems.DriveSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class TankDriveCmd extends CommandBase {
  

  private final DriveSubsystem driveSubsystem; 
  private final Supplier<Double> rightSpeedFunction;
  private final Supplier<Double> leftSpeedFunction;
  private final Supplier<Boolean> strait;
  private double straitvalue;
  //use private final varable_type varable_name; to make new varable wich you can grab in constructor
  
  public TankDriveCmd(DriveSubsystem driveSubsystem, 
      Supplier<Double> rightSpeedFunction, Supplier<Double> leftSpeedFunction, Supplier<Boolean> strait) {
    this.driveSubsystem = driveSubsystem;
    this.rightSpeedFunction = rightSpeedFunction;
    this.leftSpeedFunction = leftSpeedFunction;
    this.strait = strait;
    //use this.varable_name = varable_name; to get varables into command 
    //also make sure to add varable_name in parameters
    addRequirements(driveSubsystem);
  }
  
  @Override
  public void initialize() {
    //put setup code here
    System.out.println("TankDriveCmd Started");
  }
  
  @Override
  public void execute() {
    //this function called repetivly while command is running
    
    double realTimeRightSpeed = -rightSpeedFunction.get()*DriveCon.kMaxSpeed;
    double realTimeLeftSpeed = -leftSpeedFunction.get()*DriveCon.kMaxSpeed;
    if(strait.get()){
      straitvalue = (realTimeLeftSpeed+realTimeRightSpeed)/2;
      realTimeRightSpeed = straitvalue;
      realTimeLeftSpeed = straitvalue;
      driveSubsystem.setMotors(realTimeLeftSpeed, realTimeRightSpeed);
    }else{
      driveSubsystem.setTankDrive(realTimeLeftSpeed, realTimeRightSpeed);
    }

    
    
  }

  @Override
  public void end(boolean interrupted) {
    //last end stuff ran at end
    //bool interupted is true if command is stoped
    driveSubsystem.setMotors(0, 0);
    System.out.println("TankDriveCmd Ended");
  }
  @Override
  public boolean isFinished() {
    return false;
    //if ture will have the command finnish and let the next command run
  }
}