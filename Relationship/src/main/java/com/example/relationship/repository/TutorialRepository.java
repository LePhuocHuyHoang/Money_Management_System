package com.example.relationship.repository;

import java.util.List;

import com.example.relationship.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    // ...
    List<Tutorial> findTutorialsByTagsId(Long tagId);
    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findByPublished(boolean published);
}
