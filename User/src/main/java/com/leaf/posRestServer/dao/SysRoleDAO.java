package com.leaf.posRestServer.dao;

import com.leaf.posRestServer.entity.SysRole;

/**
 * @author : Rusiru on 31-Jan-18.
 */
public interface SysRoleDAO {

    /**
     * Get Reference SysRole Object By id
     *
     * @param id - Id of System Role
     * @return SysRole ref Object
     */
    SysRole loadSysRole(long id);

    /**
     * Get SysRole By id from DB
     *
     * @param id - Id of System Role
     * @return SysRole
     */
    SysRole findSysRole(long id);

    /**
     * Get Sys Role by code from DB
     *
     * @param code - code of System Role
     * @return SysRole
     */
    SysRole findSysRoleByCode(String code);

    /**
     * Save SysRole to the DB
     *
     * @param sysRole - System Role
     */
    void saveSysRole(SysRole sysRole);

    /**
     * Update SysRole in DB
     *
     * @param sysRole - System Role
     */
    void updateSysRole(SysRole sysRole);
}
