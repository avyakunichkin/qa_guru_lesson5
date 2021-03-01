package tests;

import org.junit.jupiter.api.Test;
import steps.GitHubSteps;

public class GitHubIssueStepsTest {

    private final GitHubSteps steps = new GitHubSteps();
    private static final String repo = "avyakunichkin/qa_guru_lesson5";

    @Test
    void gitHubIssueStepsTest(){
        steps.openMainPage()
                .searchRepo(repo)
                .selectRepo(repo)
                .goToIssues()
                .checkIssue();
    }
}
