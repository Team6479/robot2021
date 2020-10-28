package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.team6479.lib.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class Drivetrain extends SubsystemBase implements TankDrive {
  private final int CPR = 4096;
  private final double WHEEL_CIRCUMFERENCE = Math.PI * 5; //TODO: Insert actual wheel diameter
  private final TalonSRX leftFrontMotor = new TalonSRX(DriveTrainConstants.LEFT_FRONT_MOTOR_PORT);
  private final TalonSRX leftBackMotor = new TalonSRX(DriveTrainConstants.LEFT_BACK_MOTOR_PORT);
  private final TalonSRX rightFrontMotor = new TalonSRX(DriveTrainConstants.RIGHT_FRONT_MOTOR_PORT);
  private final TalonSRX rightBackMotor = new TalonSRX(DriveTrainConstants.RIGHT_BACK_MOTOR_PORT);

  public Drivetrain() {
    // Config defaults
    leftFrontMotor.configFactoryDefault();
    leftBackMotor.configFactoryDefault();
    rightFrontMotor.configFactoryDefault();
    rightBackMotor.configFactoryDefault();

    // Set back motors to follow front motors
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    // Set neutral mode to brake
    leftFrontMotor.setNeutralMode(NeutralMode.Brake);
    leftBackMotor.setNeutralMode(NeutralMode.Brake);
    rightFrontMotor.setNeutralMode(NeutralMode.Brake);
    rightBackMotor.setNeutralMode(NeutralMode.Brake);

    // Set encoders
    leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    rightFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

    // Invert Motors
    leftFrontMotor.setInverted(false);
    leftBackMotor.setInverted(false);
    rightFrontMotor.setInverted(true);
    rightBackMotor.setInverted(true);
  }

  @Override
  public void stop() {
    leftFrontMotor.set(ControlMode.PercentOutput, 0);
    rightFrontMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void tankDrive(double leftSpeed, double rightSpeed) {
    leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed);
    rightFrontMotor.set(ControlMode.PercentOutput, rightSpeed);
  }

  @Override
  public void arcadeDrive(double forward, double rotation) {
    leftFrontMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, +rotation);
    rightFrontMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, -rotation);
  }

  public void straightDrive(double distance) {
    leftFrontMotor.set(ControlMode.Position, CPR * distance / WHEEL_CIRCUMFERENCE);
    rightFrontMotor.set(ControlMode.Position, CPR * distance / WHEEL_CIRCUMFERENCE);
  }
}
