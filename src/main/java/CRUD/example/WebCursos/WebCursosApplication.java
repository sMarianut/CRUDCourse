package CRUD.example.WebCursos;

import CRUD.example.WebCursos.enums.Role;
import CRUD.example.WebCursos.models.Admin;
import CRUD.example.WebCursos.models.Student;
import CRUD.example.WebCursos.models.Teacher;
import CRUD.example.WebCursos.repositories.AdminRepository;
import CRUD.example.WebCursos.repositories.StudentRepository;
import CRUD.example.WebCursos.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCursosApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(AdminRepository adminRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, PasswordEncoder passwordEncoder) {
		return (args) -> {
			Admin admin = new Admin("admin", "admin", "admin@lol.com", passwordEncoder.encode("1234"), Role.ADMIN, "qEGuqw45!3ed");
			adminRepository.save(admin);
			Student student = new Student("student", "student", "student@lol.com",  passwordEncoder.encode("1234"), Role.USER, "qEGuqw45!3ed");
			studentRepository.save(student);
			Teacher teacher = new Teacher("teacher", "teacher", "teacher@lol.com",  passwordEncoder.encode("1234"), Role.TEACHER, "qEGuqw45!3ed");
			teacherRepository.save(teacher);
		};
	}
}



