import java.io.*;
import java.util.*;
public class Main {
    //Сканер для считывания информации
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        System.out.print("Введите колво клиентов ");
        int n = input.nextInt();
        WriterClients(n);

    }

    public static void WriterClients(int n) throws Exception{
        for (int i = 0; i < n; i++) {
            System.out.print("Id клиента ");
            int id = input.nextInt();
            System.out.print("Имя клиента ");
            String name = input.nextLine();
            System.out.print("Номер сделки ");
            int num = input.nextInt();
            Clients clients = new Clients(id, name, num);
            Clients.Write(clients);
        }
    }
}


