import java.util.ArrayList;
import java.util.List;

public class ProductTypeTable {
    private List<ProductType> productType;

    public ProductTypeTable() {
    	productType = new ArrayList<>();

    	ProductType product1 = new ProductType("Pizza");
    	ProductType product2 = new ProductType("Drink");
    	ProductType product3 = new ProductType("Other");
        
        productType.add(product1);
        productType.add(product2);
        productType.add(product3);
    }

    public String get(int id) {
        return productType.get(id).getProductType();
    }
	
	public boolean exists(String s) {
		for (int i = 0; i < productType.size(); i++) {
			if (productType.get(i).getProductType().equals(s)) return true;
		}
		return false;
	}

	public int size() {
		return productType.size();
	}
}
