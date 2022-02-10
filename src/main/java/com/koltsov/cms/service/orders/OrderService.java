package com.koltsov.cms.service.orders;

import com.koltsov.cms.starter.service.DefaultCrudService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends DefaultCrudService<Order, Long> {

    @Override
    protected void updateFields(Order to, Order from) {
        to.setCakeId(from.getCakeId());
        to.setUserId(from.getUserId());
        to.setDeliveryDate(from.getDeliveryDate());
    }
}
