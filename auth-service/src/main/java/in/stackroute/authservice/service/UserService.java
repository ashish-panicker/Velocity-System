package in.stackroute.authservice.service;

import java.util.List;
import java.util.Optional;
import in.stackroute.authservice.domain.User;

public interface UserService {

    
    public User saveUser(User user);
    
    public User updateUser(User user);
    
    public void deleteUser(User user);

    public List<User> getAllUsers();
    
    public Optional<User> getUserByUserName(String username);
    
    public Optional<User> getUserByUserNameAndPassword(String username, String password);
    
}
