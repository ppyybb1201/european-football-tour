package ync.pyb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ync.pyb.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{


}
