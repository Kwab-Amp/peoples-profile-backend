package com.ttlabs.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttlabs.project.models.GetFromBob;
import com.ttlabs.project.models.Profile;
import com.ttlabs.project.services.ProfileServiceImpl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	OkHttpClient client = new OkHttpClient();
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	ProfileServiceImpl profileService;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return  restTemplateBuilder.build();
	}



	@Bean
	public CommandLineRunner run(RestTemplate restTemplate)throws Exception{
		return args->{

			ArrayList<Profile> pros = new ArrayList<>();
			ArrayList<Map> bob = new ArrayList<Map>();
			String url = "https://api.hibob.com/v1/people";
			Request request = new Request.Builder().url(url).addHeader("Authorization", "4drMC7Hjcjf4kTxyriFFhc53G3PVi4BRUH3SiFrP").addHeader("Accept", "application/json").build();
			Call call = client.newCall(request);
			Response response = call.execute();
			String myResult = response.body().string();
			try{
				Map profiles = mapper.readValue(myResult,Map.class);
				ArrayList<Map> employees = (ArrayList<Map>) profiles.get("employees");
				for (Map emp:employees) {
					Map work = (Map) emp.get("work");
					Profile pro = new Profile();
					pro.setFullName(emp.get("fullName").toString());
					pro.setManager((boolean) work.get("isManager")); //this is in the work object
					pro.setEmail(emp.get("email").toString());
					if(emp.get("avatarUrl")!= null){
						pro.setProfilePicture(emp.get("avatarUrl").toString());
					}
					if (work.get("department")!=null){
						pro.setDepartment(work.get("department").toString());
					}
					pro.setTitle( work.get("title").toString());
					pros.add(pro);
				}
				for (Profile mm:pros) {
					System.out.println(mm.getFullName());
				}
				profileService.addAllProfiles(pros);
				System.out.println(pros.size());

			}catch (IOException e){
				e.printStackTrace();
			}
		};
	}
}
