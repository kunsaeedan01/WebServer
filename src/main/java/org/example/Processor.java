package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
public class Processor {
    private final Socket socket;
    private final HttpRequest request;
    public Processor(Socket socket, HttpRequest request) {
        this.socket = socket;
        this.request = request;
    }

    public void process() throws IOException {
        System.out.println("Got request:");
        System.out.println(request.toString());
        System.out.flush();
        PrintWriter output = new PrintWriter(socket.getOutputStream());

        if(request.getRequestLine().contains("/create/itemid"))
        {
            System.out.println("hello world");
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<html>");
            output.println("<head><title>Create</title></head>");
            output.println("<body><p>New Item ID was create</p></body>");
            output.println("</html>");
            output.flush();
            socket.close();
        }
        else if (request.getRequestLine().contains("/delete/itemid"))
        {
            System.out.println("hello world");
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<html>");
            output.println("<head><title>Delete</title></head>");
            output.println("<body><p>Item ID was delete</p></body>");
            output.println("</html>");
            output.flush();
            socket.close();
        } else if (request.getRequestLine().contains("/exec/params")){
            System.out.println("hello world");
            int random = 100 + (int) (Math.random() * 10000);
            int random1 = 1000 + (int) (Math.random() * 1000000);
            int random2 = 10000 + (int) (Math.random() * 10000000);
            int sum=0;
            int sum1=0;
            int sum2=0;
            for (int i=0;i<random;i++){
                sum+=i;
            }
            for (int i=0;i<random1;i++){
                sum1+=i;
            }
            for (int i=0;i<random2;i++){
                sum2+=i;
            }
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<html>");
            output.println("<head><title>Parameter</title></head>");
            output.println("<body><p>Parameter was executed</p></body>");
            output.println("<body><p>"+random+ " : "+ sum + " : "+ sum1 +" : "+ sum2 +"</p></body>");
            output.println("</html>");
            output.flush();
            socket.close();
        } else {
            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<html>");
            output.println("<head><title>hello world!</title></head>");
            output.println("<body><p>Hi</p></body>");
            output.println("</html>");
            output.flush();
            socket.close();
        }
    }
}
