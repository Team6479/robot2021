package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.NavX;

public class Turn extends CommandBase {
  public enum Direction {
    Left, Right
  }
  private final Drivetrain drivetrain;
  private final NavX navX;
  private final double GOAL;
  private final Direction DIRECTION;
  private final double SPEED;

  private double currentAngle = 0;

  public Turn(Drivetrain drivetrain, NavX navX, double finalAngle, double speed, Direction direction) {
    this.drivetrain = drivetrain;
    this.navX = navX;
    this.GOAL = finalAngle;
    this.SPEED = speed;
    this.DIRECTION = direction;

    addRequirements(drivetrain, navX);
  }

  //Called at command schedule
  @Override
  public void initialize() {
    navX.reset();
  }

  //Called when Scheduler runs
  @Override
  public void execute() {
    while (currentAngle < GOAL) {
      if (DIRECTION == Direction.Left) {
        drivetrain.tankDrive(-SPEED, SPEED);
      } else {
        drivetrain.tankDrive(SPEED, -SPEED);
      }

      currentAngle = Math.abs(navX.getAngle());
    }
  }

  //Called when command ends
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
    DriverStation.reportError("Done", false);
  }

  @Override
  public boolean isFinished() {
    return currentAngle >= GOAL;
  }
}
