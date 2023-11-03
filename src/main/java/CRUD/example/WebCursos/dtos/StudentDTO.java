package CRUD.example.WebCursos.dtos;

import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@NoArgsConstructor
public class StudentDTO {
    @NotBlank(message = "Please, enter a valid name")
    private String firstName;
    @NotBlank(message = "Please, enter a valid last name")
    private String lastName;
    @NotBlank(message = "Please, enter a valid email")
    private String email;
    @NotBlank(message = "Please, enter a valid password")
    private String password;
    public StudentDTO(String name, String lastName, String email, String password) {
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
