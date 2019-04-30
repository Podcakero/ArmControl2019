/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.*;
import frc.robot.frc2890classes.ArmPositionPreset;
import frc.robot.frc2890classes.USBButton;
import frc.robot.subsystems.*;

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
   * The CAN ID of the wrist talon
   */
  public static final int WRIST_TALON_ID = 9;
  /**
   * The CAN ID of the gimbal/rotating base talon
   */
  public static final int GIMBAL_TALON_ID = 10;

  /** 
   * The ID of the forward port on the grabber solenoid
  */
  public static final int GRABBER_SOLENOID_FORWARD_PORT = 0;
  /**
   * The ID of the reverse port on the grabber solenoid
   */
  public static final int GRABBER_SOLENOID_REVERSE_PORT = 1;

  /**
   * The port which the Driver Station reports as connected to the driver controller
   */
  public static final int DRIVER_CONTROLLER_PORT = 0; //Not sure if we're using an xbox or dual-joysticks yet
  /**
   * The port which the Driver Station reports as connected to the assistant driver controller
   */
  public static final int ASSISTANT_DRIVER_CONTROLLER_PORT = 1;

  /**
   * The port which the Driver Station reports as connected to the Left Joystick
   */
  public static final int FIRST_ARM_SEGMENT_JOYSTICK_PORT = 2;
  /**
   * The port which the Driver Station reports as connected to the Centre Joystick
   */
  public static final int SECOND_ARM_SEGMENT_JOYSTICK_PORT = 3;
  /**
   * The port which the Driver Station reports as connected to the Right Joystick
   */
  public static final int WRIST_JOYSTICK_PORT = 4;
  /**
   * The port which the Driver Station reports as connected to the Left Small Button
   */
  public static final int GIMBAL_LEFT_BUTTON_PORT = 5;
  /**
   * The port which the Driver Station reports as conected to the Giant Centre button
   */
  public static final int GRABBER_BUTTON_PORT = 6;
  /**
   * The port which the Driver Station reports as connected to the Right s=Small button
   */
  public static final int GIMBAL_RIGHT_BUTTON_PORT = 7;

  /**
   * The Proportional value for the PID Loop <br>
   * This is a number which is multiplied by the error (the setpoint - the current value) to determine the speed
   */
  public static final double FIRST_ARM_SEGMENT_P = 0.0;
  /**
   * The Integral value for the PID Loop <br>
   * This value is the accumulation of the SP (setpoint) - PV (current value) and is added to determine speed
   */
  public static final double FIRST_ARM_SEGMENT_I = 0.0;
  /**
   * The Derivative value for the PID Loop <br>
   * This value is an estimate for the current trend, based on its RoC (Rate of Change)
   */
  public static final double FIRST_ARM_SEGMENT_D = 0.0;
  /**
   * The Proportional value for the PID Loop <br>
   * This is a number which is multiplied by the error (the setpoint - the current value) to determine the speed
   */
  public static final double SECOND_ARM_SEGMENT_P = 0.0;
  /**
   * The Integral value for the PID Loop <br>
   * This value is the accumulation of the SP (setpoint) - PV (current value) and is added to determine speed
   */
  public static final double SECOND_ARM_SEGMENT_I = 0.0;
  /**
   * The Derivative value for the PID Loop <br>
   * This value is an estimate for the current trend, based on its RoC (Rate of Change)
   */
  public static final double SECOND_ARM_SEGMENT_D = 0.0;
  /**
   * The Proportional value for the PID Loop <br>
   * This is a number which is multiplied by the error (the setpoint - the current value) to determine the speed
   */
  public static final double WRIST_P = 0.0;
  /**
   * The Integral value for the PID Loop <br>
   * This value is the accumulation of the SP (setpoint) - PV (current value) and is added to determine speed
   */
  public static final double WRIST_I = 0.0;
  /**
   * The Derivative value for the PID Loop <br>
   * This value is an estimate for the current trend, based on its RoC (Rate of Change)
   */
  public static final double WRIST_D = 0.0;
  /**
   * The Proportional value for the PID Loop <br>
   * This is a number which is multiplied by the error (the setpoint - the current value) to determine the speed
   */
  public static final double GIMBAL_P = 0.0;
  /**
   * The Integral value for the PID Loop <br>
   * This value is the accumulation of the SP (setpoint) - PV (current value) and is added to determine speed
   */
  public static final double GIMBAL_I = 0.0;
  /**
   * The Derivative value for the PID Loop <br>
   * This value is an estimate for the current trend, based on its RoC (Rate of Change)
   */
  public static final double GIMBAL_D = 0.0;

  /**
   * The value which the trigger needs to exceed before we start sending values.
   */
  public static final double TRIGGER_DEADBAND = 0.01;

  /**
   * The speed at which the gimbal will move
   */
  public static final double GIMBAL_SPEED = 1.0;

  /**
   * This ArrayList contains every user-defined arm position preset
   */
  public static ArrayList<ArmPositionPreset> armPresets;

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

  /**
   * The left talon controlling the first arm segment
   */
  public static WPI_TalonSRX firstArmSegmentLeftTalon;
  /**
   * The right talon controlling the first arm segment
   */
  public static WPI_TalonSRX firstArmSegmentRightTalon;
  /**
   * The left talon controlling the second arm segment
   */
  public static WPI_TalonSRX secondArmSegmentLeftTalon;
  /**
   * The right talon controlling the second arm segment
   */
  public static WPI_TalonSRX secondArmSegmentRightTalon;
  /**
   * The wrist talon object
   */
  public static WPI_TalonSRX wristTalon;
  /**
   * The talon for the rotating base
   */
  public static WPI_TalonSRX gimbalTalon;

  /**
   * The grabber solenoid
   */
  public static DoubleSolenoid grabberSolenoid;

  /**
   * This is the drivetrain object which handles the input from the controllers to move a mechanum chassis
   */
  public static MecanumDrive drivetrain;

  /**
   * The main driver controller which controls the robot
   */
  public static XboxController driverController;
  /**
   * The assistant driver controller which controls the arm
   */
  public static XboxController assistantDriverController;

  /**
   * The dedicated joystick (located on the left) which controls the first arm segment
   */
  public static Joystick firstArmSegmentJoystick;
  /**
   * The dedicated joystick (located in the centre) which controls the second arm segment
   */
  public static Joystick secondArmSegmentJoystick;
  /**
   * The dedicated joystick (located on the right) which controls the wrist
   */
  public static Joystick wristJoystick;
  /**
   * The dedicated button (on the left) which moves the gimbal left
   */
  public static USBButton leftGimbalButton;
  /**
   * The dedicated button (in the centre) which actuates the grabber
   */
  public static USBButton grabberButton;
  /**
   * The dedicated button (on the right) which moved the gimbal right
   */
  public static USBButton rightGimbalButton;

  /**
   * The subsystem which contains the methods to move the arm
   */
  public static ArmSubsystem armSubsystem;
  /**
   * This subsystem contains the PID Loop to control the first subsystem
   */
  public static FirstArmSegmentSubsystem firstArmSegmentSubsystem;
  /**
   * This subsystem contains the PID Loop to control the second segment
   */
  public static SecondArmSegmentSubsystem secondArmSegmentSubsystem;
  /**
   * This subsystem contains the PID Loop to control the wrist
   */
  public static WristSubsystem wristSubsystem;
  /**
   * This subsystem contains the PID Loop to control the gimbal
   */
  public static GimbalSubsystem gimbalSubsystem;

  /**
   * This subsystem controls all the control schemes for the robot
   */
  public static ControlSubsystem controlSubsystem;

  /**
   * This flag is used to determine which state the grabber is in. True = grabbed, false = release
   */
  public static boolean grabberIsGrabbed = true;

  /**
   * This is where we instantiate any and all objects, as well as configure specific settings such as PID values and follow modes
   */
  public static void init()
  {
    setupDrivetrain();
    setupArm();
    initSubsystems();
    initContollers();
    setupPresets();
  }

  /**
   * This method instantiates the drivetrain motors and sets their parameters
   */
  private static void setupDrivetrain()
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
  private static void setupArm()
  {
    firstArmSegmentLeftTalon = new WPI_TalonSRX(FIRST_ARM_SEGMENT_LEFT_TALON_ID);
    firstArmSegmentRightTalon = new WPI_TalonSRX(FIRST_ARM_SEGMENT_RIGHT_TALON_ID);
    secondArmSegmentLeftTalon = new WPI_TalonSRX(SECOND_ARM_SEGMENT_LEFT_TALON_ID);
    secondArmSegmentRightTalon = new WPI_TalonSRX(SECOND_ARM_SEGMENT_RIGHT_TALON_ID);

    wristTalon = new WPI_TalonSRX(WRIST_TALON_ID);
    gimbalTalon = new WPI_TalonSRX(GIMBAL_TALON_ID);

    //Need to add encoders to all talons 

    grabberSolenoid = new DoubleSolenoid(GRABBER_SOLENOID_FORWARD_PORT, GRABBER_SOLENOID_REVERSE_PORT);

    //Set the secondary motors to follow any commands given to the primary motors
    firstArmSegmentRightTalon.follow(firstArmSegmentLeftTalon);
    secondArmSegmentRightTalon.follow(secondArmSegmentLeftTalon);
  }

  /**
   * Instantiates the subsystems
   */
  private static void initSubsystems()
  {
    armSubsystem = new ArmSubsystem();

    firstArmSegmentSubsystem = new FirstArmSegmentSubsystem(FIRST_ARM_SEGMENT_P, FIRST_ARM_SEGMENT_I, FIRST_ARM_SEGMENT_D);
    secondArmSegmentSubsystem = new SecondArmSegmentSubsystem(SECOND_ARM_SEGMENT_P, SECOND_ARM_SEGMENT_I, SECOND_ARM_SEGMENT_D);
    wristSubsystem = new WristSubsystem(WRIST_P, WRIST_I, WRIST_D);
    gimbalSubsystem = new GimbalSubsystem(GIMBAL_P, GIMBAL_I, GIMBAL_D);

    controlSubsystem = new ControlSubsystem();
  }

  /**
   * Instantiates the controllers and buttons
   */
  private static void initContollers()
  {
    driverController = new XboxController(DRIVER_CONTROLLER_PORT);
    assistantDriverController = new XboxController(ASSISTANT_DRIVER_CONTROLLER_PORT);

    firstArmSegmentJoystick = new Joystick(FIRST_ARM_SEGMENT_JOYSTICK_PORT);
    secondArmSegmentJoystick = new Joystick(SECOND_ARM_SEGMENT_JOYSTICK_PORT);
    wristJoystick = new Joystick(WRIST_JOYSTICK_PORT);
    leftGimbalButton = new USBButton(GIMBAL_LEFT_BUTTON_PORT);
    grabberButton = new USBButton(GRABBER_BUTTON_PORT);
    rightGimbalButton = new USBButton(GIMBAL_RIGHT_BUTTON_PORT);
  }

  /**
   * Grabs and creates presets from the armpresets.txt file on the robot
   */
  private static void setupPresets()
  {
    //Create a filenameFilter for the filename "armpresets.txt"
    FilenameFilter filter = new FilenameFilter()
    {
      /**
       * Accept only the file that meets the given criteria. In this case, only files with names matching "armpresets.txt"
       * @param arg0 The file path of the file
       * @param arg1 The filename of the file
       * @return true if arg1 equals "armpresets.txt"
       */
      @Override
      public boolean accept(File arg0, String arg1) 
      {
        return arg1.equalsIgnoreCase("armpresets.txt");
      }
    };

    //Create a scanner utilising the file name armpresets.txt in the robot code deploy directory. I know it's complicated... but it works
    Scanner scan = new Scanner(Filesystem.getDeployDirectory().list(filter)[0]);

    //Create new presets from each row of values in the armpresets file.
    while (scan.hasNextLine())
    {
      int arg0 = scan.nextInt();
      int arg1 = scan.nextInt();
      int arg2 = scan.nextInt();
      int arg3 = scan.nextInt();
      armPresets.add(new ArmPositionPreset(arg0, arg1, arg2, arg3));
      scan.nextLine();
    }
  }
}
