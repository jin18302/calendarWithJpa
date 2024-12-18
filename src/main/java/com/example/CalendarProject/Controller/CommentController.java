package com.example.CalendarProject.Controller;

import com.example.CalendarProject.Dto.CommentDto.CommentAddRequest;
import com.example.CalendarProject.Dto.CommentDto.CommentResponse;
import com.example.CalendarProject.Dto.CommentDto.CommentUpdateRequest;
import com.example.CalendarProject.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar/comment")
public class CommentController {

    private final CommentService service;

    @PostMapping
    public ResponseEntity<CommentResponse> addComment(@RequestBody CommentAddRequest request) {
        CommentResponse response = service.addComment(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findCommentById(@PathVariable Long id) {
        CommentResponse response = service.findCommentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable Long id, @RequestBody CommentUpdateRequest request) {
        CommentResponse response = service.updateComment(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
