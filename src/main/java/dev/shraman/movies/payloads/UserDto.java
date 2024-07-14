package dev.shraman.movies.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDto {

    @NotEmpty
    @Email(message = "Username should be a valid email")
    String userName;

    @NotEmpty
    @Size(min = 8, max = 16, message = "Password should be min of 8 chars and max of 16 chars")
    String password;
}
