package itis.orders;

import itis.orders.entities.Order;
import itis.orders.entities.Status;
import itis.orders.entities.StatusGroup;

import java.util.ArrayList;

//Сервис для работы с заказами. Менять интерфейс запрещено!
public interface OrderService {

	//Получить заказ по айди
	Order getOrderById(ArrayList<Order> orders, Long id);

	//Получить список заказов в определенном статусе
	ArrayList<Order> getAllOrdersByStatus(ArrayList<Order> orders, Status status);

	//Получить список заказов со статусом определенной группы
	ArrayList<Order> getAllOrdersByStatusGroup(ArrayList<Order> orders, StatusGroup statusGroup);

	//Получить список заказов без удаленных позиций товаров
	ArrayList<Order> getAllOrdersWithoutDeletedItems(ArrayList<Order> orders);

	//Получить заказы, сумма которых больше заданной. Сумма заказов рассчитывается по следующей формуле:
	//Сумма произведений цены каждой позиции на ее количество (удаленные позиции не учитываются), с учетом скидки (в процентах)
	ArrayList<Order> getOrdersWithPriceGreaterThan(ArrayList<Order> orders, Double price);

}
