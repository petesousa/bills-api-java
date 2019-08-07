package com.deliver.bills.converters;

import com.deliver.bills.domain.entity.Bill;
import com.deliver.bills.dto.CreateBill;
import org.springframework.stereotype.Component;

@Component
public class CreateBillConverter {

    public Bill encode(CreateBill input) {
        return Bill.builder()
                .title(input.getTitle())
                .value(input.getValue())
                .dueDate(input.getDueDate())
                .build();
    }

}
