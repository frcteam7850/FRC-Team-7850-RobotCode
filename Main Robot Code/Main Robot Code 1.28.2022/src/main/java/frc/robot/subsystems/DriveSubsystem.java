// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveCon;
import frc.robot.Constants.RobotPort;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends SubsystemBase {
  
  private final Spark leftMotor1 = new Spark(RobotPort.kLeftMotor1Port); 
  private final Spark leftMotor2 = new Spark(RobotPort.kLeftMotor2Port);
  private final Spark rightMotor1 = new Spark(RobotPort.kRightMotor1Port);
  private final Spark rightMotor2 = new Spark(RobotPort.kRightMotor2Port);

  private Encoder encoder = new Encoder(0, 1, false, EncodingType.k4X);
  private double encoderDistence;

  public DriveSubsystem() {

  }

  @Override
  public void periodic() {
    
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    leftMotor1.set(leftSpeed*DriveCon.kLeftSpeedMod);
    leftMotor2.set(leftSpeed*DriveCon.kLeftSpeedMod);
    rightMotor1.set(rightSpeed*DriveCon.kRightSpeedMod);
    rightMotor2.set(rightSpeed*DriveCon.kRightSpeedMod);
  }
  public double getEncoderValue(){
    
    encoderDistence = encoder.get() * DriveCon.kEncoderConversion;

    return encoderDistence;
  }
  

  
}
