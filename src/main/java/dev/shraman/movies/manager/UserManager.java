package dev.shraman.movies.manager;

import dev.shraman.movies.data.User;
import dev.shraman.movies.payloads.UserDto;
import dev.shraman.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerNewUser(final UserDto userDtoObject) {
        final Optional<User> currUserOptional = userRepository.findByUsername(userDtoObject.getUserName());
        if(currUserOptional.isPresent()) {
            throw new RuntimeException("UserName Already Exists");
        }
        final User user = new User();
        user.setUsername(userDtoObject.getUserName());
        user.setPassword(passwordEncoder.encode(userDtoObject.getPassword()));
        User createdUser = userRepository.insert(user);
        return createdUser.getId().toHexString();

    }

    public boolean verifyUser(final UserDto userDtoObject) {
        final Optional<User> currUserOptional = userRepository.findByUsername(userDtoObject.getUserName());

        if(currUserOptional.isEmpty()) {
            throw new RuntimeException("User is not registered!! Please register first");
        }
        else {
            User currUser = currUserOptional.get();
            return currUser.getPassword().equals(userDtoObject.getPassword());
        }
    }
}
