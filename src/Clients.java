import java.io.*;
import java.util.HashMap;

//Класс с общей информацией о клиентах
public class Clients {

    //Файл с информацией о клиентах
    private static final String filePath = "clients.txt";
    //Общая информация о клиентах
    int id;
    String name;
    int numberDeal;
    //Хеш-карта для записи данных
    static HashMap<String, String> clients = new HashMap<>();

    // Пустой конструктор класса
    Clients() {
        id = 0;
        name = "";
        numberDeal = 0;
    }

    //Конструктор, который записывает информацию в поля класса
    Clients(int id, String name, int numberDeal) {
        this.id = id;
        this.name = name;
        this.numberDeal = numberDeal;
    }

    // Метод для записи в файл информации о клиентах
    public static void Write(Clients clients) throws Exception {
        // Создаем поток для чтения/записи из/в файл
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        // Записываем в файл информацию о клиентах
        pw.print(clients.id + ", ");
        pw.print(clients.name + ", ");
        pw.println(clients.numberDeal);

        // Закрываем потоки
        pw.close();
        bw.close();
        fw.close();
    }

    public static void Info() throws Exception {
        // Создаем поток для чтения информации из файла
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        // Создаем HashMap, где key - id, value - name + dealNumber (сделка)
        String line;
        // Читаем информацию из файла (name + id + dealNumber) и добавляем в HashMap (id + name + dealNumber)
        while ((line = br.readLine()) != null) {
            String[] data = line.split(", ");
            clients.put(data[1], data[0] + ", " + data[2]);
            System.out.println(line);
        }
        // Закрываем потоки
        br.close();
        fr.close();
    }

    //Метод добавления клиента
    public static void Add() {
        // Добавление клиента добавляет клиента в hashmap, а надо в файл
        String newName = "Ann White";
        String newId = "34568";
        String newDealNumber = "567";

        if (!clients.containsKey(newId)) {
            clients.put(newId, newName + ", " + newDealNumber);
            System.out.println("Added: " + newName + ", " + newId + ", " + newDealNumber);
        } else {
            System.out.println("Client with ID: " + newId + " already exists!");
        }
    }

    //Метод поиска клиента по id
    public static void IDSearch() {
        String searchId = "34568";
        if (clients.containsKey(searchId)) {
            System.out.println("Found: " + clients.get(searchId));
        } else {
            System.out.println("No client found with ID: " + searchId);
        }
    }

    public static void Delete() {
        String deleteId = "3";
        if (clients.containsKey(deleteId)) {
            clients.keySet().removeIf(key -> key != deleteId);
            System.out.println("Delete client with ID: " + deleteId);
        } else {
            System.out.println("Client have status non-activite");
        }


    }
}

