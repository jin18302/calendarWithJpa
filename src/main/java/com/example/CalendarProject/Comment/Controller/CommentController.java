package com.example.CalendarProject.Comment.Controller;

import com.example.CalendarProject.Comment.Dto.AddCommentRequest;
import com.example.CalendarProject.Comment.Dto.CommentResponse;
import com.example.CalendarProject.Comment.Dto.UpdateCommentRequest;
import com.example.CalendarProject.Comment.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CommentController {

    private final CommentService service;

    @PostMapping("/customers/{customerid}/events/{eventid}/comments")
    public ResponseEntity<CommentResponse> addComment(@Valid @RequestBody AddCommentRequest request,
                                                      @PathVariable(name = "customerid")Long customerId,
                                                      @PathVariable(name = "eventid")Long eventId) {
        CommentResponse response = service.saveComment(customerId, eventId, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findCommentById(@PathVariable Long id) {
        CommentResponse response = service.findCommentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable Long id, @Valid @RequestBody UpdateCommentRequest request) {
        CommentResponse response = service.updateComment(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
