package com.example.hong.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    //定义一个list集合，用于存放activity
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity: activities) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
