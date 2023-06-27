package lt.techin.vtmc.orderapi.services;

import java.util.Objects;

public class ServiceDto {

    private String name;

    public ServiceDto() {
    }

    public ServiceDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDto that = (ServiceDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ServiceDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
