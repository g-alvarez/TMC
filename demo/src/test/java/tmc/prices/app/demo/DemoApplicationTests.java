package tmc.prices.app.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tmc.prices.app.demo.model.Price;
import tmc.prices.app.demo.repository.PriceRepository;

@SpringBootTest
class DemoApplicationTests {
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd-hh.mm.ss");

	@Autowired
	private PriceRepository priceRepository;

	@Test
	public void testfindByDateProductBrand() {
		List<String> datesNotInDB = Arrays.asList("2020-06-14-10.00.00", "2020-06-14-16.00.00", "2020-06-14-21.00.00", "2020-06-15-10.00.00", "2020-06-16-21.00.00");
		List<String> datesInDB = Arrays.asList("2020-06-14-00.00.00", "2020-06-14-15.00.00", "2020-06-15-00.00.00", "2020-06-15-16.00.00");
		Long productId = 35455L;
		Long brandId = 1L;
		try {
			// Dates not in the price table
			for (String element : datesNotInDB) {
				List<Price> prices = priceRepository.findByDateProductBrand(formatter.parse(
						element), productId, brandId);
				assertTrue(prices.isEmpty());
			}
			// Datess in the price table
			for (String element : datesInDB) {
				List<Price> prices = priceRepository.findByDateProductBrand(formatter.parse(
						element), productId, brandId);
				assertFalse(prices.isEmpty());
			}
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

}
