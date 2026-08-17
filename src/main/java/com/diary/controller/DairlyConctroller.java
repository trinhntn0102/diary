package com.diary.controller;

import java.util.List;

import com.diary.entity.SubjectEntity;
import com.diary.repository.SubjectRepository;
import com.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diary.dto.SubjectDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DairlyConctroller {

    private final DiaryService diaryService;
    private final SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public String subjects(Model model) {

        List<SubjectEntity> subjects = subjectRepository.findAll();

        model.addAttribute("subjects", subjects);

        return "subjects";
    }

	@GetMapping("/diary")
    public String diary(Model model,  @RequestParam Long subjectId) {

        SubjectDto subject = diaryService.getDiary(subjectId);

        model.addAttribute("subject", subject);

        return "diary";
    }

    @PostMapping("/diary/{subjectId}/events")
    public String addEvent(
            @PathVariable Long subjectId,
            @RequestParam String event,
            @RequestParam String content) {

        diaryService.addEvent(subjectId, event, content);
        return "redirect:/diary?subjectId=" + subjectId;
    }
}
