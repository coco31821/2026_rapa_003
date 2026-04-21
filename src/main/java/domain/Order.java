package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Long memberId;
    private String orderedAt;
    private String status;

    private Member member;
    private List<OrderItem> orderItems;

    /*
    select *
    from
        order
    left join
        member
    on
        order.member_id = member.id
    left join
        order_item
    on
        order.id=order_item.order.id

    * */

}
