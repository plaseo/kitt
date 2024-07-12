package com.cardealer.enums;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//enum allows you to define a collection of related constants
//  each constant is a distinct value
@RequiredArgsConstructor
public enum UserRole {

    BUYER(Collections.emptySet()),
    SELLER(Set.of(
        Permission.SELLER_READ,
        Permission.SELLER_UPDATE,
        Permission.SELLER_CREATE,
        Permission.SELLER_DELETE
    ));
    
    @Getter
    private final Set<Permission> permissions;

}
