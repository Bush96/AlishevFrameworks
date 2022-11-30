package com.example.demo2.services;

import com.example.demo2.models.Book;
import com.example.demo2.models.Person;
import com.example.demo2.repositories.BooksRepository;
import com.example.demo2.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;


    @Autowired
    public BooksService(BooksRepository booksRepository, PeopleService peopleService, PeopleRepository peopleRepository) {
        this.booksRepository = booksRepository;

    }

    public Page<Book> findAllWithPagination(Pageable pageable) {
        return booksRepository.findAll(pageable);
    }

    public List<Book> findAll(boolean sortByYear) {
        if (sortByYear) {
            return booksRepository.findAll(Sort.by("year"));
        } else {
            return booksRepository.findAll();
        }
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);  // возвращает сущность по айди (используем оптионал ибо можем ничего не найти, тогда вернем нулл)
        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        Book bookToBeUpdated = booksRepository.findById(id).get();
        updatedBook.setId(id);
        booksRepository.save(updatedBook);     //для добавления и обновления используется один и тот же метод
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }


    public List<Book> showBooksByOwner(Person person) {
        List<Book> foundBooks = booksRepository.findByOwner(person);
        return foundBooks;
    }

    public Person getOwner(int id) {
        Person foundPerson = booksRepository.findById(id).map(Book::getOwner).orElse(null);  // возвращает сущность по айди (используем оптионал ибо можем ничего не найти, тогда вернем нулл)
        return foundPerson;
    }

    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(book -> {
            book.setOwner(null);
        });
    }

    @Transactional
    public void appoint(int id, Person selectedPerson) {

        booksRepository.findById(id).ifPresent(book -> book.setOwner(selectedPerson));
    }

    public List<Book> searchByTitle(String query) {
      return booksRepository.findByTitleStartingWith(query);
    }
}


//
//
//<div th:if="${owner}">
//<span> Book owner:</span> <span th:text="${owner.getName() + ', ' + owner.getAge()}">Person name</span>
//
//<form th:method="PATCH" th:action="@{/books/{id}/release(id=${book.getId()})}">
//<input th:type="submit" value="Release book"/>
//        ></form>
//</div>
//
//<div th:if="${people}">
//<span> Book has not owner</span>
//
//<form th:method="PATCH" th:action="@{/books/{id}/appoint(id=${book.getId()})}">
//<label for="person">Choose owner</label>
//<select th:object="${person}" th:field="*{id}" id="person">
//<option th:each="person : ${people}" th: value="${person.getId()}" th:text="${person.getName()}">
//</option>
//</select>
//<input type="submit" value="Accept">
//</form>
//</div>
//
//<hr/>

//
//<form th:method="GET" th:action="@{/books/{id}/edit(id=${book.getId()})}">
//<input type="submit" value="Edit"/>
//</form>
//
//<form th:method="DELETE" th:action="@{/books/{id}(id=${book.getId()})}">
//<input type="submit" value="Delete"/>
//</form>


//<form th:method="PATCH" th:action="@{/books/{id}/appoint(id=${book.getId()})}">
//<label for="person">Choose owner</label>
//<select th:object="${person}" th:field="*{id}" id="person">
//<option th:each="person : ${people}" th: value="${person.getId()}" th:text="${person.getName()}">
//</option>
//</select>
//<input type="submit" value="Accept">
//</form>


//
//<div th:if="${people}">
//<span> Book has not owner</span>
//
//<form th:method="PATCH" th:action="@{/books/{id}/appoint(id=${book.getId()})}">
//<label for="person">Choose owner</label>
//<select th:object="${person}" th:field="*{id}" id="person">
//<option th:each="person : ${people}" th: value="${person.getId()}" th:text="${person.getName()}">
//</option>
//</select>
//<input type="submit" value="Accept">
//</form>
//</div>


//<form th:method="PATCH" th:action="@{/books/{id}/appoint(id=${book.getId()})}">
//<label for="person">Choose owner</label>
//<select th:object="${person}" th:field="*{id}" id="person">
//<option th:each="person : ${people}" th: value="${person.getId()}" th:text="${person.getName()}">
//</option>
//</select>
//<input type="submit" value="Accept">
//</form>