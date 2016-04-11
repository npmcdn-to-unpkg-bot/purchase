package by.ladyka.purchase.dao;

import by.ladyka.purchase.repository.Space;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpaceDAO extends BaseDAO<Space> {
    private static final String COL_NAME = "name";

    public List<Space> get(String query) {
        return getEntitiesFromCriterions(Restrictions.like(COL_NAME,query));
    }
}
