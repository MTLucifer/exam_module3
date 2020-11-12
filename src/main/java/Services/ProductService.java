package Services;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void addProduct(Product product) throws SQLException;

    Product findProduct(int id);

    List<Product> findAllProducts();

    void deleteProduct(int id) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;

    List<Product> findProductByName(String words);


}
