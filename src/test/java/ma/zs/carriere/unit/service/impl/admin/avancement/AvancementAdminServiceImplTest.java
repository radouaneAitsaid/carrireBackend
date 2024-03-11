package ma.zs.carriere.unit.service.impl.admin.avancement;

import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.dao.facade.core.avancement.AvancementDao;
import ma.zs.carriere.service.impl.admin.avancement.AvancementAdminServiceImpl;

import ma.zs.carriere.bean.core.avancement.Echelon ;
import ma.zs.carriere.bean.core.commun.Employe ;
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
class AvancementAdminServiceImplTest {

    @Mock
    private AvancementDao repository;
    private AutoCloseable autoCloseable;
    private AvancementAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new AvancementAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllAvancement() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveAvancement() {
        // Given
        Avancement toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteAvancement() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetAvancementById() {
        // Given
        Long idToRetrieve = 1L; // Example Avancement ID to retrieve
        Avancement expected = new Avancement(); // You need to replace Avancement with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Avancement result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Avancement constructSample(int i) {
		Avancement given = new Avancement();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setEmploye(new Employe(1L));
        given.setEmploye(employe);
        given.setEchelon(new Echelon(1L));
        given.setEchelon(echelon);
        given.setSalaireAjoute(BigDecimal.TEN);
        given.setSalaireAjoute(salaireAjoute);
        return given;
    }

}
