// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.commands.ForwardCmd;

public class RobotContainer {
  private DriveSubsystem driveSubsystem = new DriveSubsystem();
  
  public RobotContainer() {

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new ForwardCmd(driveSubsystem, 1.5)
    );
  }
}
