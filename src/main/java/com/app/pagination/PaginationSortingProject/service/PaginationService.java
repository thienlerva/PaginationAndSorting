package com.app.pagination.PaginationSortingProject.service;

import com.app.pagination.PaginationSortingProject.model.PagingEntity;
import com.app.pagination.PaginationSortingProject.repository.PaginationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class PaginationService {

    @Autowired
    PaginationDao paginationDao;

    public Page<PagingEntity> findJsonDataByCondition(String orderBy, String direction, int page, int size) {
        Sort sort = null;
        if (direction.equals("ASC")) {
            sort = Sort.by(new Sort.Order(Sort.Direction.ASC, orderBy));
        }
        if (direction.equals("DESC")) {
            sort = Sort.by(new Sort.Order(Sort.Direction.DESC, orderBy));
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<PagingEntity> data = paginationDao.findAll(pageable);
        return data;
    }
}
