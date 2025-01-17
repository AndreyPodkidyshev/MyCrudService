package com.alexey.crud.service;

import com.alexey.crud.model.User;
import com.alexey.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager em;

    @Transactional
    public User getUserByEmail(String email) {

        TypedQuery<User> user = em.createQuery(
                "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email = :emailParam", User.class);
        user.setParameter("emailParam", email);
        return user.getSingleResult();
    }
    @Transactional
    public User getUserById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
