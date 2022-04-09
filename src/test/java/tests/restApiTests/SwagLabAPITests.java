package tests.restApiTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pageObjects.Urls;

import static io.restassured.RestAssured.given;

public class SwagLabAPITests {

    @Test(testName = "Main page available", groups = {"Smoke", "API"})
    public void test_01() {
        given()
                .accept(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(Urls.BASE_URL)
                .then()
                .statusCode(200);
    }

    @Test(testName = "Products page available", groups = {"Smoke", "API"}, enabled=false)
    public void test_02() {
        given()
                .accept(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(Urls.INVENTORY_URL)
                .then()
                .contentType(ContentType.HTML)
                .statusCode(200);
    }

    @Test(testName = "Cart page available", groups = {"Smoke", "API"}, enabled=false)
    public void test_03() {
        given()
                .accept(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(Urls.CART_URL)
                .then()
                .contentType(ContentType.HTML)
                .statusCode(200);
    }

    @Test(testName = "Checkout1 page available", groups = {"Smoke", "API"}, enabled=false)
    public void test_04() {
        given()
                .accept(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(Urls.CHECKOUT1_URL)
                .then()
                .contentType(ContentType.HTML)
                .statusCode(200);
    }

    @Test(testName = "Checkout2 page available", groups = {"Smoke", "API"}, enabled=false)
    public void test_05() {
        given()
                .accept(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(Urls.CHECKOUT2_URL)
                .then()
                .contentType(ContentType.HTML)
                .statusCode(200);
    }
    @Test(testName = "Checkout3 page available", groups = {"Smoke", "API"}, enabled=false)
    public void test_06() {
        given()
                .accept(ContentType.JSON)
                .log()
                .all()
                .when()
                .get(Urls.CHECKOUT3_URL)
                .then()
                .contentType(ContentType.HTML)
                .statusCode(200);
    }
}

