package ma.zs.carriere.unit.dao.facade.core.avancement;

import ma.zs.carriere.bean.core.avancement.Echelle;
import ma.zs.carriere.dao.facade.core.avancement.EchelleDao;

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
public class EchelleDaoTest {

@Autowired
    private EchelleDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Echelle entity = new Echelle();
        entity.setId(id);
        underTest.save(entity);
        Echelle loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Echelle entity = new Echelle();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Echelle loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Echelle> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Echelle> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Echelle given = constructSample(1);
        Echelle saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Echelle constructSample(int i) {
		Echelle given = new Echelle();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
