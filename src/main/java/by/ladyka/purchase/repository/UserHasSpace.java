package by.ladyka.purchase.repository;

import javax.persistence.*;

@Entity
@Table(name = "user_has_space", schema = "purchase")
@IdClass(UserHasSpacePK.class)
public class UserHasSpace {
    private Integer userId;
    private Integer spaceId;

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "Space_id", nullable = false)
    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasSpace that = (UserHasSpace) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (spaceId != null ? !spaceId.equals(that.spaceId) : that.spaceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (spaceId != null ? spaceId.hashCode() : 0);
        return result;
    }
}
