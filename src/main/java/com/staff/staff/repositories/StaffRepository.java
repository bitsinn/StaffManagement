package com.staff.staff.repositories;

import com.staff.staff.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StaffRepository extends  JpaRepository<Staff, Long>{
}
