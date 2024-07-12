package com.cardealer.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import static com.cardealer.enums.UserRole.BUYER;

@RequiredArgsConstructor
public enum Permission {

    SELLER_READ("seller:read"),
    SELLER_UPDATE("seller:update"),
    SELLER_CREATE("seller:create"),
    SELLER_DELETE("seller:delete");

    @Getter
    private final String permission;
    
}
