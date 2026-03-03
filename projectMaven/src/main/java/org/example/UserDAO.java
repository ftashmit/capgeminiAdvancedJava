package org.example;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class UserDAO {

    private EntityManager em;

    public UserDAO() {
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    private UserDTO convertToDTO(User user) {

        if (user == null) return null;

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public UserDTO create(User user) {

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        return convertToDTO(user);
    }

    public UserDTO getById(Long id) {
        return convertToDTO(em.find(User.class, id));
    }

    public List<UserDTO> getAll() {

        List<User> users =
                em.createQuery("SELECT u FROM User u", User.class)
                        .getResultList();

        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO update(Long id, String name, String email) {

        em.getTransaction().begin();

        User user = em.find(User.class, id);

        if (user != null) {
            user.setName(name);
            user.setEmail(email);
        }

        em.getTransaction().commit();

        return convertToDTO(user);
    }

    public void close() {
        em.close();
    }
}