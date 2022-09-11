
public class Burner {
	enum Temperature{BLAZING, HOT, WARM, COLD}
	Temperature myTemperature;
	Setting mySetting;
	int timer;
	public final static int TIME_DURATION = 2;

	public Temperature getMyTemperature() {
		return myTemperature;
	}

}
