package com.thetestingacademy.tests.integration.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.BookingRespons;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class testVerifyCreateBookingPOST01 extends BaseTest {


    @Owner("Promode")
    @TmsLink("https://bugz.atlassian.net/jira/software/projects/REQ/boards/1?selectedIssue=REQ-1")
    @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
    @Issue("JIRA_RBT-4")
    @Description("Verify that POST request is working fine.")
    @Test
    public void testVerifyCreateBookingPOST01() {

        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response =
                RestAssured
                        .given(requestSpecification)
                        .when().body(payloadManager.createPayloadBookingAsString()).post();


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Default Rest Assured - Validation -
        validatableResponse.body("booking.firstname", Matchers.equalTo("James"));


        BookingRespons bookingResponse = payloadManager.bookingResponseJava(response.asString());

        // AssertJ
        // assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"James");
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James");


        // TestNG Assertions
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyResponseBody(bookingResponse.getBooking().getFirstname(), "James", "Verify the First Name");

    }


    @Test
    public void testVerifyCreateBookingPOST02() {
    }

    @Test
    public void testVerifyCreateBookingPOST03() {
    }

    @Test
    public void testVerifyCreateBookingPOST04() {
    }

    @Test
    public void testVerifyCreateBookingPOST05() {
    }

    @Test
    public void testVerifyCreateBookingPOST06() {
    }


}
