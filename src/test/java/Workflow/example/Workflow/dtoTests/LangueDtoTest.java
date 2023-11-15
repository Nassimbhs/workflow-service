package workflow.example.workflow.dtoTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.LangueDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LangueDtoTest {

    @InjectMocks
    private LangueDto langueDto;

    @Test
    void testLangueDto() {
        langueDto.setId(1L);
        langueDto.setNom("English");
        langueDto.setNiveau("Advanced");

        assertEquals(1L, langueDto.getId());
        assertEquals("English", langueDto.getNom());
        assertEquals("Advanced", langueDto.getNiveau());

    }
}

