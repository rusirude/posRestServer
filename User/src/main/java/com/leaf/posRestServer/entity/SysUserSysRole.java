package com.leaf.posRestServer.entity;

import javax.persistence.*;

/**
 * Created by Rusiru on 11-Jan-18.
 */
@Entity
@Table(name = "sys_user_sys_role")
public class SysUserSysRole {

    private SysUserSysRoleId sysUserSysRoleId;
    private SysUser sysUser;
    private SysRole sysRole;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "sysUser", column = @Column(name = "sys_user", nullable = false)),
            @AttributeOverride(name = "sysRole", column = @Column(name = "sys_role", nullable = false))
    })
    public SysUserSysRoleId getSysUserSysRoleId() {
        return sysUserSysRoleId;
    }

    public void setSysUserSysRoleId(SysUserSysRoleId sysUserSysRoleId) {
        this.sysUserSysRoleId = sysUserSysRoleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_user", referencedColumnName = "username", insertable = false, updatable = false)
    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_role", referencedColumnName = "id", insertable = false, updatable = false)
    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
}
