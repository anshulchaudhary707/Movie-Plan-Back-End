package com.example.movieplan;

import com.example.movieplan.model.Role;
import com.example.movieplan.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class MoviePlanApplication implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepo;
    public static void main(String[] args) {
        SpringApplication.run(MoviePlanApplication.class, args);
    }
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            Role role1 = new Role(501,"ROLE_ADMIN");
            Role role2 = new Role(502,"ROLE_NORMAL");
            Role role3 = new Role(503,"ROLE_THEATRE");
            this.roleRepo.save(role1);
            this.roleRepo.save(role2);
            this.roleRepo.save(role3);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
