package com.leaf.posRestServer.daoImpl;

import com.leaf.posRestServer.dao.SysRoleAuthorityDAO;
import com.leaf.posRestServer.entity.SysRole;
import com.leaf.posRestServer.entity.SysRoleAuthority;
import com.leaf.posRestServer.entity.SysRoleAuthority_;
import com.leaf.posRestServer.entity.SysRole_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

/**
 * Created by Rusiru on 07-Jan-18.
 */
@Repository
public class SysRoleAuthorityDAOImpl implements SysRoleAuthorityDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SysRoleAuthority> getSysRoleAuthorityBySysRoles(List<SysRole> sysRoles) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SysRoleAuthority> criteriaQuery = criteriaBuilder.createQuery(SysRoleAuthority.class);
        Root<SysRoleAuthority> root = criteriaQuery.from(SysRoleAuthority.class);
        criteriaQuery.select(root).distinct(true);
        CriteriaBuilder.In<Long> sysRoleIn = criteriaBuilder.in(root.get(SysRoleAuthority_.sysRole).get(SysRole_.id));
        sysRoles.forEach(sysRole -> {
            sysRoleIn.value(sysRole.getId());
        });
        criteriaQuery.where(sysRoleIn);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
