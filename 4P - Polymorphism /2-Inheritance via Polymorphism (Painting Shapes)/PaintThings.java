//************************************************************
// PaintThings.java
//
// Computes the amount of paint needed to paint various
// things. Uses the amount method of the paint class which
// takes any Shape as a parameter.
//***********************************************************
import java.text.DecimalFormat;
    public class PaintThings {
        //-----------------------------------------
        // Creates some shapes and a Paint object
        // and prints the amount of paint needed
        // to paint each shape.
        //-----------------------------------------
        public static void main (String[] args) {
            final double COVERAGE = 350;
            Paint paint = new Paint(COVERAGE);

            // 6. Menginstansiasi objek pada class PaintThings
            Rectangle deck = new Rectangle(20, 35);
            Sphere bigBall = new Sphere(15);
            Cylinder tank = new Cylinder(10, 30);
            double deckAmt, ballAmt, tankAmt;

            // 7. Menghitung jumlah cat yang dibutuhkan
            deckAmt = paint.amount(deck);
            ballAmt = paint.amount(bigBall);
            tankAmt = paint.amount(tank);

            DecimalFormat fmt = new DecimalFormat("0.#");
            //8. Menampilkan hasil perhitungan jumlah cat
            System.out.println ("\nNumber of gallons of paint needed...");
            System.out.println ("Deck " + fmt.format(deckAmt));
            System.out.println ("Big Ball " + fmt.format(ballAmt));
            System.out.println ("Tank " + fmt.format(tankAmt));
        }
    }