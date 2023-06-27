//package lt.techin.vtmc.orderapi.workers;
//
//import lt.techin.vtmc.orderapi.services.ServiceRepository;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class WorkerService {
//    private final WorkerRepository workerRepository;
//    private final ServiceRepository serviceRepository;
//
//    public WorkerService(WorkerRepository workerRepository, ServiceRepository serviceRepository) {
//        this.workerRepository = workerRepository;
//        this.serviceRepository = serviceRepository;
//    }
//
//    public List<Worker> getAll() {
//        return workerRepository.findAll();
//    }
//
//    public Optional<Worker> getById(Long id) {
//        return workerRepository.findById(id);
//    }
//
//    public boolean deleteById(Long id) {
//        try {
//            workerRepository.deleteById(id);
//            return true;
//        } catch (EmptyResultDataAccessException exception) {
//            return false;
//        }
//    }
//
//    public Worker create(Worker worker) {
//        return workerRepository.save(worker);
//    }
//
//    public Worker replaceWorker(Long id, Worker worker) {
//        worker.setId(id);
//        return workerRepository.save(worker);
//    }
//
//    public Worker updateWorker(Long id, Worker worker) {
//        Worker existingWorker = workerRepository.findById(id).orElseThrow();
//
//        existingWorker.setName(worker.getName());
//        existingWorker.setLastName(worker.getLastName());
//        existingWorker.setSpecialization(worker.getSpecialization());
//        existingWorker.setCity(worker.getCity());
//        existingWorker.setService(worker.getService());
//
//        return workerRepository.save(existingWorker);
//    }
//
//    public List<Worker> getAllByServiceId(Long workerId) {
//        return workerRepository.findWorkersByServiceId(workerId);
//    }
//}
