package com.example.Ultil;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ultil {
	Double km = km();
	Double price = price();

public double km() {
		
		km = Math.random()*99+1;
		
		return km;
		
	}

public double price() {
	price = (double) 0;
	if(km <= 50) {
		price = (double) 30;
		return price;
	}else {
		return price = (double) 50;
	}
	
}
}
