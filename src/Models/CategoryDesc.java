package Models;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY_DESC", schema = "dbo", catalog = "ProjectDB")
@IdClass(CategoryDescPK.class)
public class CategoryDesc {
    private int CategoryDescId;
    private int categoryId;
    private String dimensions;
    private Double weightPerUnit;
    private String colors;
    private Categores categores;

    @Id
    @Column(name = "CategoryDesc_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCategoryDescId() {
        return CategoryDescId;
    }

    public void setCategoryDescId(int categoryDescId) {
        CategoryDescId = categoryDescId;
    }

    @Id
    @Column(name = "Category_ID")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @ManyToOne
    @JoinColumn(name = "Category_ID", insertable = false, updatable = false)
    public Categores getCategores() {
        return categores;
    }

    public void setCategores(Categores categores) {
        this.categores = categores;
    }

    @Basic
    @Column(name = "Dimensions")
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Basic
    @Column(name = "Weight_Per_Unit")
    public Double getWeightPerUnit() {
        return weightPerUnit;
    }

    public void setWeightPerUnit(Double weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    @Basic
    @Column(name = "Colors")
    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDesc that = (CategoryDesc) o;

        if (CategoryDescId != that.CategoryDescId) return false;
        if (categoryId != that.categoryId) return false;
        if (dimensions != null ? !dimensions.equals(that.dimensions) : that.dimensions != null) return false;
        if (weightPerUnit != null ? !weightPerUnit.equals(that.weightPerUnit) : that.weightPerUnit != null)
            return false;
        if (colors != null ? !colors.equals(that.colors) : that.colors != null) return false;
        return !(categores != null ? !categores.equals(that.categores) : that.categores != null);

    }

    @Override
    public int hashCode() {
        int result = CategoryDescId;
        result = 31 * result + categoryId;
        result = 31 * result + (dimensions != null ? dimensions.hashCode() : 0);
        result = 31 * result + (weightPerUnit != null ? weightPerUnit.hashCode() : 0);
        result = 31 * result + (colors != null ? colors.hashCode() : 0);
        result = 31 * result + (categores != null ? categores.hashCode() : 0);
        return result;
    }
}