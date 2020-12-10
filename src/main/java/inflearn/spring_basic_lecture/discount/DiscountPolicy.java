package inflearn.spring_basic_lecture.discount;

import inflearn.spring_basic_lecture.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
