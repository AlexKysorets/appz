package com.example.appz;

import com.example.appz.models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.lang.module.Configuration;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.appz.models"})
public class AppzApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppzApplication.class, args);
    }

}
