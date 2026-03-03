package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Application...");

        TaskDAO taskDAO = null;
        UserDAO userDAO = null;

        try {

            taskDAO = new TaskDAO();
            userDAO = new UserDAO();

            // ---------- TASK CRU ----------

            Task newTask = new Task("Learn JPA", "Understand Hibernate ORM");

            TaskDTO createdTask = taskDAO.create(newTask);
            System.out.println("Created Task: " + createdTask);

            TaskDTO fetchedTask = taskDAO.getById(createdTask.getId());
            System.out.println("Fetched Task: " + fetchedTask);

            TaskDTO updatedTask = taskDAO.update(
                    createdTask.getId(),
                    "Learn Hibernate",
                    "Deep dive into JPA"
            );

            System.out.println("Updated Task: " + updatedTask);

            List<TaskDTO> tasks = taskDAO.getAll();

            System.out.println("All Tasks:");
            tasks.forEach(System.out::println);


            // ---------- USER CRU ----------

            User newUser = new User("Ashmit", "ashmit@email.com");

            UserDTO createdUser = userDAO.create(newUser);
            System.out.println("Created User: " + createdUser);

            UserDTO fetchedUser = userDAO.getById(createdUser.getId());
            System.out.println("Fetched User: " + fetchedUser);

            UserDTO updatedUser = userDAO.update(
                    createdUser.getId(),
                    "Ashmit Dutta",
                    "ashmitd@email.com"
            );

            System.out.println("Updated User: " + updatedUser);

            List<UserDTO> users = userDAO.getAll();

            System.out.println("All Users:");
            users.forEach(System.out::println);

        }
        catch (Exception e) {

            System.out.println("Application error:");
            e.printStackTrace();

        }
        finally {

            if (taskDAO != null)
                taskDAO.close();

            if (userDAO != null)
                userDAO.close();
        }

        System.out.println("Application Finished.");
    }
}