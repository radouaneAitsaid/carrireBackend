package ma.zs.carriere.unit.service.impl.admin.avancement;

import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.dao.facade.core.avancement.EchelonDao;
import ma.zs.carriere.service.impl.admin.avancement.EchelonAdminServiceImpl;

import ma.zs.carriere.bean.core.avancement.Echelle ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class EchelonAdminServiceImplTest {

    @Mock
    private EchelonDao repository;
    private AutoCloseable autoCloseable;
    private EchelonAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EchelonAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEchelon() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEchelon() {
        // Given
        Echelon toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEchelon() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEchelonById() {
        // Given
        Long idToRetrieve = 1L; // Example Echelon ID to retrieve
        Echelon expected = new Echelon(); // You need to replace Echelon with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Echelon result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Echelon constructSample(int i) {
		Echelon given = new Echelon();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setSalaire(BigDecimal.TEN);
        given.setSalaire(salaire);
        given.setEchelle(new Echelle(1L));
        given.setEchelle(echelle);
        return given;
    }

}
