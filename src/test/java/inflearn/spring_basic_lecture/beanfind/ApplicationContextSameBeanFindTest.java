package inflearn.spring_basic_lecture.beanfind;

import inflearn.spring_basic_lecture.AppConfig;
import inflearn.spring_basic_lecture.member.MemberRepository;
import inflearn.spring_basic_lecture.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DuplicateConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 있으면 중복 오류가 발생한다")
    void 같은_타입_조회(){
        MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        System.out.println(memberRepository.getClass());
        for(String s : beansOfType.keySet()){
            System.out.println(s);
        }
    }


    @Configuration
    static class DuplicateConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
