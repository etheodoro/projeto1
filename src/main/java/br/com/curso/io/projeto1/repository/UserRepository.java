package br.com.curso.io.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.curso.io.projeto1.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);
	
	@Query("SELECT u FROM User u WHERE u.name like %?1%")
	User findByQualquerCoisa(String name);

}
