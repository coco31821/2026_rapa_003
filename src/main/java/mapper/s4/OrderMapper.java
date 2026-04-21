package mapper.s4;

import domain.Order;
import java.util.List;

public interface OrderMapper {
    // optional이 아니라 list인 이유
    List<Order> findByMemberId(Long MemberId);
    List<Order> findAllInlineMapping();

    List<Order> findAllWithMemberNestedSelect();
}
