package com.sathya.orm.mapper;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.sathya.orm.entity.Product;
import com.sathya.orm.model.ProductDetials;

@Component
public class ProductMapper {
	
	
	//This method taking model class as input and return entity class as output
	
	public Product modelToEntityConversion(ProductDetials productDetials )
	{
		//read the data from model class set to entity class
		
		Product product = new Product();
		
		product.setProId(productDetials.getProId()); 
		product.setProName(productDetials.getProName());
		  product.setProPrice(productDetials.getProPrice());
		  
		  product.setCreateBy(System.getProperty("user.name"));
		  product.setCreateAt(LocalDateTime.now()); 
		  return product;
		
	}
	 public List<Product> modelToEntityListConversion(List<ProductDetials> pd){
		  List<Product> products=new ArrayList<>();
		  //Reading the data from model class and setting the data
		  for(ProductDetials prDetials : pd)
		  {
		    Product product = new Product();
		    product.setProId(prDetials.getProId());
		    product.setProName(prDetials.getProName());
		    product.setProPrice(prDetials.getProPrice());
		    
		    product.setCreateBy(System.getProperty("user.name"));
		    product.setCreateAt(LocalDateTime.now());
		    products.add(product);
		  }
		  return products;
		}
		}
	


