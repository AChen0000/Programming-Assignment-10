/*
 Name: Ann C.
 Purpose: To define a Circle2D class with methods for area, perimeter,
 point containment, circle containment, and circle overlap checking
 Date: 4/23/26
 */

import java.lang.Math;
public class Circle2D {
    private double x;
    private double y;
    private double radius;
    
    // creates default circle at (0,0) with radius 1
    public Circle2D() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }
    
    // Constructor with specified x, y, and radius
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    // Get methods
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getRadius() {
        return radius;
    }
    
    // Set method for radius
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Error: Radius must be positive");
        }
    }
    
    // Set method for x and y 
    public void setCenter(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    // Method for circumference
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    // Method to check if a point is inside the circle
    public boolean contains(double x, double y) {
        double distance = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        return distance < radius;
    }
    
    // Method to check if another circle is completely inside this circle
    public boolean contains(Circle2D circle) {
        double distanceBetweenCenters = Math.sqrt(
            Math.pow(this.x - circle.getX(), 2) + 
            Math.pow(this.y - circle.getY(), 2)
        );
        return distanceBetweenCenters + circle.getRadius() < this.radius;
    }
    
    // Method to check if another circle overlaps with this circle
    public boolean overlaps(Circle2D circle) {
        double distanceBetweenCenters = Math.sqrt(
            Math.pow(this.x - circle.getX(), 2) + 
            Math.pow(this.y - circle.getY(), 2)
        );
        return distanceBetweenCenters < (this.radius + circle.getRadius()) &&
               !contains(circle);
    }
}
