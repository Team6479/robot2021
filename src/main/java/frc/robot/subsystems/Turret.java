package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants.TurretConstants;
import frc.robot.util.Sigmoid;

public class Turret {

  int upperLimit;
  int lowerLimit;

  private final double ENCODER_UNITS = 4095; //represents the number of encoder units in one rotation
  private final double UNITS_PER_DEGREE = ENCODER_UNITS / 360;

  private final TalonSRX motor = new TalonSRX(TurretConstants.MOTOR);
  private final Sigmoid sigmoid = new Sigmoid(0.0, 0.0, 0.0, false, 0.0, 0.0);

  public Turret(){

    motor.configFactoryDefault();
    motor.setNeutralMode(NeutralMode.Brake);
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

    motor.setInverted(true);
    motor.setSensorPhase(true);

  }

  public void setPosition(double angle){
    angle %= 360;
    motor.set(ControlMode.Position, angle * UNITS_PER_DEGREE);
  }

  public void setSpeed(double speed){
    //do sigmoid stuff that we don't understand
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
