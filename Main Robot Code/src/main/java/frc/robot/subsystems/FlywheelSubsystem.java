// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlyCon;
import frc.robot.Constants.RobotPort;

public class FlywheelSubsystem extends SubsystemBase {
    private boolean emgStop;
    private final CANSparkMax flyMotor1 = new CANSparkMax(RobotPort.kFlyMotor1, MotorType.kBrushless);
    private final CANSparkMax flyMotor2 = new CANSparkMax(RobotPort.kFlyMotor2, MotorType.kBrushless);

    private final SparkMaxPIDController flyPID;
    private final RelativeEncoder flyEncoder;
  
//put setup code here
//ex private final Spark Motor = new Spark(0);

  public FlywheelSubsystem() {
    //other setup stuff such as inverting motors with sensors
    flyMotor1.restoreFactoryDefaults();
    flyMotor2.restoreFactoryDefaults();

    flyMotor1.setInverted(FlyCon.kMotor1Invert);

    flyMotor2.follow(flyMotor1, FlyCon.kMotor2Invert);

    flyPID = flyMotor1.getPIDController();
    flyEncoder = flyMotor1.getEncoder();

    emgStop = false;
  }

  @Override
  public void periodic() {

    //runs continuasly like robotperiodic
    
  }

  public void setFlyPID(){
    
  }
  public void warmFly(){
    if(emgStop = false){
        
    }
  }
  public void runFly(){
    if(emgStop = false){
        
    }
  }
  public void idleFly(){
    if(emgStop = false){
        
    }
  }
  public void stopFly(){
    if(emgStop = false){
        
    }
  }
  public void emgStopFly(){
    emgStop = true;
  }
  public void emgUnstopFly(){
    emgStop = false;
  }
  public void fastStopFly(){
    if(emgStop = false){

    }
  }
  public void dispPIDInfo(){

  }

  //create nessary functions/methods which the command will use
  
  
}

//normally ther is also a simulationperiodic function but were not using it, add if nessary below periodic function
  /*
  @Override
  public void simulationPeriodic() {
    
  }
  */
