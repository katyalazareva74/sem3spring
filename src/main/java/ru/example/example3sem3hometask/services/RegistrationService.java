package ru.example.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.example3sem3hometask.domain.User;

@Service
public class RegistrationService {
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    /**
     * Метод processRegistration(String name, int age, String email) создает нового пользователия по полям
     * класса User (String name, int age, String email) и выводит об этом сообщение.
     *
     * @param name  - поле name передается в метод
     * @param age   - поле age передается в метод
     * @param email - поле email передается в метод
     */
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("Пользователь создан и добавлен в список");
    }

    //Поля UserService, NotificationService

    //Метод processRegistration
}
