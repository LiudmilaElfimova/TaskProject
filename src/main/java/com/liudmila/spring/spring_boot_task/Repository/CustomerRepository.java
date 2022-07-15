package com.liudmila.spring.spring_boot_task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.liudmila.spring.spring_boot_task.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
