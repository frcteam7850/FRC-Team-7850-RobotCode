// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  
//put setup code here
//ex private final Spark Motor = new Spark(0);

  public ExampleSubsystem() {
    //other setup stuff such as inverting motors with sensors
  }

  @Override
  public void periodic() {

    //runs continuasly like robotperiodic
    
  }

  //create nessary functions/methods which the command will use

  
}

//normally ther is also a simulationperiodic function but were not using it, add if nessary below periodic function
  /*
  @Override
  public void simulationPeriodic() {
    
  }
  */
