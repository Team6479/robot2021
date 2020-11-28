package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class Colorwheel extends SubsystemBase {

  private CANSparkMax colorwheelRotator;
  private DoubleSolenoid colorwheelSol;

  public Colorwheel() {

    colorwheelRotator = new CANSparkMax(Constants.ColorwheelConstants.COLORWHEEL_SPARK_MAX, MotorType.kBrushless);

    colorwheelRotator.restoreFactoryDefaults();

    colorwheelRotator.setInverted(false); //Not Inverted

    colorwheelSol = new DoubleSolenoid(Constants.ColorwheelConstants.COLORWHEEL_SOL_1, Constants.ColorwheelConstants.COLORWHEEL_SOL_2);
    /*
    *Are there no defaults or inverteds that I have to set for the double solenoid. I looked back into my old code, and didn't see it, but I could be wrong.
    */
  }

  public void extendColorwheel() {
    colorwheelSol.set(DoubleSolenoid.Value.kForward);
  }

  public void retractColorwheel() {
    colorwheelSol.set(DoubleSolenoid.Value.kReverse);
  }

  public void forwardColorwheel() {
    colorwheelRotator.set(0.5);
  }

  public void backwardsColorwheel() {
    colorwheelRotator.set(-0.5);
  }

  public void colorwheelOff() {
    colorwheelRotator.set(0);
  }


}
