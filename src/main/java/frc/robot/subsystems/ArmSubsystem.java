/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ArmSubsystem extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /**
   * Moves the arm to the given encoder values. Use -1 for no movement
   * @param firstSegment The econder value to move the first arm to
   * @param secondSegment The encoder value to move the second arm to
   * @param wrist The encoder value to move the wrist to
   * @param gimbal The encoder value to move the gimbal base to
   */
  public void moveArmByEncoderAbsolute(double firstSegment, double secondSegment, double wrist, double gimbal)
  {
    if (firstSegment >= 0.0)
      RobotMap.firstArmSegmentSubsystem.setSetpoint(firstSegment);
    if (secondSegment >= 0.0)
      RobotMap.secondArmSegmentSubsystem.setSetpoint(secondSegment);
    if (wrist >= 0.0)
      RobotMap.wristSubsystem.setSetpoint(wrist);
    if (gimbal >= 0.0)
      RobotMap.gimbalSubsystem.setSetpoint(gimbal);
  }

  /**
   * Moves the arm by the given encoder values. Use 0 for no movement
   */
  public void moveArmByEncoderRelative(double firstSegment, double secondSegment, double wrist, double gimbal)
  {
    RobotMap.firstArmSegmentSubsystem.setSetpointRelative(firstSegment);
    RobotMap.secondArmSegmentSubsystem.setSetpointRelative(secondSegment);
    RobotMap.wristSubsystem.setSetpointRelative(wrist);
    RobotMap.gimbalSubsystem.setSetpointRelative(gimbal);
  }
}
