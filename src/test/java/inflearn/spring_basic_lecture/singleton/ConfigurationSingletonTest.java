package inflearn.spring_basic_lecture.singleton;

import inflearn.spring_basic_lecture.AppConfig;
import inflearn.spring_basic_lecture.member.MemberRepository;
import inflearn.spring_basic_lecture.member.MemberServiceIml;
import inflearn.spring_basic_lecture.order.OrderServiceIml;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceIml memberService = ac.getBean("memberService", MemberServiceIml.class);
        OrderServiceIml orderService = ac.getBean("orderService", OrderServiceIml.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        MemberRepository memberRepository = memberService.getMemberRepository();

        System.out.println("MemberServiceRepository --> memberRepository1 : "+ memberRepository1);
        System.out.println("OrderServiceRepository --> memberRepository2 : "+ memberRepository2);
        System.out.println("MemberRepository --> memberRepository: " + memberRepository);

    }

    @Test
    void beanTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println(bean);
    }
}
