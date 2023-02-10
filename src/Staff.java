import java.io.BufferedReader;
import java.io.FileReader;

public class Staff {
    //Файл с информацией о сотрудниках

    //Общая информация о сотрудниках
    int id;
    String name;
    String address;
    int idTax;
    int idBelay;
    int idMedecine;
    String placeBorn;
    int phoneNumber;
    String email;
    // Пустой конструктор класса
    Staff(){
        this.id = 0;
        this.name = "";
        this.address = "";
        this.idTax = 0;
        this.idBelay = 0;
        this.placeBorn = "";
        this.phoneNumber = 0;
    }
    //Конструктор, который записывает информацию в поля класса
    Staff(int id, String name, String address, int idTax, int idBelay, String placeBorn, int phoneNumber){
        this.id = id;
        this.name = name;
        this.address = address;
        this.idTax = idTax;
        this.idBelay = idBelay;
        this.placeBorn = placeBorn;
        this.phoneNumber = phoneNumber;
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
