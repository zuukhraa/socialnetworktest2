package itis.orders.entities;

public class Item {

	private final Long id;

	//Число товаров данного вида в заказе
	private Integer quantity;

	private Double price;

	private String name;

	private Boolean isDeleted;


	public Item(Long id, Integer quantity, Double price, String name) {
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.isDeleted = false;
	}
}
