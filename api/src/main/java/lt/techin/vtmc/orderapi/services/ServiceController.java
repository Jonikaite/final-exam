//package lt.techin.vtmc.orderapi.services;
//
//import lt.techin.vtmc.orderapi.workers.WorkerEntityDto;
//import lt.techin.vtmc.orderapi.workers.WorkerMapper;
//import lt.techin.vtmc.orderapi.workers.WorkerService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.awt.*;
//
//import static java.util.stream.Collectors.toList;
//import lt.techin.vtmc.orderapi.services.ServiceMapper.toService;
//import lt.techin.vtmc.orderapi.services.ServiceMapper.toServiceDto;
//import static org.springframework.http.ResponseEntity.ok;
//
//@RestController
//@RequestMapping("api/v1/services")
//public class ServiceController {
//    public Logger logger = LoggerFactory.getLogger(ServiceController.class);
//
//    private final ServiceService serviceService;
//
//    private final WorkerService workerService;
//
//    public ServiceController(ServiceService serviceService, WorkerService workerService) {
//        this.serviceService = serviceService;
//        this.workerService = workerService;
//    }
//
//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public List<ServiceEntityDto> getServices() {
//        return serviceService.getAll().stream().map(ServiceMapper::toServiceEntityDto).collect(toList());
//    }
//
//    @GetMapping(value = "/{serviceId}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Service> getService(@PathVariable Long serviceId) {
//        var serviceOptional = serviceService.getById(serviceId);
//
//        var responseEntity = serviceOptional.map(service -> ok(service)).orElseGet(()-> ResponseEntity.notFound().build());
//
//        return responseEntity;
//    }
//
//    @DeleteMapping("/{serviceId}")
//    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
//        boolean deleted = serviceService.deleteById(serviceId);
//
//        if(deleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto serviceDto) {
//        var createdService = serviceService.create(toService(serviceDto));
//
//        return ok(toServiceDto(createdService));
//    }
//
//    @GetMapping(value = "/workers/{serviceId}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public java.util.List<WorkerEntityDto> getWorkersByServiceId(@PathVariable Long serviceId) {
//        return workerService.getAllByServiceId(serviceId).stream().map(WorkerMapper::toWorkerEntityDto).collect(toList());
//    }
//
//    @PatchMapping("update/{serviceId}")
//    public ResponseEntity<ServiceDto> updateService(@PathVariable Long serviceId, @RequestBody ServiceDto serviceDto) {
//        var updatedService = serviceService.updateService(serviceId, toService(serviceDto));
//        return ok(toServiceDto(updatedService));
//    }
//
//}
