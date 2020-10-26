public class Indexer extends Subsystembase {

  private TalonSRX indexer1;
 //Creates an On and Off Boolean
  private Boolen on;

  //Creates Indexer Object and Sets Default Parameters
  public Indexer() {
      indexer1 = new TalonSRX(Constants.INDERER_ROLLER);
      //I don't know why my Indexer isn't changing to blue!!!
      indexer1.configFactoryDefault();
      indexer1.setInverted(false);
      on = false;
    }

    //Sends if the On boolean is True/False
    public boolean isOn() {
      return on;
    }

    // Set the indexer motor to on
    public void indexerOn() {
      indexer1.set(ControlMode.PercentOutput, 0.8); //I just put it 80% because I thought that it would be a good speed but you can change it if needed
      on = true;
    }

    // Set the indexer motor to off
    public void indexerOff() {
      indexer1.set(ControlMode.PercentOutput, 0.0);
      on = false;
    }
    // Toggles the indexer off or on when called
    public void toggleRollers() {
      if(on) {
        indexerOff();
      } else {
        indexerOn();
      }
    }

  }

