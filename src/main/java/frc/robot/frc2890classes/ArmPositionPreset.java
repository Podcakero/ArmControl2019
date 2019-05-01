/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.frc2890classes;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;

/**
 * This class holds the encoder values for a specific position for the arm. These can be called to automatically move the arm to a set position
 */
public class ArmPositionPreset extends InstantCommand
{
    /**
     * This is the array of 4 encoder values corresponding to the: <br>
     * First segment <br>
     * Second segment <br>
     * wrist <br>
     * gimbal
     */
    private int[] encoderValues = new int[4];

    /**
     * Creates a new ArmPositionPreset object with the given encoder values.
     * @param firstSegment The encoder value the first segment should be moved to
     * @param secondSegment The encoder value the second segment should be moved to
     * @param wrist The encoder value the wrist should be moved to
     * @param gimbal The encoder value the gimbal should be moved to
     */
    public ArmPositionPreset(int firstSegment, int secondSegment, int wrist, int gimbal, String name)
    {
        //set the name of this preset
        super(name);
        encoderValues[0] = firstSegment;
        encoderValues[1] = secondSegment;
        encoderValues[2] = wrist;
        encoderValues[3] = gimbal;
    }

    /**
     * Creates a new ArmPositionPreset from an array of encoder values
     * @param values The array of 4 encoder values corresponding to (in this order)<br>
     * The first segment, second segment, wrist, gimbal
     * @param name The name of this preset
     */
    public ArmPositionPreset(int[] values, String name)
    {
        this(values[0], values[1], values[2], values[3], name);
    }

    /**
     * Moves the arm to this preset's position.
     */
    public void intitialise()
    {
        RobotMap.armSubsystem.moveArmByEncoderAbsolute(encoderValues[0], encoderValues[1], encoderValues[2], encoderValues[3]);
    }
}
