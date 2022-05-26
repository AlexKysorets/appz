package com.example.appz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prediction")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prediction {
    @Id
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
}
