package pages;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyRadioBtn = $("#hobbiesWrapper"),
            uploadImageInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateTabs = $("#state"),
            stateInput = $("#stateCity-wrapper"),
            cityTabs = $("#city"),
            cityInput = $("#stateCity-wrapper"),
            submitBtnCityAndState = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender (String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave((text(value)));
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyRadioBtn.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadImage(String value) {
        uploadImageInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState (String value) {
        stateTabs.scrollTo();
        stateTabs.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity (String value) {
        cityTabs.scrollTo();
        cityTabs.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitCityAndState() {
        submitBtnCityAndState.click();
        return this;
    }

}