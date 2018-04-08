package com.leaf.posRestServer.dao;

import com.leaf.posRestServer.dto.DataTableRequestDTO;
import com.leaf.posRestServer.entity.SysRole;

import java.util.List;

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

    /**
     * Getting Slices of Sys Role Entities
     * @param dataTableRequestDTO - data Table request from client
     * @return List of SysRole
     */
    List<SysRole> searchSysRoleWithDataTableCriteria(DataTableRequestDTO dataTableRequestDTO);

    /**
     * Getting Search row count
     * @param dataTableRequestDTO - data Table request from client
     * @return Long
     */
    Long searchSysRoleCountWithDataTableCriteria(DataTableRequestDTO dataTableRequestDTO);

}
