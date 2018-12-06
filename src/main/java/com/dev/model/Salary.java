package com.dev.model;

import javax.persistence.*;

@Entity
@Table(name="salary")
public class Salary {

    @Id
    private int id;

    @Column(name = "id_doctor")
    private int idDoctor;

    private int sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
