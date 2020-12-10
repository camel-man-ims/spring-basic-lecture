package inflearn.spring_basic_lecture.order;

import inflearn.spring_basic_lecture.AppConfig;
import inflearn.spring_basic_lecture.member.Grade;
import inflearn.spring_basic_lecture.member.Member;
import inflearn.spring_basic_lecture.member.MemberService;
import inflearn.spring_basic_lecture.member.MemberServiceIml;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",100000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
