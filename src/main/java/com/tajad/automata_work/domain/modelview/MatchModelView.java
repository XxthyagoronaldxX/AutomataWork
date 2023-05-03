package com.tajad.automata_work.domain.modelview;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.MatchResult;

@Getter
@Setter
@NoArgsConstructor
public class MatchModelView {
    private String text;
    private int startIndex;
    private int endIndex;

    public static MatchModelView fromMatchResult(MatchResult matchResult) {
        MatchModelView matchModelView = new MatchModelView();

        matchModelView.setText(matchResult.group());
        matchModelView.setStartIndex(matchResult.start());
        matchModelView.setEndIndex(matchResult.end() - 1);

        return matchModelView;
    }
}
