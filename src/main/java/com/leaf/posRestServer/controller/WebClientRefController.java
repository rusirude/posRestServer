package com.leaf.posRestServer.controller;

import com.leaf.posRestServer.service.WebClientRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Rusiru on 11-Mar-18.
 */
@RestController
public class WebClientRefController {

    @Autowired
    WebClientRefService webClientRefService;

    @PreAuthorize("hasRole('ROLE_ROLE')")
    @RequestMapping(value = "getRefDataForSysRole", method = RequestMethod.POST)
    public ResponseEntity<?> getRefDataForSysRole() {
        return ResponseEntity.ok().body(webClientRefService.gerRefDataForSysRole());
    }
}
