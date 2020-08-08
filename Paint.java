//Ananya Heroor, 9074986762, heroor
public class Paint{
    public static void main (String [] args){
        //computeClockArea(1.0);
        //computeClockArea(4.0);
        System.out.println(computeClockArea(1.0)+ " is the clock area");
        System.out.println(computeClockArea(4.0) + " is the clock area");
        //computeWallArea(2.0, 4.0);
        //computeWallArea (3.0, 3.0);
        System.out.println(computeWallArea(2.0, 4.0)+ " is the wall area");
        System.out.println(computeWallArea(3.0, 3.0)+ " is the wall area");
        //computeExposedWallArea(1.0, 2, 4.0, 4.0, 2);
        System.out.println(computeExposedWallArea(1.0, 2, 4.0, 4.0, 2)+ " is the exposed wall area");
    }
        public static double computeClockArea(double radius){
            return (radius*radius*3.14);
        }  
        public static double computeWallArea (double width, double height){
            return (width*height);
        }
        public static double computeExposedWallArea (double radius, int numClocks, double width, double height, int numWalls){
            return ((width*height*numWalls)-(radius*radius*3.14*numClocks));
        }
}