package abeille.cool.web.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abeille.cool.model.Unite;

@RestController
@RequestMapping("/unite")
@CrossOrigin("*") 
public class UniteRestController {
	
	@GetMapping("")
	public Unite[] list() {
		return Unite.values();
	}

}
