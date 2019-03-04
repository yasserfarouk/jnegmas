package jnegmas;

import py4j.GatewayServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class JNegmasApp {

    private static final int DEFAULT_JAVA_PORT = 25337;
    private static final int DEFAULT_PYTHON_PORT = 25336;

    public Object create(String class_name){
        System.out.format("Creating %s\n", class_name);
        try {
            Class<?> clazz = Class.forName(class_name);
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void usage(){
        System.out.print("Usage: jnemas [--die-on-exit/--doe/-d] [--port/-p int]\n");
    }

    public static void main(String[] args) {
        int port = DEFAULT_JAVA_PORT;
        boolean dieOnBrokenPipe=false;
        System.out.format("Received options: ");
        for (int i = 0; i < args.length; i++) {
            String opt = args[i];
            System.out.format("%s ", opt);
            if (opt.equals("--die-on-exit") || opt.equals("--doe") || opt.equals("-d")) {
                dieOnBrokenPipe = true;
            } else if (opt.equals("-p") || opt.equals("--port")){
                if (i < args.length - 1) {
                    try {
                        port = Integer.parseInt(args[i + 1]);
                    }catch (NumberFormatException e){
                        System.out.format("%s is not a number! (port numbers must be numbers)\n\n", args[i+1]);
                        usage();
                        System.exit(-1);
                    }

                }
                else{
                    System.out.format("Cannot pass %s as last argument\n\n", opt);
                    usage();
                    System.exit(-1);
                }
            }else{
                System.out.format("Unknown argument: %s\n\n", opt);
                usage();
                System.exit(-1);
            }
        }
        System.out.format("\n");
        JNegmasApp app = new JNegmasApp();
        // app is now the gateway.entry_point
        GatewayServer server = new GatewayServer(app, port);
        server.start();
        int listening_port = server.getListeningPort();
        System.out.format("Gateway to NegMAS started at port %d listening to port %d\n", port, listening_port);

        if (dieOnBrokenPipe) {
            /* Exit on EOF or broken pipe.  This ensures that the server dies
             * if its parent program dies. */
            try {
                BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
                stdin.readLine();
                System.exit(0);
            } catch (java.io.IOException e) {
                System.exit(1);
            }
        }
    }
}
