package com.deliver.bills.domain.repository.custom;

import com.deliver.bills.domain.GenericQueryDslSupport;
import com.deliver.bills.domain.entity.Bill;
import com.deliver.bills.domain.entity.QBill;
import org.springframework.data.domain.Page;

public class BillRepositoryCustomImpl extends GenericQueryDslSupport<Bill> implements BillRepositoryCustom {

    private static final QBill qBill = QBill.bill;

    @Override
    public Page<Bill> findPaidBills() {
        return (Page<Bill>) from(qBill).where(qBill.paymentDay.isNotNull());
    }

}
