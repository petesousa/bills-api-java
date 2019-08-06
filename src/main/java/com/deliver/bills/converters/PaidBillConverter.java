package com.deliver.bills.converters;

import com.deliver.bills.dto.PaidBill;
import org.springframework.stereotype.Component;

@Component
public class PaidBillConverter {

    public PaidBill encode(PaidBill input) {
        return PaidBill.builder()
                .title(input.getTitle())
                .value(input.getValue())
                .dueDate(input.getDueDate())
                .paymentDate(input.getPaymentDate())
                .valueWithInterest(input.getValueWithInterest())
                .build();
    }

}
