package com.domain.RMS.SignUpRepository;

import com.domain.RMS.SignUpModel.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SignUpRepository extends JpaRepository<SignUp ,Long> {
}
