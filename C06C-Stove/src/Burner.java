
public class Burner {
	//enum variables only to be used in Burner class
	enum Temperature{BLAZING, HOT, WARM, COLD}
	private Temperature myTemperature;
	//uses enum variable from Setting enum
	private Setting mySetting;
	int timer;
	public final static int TIME_DURATION = 2;
	
	// getter for temperature
	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	/**
	 * @param myTemperature
	 * @param mySetting
	 */
	//constructor that just sets temp and setting
	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	//will raise the setting by one notch
	public void plusButton() {
		//used to check where the current setting is at
		switch(mySetting) {
		case OFF: {mySetting = Setting.LOW; break;}
		case LOW: {mySetting = Setting.MEDIUM; break;}
		case MEDIUM: {mySetting = Setting.HIGH; break;}
		//case HIGH: System.out.println("At hightest setting");
		}
		timer = TIME_DURATION;
	}	
	
	//will lower the setting by one notch
	public void minusButton() {
		//used to check where the current setting is at
		switch(mySetting) {
		case HIGH: {mySetting = Setting.MEDIUM; break;}
		case MEDIUM: {mySetting = Setting.LOW; break;}
		case LOW: {mySetting = Setting.OFF; break;}
		//case OFF: System.out.println("At Lowest setting");
		}
		timer = TIME_DURATION;
	}	
	
	public void updateTemperature() {
		if (timer != 0) {
			timer--;
		}
		if (timer == 0) {
			switch(mySetting) {
			case OFF:{
				switch (myTemperature){ 
				case WARM: {myTemperature = Temperature.COLD; break;}
				case HOT: {myTemperature = Temperature.WARM; timer = TIME_DURATION; break;}
				case BLAZING: {myTemperature = Temperature.HOT; timer = TIME_DURATION; break;}
				}
				break;
			}
			case LOW:{ 
				switch (myTemperature){ 
				case COLD: {myTemperature = Temperature.WARM; break;}
				case HOT: {myTemperature = Temperature.WARM; break;}
				case BLAZING: {myTemperature = Temperature.HOT; timer = TIME_DURATION; break;}
				}
				break;
			}
			case MEDIUM: {
				switch (myTemperature){ 
				case COLD: {myTemperature = Temperature.WARM; timer = TIME_DURATION; break; }
				case WARM: {myTemperature = Temperature.HOT; break; }
				case BLAZING: {myTemperature = Temperature.HOT; break; }
				}
				break;
			}
			case HIGH:{
				switch (myTemperature){ 
				case COLD: {myTemperature = Temperature.WARM; timer = TIME_DURATION; break; }
				case WARM: {myTemperature = Temperature.HOT; timer = TIME_DURATION; break; }
				case HOT: {myTemperature = Temperature.BLAZING; break; }
				}
				break;
			}
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
