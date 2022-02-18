// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.DriveCon;
import frc.robot.subsystems.DriveSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class ArcadeDriveCmd extends CommandBase {
  

  private final DriveSubsystem driveSubsystem; 
  private final Supplier<Double> speedFunction;
  private final Supplier<Double> turnFunction;
  private double speed;
  private double turn;
  //use private final varable_type varable_name; to make new varable wich you can grab in constructor
  
  public ArcadeDriveCmd(DriveSubsystem driveSubsystem, 
      Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.driveSubsystem = driveSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    
    //use this.varable_name = varable_name; to get varables into command 
    //also make sure to add varable_name in parameters
    addRequirements(driveSubsystem);
  }
  
  @Override
  public void initialize() {
    //put setup code here
    
    System.out.println("ArcadeDriveCmd Started");
  }
  
  @Override
  public void execute() {
    //this function called repetivly while command is running
    if(DriveCon.kInvertTurn){
        turn = -turnFunction.get()*DriveCon.kTurnValue;
    }else{
        turn = turnFunction.get()*DriveCon.kTurnValue;
    }
    speed = -speedFunction.get()*DriveCon.kMaxSpeed;
    
    driveSubsystem.setArcadeDrive(speed, turn);

    
    
  }

  @Override
  public void end(boolean interrupted) {
    //last end stuff ran at end
    //bool interupted is true if command is stoped
    driveSubsystem.setMotors(0, 0);
    System.out.println("ArcadeDriveCmd Ended");
  }
  @Override
  public boolean isFinished() {
    return false;
    //if ture will have the command finnish and let the next command run
  }
}