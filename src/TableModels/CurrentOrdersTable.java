package TableModels;

import java.sql.Date;


public class CurrentOrdersTable {

    private String factoryName;
    private String productName;
    private String quantity;
    private String PricUnit;
    private String laboratory;
    private String Date;

    public CurrentOrdersTable(String factoryName, String productName, String quantity, String pricUnit, String laboratory, String date) {
        this.factoryName = factoryName;
        this.productName = productName;
        this.quantity = quantity;
        this.PricUnit = pricUnit;
        this.laboratory = laboratory;
        this.Date = date;


    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPricUnit() {
        return PricUnit;
    }

    public void setPricUnit(String pricUnit) {
        PricUnit = pricUnit;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}