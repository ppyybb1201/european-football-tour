package ync.pyb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ync.pyb.entity.Detail;
import ync.pyb.entity.Product;

public interface DetailRepo extends JpaRepository<Detail, Long>{

}
