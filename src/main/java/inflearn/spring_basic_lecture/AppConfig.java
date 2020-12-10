package inflearn.spring_basic_lecture;

import inflearn.spring_basic_lecture.discount.DiscountPolicy;
import inflearn.spring_basic_lecture.discount.FixDiscountPolicy;
import inflearn.spring_basic_lecture.discount.RateDiscountPolicy;
import inflearn.spring_basic_lecture.member.MemberRepository;
import inflearn.spring_basic_lecture.member.MemberService;
import inflearn.spring_basic_lecture.member.MemberServiceIml;
import inflearn.spring_basic_lecture.member.MemoryMemberRepository;
import inflearn.spring_basic_lecture.order.OrderService;
import inflearn.spring_basic_lecture.order.OrderServiceIml;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceIml(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("AppConfig.orderService");
        return new OrderServiceIml(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
