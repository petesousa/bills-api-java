package com.deliver.bills.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBill {

    @NotNull
    String title;

    @NotNull
    double value;

    @NotNull
    LocalDate dueDate;

}