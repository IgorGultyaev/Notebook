package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void validateRange(int choiceInt, int lowerLimit, int upperLimit) {
        if (choiceInt < -lowerLimit || choiceInt > upperLimit) {
            throw new ValueOutOfRangeException("Value out of range");
        }
    }

    public static int dateVerification(String choice, int lowerLimit, int upperlimit) throws ValueOutOfRangeException {
        try {
            int choiceInt = Integer.parseInt(choice);
            validateRange(choiceInt, lowerLimit, upperlimit);
            return choiceInt;
        } catch (NumberFormatException RuntimeException) {
            System.out.println("Вы ввели текст, нужно ввести цифру из заданного диапазона");
            return -1;
        } catch (ValueOutOfRangeException RuntimeException) {
            System.out.println("Вы выбрали неверное значение");
            return -1;
        }
    }


    public static List addTask(List<Task> list) {
        System.out.println();
        System.out.println("Добавление задачи");
        Scanner scanner = new Scanner(System.in);
        String taskText = scanner.nextLine();
        list.add(new Task(taskText));
        return list;
    }

    public static void outputListOfTasks(List<Task> list) {
        System.out.println();
        System.out.println("Печать всех задач");
        int pos = 1;
        for (Task task: list
             ) {
            System.out.print(pos + ": ");
            pos++;
            System.out.println(task);
        }
    }

    public static List deleteTask(List<Task> list) {
        outputListOfTasks(list);
        System.out.print("Введите номер задачи, которую Вы хотите удалить: ");
        Scanner scanner = new Scanner(System.in);
        String chois = scanner.nextLine();
        int choisInt = dateVerification(chois, 1, list.size());
         if (choisInt == -1) {
             System.out.println("Такой записи нет");
         } else {
             list.remove(choisInt-1);
             System.out.println("Завпись удалена");
         }
        return list;
    }

    public static void main(String[] args) throws ValueOutOfRangeException {
        Scanner scanner = new Scanner(System.in);
        List<Task> taskList = new LinkedList<>();
        int choiceInt = -1;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Вывести список задач");
            System.out.println("3. Удалить задачу");
            System.out.println("0. Выход");

            String choice = scanner.nextLine();
            choiceInt = dateVerification(choice, 0, 3);

            switch (choiceInt) {
                case (1):
                    addTask(taskList);
                    break;
                case (2):
                    outputListOfTasks(taskList);
                    break;
                case (3):
                    deleteTask(taskList);
                    break;
            }
        } while (choiceInt != 0);
        scanner.close();
    }
}
