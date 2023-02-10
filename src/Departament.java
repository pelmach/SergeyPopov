import java.io.*;
import java.util.*;

//Класс с информацией об отделах
public class Departament {

    //Файл с информацией об отделах
    private static final String filePath = "department.txt";

    int id;
    String name;
    // хеш-карта для записи данных
    static HashMap<String, String> depertaments = new HashMap<>();
    // Пустой конструктор класса
    Departament() {
        id = 0;
        name = "";

    }

    //Конструктор, который записывает информацию в поля класса
    Departament(int id, String name) {
        this.id = id;
        this.name = name;

    }
    // Метод для записи в файл информации об отделах
    public static void Write(Departament departament) throws Exception {
        // Создаем поток для чтения/записи из/в файл
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        // Записываем в файл информацию о клиентах
        pw.print(departament.id + ", ");
        pw.print(departament.name + ", ");

        // Закрываем потоки
        pw.close();
        bw.close();
        fw.close();
    }

    public static void Info() throws Exception {
        // Создаем поток для чтения информации из файла
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        // Создаем HashMap, где key - id, value - name
        String line;
        // Читаем информацию из файла (name + id) и добавляем в HashMap (id + name)
        while ((line = br.readLine()) != null) {
            String[] data = line.split(", ");
            depertaments.put(data[1], data[0] + ", ");
            System.out.println(line);
        }
        // Закрываем потоки
        br.close();
        fr.close();
    }

    //Метод добавления отдела
    public static void Add() {
        // Добавление клиента добавляет клиента в hashmap, а надо в файл
        String newName = "Information Security";
        String newId = "1";

        if (!depertaments.containsKey(newId)) {
            depertaments.put(newId, newName + ", ");
            System.out.println("Added: " + newName + ", " + newId + ", ");
        } else {
            System.out.println("Client with ID: " + newId + " already exists!");
        }
    }

    //Метод поиска клиента по id
    public static void IDSearch() {
        String searchId = "34568";
        if (depertaments.containsKey(searchId)) {
            System.out.println("Found: " + depertaments.get(searchId));
        } else {
            System.out.println("No client found with ID: " + searchId);
        }
    }

    //Метод удаляющий отдел
    public static void Delete() {
        String deleteId = "2";
        if (depertaments.containsKey(deleteId)) {
            depertaments.keySet().removeIf(key -> key != deleteId);
            System.out.println("Delete client with ID: " + deleteId);
        } else {
            System.out.println("Client have status non-activite");
        }
    }

}
