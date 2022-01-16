package com.david.optional.demo;

import com.david.optional.dto.MemberCardDTO;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Optional;

import static com.david.optional.dto.MembershipLevelEnum.GOLD;
import static com.david.optional.dto.MembershipLevelEnum.PLATINUM;

public class OptionalExampleDemo {

    public static void main(String[] args) {

        MemberCardDTO card = new MemberCardDTO("1");

        getDiscountWithoutOptional(card);
        getDiscountWithOptional(card);
    }

    private static Double getDiscountWithoutOptional(MemberCardDTO card) {

        if (PLATINUM.equals(card.getLevel())) {
            return 10.0D;
        } else if (GOLD.equals(card.getLevel())) {
            return 5.0D;
        }
        return null;
    }

    private static Optional<Double> getDiscountWithOptional(MemberCardDTO card) {

        if (PLATINUM.equals(card.getLevel())) {
            return Optional.of(10.0D);
        } else if (GOLD.equals(card.getLevel())) {
            return Optional.of(5.0D);
        }
        return Optional.empty();
    }





}
