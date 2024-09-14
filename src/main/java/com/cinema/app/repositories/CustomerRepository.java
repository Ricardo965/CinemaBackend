package com.cinema.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cinema.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
