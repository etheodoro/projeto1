package br.com.curso.io.projeto1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.curso.io.projeto1.entity.User;
import br.com.curso.io.projeto1.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>  {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if ( userRepository.findAll().isEmpty() ) {
			createUser("Evandro","evandrix@hotmail.com");
			createUser("Maria","maria@hotmail.com");
			createUser("João","joao@hotmail.com");
		}
		
		User user = userRepository.findByQualquerCoisa("Ev");
		
		System.out.println(user.toString());
		
	}

	public void createUser(String name, String email) {
		User user = new User(name,email);
		userRepository.save(user);
	}

}
