package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Box;
import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "FirstTitle", 25));
        products.add(new Product(2L, "SecondTitle", 15));
        products.add(new Product(3L, "ThirdTitle", 25));
        products.add(new Product(4L, "FourthTitle", 22));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void save(Product product) {
        products.add(product);
    }

    public void deleteById(Long id) {
        products.removeIf(b -> b.getId().equals(id));
    }
}

