package csc272.robotproject;

/**
 *
 * @author js
 */
public class RobotGrid {
    public static char[][] grid;
    
    // Write a nonmember function print2D() that receives a 2D array of characters and prints it (in our case 25 elements per row).
    public static void print2D(char[][] charArray) {
	for (int i = 0; i < 14; i++) {
		for (int j = 0; j < 11; j++) {
                    System.out.print(charArray[i][j] + " "); // Added a space here for readability. Space can be removed if having problems w/ movement methods.
		}
            System.out.println();
	}   
        System.out.println();
    }
}
