package com.leaf.posRestServer.serviceImpl;

import com.leaf.posRestServer.dao.SysRoleDAO;
import com.leaf.posRestServer.dto.CommonResponseDTO;
import com.leaf.posRestServer.dto.SysRoleDTO;
import com.leaf.posRestServer.entity.SysRole;
import com.leaf.posRestServer.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Rusiru on 31-Jan-18.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    SysRoleDAO sysRoleDAO;

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

            sysRoleDAO.saveSysRole(sysRole);
        }
        catch (Exception e){}
        return null;
    }
}
