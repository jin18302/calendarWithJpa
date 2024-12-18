package com.example.CalendarProject.Service;

import com.example.CalendarProject.Dto.CommentDto.CommentAddRequest;
import com.example.CalendarProject.Dto.CommentDto.CommentResponse;
import com.example.CalendarProject.Dto.CommentDto.CommentUpdateRequest;
import com.example.CalendarProject.Entity.Comment;
import com.example.CalendarProject.Repository.CommentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

    public CommentResponse addComment(CommentAddRequest request){
       Comment comment =  repository.save(request.toEntity());
        return new CommentResponse(comment);
    }

    public CommentResponse findCommentById(Long id){
       Optional<Comment> findComment = repository.findById(id);

       if(findComment.isEmpty()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Comments with that ID don't exist");
       }

       Comment comment = findComment.get();

        return new CommentResponse(comment);
    }

    public CommentResponse updateComment(Long id, CommentUpdateRequest request){
        Optional<Comment> findComment = repository.findById(id);

        if(findComment.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Comments with that ID don't exist");
        }

        Comment comment = findComment.get();

        comment.update(request);

        return new CommentResponse(comment);
    }

    public void delete(Long id){
        Optional<Comment> findComment = repository.findById(id);

        if(findComment.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Comments with that ID don't exist");
        }
        repository.deleteById(id);
    }
}
