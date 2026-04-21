import domain.MemberDTO;
import mapper.s4.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import util.HikariMyBatisConnector;
import util.MyBatisSessionConnector;

import java.util.List;

public class ResultMapTests {


    private static final String MAPPER_PACKAGE = "mapper.s4";
    private static final String ALIAS_PACKAGE = "domain";

    private static final MyBatisSessionConnector connector = new HikariMyBatisConnector(
            MAPPER_PACKAGE,
            ALIAS_PACKAGE
    );

    static void main(){
        test1();
    }
    static void test1(){

        System.out.println("ResultMapTests.test1");

        try(SqlSession session = connector.openSession()){
            MemberMapper mapper = session.getMapper(MemberMapper.class);

            List<MemberDTO> members = mapper.findAll();

            MemberDTO findMember = members.getLast();

            String memberName = findMember.getMemberName();
            System.out.println("memberName" + memberName);
//            System.out.println("findMember.getPassword() : "+ findMember.getPassword());


        }

    }

}
