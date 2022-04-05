// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.EncoderType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.SparkMaxRelativeEncoder.Type;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlyCon;
import frc.robot.Constants.RobotPort;

public class FlywheelSubsystem extends SubsystemBase {
    
    private final CANSparkMax flyMotor1 = new CANSparkMax(RobotPort.kFlyMotor1, MotorType.kBrushless);
    private final CANSparkMax flyMotor2 = new CANSparkMax(RobotPort.kFlyMotor2, MotorType.kBrushless);

    private final SparkMaxPIDController flyPID;
    private final RelativeEncoder flyEncoder;
    private final RelativeEncoder flyEncoder2;
    private boolean goodToRun = false;
    private double setPointDiff = 0;

    
  
    public double runSetpoint = 0;
  
//put setup code here
//ex private final Spark Motor = new Spark(0);

  public FlywheelSubsystem() {
    //other setup stuff such as inverting motors with sensors
    flyMotor1.restoreFactoryDefaults();
    flyMotor2.restoreFactoryDefaults();

    flyMotor1.setInverted(FlyCon.Motors.kMotor1Invert);

    flyMotor2.follow(flyMotor1, true);

    flyPID = flyMotor1.getPIDController();
    flyEncoder = flyMotor1.getEncoder();
    flyEncoder2 = flyMotor2.getEncoder();

    flyPID.setP(FlyCon.VelPID.kP);
    flyPID.setI(FlyCon.VelPID.kI);
    flyPID.setD(FlyCon.VelPID.kD);
    flyPID.setIZone(FlyCon.VelPID.kIz);
    flyPID.setFF(FlyCon.VelPID.kFF);

    SmartDashboard.putNumber("Run Setpoint", runSetpoint);

  }

  @Override
  public void periodic() {

    //runs continually like robotperiodic
    
    System.out.println("right " + flyEncoder.getVelocity());
    System.out.println("left  " + flyEncoder2.getVelocity());
    SmartDashboard.putNumber("ProcessVariable", flyEncoder.getVelocity());
    
    
    
  }

  public void setFlyPID(double run){

    run = SmartDashboard.getNumber("Run Setpoint", 0);
    //inital code for PID

    double setPoint = run;

    System.out.println("Setpoint: " + setPoint);

    flyPID.setReference(setPoint, CANSparkMax.ControlType.kVelocity);

    SmartDashboard.putNumber("SetPoint", setPoint);

    setPointDiff = setPoint - flyEncoder.getVelocity();
    if(setPointDiff <= 10 && setPointDiff >= -10){
      goodToRun = true;
    }else{
      goodToRun = false;
    }
    SmartDashboard.putBoolean("Good To Run", goodToRun);
    
  }
  public void warmFly(){
    //sends a value just below target range so that way it doesn't take as long to get to target range (more for practice when shooting multiple in a row so we aren't waiting on flywheel)
  }
  public void runFly(){
    //runs flywheel inside a target range, adjustable for distance maybe
  }
  public void valueSetFly(double speed){
      flyMotor1.set(speed); //sets a manual value to flywheel doesn't use speed PID but will use difference PID
  }
  public void idleFly(){
    //sets a very low value outside warm range to spin flywheel at low speeds for instance dropping a ball rather then shooting
  }
  public void stopFly(){
    flyMotor1.set(0);
  }
  public void haltFly(){
    //brakes flywheel for emergencies not for constant use
  }
  
  public void dispPIDInfo(){

  }

  //create necessary functions/methods which the command will use
  
  
}

//normally there is also a simulationperiodic function but were not using it, add if necessary below periodic function
  /*
  @Override
  public void simulationPeriodic() {
    
  }
  */
