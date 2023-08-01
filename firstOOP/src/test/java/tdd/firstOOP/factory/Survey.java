package tdd.firstOOP.factory;

import jdk.jshell.Snippet;

import java.awt.image.PixelGrabber;
import java.time.LocalDateTime;
import java.util.List;

public class Survey {

    private Long id;
    private SurveyStatus surveyStatus;
    private LocalDateTime localDateTime;
    private List<Question> questions;
    private static Survey survey;

    public static Survey builder() {
        return survey = new Survey();
    }

    public Survey id(Long id) {
        Survey.survey.id = id;
        return Survey.survey;
    }

    public Survey status(SurveyStatus surveyStatus) {
        Survey.survey.surveyStatus = surveyStatus;
        return Survey.survey;
    }

    public Survey endOfPeriod(LocalDateTime localDateTime) {
        Survey.survey.localDateTime = localDateTime;
        return Survey.survey;
    }

    public Survey questions(List<Question> questions) {
        Survey.survey.questions = questions;
        return Survey.survey;
    }

    public Survey build() {
        return this.survey;
    }
}

