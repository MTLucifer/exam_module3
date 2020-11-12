package Services;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement implements ProductService {
    private String url = "jdbc:mysql://localhost:3306/exam_module3?useSSL=false";
    private String user = "root";
    private String password = "Doi2thutoc";

    private static final String INSERT_PRODUCT_SQL = "insert into products (name,price,color,category_id,quantity,description) values (?,?,?,?,?,?)";
    private static final String SELECT_PRODUCT_BY_ID = "select * from products  where id = ?";
    private static final String SELECT_ALL_PRODUCTS = "select * from products join categories on category_id = categories.id";
    private static final String DELETE_PRODUCT_SQL = "delete from products where id = ?";
    private static final String UPDATE_PRODUCT_SQL = "update products set name = ?,price= ?, quantity =?,category_id=?,color=?,description=? where id = ?";
    private static final String SELECT_PRODUCT_BY_NAME = "select * from products join categories on category_id = categories.id where name like concat('%',?,'%')";

    public Connection getJDBC() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        try (Connection connection = getJDBC();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getColor());
            preparedStatement.setInt(4, product.getCategory_id());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findProduct(int id) {
        Product product = null;
        try (Connection connection = getJDBC();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int category_id = rs.getInt("category_id");
                product = new Product(name, color, description,  price,  quantity,  category_id, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getJDBC();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                int id = rs.getInt("id");
                products.add(new Product(name, color, category,price,quantity,id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public void deleteProduct(int id) throws SQLException {
        try (Connection connection = getJDBC(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getJDBC(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getCategory_id());
            statement.setString(5, product.getColor());
            statement.setString(6, product.getDescription());
            statement.setInt(7, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Product> findProductByName(String words) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getJDBC();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);) {
            preparedStatement.setString(1, words);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String category = rs.getString("category");
                int id = rs.getInt("id");
                products.add(new Product(name, color, category,price,quantity,id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
