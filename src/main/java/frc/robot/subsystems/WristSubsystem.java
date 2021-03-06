/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * This subsystem controls the Wrist... WOW
 */
public class WristSubsystem extends PIDSubsystem 
{
  /**
   * This is the constructor for the wrist subsystem, the PID values should be put in here. 
   * @param P The proportional gain 
   * @param I The integral gain
   * @param D The derivative gain
   */
  public WristSubsystem(double P, double I, double D) 
  {
    // Intert a subsystem name and PID values here
    super("Wrist Subsystem", P, I, D);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() 
  {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return RobotMap.wristTalon.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) 
  {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    RobotMap.wristTalon.set(output);
  }
}
