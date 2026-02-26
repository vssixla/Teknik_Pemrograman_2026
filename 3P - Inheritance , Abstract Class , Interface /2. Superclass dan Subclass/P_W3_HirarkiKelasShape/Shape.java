public class Shape {
    // a. atribut
    private String color; // proses encapsulation
    private boolean filled; // proses encapsulation
    // b. no-arg constructor
    public Shape() {
        color = "green";
        filled = true;
    }
    // b. parameterized constructor
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    // c. getter & setter
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    // boolean getter
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    // e. toString()
    @Override
    public String toString() {
        return "A Shape with color of " + color +
                " and " + (filled ? "filled" : "Not filled");
    }
}