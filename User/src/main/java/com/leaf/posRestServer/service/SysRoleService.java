package com.leaf.posRestServer.service;

import com.leaf.posRestServer.dto.CommonResponseDTO;
import com.leaf.posRestServer.dto.DataTableRequestDTO;
import com.leaf.posRestServer.dto.DataTableResponseDTO;
import com.leaf.posRestServer.dto.SysRoleDTO;

/**
 * @author : Rusiru on 31-Jan-18.
 */
public interface SysRoleService {

    /**
     * Service for Save System Role to DB
     *
     * @param sysRoleDTO- System Role DTO from controller
     * @param loggedUser  - Logged User
     * @return CommonResponseDTO
     */
    CommonResponseDTO saveSysRole(SysRoleDTO sysRoleDTO, String loggedUser);

    /**
     * Service for Update System Role to DB
     *
     * @param sysRoleDTO- System Role DTO from controller
     * @param loggedUser  - Logged User
     * @return CommonResponseDTO
     */
    CommonResponseDTO updateSysRole(SysRoleDTO sysRoleDTO, String loggedUser);

    /**
     * Service for Soft Delete System Role to DB
     *
     * @param sysRoleDTO- System Role DTO from controller
     * @param loggedUser  - Logged User
     * @return CommonResponseDTO
     */
    CommonResponseDTO deleteSysRole(SysRoleDTO sysRoleDTO, String loggedUser);

    /**
     * Service for Search System Role from DB
     *
     * @param sysRoleDTO- System Role DTO from controller
     * @return CommonResponseDTO
     */
    CommonResponseDTO searchSysRole(SysRoleDTO sysRoleDTO);

    /**
     * Service for getting All Sys roles to Data Table
     * @param dataTableRequestDTO - request Dto from client
     * @return DataTableResponseDTO
     */
    DataTableResponseDTO searchSysRolesForDataTable(DataTableRequestDTO dataTableRequestDTO);
}
