package lt.techin.vtmc.orderapi.workers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository <Worker, Long> {
    List<Worker> findWorkersByServiceId(Long serviceId);
}
