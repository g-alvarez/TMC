package tmc.prices.app.demo;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tmc.prices.app.demo.model.Price;
import tmc.prices.app.demo.repository.PriceRepository;

// @EnableJpaRepositories("tmc.prices.app.demo.repository")
@SpringBootApplication
public class DemoApplication {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd-hh.mm.ss");

	@Autowired
	private PriceRepository priceRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	private void initDb() {
		try {
			Price price1 = new Price();
			Price price2 = new Price();
			Price price3 = new Price();
			Price price4 = new Price();

			price1.setBrandId(1);
			price1.setStartDate(formatter.parse("2020-06-14-00.00.00"));
			price1.setEndDate(formatter.parse("2020-12-31-23.59.59"));
			price1.setPriceList(1);
			price1.setProductId(35455);
			price1.setPriority(0);
			price1.setPrice(35.5);
			price1.setCurr("EUR");

			price2.setBrandId(1);
			price2.setStartDate(formatter.parse("2020-06-14-15.00.00"));
			price2.setEndDate(formatter.parse("2020-06-14-18.30.00"));
			price2.setPriceList(2);
			price2.setProductId(35455);
			price2.setPriority(1);
			price2.setPrice(25.45);
			price2.setCurr("EUR");

			price3.setBrandId(1);
			price3.setStartDate(formatter.parse("2020-06-15-00.00.00"));
			price3.setEndDate(formatter.parse("2020-06-15-11.00.00"));
			price3.setPriceList(3);
			price3.setProductId(35455);
			price3.setPriority(1);
			price3.setPrice(30.5);
			price3.setCurr("EUR");

			price4.setBrandId(1);
			price4.setStartDate(formatter.parse("2020-06-15-16.00.00"));
			price4.setEndDate(formatter.parse("2020-12-31-23.59.59"));
			price4.setPriceList(4);
			price4.setProductId(35455);
			price4.setPriority(1);
			price4.setPrice(38.95);
			price4.setCurr("EUR");

			priceRepository.save(price1);
			priceRepository.save(price2);
			priceRepository.save(price3);
			priceRepository.save(price4);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}
}
