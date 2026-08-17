package com.diary.service;

import com.diary.dto.EventDto;
import com.diary.dto.SubjectDto;
import com.diary.entity.EventEntity;
import com.diary.entity.SubjectEntity;
import com.diary.repository.EventRepository;
import com.diary.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*******************************************************************************
 * Class        : 
 * Created date : 
 * Lasted date  : 
 * Author       : 
 * Change log   : : 01:00  create a new
 ******************************************************************************/

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final SubjectRepository subjectRepository;
    private final EventRepository eventRepository;

    public SubjectDto getDiary(Long subjectId) {

        SubjectEntity subject = subjectRepository.findById(subjectId)
                .orElseThrow();

        List<EventDto> details = eventRepository
                .findBySubjectIdOrderByActionDateAsc(subjectId)
                .stream()
                .map(this::toDto)
                .toList();

        SubjectDto dto = new SubjectDto();
        dto.setId(subject.getId());
        dto.setSubjectCode(subject.getSubjectCode());
        dto.setSubjectName(subject.getSubjectName());
        dto.setListDetail(details);

        return dto;
    }

    private EventDto toDto(EventEntity e) {

        EventDto dto = new EventDto();
        dto.setId(e.getId());
        dto.setSubjectId(e.getSubject().getId());
        dto.setActionDate(e.getActionDate());
        dto.setEvent(e.getEvent());
        dto.setContent(e.getContent());

        return dto;
    }

    public void addEvent(
            Long subjectId,
            String event,
            String content) {

        EventEntity eventEntity = new EventEntity();

        SubjectEntity subject = subjectRepository.findById(subjectId)
                .orElseThrow();

        eventEntity.setSubject(subject);
        eventEntity.setActionDate(LocalDateTime.now());
        eventEntity.setEvent(event);
        eventEntity.setContent(content);

        eventRepository.save(eventEntity);
    }
}
