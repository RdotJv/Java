package com.example.sqltesting;
//import com.example.sqltesting.repositories.ProductRepository;
import com.example.sqltesting.model.Profile;
import com.example.sqltesting.repositories.ProfileRepository;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;


public class SqltestingApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
			var profileRepository = context.getBean(ProfileRepository.class);
			profileRepository.addProfile(new Profile("abc", 68));
			List<Profile> profileList = profileRepository.getProfiles();
			profileList.forEach(System.out::println);
		}
	}
}
