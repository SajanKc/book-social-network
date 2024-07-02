package com.iamsajan.book.feedback;

import com.iamsajan.book.User.User;
import com.iamsajan.book.book.Book;
import org.springframework.stereotype.Service;

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
}
