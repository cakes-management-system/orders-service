package com.koltsov.cms.service.orders;

import com.koltsov.cms.starter.client.CakeClient;
import com.koltsov.cms.starter.client.UserClient;
import com.koltsov.cms.starter.web.dto.order.OrderCreateDto;
import com.koltsov.cms.starter.web.dto.order.OrderDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.koltsov.cms.service.orders.OrderHelper.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderMapperTest {

    @InjectMocks
    private OrderMapperImpl orderMapper;

    @Mock
    private CakeClient cakeClient;
    @Mock
    private UserClient userClient;

    @Test
    void toDto() {
        when(cakeClient.getCakeById(any(Long.class))).thenReturn(CAKE_DTO);
        when(userClient.getUserById(any(Long.class))).thenReturn(USER_DTO);

        Order entity = orderEntity();
        OrderDto expected = orderDto();

        OrderDto actual = orderMapper.toDto(entity);

        assertEquals(expected, actual);
    }

    @Test
    void afterToDtoMapping() {
        when(cakeClient.getCakeById(any(Long.class))).thenReturn(CAKE_DTO);
        when(userClient.getUserById(any(Long.class))).thenReturn(USER_DTO);

        Order entity = orderEntity();
        OrderDto dto = orderDto(ID, null, null, DELIVERY_DATE);

        orderMapper.afterToDtoMapping(entity, dto);

        assertAll(
                () -> verify(cakeClient).getCakeById(any(Long.class)),
                () -> verify(userClient).getUserById(any(Long.class)),
                () -> assertNotNull(dto.getCake()),
                () -> assertNotNull(dto.getUser())
        );
    }

    @Test
    void toEntity() {
        Order expected = orderEntity();
        OrderDto dto = orderDto();

        Order actual = orderMapper.toEntity(dto);

        assertOrderEquals(expected, actual);
    }

    @Test
    void toNewEntity() {
        Order expected = orderEntity(null, USER_ID, CAKE_ID, DELIVERY_DATE);
        OrderCreateDto dto = orderCreateDto();

        Order actual = orderMapper.toNewEntity(dto);

        assertOrderEquals(expected, actual);
    }

    private void assertOrderEquals(Order expected, Order actual) {
        assertAll(
                () -> assertEquals(expected.getId(), actual.getId(), "Wrong order ID"),
                () -> assertEquals(expected.getCakeId(), actual.getCakeId(), "Wrong cake ID"),
                () -> assertEquals(expected.getUserId(), actual.getUserId(), "Wrong user ID"),
                () -> assertEquals(expected.getDeliveryDate(), actual.getDeliveryDate(), "Wrong delivery date")
        );
    }
}