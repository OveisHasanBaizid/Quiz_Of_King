package com.example.quiz_of_king;

import java.io.Serializable;

public class Question implements Serializable {
    private String text;
    private SubjectQuestion subject;
    private String answer;

    private String option1, option2, option3, option4;

    public Question(String text, SubjectQuestion subject, String answer
            , String option1, String option2, String option3, String option4) {
        this.text = text;
        this.subject = subject;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        setAnswer(answer);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SubjectQuestion getSubject() {
        return subject;
    }

    public void setSubject(SubjectQuestion subject) {
        this.subject = subject;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        if (answer.equals("1"))
            this.answer = option1;
        else if (answer.equals("2"))
            this.answer = option2;
        else if (answer.equals("3"))
            this.answer = option3;
        else if (answer.equals("4"))
            this.answer = option4;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
