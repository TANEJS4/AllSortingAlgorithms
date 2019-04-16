package sort;

public class Product implements Comparable<Product>{
	@Override
	public int compareTo(Product j)
	{
		if (j.getSalesAmount() > this.getSalesAmount()) {
			return -1;
		}
		else if (j.getSalesAmount() < this.getSalesAmount()) {
			return 1;
		} else if (j.getSalesAmount() == this.getSalesAmount()){
			
			String v = j.getProductID();
			String w = this.getProductID();
			int i = w.compareTo(v);
			if (i > 0) {
				return 1;
			} else if  (i < 0 ) {
				return -1;
			}
			else {
				return 0;
			}
		}
		return 0;
		
	}
	
	private final String productID;
	private int salesAmount;
	
	public String getProductID(){
		return this.productID;}
	
	public int getSalesAmount() {
		return this.salesAmount;
	}
	
	public void setSalesAmount(Product that, int sales) {
		that.salesAmount = sales; 
	}
	
	public String toString() {
		return "Id: "+  this.productID+  " Sales: " +this.salesAmount;
	}
	
	public Product(String productID, int salesAmount){

		this.productID = productID;
		this.salesAmount = salesAmount;
		}
	
}

