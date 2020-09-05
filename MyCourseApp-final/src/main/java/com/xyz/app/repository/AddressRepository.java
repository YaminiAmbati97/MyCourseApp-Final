package com.xyz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.app.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
