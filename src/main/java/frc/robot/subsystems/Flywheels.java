package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Flywheels extends SubsystemBase{

   private CANSparkMax smallFlywheel1;  //Creates Object
   private CANSparkMax smallFlywheel2;  //Creates Object
   private TalonFX bigFlywheelMotor1;   //Creates Object
   private TalonFX bigFlywheelMotor2;   //Creates Object

   public Flywheels() {

    smallFlywheel1 = new CANSparkMax(Constants.FlywheelConstants.SPARK_MAX_1, MotorType.kBrushless);
    smallFlywheel2 = new CANSparkMax(Constants.FlywheelConstants.SPARK_MAX_2, MotorType.kBrushless);

    smallFlywheel1.restoreFactoryDefaults();  //Sets Factory Default
    smallFlywheel2.restoreFactoryDefaults();  //Sets Factory Default

    smallFlywheel1.setInverted(false);
    smallFlywheel2.setInverted(true); //Not inverted

    bigFlywheelMotor1 = new TalonFX(Constants.FlywheelConstants.FALCON_MOTOR_1); //Initializes Object
    bigFlywheelMotor2 = new TalonFX(Constants.FlywheelConstants.FALCON_MOTOR_2); //Initializes Object

    bigFlywheelMotor1.configFactoryDefault(); //Sets Factory Default
    bigFlywheelMotor2.configFactoryDefault(); //Sets Factory Default

    bigFlywheelMotor1.setInverted(false); //I Though you said something about if there are 2 wheels, one is inverted always
    bigFlywheelMotor2.setInverted(true);  //I Though you said something about if there are 2 wheels, one is inverted always

    smallFlywheel2.follow(smallFlywheel1); //Follow the same actions of a motor
    bigFlywheelMotor2.follow(bigFlywheelMotor1); //Follow the same actions of a motor
   }

   public void bigFlywheelRoationForward() {
    bigFlywheelMotor1.set(ControlMode.PercentOutput, 0.15); //Makes the Flywheel Rotate Towards
   }

   public void bigFlywheelRoationBackwards() {
    bigFlywheelMotor1.set(ControlMode.PercentOutput, -0.15);  //Makes the Flywheel Rotate Backwards
   }

   public void bigFlywheelRoationOff() {
    bigFlywheelMotor1.set(ControlMode.PercentOutput, 0.0);  //Makes the Flywheel Rotate Off
   }

  public void smallFlywheelRotaionForward() {
    smallFlywheel1.set(.15);  //Makes the Flywheel Rotate Towards

  }

  public void smallFlywheelRotaionBackwards() {
    smallFlywheel1.set(-.15); //Makes the Flywheel Rotate Backwards
  }

  public void smallFlywheelRotaionoff() {
    smallFlywheel1.set(0.0); //Makes the Flywheel Rotate Off
  }



}
