package com.joonseolee.springsecuritytutorial.mapper;

import com.joonseolee.springsecuritytutorial.domain.Account;
import com.joonseolee.springsecuritytutorial.domain.AccountDto;
import org.mapstruct.Mapper;

/**
 * spring bean 으로 등록하고싶다면 인자를 넣어준다.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "username", source = "username2")
    Account toAccount(AccountDto accountDto);
//    @InheritInverseConfiguration
    AccountDto toAccountDto(Account account);
}
