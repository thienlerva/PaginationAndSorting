package com.app.pagination.PaginationSortingProject.controller;

import com.app.pagination.PaginationSortingProject.exception.PaginationSortingException;
import com.app.pagination.PaginationSortingProject.exception.PagingSortingErrorResponse;
import com.app.pagination.PaginationSortingProject.model.Direction;
import com.app.pagination.PaginationSortingProject.model.OrderBy;
import com.app.pagination.PaginationSortingProject.model.PagingEntity;
import com.app.pagination.PaginationSortingProject.service.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pagination")
public class PaginationController {

    @Autowired
    PaginationService paginationService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/conditionalPagination", params = { "orderBy", "direction", "page",
            "size" }, method = RequestMethod.GET)
    @ResponseBody
    public Page<PagingEntity> findJsonDataByPageAndSize(@RequestParam("orderBy") String orderBy,
                                                        @RequestParam("direction") String direction, @RequestParam("page") int page,
                                                        @RequestParam("size") int size) {
        if (!(direction.equals(Direction.ASCENDING.getDirectionCode())
                || direction.equals(Direction.DESCENDING.getDirectionCode()))) {
            throw new PaginationSortingException("Invalid sort direction");
        }
        if (!(orderBy.equals(OrderBy.ID.getOrderByCode()) || orderBy.equals(OrderBy.USERID.getOrderByCode()))) {
            throw new PaginationSortingException("Invalid orderBy condition");
        }
        Page<PagingEntity> list = paginationService.findJsonDataByCondition(orderBy, direction, page, size);
        return list;
    }

    @ExceptionHandler(PaginationSortingException.class)
    public ResponseEntity<PagingSortingErrorResponse> exceptionHandler(Exception ex) {
        PagingSortingErrorResponse pagingSortingErrorResponse = new PagingSortingErrorResponse();
        pagingSortingErrorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        pagingSortingErrorResponse.setMessage(ex.getMessage());

        return new ResponseEntity<>(pagingSortingErrorResponse, HttpStatus.OK);
    }
}
