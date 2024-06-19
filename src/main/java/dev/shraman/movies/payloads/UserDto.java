package dev.shraman.movies.payloads;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDto {
    String userName;
    String password;
}
