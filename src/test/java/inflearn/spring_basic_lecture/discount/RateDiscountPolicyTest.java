package inflearn.spring_basic_lecture.discount;

import inflearn.spring_basic_lecture.member.Grade;
import inflearn.spring_basic_lecture.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("할인정책 성공")
    void vip_o(){
        Member member = new Member(1L,"임얼쑤", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }
}