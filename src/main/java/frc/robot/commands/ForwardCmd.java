package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;

public class ForwardCmd extends CommandBase{
    private final DriveSubsystem driveSubsystem;
    private final double distance;
    private double encoderSetpoint;

    public ForwardCmd(DriveSubsystem driveSubsystem, double distance) {
        this.driveSubsystem = driveSubsystem;
        this.distance = distance;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        encoderSetpoint = driveSubsystem.getEncoderMeters() + distance;
        System.out.println("Drive start");
    }

    @Override
    public void execute() {
        driveSubsystem.setMotors(0.5, 0.5);
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.setMotors(0, 0);
        System.out.println("Drive ended");
    }

    @Override
    public boolean isFinished() {
        if (driveSubsystem.getEncoderMeters() > encoderSetpoint){
            return true;
        }
        else {
            return false;
        }
    }
}
