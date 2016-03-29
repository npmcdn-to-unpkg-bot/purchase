package by.ladyka.purchase.view;

import by.ladyka.purchase.repository.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO extends BaseDAO<Product>{

    public Product get(int id) {
        return getEntity(Product.class,id);
    }
}
