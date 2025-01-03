package com.example.CalendarProject.Comment.Repository;

import com.example.CalendarProject.Comment.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
