package ync.pyb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ync.pyb.dto.ProductDTO;
import ync.pyb.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
