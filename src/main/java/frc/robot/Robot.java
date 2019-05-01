/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.*;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commandgroups.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  /**
   * This object writes data to the armpresets.txt file
   */
  private static FileWriter armPresetsWriter;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    //Initialise all of our stuff OwO
    RobotMap.init();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() 
  {
  }

  @Override
  public void disabledPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() 
  {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() 
  {
    new ControlCommandGroup().start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called the first time test mode uns
   */
  @Override
  public void testInit()
  {
    //Make sure we can move the arm
    new ControlCommandGroup().start();

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

    //Try and create a filewriter that appends for the armpresets file. If it doesn't work, print out the exception
    try 
    {
      armPresetsWriter = new FileWriter(Filesystem.getDeployDirectory().listFiles(filter)[0], true);  
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {
    Scheduler.getInstance().run();

    // If the user presses the xbutton while in test mode, save the arms encoder values to the armpresets.txt file
    if (RobotMap.assistantDriverController.getXButtonPressed())
    {
      //Try and add the data from the encoders to the file.
      try 
      {
        //Write the encoder values to the armpresets file in this format:
        // int1 int2 int3 int4
        armPresetsWriter.write("\n" + RobotMap.firstArmSegmentLeftTalon.getSelectedSensorPosition() + " " 
                        + RobotMap.secondArmSegmentLeftTalon.getSelectedSensorPosition() + " " 
                        + RobotMap.wristTalon.getSelectedSensorPosition() + " " 
                        + RobotMap.gimbalTalon.getSelectedSensorPosition() + " new preset");
        //Updates the presets on shuffleboard
        RobotMap.updatePresets();
      }
      catch (IOException e)
      {
        System.out.println(e);
      }   
    }
  }

  /**
   * @return The FileWriter object that correlates to the armpresets.txt file
   */
  public static FileWriter getArmPresets()
  {
    return armPresetsWriter;
  }
}
