package static_rules;
class Circle4 {

    static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}
class Rectangle4 {

    static double calculateArea(double width, double length) {
        return width * length;
    }
}

class Triangle  {

    static double calculateArea(double width, double height) { // 'static' methods can be passed to another class;
        return width * height / 2;
    }
}
class Static_ShapeCalculator {

    public static void main(String[] args) {

        // Create an array of shape objects and calculate areas
        double[] areas = new double[3];

        areas[0] = Circle4.calculateArea(5.0);           // Circle area
        areas[1] = Rectangle4.calculateArea(4.0, 6.0);  // Rectangle area
        areas[2] = Triangle.calculateArea(3.0, 4.0);   // Triangle area

        // Display the calculated areas
        System.out.println("Areas of Geometric Shapes:");
        System.out.println("Circle Area: " + areas[0]);
        System.out.println("Rectangle Area: " + areas[1]);
        System.out.println("Triangle Area: " + areas[2]);
    }
}