package br.com.devsuperior.springessential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.devsuperior.springessential.modulo1.desafio.model.Order;
import br.com.devsuperior.springessential.modulo1.desafio.service.OrderService;

@SpringBootApplication
@ComponentScan({"br.com.devsuperior.springessential"})
public class SpringessentialApplication implements CommandLineRunner{
	
	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringessentialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order1 = new Order(1034, 150d, 20d);
		double realValue1 = orderService.total(order1);
		System.out.println(String.format("Pedido de código %s\r\nValor total: R$ %.2f", order1.getCode(), realValue1));
		
		Order order2 = new Order(2282, 800d, 10d);
		double realValue2 = orderService.total(order2);
		System.out.println(String.format("Pedido de código %s\r\nValor total: R$ %.2f", order2.getCode(), realValue2));
		
		Order order3 = new Order(1309, 95.90d, 0d);
		double realValue3 = orderService.total(order3);
		System.out.println(String.format("Pedido de código %s\r\nValor total: R$ %.2f", order3.getCode(), realValue3));
	}

}
