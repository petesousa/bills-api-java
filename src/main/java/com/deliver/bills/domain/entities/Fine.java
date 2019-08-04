package com.deliver.bills.domain.entities;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fine {

    @NotNull
    private Long daysLate;

    @NotNull
    private double finePercentage;

    @NotNull
    private double dailyPercentage;

}