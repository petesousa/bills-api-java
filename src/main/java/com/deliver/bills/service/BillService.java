package com.deliver.bills.service;

import com.deliver.bills.dto.PayBill;
import com.deliver.bills.dto.CreateBill;
import com.deliver.bills.helpers.DaysLate;
import com.deliver.bills.helpers.FineRule;
import com.deliver.bills.domain.entity.Bill;
import com.deliver.bills.dto.Fine;
import com.deliver.bills.helpers.BillWithInterest;
import com.deliver.bills.exception.BadRequestException;
import com.deliver.bills.domain.repository.BillRepository;

import java.util.Optional;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill createBill(CreateBill createBill) {

        Bill bill = new Bill();
        bill.setTitle(createBill.getTitle());
        bill.setValue(createBill.getValue());
        bill.setDueDate(createBill.getDueDate());

        return billRepository.save(bill);

    }

    public Bill payBill(PayBill payBill) throws BadRequestException {

        Optional<Bill> findBill = billRepository.findById(payBill.getId());

        if(!findBill.isPresent()) {
            throw new BadRequestException("The requested bill does not exist");
        }

        Bill bill = findBill.get();
        Long daysLate = DaysLate.daysLate(bill.getDueDate());
        if (daysLate > 0) {
            Fine fine = FineRule.fineRule(daysLate);
            BillWithInterest.billWithInterest(bill, fine);
            return billRepository.save(bill);
        }

        bill.setPaymentDay(LocalDate.now());
        return billRepository.save(bill);

    }

    public Page<Bill> getPage(Pageable page) {
        return billRepository.findAll(page);
    }
}