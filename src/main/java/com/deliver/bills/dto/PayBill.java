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
public class PayBill {

    @NotNull
    Long id;

    String title;
    double value;
    LocalDate dueDate;
    LocalDate paymentDate;
    double valueWithInterest;

}