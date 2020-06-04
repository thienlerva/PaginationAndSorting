package com.app.pagination.PaginationSortingProject.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="json_data")
public class PagingEntity {

    @Id
    @Column
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;
    @Column
    private String title;
    @Column
    private String body;

}
