package com.deliver.bills.domain.repository;

import com.deliver.bills.domain.entities.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends PagingAndSortingRepository<Bill, Long> {

}
