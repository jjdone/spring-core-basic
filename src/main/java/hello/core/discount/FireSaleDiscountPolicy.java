package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class FireSaleDiscountPolicy implements DiscountPolicy{

    private int basicSaleRate = 50;
    private int specialSaleRate = 70;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * specialSaleRate / 100;
        }else {
            return price * basicSaleRate / 100;
        }
    }
}
