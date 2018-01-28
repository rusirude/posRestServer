package com.leaf.posRestServer.service;

import com.leaf.posRestServer.dao.SysRoleAuthorityDAO;
import com.leaf.posRestServer.dao.SysUserDAO;
import com.leaf.posRestServer.entity.SysRole;
import com.leaf.posRestServer.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rusiru on 16-Dec-17.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    SysUserDAO sysUserDAO;
    @Autowired
    SysRoleAuthorityDAO sysRoleAuthorityDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            SysUser sysUser = sysUserDAO.getSysUserByUsername(username);
            return new User(sysUser.getUsername(), sysUser.getPassword(), getGrantedAuthoritiesForUser(sysUser));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Set<GrantedAuthority> getGrantedAuthoritiesForUser(SysUser user) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        List<SysRole> sysRoles = new ArrayList<>();
        user.getSysUserSysRoles()
                .forEach(sysUserSysRole -> {
                    sysRoles.add(sysUserSysRole.getSysRole());
                });
        if (sysRoles != null) {
            sysRoleAuthorityDAO.getSysRoleAuthorityBySysRoles(sysRoles)
                    .stream()
                    .forEach(roleAuthority -> {
                        grantedAuthoritySet.add(new SimpleGrantedAuthority(roleAuthority.getAuthority().getDescription()));
                    });
        }
        return grantedAuthoritySet;
    }
}
