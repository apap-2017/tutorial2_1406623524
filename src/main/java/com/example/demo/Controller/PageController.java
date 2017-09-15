package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";// dia nganggep template sebagai kumpulan string. Jadi
						// dia langsung manggil semua stringnya.
	}

/*	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "dunia") String name,
			Model model) {
		// required menentukan apakah suatu controller butuh parameter atau tidak.
		// defaultvalue menentukan value default ketika parameternya kosong.
		model.addAttribute("name", name);
		return "greeting";// dia nganggep template sebagai kumpulan string. Jadi
							// dia langsung manggil semua stringnya.
	} */

	@RequestMapping(value = { "/greeting", "greeting/{name}" })
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "buba");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value = "a", required = false, defaultValue = "0") Integer a,
			@RequestParam(value = "b", required = false, defaultValue = "0") Integer b,
			Model model) {		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", a*b);
		return "perkalian";// dia nganggep template sebagai kumpulan string. Jadi
							// dia langsung manggil semua stringnya.
	}

}