public class Main {

    public static void main(String[] args) {

        /*
        для решения задачи используем Blocking IO т.к. у нас простая задача запрос->ответ,
        нет параллельных задач
         */

        Server server = new Server();
        Client client = new Client();

        new Thread(null, server::startServer, "Server").start();
        new Thread(null, client::startClient, "Client").start();
    }
}
