package com.leaf.posRestServer.dao;

import com.leaf.posRestServer.entity.Status;

/**
 * @author : Rusiru on 31-Jan-18.
 */
public interface StatusDAO {

    /**
     * Get Status By code from DB
     *
     * @param code - code of Status
     * @return Status
     */
    Status findStatusByCode(String code);

    /**
     * Update Status
     */
    void updateStatus(Status status);
}
