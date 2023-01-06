package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FireSaleDiscountPolicyTest {

    private FireSaleDiscountPolicy fireSaleDiscountPolicy = new FireSaleDiscountPolicy();

    @Test
    @DisplayName("VIP이면 파격 세일 70퍼 할인된다.")
    void vip_o() {
        Member userA = new Member(1L, "userA", Grade.VIP);
        int discount = fireSaleDiscountPolicy.discount(userA, 10000);
        assertThat(discount).isEqualTo(7000);
    }

    @Test
    @DisplayName("VIP가 아니어도 파격 세일 50퍼 할인된다.")
    void vip_x() {
        Member userB = new Member(2L, "userB", Grade.BASIC);
        int discount = fireSaleDiscountPolicy.discount(userB, 10000);
        assertThat(discount).isEqualTo(5000);
    }
}