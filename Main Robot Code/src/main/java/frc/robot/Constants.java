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
            public static final boolean kDefaltDrive = false; //false = tank, true = arcade
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
        
    }
    public static final class RobotPort{
        public static final int kLeftMotor1Port = 3;
        public static final int kLeftMotor2Port = 4;
        public static final int kRightMotor1Port = 1;
        public static final int kRightMotor2Port = 2;

        //public static final int kPDHubPort = 11; //power distrubution hub
        //public static final int kPSHubPort = 12; //pnumatics hub
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
    }
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
