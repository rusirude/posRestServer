package com.leaf.posRestServer.serviceImpl;

import com.leaf.posRestServer.dao.StatusDAO;
import com.leaf.posRestServer.dao.SysRoleDAO;
import com.leaf.posRestServer.dto.CommonResponseDTO;
import com.leaf.posRestServer.dto.DataTableRequestDTO;
import com.leaf.posRestServer.dto.DataTableResponseDTO;
import com.leaf.posRestServer.dto.SysRoleDTO;
import com.leaf.posRestServer.entity.SysRole;
import com.leaf.posRestServer.enums.DeleteStatusEnum;
import com.leaf.posRestServer.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public CommonResponseDTO saveSysRole(SysRoleDTO sysRoleDTO,String loggedUser) {
        try {
            SysRole sysRole = new SysRole();
            sysRole.setCode(sysRoleDTO.getCode());
            sysRole.setDescription(sysRoleDTO.getDescription());
            sysRole.setStatus(statusDAO.findStatusByCode(sysRoleDTO.getStatus()));
            sysRole.setCreatedBy(loggedUser);
            sysRole.setCreatedOn(new Date());
            sysRoleDAO.saveSysRole(sysRole);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS","Saved "+sysRoleDTO.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO updateSysRole(SysRoleDTO sysRoleDTO,String loggedUser) {
        try {
            SysRole sysRole  = sysRoleDAO.findSysRoleByCode(sysRoleDTO.getCode());
            sysRole.setDescription(sysRoleDTO.getDescription());
            sysRole.setStatus(statusDAO.findStatusByCode(sysRoleDTO.getStatus()));
            sysRole.setUpdatedBy(loggedUser);
            sysRole.setUpdatedOn(new Date());
            sysRoleDAO.updateSysRole(sysRole);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS","Updated "+sysRoleDTO.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO deleteSysRole(SysRoleDTO sysRoleDTO,String loggedUser) {
        try {
            SysRole sysRole  = sysRoleDAO.findSysRoleByCode(sysRoleDTO.getCode());
            sysRole.setStatus(statusDAO.findStatusByCode(DeleteStatusEnum.DELETE.getCode()));
            sysRole.setUpdatedBy(loggedUser);
            sysRole.setUpdatedOn(new Date());
            sysRoleDAO.updateSysRole(sysRole);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS","Deleted "+sysRoleDTO.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CommonResponseDTO searchSysRole(SysRoleDTO sysRoleDTO) {
        SysRoleDTO roleDTO = null;
        try {
            SysRole sysRole  = sysRoleDAO.findSysRoleByCode(sysRoleDTO.getCode());
            roleDTO = new SysRoleDTO();
            roleDTO.setCode(sysRole.getCode());
            roleDTO.setDescription(sysRole.getDescription());
            roleDTO.setStatus(sysRole.getStatus().getCode());
            roleDTO.setCreatedBy(sysRole.getCreatedBy());
            roleDTO.setUpdatedBy(sysRole.getUpdatedBy());
            roleDTO.setCreatedOn(sysRole.getCreatedOn());
            roleDTO.setUpdatedOn(sysRole.getUpdatedOn());
        }
        catch (Exception e){
            System.err.println(e);
        }
        return new CommonResponseDTO("SUCCESS",roleDTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DataTableResponseDTO searchSysRolesForDataTable(DataTableRequestDTO dataTableRequestDTO){
        DataTableResponseDTO responseDTO = new DataTableResponseDTO();
        responseDTO.setDraw(dataTableRequestDTO.getDraw());
        try{
            List<SysRoleDTO> sysRoleDTOs = new ArrayList<>();
            Long count = sysRoleDAO.searchSysRoleCountWithDataTableCriteria(dataTableRequestDTO);
            sysRoleDAO.searchSysRoleWithDataTableCriteria(dataTableRequestDTO)
                    .stream()
                    .forEach(sysRole -> {
                        SysRoleDTO sysRoleDTO = new SysRoleDTO();
                        sysRoleDTO.setCode(sysRole.getCode());
                        sysRoleDTO.setDescription(sysRole.getDescription());
                        sysRoleDTO.setStatus(sysRole.getStatus().getDescription());
                        sysRoleDTO.setCreatedBy(sysRole.getCreatedBy());
                        sysRoleDTO.setCreatedOn(sysRole.getCreatedOn());
                        sysRoleDTO.setUpdatedBy(sysRole.getUpdatedBy());
                        sysRoleDTO.setUpdatedOn(sysRole.getUpdatedOn());
                        sysRoleDTOs.add(sysRoleDTO);
                    });
            responseDTO.setData(sysRoleDTOs);
            responseDTO.setRecordsFiltered(count);
            responseDTO.setRecordsTotal(count);
        }
        catch (Exception e){
            System.err.println(e);
        }
        return responseDTO;
    }
}
