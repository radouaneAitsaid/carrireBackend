package ma.zs.carriere.unit.dao.facade.core.avancement;

import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.dao.facade.core.avancement.EchelonDao;

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
public class EchelonDaoTest {

@Autowired
    private EchelonDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Echelon entity = new Echelon();
        entity.setId(id);
        underTest.save(entity);
        Echelon loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Echelon entity = new Echelon();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Echelon loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Echelon> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Echelon> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Echelon given = constructSample(1);
        Echelon saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Echelon constructSample(int i) {
		Echelon given = new Echelon();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setSalaire(BigDecimal.TEN);
        given.setEchelle(new Echelle(1L));
        return given;
    }

}
