package com.example.quiz_of_king;

import java.io.Serializable;

public enum SubjectQuestion  implements Serializable {
    Religious, Sports, Geography, Art, Math, Language, IQ;

    public String getText(){
        switch (this){
            case Religious -> {
                return "مذهبی";
            }
            case Sports -> {
                return "ورزشی";
            }
            case Geography -> {
                return"جفرافیا";
            }
            case Art -> {
                return "هنر";
            }
            case Math -> {
                return"ریاضی";
            }
            case Language -> {
                return "زبان";
            }
            default -> {
                return "هوش";
            }
        }
    }
}
