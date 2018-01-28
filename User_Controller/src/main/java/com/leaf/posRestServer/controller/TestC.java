package com.leaf.posRestServer.controller;

import com.leaf.posRestServer.dao.StatusCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rusiru on 19-Nov-17.
 */
@RestController
public class TestC {
    @Autowired
    private StatusCategoryDAO statusCategoryDAO;
    @PostMapping("/login")
         public String home() {

        return "working.......!";
    }

    @PostMapping("/rest")
    public String home2() {

        return "working2.......!";
    }
}
