public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        System.out.println(s1);
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());
        // Test constructor berparameter
        Shape s2 = new Shape("blue", false);
        System.out.println(s2);
        // Test setter
        s2.setColor("red");
        s2.setFilled(true);
        System.out.println("After change:");
        System.out.println(s2);

        //UNTUK TES NOMOR 2
        // ===== TEST CIRCLE =====
        System.out.println("\n=== TEST CIRCLE ===");
        Circle c1 = new Circle(2.5, "red", true);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        System.out.println();
        // ===== TEST RECTANGLE =====
        System.out.println("\n=== TEST RECTANGLE ===");
        Rectangle r1 = new Rectangle(2.0, 3.0, "blue", false);
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        // UNTUK TES NOMOR 
        // ===== TEST SQUARE =====
        System.out.println("\n=== TEST SQUARE ===");
        Square sq1 = new Square(4.0, "yellow", true);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());
    }
}