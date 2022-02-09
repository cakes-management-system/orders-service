package com.koltsov.cms.service.orders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.koltsov.cms.service.orders.OrderHelper.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Test
    void updateFields() {
        Order to = orderEntity(null, null, null, null);
        Order from = orderEntity();
        orderService.updateFields(to, from);

        assertAll(
                () -> assertNull(to.getId()),
                () -> assertEquals(CAKE_ID, to.getCakeId()),
                () -> assertEquals(USER_ID, to.getUserId()),
                () -> assertEquals(DELIVERY_DATE, to.getDeliveryDate())
        );
    }
}