package com.koltsov.cms.service.orders;

import com.koltsov.cms.starter.client.CakeClient;
import com.koltsov.cms.starter.client.UserClient;
import com.koltsov.cms.starter.mapper.CakeMangerMapperConfig;
import com.koltsov.cms.starter.mapper.GenericMapper;
import com.koltsov.cms.starter.web.dto.order.OrderCreateDto;
import com.koltsov.cms.starter.web.dto.order.OrderDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = CakeMangerMapperConfig.class)
public abstract class OrderMapper implements GenericMapper<Order, OrderDto, OrderCreateDto> {

    @Autowired
    private CakeClient cakeClient;
    @Autowired
    private UserClient userClient;

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "cake", ignore = true)
    public abstract OrderDto toDto(Order entity);

    @AfterMapping
    void afterToDtoMapping(Order entity, @MappingTarget OrderDto orderDto) {
        orderDto.setCake(cakeClient.getCakeById(entity.getCakeId()));
        orderDto.setUser(userClient.getUserById(entity.getUserId()));
    }

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "cakeId", source = "cake.id")
    @Override
    public abstract Order toEntity(OrderDto dto);

    @Mapping(target = "id", ignore = true)
    @Override
    public abstract Order toNewEntity(OrderCreateDto createDto);
}
