package com.tajad.automata_work.domain.dtos;

import com.tajad.automata_work.domain.utils.enums.ReviewType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDTO {
    @NotBlank
    private String text;
    @NotNull
    private ReviewType reviewType;
    private int x;
    private int y;
}
