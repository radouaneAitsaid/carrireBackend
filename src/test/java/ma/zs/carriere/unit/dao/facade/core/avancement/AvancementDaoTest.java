package ma.zs.carriere.unit.dao.facade.core.avancement;

import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.bean.core.commun.Employe;
import ma.zs.carriere.dao.facade.core.avancement.AvancementDao;

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
public class AvancementDaoTest {

@Autowired
    private AvancementDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Avancement entity = new Avancement();
        entity.setRef(ref);
        underTest.save(entity);
        Avancement loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Avancement entity = new Avancement();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Avancement loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Avancement entity = new Avancement();
        entity.setId(id);
        underTest.save(entity);
        Avancement loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Avancement entity = new Avancement();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Avancement loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Avancement> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Avancement> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Avancement given = constructSample(1);
        Avancement saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Avancement constructSample(int i) {
		Avancement given = new Avancement();
        given.setRef("ref-"+i);
        given.setEmploye(new Employe(1L));
        given.setEchelon(new Echelon(1L));
        given.setSalaireAjoute(BigDecimal.TEN);
        return given;
    }

}
