package com.iamsajan.book.book;

import com.iamsajan.book.User.User;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book toBook(BookRequest bookRequest) {
        return Book
                .builder()
                .id(bookRequest.id())
                .title(bookRequest.title())
                .authorName(bookRequest.authorName())
                .isbn(bookRequest.isbn())
                .synopsis(bookRequest.synopsis())
                .archived(false)
                .shareable(bookRequest.shareable())
                .build();
    }
}
