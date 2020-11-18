package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.Spark;
import com.team6479.lib.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class Drivetrain extends SubsystemBase implements TankDrive {
  private final Spark leftFrontMotor = new Spark(DriveTrainConstants.LEFT_FRONT_MOTOR_PORT);
  private final Spark leftBackMotor = new Spark(DriveTrainConstants.LEFT_BACK_MOTOR_PORT);
  private final Spark rightFrontMotor = new Spark(DriveTrainConstants.RIGHT_FRONT_MOTOR_PORT);
  private final Spark rightBackMotor = new Spark(DriveTrainConstants.RIGHT_BACK_MOTOR_PORT);

  public Drivetrain() {

    // Invert Motors
    leftFrontMotor.setInverted(false);
    leftBackMotor.setInverted(false);
    rightFrontMotor.setInverted(true);
    rightBackMotor.setInverted(true);
  }

  @Override
  public void stop() {
    leftFrontMotor.set(0);
    leftBackMotor.set(0);
    rightFrontMotor.set(0);
    rightBackMotor.set(0);
  }

  @Override
  public void tankDrive(double leftSpeed, double rightSpeed) {
    leftFrontMotor.set(leftSpeed);
    leftBackMotor.set(leftSpeed);
    rightFrontMotor.set(rightSpeed);
    rightBackMotor.set(rightSpeed);
  }

  @Override
  public void arcadeDrive(double forward, double rotation) {
    leftFrontMotor.set(forward + rotation);
    leftBackMotor.set(forward + rotation);
    rightFrontMotor.set(forward - rotation);
    rightBackMotor.set(forward - rotation);
  }
}
