
public class Order {
	int orderNumber;
	String name;
	Hotdog hotdogSelection;
	
	Order(int orderNumber, String name, Hotdog hotdogSelection) {
		setOrderNumber(orderNumber);
		setName(name);
		setHotdogSelection(hotdogSelection);
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
}
