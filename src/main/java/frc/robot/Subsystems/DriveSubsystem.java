package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private final CANSparkMax m_leftDriveMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_rightDriveMotor = new CANSparkMax(0, MotorType.kBrushless);
    private RelativeEncoder m_leftEncoder = m_leftDriveMotor.getEncoder();
    private RelativeEncoder m_rightEncoder = m_rightDriveMotor.getEncoder();
    private double kEncoderTick2Meter = 1.0 / 4096.0 * 0.128 * Math.PI;

    public double getEncoderMeters() {
        return (((CANSparkMax) m_leftEncoder).get() + -((CANSparkMax) m_rightEncoder).get()) / 2 * kEncoderTick2Meter;
    }
    public DriveSubsystem() {
        m_leftDriveMotor.setInverted(false);
        m_rightDriveMotor.setInverted(true);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Driving Encoder: ", getEncoderMeters());
    }
    
    public void setMotors(double leftSpeed, double rightSpeed) {
        m_leftDriveMotor.set(leftSpeed);
        m_rightDriveMotor.set(-rightSpeed);
    }
}
