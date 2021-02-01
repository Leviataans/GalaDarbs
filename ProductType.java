public class ProductType {
	private String productType;

	public ProductType(String productType) {
		this.productType = productType;
	}

	public final String getProductType() {
		return productType;
	}

	public final void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "ProductType [productType=" + productType + "]";
	}
}
