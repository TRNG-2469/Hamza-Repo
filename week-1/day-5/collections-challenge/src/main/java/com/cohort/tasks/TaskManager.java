package com.cohort.tasks;

import java.util.*;

public class TaskManager {
    static List<Task> allTasks = new ArrayList<>();
    static Set<String> uniqueTitles = new HashSet<>();
    static Map<String, Task> taskLookup = new HashMap<>();

    public static boolean addTask(Task task){
        if(uniqueTitles.contains(task.getTitle())) {
            System.out.println("Duplicate Task blocked");
            return false;
        }
        else {
            allTasks.add(task);
            uniqueTitles.add(task.getTitle());
            taskLookup.put(task.getTaskId(), task);
            return true;
        }
    }

    public static Task getTaskById(String id){
        return taskLookup.get(id);
    }

    public static void printRoster(){
        taskLookup.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    public static void main(String[] args) {
        Task T1 = new Task("T1", "Write Primitives Lab");
        Task T2 = new Task("T2", "Configure GitIgnore");
        Task T3 = new Task("T3", "Write Primitives Lab");

        addTask(T1);
        addTask(T2);
        addTask(T3);

        printRoster();

        System.out.println(getTaskById("T2"));

        System.out.println("TASK 1" + T1.isCompleted());
        System.out.println("TASK 2" + T2.isCompleted());
        System.out.println("TASK 3" + T3.isCompleted());

    }

}
