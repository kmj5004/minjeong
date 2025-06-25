package com.minjeong.usedPhone.repository;

import com.minjeong.usedPhone.entity.UsedPhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedPhoneRepository extends JpaRepository<UsedPhoneEntity, Long> {
}
