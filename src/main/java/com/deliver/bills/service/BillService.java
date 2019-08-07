package com.deliver.bills.service;

import com.deliver.bills.helpers.DaysLate;
import com.deliver.bills.helpers.FineRule;
import com.deliver.bills.domain.entity.Bill;
import com.deliver.bills.dto.Fine;
import com.deliver.bills.helpers.BillWithInterest;
import com.deliver.bills.exception.BadRequestException;
import com.deliver.bills.domain.repository.BillRepository;
import com.deliver.bills.domain.repository.custom.BillRepositoryCustomImpl;

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

    @Autowired
    private BillRepositoryCustomImpl billRepositoryCustomImpl;

    public Bill createBill(Bill createBill) {

        Bill bill = new Bill();
        bill.setTitle(createBill.getTitle());
        bill.setValue(createBill.getValue());
        bill.setDueDate(createBill.getDueDate());

        return billRepository.save(bill);

    }

    public Bill payBill(Long id) throws BadRequestException {

        Optional<Bill> findBill = billRepository.findById(id);

        if(!findBill.isPresent()) {
            throw new BadRequestException("The requested bill does not exist");
        }

        Bill bill = findBill.get();

        if (bill.getPaymentDay() != null) {
            throw new BadRequestException("This bill is already paid.");
        }

        Long daysLate = DaysLate.daysLate(bill.getDueDate());
        if (daysLate > 0) {
            Fine fine = FineRule.fineRule(daysLate);
            BillWithInterest.billWithInterest(bill, fine);
            return billRepository.save(bill);
        } else {
            bill.setValueWithInterest(bill.getValue());
        }

        bill.setPaymentDay(LocalDate.now());
        return billRepository.save(bill);

    }

    private boolean isPaid(Bill bill) {
        return bill.getPaymentDay() != null;
    }

    public Page<Bill> getPage(Pageable page) throws BadRequestException {
        return billRepository.findAll(page);
//        return billRepositoryCustomImpl.findPaidBills();
    }
}