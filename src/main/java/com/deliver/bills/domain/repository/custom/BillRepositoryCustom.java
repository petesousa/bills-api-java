package com.deliver.bills.domain.repository.custom;

import com.deliver.bills.domain.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BillRepositoryCustom extends JpaRepository<Bill, Long> {

}
