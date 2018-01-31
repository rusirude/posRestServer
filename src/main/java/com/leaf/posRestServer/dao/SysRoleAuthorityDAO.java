package com.leaf.posRestServer.dao;

import com.leaf.posRestServer.entity.SysRole;
import com.leaf.posRestServer.entity.SysRoleAuthority;

import java.util.List;
import java.util.Set;

/**
 * @author : Rusiru on 06-Jan-18.
 */
public interface SysRoleAuthorityDAO {
    /**
     * Get Distinct SysRoleAuthority by Role
     * @param sysRoles
     * @return List of SysRoleAuthority
     */
    List<SysRoleAuthority> getSysRoleAuthorityBySysRoles(List<SysRole> sysRoles);
}
