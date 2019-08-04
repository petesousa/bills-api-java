package com.deliver.bills.helpers;

import com.deliver.bills.domain.entities.Fine;

public final class FineRule {

    public FineRule() {
        throw new IllegalStateException("This class cannot be instantiated.");
    }

    public static Fine fineRule(Long daysLate) {
        if (daysLate <= 3) { return new Fine(daysLate, 2, 0.1); }
        if (daysLate <= 5) { return new Fine(daysLate, 3, 0.2); }
        return new Fine(daysLate, 5, 0.3);
    }

}