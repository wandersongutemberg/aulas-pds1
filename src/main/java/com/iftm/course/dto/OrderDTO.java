package com.iftm.course.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iftm.course.entities.Order;
import com.iftm.course.entities.User;
import com.iftm.course.entities.enums.OrderStatus;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private OrderStatus orderStatus;
	private Long clientId;
	private String clientName;
	private String clientEmail;
	
	public OrderDTO() {
	}

	public OrderDTO(Long id, Instant moment, OrderStatus orderStatus, Long clientId, String clientName,
			String clientEmail) {
		this.id = id;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
	}
	
	public OrderDTO(Order entity) {
		id = entity.getId();
		moment = entity.getMoment();
		orderStatus = entity.getOrderStatus();
		clientId = entity.getClient().getId();
		clientName = entity.getClient().getName();
		clientEmail = entity.getClient().getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	
	public Order toEntity() {
		User client = new User(clientId, clientName, clientEmail, null, null);
		return new Order(id, moment, orderStatus, client);
	}	

}
