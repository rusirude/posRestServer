package com.leaf.posRestServer.daoImpl;

import com.leaf.posRestServer.dao.StatusDAO;
import com.leaf.posRestServer.entity.Status;
import com.leaf.posRestServer.entity.Status_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    public Status findStatusByCode(String code) {
        Status status = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Status> criteriaQuery = criteriaBuilder.createQuery(Status.class);
        Root<Status> root = criteriaQuery.from(Status.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get(Status_.code), code)
        );

        try {
            status = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
        }

        return status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateStatus(Status status) {
        entityManager.merge(status);
    }
}
