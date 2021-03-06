package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class GitHubIssueTest {

    private static final String repo = "avyakunichkin/qa_guru_lesson5";

    @Test
    void gitHubIssueTest(){
        open("https://github.com/");
        $("[name=q]").setValue(repo).pressEnter();
        $(format("a[href='/%s']", repo)).click();
        $(byText("Issues")).click();
        $(byText("Test Issue")).shouldBe(visible);
    }
}
