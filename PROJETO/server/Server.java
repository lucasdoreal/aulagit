package server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
public static void main(String[] args) {
    final int PORT = 9876; 
    ServerSocket serverSocket = null;
    Socket socketClient = null;
    Scanner scanner = null;
    PrintStream printStream = null;

    //criação do socket
    try {
        serverSocket = new ServerSocket(PORT); //bind
        System.out.println("Servidor disponivel na porta" + PORT);
    } catch (Exception e) {
        System.out.println("Erro de bind.");
        System.out.println(e.getMessage());
        return;
    }


    //conexão
    try {
        System.out.println("Aguardando o cliente...");
        socketClient = serverSocket.accept();
        System.out.println("Conectado ao cliente");
    } catch (Exception e) {
        System.out.println("Erro na conexão com o cliente");
        System.out.println(e.getMessage());
    }

    //comunicação
    try {
        scanner = new Scanner(socketClient.getInputStream());
        String message = scanner.nextLine();
        System.out.println("Recebido: " + message);
    } catch (Exception e) {
        System.out.println("Erro ao receber mensagem");
        System.out.println(e.getMessage());
    }

    try {
        printStream = new PrintStream(socketClient.getOutputStream());
        printStream.println("Boa noite cliente");
    } catch (Exception e) {
        System.out.println("Erro na comunicação");
        System.out.println(e.getMessage())
        ;
    }
    //encerrar conexão

    try {
        System.out.println("Encerrando o servidor.");
        if(socketClient != null)
        {
            socketClient.close();
        }
        socketClient.close();
        serverSocket.close();
    } catch (Exception e) {
        System.out.println("Erro ao fechar: " + e.getMessage());
    }
}
}
