package com.zpasthapana;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableScheduling
public class ZpasthapanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZpasthapanaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mp = new ModelMapper();
	    Converter<String, LocalDateTime> toStringDateTime = new AbstractConverter<String, LocalDateTime>() {
	        @Override
	        protected LocalDateTime convert(String source) {
	        	LocalDateTime localDate = LocalDateTime.now();
	        	try {
	        		localDate = LocalDateTime.parse(source);
	        	} catch (Exception e) {
				}
	            return localDate;
	        }
	    };
	    
	    Converter<String, Date> toStringDate = new AbstractConverter<String, Date>() {
	        @Override
	        protected Date convert(String source) {
	        	try {
	        		Date localDate = new Date();
	        		if(StringUtils.contains(source, "India Standard Time")) {
	        			DateFormat inputFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH);
	        			localDate = inputFormat.parse(source);
	        		} else {
	        			localDate = new SimpleDateFormat("yyyy-MM-dd").parse(source);
	        		}
	        		return localDate;
	        	} catch (Exception e) {
				}
	            return null;
	        }
	    };
		mp.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		mp.addConverter(toStringDate);
		mp.addConverter(toStringDateTime);
		return mp;
	}
	
	@Bean
    public ObjectMapper objectMapper() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        ObjectMapper dateFormatMapper = new ObjectMapper();
        dateFormatMapper.setDateFormat(dateFormat);
        return dateFormatMapper;
    }
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	   return new WebMvcConfigurerAdapter() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/**").allowedOrigins("*");
	      }    
	   };
	}
}
