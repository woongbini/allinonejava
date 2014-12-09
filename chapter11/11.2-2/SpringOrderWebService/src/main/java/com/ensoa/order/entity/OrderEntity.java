package com.ensoa.order.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ensoa.order.domain.Order;
import com.ensoa.order.domain.OrderItem;

public class OrderEntity {
	private long id;
	private Date orderDate;
	private ArrayList<OrderItemEntity> items;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public ArrayList<OrderItemEntity> getItems() {
		return items;
	}
	public void setItems(ArrayList<OrderItemEntity> items) {
		this.items = items;
	}
	public String toString() {
		String result =  "id : " + id + ", orderDate : " + orderDate + "\n";
		for(OrderItemEntity item : items)
			result  += item.toString() + "\n";
		return result;
	}
	public Order buildDomain() {
		Order order = new Order();
		order.setId(id);
		order.setOrderDate(orderDate);
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(OrderItemEntity item : items)
			orderItems.add(item.buildDomain());
		order.setItems(orderItems);
		return order;
	}
	public void buildEntity(Order order) {
		id =  order.getId();
		orderDate = order.getOrderDate();
		items = new ArrayList<OrderItemEntity>();
		for(OrderItem orderItem : order.getItems()) {
			OrderItemEntity item = new OrderItemEntity();
			item.buildEntity(orderItem);
			items.add(item);
		}
	}
}
