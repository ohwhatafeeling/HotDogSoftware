
public class Order {
	private int orderNumber;
	private String name;
	private Hotdog hotdogSelection;
	
	Order(int orderNumber, String name, Hotdog hotdogSelection) {
		this.orderNumber = orderNumber;
		this.name = name;
		this.hotdogSelection = hotdogSelection;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHotdogSelection(Hotdog hotdogSelection) {
		this.hotdogSelection = hotdogSelection;
	}
	
	public int getOrderNumber() {
		return this.orderNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Hotdog getHotdog() {
		return this.hotdogSelection;
	}
	
	public String toString() {
		return "**** NEW ORDER ****\nORDER NUMBER: " + getOrderNumber() +
				"\nNAME: " + getName() +
				"\nHOTDOG:\n" + getHotdog();
	}
}
