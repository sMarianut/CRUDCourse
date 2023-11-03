package CRUD.example.WebCursos.configuration;

import CRUD.example.WebCursos.models.Admin;
import CRUD.example.WebCursos.models.Student;
import CRUD.example.WebCursos.models.Teacher;
import CRUD.example.WebCursos.repositories.AdminRepository;
import CRUD.example.WebCursos.repositories.StudentRepository;
import CRUD.example.WebCursos.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthorization extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputName -> {
            Admin admin = adminRepository.findByEmail(inputName);
            if(admin != null){
                return new User(admin.getEmail(), admin.getPassword(), AuthorityUtils.createAuthorityList(admin.getRole().toString()));
            }
            Teacher teacher = teacherRepository.findByEmail(inputName);
            if(teacher != null){
                return new User(teacher.getEmail(), teacher.getPassword(), AuthorityUtils.createAuthorityList(teacher.getRole().toString()));
            }
            Student student = studentRepository.findByEmail(inputName);
            if(student != null){
                return new User(student.getEmail(), student.getPassword(), AuthorityUtils.createAuthorityList(student.getRole().toString()));
            }else{
                throw new UsernameNotFoundException("Unknown user: " + inputName);
            }
        });
    }
}
