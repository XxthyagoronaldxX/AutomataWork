package com.tajad.automata_work.domain.services.impl;

import com.tajad.automata_work.domain.dtos.ReviewDTO;
import com.tajad.automata_work.domain.exceptions.InvalidArgumentException;
import com.tajad.automata_work.domain.modelview.MatchModelView;
import com.tajad.automata_work.domain.services.IFamilyReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FamilyReviewServiceImpl implements IFamilyReviewService {
    @Override
    public List<MatchModelView> handleReview(ReviewDTO dto) throws InvalidArgumentException {
        String text = dto.getText();
        String regex = getRegexByDTO(dto);

        return generateMatchModelsFromRegexAndText(regex, text);
    }

    private List<MatchModelView> generateMatchModelsFromRegexAndText(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<MatchModelView> matchModelViews = new ArrayList<>();
        matcher.results().forEach((result) -> {
            if (result.end() <= text.length() - 1) {
                char flag_end = text.charAt(result.end());

                if (flag_end != '$') return;
            }

            if (result.start() != 0) {
                char flag_start = text.charAt(result.start() - 1);

                if (flag_start != '$') return;
            }

            matchModelViews.add(MatchModelView.fromMatchResult(result));
        });

        return matchModelViews;
    }

    private String getRegexByDTO(ReviewDTO dto) throws InvalidArgumentException {
        switch (dto.getReviewType()) {
            case LETTER_A:
                return "(MH|HM)((h)*m(h)*m(h|m)*|h(h|m)*|(hmh|mhh|hhm)(h|m)*)";
            case LETTER_B:
                return "(MH|HM)h*m(mh*m|h)*";
            case LETTER_C:
                return "(MH|HM)m(m|h)*h";
            case LETTER_D:
                return "(HH|MM)(hm|mh)(h|m){2,}(hm|mh)";
            case LETTER_E:
                return "(HH|MM)((hm|mh)*[hm]?)?";
            case LETTER_F:
                return "(HH|MM)((h?m+|m+h?)*h?)?";
            case LETTER_G:
                if (dto.getX() < 1) {
                    throw new InvalidArgumentException("The value X must have to be higher than or equal to 1.");
                }

                if (dto.getX() > dto.getY()) {
                    throw new InvalidArgumentException("The value X can't be higher than Y.");
                }

                return "[HM]{X,Y}((h|m)*(mhh|mh|m)|hh|h)?"
                        .replace("X", String.valueOf(dto.getX()))
                        .replace("Y", String.valueOf(dto.getY()));
            default:
                return "";
        }
    }
}
