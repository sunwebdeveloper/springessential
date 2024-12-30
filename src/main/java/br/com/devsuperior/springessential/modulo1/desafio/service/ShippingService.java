package br.com.devsuperior.springessential.modulo1.desafio.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.devsuperior.springessential.modulo1.desafio.model.Order;

@Service
public class ShippingService {

	public double shipment(Order order) {
		if(Objects.isNull(order) || Objects.isNull(order.getBasic()) || order.getBasic() < 0){
			throw new IllegalStateException("Data Invalid. Basic value is null or minor than zero.");
		}
		
		double shippment = 0d;
		if(order.getBasic() < 100d) {
			shippment = 20d;			
		} else if(order.getBasic() >=100 && order.getBasic() < 200) {
			shippment = 12d;
		}
		
		return shippment;
	}
}
