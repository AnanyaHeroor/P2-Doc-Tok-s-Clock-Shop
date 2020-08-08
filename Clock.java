/** 
* This class determines the angle of the hands of the clock
*
*/
public class Clock{
    public static void main (String [] args){
        //computeSecondHandAngle(0);
        // System.out.println("The second hand angle is "+computeSecondHandAngle(0)+ " degrees");
        //computeSecondHandAngle(1);
        // System.out.println("The second hand angle is "+computeSecondHandAngle(1)+ " degrees");
        //computeSecondHandAngle(10);
        // System.out.println("The second hand angle is "+computeSecondHandAngle(10)+ " degrees");
        //computeSecondHandAngle(30);
        // System.out.println("The second hand angle is "+computeSecondHandAngle(30)+ " degrees");
        //computeMinuteHandAngle(0);
        // System.out.println("The minute hand angle is "+computeMinuteHandAngle(0)+ " degrees");
        //computeMinuteHandAngle(1);
        // System.out.println("The minute hand angle is "+computeMinuteHandAngle(1)+ " degrees");
        //computeMinuteHandAngle(10);
        // System.out.println("The minute hand angle is "+computeMinuteHandAngle(10)+ " degrees");
        //computeMinuteHandAngle(30);
        // System.out.println("The minute hand angle is "+computeMinuteHandAngle(30)+ " degrees");
        //computeHourHandAngle(0);
        // System.out.println("The hour hand angle is "+computeHourHandAngle(0)+ " degrees");
        //computeHourHandAngle(2);
        // System.out.println("The hour hand angle is "+computeHourHandAngle(2)+ " degrees");
        //computeHourHandAngle(6);
        // System.out.println("The hour hand angle is "+computeHourHandAngle(6)+ " degrees");
        //computeHourHandAngle(18);
        // System.out.println("The hour hand angle is "+computeHourHandAngle(18)+ " degrees");
    }
/** 
* This function determines the angle of the second hand
* @param int seconds between 0 and 59 inclusive
* @return int representing angle in degrees of second hand when current time has seconds seconds passed
* 0 degrees is 12 o*clock
* Degrees increase counterclockwise (3 o'clock is 90 degrees)
*/
    public static int computeSecondHandAngle (int seconds){
        return (seconds*6);
    }
/** 
* This function determines the angle of the minute hand
* @param int minutes between 0 and 59 inclusive
* @return int representing angle in degrees of minute hand when current time has minutes minutes, ignoring
*   contributions from seconds
* 0 degrees is 12 o*clock
* Degrees increase counterclockwise (3 o'clock is 90 degrees)
*/
    public static int computeMinuteHandAngle (int minutes){
        return (minutes*6);
    }
 /** 
* This function determines the angle of the hour hand
* @param int hours between 0 and 23 inclusive
* @return int representing angle in degrees of hour hand when current time has hours hours 
*   ignoring contributiosn from minutes and seconds
* 0 degrees is 12 o*clock
* Degrees increase counterclockwise (3 o'clock is 90 degrees)
*/
    public static int computeHourHandAngle (int hours){
        return ((hours%12)*30);
    }
}
