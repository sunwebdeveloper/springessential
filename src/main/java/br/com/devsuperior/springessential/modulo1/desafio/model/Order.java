package br.com.devsuperior.springessential.modulo1.desafio.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {

	private Integer code;
	private Double basic;
	private Double discount;
	
	public void isValid() {
		if((Objects.isNull(this.code) || this.code <= 0) ||
		   (Objects.isNull(this.basic) || this.basic <= 0d)) {
			throw new IllegalStateException("Data Invalid. Code or Basic null or with value minor or equals zero.");
		}
		if(Objects.nonNull(this.discount)) {
			if(this.discount < 0d) {
				throw new IllegalStateException("Data Invalid. Value of discount cant be negative.");
			}
			if(this.discount > this.basic) {
				throw new IllegalStateException("Data Invalid. Value of discount cant br major than Basic value.");
			}
		}
	}
}
