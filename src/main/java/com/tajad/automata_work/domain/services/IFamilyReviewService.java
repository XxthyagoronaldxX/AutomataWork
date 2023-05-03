package com.tajad.automata_work.domain.services;

import com.tajad.automata_work.domain.dtos.ReviewDTO;
import com.tajad.automata_work.domain.exceptions.InvalidArgumentException;
import com.tajad.automata_work.domain.modelview.MatchModelView;

import java.util.List;

public interface IFamilyReviewService {
    List<MatchModelView> handleReview(ReviewDTO dto) throws InvalidArgumentException;
}
