package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Product;
import com.example.demo.dao.ProductRepository;


@Controller

public class HelloController {
	 @Autowired
	    ProductRepository productRepository;
	 @GetMapping("/")
		
	 public String sayhello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	System.out.println("inside sayHello");
	model.addAttribute("user", name);
	return "hello";
}
	 @GetMapping("/products")
	    public String productsList(Model model){
		//System.out.println("in products");
	       model.addAttribute("products", productRepository.findAll());
	        return "products";
	    }
	@PostMapping("/addproduct")
    public String addProduct(Model model, Product products){
	System.out.println("in addProduct");
	
      productRepository.insert(products);
      model.addAttribute("products", productRepository.findAll());
        return "products";
    }

	@RequestMapping("/deleteproduct/{id}")
	public String deleteProd(@PathVariable String id,Model model){
		System.out.println("in deleteProduct");
		System.out.println("product id:"+ id);
	      productRepository.deleteById(id);
	      System.out.println("after deleting prod");
	      model.addAttribute("products", productRepository.findAll());
	        return "products";
	}
	
	
	@RequestMapping("displayProdDetails/{id}")
	public String displayProduct(@PathVariable String id, Model model){
		System.out.println("in displayProduct");
	    model.addAttribute("product", productRepository.findById(id));
	    return "editProduct";
	}
	
	@RequestMapping("updateproduct")
	public String updateProduct(Product prod, Model model){
		System.out.println("in updateproduct");
	    //model.addAttribute("product", productRepository.findById(id));
		productRepository.update(prod);
		 System.out.println("after updating prod");
	      model.addAttribute("products", productRepository.findAll());
	      return "products";
	}
	@GetMapping("/error")
	public String error1(Model model){
		model.addAttribute("error","Something went wrong");
		return "error";
	}
	
	}
