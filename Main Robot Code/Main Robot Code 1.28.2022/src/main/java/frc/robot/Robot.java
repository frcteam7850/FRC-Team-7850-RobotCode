// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.commands.PIDDriveCmd;
//import frc.robot.subsystems.DriveSubsystem;
//import frc.robot.Constants;
//import frc.robot.Constants.ControlCon;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  //private DriveSubsystem driveSubsystem = new DriveSubsystem();

  ////private Joystick leftStick = new Joystick(ControlCon.kLeftStickPort);
  //private Joystick rightStick = new Joystick(ControlCon.kRightStickPort);

  //private boolean PIDActive = false;
  //private boolean PIDActivate = false;
  //private boolean PIDActButton = false;


  //private JoystickButton activatePIDPos1But = new JoystickButton(leftStick, ControlCon.tkActivatePIDPos1But);
  //private JoystickButton activatePIDPos2But = new JoystickButton(leftStick, ControlCon.tkActivatePIDPos2But);
  //private JoystickButton activatePIDPos3But = new JoystickButton(leftStick, ControlCon.tkActivatePIDPos3But);
  //private JoystickButton activatePIDPos4But = new JoystickButton(leftStick, ControlCon.tkActivatePIDPos4But);
  //private JoystickButton deactivatePIDBut = new JoystickButton(leftStick, ControlCon.tkDeactivatePIDBut);
  //private JoystickButton reactivatePIDBut = new JoystickButton(leftStick, ControlCon.tkReactivatePIDBut);

  //private JoystickButton tunePIDkpDecL = new JoystickButton(leftStick,ControlCon.tkTunePIDkpDecL);
  //private JoystickButton tunePIDkpIncL = new JoystickButton(leftStick,ControlCon.tkTunePIDkpIncL);
  //private JoystickButton tunePIDkpDecM = new JoystickButton(leftStick,ControlCon.tkTunePIDkpDecM);
  //private JoystickButton tunePIDkpIncM = new JoystickButton(leftStick,ControlCon.tkTunePIDkpIncM);
  //private JoystickButton tunePIDkpDecS = new JoystickButton(leftStick,ControlCon.tkTunePIDkpDecS);
  //private JoystickButton tunePIDkpIncS = new JoystickButton(leftStick,ControlCon.tkTunePIDkpIncS);

  //private JoystickButton tunePIDkiDecL = new JoystickButton(leftStick,ControlCon.tkTunePIDkiDecL);
  //private JoystickButton tunePIDkiIncL = new JoystickButton(leftStick,ControlCon.tkTunePIDkiIncL);
  //private JoystickButton tunePIDkiDecM = new JoystickButton(leftStick,ControlCon.tkTunePIDkiDecM);
  //private JoystickButton tunePIDkiIncM = new JoystickButton(leftStick,ControlCon.tkTunePIDkiIncM);
  //private JoystickButton tunePIDkiDecS = new JoystickButton(leftStick,ControlCon.tkTunePIDkiDecS);
  //private JoystickButton tunePIDkiIncS = new JoystickButton(leftStick,ControlCon.tkTunePIDkiIncS);

  //private JoystickButton tunePIDkdDecL = new JoystickButton(leftStick,ControlCon.tkTunePIDkdDecL);
  //private JoystickButton tunePIDkdIncL = new JoystickButton(leftStick,ControlCon.tkTunePIDkdIncL);
  //private JoystickButton tunePIDkdDecM = new JoystickButton(leftStick,ControlCon.tkTunePIDkdDecM);
  //private JoystickButton tunePIDkdIncM = new JoystickButton(leftStick,ControlCon.tkTunePIDkdIncM);
  //private JoystickButton tunePIDkdDecS = new JoystickButton(leftStick,ControlCon.tkTunePIDkdDecS);
  //private JoystickButton tunePIDkdIncS = new JoystickButton(leftStick,ControlCon.tkTunePIDkdIncS);

  //private double tunePIDkpLSize = ControlCon.tkTunePIDkpLSize;
  //private double tunePIDkpMSize = ControlCon.tkTunePIDkpMSize;
  //private double tunePIDkpSSize = ControlCon.tkTunePIDkpSSize;

  //private double tunePIDkiLSize = ControlCon.tkTunePIDkiLSize;
  //private double tunePIDkiMSize = ControlCon.tkTunePIDkiMSize;
  //private double tunePIDkiSSize = ControlCon.tkTunePIDkiSSize;

  //private double tunePIDkdLSize = ControlCon.tkTunePIDkdLSize;
  //private double tunePIDkdMSize = ControlCon.tkTunePIDkdMSize;
  //private double tunePIDkdSSize = ControlCon.tkTunePIDkdSSize;




  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
    
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    
  }
}
