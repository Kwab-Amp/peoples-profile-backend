//package com.ttlabs.project.config;
//
//import okhttp3.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//public class LoadProfiles {
//    private static final Logger log = LoggerFactory.getLogger(LoadProfiles.class);
//    OkHttpClient client = new OkHttpClient();
//
//    @Bean
//    CommandLineRunner bobProfiles(){
//        String url = "https://api.hibob.com/v1/people";
//        Request request = new Request.Builder().url(url).addHeader("Authorization", "4drMC7Hjcjf4kTxyriFFhc53G3PVi4BRUH3SiFrP").addHeader("Accept", "application/json").build();
//        Call call = client.newCall(request);
//
//        try {
//            Response response = call.execute();
//            log.info(response.body().toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return args->{
//            log.info("profile gotten");
//        };
//    }
//}
