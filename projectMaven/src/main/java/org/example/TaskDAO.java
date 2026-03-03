package org.example;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDAO {

    private EntityManager em;

    public TaskDAO() {
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    private TaskDTO convertToDTO(Task task) {
        if (task == null) return null;

        return new TaskDTO(
                task.getId(),
                task.getTask(),
                task.getDescription()
        );
    }

    public TaskDTO create(Task task) {

        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();

        return convertToDTO(task);
    }

    public TaskDTO getById(Long id) {
        return convertToDTO(em.find(Task.class, id));
    }

    public List<TaskDTO> getAll() {

        List<Task> tasks =
                em.createQuery("SELECT t FROM Task t", Task.class)
                        .getResultList();

        return tasks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO update(Long id, String taskName, String desc) {

        em.getTransaction().begin();

        Task task = em.find(Task.class, id);

        if (task != null) {
            task.setTask(taskName);
            task.setDescription(desc);
        }

        em.getTransaction().commit();

        return convertToDTO(task);
    }

    public void close() {
        em.close();
    }
}