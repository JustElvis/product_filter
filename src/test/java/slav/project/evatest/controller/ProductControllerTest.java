package slav.project.evatest.controller;

import static org.junit.jupiter.api.Assertions.*;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import slav.project.evatest.model.Product;
import slav.project.evatest.service.ProductService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldShowAllProductsNotStartsWithLetterE() {
        List<Product> mockProducts = List.of(
                new Product(0L, "product", "bad product"),
                new Product(1L, "Eproduct", "good product"));
        Mockito.when(productService.findAll()).thenReturn(mockProducts);

        RestAssuredMockMvc
                .given()
                .queryParam("nameFilter", "^E.*$")
                .when()
                .get("/shop/product")
                .then()
                .body("size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(0))
                .body("[0].name", Matchers.equalTo("product"))
                .body("[0].description", Matchers.equalTo("bad product"));
    }

    @Test
    public void shouldShowAllProductsNotContainsLettersEVA() {
        List<Product> mockProducts = List.of(
                new Product(0L, "product", "bad product"),
                new Product(1L, "producte", "good product"),
                new Product(2L, "productv", "good product"),
                new Product(3L, "producta", "good product"));
        Mockito.when(productService.findAll()).thenReturn(mockProducts);

        RestAssuredMockMvc
                .given()
                .queryParam("nameFilter", "^.*[eva].*$")
                .when()
                .get("/shop/product")
                .then()
                .body("size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(0))
                .body("[0].name", Matchers.equalTo("product"))
                .body("[0].description", Matchers.equalTo("bad product"));
    }
}