package lt.techin.vtmc.orderapi.workers;

public class WorkerMapper {
    public static WorkerDto toWorkerDto(Worker worker) {
        WorkerDto workerDto = new WorkerDto();

        workerDto.setName(worker.getName());
        workerDto.setLastName(worker.getLastName());
        workerDto.setSpecialization(worker.getSpecialization());
        workerDto.setCity(worker.getCity());
        workerDto.setService(worker.getService());

        return workerDto;
    }

    public static WorkerEntityDto toWorkerEntityDto(Worker worker) {
        WorkerEntityDto workerEntityDto = new WorkerEntityDto();

        workerEntityDto.setId(worker.getId());
        workerEntityDto.setName(worker.getName());
        workerEntityDto.setLastName(worker.getLastName());
        workerEntityDto.setSpecialization(worker.getSpecialization());
        workerEntityDto.setCity(worker.getCity());
        workerEntityDto.setService(worker.getService());

        return workerEntityDto;
    }

    public static Worker toWorker(WorkerDto workerDto) {
        Worker worker = new Worker();

        worker.setName(workerDto.getName());
        worker.setLastName(workerDto.getLastName());
        worker.setSpecialization(workerDto.getSpecialization());
        worker.setCity(workerDto.getCity());
        worker.setService(workerDto.getService());

        return worker;
    }

    public static Worker toWorkerFromEntityDto(WorkerEntityDto workerEntityDto) {
        Worker worker = new Worker();

        worker.setId(workerEntityDto.getId());
        worker.setName(workerEntityDto.getName());
        worker.setLastName(workerEntityDto.getLastName());
        worker.setSpecialization(workerEntityDto.getSpecialization());
        worker.setCity(workerEntityDto.getCity());
        worker.setService(workerEntityDto.getService());

        return worker;
    }
    
}
