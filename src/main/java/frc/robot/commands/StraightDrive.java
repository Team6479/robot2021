package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.NavX;

public class StraightDrive extends CommandBase {
  private final Drivetrain drivetrain;
  private final NavX navX;
  private final double SPEED;
  private final double DISTANCE;
  private final double WHEEL_CIRCUMFERENCE = Math.PI * 5; //TODO: Insert actual wheel diameter
  private final double CPR = 4096;

  //Create new StraightDrive
  public StraightDrive(Drivetrain drivetrain, NavX navX, double speed, double distance) {
    this.drivetrain = drivetrain;
    this.navX = navX;
    this.SPEED = speed;
    this.DISTANCE = CPR * distance / WHEEL_CIRCUMFERENCE;
    addRequirements(drivetrain, navX);
  }

  //Called at command schedule
  @Override
  public void initialize() {
    navX.reset();
    drivetrain.resetEncoders();
  }

  //Called when Scheduler runs
  @Override
  public void execute() {
    drivetrain.arcadeDrive(SPEED, -navX.getYaw() * 0.05);
  }

  //Called when command ends
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return Math.abs(drivetrain.getPosition()) >= DISTANCE;
  }
}
