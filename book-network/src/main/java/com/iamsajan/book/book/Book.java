package com.iamsajan.book.book;

import com.iamsajan.book.User.User;
import com.iamsajan.book.common.BaseEntity;
import com.iamsajan.book.feedback.Feedback;
import com.iamsajan.book.history.BookTransactionHistory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {

    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    @ManyToOne
    @JoinColumn(name = "owner_id") // optional
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    @Transient
    public double getRate() {
        if (feedbacks == null || feedbacks.isEmpty()) {
            return 0;
        }
        var rate = feedbacks.stream().mapToDouble(Feedback::getNote).average().orElse(0);
        // 2.23 --> 2.0
        return Math.round(rate * 10.0) / 10.0;
    }
}
