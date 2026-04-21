package mapper.s4;

import domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderMapper {

    // 왜 optional로 햇지
    List<Order> findByMemberId(Long MemberId);
    List<Order> findAllInlineMapping();

    List<Order> findAllWithMemberNestedSelect();





}
