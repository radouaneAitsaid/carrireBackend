package ma.zs.carriere.unit.ws.facade.admin.avancement;

import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.service.impl.admin.avancement.AvancementAdminServiceImpl;
import ma.zs.carriere.ws.converter.avancement.AvancementConverter;
import ma.zs.carriere.ws.dto.avancement.AvancementDto;
import ma.zs.carriere.ws.facade.admin.avancement.AvancementRestAdmin;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AvancementRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private AvancementAdminServiceImpl service;
    @Mock
    private AvancementConverter converter;

    @InjectMocks
    private AvancementRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllAvancementTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<AvancementDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<AvancementDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveAvancementTest() throws Exception {
        // Mock data
        AvancementDto requestDto = new AvancementDto();
        Avancement entity = new Avancement();
        Avancement saved = new Avancement();
        AvancementDto savedDto = new AvancementDto();

        // Mock the converter to return the avancement object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved avancement DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<AvancementDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        AvancementDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved avancement DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getSalaireAjoute(), responseBody.getSalaireAjoute());
    }

}
