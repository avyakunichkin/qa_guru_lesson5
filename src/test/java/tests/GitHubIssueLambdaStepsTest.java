package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class GitHubIssueLambdaStepsTest {

    private static final String repo = "avyakunichkin/qa_guru_lesson5";
    private final String issueName = "Test Issue";

    @Test
    void gitHubIssueLambdaStepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () -> open("https://github.com/"));
        step("Выполнить поиск репозитория " + repo, () -> $("[name=q]").setValue(repo).pressEnter());
        step("Выбрать репозиторий " + repo, () -> $(format("a[href='/%s']", repo)).click());
        step("Перейти на вкладку Issues", () -> $(byText("Issues")).click());
        step("Проверить наличие " + issueName, () -> $(byText(issueName)).shouldBe(visible));
    }
}
