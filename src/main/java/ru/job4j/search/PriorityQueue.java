package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }

    public static void main(String[] args) {
        Task task1 = new Task("wake up", 100);
        Task task2 = new Task("do job", 3);
        Task task3 = new Task("code Java", 1);
        Task task4 = new Task("eat", 5);
        PriorityQueue que = new PriorityQueue();
        que.put(task1);
        que.put(task2);
        que.put(task3);
        que.put(task4);
        Task res = que.take();
        System.out.println(res.getPriority());
    }
}
