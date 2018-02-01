package com.sjabonir.entity;

import javax.persistence.*;



@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findEmployeeByName",
                query = "select * from employee e where e.name = :name limit 1",
                resultClass = Employee.class
        ),
        @NamedNativeQuery(
                name = "callSpEmployee",
                query = "CALL getSpEmployee(:id)",
                resultClass = Employee.class
        )
})
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private Integer age;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
