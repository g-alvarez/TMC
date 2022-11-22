package tmc.prices.app.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "PRICE")
public class Price {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    private String curr;

    public Price() {

    }

    public Price(Integer brandId, Date startDate, Date endDate, Integer priceList, 
                    Integer productId, Integer priority, Double price, String curr) {
        super();
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    // Getters and setters
    public Integer getBrandId() {
        return brandId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurr() {
        return curr;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override
    public String toString() {
        return "Price [brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate
                + ", priceList=" + priceList + ", productId=" + productId
                + ", priority=" + priority + ", price=" + price
                + ", curr=" + curr + "]";
    }
}