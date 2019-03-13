import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args)
    {

        ArrayList<Entity> entities = new ArrayList<>(0);
        ArrayList<TvConnectionHandler> threads = new ArrayList<>(0);

        String[] testStrings = {"iederen heeft vrij om 12 uur.", "Test message please ignore", "Ok parry people jullie hebben vrij"};
        String[] testStrings1 = {"iederen heeft vrij om 1 uur."};


        entities.add(new Entity(testStrings));
        entities.add(new Entity(testStrings1));
        System.out.println(entities.get(0));
        System.out.println(entities.get(1));

        ServerSocket socketHandler = null;
        try
        {
            InetAddress iAddress = InetAddress.getLocalHost();
            socketHandler = new ServerSocket(6121);

            System.out.println(iAddress.getHostAddress());
        }catch (IOException e)
        {
            System.out.println("ERROR: " + e.getMessage());
            System.exit(0);
        }
        Socket s = null;
        while(true) {
            try {
                s = socketHandler.accept();

                BufferedInputStream input = new BufferedInputStream(s.getInputStream());
                PrintWriter output = new PrintWriter(s.getOutputStream(), true);
                TvConnectionHandler t = null;



                int code = Server.getAuthorizationCode(input);
                if(code >= 100000 && code <= 999999) {
                    for (Entity entity : entities) {
                        if (entity.getId() == code) {
                            t = new TvConnectionHandler(s, output, input, entity);
                            break;
                        }
                    }
                    if (t != null) {
                        t.start();
                        System.out.println("SUCCESS: Connected with code: " + code);
                        threads.add(t);
                    }else{
                        s.close();
                    }
                }else
                {
                    s.close();
                }
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.exit(0);
            }

        }
    }

    private static int getAuthorizationCode(InputStream input)
    {
        String authorizationCode = "";
        int code;
        try {
            int b = input.read();
            while (b != '\n') {
                authorizationCode = authorizationCode + (char) b;
                b = input.read();
            }
        }catch (Exception e)
        {
            System.err.println("ERROR: " + e);
        }

        try {
            code = new Integer(authorizationCode);
        }catch (NumberFormatException e)
        {
            code = -1;
        }
        return code;
    }
}
