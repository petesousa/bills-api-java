package com.deliver.bills.helpers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class DaysLate {

    public DaysLate() {
        throw new IllegalStateException("This class cannot be instantiated.");
    }

    public static Long daysLate(LocalDate dueDate) {

        if(dueDate == null) { return new Long(0); }

        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(dueDate, today);

    }
}