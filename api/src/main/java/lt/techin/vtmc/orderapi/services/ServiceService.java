//package lt.techin.vtmc.orderapi.services;
//
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import java.awt.*;
//import java.util.Optional;
//
//@Service
//public class ServiceService {
//    private final ServiceRepository serviceRepository;
//
//    public ServiceService(ServiceRepository serviceRepository) {
//        this.serviceRepository = serviceRepository;
//    }
//
//    public List<Service> getAll() {
//        return serviceRepository.findAll();
//    }
//
//    public Optional<Service> getById(Long id) {
//        return ServiceRepository.findById(id);
//    }
//
//    public boolean deleteById(Long id) {
//        try {
//            serviceRepository.deleteById(id);
//            return true;
//        } catch (EmptyResultDataAccessException exception) {
//            return false;
//        }
//    }
//
//    public Service create(Service service) {
//        return serviceRepository.save(service);
//    }
//
//    public Service replaceService(Long id, Service service) {
//        service.setId(id);
//        return serviceRepository.save(service);
//    }
//
//    public Service updateService(Long id, Service service) {
//        var existingService = serviceRepository.findById(id).orElseThrow();
//
//        existingService.setName(service.getName());
//        existingService.setWorkers(service.getWorkers));
//
//        return serviceRepository.save(existingService);
//    }
//}
