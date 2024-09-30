package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement userName = $("#userName"),
    userEmail = $("#userEmail"),
    currentAddress = $("#currentAddress"),
    permanentAddress = $("#permanentAddress"),
    submitBtn = $("#submit"),
    outputTable = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public TextBoxPage checkResults(String key, String value) {
        outputTable.shouldHave(text(key + value));
        return this;
    }
}
