package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Ultil.ultil;
import com.example.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

	@Autowired
	ShoppingCartService cart; // tiêm Spring Bean đã tạo
	

	@GetMapping("/cart/view")
	public String view(Model model) {
		model.addAttribute("cart", cart);
		model.addAttribute("Count", cart.getCount());
		model.addAttribute("Amount", cart.getAmount());
		
		model.addAttribute("shippingprice", cart.km());
		model.addAttribute("deliveryfee", cart.price(cart.km()));
//		model.addAttribute("codeSale", cart.codeSale());

		return "cart/cart";
	}
	@PostMapping("/cart/view")
	public String getCode(Model model, @RequestParam("code") String code) {
		model.addAttribute("cart", cart);
		model.addAttribute("Count", cart.getCount());
		model.addAttribute("Amount", cart.getAmount());
		
		model.addAttribute("shippingprice", cart.km());
		model.addAttribute("deliveryfee", cart.price(cart.km()));
		model.addAttribute("codeSale", cart.codeSale(code));
		return "/cart/cart";
	}

	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/cart/view"; // hiển thị giỏ hàng
	}
//	@RequestMapping("/cart/ship")
//	public String ship(Model model) {
//		model.addAttribute("shippingprice", cart.km());
//		
//		return "redirect:/cart/view";
//	}

	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/update/{id}/{pre}")
	public String update(@PathVariable("id") Integer id, @PathVariable("pre") String pre) {
		cart.update(id, pre);
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/clear")
	public String clear() {
		cart.clear();
		return "redirect:/cart/view";
	}
}
