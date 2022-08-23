import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Server {

    public void startServer() {
        try (ServerSocket servSocket = new ServerSocket(23444);
             Socket socket = servSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(socket.getInputStream()))) {

            out.println(fib(Integer.parseInt(in.readLine())));

        } catch (NumberFormatException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static Long fib(int n) {
        List<Long> list = Stream.iterate(new long[]{0, 1}, arr -> new long[]{arr[1], arr[0] + arr[1]})
                .limit(n)
                .map(y -> y[0])
                .collect(Collectors.toList());
        return list.get(n - 1);
    }
}



