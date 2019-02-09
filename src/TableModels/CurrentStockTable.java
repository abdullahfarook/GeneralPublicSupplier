package TableModels;

/**
 * Created by Sunny on 2/18/2016.
 */
public class CurrentStockTable {
    private String orderID;
    private String productID;
    private String productName;
    private String quantityStock;
    private String stockPriceUnit;
    private String quantityOrder;
    private String orderPriceUnit;
    private String category;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(String quantityStock) {
        this.quantityStock = quantityStock;
    }

    public String getStockPriceUnit() {
        return stockPriceUnit;
    }

    public void setStockPriceUnit(String stockPriceUnit) {
        this.stockPriceUnit = stockPriceUnit;
    }

    public String getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(String quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public String getOrderPriceUnit() {
        return orderPriceUnit;
    }

    public void setOrderPriceUnit(String orderPriceUnit) {
        this.orderPriceUnit = orderPriceUnit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CurrentStockTable(String orderID, String productID, String productName, String quantityStock, String stockPriceUnit, String quantityOrder, String orderPriceUnit, String category) {

        this.orderID = orderID;
        this.productID = productID;
        this.productName = productName;
        this.quantityStock = quantityStock;
        this.stockPriceUnit = stockPriceUnit;
        this.quantityOrder = quantityOrder;
        this.orderPriceUnit = orderPriceUnit;
        this.category = category;
    }
}

