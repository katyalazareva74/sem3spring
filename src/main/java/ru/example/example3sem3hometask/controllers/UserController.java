package ru.example.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.example3sem3hometask.domain.User;
import ru.example.example3sem3hometask.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.getDataProcessingService().getUserRepository().getUsers().add(user);
        return "User added from body!";
    }

    /**
     * Запрос создает пользователя по полям класса User и добавляет пользователя в общий список
     *
     * @param name  - поле name передается в запросе
     * @param age   - поле age передается в запросе
     * @param email - поле email  передается в запросе
     */
    @PostMapping("/params")
    public void userAddFromParam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email) {
        registrationService.processRegistration(name, age, email);
    }

}
