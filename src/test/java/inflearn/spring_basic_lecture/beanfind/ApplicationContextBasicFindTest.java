package inflearn.spring_basic_lecture.beanfind;

import inflearn.spring_basic_lecture.AppConfig;
import inflearn.spring_basic_lecture.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        System.out.println(ac.getBean("memberService").getClass());
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX(){
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxx", MemberService.class));
        // jupiter
    }
}
