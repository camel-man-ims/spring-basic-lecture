package inflearn.spring_basic_lecture.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService instance1 = ac.getBean(StatefulService.class);
        StatefulService instance2 = ac.getBean(StatefulService.class);

        int user_A_money = instance1.order("얼쑤",10000);
        int user_B_money = instance2.order("종원",30000);

        System.out.println(user_A_money);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}