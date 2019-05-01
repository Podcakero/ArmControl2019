/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.File;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TestPresetsCommand extends InstantCommand 
{
  /**
   * Add your docs here.
   */
  public TestPresetsCommand() 
  {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() 
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

    //Try and create a filewriter that appends for the armpresets file. If it doesn't work, print out the exception
    try 
    {
      FileWriter armPresetsWriter = new FileWriter(Filesystem.getDeployDirectory().listFiles(filter)[0], true);  
    
      //Try and add the data from the encoders to the file.
      try 
      {
        //Write the encoder values to the armpresets file in this format:
        // int1 int2 int3 int4
        armPresetsWriter.write("\n" + 5 + " " 
                        + 4 + " " 
                        + 3 + " " 
                        + 2 + " NewPreset" + RobotMap.armPresets.size());
      }
      catch (IOException e)
      {
        System.out.println(e);
      }   
      //Close the writer and save the file
      armPresetsWriter.close();
      //Updates the presets on shuffleboard
      RobotMap.updatePresets();
    } 
    catch (IOException e) 
    {
      System.out.println(e);
    }
  }

  /**
   * Tests this command without having to use the scheduler
   */
  public void test()
  {
    initialize();
  }

}
