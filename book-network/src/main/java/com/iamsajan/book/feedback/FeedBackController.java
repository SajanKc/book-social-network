package com.iamsajan.book.feedback;

import com.iamsajan.book.common.PageResponse;
import com.iamsajan.book.feedback.dto.FeedbackRequest;
import com.iamsajan.book.feedback.dto.FeedbackResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedbacks")
@RequiredArgsConstructor
@Tag(name = "Feedback", description = "Feedback API")
public class FeedBackController {
    private final FeedBackService feedBackService;

    @PostMapping
    public ResponseEntity<Integer> saveFeedback(
            @Valid @RequestBody FeedbackRequest feedbackRequest,
            Authentication connectedUser) {
        return ResponseEntity.ok(feedBackService.saveFeedback(feedbackRequest, connectedUser));
    }

    @GetMapping("{/book/{book-id}")
    public ResponseEntity<PageResponse<FeedbackResponse>> findAllFeedbackByBook(
            @PathVariable("book-id") Integer bookId,
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
            Authentication connectedUser) {
        return ResponseEntity.ok(feedBackService.findAllFeedbackByBook(bookId, page, size, connectedUser));
    }
}
