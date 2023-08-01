package tdd.firstOOP.factory;

import javax.swing.plaf.basic.BasicListUI;
import java.time.LocalDateTime;

import static java.util.Arrays.asList;

public class TestSurveyFactory {
    public static Survey createAnswerableSurvey(Long id) {
        return Survey.builder()
                .id(id).status(SurveyStatus.OPEN)
                .endOfPeriod(LocalDateTime.now().plusDays(5))
                .questions(asList(new Question(1, "질문1", asList(Item.of(1, "보기1"), Item.of(2, "보기2"))),
                        new Question(1, "질문2",
                                asList(Item.of(1, "보기1"), Item.of(2, "보기2"))
                        )))
                .build();
    }
}
