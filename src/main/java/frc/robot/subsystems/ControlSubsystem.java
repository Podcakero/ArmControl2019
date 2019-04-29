/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * This subsystem contains all the controls for the robot. Basically the OI (Operator Interface) for the drivers
 */
public class ControlSubsystem extends Subsystem 
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
   * This control scheme should be used ONLY by an experienced driver or at competition. <br>
   * The left joystick controls the First arm segment <br>
   * The right joysticks controls the second arm segment <br>
   * The left and right triggers control the wrist <br>
   * The left and right bumpers control the gimbal <br>
   * The A-Button actuates the grabber <br>
   */
  public void demoModeArmControl()
  {
    //Wrist value
      //If the left trigger is pressed, move the wrist forwards. If the right is pressed, move it backwards. Negative value = backwads
      double wrist = 0.0;
      if (RobotMap.assistantDriverController.getTriggerAxis(Hand.kLeft) >= RobotMap.TRIGGER_DEADBAND)
        wrist = RobotMap.assistantDriverController.getTriggerAxis(Hand.kLeft);
      else if (RobotMap.assistantDriverController.getTriggerAxis(Hand.kRight) >= RobotMap.TRIGGER_DEADBAND)
        wrist = -RobotMap.assistantDriverController.getTriggerAxis(Hand.kRight);

    //Gimbal value
      //If the left bumper is pressed, rotate the base left. If the right is pressed, rotate the base right. Negative value = right
      double gimbal = 0.0;
      if (RobotMap.assistantDriverController.getBumper(Hand.kLeft))
        gimbal = RobotMap.GIMBAL_SPEED;
      else if (RobotMap.assistantDriverController.getBumper(Hand.kRight));
        gimbal = -RobotMap.GIMBAL_SPEED;

    //Grabber
      //When the a-button is pressed, switch between grabbing and releasing.
      if (RobotMap.assistantDriverController.getAButtonPressed())
      {
        if (RobotMap.grabberIsGrabbed)
          RobotMap.grabberSolenoid.set(Value.kReverse);
        else
          RobotMap.grabberSolenoid.set(Value.kForward);
        
        //Invert the flag
        RobotMap.grabberIsGrabbed = !RobotMap.grabberIsGrabbed;
      }

    //Move the arm
    RobotMap.armSubsystem.moveArmAtSpeed(
      RobotMap.assistantDriverController.getY(Hand.kLeft), 
      RobotMap.assistantDriverController.getY(Hand.kRight), 
      wrist, 
      gimbal);
  }

  /**
   * This control mode is meant to be used by inexperienced drivers in a hands-on scenario <br>
   * The left joystick controls the first arm segment <br>
   * The centre joystick controls the second arm segment <br>
   * The right joystick controls the wrist <br>
   * The small left/right dedicated buttons control the gimbal <br>
   * The giant centre button controls the Grabber <br>
   */
  public static void handsOnDemoModeArmControl()
  {
    double gimbal = 0.0;
    if (RobotMap.leftGimbalButton.get())
      gimbal = RobotMap.GIMBAL_SPEED;
    else if (RobotMap.rightGimbalButton.get())
      gimbal = -RobotMap.GIMBAL_SPEED;

    if (RobotMap.grabberButton.getButtonPressed())
    {
      if (RobotMap.grabberIsGrabbed)
        RobotMap.grabberSolenoid.set(Value.kReverse);
      else
        RobotMap.grabberSolenoid.set(Value.kForward);
      
      //Invert the flag
      RobotMap.grabberIsGrabbed = !RobotMap.grabberIsGrabbed;
    }

    RobotMap.armSubsystem.moveArmAtSpeed(
      RobotMap.firstArmSegmentJoystick.getY(),
      RobotMap.secondArmSegmentJoystick.getY(),
      RobotMap.wristJoystick.getY(),
      gimbal);
  }

  /**
   * Moves the drivetrain based on the values of joysticks from the driver controller
   */
  public void xboxDrivetrainControl()
  {
    double rotation = 0.0;
    if (RobotMap.driverController.getTriggerAxis(Hand.kLeft) >= RobotMap.TRIGGER_DEADBAND)
      rotation = -RobotMap.driverController.getTriggerAxis(Hand.kLeft);
    else if (RobotMap.driverController.getTriggerAxis(Hand.kRight) >= RobotMap.TRIGGER_DEADBAND)
      rotation = RobotMap.driverController.getTriggerAxis(Hand.kRight);

    RobotMap.drivetrain.driveCartesian(
      RobotMap.driverController.getY(Hand.kRight), 
      RobotMap.driverController.getX(Hand.kLeft), 
      rotation);
  }
}
