package com.alexey.crud.rest;

import com.alexey.crud.model.Role;
import com.alexey.crud.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleRestController {

    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        if (roles == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}