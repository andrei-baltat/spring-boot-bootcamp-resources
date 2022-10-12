package com.ltp.gradesubmission.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "score", nullable = false)
    private String score;

    // Many grades to one student. Deci primul cuvant referentiaza entitatea curenta
    // student_id este numele coloanei din tabela grade. Este foreign key la tabela student
    //  asta e unidirectionala
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id" ,referencedColumnName = "id")
    private Student student;

}
