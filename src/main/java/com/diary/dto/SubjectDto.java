package com.diary.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
    private Long id;

    private String subjectCode;

    private String subjectName;

    private List<EventDto> listDetail;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

}
