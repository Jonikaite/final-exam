package lt.techin.vtmc.orderapi.services;

import java.awt.*;

public class ServiceMapper {

    public static ServiceDto toServiceDto(Service service) {
        ServiceDto serviceDto = new ServiceDto();

        serviceDto.setName(service.getName());

        return serviceDto;
    }

    public static ServiceEntityDto toServiceEntityDto(Service service) {
        ServiceEntityDto serviceEntityDto = new ServiceEntityDto();

        serviceEntityDto.setId(service.getId());
        serviceEntityDto.setName(service.getName());

        return serviceEntityDto;
    }

    public static Service toService(ServiceDto serviceDto) {
        Service service = new Service();

        service.setName(serviceDto.getName());
        return service;
    }

    public static Service toServiceFromEntityDto(ServiceEntityDto serviceEntityDto) {
        Service service = new Service();

        service.setId(serviceEntityDto.getId());
        service.setName(serviceEntityDto.getName());

        return service;
    }
    
}
