import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Product> allProducts = FileIO.loadProducts("data/varer.csv");
        Map<String, Product> offers = FileIO.loadProducts("data/tilbud.csv");
        CashRegister register = new CashRegister(allProducts, offers);




    }


}
