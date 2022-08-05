import java.util.ArrayList;

public class Hotdog {
	String bunSelection;
	String sausageSelection;
	ArrayList<String> toppingSelection = new ArrayList<String>();
	ArrayList<String> sauceSelection = new ArrayList<String>();
	
	Hotdog(String bunSelection, String sausageSelection, ArrayList<String> toppingSelection, ArrayList<String> sauceSelection) {
		setBunSelection(this.bunSelection);
		setSausageSelection(this.sausageSelection);
		setToppingSelection(this.toppingSelection);
		setSauceSelection(this.sauceSelection);
	}
	
	public void setBunSelection(String bunSelection) {
		this.bunSelection = bunSelection;
	}
	
	public void setSausageSelection(String sausageSelection) {
		this.sausageSelection = sausageSelection;
	}
	
	public void setToppingSelection(ArrayList<String> toppingSelection) {
		for (String item : toppingSelection) {
			this.toppingSelection.add(item);
		}
	}
	
	public void setSauceSelection(ArrayList<String> sauceSelection) {
		for (String item : sauceSelection) {
			this.sauceSelection.add(item);
		}
	}
	
	public String getBunSelection() {
		return this.bunSelection;
	}
	
	public String getSausageSelection() {
		return this.sausageSelection;
	}
	
	public ArrayList<String> getToppingSelection() {
		return this.toppingSelection;
	}
	
	public ArrayList<String> getSauceSelection() {
		return this.sauceSelection;
	}

}
