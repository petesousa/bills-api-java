package com.deliver.bills.domain.repository;

import com.deliver.bills.domain.entity.Bill;
import com.deliver.bills.domain.repository.custom.BillRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>, BillRepositoryCustom {

}
