package br.com.devsuperior.springessential.modulo1.desafio.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devsuperior.springessential.modulo1.desafio.model.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		if(Objects.isNull(order)) {
			throw new IllegalArgumentException("Data Invalid. Order is null.");
		}
		order.isValid();
		
		Double discountValue = order.getBasic() * (order.getDiscount()/100); 
		Double realValue = order.getBasic() - discountValue;
		
		Double shippingValue = this.shippingService.shipment(order);
		
		return realValue + shippingValue;
	}
}
