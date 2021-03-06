package by.ladyka.purchase.dao;

import by.ladyka.purchase.repository.Product;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO extends BaseDAO<Product> {

    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_DESCRIPTION = "description";
    private static final String COL_IMG1 = "image1";
    private static final String COL_IMG2 = "image2";
    private static final String COL_IMG3 = "image3";
    private static final String COL_USER_ID = "userId";

    public List<Product> get(String query) {
        return getEntitiesFromCriterions(Restrictions.like(COL_NAME,query),Restrictions.like(COL_DESCRIPTION,query));
    }
}
