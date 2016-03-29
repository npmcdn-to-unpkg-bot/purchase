package by.ladyka.purchase.view;

import by.ladyka.purchase.repository.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public Product getProduct(int id) {
        return productDAO.get(id);
    }
}
