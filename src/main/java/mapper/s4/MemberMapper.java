package mapper.s4;

import domain.Member;
import domain.MemberDTO;
import domain.Product;

import java.util.List;
import java.util.Optional;

public interface MemberMapper {
    List<MemberDTO> findAll();

    Optional<Member> findById();

}
