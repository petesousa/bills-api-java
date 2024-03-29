package com.deliver.bills.controller;

import com.deliver.bills.dto.CreateBill;
import com.deliver.bills.exception.BadRequestException;
import com.deliver.bills.service.BillService;
import com.deliver.bills.domain.entity.Bill;
import com.deliver.bills.converters.CreateBillConverter;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private CreateBillConverter createBillConverter;

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<Bill> get(@PageableDefault(size = 10, sort = "dueDate", direction = Sort.Direction.DESC) Pageable page) throws BadRequestException {
        return billService.getPage(page);
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Bill createBill(@RequestBody CreateBill request) {
        return billService.createBill(createBillConverter.encode(request));
    }

    @CrossOrigin
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Bill payBill(@PathVariable("id") Long id) throws BadRequestException {
        return billService.payBill(id);
    }

}