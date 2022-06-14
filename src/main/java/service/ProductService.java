package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Banhmy",12000 , "Kho , kho an"));
        products.put(2, new Product(2, "Cam",14000 , "Ngot , TUYEN QUANG"));
        products.put(3, new Product(3, "Tao", 23000, "TAY NINH"));
        products.put(4, new Product(4, "Chuoi", 31000, "PHU THO"));
        products.put(5, new Product(5, "Buoi", 17000, "QUAT LAM"));
        products.put(6, new Product(6, "Nho", 13000, "QUANG TRI"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
            return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
