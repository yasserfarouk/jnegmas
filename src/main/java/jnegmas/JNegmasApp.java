package jnegmas;

import py4j.ClientServer;
import py4j.GatewayServer;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

public class JNegmasApp {

    public static final String PYTHON_CLASS_IDENTIFIER = "__python_class__";
    private static final int DEFAULT_JAVA_PORT = 25333;
    private static final int DEFAULT_PYTHON_PORT = 25334;
    public static PyEntryPoint python;

    public static<T extends PyCopyable> T fromMap(T object, HashMap<String, Object> dict) throws NoSuchFieldException
            , IllegalAccessException, InstantiationException {
        object.fromMap(dict);
        return object;
    }
    public static HashMap<String, Object> toMap(PyCopyable object) throws IllegalAccessException {
        if (object == null)
            return null;
        HashMap<String, Object> map = object.toMap();
        map.put(JNegmasApp.PYTHON_CLASS_IDENTIFIER, object.getPythonClassName());
        return map;
    }

    public static<T extends PyCopyable> T createFromMap(HashMap<String, Object> dict) throws NoSuchFieldException
            , IllegalArgumentException {
        if (!dict.containsKey(JNegmasApp.PYTHON_CLASS_IDENTIFIER)){
            throw new IllegalArgumentException();
        }
        String java_class_name = String.format("j%s", dict.get(JNegmasApp.PYTHON_CLASS_IDENTIFIER));
        return createFromMap(java_class_name, dict);
    }
    public static<T extends PyCopyable> T createFromMap(String java_class_name, HashMap<String, Object> dict) throws NoSuchFieldException
            , IllegalArgumentException {
        try {
            Class cls = Class.forName(java_class_name);
            return JNegmasApp.fromMap((T) cls.newInstance(), dict);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

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



    public PyCaller create(String class_name, PyCallable python_object){
        System.out.format("Creating %s with python object\n", class_name);
        PyCaller java_object = (PyCaller) create(class_name);
        java_object.setPythonShadow(python_object);
        return java_object;
    }

    public static void usage(){
        System.out.print("Usage: jnemas [--die-on-exit/--doe/-d] [--port/-p int] [--python-port/--pyport int]" +
                "[--client-server|--gateway]\n" +
                "Default is: --client-server\n" +
                "" +
                "The Python side should use the same client-server/gateway setting and connect to the same port");
    }

    static int parse_port(String[] args, int i, String opt){
        int port = 0;
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
        return port;
    }

    public static void main(String[] args) {
        int port = DEFAULT_JAVA_PORT;
        int python_port = DEFAULT_PYTHON_PORT;
        boolean dieOnBrokenPipe=false;
        boolean use_client_server=true;
        System.out.format("Received options: ");
        for (int i = 0; i < args.length; i++) {
            String opt = args[i];
            System.out.format("%s ", opt);
            if (opt.equals("--die-on-exit") || opt.equals("--doe") || opt.equals("-d")) {
                dieOnBrokenPipe = true;
            } else if (opt.equals("--client-server") || opt.equals("--single-thread")){
                use_client_server = true;
            } else if (opt.equals("--gateway") || opt.equals("--multiple-threads")){
                use_client_server = false;
            } else if (opt.equals("-p") || opt.equals("--port") || opt.equals("--java-port")
                    || opt.equals("--jport")){
                port = parse_port(args, i, opt);
                i++;
            } else if (opt.equals("--python-port") || opt.equals("--pyport")){
                python_port = parse_port(args, i, opt);
                i++;
            }else{
                System.out.format("Unknown argument: %s\n\n", opt);
                usage();
                System.exit(-1);
            }
        }
        System.out.format("\n");
        JNegmasApp app = new JNegmasApp();
        if (use_client_server) {
            // app is now the gateway.entry_point
            ClientServer server = new ClientServer(DEFAULT_JAVA_PORT, GatewayServer.defaultAddress()
                    , python_port,
                    GatewayServer.defaultAddress(), GatewayServer.DEFAULT_CONNECT_TIMEOUT,
                    GatewayServer.DEFAULT_READ_TIMEOUT, ServerSocketFactory.getDefault()
                    , SocketFactory.getDefault(),
                    app);
            server.startServer();
            python = (PyEntryPoint) server.getPythonServerEntryPoint(new Class[] {PyEntryPoint.class});
            System.out.format("Gateway to NegMAS started at port %d (single-thread)\n", port);
        } else{
            GatewayServer server = new GatewayServer(app, port);
            server.start();
            python = (PyEntryPoint) server.getPythonServerEntryPoint(new Class[] {PyEntryPoint.class});
            int listening_port = server.getListeningPort();
            System.out.format("Gateway to NegMAS started at port %d listening to port %d (multiple-threads)\n"
                    , port, listening_port);
        }

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
