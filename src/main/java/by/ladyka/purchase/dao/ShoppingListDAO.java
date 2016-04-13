package by.ladyka.purchase.dao;

import by.ladyka.purchase.repository.ShoppingList;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingListDAO extends BaseDAO<ShoppingList> {
    public static final int STATUS_CREATE = 1;
    public static final int STATUS_BOUGHT = 2;
    public static final String COL_NAME = "name";

    public List<ShoppingList> get(String query) {
        return getEntitiesFromCriterions(Restrictions.like(COL_NAME,query));
    }
}
