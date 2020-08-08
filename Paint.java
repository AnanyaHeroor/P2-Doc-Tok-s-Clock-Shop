/**
* This class paints the store red by figuring out how much paint to buy
* @author Ananya Heroor
*
*/
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
    /**
    * This function helps us calculate the area of a single clock
    * @param double radius: radius of the clock
    * @return double equal to the area of a clock with teh radius of radius
    */
        public static double computeClockArea(double radius){
            return (radius*radius*3.14);
        }  
    /**
    * This function helps us determine the total area of a wall
    * @param double width: width of the wall
    * @param double height: height of the wall
    * @return double equal to the surface area of the wall
    */
        public static double computeWallArea (double width, double height){
            return (width*height);
        }
    /**
    * This function helps us calculate how much of the wall area is exposed
    * Areas of the wall that have a clock hanging on it don't need to be painted
    * @param double radius: radius of each clock
    * @param int numClocks: number of clocks
    * @param double width: width of each wall
    * @param double height: height of each wall
    * @param int numWalls: number of walls
    * @return a double equal to the exposed surface area of walls when numClocks clocks (each with radius of radius)
    * are hung on numWalls walls (each with height of height and width of width)
    */
        public static double computeExposedWallArea (double radius, int numClocks, double width, double height, int numWalls){
            return ((width*height*numWalls)-(radius*radius*3.14*numClocks));
        }
}
