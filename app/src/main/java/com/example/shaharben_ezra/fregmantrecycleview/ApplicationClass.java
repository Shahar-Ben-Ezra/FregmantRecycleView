package com.example.shaharben_ezra.fregmantrecycleview;

import android.app.Application;
import java.util.ArrayList;

public  class ApplicationClass extends Application {
    public static ArrayList<Person> people;
    @Override
    public void onCreate() {
        super.onCreate();
        people=new ArrayList<Person>();
        people.add(new Person("chuck Norris","049916005"));
        people.add(new Person("haim Norris","64365465464"));
        people.add(new Person("shahar Norris","6436456546"));
        people.add(new Person("ben Norris","355456465"));
        people.add(new Person("neta Norris","0526671797"));

    }
}