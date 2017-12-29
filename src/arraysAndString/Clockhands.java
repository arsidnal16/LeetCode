package arraysAndString;

public class ClockHands {
	
	/*
	 * The minute hand moves 360 degree in 60 minute(or 6 degree in one minute) and
	 *  hour hand moves 360 degree in 12 hours(or 0.5 degree in 1 minute). 
	 * In h hours and m minutes, the minute hand would move (h*60 + m)*6 and hour hand would move (h*60 + m)*0.5.
	 */
	
	static int calcAngle(double h, double m)
    {
        // validate the input
        if (h <0 || m < 0 || h >12 || m > 60)
            System.out.println("Wrong input");
 
        if (h == 12)
            h = 0;
        if (m == 60) 
            m = 0;
 
        // Calculate the angles moved by hour and minute hands
        // with reference to 12:00
        int hour_angle = (int)(0.5 * (h*60 + m));  // we consider whole circle as 360.
        int minute_angle = (int)(6*m);
 
        // Find the difference between two angles
        int angle = Math.abs(hour_angle - minute_angle);
 
        // smaller angle of two possible angles
        angle = Math.min(360-angle, angle);
 
        return angle;
    }

}
