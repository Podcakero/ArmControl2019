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
 * This subsystem controls all aspects of the arm. This is where you move the arm's different segments.
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
    //Only move the arm if the encoder value is >= 0.0
    if (firstSegment >= 0.0)
      RobotMap.firstArmSegmentSubsystem.setSetpoint(firstSegment);
    if (secondSegment >= 0.0)
      RobotMap.secondArmSegmentSubsystem.setSetpoint(secondSegment);
    if (wrist >= 0.0)
      RobotMap.wristSubsystem.setSetpoint(wrist);
    if (gimbal >= 0.0)
      RobotMap.gimbalSubsystem.setSetpoint(gimbal);

    //Enable the PID Loop
    RobotMap.firstArmSegmentSubsystem.enable();
    RobotMap.secondArmSegmentSubsystem.enable();
    RobotMap.wristSubsystem.enable();
    RobotMap.gimbalSubsystem.enable();
  }

  /**
   * Moves the arm by the given encoder values. Use 0 for no movement
   * @param firstSegment Amount (in encoder ticks) to move the first segment by
   * @param secondSegment Amount (in encoder ticks) to move the second segment by
   * @param wrist Amount (in encoder ticks) to move the wrist by
   * @param gimbal Amount (in encoder ticks) to to move the gimbal by
   */
  public void moveArmByEncoderRelative(double firstSegment, double secondSegment, double wrist, double gimbal)
  {
    //Set the target for the segments
    RobotMap.firstArmSegmentSubsystem.setSetpointRelative(firstSegment);
    RobotMap.secondArmSegmentSubsystem.setSetpointRelative(secondSegment);
    RobotMap.wristSubsystem.setSetpointRelative(wrist);
    RobotMap.gimbalSubsystem.setSetpointRelative(gimbal);

    //Enable the PID Loop
    RobotMap.firstArmSegmentSubsystem.enable();
    RobotMap.secondArmSegmentSubsystem.enable();
    RobotMap.wristSubsystem.enable();
    RobotMap.gimbalSubsystem.enable();
  }

  /**
   * Moves the arm at the given speed (-1 <-> 1. -1 being full reverse, 1 being full forward, 0 being stop)
   * @param firstSegment The speed to move the first segment at
   * @param secondSegment The speed to move the second segment at
   * @param wrist The speed to move the wrist at
   * @param gimbal The sped to move the gimbal at
   */
  public void moveArmAtSpeed(double firstSegment, double secondSegment, double wrist, double gimbal)
  {
    // Since we're not giving it encoder values, we need to disable it so it doesn't attempt to stay in one place
    RobotMap.firstArmSegmentSubsystem.disable();
    RobotMap.secondArmSegmentSubsystem.disable();
    RobotMap.wristSubsystem.disable();
    RobotMap.gimbalSubsystem.disable();

    //Set the speed of the segments
    RobotMap.firstArmSegmentLeftTalon.set(firstSegment);
    RobotMap.secondArmSegmentLeftTalon.set(secondSegment);
    RobotMap.wristTalon.set(wrist);
    RobotMap.gimbalTalon.set(gimbal);
  }
}
