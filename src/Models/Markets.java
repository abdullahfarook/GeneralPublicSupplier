package Models;

import javax.persistence.*;


@Entity
public class Markets {
    private int marketId;
    private int productId;
    private String marketName;
    private String marketCity;
    private String marketLocation;
    private String goodsAvailable;
    private Products product;


    @Id
    @Column(name = "Market_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    @Basic
    @Column(name = "Product_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name ="Product_ID", insertable =false,updatable = false,referencedColumnName = "Product_ID")
    })
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Basic
    @Column(name = "Market_Name")
    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @Basic
    @Column(name = "Market_City")
    public String getMarketCity() {
        return marketCity;
    }

    public void setMarketCity(String marketCity) {
        this.marketCity = marketCity;
    }

    @Basic
    @Column(name = "Market_Location")
    public String getMarketLocation() {
        return marketLocation;
    }

    public void setMarketLocation(String marketLocation) {
        this.marketLocation = marketLocation;
    }

    @Basic
    @Column(name = "Goods_Available")
    public String getGoodsAvailable() {
        return goodsAvailable;
    }

    public void setGoodsAvailable(String goodsAvailable) {
        this.goodsAvailable = goodsAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Markets markets = (Markets) o;

        if (marketId != markets.marketId) return false;
        if (productId != markets.productId) return false;
        if (marketName != null ? !marketName.equals(markets.marketName) : markets.marketName != null) return false;
        if (marketCity != null ? !marketCity.equals(markets.marketCity) : markets.marketCity != null) return false;
        if (marketLocation != null ? !marketLocation.equals(markets.marketLocation) : markets.marketLocation != null)
            return false;
        if (goodsAvailable != null ? !goodsAvailable.equals(markets.goodsAvailable) : markets.goodsAvailable != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = marketId;
        result = 31 * result + productId;
        result = 31 * result + (marketName != null ? marketName.hashCode() : 0);
        result = 31 * result + (marketCity != null ? marketCity.hashCode() : 0);
        result = 31 * result + (marketLocation != null ? marketLocation.hashCode() : 0);
        result = 31 * result + (goodsAvailable != null ? goodsAvailable.hashCode() : 0);
        return result;
    }
}
