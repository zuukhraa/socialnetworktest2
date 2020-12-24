package itis.orders.entities;

public enum Status {

	NEW(1, "Новый"),
	CONFIRMED(2, "Подтвержден"),
	DELIVERED(3, "Продан"),
	CANCELLED(4, "Отменен");

	private Integer id;

	private String title;

	Status(Integer id, String title) {
		this.id = id;
		this.title = title;
	}


}
