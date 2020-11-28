package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


  public static final class FlywheelConstants {
  public static final int SPARK_MAX_1 = 5; //Change Due to Port Number
  public static final int SPARK_MAX_2 = 6; //Change Due to Port Number
  public static final int FALCON_MOTOR_1 = 1; //Change Due to Port Number
  public static final int FALCON_MOTOR_2 = 2; //Change Due to Port Number
  }
  public static final class ColorwheelConstants {
   public static final int COLORWHEEL_SPARK_MAX = 20; //Change Due to Port Number
   public static final int COLORWHEEL_SOL_1 = 21; //Change Due to Port Number
   public static final int COLORWHEEL_SOL_2 = 22; //Change Due to Port Number
  }

  public static final class IndexerConstants {
    public static final int INDERXER_ROLLER = 9; //Change Due to Port Number
   }

}

