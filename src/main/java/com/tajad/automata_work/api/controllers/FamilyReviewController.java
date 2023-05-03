package com.tajad.automata_work.api.controllers;

import com.tajad.automata_work.domain.dtos.ReviewDTO;
import com.tajad.automata_work.domain.exceptions.InvalidArgumentException;
import com.tajad.automata_work.domain.services.IFamilyReviewService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familyReview")
public class FamilyReviewController {
    private final IFamilyReviewService familyReviewService;

    public FamilyReviewController(IFamilyReviewService familyReviewService) {
        this.familyReviewService = familyReviewService;
    }

    @GetMapping
    public ResponseEntity<?> handleReview(@RequestBody @Valid ReviewDTO reviewDTO) throws InvalidArgumentException {
        return ResponseEntity.ok(familyReviewService.handleReview(reviewDTO));
    }
}
