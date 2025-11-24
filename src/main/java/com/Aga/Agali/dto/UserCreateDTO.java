package com.Aga.Agali.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    @NotBlank(message = "Can't keep it idle!")
    @Size(min = 3, max = 25)
    private String firstName;
    @NotBlank(message = "Can't keep it idle!")
    @Size(min = 3, max = 25)
    private String lastName;
    @Email(message = "Enter in email format!")
    private String email;
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, include uppercase, lowercase, number and special character"
    )
    private String password;
    @Pattern(
            regexp = "^(\\+994|0)(50|51|55|70|77|99)\\d{7}$",
            message = "Invalid Azerbaijani mobile number"
    )
    private String phoneNumber;
}

