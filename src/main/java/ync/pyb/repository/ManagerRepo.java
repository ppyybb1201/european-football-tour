package ync.pyb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ync.pyb.entity.Manager;
import ync.pyb.entity.Product;

public interface ManagerRepo extends JpaRepository<Manager, Long>{

}
