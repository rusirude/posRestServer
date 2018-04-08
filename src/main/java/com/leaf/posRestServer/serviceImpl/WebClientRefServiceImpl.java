package com.leaf.posRestServer.serviceImpl;

import com.leaf.posRestServer.dao.StatusCategoryDAO;
import com.leaf.posRestServer.dto.CommonSelectBoxDTO;
import com.leaf.posRestServer.enums.StatusCategoryEnum;
import com.leaf.posRestServer.service.WebClientRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Rusiru on 11-Mar-18.
 */

@Service
public class WebClientRefServiceImpl implements WebClientRefService {

    @Autowired
    StatusCategoryDAO statusCategoryDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public HashMap<String, Object> gerRefDataForSysRole() {
        HashMap<String, Object> map = null;
        try {
            map = new HashMap<>();
            map.put("status",StatusListDropdownDtoForStatusCategoryCode(StatusCategoryEnum.DEFAULT.getCode()));

        } catch (Exception e) {
            System.err.println(e);
        }
        return map;
    }

    private List<CommonSelectBoxDTO> StatusListDropdownDtoForStatusCategoryCode(String code) {
        List<CommonSelectBoxDTO> boxDTOs = new ArrayList<>();
        try {
            statusCategoryDAO.findStatusCategoryByCode(code).getStatuses()
                    .stream()
                    .forEach(status -> {
                        CommonSelectBoxDTO dto = new CommonSelectBoxDTO();
                        dto.setCode(status.getCode());
                        dto.setDescription(status.getDescription());
                        boxDTOs.add(dto);
                    });
        } catch (Exception e) {
            System.err.println(e);
        }
        return boxDTOs;
    }
}
