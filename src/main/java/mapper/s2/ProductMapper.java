package mapper.s2;

import java.util.List;
import java.util.Optional;

public interface ProductMapper {

    List<Product> findAll();
    Optional<Product> findById(Long id);

    // 재고가 있는 상품만 조회
    List<Product> findHasStock();

    int save(Product product);

    int updatePrice(Long id, int price);

    int deleteById(Long id);

    int decreaseStock(Long id, int amount);



}
