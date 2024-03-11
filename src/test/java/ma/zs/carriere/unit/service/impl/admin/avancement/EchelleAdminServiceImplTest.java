package ma.zs.carriere.unit.service.impl.admin.avancement;

import ma.zs.carriere.bean.core.avancement.Echelle;
import ma.zs.carriere.dao.facade.core.avancement.EchelleDao;
import ma.zs.carriere.service.impl.admin.avancement.EchelleAdminServiceImpl;

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
class EchelleAdminServiceImplTest {

    @Mock
    private EchelleDao repository;
    private AutoCloseable autoCloseable;
    private EchelleAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EchelleAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEchelle() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEchelle() {
        // Given
        Echelle toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEchelle() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEchelleById() {
        // Given
        Long idToRetrieve = 1L; // Example Echelle ID to retrieve
        Echelle expected = new Echelle(); // You need to replace Echelle with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Echelle result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Echelle constructSample(int i) {
		Echelle given = new Echelle();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        return given;
    }

}
