// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // please note that joysticks for control stick are paired with the control button and that

    public static final class ControlCon{

        public static final int kLeftStickPort = 1;
        public static final int kRightStickPort = 0;

        public static final class Drive{
            public static final boolean kEnableDefaltDrive = true;
            public static final boolean kDefaltDrive = true; //false = tank, true = arcade
            public static final boolean kEnableDriveSwitch = false;

            public static final int kTankDriveBut = 6;
            public static final Joystick sTankDriveBut = new Joystick(kLeftStickPort);

            public static final int kArcadeDriveBut = 9;
            public static final Joystick sArcadeDriveBut = new Joystick(kLeftStickPort);

            public static final int kSpeedDriveAxis = 1;
            public static final int kTurnDriveAxis = 0;
            public static final Joystick sArcadeDrive = new Joystick(kLeftStickPort);
        
            public static final int kLeftDriveAxis = 1;
            public static final int kRightDriveAxis = 1;

            public static final int kStraitDriveBut = 2;
            public static final Joystick sStraitDriveBut = new Joystick(kLeftStickPort);
        }
        public static final class PID{
            public static final int kPIDActiveBut1 = 3;
            public static final Joystick sPIDActiveBut1 = new Joystick(kRightStickPort);

            public static final int kPIDActiveBut2 = 4;
            public static final Joystick sPIDActiveBut2 = new Joystick(kRightStickPort);

            public static final double kPI = 3.14159;
            public static final double mDriveWheelDiaInch = 6;
            public static final double kInchPerFoot = 12;
            public static final double mDriveDistMod = 10;
            public static double mDriveWheelCon = mDriveWheelDiaInch/kInchPerFoot*kPI*mDriveDistMod;
            
            public static final double mAutoDist = 10;
            public static final double mAutoRotation = mAutoDist/mDriveWheelCon;
            public static final double mButton1Dist = 5;
            public static final double mButton1Rotation = mAutoDist/mButton1Dist;
            public static final double mButton2Dist = -5;
            public static final double mButton2Rotation = mAutoDist/mButton2Dist;
        }
      public static final class Intake{
        public static final int lowerIntakeBut = 5;
        public static final int raiseIntakeBut = 6;
        public static final int intakeInBut = 7;
        public static final int intakeOutBut = 8;
      }
        
    }
    public static final class RobotPort{
        public static final int kLeftMotor1Port = 3;
        public static final int kLeftMotor2Port = 4;
        public static final int kRightMotor1Port = 1;
        public static final int kRightMotor2Port = 2;

        public static final int kFlyMotor1 = 6;
        public static final int kFlyMotor2 = 5;

        /*
        things to add

        will have 1 NEO motor for intake arm with a gearbox and spark max motor controller
        
        pneumatics

        1 double solinoid connected to two pistons for rasing and lowering intake arm
        */

        //public static final int kPDHubPort = 11; //power distrubution hub
        public static final int kPSHubPort = 12; //pnumatics hub
    }

    public static final class DriveCon{
        public static final double kTurnValue = 0.6;
        public static final boolean kInvertTurn = false;

        public static final double kMaxSpeed = 0.8;
        public static final double kLeftSpeedMod = 1;
        public static final double kRightSpeedMod = 1; //.9752 fir old robot

        public static final boolean kLeftMotorInvert = false;
        public static final boolean kRightMotorInvert = true;

        public static final double kEncoderConversion = 0.0373999125427; //feet per encoder tick
    
        public static final class PIDCon{
            public static double kP = 0.3;
            public static double kI = 0;
            public static double kD = 0;

            //public static double kIZone = 100;

            public static double ksetpoint = 10;
        
            public static double kMaxOutput = 0.2;
            public static double kMinOutput = -0.2;
        }
    }
    public static final class FlyCon{
        public static final class Motors{
            public static final boolean kMotor1Invert = true;
            public static final boolean kMotor2Invert = true;
            public static final boolean kMotorDiffrenceInvert = kMotor1Invert ^ kMotor2Invert;
        }
        public static final class DiffPID{

        }
        public static final class VelPID{
            public static final double kP = 0.5;
            public static final double kI = 0;
            public static final double kD = 0;

        }
        public static final class VelZones{
            public static final double idleRPM = 10;
            public static final double minWarmRPM = 85;
            public static final double maxWarmRPM = 95;
            public static final double minTargetRPM = 100;
            public static final double maxTargetRPM = 180;
            public static final double core1RPM = 110;
            public static final double core2RPM = 140;
            public static final double core3RPM = 150;
        }

    }

    public static final class IntakeCon{
      public static final int kIntakeMotorCanID = 7;
      public static final int kIntakeSolenoidForwardPort = 8;
      public static final int kIntakeSolenoidReversePort = 9;
      public static final double kIntakeSpeed = 0.2;
    }
    




    //unit converstion below
















    public static final class UnitConversion{

        public static final class custom{

            public static final double RPMVoltageConversionFactor = 1;

            public static final double RPMToVoltageConverter(double varable){
                varable = varable*RPMVoltageConversionFactor;
                return varable;
            }
        }
        public static final class length{

            public static final double cFootMeter = 3.28084;
            public static final double cMileKilo = 1.60934;

            public static final double MeterToFeet(double meters){
                double feet = meters*cFootMeter;
                return feet;
            }
            public static final double FeetToMeter(double feet){
                double meters = feet/cFootMeter;
                return meters;
            }
        }
        public static final class angle{

            public static final double cDegRad = 57.2958;
            public static final double cGradDeg = 1.11111;
            public static final double cMinDeg = 60;
            public static final double cMinGrad = 54;
            public static final double cMinRad = 3437.75;
            public static final double cGradRad = 63.662;

            public static double DegToRad(double degrees){
                double radians = degrees/cDegRad;
                return radians;
            }
            public static double RadToDeg(double radians){
                double degrees = radians*cDegRad;
                return degrees;
            }
        }
        
    }
}
