package com.example.RegisterLogin.Repository;

import com.example.RegisterLogin.Entity.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrRepository extends JpaRepository<HR, Long> {
}
