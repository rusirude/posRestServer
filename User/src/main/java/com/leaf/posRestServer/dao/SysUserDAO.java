package com.leaf.posRestServer.dao;

import com.leaf.posRestServer.entity.SysUser;

/**
 * Created by Rusiru on 01-Jan-18.
 */
public interface SysUserDAO {

    /**
     * Get User Entity By Username
     * @param username
     * @return SysUser
     */
    SysUser getSysUserByUsername(String username);
}
