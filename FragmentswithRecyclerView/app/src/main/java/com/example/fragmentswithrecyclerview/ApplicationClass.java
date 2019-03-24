package com.example.fragmentswithrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Person> people;


    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<Person>();
        people.add(new Person("Rahul Raj", "9847607322"));
        people.add(new Person("John Rambo", "55445258"));
        people.add(new Person("Nelson Mandela", "9930"));
        people.add(new Person("Chuck Noris", "305245"));
    }
}
