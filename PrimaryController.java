package csc272.robotproject;

import static csc272.robotproject.RobotGrid.grid;
import java.io.IOException;
import static java.lang.System.gc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PrimaryController {

    final static int GRID_SIZE = 14;
    
    private int asciiValue;
    private char convertedChar;
    
    private int x;
    private int y;
    private double side;
    private Robot r1;
    char[][] grid = new char[GRID_SIZE][GRID_SIZE]; 
    
    @FXML
    private GridPane myGrid;
    @FXML
    private Canvas myCanvas;
    @FXML
    public GraphicsContext gc;
    @FXML
    private Rectangle rectangle;

    
   @FXML
   public void start(){
    gc = myCanvas.getGraphicsContext2D();
    side = myGrid.getWidth() / 15;


    // Initialize grid
    for (int x = 0; x < GRID_SIZE; x++) {
        for (int y = 0; y < GRID_SIZE; y++){
            grid[x][y] = ' ';
        }
    }
    
    // Input characters to be picked up and dropped off
    grid[0][9] = 'A';
    grid[6][9] = 'D';
    grid[11][7] = '7';
    grid[7][10] = '/';
    grid[10][4] = '~';
    grid[8][6] = '$';
    
    gc.strokeText("A", x+5*side, y+5*side);
    gc.strokeText("9", x+1*side, y+9*side);
    gc.strokeText("~", x+3*side, y+6*side);
    
    
    // Print Grid.
    RobotGrid.print2D(grid);
    
            
    // Creating a square to represent the Robot object.
    r1 = new Robot(side);    
    rectangle.setVisible(true);
    rectangle.setFill(Color.CORAL);
    rectangle.setX(x);
    rectangle.setY(y);
}
    

   
   @FXML
   public void pickUpButtonPressed(ActionEvent event) {
       System.out.println("pickUpButtonPressed");

       if (r1.getPayLoad() != ' ') {   // If the Robot's payLoad is anything other than empty, function returns false and escapes;
            System.out.println("Payload is occupied. Cannot pickup anything.");
        }
        
        else {
            if (grid[x][y] != ' ') { // If the coordinates have a character to pick up...
                r1.setPayLoad(grid[x][y]);
                asciiValue = r1.getPayLoad();
                convertedChar = (char)asciiValue;                
                System.out.println("Picked up character " + convertedChar);

            }
            else {
                System.out.println("There is nothing to pick up at (" + x + ", " + y + ").");
            }
        }           
   }
   
   
   
   
   
   @FXML
   public void dropOffButtonPressed(ActionEvent event) {
       System.out.println("dropOffButtonPressed");
       
        if (r1.getPayLoad() == ' ') {   // If the Robot's payLoad is empty, function returns false and escapes;
            System.out.println("Payload is occupied. Cannot pickup anything.");
        }
        
        else {
            if (grid[x][y] == ' ') { // If the coordinates do not have a character at that location...
                System.out.println(grid[x][y]);                
                asciiValue = r1.getPayLoad();
                convertedChar = (char)asciiValue;
                grid[x][y] = convertedChar; 
                System.out.println("Dropped off character " + convertedChar);
                r1.setPayLoad(' ');
                System.out.println(grid[x][y]);      
            }
            else {
                System.out.println("There is nothing to drop off at (" + x + ", " + y + ").");
            }
        }      
   }  
   
   
   
   
   
   @FXML
   public void moveUpButtonPressed(ActionEvent event) {
       System.out.println("moveUpButtonPressed");
       
        if (r1.getY() > 0) {
            y--;
            r1.setY(y);
            rectangle.setY(y*side);
            if (r1.getY() == 0) {
                System.out.println("Top boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveUp. Robot is already at the top boundary.");
        }       
   }  
   
   @FXML
   public void moveLeftButtonPressed(ActionEvent event) {
       System.out.println("moveLeftButtonPressed");
       
        if (r1.getX() > 0) {
           x--;
            r1.setX(x);
            rectangle.setX(x*side);

            if (r1.getX() == 0) {
                System.out.println("Left boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveLeft. Robot is already at the left boundary.");
        }      
   }   
   
   @FXML
   public void moveRightButtonPressed(ActionEvent event) {
       System.out.println("moveRightButtonPressed");
       
        if (r1.getX() < GRID_SIZE) {
           x++;
            r1.setX(x);
            rectangle.setX(x*side);

            if (r1.getX() == GRID_SIZE) {
                System.out.println("Right boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveRight. Robot is already at the right boundary.");
        }
   }
   
    @FXML
   public void moveDownButtonPressed(ActionEvent event) {
       System.out.println("moveDownButtonPressed");

        if (r1.getY() < GRID_SIZE) {
            y++;
            r1.setY(y);
            rectangle.setY(y*side);
            if (r1.getY() == GRID_SIZE) {
                System.out.println("Bottom boundary reached.");
            }
        }
        else {
            System.out.println("Cannot moveDown. Robot is already at the bottom boundary.");
        }
   }
}
