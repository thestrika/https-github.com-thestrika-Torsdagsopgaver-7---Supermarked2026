import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CashRegister {

    private Map<String, Product> allProducts;
    private Map<String, Product> discountedProducts;

    public CashRegister(Map<String, Product> allProducts, Map<String, Product> discountedProducts){
        this.allProducts = allProducts;
        this.discountedProducts = discountedProducts;
    }

    public void printReceipt(Collection<Product> basket){
        Map<String, Integer> amount = countProducts(basket);
        double total = 0;

        for(String EAN : amount.keySet()){
            int pcs = amount.get(EAN);
            Product normal = allProducts.get(EAN);
            double totalPrice = pcs * normal.getPrice();

            System.out.println(normal.getName());
            System.out.println(String.format(" %d x %.2f kr. = %.2f kr.", pcs, normal.getPrice(), totalPrice));
            total += totalPrice;

            Product offer = discountedProducts.get(EAN);
            if(offer != null){
                double discount = (normal.getPrice() - offer.getPrice()) * pcs;
                System.out.println(String.format(" Discount: -%.2f kr.", discount));
                total -= discount;
            }

        }
        System.out.println(String.format("Total: %.2f kr.", total));
        System.out.println(String.format("Tax: %.2f kr.", total * 0.20));

    }

    private Map<String, Integer> countProducts(Collection<Product> basket){
        Map<String, Integer> antal = new LinkedHashMap<>();
        for (Product p : basket) {
            antal.merge(p.getEAN(), 1, Integer::sum);
        }
        return antal;
    }


}
