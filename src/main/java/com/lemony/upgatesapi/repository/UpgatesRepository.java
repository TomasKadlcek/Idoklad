package com.lemony.upgatesapi.repository;

import com.lemony.upgatesapi.repository.entity.UpgatesEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpgatesRepository extends PagingAndSortingRepository<UpgatesEntity, Long> {




}
