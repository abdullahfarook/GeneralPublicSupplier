package Models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Sunny on 1/24/2016.
 */
@Entity
public class Categores {
    private int categoryId;
    private int productId;
    private String categoryName;
    private Products product;
    private Collection<CategoryDesc> categoryDesc;

    @Id
    @Column(name = "Category_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name ="Product_ID", insertable =false,updatable = false,referencedColumnName = "Product_ID")
    })
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "categores")
    public Collection<CategoryDesc> getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(Collection<CategoryDesc> categoryDesc) {
        this.categoryDesc = categoryDesc;
    }


    @Basic
    @Column(name = "Product_ID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Category_NAME")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categores categores = (Categores) o;

        if (categoryId != categores.categoryId) return false;
        if (productId != categores.productId) return false;
        if (categoryName != null ? !categoryName.equals(categores.categoryName) : categores.categoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + productId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }
}
