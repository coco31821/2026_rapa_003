import domain.Product;
import mapper.s2.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import util.HikariMyBatisConnector;
import util.MyBatisSessionConnector;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProductCrud {

    static void main() {

        MyBatisSessionConnector connector = new HikariMyBatisConnector(
                "mapper.s2",
                "domain"
        );

        try (SqlSession session = connector.openSession(true)) {

            ProductMapper mapper = session.getMapper(ProductMapper.class);
            Product product = new Product(null, "상품_%d".formatted(genRandomNumber()), genRandomNumber(), 5);

            mapper.save(product);

        }

        try (SqlSession session = connector.openSession()) {

            ProductMapper mapper = session.getMapper(ProductMapper.class);

            List<Product> products = mapper.findAll();

            System.out.println("전체 상품 목록 =========");

            for (Product product : products) {
                System.out.println("상품 번호 : " + product.getId());
                System.out.println("상품 이름 : " + product.getName());
                System.out.println("상품 가격 : " + product.getPrice());
                System.out.println("상품 재고 : " + product.getStock());
            }

        }

        try (SqlSession session = connector.openSession()) {

            ProductMapper mapper = session.getMapper(ProductMapper.class);

            long targetProductId = 1L;

            Optional<Product> productOptional = mapper.findById(targetProductId);
            Product findProduct = productOptional.orElseThrow(() -> new NoSuchElementException("해당 상품은 존재하지 않습니다."));

            System.out.println("%d번 상품=============".formatted(findProduct.getId()));
            System.out.println("상품 이름 : " + findProduct.getName());
            System.out.println("상품 가격 : " + findProduct.getPrice());
            System.out.println("상품 재고 : " + findProduct.getStock());

        }


        try (SqlSession session = connector.openSession(true)) {

            ProductMapper mapper = session.getMapper(ProductMapper.class);

            long targetProductId = 1L;
            int targetStock = 3;

            mapper.decreaseStock(targetProductId, targetStock);


        }


        try (SqlSession session = connector.openSession()) {

            ProductMapper mapper = session.getMapper(ProductMapper.class);

            long targetProductId = 1L;

            Optional<Product> productOptional = mapper.findById(targetProductId);
            Product findProduct = productOptional.orElseThrow(() -> new NoSuchElementException("해당 상품은 존재하지 않습니다."));

            System.out.println("상품 수정 후 조회 ===================");
            System.out.println("상품 번호 : " + findProduct.getId());
            System.out.println("상품 이름 : " + findProduct.getName());
            System.out.println("상품 가격 : " + findProduct.getPrice());
            System.out.println("상품 재고 : " + findProduct.getStock());

        }


        try (SqlSession session = connector.openSession(true)) {

            ProductMapper mapper = session.getMapper(ProductMapper.class);

            long targetProductId = 1L;

            mapper.deleteById(targetProductId);

        }


        try (SqlSession session = connector.openSession()) {

            ProductMapper mapper = session.getMapper(ProductMapper.class);

            long targetProductId = 1L;

            Optional<Product> productOptional = mapper.findById(targetProductId);
            Product findProduct = productOptional.orElseThrow(() -> new NoSuchElementException("해당 상품은 존재하지 않습니다."));


        } catch (NoSuchElementException e) {
            System.out.println("!!! 예외 발생");
            System.out.println(e.getMessage());
        }

    }

    private static int genRandomNumber() {
        return (int) (Math.random() * 1000000);
    }

}
