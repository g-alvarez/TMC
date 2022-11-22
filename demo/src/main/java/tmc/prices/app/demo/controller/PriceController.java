package tmc.prices.app.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import tmc.prices.app.demo.model.Price;
import tmc.prices.app.demo.repository.PriceRepository;

@RestController
@RequestMapping(path="/prices")
public class PriceController {
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd-hh.mm.ss");

    @Autowired
    private PriceRepository priceRepository;

    @GetMapping
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    @GetMapping(path = "/{startDate}/{productId}/{brandId}")
    public @ResponseBody Iterable<Price> getAllPricesbyDateProductBrand(@PathVariable String startDate, @PathVariable Long productId, @PathVariable Long brandId) {
        try {
            List<Price> prices = priceRepository.findByDateProductBrand(formatter.parse(startDate), productId, brandId);
            return prices;
        } catch (java.text.ParseException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bad date format!");
        }
    }
}
