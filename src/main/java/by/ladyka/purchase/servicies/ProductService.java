package by.ladyka.purchase.servicies;

import by.ladyka.purchase.dao.ProductDAO;
import by.ladyka.purchase.repository.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public Product getProduct(int id) {
        return productDAO.get(id);
    }

    public Product create(String principalName, String name, String description, String image1, String image2, String image3) {
        Product product = new Product();
        product = updateEntity(name, description, image1, image2, image3, product);
        product = productDAO.saveOrUpdate(product);
        return product;
    }

    public boolean delete(int id) {
        productDAO.delete(id);
        return true;
    }

    public Product edit(String principalName, int id , String name, String description, String image1, String image2, String image3) {
        Product product = new Product().setId(id);
        product = updateEntity(name, description, image1, image2, image3, product);
        product = productDAO.saveOrUpdate(product);
        return product;
    }

    public List<Product> get(String query) {
        return productDAO.get(query);
    }

    private Product updateEntity(String name, String description, String image1, String image2, String image3, Product product) {
        product.setName(name);
        product.setDescription(description);
        product.setImage1(image1);
        product.setImage2(image2);
        product.setImage3(image3);
        return product;
    }
}
