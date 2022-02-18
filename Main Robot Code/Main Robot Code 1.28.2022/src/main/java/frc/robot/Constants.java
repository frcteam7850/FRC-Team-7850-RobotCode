// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class ControlCon{
        public static final int kLeftStickPort = 1;
        public static final int kRightStickPort = 0;
        
        public static final int kLeftDriveAxis = 1;
        public static final int kRightDriveAxis = 1;

        public static final int kPIDActiveBut = 7;


        //PID tuning controls durring test
        public static final int tkActivatePIDPos1But = 7;//Port
        public static final int tkActivatePIDPos2But = 7;//Port
        public static final int tkActivatePIDPos3But = 7;//Port
        public static final int tkActivatePIDPos4But = 7;//Port
        public static final int tkDeactivatePIDBut = 7;//Port
        public static final int tkReactivatePIDBut = 7;//Port

        public static final int tkTunePIDkpDecL = 7;//Port
        public static final int tkTunePIDkpIncL = 7;//Port
        public static final int tkTunePIDkpDecM = 7;//Port
        public static final int tkTunePIDkpIncM = 7;//Port
        public static final int tkTunePIDkpDecS = 7;//Port
        public static final int tkTunePIDkpIncS = 7;//Port

        public static final int tkTunePIDkiDecL = 7;//Port
        public static final int tkTunePIDkiIncL = 7;//Port
        public static final int tkTunePIDkiDecM = 7;//Port
        public static final int tkTunePIDkiIncM = 7;//Port
        public static final int tkTunePIDkiDecS = 7;//Port
        public static final int tkTunePIDkiIncS = 7;//Port

        public static final int tkTunePIDkdDecL = 7;//Port
        public static final int tkTunePIDkdIncL = 7;//Port
        public static final int tkTunePIDkdDecM = 7;//Port
        public static final int tkTunePIDkdIncM = 7;//Port
        public static final int tkTunePIDkdDecS = 7;//Port
        public static final int tkTunePIDkdIncS = 7;//Port

        public static final double tkTunePIDkpLSize = 1;//large kp scale
        public static final double tkTunePIDkpMSize = 0.1;//medium kp scale
        public static final double tkTunePIDkpSSize = 0.01;//small kp scale

        public static final double tkTunePIDkiLSize = 0.1;//large ki scale
        public static final double tkTunePIDkiMSize = 0.01;//medium ki scale
        public static final double tkTunePIDkiSSize = 0.001;//small ki scale

        public static final double tkTunePIDkdLSize = 0.1;//large kd scale
        public static final double tkTunePIDkdMSize = 0.01;//medium kd scale
        public static final double tkTunePIDkdSSize = 0.001;//small kd scale
    }
    public static final class RobotPort{
        public static final int kLeftMotor1Port = 1;
        public static final int kLeftMotor2Port = 2;
        public static final int kRightMotor1Port = 3;
        public static final int kRightMotor2Port = 4;

        public static final int kPDHubPort = 11; //power distrubution hub
        public static final int kPSHubPort = 12; //pnumatics hub
    }

    public static final class DriveCon{
        public static final double kMaxSpeed = 0.8;
        public static final double kLeftSpeedMod = 1;
        public static final double kRightSpeedMod = -1;

        public static final double kEncoderConversion = 0.0373999125427; //feet per encoder tick
    }
}
