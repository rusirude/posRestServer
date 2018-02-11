package com.leaf.posRestServer.controller;

import com.leaf.posRestServer.dto.SysRoleDTO;
import com.leaf.posRestServer.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Rusiru on 31-Jan-18.
 */

@RestController
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @PreAuthorize("hasRole('ROLE_ROLE')")
    @RequestMapping(value = "saveSysRole", method = RequestMethod.POST)
    public ResponseEntity<?> saveSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
        return ResponseEntity.ok().body(sysRoleService.saveSysRole(sysRoleDTO, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }
}
