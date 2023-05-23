package com.myshop.Service.Impl;

import com.myshop.Bean.Role;
import com.myshop.Repository.IRoleRepository;
import com.myshop.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findById(Integer roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }
}
