package com.diary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*******************************************************************************
 * Class        : 
 * Created date : 
 * Lasted date  : 
 * Author       : 
 * Change log   : : 01:00  create a new
 ******************************************************************************/
@Entity
@Table(name = "diary_subject")
@Getter
@Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "subject_name")
    private String subjectName;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<EventEntity> events;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
