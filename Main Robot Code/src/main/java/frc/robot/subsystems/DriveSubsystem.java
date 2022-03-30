// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveCon;
import frc.robot.Constants.RobotPort;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class DriveSubsystem extends SubsystemBase {
  
  private final CANSparkMax leftMotor1 = new CANSparkMax(RobotPort.kLeftMotor1Port, MotorType.kBrushless); 
  private final CANSparkMax leftMotor2 = new CANSparkMax(RobotPort.kLeftMotor2Port, MotorType.kBrushless);
  private final CANSparkMax rightMotor1 = new CANSparkMax(RobotPort.kRightMotor1Port, MotorType.kBrushless);
  private final CANSparkMax rightMotor2 = new CANSparkMax(RobotPort.kRightMotor2Port, MotorType.kBrushless);

  private final SparkMaxPIDController drivePIDL;
  private final SparkMaxPIDController drivePIDR;
  private final RelativeEncoder driveEncoderL;
  private final RelativeEncoder driveEncoderR;

  //private double testVar = 0;
  //private double testVar2 = 0;
  
  private DifferentialDrive drivetrain;
  

  public DriveSubsystem() {
    

    leftMotor1.restoreFactoryDefaults();
    leftMotor2.restoreFactoryDefaults();
    rightMotor1.restoreFactoryDefaults();
    rightMotor2.restoreFactoryDefaults();

    leftMotor1.setInverted(DriveCon.kLeftMotorInvert);
    leftMotor2.setInverted(DriveCon.kLeftMotorInvert);
    rightMotor1.setInverted(DriveCon.kRightMotorInvert);
    rightMotor2.setInverted(DriveCon.kRightMotorInvert);

    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);

    drivePIDL = leftMotor1.getPIDController();
    driveEncoderL = leftMotor1.getEncoder();

    drivePIDR = rightMotor1.getPIDController();
    driveEncoderR = rightMotor1.getEncoder();

    drivetrain = new DifferentialDrive(leftMotor1, rightMotor1);
  }

  @Override
  public void periodic() {

    SmartDashboard.putNumber("leftMotor1 AppliedOutput", leftMotor1.getAppliedOutput());
    SmartDashboard.putNumber("leftMotor2 AppliedOutput", leftMotor2.getAppliedOutput());
    SmartDashboard.putNumber("rightMotor1 AppliedOutput", rightMotor1.getAppliedOutput());
    SmartDashboard.putNumber("rightMotor2 AppliedOutput", rightMotor2.getAppliedOutput());

    SmartDashboard.putNumber("leftMotor1 BusVoltage", leftMotor1.getBusVoltage());
    SmartDashboard.putNumber("leftMotor2 BusVoltage", leftMotor2.getBusVoltage());
    SmartDashboard.putNumber("rightMotor1 BusVoltage", rightMotor1.getBusVoltage());
    SmartDashboard.putNumber("rightMotor2 BusVoltage", rightMotor2.getBusVoltage());



    //just some test values

   /*testVar = SmartDashboard.getNumber("test Var", 0);

    SmartDashboard.putNumber("test Var", testVar);
    testVar2 = testVar;
    SmartDashboard.putNumber("test Var 2", testVar2);
    */

    
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    leftMotor1.set(leftSpeed*DriveCon.kLeftSpeedMod);
    rightMotor1.set(rightSpeed*DriveCon.kRightSpeedMod);

    
  }
  public void setArcadeDrive(double xSpeed, double zRotation){
    drivetrain.arcadeDrive(xSpeed, zRotation);
  }
  public void setTankDrive(double leftSpeed, double rightSpeed){
    drivetrain.tankDrive(leftSpeed, rightSpeed);
  }
  public void stopMotors(){
    drivetrain.stopMotor();
  }

  
  
  public void PIDDrive(double setpoint){
    drivePIDL.setP(DriveCon.PIDCon.kP);
    drivePIDL.setI(DriveCon.PIDCon.kI);
    drivePIDL.setD(DriveCon.PIDCon.kD);
    //drivePIDL.setIZone(PIDCon.kIZone);
    drivePIDL.setOutputRange(DriveCon.PIDCon.kMinOutput, DriveCon.PIDCon.kMaxOutput);

    drivePIDR.setP(DriveCon.PIDCon.kP);
    drivePIDR.setI(DriveCon.PIDCon.kI);
    drivePIDR.setD(DriveCon.PIDCon.kD);
    //drivePIDR.setIZone(PIDCon.kIZone);
    drivePIDR.setOutputRange(DriveCon.PIDCon.kMinOutput, DriveCon.PIDCon.kMaxOutput);

    SmartDashboard.putNumber("P Gain", DriveCon.PIDCon.kP);
    SmartDashboard.putNumber("I Gain", DriveCon.PIDCon.kI);
    SmartDashboard.putNumber("D Gain", DriveCon.PIDCon.kD);
    //SmartDashboard.putNumber("I Zone", PIDCon.kIZone);
    SmartDashboard.putNumber("Min Output", DriveCon.PIDCon.kMinOutput);
    SmartDashboard.putNumber("MaxOutput", DriveCon.PIDCon.kMaxOutput);
    SmartDashboard.putNumber("Setpoint", DriveCon.PIDCon.ksetpoint);
    SmartDashboard.putNumber("EncoderLeft", driveEncoderL.getPosition());
    SmartDashboard.putNumber("EncoderRigh", driveEncoderR.getPosition());

    /*double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    //double iz = SmartDashboard.getNumber("I Zone", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);

    if((p != PIDCon.kP)) { drivePIDL.setP(p); drivePIDR.setP(p); PIDCon.kP = p; }
    if((i != PIDCon.kI)) { drivePIDL.setI(i); drivePIDR.setI(i); PIDCon.kI = i; }
    if((d != PIDCon.kD)) { drivePIDL.setD(d); drivePIDR.setD(d); PIDCon.kD = d; }
    //if((iz != PIDCon.kIZone)) { drivePIDL.setIZone(iz); drivePIDR.setIZone(iz); PIDCon.kIZoneL = iz; }
    if((max != PIDCon.kMaxOutput) || (min != PIDCon.kMinOutput)) { 
      drivePIDL.setOutputRange(min, max);
      drivePIDR.setOutputRange(min, max); 
      PIDCon.kMinOutput = min; PIDCon.kMaxOutput = max; 
    }*/
    
    System.out.println(setpoint);
    drivePIDL.setReference(setpoint, CANSparkMax.ControlType.kPosition);
    System.out.println(drivePIDL.setReference(setpoint, CANSparkMax.ControlType.kPosition));

    drivePIDR.setReference(setpoint, CANSparkMax.ControlType.kPosition);
    System.out.println(drivePIDR.setReference(setpoint, CANSparkMax.ControlType.kPosition));


  }
  public void prepPID(){
    driveEncoderL.setPosition(0);
    driveEncoderR.setPosition(0);
  }
  public void finnishPID(){
    
    
  }
  

  
}
