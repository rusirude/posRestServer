package com.leaf.posRestServer.daoImpl;

import com.leaf.posRestServer.dao.SysUserDAO;
import com.leaf.posRestServer.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by Rusiru on 07-Jan-18.
 */
@Repository
public class SysUserDAOImpl implements SysUserDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public SysUser getSysUserByUsername(String username) {
        return entityManager.find(SysUser.class,username);
    }
}
