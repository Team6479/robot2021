package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants.TurretConstants;

public class Turret {

  int upperLimit;
  int lowerLimit;

  private final TalonSRX motor = new TalonSRX(TurretConstants.MOTOR);


  public Turret(){

    motor.configFactoryDefault();
    motor.setNeutralMode(NeutralMode.Brake);
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

    motor.setInverted(true);
    motor.setSensorPhase(true);

  }

  public void start(){
    motor.set(ControlMode.PercentOutput, 0.5);
  }

  public void stop(){
    motor.set(ControlMode.PercentOutput, 0);

  }

  public double getUpperLimit() {
    return upperLimit;
  }

  public double getLowerLimit() {
    return lowerLimit;
  }

}
