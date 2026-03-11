public class Commission extends Hourly { // 1. Membuat class Commision
                                        // 2. Class extends Hourly
    private double totalSales; //3. Variabel Total Sales
    private double commissionRate; //Variabel Commision Rate

    //4. Constructor dengan 6 Parameter
    public Commission(String eName, String eAddress, String ePhone,
                String socSecNumber, double rate,
                double commissionRate)
    {
        //5. Constructor Memanggil Parent (super)
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        totalSales = 0;
    }
    //6. Menambahkan Method addSales()
    public void addSales(double sales)
    {
        totalSales += sales;
    }

    //7. Menambahkan Method pay()
    public double pay()
    {
        double payment = super.pay();
        payment += totalSales * commissionRate;
        //8. Reset totalSales
        totalSales = 0;

        return payment;
    }
    public String toString()
    {
        //9. Reset totalSales
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}