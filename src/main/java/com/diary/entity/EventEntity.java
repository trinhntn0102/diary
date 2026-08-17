package com.diary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/*******************************************************************************
 * Class        : 
 * Created date : 
 * Lasted date  : 
 * Author       : 
 * Change log   : : 01:00  create a new
 ******************************************************************************/
@Entity
@Table(name = "diary_event")
@Getter
@Setter
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @Column(name = "action_date")
    private LocalDateTime actionDate;

    @Column(name = "event_name")
    private String event;

    @Column(name = "event_description")
    private String content;
}
