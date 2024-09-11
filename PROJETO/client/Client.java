package client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
    Socket socket = null;
    final String IP = "127.0.0.1";
    final int PORT = 9876;
    PrintStream printStream = null;
    Scanner scanner = null;

    //criação do socket e pedido de conexão 
    try {
        socket = new Socket(IP, PORT);
        System.out.println("Conectado com o servidor");

    } catch (Exception e) {
        System.out.println("Erro ao conectar com o servidor");
        System.out.println(e.getMessage());
        return;
    }

    //comunicação
    try {
        printStream = new PrintStream(socket.getOutputStream());
        printStream.println("Boa noite servidor");
    } catch (Exception e) {
        System.out.println("Erro na comunicação");
        System.out.println(e.getMessage())
        ;
    }

    try {
        scanner = new Scanner(socket.getInputStream());
        String message = scanner.nextLine();
        System.out.println("Recebido: " + message);
    } catch (Exception e) {
        System.out.println("Erro ao receber mensagem");
        System.out.println(e.getMessage());
    }

    //encerrar a comunicação
    try {
        System.out.println("Encerrando a conexão com o servidor");
        socket.close();
    } catch (Exception e) {
        System.out.println("Erro ao fechar a conexão");
        System.out.println(e.getMessage());
    }
}
}
