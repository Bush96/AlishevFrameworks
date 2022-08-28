package dyurbash.springcourse.controllers;

import dyurbash.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import dyurbash.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {                          //создает обьект персон при нажатии в представлении
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person) {       //добавляет обьект персон в лист
        personDAO.save(person);
        return "redirect:/people";       //возвращает на страницу пипл
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);

        return "redirect:/people";
    }

}


/*
<form th:method="POST" th:action="@{/people}" th:object="${person}">              //указываем что будем делать и с чем
    <label for="name" >Enter name: </label>                   //добавление пояснения окна для ввода имени
    <input type = "text" th:field="*{name}" id="name"/>           //добавление окна для ввода имени
    <br/>
    <input type="submit" value="Create!"/>                  //кнапка подтвердить
</form>
 */