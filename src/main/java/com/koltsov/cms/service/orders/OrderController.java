package com.koltsov.cms.service.orders;

import com.koltsov.cms.starter.web.controller.CrudController;
import com.koltsov.cms.starter.web.dto.order.OrderCreateDto;
import com.koltsov.cms.starter.web.dto.order.OrderDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController extends CrudController<Order, Long, OrderDto, OrderCreateDto> {
}
