package com.deliver.bills.converters;

import com.deliver.bills.dto.PayBill;
import org.springframework.stereotype.Component;

@Component
public class PayBillConverter {

    public PayBill encode(PayBill input) {
        return PayBill.builder()
                .title(input.getTitle())
                .value(input.getValue())
                .dueDate(input.getDueDate())
                .paymentDate(input.getPaymentDate())
                .build();
    }

}
