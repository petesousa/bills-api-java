package com.deliver.bills.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaidBill {

    String title;
    double value;
    LocalDate dueDate;
    LocalDate paymentDate;
    double valueWithInterest;

}