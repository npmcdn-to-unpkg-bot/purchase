package by.ladyka.purchase.repository;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "shopping_list", schema = "purchase", catalog = "")
public class ShoppingList {
    private Integer id;
    private Integer spaceId;
    private Timestamp createTime;
    private String name;
    private Integer status;
    private Timestamp buyTime;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Space_id", nullable = false)
    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 250)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "buy_time", nullable = true)
    public Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingList that = (ShoppingList) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (spaceId != null ? !spaceId.equals(that.spaceId) : that.spaceId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (buyTime != null ? !buyTime.equals(that.buyTime) : that.buyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (spaceId != null ? spaceId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (buyTime != null ? buyTime.hashCode() : 0);
        return result;
    }
}
