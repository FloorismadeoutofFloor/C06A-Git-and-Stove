
public class Burner {
	enum Temperature{BLAZING, HOT, WARM, COLD}
	private Temperature myTemperature;
	private Setting mySetting;
	int timer;
	public final static int TIME_DURATION = 2;

	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	/**
	 * @param myTemperature
	 * @param mySetting
	 */
	public Burner(Burner.Temperature myTemperature, Setting mySetting) {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	public void plusButton() {
		switch(mySetting) {
		case OFF: mySetting = Setting.LOW;
		case LOW: mySetting = Setting.MEDIUM;
		case MEDIUM: mySetting = Setting.HIGH;
		case HIGH: System.out.println("At hightest setting");
		}
		timer = TIME_DURATION;
	}	
	
	public void minusButton() {
		switch(mySetting) {
		case HIGH: mySetting = Setting.MEDIUM;
		case MEDIUM: mySetting = Setting.LOW;
		case LOW: mySetting = Setting.OFF;
		case OFF: System.out.println("At Lowest setting");
		}
		timer = TIME_DURATION;
	}	
	
	public void updateTemperature() {
		if (timer != 0) {
			timer--;
		}
		else if (timer == 0) {
			switch(mySetting) {
			case OFF: myTemperature = Temperature.COLD;
			case LOW: myTemperature = Temperature.WARM;
			case MEDIUM: myTemperature = Temperature.HOT;
			case HIGH: myTemperature = Temperature.BLAZING;
		}
		}
	}
	
}
