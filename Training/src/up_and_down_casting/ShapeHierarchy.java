package up_and_down_casting;
abstract class Shape {
    String name;
    String color;

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public abstract double calculateArea();
}
//------------------------------------------------------------
class Circle extends Shape {
	
    double radius;

    public Circle(String name, String color, double radius) {
        super(name, color);
        this.radius = radius;}

    @Override
    public double calculateArea() { return Math.PI * radius * radius;}
}
//--------------------------------------------------------------------------
class Rectangle extends Shape {
	
    double width;
    double height;

    public Rectangle(String name, String color, double width, double height) {
        super(name, color);
        this.width = width;
        this.height = height; }

    @Override
    public double calculateArea() { return width * height;}
}
//-----------------------------------------------------------------------------------
class Triangle extends Shape {
	
    double base;
    double triangleHeight;

    public Triangle(String name, String color, double base, double triangleHeight) {
        super(name, color);
        this.base = base;
        this.triangleHeight = triangleHeight; }

    @Override
    public double calculateArea() { return 0.5 * base * triangleHeight;}
}
//--------------------------------------------------------------------------------------
public class ShapeHierarchy {
	
  public static void main(String[] args) {
	
        // Create Circle, Rectangle, and Triangle objects:
        Circle circle = new Circle("Circle", "Red", 5.0);
        Rectangle rectangle = new Rectangle("Rectangle", "Blue", 4.0, 6.0);
        Triangle triangle = new Triangle("Triangle", "Green", 3.0, 4.0);

        // Upcasting to Shape references:
        Shape shape1 = circle;
        Shape shape2 = rectangle;
        Shape shape3 = triangle;
        //shape4.radius

        // Calculate and display areas using upcasted references:
        System.out.println(shape1.name + " Area: " + shape1.calculateArea() + "\n" + shape2.name + " Area: " +
        shape2.calculateArea() + "\n" + shape3.name + " Area: " + shape3.calculateArea());

        // Downcasting to access specific attributes:
        if (shape1 instanceof Circle) {
            Circle downcastedCircle = (Circle) shape1;
            System.out.println("Circle Radius: " + downcastedCircle.radius);}

        if (shape2 instanceof Rectangle) {
            Rectangle downcastedRectangle = (Rectangle) shape2;
            System.out.println("Rectangle Width: " + downcastedRectangle.width + "\nRectangle Height: " + downcastedRectangle.height);}

        if (shape3 instanceof Triangle) {
            Triangle downcastedTriangle = (Triangle) shape3;
            System.out.println("Triangle Base: " + downcastedTriangle.base + "\nTriangle Height: " + downcastedTriangle.triangleHeight);}
    }
}
