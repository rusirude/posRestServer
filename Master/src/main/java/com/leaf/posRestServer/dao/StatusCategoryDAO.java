package com.leaf.posRestServer.dao;

import com.leaf.posRestServer.dto.StatusCategoryDTO;
import com.leaf.posRestServer.entity.StatusCategory;

import java.util.List;

/**
 * Created by Rusiru on 03-Dec-17.
 */
public interface StatusCategoryDAO {

    StatusCategory getAllStatusCategory(Integer id);
}
