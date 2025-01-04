package com.example.CalendarProject.Comment.Service;

import com.example.CalendarProject.Comment.Dto.AddCommentRequest;
import com.example.CalendarProject.Comment.Dto.CommentResponse;
import com.example.CalendarProject.Comment.Dto.UpdateCommentRequest;
import com.example.CalendarProject.Comment.Entity.Comment;
import com.example.CalendarProject.Comment.Repository.CommentRepository;
import com.example.CalendarProject.Common.Code.ErrorCode;
import com.example.CalendarProject.Comment.Exception.CommentNullException;
import com.example.CalendarProject.Event.Exception.EventNullException;
import com.example.CalendarProject.Customer.Exception.InvalidCustomerInfoException;
import com.example.CalendarProject.Customer.Entity.Customer;
import com.example.CalendarProject.Customer.Repository.CustomerRepository;
import com.example.CalendarProject.Event.Entity.Event;
import com.example.CalendarProject.Event.Repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CustomerRepository customerRepository;
    private final EventRepository eventRepository;


    public CommentResponse saveComment(AddCommentRequest request, Long customerId, Long eventId){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new InvalidCustomerInfoException(ErrorCode.NULL_POINT_CUSTOMER));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new EventNullException(ErrorCode.NULL_POINT_EVENT));

        Comment comment = new Comment (customer, event, request);

        Comment saveComment = commentRepository.save(comment);

        return new CommentResponse(saveComment);
    }



    public CommentResponse findCommentById(Long id){
        Comment comment = findCommentOrElseThrowException(id);

        return new CommentResponse(comment);
    }



    public CommentResponse updateComment(Long id, UpdateCommentRequest request){

        Comment comment = findCommentOrElseThrowException(id);

        comment.update(request);

        return new CommentResponse(comment);
    }


    public void delete(Long id){
        Comment comment = findCommentOrElseThrowException(id);

        commentRepository.deleteById(id);
    }


    public Comment findCommentOrElseThrowException(Long id){
        Comment findComment = commentRepository.findById(id)
                .orElseThrow(()-> new CommentNullException(ErrorCode.NULL_POINT_COMMENT));
        return findComment;
    }
}
