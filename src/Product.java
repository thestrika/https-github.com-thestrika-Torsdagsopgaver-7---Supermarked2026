import java.time.LocalDate;

public class Product {
    private String EAN;
    private String name;
    private String date;
    private double price;
    private double quantity;
    private String unit;

    public Product(String EAN, String name, String date, double price, double quantity, String unit){
        this.EAN = EAN;
        this.name = name;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getEAN(){
        return EAN;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }

    public double getPrice(){
        return price;
    }

    public double getQuantity(){
        return quantity;
    }

    public String getUnit(){
        return unit;
    }

}
