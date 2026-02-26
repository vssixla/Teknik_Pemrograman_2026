public class Square extends Rectangle { // POIN 1 Square tidak memiliki atribut baru,
    public Square() { // POIN 2 — No-arg constructor (opsional tapi baik)
        super(1.0, 1.0);
    }
    public Square(double side) { //POIN 2 — Constructor menggunakan super(side, side)
        super(side, side); // memanggil superclass Rectangle(double, double)
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() { // Getter side
        return getWidth();
    }
    public void setSide(double side) { // Setter side
        setWidth(side);
        setLength(side);
    }
    @Override
    public void setWidth(double side) { //POIN 5 — Override setWidth()
        super.setWidth(side);
        super.setLength(side); // menjaga bentuk persegi
    }
    @Override
    public void setLength(double side) { /*poin 5 — Override setLength()
                                        supaya width dan length selalu sama */
        super.setWidth(side);
        super.setLength(side); // jaga bentuk persegi
    }
    @Override
    public String toString() { // poin 3 : Override toString(), 
        return "A Square with side=" + getWidth()
                + ", which is a subclass of " + super.toString();
    }
}