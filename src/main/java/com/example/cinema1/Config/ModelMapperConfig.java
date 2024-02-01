package com.example.cinema1.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    //    cau hinh cua modelmapper
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
