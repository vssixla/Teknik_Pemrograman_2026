public class Circle extends Shape {

    // 1. Instance variable
    private double radius;
    // 2. No-arg constructor
    public Circle() {
        super();          // panggil constructor Shape
        radius = 1.0;
    }
    // 3. Constructor radius saja
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    // 4. Constructor lengkap
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    // 5. Getter & Setter
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    // 6. getArea()
    public double getArea() {
        return Math.PI * radius * radius;
    }
    // 7. getPerimeter()
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    // 8. Override toString()
    @Override
    public String toString() {
        return "A Circle with radius=" + radius +
                ", which is a subclass of " + super.toString();
    }
}