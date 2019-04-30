/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.frc2890classes;

import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ArmPositionPreset 
{
    private int[] encoderValues = new int[4];

    /**
     * Creates a new ArmPositionPreset object with the given encoder values.
     * @param firstSegment The encoder value the first segment should be moved to
     * @param secondSegment The encoder value the second segment should be moved to
     * @param wrist The encoder value the wrist should be moved to
     * @param gimbal The encoder value the gimbal should be moved to
     */
    public ArmPositionPreset(int firstSegment, int secondSegment, int wrist, int gimbal)
    {
        encoderValues[0] = firstSegment;
        encoderValues[1] = secondSegment;
        encoderValues[2] = wrist;
        encoderValues[3] = gimbal;
    }

    /**
     * Moves the arm to this preset's position.
     */
    public void run()
    {
        RobotMap.armSubsystem.moveArmByEncoderAbsolute(encoderValues[0], encoderValues[1], encoderValues[2], encoderValues[3]);
    }
}
