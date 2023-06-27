package lt.techin.vtmc.orderapi.services;

import java.util.Objects;

public class ServiceEntityDto extends ServiceDto {

    private Long id;

    public ServiceEntityDto() {
    }

    public ServiceEntityDto(String name, Long id) {
        super(name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServiceEntityDto that = (ServiceEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "ServiceEntityDto{" +
                "id=" + id +
                '}';
    }
}
