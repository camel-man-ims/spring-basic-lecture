package inflearn.spring_basic_lecture.discount;

import inflearn.spring_basic_lecture.member.Grade;
import inflearn.spring_basic_lecture.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP){
            return price * discountPercent/100;
        }else{
            return 0;
        }
    }
}
