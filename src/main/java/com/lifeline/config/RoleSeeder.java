package com.lifeline.config;

import com.lifeline.entity.Role;
import com.lifeline.enums.RoleType;
import com.lifeline.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

        for (RoleType roleType : RoleType.values()) {

            if (roleRepository.findByRoleName(roleType).isEmpty()) {

                Role role = new Role();
                role.setRoleName(roleType);

                roleRepository.save(role);
            }
        }

        System.out.println("Default roles inserted successfully.");
    }
}