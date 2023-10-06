package com.example.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.example.Ultil.SP;
import com.example.model.Item;


@SessionScope
@Controller

public class ShoppingCartServiceImpl implements ShoppingCartService {

	Map<Integer, Item> map = new HashMap<>();
	int random =(int) (Math.random()*99+1) ;
	
	@Override
	public Item add(Integer id) {
		Item item = map.get(id);
		if(item == null) { // Chưa có trong giỏ hàng
			item = SP.item.get(id);
			item.setQty(1);
			map.put(id, item);
		}else {
			item.setQty(item.getQty()+1);
		}
		return item;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public Item update(Integer id, String qty) {
		Item item = map.get(id);
		if(qty.equals("dis") && item.getQty()>0) {
			item.setQty(item.getQty()-1);
			if(item.getQty() == 0) {
				remove(id);
			}
		}else if(qty.equals("plus") &&item.getQty()<100) {
			item.setQty(item.getQty()+1);
		}
		
		return item;
	}

	@Override
	public void clear() {
		// xoa het gio hang
		map.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return map.values();
	}

	@Override
	public int getCount() {
		
		return map.values().stream().mapToInt(item -> item.getQty()).sum();
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getPrice()*item.getQty()).sum();
	}

	@Override
	public double km() {
		
		
		
		return random;
		
	}

	@Override
	public double price(double km) {
		double money = 0;
		if(km <= 50) {
			money = 30;
			return money;
		}else {
			money = 50;
			return money;
		}
		
	}

	@Override
	public int codeSale(String code) {
		int saleMoney = 0;
		String codeTrue = "teo123";
		if(code.equals(codeTrue)) {
			saleMoney = 30;
			return saleMoney;
		}
		return 0;
	}



	

}
