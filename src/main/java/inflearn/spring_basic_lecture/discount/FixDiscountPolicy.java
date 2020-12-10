package inflearn.spring_basic_lecture.discount;

import inflearn.spring_basic_lecture.member.Grade;
import inflearn.spring_basic_lecture.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
