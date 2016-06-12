package com.site;

import com.site.data.Person;
import com.site.data.PersonRepository;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class QueryControllerTest {
    @Test
    public void foundPerson() {
        Person person = new Person();
        person.setName("test name");
        person.setEmail("test@example.com");
        person.setAge(1);

        QueryController controller = new QueryController(createRepository(person));
        Map<String, Object> data = controller.query(person.getName()).getModel();
        assertThat(data.get("name"), is(equalTo(person.getName())));
        assertThat(data.get("email"), is(equalTo(person.getEmail())));
        assertThat(data.get("age"), is(equalTo(person.getAge())));
    }

    @Test
    public void notFoundPerson() {
        QueryController controller = new QueryController(createRepository(null));
        String name = "test name";
        Map<String, Object> data = controller.query(name).getModel();
        assertThat(data.get("name"), is(equalTo(name)));
        assertNull(data.get("email"));
        assertNull(data.get("age"));
    }

    private static PersonRepository createRepository(Person person) {
        PersonRepository repository = EasyMock.createMock(PersonRepository.class);
        EasyMock.expect(repository.findByName(EasyMock.anyString())).andReturn(person);
        EasyMock.replay(repository);
        return repository;
    }
}