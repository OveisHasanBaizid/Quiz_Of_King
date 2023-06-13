package com.example.quiz_of_king;

import java.io.*;
import java.util.ArrayList;

public class DataBase {
    static String player1 , player2;
    public static ArrayList<Question> questions = new ArrayList<>();
    public static SubjectQuestion subjectQuestion;

    public static ArrayList<Question> getQuestionsSubject() {
        ArrayList<Question> list = new ArrayList<>();
        for (Question q : questions) {
            if (q.getSubject() == subjectQuestion)
                list.add(q);
        }
        return list;
    }

    public static void addQuestion(Question question) throws IOException {
        questions.add(question);
        saveQuestionToFile();
    }

    public static void saveQuestionToFile() throws IOException {
        ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream("Questions.txt"));
        objectInputStream.writeInt(DataBase.questions.size());
        for (int i = 0; i < DataBase.questions.size(); i++) {
            objectInputStream.writeObject(DataBase.questions.get(i));
        }
        objectInputStream.close();
    }

    public static void readQuestionFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Questions.txt"));
        int n = objectInputStream.readInt();
        for (int i = 0; i < n; i++) {
            DataBase.questions.add((Question) objectInputStream.readObject());
        }
        objectInputStream.close();
    }
}
