package com.diary.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;

    private Long subjectId;

    private LocalDateTime actionDate;

    private String event;

    private String content;

    private LocalDateTime createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    public EventDto(LocalDateTime of, String bắtĐầuXửLý, String s) {
    }
}
