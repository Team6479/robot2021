package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class AlignmentBelt {
  private final CANSparkMax rightMotor = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax leftMotor = new CANSparkMax(1, MotorType.kBrushless);

  public AlignmentBelt() {
    rightMotor.restoreFactoryDefaults();
    leftMotor.restoreFactoryDefaults();

    leftMotor.follow(rightMotor);

    rightMotor.setIdleMode(IdleMode.kCoast);
    leftMotor.setIdleMode(IdleMode.kCoast);
  }

  public void run() {
    rightMotor.set(1.0);
  }

  public void reverse() {
    rightMotor.set(-1.0);
  }

  public void stop() {
    rightMotor.set(0.0);
  }
}


