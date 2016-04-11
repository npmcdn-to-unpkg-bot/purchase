package by.ladyka.purchase.repository;

import javax.persistence.*;

@Entity
@Table(name = "shopping_item", schema = "purchase", catalog = "")
public class ShoppingItem implements SetIdEntity {
    private int id;
    private Integer productId;
    private Integer status;
    private Double price;
    private Integer shoppingListId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public ShoppingItem setId(int id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "shopping_list_id", nullable = false)
    public Integer getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Integer shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingItem that = (ShoppingItem) o;

        if (id != that.id) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (shoppingListId != null ? !shoppingListId.equals(that.shoppingListId) : that.shoppingListId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (shoppingListId != null ? shoppingListId.hashCode() : 0);
        return result;
    }
}
