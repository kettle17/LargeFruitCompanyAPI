package org.example.largefruitcompanyapi;

import org.example.largefruitcompanyapi.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class LargeFruitCompanyApiApplicationTests {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private FruitService fruitService;

    @DisplayName("GET /fruits should return 200 when fruit database exists")
    @Test
    public void givenFruit_whenGetFruits_thenStatus200() throws Exception {
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit = new Fruit("1","Magical Fruit", "null");
        Fruit fruit2 = new Fruit("2","Scary Fruit", "null");
        fruits.add(fruit);
        fruits.add(fruit2);
        when(fruitService.getAllFruits()).thenReturn(fruits);

        mvc.perform(get("/fruits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].documentId").isNotEmpty())
                .andExpect(jsonPath("$[*].name").isNotEmpty());;
    }

    @DisplayName("GET /fruits should return 200 when fruit database is EMPTY, since it is the correct endpoint")
    @Test
    public void givenFruit_whenEmptyFruits_thenStatus200() throws Exception {
        List<Fruit> fruits = new ArrayList<>();
        when(fruitService.getAllFruits()).thenReturn(fruits);

        mvc.perform(get("/fruits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("GET /fruits should return 404 when fruit database is null/no list instantiated")
    @Test
    public void givenFruit_whenNullFruits_thenStatus404() throws Exception {
        when(fruitService.getAllFruits()).thenReturn(null);

        mvc.perform(get("/fruits")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @DisplayName("GET /fruits/{id} should return 200 when fruit with id exists")
    @Test
    public void getFruit_ReturnsFruit_WhenFound_NumericalID() throws Exception {

        // Arrange
        Fruit fruit = new Fruit("1","Magical Fruit", "null");
        when(fruitService.getFruitById("1")).thenReturn(fruit);

        // Act & Assert
        mvc.perform(get("/fruits/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Magical Fruit"));
    }

    @DisplayName("GET /fruits/{id} should return 200 when fruit with id exists with alphanumeric string")
    @Test
    public void getFruit_ReturnsFruit_WhenFound_Alphanumeric_ID() throws Exception {

        // Arrange
        Fruit fruit = new Fruit("FN3IFH3F03FH","Magical Fruit 2", "null");
        when(fruitService.getFruitById("FN3IFH3F03FH")).thenReturn(fruit);

        // Act & Assert
        mvc.perform(get("/fruits/FN3IFH3F03FH")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Magical Fruit 2"));
    }

    @DisplayName("GET /fruits/{id} should return 404 when fruit with id does not exist")
    @Test
    public void noFruit_returns404_WhenNotFound() throws Exception {
        when(fruitService.getFruitById("DDDDDDDDDD")).thenReturn(null);

        mvc.perform(get("/fruits/DDDDDDDDDD").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @DisplayName("GET /{incorrecturl} should return 404")
    @Test
    public void incorrectURL_returns_404() throws Exception {
        // Act & Assert
        mvc.perform(get("/bowadwadawdoks")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

}
