package inflearn.spring_basic_lecture;

import inflearn.spring_basic_lecture.member.Grade;
import inflearn.spring_basic_lecture.member.Member;
import inflearn.spring_basic_lecture.member.MemberService;
import inflearn.spring_basic_lecture.member.MemberServiceIml;
import inflearn.spring_basic_lecture.order.Order;
import inflearn.spring_basic_lecture.order.OrderService;
import inflearn.spring_basic_lecture.order.OrderServiceIml;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",1200000);

        System.out.println(order);

    }
}
