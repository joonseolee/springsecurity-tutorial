package com.joonseolee.springsecuritytutorial.domain;

import org.mapstruct.*;

import java.util.List;
import java.util.stream.Stream;

/**
 * spring bean 으로 등록하고싶다면 인자를 넣어준다.
 */
@Mapper(config = CommonMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@DecoratedWith(AccountMapperDecorator.class)
public interface AccountMapper {

    @Mapping(target = "age", source = "age")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRoles", ignore = true)
    Account toAccount(AccountDto accountDto);

    @Mapping(target = "role", ignore = true)
    @InheritInverseConfiguration
    AccountDto toAccountDto(Account account);

    @IterableMapping(numberFormat = "$#.00")
    List<String> prices(List<Integer> prices);

    @InheritInverseConfiguration
    List<AccountDto> toAccountDtos(Stream<Account> accounts);

    @ValueMapping(source = "EXTRA", target = "SPECIAL")
    @ValueMapping(source = "STANDARD", target = "DEFAULT")
    @ValueMapping(source = MappingConstants.NULL, target = "DEFAULT")
    @ValueMapping(source = "NORMAL", target = MappingConstants.NULL)
    ExternalOrderType toExternalOrderType(OrderType orderType);
}
