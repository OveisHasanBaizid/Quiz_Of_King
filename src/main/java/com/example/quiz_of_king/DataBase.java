package com.example.quiz_of_king;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Question> questions = new ArrayList<>();
    public static SubjectQuestion subjectQuestion;

    public ArrayList<Question> getQuestionsSubject(SubjectQuestion subjectQuestion){
        ArrayList<Question> list = new ArrayList<>();
        for (Question q:questions) {
            if (q.getSubject()==subjectQuestion)
                list.add(q);
        }
        return list;
    }
}
