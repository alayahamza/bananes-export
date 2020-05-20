package com.alenia.bananesexport.repository;

import com.alenia.bananesexport.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataRecipientRepository extends JpaRepository<Recipient, Long> {
}
