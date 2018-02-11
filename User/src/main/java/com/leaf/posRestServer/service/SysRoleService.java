package com.leaf.posRestServer.service;

import com.leaf.posRestServer.dto.CommonResponseDTO;
import com.leaf.posRestServer.dto.SysRoleDTO;

/**
 * @author : Rusiru on 31-Jan-18.
 */
public interface SysRoleService {

    /**
     * Service for Save System Role to DB
     * @param sysRoleDTO- System Role DTO from controller
     * @param loggedUser - Logged User
     * @return CommonResponseDTO
     */
    CommonResponseDTO saveSysRole(SysRoleDTO sysRoleDTO,String loggedUser);
}
