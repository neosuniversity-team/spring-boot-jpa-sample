package com.neosuniversity.jpa;

import com.neosuniversity.jpa.domain.Employee;
import com.neosuniversity.jpa.domain.Rol;
import com.neosuniversity.jpa.repo.EmployeeRepository;
import com.neosuniversity.jpa.repo.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

import java.util.List;
import java.util.Optional;



@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;


	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> listnames = repo.findEmployeeByFirstName("Cristian");
		listnames.forEach(System.out::println);

		System.out.println("------------------------");

		List<Employee> list = repo.findAll();
		list.forEach(System.out::println);

		System.out.println("------------------------");

		Optional<Employee> opt = repo.findById(3);

		if (opt.isPresent()) {
			Employee emp = opt.get();


			System.out.println("El empleado 3 es: ");
			System.out.println(emp);

			emp.setFirstName("Fabiola");
			repo.save(emp);
		}



//
//		Employee emp = new Employee();
//		emp.setFirstName("Laura");
//		emp.setLastName("Perez");
//		emp.setEmail("laura@gmail.com");

		//repo.save(emp);

		System.out.println("------------------------");

		list = repo.findAll();
		list.forEach(System.out::println);


	}
}


@Component
class RolInit implements CommandLineRunner {

	@Autowired
	private RolRepository repoRol;

	@Override
	public void run(String... args) throws Exception {

		 List<Rol>  roles= repoRol.findAll();

		 roles.forEach(System.out::println);
	}
}
