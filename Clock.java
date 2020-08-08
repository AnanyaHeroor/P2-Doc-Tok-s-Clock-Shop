//Ananya Heroor, 9074986762, heroor
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
    public static int computeSecondHandAngle (int seconds){
        return (seconds*6);
    }
    public static int computeMinuteHandAngle (int minutes){
        return (minutes*6);
    }
    public static int computeHourHandAngle (int hours){
        return ((hours%12)*30);
    }
}