package Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Sunny on 1/24/2016.
 */
public class CategoryDescPK implements Serializable {
    private int CategoryDescId;
    private int CategoryId;

    @Column(name = "CategoryDesc_ID")
    @Id
    public int getCategoryDescId() {
        return CategoryDescId;
    }

    public void setCategoryDescId(int categoryDescId) {
        this.CategoryDescId = categoryDescId;
    }

    @Column(name = "Category_ID")
    @Id
    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        this.CategoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDescPK that = (CategoryDescPK) o;

        if (CategoryDescId != that.CategoryDescId) return false;
        if (CategoryId != that.CategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = CategoryDescId;
        result = 31 * result + CategoryId;
        return result;
    }
}
