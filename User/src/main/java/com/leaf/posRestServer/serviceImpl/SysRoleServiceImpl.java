package com.leaf.posRestServer.serviceImpl;

import com.leaf.posRestServer.dao.StatusDAO;
import com.leaf.posRestServer.dao.SysRoleDAO;
import com.leaf.posRestServer.dto.CommonResponseDTO;
import com.leaf.posRestServer.dto.SysRoleDTO;
import com.leaf.posRestServer.entity.SysRole;
import com.leaf.posRestServer.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author : Rusiru on 31-Jan-18.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    SysRoleDAO sysRoleDAO;

    @Autowired
    StatusDAO statusDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO saveSysRole(SysRoleDTO sysRoleDTO) {
        try {
            SysRole sysRole = new SysRole();
            sysRole.setCode(sysRoleDTO.getCode());
            sysRole.setDescription(sysRoleDTO.getDescription());
            sysRole.setStatus(statusDAO.findStatusByCode(sysRoleDTO.getStatus()));
            sysRole.setCreatedBy("system");
            sysRole.setCreatedOn(new Date());
            sysRoleDAO.saveSysRole(sysRole);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS","Saved "+sysRoleDTO.getDescription());
    }
}
