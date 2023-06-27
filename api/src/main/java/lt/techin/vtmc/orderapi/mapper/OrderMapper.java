package lt.techin.vtmc.orderapi.mapper;

import lt.techin.vtmc.orderapi.order.Order;
import lt.techin.vtmc.orderapi.order.CreateOrderRequest;
import lt.techin.vtmc.orderapi.rest.dto.OrderDto;

public interface OrderMapper {

    Order toOrder(CreateOrderRequest createOrderRequest);

    OrderDto toOrderDto(Order order);
}