package lt.techin.vtmc.orderapi.workers;


import lt.techin.vtmc.orderapi.services.Service;

import java.util.Objects;

public class WorkerDto {
    private Long id;
    private String name;
    private String lastName;
    private String specialization;
    private String city;
    private Service service;

    public WorkerDto() {
    }

    public WorkerDto(Long id, String name, String lastName, String specialization, String city, Service service) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialization = specialization;
        this.city = city;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerDto workerDto = (WorkerDto) o;
        return Objects.equals(id, workerDto.id) && Objects.equals(name, workerDto.name) && Objects.equals(lastName, workerDto.lastName) && Objects.equals(specialization, workerDto.specialization) && Objects.equals(city, workerDto.city) && Objects.equals(service, workerDto.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, specialization, city, service);
    }

    @Override
    public String toString() {
        return "WorkerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", city='" + city + '\'' +
                ", service=" + service +
                '}';
    }
}
