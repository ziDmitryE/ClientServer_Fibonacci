import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 23444);
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(
                         new OutputStreamWriter(socket.getOutputStream()), true);
                 Scanner scanner = new Scanner(System.in)) {
                System.out.println("Для рассчета N-го члена ряда Фибоначчи введите целое число");
                String msg = scanner.nextLine();
                out.println(msg);
                System.out.println("Подключаемся к серверу и ждем ответа ...\n");
                Thread.sleep(2000); //имитируем процесс рассчета сервером
                System.out.println("Сервер: " + msg + " член ряда Фибоначчи равен " + in.readLine());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
