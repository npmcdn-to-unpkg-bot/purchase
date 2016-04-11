package by.ladyka.purchase.dao;


import by.ladyka.purchase.repository.SetIdEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
public abstract class BaseDAO<T> {

    private Class<T> entityClass = (Class<T>)
            ((ParameterizedType) getClass()
                    .getGenericSuperclass())
                    .getActualTypeArguments()[0];

    SessionFactory sessionFactory;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T save(T entity) {
        this.sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    public T saveOrUpdate(T entity) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public boolean delete(T object) {
        try {
            this.sessionFactory.getCurrentSession().delete(object);
            return true;
        } catch (Exception var3) {
            this.logger.error(var3.getLocalizedMessage());
            return false;
        }
    }

    public T get(int id) {
        return entityClass.cast(sessionFactory.getCurrentSession().get(entityClass, id));
    }

    public List<T> getEntities(Object... col_coma_value) {
        Criterion[] criterions = new Criterion[col_coma_value.length / 2 + 1];

        try {
            for (int e = 0; e < col_coma_value.length; e += 2) {
                String field = String.valueOf(col_coma_value[e]);
                Object value = col_coma_value[e + 1];
                criterions[e / 2] = Restrictions.eq(field, value);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            return new ArrayList<T>();
        }

        return getEntitiesFromCriterions(criterions);
    }

    protected List<T> getEntitiesFromCriterions(Criterion... criterions) {
        try {
            Criteria e = this.getCriteria();
            Criterion[] listEntity = criterions;
            int var5 = criterions.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                Criterion criterion = listEntity[var6];
                if (criterion != null) {
                    e.add(criterion);
                }
            }

            List var9 = e.list();
            return var9;
        } catch (Exception var8) {
            var8.printStackTrace();
            return new ArrayList<T>();
        }
    }

    public Criteria getCriteria() {
        return this.sessionFactory.getCurrentSession().createCriteria(entityClass);
    }

    public SQLQuery createSQLQuery(String queryString) {
        return this.sessionFactory.getCurrentSession().createSQLQuery(queryString);
    }

    public Query createQuery(String queryString) {
        return this.sessionFactory.getCurrentSession().createQuery(queryString);
    }

    public T getEntity(Object... col_coma_value) {
        List<T> list = getEntities(col_coma_value);
        switch (list.size()) {
            case 0:
                return null;
            case 1:
                return list.get(0);
            default:
                this.logger.warn("SIZE > 1" + Arrays.toString(list.toArray()));
                return list.get(0);
        }
    }

    public boolean delete(int id) {
        try {
            SetIdEntity t = (SetIdEntity) entityClass.newInstance();
            t.setId(id);
            delete((T) t);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}

