package csc272.robotproject;



/**
 *
 * @author js
 */



public class Robot {

    private int x;
    private int y;
    private char payLoad;
    private String[][] str;
    
    
    // Default constructor; location at (0,0); payload set to ' '(empty)
    Robot(double side){
        this.x = 0;
        this.y = 0;
        this.payLoad = ' ';
    }
    
    // Constructor that receives three parameters to initialize the private data members.
    Robot(int x, int y, char payLoad){
        this.x = x;
        this.y = y;
        this.payLoad = payLoad;
    }
    
    
    
    // Include a set and get method for each of the private data members.    
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getPayLoad() { return this.payLoad; }
    
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setPayLoad(char payLoad) { this.payLoad = payLoad; }
    
    
    
    // Include a member function print() that prints the location of the robot on the grid as well as its load.
    public void print() {
        System.out.println(
                "Robot: " + this + "\n" + 
                "Coordinates: (" + this.x + ", " + this.y + ")\n" +
                "Payload: '" + this.payLoad + "'\n");    
    }
    
    
    
    // Method pickup(int lx, int ly) with boolean return type.
    public boolean pickUp(int lx, int ly){
        if (payLoad != ' ') {   // If the Robot's payLoad is anything other than empty, function returns false and escapes;
            System.out.println("Payload is occupied. Cannot pickup anything.");
            return false;
        }
        
        else {
            if (RobotGrid.grid[lx][ly] != ' ') { // If the coordinates have a character to pick up...
                moveTo(lx, ly); // Go to the coordinates and pick it up.
                payLoad = RobotGrid.grid[lx][ly];
                RobotGrid.grid[lx][ly] = ' ';
                System.out.println("Picked up character " + payLoad);
                return true;
            }
            else {
                System.out.println("There is nothing to pick up at (" + lx + " ," + ly + ").");
                return false;
            }
        }       
    }

    
    // Method dropOff(int lx, int ly) with Boolean return type.
    public boolean dropOff(int lx, int ly) {
        if (payLoad == ' ') {   // If the Robot's payLoad is empty, function returns false and escapes;
            System.out.println("Payload is occupied. Cannot pickup anything.");
            return false;
        }
        
        else {
            if (RobotGrid.grid[lx][ly] == ' ') { // If the coordinates do not have a character at that location...
                moveTo(lx, ly); // Go to the coordinates and drop off our payLoad.
                RobotGrid.grid[lx][ly] = payLoad;
                System.out.println("Dropped off character " + payLoad);
                payLoad = ' ';
                return true;
            }
            else {
                System.out.println("There is nothing to drop off at (" + lx + " ," + ly + ").");
                return false;
            }
        }
    }
    
    
    
    
    // Method moveRight() with a void return type.
    public void moveRight() {
        if (x < 26) {
            x++;
            if (x == 26) {
                System.out.println("Right boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveRight. Robot is already at the right boundary.");
        }
    }
    // Method moveLeft() with a void return type.
    
    public void moveLeft() {
        if (x > 0) {
            x--;
            if (x == 0) {
                System.out.println("Left boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveLeft. Robot is already at the left boundary.");
        }
    }    
    
    // Method moveUp() with a void return type.
    public void moveUp() {
        if (y < 26) {
            y++;
            if (y == 26) {
                System.out.println("Top boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveUp. Robot is already at the top boundary.");
        }
    }  
    
    // Method moveDown() with a void return type.
    public void moveDown() {
        if (y > 0) {
            y--;
            if (y == 0) {
                System.out.println("Bottom boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveDown. Robot is already at the bottom boundary.");
        }    
    }
    
    // Method MoveTo(int lx, int ly) with boolean return type.
    public boolean moveTo(int lx, int ly) {
        if (lx < 0 || lx > 26 || ly < 0 || ly > 26) { 
            System.out.println("Out of bounds"); 
            return false;
        }
        else {
            System.out.printf("Send it to (%d, %d)... \n", lx,ly);
            if (lx != x) {	// If x is different from the Robot's current location, move along x axis to get there.
                for (int i = x; i < lx; ++i) {
                    moveRight();
                }
                for (int i = x; i > lx; --i) {
                    moveLeft();
                }
            }
            if (ly != y) {	// If y is different from the Robot's current location, move along y axis to get there.
                for (int j = y; j < ly; ++j) {
                    moveUp();
                }
                for (int j = y; j > ly; --j) {
                    moveDown();
                }
            }

            if (x == lx && y == ly) {	// Once the Robot has arrived at its destination, set coordinates and return true.
                // Until then...
                System.out.println("Yeet!");
            }                
        }
        return true;
    }

   
    
    
    // Main Function unused here. Applied in RobotTest class.
    public static void main(String[] args) {}
}
