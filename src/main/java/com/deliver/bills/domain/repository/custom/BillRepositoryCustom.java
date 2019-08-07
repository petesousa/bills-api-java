package com.deliver.bills.domain.repository.custom;

import com.deliver.bills.domain.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepositoryCustom {

    Page<Bill> findPaidBills();

}
