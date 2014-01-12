package vending_machine;

public class Product {
	private int cost;
	private String name;
	
	Product(int cost, String name) {
		this.cost = cost;
		this.name = name;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public String getName() {
		return this.name;
	}
}
