package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class Colorwheel extends SubsystemBase {

  private CANSparkMax colorwheelRotator; //Creates Motor
  private DoubleSolenoid colorwheelSol; //Creates Motor

  public Colorwheel() {

    colorwheelRotator = new CANSparkMax(Constants.COLORWHEEL_SPARK_MAX, MotorType.kBrushless); //Defines Object

    colorwheelRotator.restoreFactoryDefaults(); //Restores Factory Defaults

    colorwheelRotator.setInverted(false); //Not Inverted

    colorwheelSol = new DoubleSolenoid(Constants.COLORWHEEL_SOL_1, Constants.COLORWHEEL_SOL_2); //Defines Object
    /*
    *Are there no defaults or inverteds that I have to set for the double solenoid. I looked back into my old code, and didn't see it, but I could be wrong.
    */
  }

  public void ColorwheelExtends() {
    colorwheelSol.set(DoubleSolenoid.Value.kForward); //The Wheel Extends Forward
  }

  public void ColorwheelRetracts() {
    colorwheelSol.set(DoubleSolenoid.Value.kReverse); //The Wheel Retracts
  }

  public void ColorwheelForward() {
    colorwheelRotator.set(0.5); //The Wheel Rotates Forwards
  }

  public void ColorwheelBackwards() {
    colorwheelRotator.set(-0.5); //The Wheel Rotates Backwards
  }

  public void ColorwheelOff() {
    colorwheelRotator.set(0); //The Wheel is Off
  }


}
