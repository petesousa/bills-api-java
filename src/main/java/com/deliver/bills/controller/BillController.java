package com.deliver.bills.controller;

import com.deliver.bills.dto.PayBill;
import com.deliver.bills.dto.CreateBill;
import com.deliver.bills.service.BillService;
import com.deliver.bills.domain.entities.Bill;
import com.deliver.bills.converters.PayBillConverter;
import com.deliver.bills.converters.CreateBillConverter;

import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;

@RestController("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private CreateBillConverter createBillConverter;

    @Autowired
    private PayBillConverter payBillConverter;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Bill> get(@PageableDefault(size = 5, sort = "dueDate", direction = Sort.Direction.DESC) Pageable page) {
        return billService.getPage(page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bill createBill(@RequestBody CreateBill request) {
        return billService.createBill(createBillConverter.encode(request));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Bill payBill(@RequestBody PayBill request) {
        return billService.payBill(payBillConverter.encode(request));
    }

}