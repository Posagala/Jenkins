package com.sathya.orm.mapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.entity.Product;
import com.sathya.orm.model.ProductDetials;
import com.sathya.orm.repository.ProductRepository;


@Component
public class PoductClient  implements CommandLineRunner{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper  mapper;
	
	
	@Override
	public void run(String... args) throws Exception {
			//model class data
		ProductDetials productDetials = new  ProductDetials();
		productDetials.setProId(1001);
		productDetials.setProName("chitapandu");
		productDetials.setProPrice(220);
		
		Product product =mapper.modelToEntityConversion(productDetials);
		
		productRepository.save(product);
		
		ProductDetials p1 = new ProductDetials();
		p1.setProId(111);
		p1.setProName("sugar");
		p1.setProPrice(20);
		
		ProductDetials  p2 = new ProductDetials ();
		    p2.setProId(222);
		    p2.setProName("oil");
		    p2.setProPrice(200);
		    
		
		
		
		 List<ProductDetials> details=List.of(p1,p2);
		    //conversion of model class data to entity
		    List<Product> produc=mapper.modelToEntityListConversion(details);
		    productRepository.saveAll(produc);
		    
		   // findById
		    Optional<Product> prd= productRepository.findById(130);
		    if(prd.isPresent()) {
		      System.out.println(prd);
		   }
		    else 
		      System.out.println("Record is not available");
		    
		    //count
		  Long count=productRepository.count();
		    System.out.println("No.of records..."+count);
		    
		   // findAll
		  List<Product>pro=productRepository.findAll();
		    System.out.println(pro);
		    
		    //ExistById
		   boolean status=productRepository.existsById(111);
		    System.out.println("Your record present or not:"+status);
		    
		  //DeleteById
		   // productRepository.deleteById(222);
		   //productRepository.deleteAll();
		    
		    
		    
		    
		    
		    
		  }

		}