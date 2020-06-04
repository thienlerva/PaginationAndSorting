package com.app.pagination.PaginationSortingProject.repository;

import com.app.pagination.PaginationSortingProject.model.PagingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationDao extends PagingAndSortingRepository<PagingEntity, Integer> {
}
