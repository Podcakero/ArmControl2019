/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.frc2890classes;

import edu.wpi.first.wpilibj.GenericHID;

/**
 * This class is to be used with generic USB conncted physical buttons.
 */
public class USBButton extends GenericHID
{
    /**
     * Constructs a new USBButton object with the given port
     * @param port The port which the button is plugged into
     */
    public USBButton(int port)
    {
        super(port);
    }

    /**
     * This method returns 0.0 as it is required by the GenericHID interface
     */
    public double getY(Hand hand)
    {
        return 0.0;
    }

    /**
     * This method returns 0.0 as it is required by the GenericHID interface
     */
    public double getX(Hand hand)
    {
        return 0.0;
    }

    /**
     * Returns the value of the button (true for pressed)
     * @return boolean
     */
    public boolean get()
    {
        return super.getRawButton(1);
    }

    /**
     * Whether the button was pressed since the last check
     */
    public boolean getButtonPressed()
    {
        return super.getRawButtonPressed(1);
    }

    /**
     * Whether the button was released since the last check
     */
    public boolean getButtonReleased()
    {
        return super.getRawButtonReleased(1);
    }
}
