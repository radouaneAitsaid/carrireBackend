package ma.zs.carriere.unit.dao.facade.core.commun;

import ma.zs.carriere.bean.core.commun.Employe;
import ma.zs.carriere.dao.facade.core.commun.EmployeDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmployeDaoTest {

@Autowired
    private EmployeDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Employe entity = new Employe();
        entity.setRef(ref);
        underTest.save(entity);
        Employe loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Employe entity = new Employe();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Employe loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Employe entity = new Employe();
        entity.setId(id);
        underTest.save(entity);
        Employe loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Employe entity = new Employe();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Employe loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Employe> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Employe> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Employe given = constructSample(1);
        Employe saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Employe constructSample(int i) {
		Employe given = new Employe();
        given.setRef("ref-"+i);
        given.setUsername("username-"+i);
        given.setNom("nom-"+i);
        given.setPassword("password-"+i);
        given.setSalaire(BigDecimal.TEN);
        return given;
    }

}
