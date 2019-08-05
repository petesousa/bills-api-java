package com.deliver.bills.helpers;

import java.time.LocalDate;

import com.deliver.bills.dto.Fine;
import com.deliver.bills.domain.entity.Bill;

public final class BillWithInterest {

    public BillWithInterest() {
        throw new IllegalStateException("This class cannot be instantiated.");
    }

    public static void billWithInterest(Bill bill, Fine fine) {

        double value = bill.getValue();
        Long daysLate = fine.getDaysLate();
        double finePercentage = fine.getFinePercentage();
        double dailyPercentage = fine.getDailyPercentage();
        double valueWithInterest;

        double fineValue = value * (finePercentage / 100);
        double interestValue = daysLate * (value * (dailyPercentage / 100));
        valueWithInterest = value + fineValue + interestValue;

        bill.setPaymentDay(LocalDate.now());
        bill.setValueWithInterest(valueWithInterest);

    }

}