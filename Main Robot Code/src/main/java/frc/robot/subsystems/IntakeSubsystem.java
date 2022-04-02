// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.*;

public class IntakeSubsystem extends SubsystemBase {

  DoubleSolenoid intakeDoubleSolenoid = new DoubleSolenoid(RobotPort.kPSHubPort, PneumaticsModuleType.REVPH, IntakeCon.kIntakeSolenoidForwardPort, IntakeCon.kIntakeSolenoidReversePort);
  CANSparkMax intakeMotor = new CANSparkMax(IntakeCon.kIntakeMotorCanID, CANSparkMax.MotorType.kBrushless);

  /** Creates a new Intake. */
  public IntakeSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeDown() {
    intakeDoubleSolenoid.set(kReverse);
  }

  public void intakeUp() {
    intakeDoubleSolenoid.set(kForward);
  }

  public void intakeStop() {
    intakeDoubleSolenoid.set(kOff);
  }

  public void runIntakeMotor(double speed) {
    intakeMotor.set(speed);
  }
}
