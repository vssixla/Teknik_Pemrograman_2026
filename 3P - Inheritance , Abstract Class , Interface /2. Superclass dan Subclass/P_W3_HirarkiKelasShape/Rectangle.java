public class Rectangle extends Shape {
    // 1. Instance variables
    private double width;
    private double length;
    // 2. No-arg constructor
    public Rectangle() {
        super();
        width = 1.0;
        length = 1.0;
    }
    // 3. Constructor width & length
    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }
    // 4. Constructor lengkap
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    // 5. Getter & Setter
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    // 6. getArea()
    public double getArea() {
        return width * length;
    }
    // 7. getPerimeter()
    public double getPerimeter() {
        return 2 * (width + length);
    }
    // 8. Override toString()
    @Override
    public String toString() {
        return "A Rectangle with width=" + width +
                " and length=" + length +
                ", which is a subclass of " + super.toString();
    }
}