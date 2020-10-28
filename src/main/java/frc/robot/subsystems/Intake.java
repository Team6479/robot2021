package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private final DoubleSolenoid leftIntakeSol = new DoubleSolenoid(Constants.IntakeConstants.DOUBLE_SOLENOID_LEFT_0, Constants.IntakeConstants.DOUBLE_SOLENOID_LEFT_1);
  private final DoubleSolenoid rightIntakeSol = new DoubleSolenoid(Constants.IntakeConstants.DOUBLE_SOLENOID_RIGHT_0, Constants.IntakeConstants.DOUBLE_SOLENOID_RIGHT_1);

  private final TalonSRX intakeRollers = new TalonSRX(Constants.IntakeConstants.INTAKE_ROLLERS);

  private boolean rollersOn = false;
  private boolean extendedArms = false;

  public Intake () {

    retractArms();
    stopRollers();

    intakeRollers.configFactoryDefault();
    intakeRollers.setNeutralMode(NeutralMode.Brake);
    intakeRollers.setInverted(false);

  }

  public void extendArms() {
    leftIntakeSol.set(DoubleSolenoid.Value.kForward);
    rightIntakeSol.set(DoubleSolenoid.Value.kForward);
    extendedArms = true;
  }

  public void retractArms() {
    leftIntakeSol.set(DoubleSolenoid.Value.kReverse);
    rightIntakeSol.set(DoubleSolenoid.Value.kReverse);
    extendedArms = false;
  }

  public void toggleArms() {
    if(extendedArms) {
      retractArms();
    } else {
      extendArms();
    }
  }

  public void spinRollers() {
    intakeRollers.set(ControlMode.PercentOutput, 1.0);
    rollersOn = true;
  }

  public void stopRollers() {
    intakeRollers.set(ControlMode.PercentOutput, 0.0);
    rollersOn = false;
  }

  public void toggleRollers() {
    if(rollersOn) {
      stopRollers();
    } else {
      spinRollers();
    }
  }
}
