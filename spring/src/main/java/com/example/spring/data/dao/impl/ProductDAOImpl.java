package com.example.spring.data.dao.impl;

import com.example.spring.data.dao.ProductDAO;   // data 파일의 dao 파일
import com.example.spring.data.entity.Product;   // entity 파일
import com.example.spring.data.repository.ProductRepository;    // 레포지토리파일
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 오류에대해서 waring에서 hilight되는게 Syntax로 바꿨는데 이는 문법상 오류만 뜨도록 바꾼 것
   이걸로 바꾸지 않으면 @Autowired에서 members must be defined in valid Spring bean... 오류가 발생하게 된다*/

@Component         // Component어노테이션은 bean 역할을 하는 클래스로 명시한다, 지정한다는 의미
public class ProductDAOImpl implements ProductDAO {
     // ProductDAO 인터페이스를 구현하는 클래스다
    private final ProductRepository productRepository;  // 필드
    // 객체를 생성해 객체를 통해 접근으로 DI, AOP 사용

    @Autowired     // @Component를 사용했기 때문에 @Autowirde라는 의존성을 주입 어노테이션을 사용할 수 있음
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);   // 위 객체에서 접근하는 것이기 때문에
                                                                  //this.productRepository 객체를 통해 사용하는 것
        return savedProduct;
        // productRepository라는 객체를 통해 JpaRepository의 save함수를 매개변수로 받은 product를 넣음
    }
    @Override
    public Product selectProduct(Long number) {
        Optional<Product> selectedProduct = productRepository.findById(number);

        return selectedProduct.orElseThrow(() -> new RuntimeException("조회 안됨"));
    }
    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());
            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }
    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}
