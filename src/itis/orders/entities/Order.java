package itis.orders.entities;

import java.util.ArrayList;

public class Order {

	private Long id;

	//Размер скидки
	private Integer discountPercent;

	//Позиции заказа
	private ArrayList<Item> items;

	private Status status;
}
