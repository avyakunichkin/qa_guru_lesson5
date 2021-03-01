package steps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class GitHubSteps {

    public GitHubSteps openMainPage(){
        open("https://github.com/");
        return this;
    }

    public GitHubSteps searchRepo(String repo){
        $("[name=q]").setValue(repo).pressEnter();
        return this;
    }

    public GitHubSteps selectRepo(String repo){
        $(format("a[href='/%s']", repo)).click();
        return this;
    }

    public GitHubSteps goToIssues(){
        $(byText("Issues")).click();
        return this;
    }

    public GitHubSteps checkIssue(){
        $(byText("Test Issue")).shouldBe(visible);
        return this;
    }
}
