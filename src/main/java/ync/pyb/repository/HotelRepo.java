package ync.pyb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ync.pyb.entity.Hotel;
import ync.pyb.entity.Product;

public interface HotelRepo extends JpaRepository<Hotel, Long> {

}
