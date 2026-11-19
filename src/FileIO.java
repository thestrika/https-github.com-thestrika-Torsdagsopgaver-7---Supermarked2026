import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileIO {

    public static Map<String, Product> loadProducts(String path) throws IOException {
        Map<String, Product> products = new HashMap<>();
        List<String> lines = Files.readAllLines(Path.of(path));
        for(int i = 1; i < lines.size(); i++){
            String line = lines.get(i);
            if(line.isBlank()){
                continue;
            }
            String[] fields = line.split(";");

            String EAN = fields[0];
            String name = fields[1];
            String date = fields[2];
            double price = Double.parseDouble(fields[3]);
            double quantity = Double.parseDouble(fields[5]);
            String unit = fields[6];

            Product product = new Product(EAN, name, date, price, quantity, unit);
            products.put(EAN, product);

        }

        return products;

    }

}
