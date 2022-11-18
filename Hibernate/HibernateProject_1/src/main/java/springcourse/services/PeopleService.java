package springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcourse.models.Book;
import springcourse.models.Person;
import springcourse.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();  //по умолчанию возвращает все сущности из таблицы
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);  // возвращает сущность по айди (используем оптионал ибо можем ничего не найти, тогда вернем нулл)
        return foundPerson.orElse(null);
    }



    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);     //для добавления и обновления используется один и тот же метод
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }


}
