
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
	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	public void plusButton() {
		switch(mySetting) {
		case OFF: mySetting = Setting.LOW;
		case LOW: mySetting = Setting.MEDIUM;
		case MEDIUM: mySetting = Setting.HIGH;
		//case HIGH: System.out.println("At hightest setting");
		}
		timer = TIME_DURATION;
	}	
	
	public void minusButton() {
		switch(mySetting) {
		case HIGH: mySetting = Setting.MEDIUM;
		case MEDIUM: mySetting = Setting.LOW;
		case LOW: mySetting = Setting.OFF;
		//case OFF: System.out.println("At Lowest setting");
		}
		timer = TIME_DURATION;
	}	
	
	public void updateTemperature() {
		if (timer != 0) {
			timer--;
		}
		else if (timer == 0) {
			switch(mySetting) {
			case OFF:{
				switch (myTemperature){ 
				case WARM: myTemperature = Temperature.COLD;
				case HOT: myTemperature = Temperature.WARM; timer = TIME_DURATION;
				case BLAZING: myTemperature = Temperature.HOT; timer = TIME_DURATION;
				}
			};
			case LOW:{ 
				switch (myTemperature){ 
				case COLD: myTemperature = Temperature.WARM;
				case HOT: myTemperature = Temperature.WARM;
				case BLAZING: myTemperature = Temperature.HOT; timer = TIME_DURATION;
				}
			};
			case MEDIUM: {
				switch (myTemperature){ 
				case COLD: myTemperature = Temperature.WARM; timer = TIME_DURATION;
				case WARM: myTemperature = Temperature.HOT;
				case BLAZING: myTemperature = Temperature.HOT;
				}
			};
			case HIGH:{
				switch (myTemperature){ 
				case COLD: myTemperature = Temperature.WARM; timer = TIME_DURATION;
				case WARM: myTemperature = Temperature.HOT; timer = TIME_DURATION;
				case HOT: myTemperature = Temperature.BLAZING;
				}
			};
		}
		}
	}
	
	
	public String display() {
		switch(myTemperature) {
		case COLD: return ("[" + mySetting + "].....cooool");
		case WARM: return ("[" + mySetting + "].....warm");
		case HOT: return ("[" + mySetting + "].....CAREFUL");
		case BLAZING: return ("[" + mySetting + "].....VERY HOT! DON'T TOUCH");
		default: return "Error in display method";
		}
	}
	
}
