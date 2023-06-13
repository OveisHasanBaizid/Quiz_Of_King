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
    public static SubjectQuestion setText(String s){
        switch (s){
            case "مذهبی" -> {
                return Religious;
            }
            case "ورزشی" -> {
                return Sports;
            }
            case "جفرافیا" -> {
                return Geography;
            }
            case "هنر" -> {
                return Art;
            }
            case "ریاضی" -> {
                return Math;
            }
            case "زبان" -> {
                return Language;
            }
            default -> {
                return IQ;
            }
        }
    }
}
