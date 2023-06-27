package lt.techin.vtmc.orderapi.workers;

import lt.techin.vtmc.orderapi.services.Service;

import java.util.Objects;

public class WorkerEntityDto  extends WorkerDto{
     private Long id;

    public WorkerEntityDto() {
    }

    public WorkerEntityDto(Long id, String name, String lastName, String specialization, String city, Service service) {
        super(id, name, lastName, specialization, city, service);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WorkerEntityDto that = (WorkerEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }


    @Override
    public String toString() {
        return "WorkerEntityDto{" +
                "id=" + id +
                '}';
    }
}
