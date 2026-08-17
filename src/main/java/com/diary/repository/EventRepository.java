package com.diary.repository;

import com.diary.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*******************************************************************************
 * Class        : 
 * Created date : 
 * Lasted date  : 
 * Author       : 
 * Change log   : : 01:00  create a new
 ******************************************************************************/
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    List<EventEntity> findBySubjectIdOrderByActionDateAsc(Long subjectId);
}
