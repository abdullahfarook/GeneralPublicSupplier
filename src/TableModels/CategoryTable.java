package TableModels;

/**
 * Created by Sunny on 2/18/2016.
 */
public class CategoryTable {
   private String categoryName;
     private String       productName;
   private String dimensions;
    private String weightPerUnit;
    private String       colors;

    public CategoryTable(String categoryName, String productName, String dimensions, String weightPerUnit, String colors) {
        this.categoryName = categoryName;
        this.productName = productName;
        this.dimensions = dimensions;
        this.weightPerUnit = weightPerUnit;
        this.colors = colors;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeightPerUnit() {
        return weightPerUnit;
    }

    public void setWeightPerUnit(String weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
}
