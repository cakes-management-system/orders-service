package com.koltsov.cms.service.orders;

import com.koltsov.cms.starter.web.dto.cake.CakeDto;
import com.koltsov.cms.starter.web.dto.order.OrderCreateDto;
import com.koltsov.cms.starter.web.dto.order.OrderDto;
import com.koltsov.cms.starter.web.dto.user.UserDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

@UtilityClass
public class OrderHelper {

    public static final CakeDto CAKE_DTO = new CakeDto();
    public static final UserDto USER_DTO = new UserDto();
    public static final Long ID = 1L;
    public static final Long USER_ID = 10L;
    public static final Long CAKE_ID = 100L;
    public static final LocalDateTime DELIVERY_DATE = LocalDateTime.of(
            LocalDate.of(2020, Month.JANUARY, 1),
            LocalTime.MIDNIGHT
    );

    static {
        CAKE_DTO.setId(CAKE_ID);
        USER_DTO.setId(USER_ID);
    }

    public static Order orderEntity() {
        return orderEntity(ID, USER_ID, CAKE_ID, DELIVERY_DATE);
    }

    public static Order orderEntity(Long id, Long userId, Long cakeId, LocalDateTime deliveryDate) {
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId);
        order.setCakeId(cakeId);
        order.setDeliveryDate(deliveryDate);
        return order;
    }

    public static OrderDto orderDto() {
        return orderDto(ID, CAKE_DTO, USER_DTO, DELIVERY_DATE);
    }

    public static OrderDto orderDto(Long id, CakeDto cakeDto, UserDto userDto, LocalDateTime deliveryDate) {
        return new OrderDto(id, cakeDto, userDto, deliveryDate);
    }

    public static OrderCreateDto orderCreateDto() {
        return new OrderCreateDto(CAKE_ID, USER_ID, DELIVERY_DATE);
    }
}
