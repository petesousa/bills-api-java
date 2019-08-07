package com.deliver.bills.converters;

import com.deliver.bills.domain.entity.Bill;
import com.deliver.bills.dto.PaidBill;
import org.springframework.stereotype.Component;

@Component
public class PaidBillConverter {

    public Bill encode(PaidBill input) {
        return Bill.builder()
                .title(input.getTitle())
                .value(input.getValue())
                .dueDate(input.getDueDate())
                .paymentDay(input.getPaymentDate())
                .valueWithInterest(input.getValueWithInterest())
                .build();
    }

}
