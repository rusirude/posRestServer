package com.leaf.posRestServer.daoImpl;

import com.leaf.posRestServer.dao.StatusCategoryDAO;
import com.leaf.posRestServer.entity.StatusCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author : Rusiru on 03-Dec-17.
 */
@Repository
public class StatusCategoryDAOImpl implements StatusCategoryDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public StatusCategory findStatusCategory(Integer id) {

        return entityManager.find(StatusCategory.class, id);
    }
}
