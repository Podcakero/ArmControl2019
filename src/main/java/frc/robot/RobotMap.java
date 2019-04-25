/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  /**
   * The CAN ID for the front left drive talon
   */
  public static final int FRONT_LEFT_DRIVE_TALON_ID = 1;
  /**
   * The CAN ID for the front right drive talon 
   */
  public static final int FRONT_RIGHT_DRIVE_TALON_ID = 2;
  /**
   * The CAN ID for the rear left drive talon
   */
  public static final int REAR_LEFT_DRIVE_TALON_ID = 3;
  /**
   * The CAN ID for the rear right drive talon
   */
  public static final int REAR_RIGHT_DRIVE_TALON_ID = 4;

  /**
   * The CAN ID of the left talon controlling the first arm segment
   */
  public static final int FIRST_ARM_SEGMENT_LEFT_TALON_ID = 5;
  /**
   * The CAN ID of the right talon controlling the first arm segment
   */
  public static final int FIRST_ARM_SEGMENT_RIGHT_TALON_ID = 6;

  /**
   * The CAN ID of the left talon controlling the second arm segment
   */
  public static final int SECOND_ARM_SEGMENT_LEFT_TALON_ID = 7;
  /**
   * The CAN ID of the right talon controlling the second arm segment
   */
  public static final int SECOND_ARM_SEGMENT_RIGHT_TALON_ID = 8;

  /**
   * The front left drive talon object
   */
  public static WPI_TalonSRX frontLeftDriveTalon;
  /**
   * The front right drive talon object
   */
  public static WPI_TalonSRX frontRightDriveTalon;
  /**
   * The rear left drive talon object
   */
  public static WPI_TalonSRX rearLeftDriveTalon;
  /**
   * The rear right drive talon object
   */
  public static WPI_TalonSRX rearRightDriveTalon;


  public static SpeedControllerGroup firstSegmentTalons;


  /**
   * This is the drivetrain object which handles the input from the controllers to move a mechanum chassis
   */
  public static MecanumDrive drivetrain;

  /**
   * This is where we instantiate any and all objects, as well as configure specific settings such as PID values and follow modes
   */
  public void init()
  {
    setupDrivetrain();
    setupArm();
  }

  /**
   * This method instantiates the drivetrain motors and sets their parameters
   */
  private void setupDrivetrain()
  {
    frontLeftDriveTalon = new WPI_TalonSRX(FRONT_LEFT_DRIVE_TALON_ID);
    frontRightDriveTalon = new WPI_TalonSRX(FRONT_RIGHT_DRIVE_TALON_ID);
    rearLeftDriveTalon = new WPI_TalonSRX(REAR_LEFT_DRIVE_TALON_ID);
    rearRightDriveTalon = new WPI_TalonSRX(REAR_RIGHT_DRIVE_TALON_ID);

    drivetrain = new MecanumDrive(frontLeftDriveTalon, rearLeftDriveTalon, frontRightDriveTalon, rearRightDriveTalon);
  }

  /**
   * This method instantiates the arm talons and sets their parameters
   */
  private void setupArm()
  {

  }
}
