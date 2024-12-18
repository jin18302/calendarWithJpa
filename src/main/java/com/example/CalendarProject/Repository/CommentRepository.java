package com.example.CalendarProject.Repository;

import com.example.CalendarProject.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
