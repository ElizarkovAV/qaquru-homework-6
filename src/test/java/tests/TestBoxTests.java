package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TestBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    String fullName = "Test Testov";
    String email = "test@test.com";
    String currentAddress = "Street 1";
    String permanentAddress = "Street 2";

    @Test
    public void registrationTextBoxTest() {
        //act
        textBoxPage
                .openPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        //assert
        textBoxPage
                .checkResults("Name:", fullName)
                .checkResults("Email:",  email)
                .checkResults("Current Address :", currentAddress)
                .checkResults("Permananet Address :", permanentAddress);
    }
}
