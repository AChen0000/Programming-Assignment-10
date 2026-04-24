/*
Name:Ann C.
Purpose: To test the Circle2D class with a menu
Date: 4/23/26
*/

import java.util.Scanner;
public class TestCircle2D {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        
    // Ask user for circle creation
    System.out.println("Let's create your first circle!");
    System.out.print("Enter center x coordinate (or press Enter for default 0): ");
    String xInput = input.nextLine();
        
    double x = 0;
    if (!xInput.isEmpty()) {
        x = Double.parseDouble(xInput);
    }
        
    System.out.print("Enter center y coordinate (or press Enter for default 0): ");
    String yInput = input.nextLine();
        
    double y = 0;
    if (!yInput.isEmpty()) {
        y = Double.parseDouble(yInput);
    }
        
    System.out.print("Enter radius (or press Enter for default 1): ");
    String rInput = input.nextLine();
        
    double radius = 1;
    if (!rInput.isEmpty()) {
        radius = Double.parseDouble(rInput);
    }
        
    // Create the circle
    Circle2D myCircle = new Circle2D(x, y, radius);
        
    // Main menu 
    while (true) {
        System.out.println();
        System.out.println("Current Circle: Center (" + myCircle.getX() + ", " 
                            + myCircle.getY() + "), Radius: " + myCircle.getRadius());
        System.out.println();
        System.out.println("Menu Options:");
        System.out.println("  1. Show area and perimeter");
        System.out.println("  2. Check if a point is inside the circle");
        System.out.println("  3. Check if another circle is inside this circle");
        System.out.println("  4. Check if another circle overlaps this circle");
        System.out.println("  5. Change circle's radius");
        System.out.println("  6. Change circle's center position");
        System.out.println("  7. Create a NEW circle");
        System.out.println("  8. Exit program");
        System.out.print("Enter your choice (1-8): ");
            
        String choice = input.nextLine();
            
        // Process choice
        switch (choice) {
            case "1":
                // Show area and perimeter
                System.out.println();
                System.out.println("Circle Statistics:");
                System.out.printf("   Area: %.2f square units\n", myCircle.getArea());
                System.out.printf("   Perimeter (Circumference): %.2f units\n", myCircle.getPerimeter());
                break;
                    
            case "2":
                // Test point containment
                System.out.print("Enter x coordinate of the point: ");
                double px = Double.parseDouble(input.nextLine());
                System.out.print("Enter y coordinate of the point: ");
                double py = Double.parseDouble(input.nextLine());
                    
                boolean pointInside = myCircle.contains(px, py);
                System.out.println();
                System.out.println("Result: The point (" + px + ", " + py + ") is " 
                                    + (pointInside ? "INSIDE" : "OUTSIDE") + " the circle.");
                    
                // Show distance
                double distance = Math.sqrt(Math.pow(myCircle.getX() - px, 2) 
                                          + Math.pow(myCircle.getY() - py, 2));
                System.out.printf("   (Distance from center: %.2f, Radius: %.2f)\n", 
                                  distance, myCircle.getRadius());
                break;
                    
            case "3":
                // Test circle containment
                System.out.print("Enter another circle's center x: ");
                double cx = Double.parseDouble(input.nextLine());
                System.out.print("Enter another circle's center y: ");
                double cy = Double.parseDouble(input.nextLine());
                System.out.print("Enter another circle's radius: ");
                double cr = Double.parseDouble(input.nextLine());
                    
                Circle2D otherCircle = new Circle2D(cx, cy, cr);
                boolean circleInside = myCircle.contains(otherCircle);
                    
                System.out.println();
                System.out.println("Result: The circle at (" + cx + ", " + cy 
                                    + ") with radius " + cr + " is " 
                                    + (circleInside ? "COMPLETELY INSIDE" : "NOT COMPLETELY INSIDE") 
                                    + " your circle.");
                    
                // Show explanation
                double distCenters = Math.sqrt(Math.pow(myCircle.getX() - cx, 2) 
                                             + Math.pow(myCircle.getY() - cy, 2));
                if (!circleInside) {
                    System.out.printf("   (Distance between centers: %.2f + small radius %.2f = %.2f", 
                                      distCenters, cr, distCenters + cr);
                    System.out.printf(" vs your radius: %.2f)\n", myCircle.getRadius());
                }
                break;
                    
            case "4":
                // Test circle overlap
                System.out.print("Enter another circle's center x: ");
                double ox = Double.parseDouble(input.nextLine());
                System.out.print("Enter another circle's center y: ");
                double oy = Double.parseDouble(input.nextLine());
                System.out.print("Enter another circle's radius: ");
                double or = Double.parseDouble(input.nextLine());
                    
                Circle2D overlapCircle = new Circle2D(ox, oy, or);
                boolean circlesOverlap = myCircle.overlaps(overlapCircle);
                    
                System.out.println();
                System.out.println("Result: The circles " 
                                    + (circlesOverlap ? "OVERLAP" : "DO NOT OVERLAP"));
                    
                // Show calculation
                double centerDist = Math.sqrt(Math.pow(myCircle.getX() - ox, 2) 
                                              + Math.pow(myCircle.getY() - oy, 2));
                double sumRadii = myCircle.getRadius() + or;
                System.out.printf("   (Distance between centers: %.2f", centerDist);
                System.out.printf(", Sum of radii: %.2f)\n", sumRadii);
                if (centerDist < sumRadii) {
                    System.out.println("   They overlap because distance < sum of radii");
                } else {
                    System.out.println("   They don't overlap because distance >= sum of radii");
                }
                break;
                    
            case "5":
                // Change radius
                System.out.print("Enter new radius: ");
                double newRadius = Double.parseDouble(input.nextLine());
                myCircle.setRadius(newRadius);
                System.out.println("Radius updated to: " + myCircle.getRadius());
                break;
                    
          case "6":
                // Change center
                System.out.print("Enter new center x: ");
                double newX = Double.parseDouble(input.nextLine());
                System.out.print("Enter new center y: ");
                double newY = Double.parseDouble(input.nextLine());
                myCircle.setCenter(newX, newY);
                System.out.println("Center updated to: (" + myCircle.getX() + ", " 
                                    + myCircle.getY() + ")");
                break;
                    
            case "7":
                // Create new circle
                System.out.println();
                System.out.println("Create a NEW circle:");
                System.out.print("Enter center x: ");
                double nx = Double.parseDouble(input.nextLine());
                System.out.print("Enter center y: ");
                double ny = Double.parseDouble(input.nextLine());
                System.out.print("Enter radius: ");
                double nr = Double.parseDouble(input.nextLine());
                myCircle = new Circle2D(nx, ny, nr);
                System.out.println("NEW circle created!");
                break;
                    
            case "8":
                // Exit program
                System.out.println();
                System.out.println("Goodbye!");
                input.close();
                return;
                    
            default:
                System.out.println();
                System.out.println("Invalid choice! Please enter a number between 1 and 8.");
                break;
        }
            
        // Exit the code
        if (!choice.equals("8")) {
            System.out.print("Press Enter to continue...");
            input.nextLine();
        }
    }
}
}
