package ru.example.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.example3sem3hometask.domain.User;
import ru.example.example3sem3hometask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(dataProcessingService.getUserRepository().getUsers());
    }

    /**
     * Запрос формирует список пользователей, у котрых значение поля age больше, чем заданное число в запросе.
     *
     * @param age - параметр, котрый передается в запросе, для фильтрации списка пользователей по полю age.
     * @return возвращает список отфильтрованных пользователей
     */
    @GetMapping("/filter/{age}")//localhost:8080/tasks/filter/age
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return dataProcessingService.filterUsersByAge(dataProcessingService.getUserRepository().getUsers(), age);
    }

    /**
     * Запрос вычисляет средний возраст пользователей
     *
     * @return - возвращает средний возраст пользователей
     */
    @GetMapping("/calc")//localhost:8080/tasks/calc
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge(dataProcessingService.getUserRepository().getUsers());
    }


    //метод filterUsersByAge
    //Подсказка  @GetMapping("/filter/{age}")

    //метод calculateAverageAge
    //Подсказка  @GetMapping("/calc")

}
