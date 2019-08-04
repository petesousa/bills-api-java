package com.deliver.bills.converters;

import com.deliver.bills.dto.CreateBill;
import org.springframework.stereotype.Component;

@Component
public class CreateBillConverter {

    public CreateBill encode(CreateBill input) {
        return CreateBill.builder()
                .title(input.getTitle())
                .value(input.getValue())
                .dueDate(input.getDueDate())
                .build();
    }

}
