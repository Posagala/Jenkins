package com.sathya.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.orm.entity.Product;
import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
	public Product  findByProName(String proName);
	

}
