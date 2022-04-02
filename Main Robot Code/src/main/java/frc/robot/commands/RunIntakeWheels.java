// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.tools.Diagnostic;

import com.ctre.phoenix.led.ColorFlowAnimation.Direction;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeCon;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntakeWheels extends CommandBase {

  private final IntakeSubsystem m_intakeSubsystem;
  private boolean m_direction;
  // true is forward, false is backward

  /** Creates a new RunIntakeWheels. */
  public RunIntakeWheels(IntakeSubsystem intakeSubsystem, Boolean direction) {
    m_intakeSubsystem = intakeSubsystem;
    m_direction = direction;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeSubsystem.runIntakeMotor(m_direction ? IntakeCon.kIntakeSpeed * 1 : IntakeCon.kIntakeSpeed * -1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.runIntakeMotor(0);
  }

}
