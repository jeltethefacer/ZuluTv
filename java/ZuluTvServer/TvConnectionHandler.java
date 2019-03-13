import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.SocketException;
import java.rmi.server.ExportException;

public class TvConnectionHandler extends Thread {
    final PrintWriter output;
    final BufferedInputStream input;
    final Socket s;
    Entity entity;
    public TvConnectionHandler(Socket s, PrintWriter output, BufferedInputStream input, Entity entity)
    {
        this.output = output;
        this.input = input;
        this.s = s;
        this.entity = entity;
    }

    @Override
    public void run()
    {
        //on connection sends info;
        String returnString = entity.toJSON();
        output.print(returnString);
        output.flush();

        int received;
        String fullText = "";
        while (true)
        {
            try {
                // receive the answer from client
                received = input.read();
                if (received == -1) {
                    this.close();
                    break;
                }
                if(received == '\n')
                {
                    System.out.println(fullText);
                    fullText = "";
                }else
                {
                    fullText = fullText + (char)received;
                }

            }
            catch (SocketException e)
            {
                this.close();
                System.out.println("Connection closed on SocketException");
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        try
        {
            // closing resources
            this.input.close();
            this.output.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public void update()
    {
        System.out.println("Updating");
        String returnString = entity.toJSON();
        output.print(returnString);
        output.flush();
    }

    private void close()
    {
        try
        {
            this.s.close();
            System.out.println("Connection closed");
        }catch (Exception e)
        {
            System.err.println("ERROR: " + e.getMessage());
        }

    }

}
