package com.balance.balance;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
