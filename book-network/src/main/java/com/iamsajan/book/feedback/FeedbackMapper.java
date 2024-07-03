package com.iamsajan.book.feedback;

import com.iamsajan.book.User.User;
import com.iamsajan.book.book.Book;
import com.iamsajan.book.feedback.dto.FeedbackRequest;
import com.iamsajan.book.feedback.dto.FeedbackResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FeedbackMapper {
    public Feedback toFeedback(FeedbackRequest feedbackRequest, User user, Book book) {
        return Feedback.builder()
                .note(feedbackRequest.note())
                .comment(feedbackRequest.comment())
                .book(Book.builder()
                        .id(feedbackRequest.bookId())
                        .archived(false) // Not required and has no impact, just to satisfy lombok
                        .shareable(false) // Not required and has no impact, just to satisfy lombok
                        .build())
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer id) {
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), id))
                .build();
    }
}
