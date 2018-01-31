package com.leaf.posRestServer.daoImpl;

import com.leaf.posRestServer.dao.StatusDAO;
import com.leaf.posRestServer.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author : Rusiru on 31-Jan-18.
 */
@Repository
public class StatusDAOImpl implements StatusDAO {

    @Autowired
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateStatus(Status status) {
        entityManager.merge(status);
    }
}
