package ync.pyb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import ync.pyb.dto.ProductDTO;
import ync.pyb.entity.Detail;
import ync.pyb.entity.Hotel;
import ync.pyb.entity.Manager;
import ync.pyb.entity.Product;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ProductRepoTests {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private DetailRepo detailRepo;
	@Autowired
	private HotelRepo hotelRepo;
	@Autowired
	private ManagerRepo managerRepo;

	@Test
	public void dummuInsert() {

		IntStream.rangeClosed(1, 5).forEach(i -> {

			Detail detail = Detail.builder().detailId(Long.valueOf(i)).detailIncluded("Include....." + i)
					.detailNotIncluded("NotIncluded....." + i).detailNotice("Notice....." + i).build();

			detailRepo.save(detail);

			Hotel hotel = Hotel.builder().hotelId(Long.valueOf(i)).hotelAddress("Address....." + i)
					.hotelDescription("Description....." + i).hotelName("Name....." + i).build();

			hotelRepo.save(hotel);

			Manager manager = Manager.builder().managerId(Long.valueOf(i)).managerName("Name..... " + i)
					.managerPhone("Phone ....." + i).managerEmail("Email....." + i).build();

			managerRepo.save(manager);

			Product product = Product.builder().productId(Long.valueOf(i)).productArrival("Arrival....." + i)
					.productDeparture("Dept....." + i).productTitle("Title....." + i).detail(detail).hotel(hotel)
					.manager(manager)
					.productCostAdultBasic("AdultBasicCost....." + i)
					.productCostAdultFuel("AdulctFuelCost....." + i)
					.productCostChildBasic("ChildBasicCost....." + i)
					.productCostChildFuel("ChildFuelCost....." + i)
					.productCostBabyBasic("BabyBasicCost....." + i)
					.productCostBabyFuel("BabyFuelCost....." + i).build();

			productRepo.save(product);

		});

	}
}
