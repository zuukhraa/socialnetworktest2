package itis.orders.entities;

import java.util.ArrayList;

public class Order {

	private Long id;

	//Размер скидки
	private Integer discountPercent;

	//Позиции заказа
	private ArrayList<Item> items;

	private Status status;

	public Order(Long id, Integer discountPercent, ArrayList<Item> items, Status status) {
		this.id = id;
		this.discountPercent = discountPercent;
		this.items = items;
		this.status = status;
	}
}
