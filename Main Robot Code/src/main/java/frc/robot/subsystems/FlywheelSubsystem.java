// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlyCon;
import frc.robot.Constants.RobotPort;

public class FlywheelSubsystem extends SubsystemBase {
    private boolean emgStop;
    private final CANSparkMax flyMotor1 = new CANSparkMax(RobotPort.kFlyMotor1, MotorType.kBrushless);
    private final CANSparkMax flyMotor2 = new CANSparkMax(RobotPort.kFlyMotor2, MotorType.kBrushless);

    private final SparkMaxPIDController flyPID;
    private final RelativeEncoder flyEncoder;
    private final RelativeEncoder flyEncoder2;
  
//put setup code here
//ex private final Spark Motor = new Spark(0);

  public FlywheelSubsystem() {
    //other setup stuff such as inverting motors with sensors
    flyMotor1.restoreFactoryDefaults();
    flyMotor2.restoreFactoryDefaults();

    flyMotor1.setInverted(FlyCon.Motors.kMotor1Invert);

    flyMotor2.follow(flyMotor1, FlyCon.Motors.kMotorDiffrenceInvert);

    flyPID = flyMotor1.getPIDController();
    flyEncoder = flyMotor1.getEncoder();
    flyEncoder2 = flyMotor2.getEncoder();

  }

  @Override
  public void periodic() {

    //runs continuasly like robotperiodic
    
    System.out.println("right " + flyEncoder.getVelocity());
    System.out.println("left  " + flyEncoder2.getVelocity());
    
    
  }

  public void setFlyPID(){
    //inital code for PID
  }
  public void warmFly(){
    //sends a value just below target range so that way it dosent take as long to get to target range (more for practice when shooting multiple in a row so we arnt waiting on flywheel)
  }
  public void runFly(){
    //runs flywheel inside a target range, adjestable for distence mabye
  }
  public void valueSetFly(double speed){
      flyMotor1.set(speed); //sets a manual value to flywheel doent use speed PID but will use diffrence PID
  }
  public void idleFly(){
    //sets a very low value outside warm range to spin flywheel at low speeds for instence dropping a ball rather then shooting
  }
  public void stopFly(){
    //sends 0 to motors and turns off PIDs
  }
  public void haltFly(){
    //brakes flywheel for emergencies not for constent use
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
