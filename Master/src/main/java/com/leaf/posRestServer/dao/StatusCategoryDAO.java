package com.leaf.posRestServer.dao;

import com.leaf.posRestServer.entity.StatusCategory;

/**
 * @author : Rusiru on 03-Dec-17.
 */
public interface StatusCategoryDAO {

    /**
     * Get Status Category By id from DB
     *
     * @param id - Id of Status Category
     * @return StatusCategory
     */
    StatusCategory findStatusCategory(Integer id);

    /**
     * Get Status Category by code from DB
     * @param code - code of Status Category
     * @return StatusCategory
     */
    StatusCategory findStatusCategoryByCode(String code);
}
