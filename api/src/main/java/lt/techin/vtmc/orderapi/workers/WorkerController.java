//package lt.techin.vtmc.orderapi.workers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import static lt.techin.vtmc.orderapi.workers.WorkerMapper.toWorker;
//import static lt.techin.vtmc.orderapi.workers.WorkerMapper.toWorkerDto;
//
//import java.util.List;
//
//import static java.util.stream.Collectors.toList;
//import static org.springframework.http.ResponseEntity.ok;
//
//
//@RestController
//    @RequestMapping("/api/v1/workers")
//    public class WorkerController {
//
//    public Logger logger = LoggerFactory.getLogger(WorkerController.class);
//
//    private final WorkerService workerService;
//
//    public WorkerController(WorkerService workerService) {
//        this.workerService = workerService;
//    }
//
//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public List<WorkerEntityDto> getWorkers() {
//        return workerService.getAll().stream().map(WorkerMapper::toWorkerEntityDto).collect(toList());
//    }
//
//    @GetMapping(value = "/{workerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Worker> getWorker(@PathVariable Long workerId) {
//        var workerOptional = workerService.getById(workerId);
//
//        var responseEntity = workerOptional.map(worker -> ok(worker)).orElseGet(() -> ResponseEntity.notFound().build());
//
//        return responseEntity;
//    }
//
//    @PostMapping(value="/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<WorkerDto> createWorker(@RequestBody WorkerDto workerDto) {
//        var createdComment = workerService.create(toWorker(workerDto));
//        return ok(toWorkerDto(createdComment));
//    }
//
//    @PatchMapping(value = "/update/{workerId}")
//    public ResponseEntity<WorkerDto> updateWorker(@PathVariable Long workerId, @RequestBody WorkerDto workerDto) {
//        var updatedWorker = workerService.updateWorker(workerId, toWorker(workerDto));
//        return ok(toWorkerDto(updatedWorker));
//    }
//
//    @DeleteMapping(value = "/{workerId}")
//    public ResponseEntity<Boolean> deleteWorker(@PathVariable Long workerId) {
//        var isDeleted = workerService.deleteById(workerId);
//        return ok(isDeleted);
//    }
//
//}
