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
        if (dict.keySet().contains(PYTHON_CLASS_IDENTIFIER))
            dict.remove(PYTHON_CLASS_IDENTIFIER);
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

    /**
     * Creates a Java object from a map (comping from python most likely).
     * <p>The java class name will be taken from the python class name stored with the key `JNegmasApp.PYTHON_CLASS_IDENTIFIER`</p>
     * @param map A map used to construct the object using fromMap.
     * @return A PyCopyable object that is the Java version of the given map
     * @throws NoSuchFieldException if the class that should be instantiated has a field not in the map
     * @throws IllegalArgumentException if the map does not contain the class name to be instantiated as the value for key `JNegmasApp.PYTHON_CLASS_IDENTIFIER`
     *
     *
     */
    public static PyCopyable createJavaObjectFromMap(HashMap<String, Object> map) throws NoSuchFieldException
            , IllegalArgumentException {
        if (map == null){
            throw new RuntimeException("Cannot create a java object from map without a map!!");
        }
        if (!map.containsKey(JNegmasApp.PYTHON_CLASS_IDENTIFIER)){
            throw new IllegalArgumentException();
        }
        String javaClassName = String.format("j%s", map.get(JNegmasApp.PYTHON_CLASS_IDENTIFIER));
        return createJavaObjectFromMap(javaClassName, map);
    }

    /**
     * Creates a Java object from a map (comping from python most likely) knowing the java class name.
     *
     * @param javaClassName The java class name
     * @param map  The map
     * @return the object created
     * @throws NoSuchFieldException if the class that should be instantiated has a field not in the map
     * @throws IllegalArgumentException if the map does not contain the class name to be instantiated as the value for key `JNegmasApp.PYTHON_CLASS_IDENTIFIER`
     */
    public static PyCopyable createJavaObjectFromMap(String javaClassName
            , HashMap<String, Object> map) throws NoSuchFieldException, IllegalArgumentException {
        try {
            Class<?> cls = Class.forName(javaClassName);
            if (PyCopyable.class.isAssignableFrom(cls)){
                return JNegmasApp.fromMap((PyCopyable) cls.newInstance(), map);
            }
            throw new InstantiationException(String.format("Class %s is not PyCopyable", cls.getName()));
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    /**
     * Creates a python object (in the python program connected through the gateway).
     *
     * @param pythonClassName The full name of the class of which an object is to be created
     * @param kwargs The parameters to be passed to the constructor
     * @return An object that represents a python object to be called later.
     */
    public static Object createPythonObjectFromMap(String pythonClassName, HashMap<String, Object> kwargs) {
        return python.create(pythonClassName, kwargs);
    }

    public Object create(String className){
        System.out.format("Creating %s\n", className);
        try {
            Class<?> clazz = Class.forName(className);
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


    public PyCaller create(String className, Object pythonObject){
        System.out.format("Creating %s with python object\n", className);
        PyCaller javaObject = (PyCaller) create(className);
        javaObject.setPythonShadow(pythonObject);
        return javaObject;
    }

    public static void usage(){
        System.out.print("Usage: jnemas [--die-on-exit/--doe/-d] [--port/-p int] [--python-port/--pyport int]" +
                "[--client-server|--gateway]\n" +
                "Default is: --client-server\n" +
                "" +
                "The Python side should use the same client-server/gateway setting and connect to the same port");
    }

    static int parsePort(String[] args, int i, String opt){
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
        int pythonPort = DEFAULT_PYTHON_PORT;
        boolean dieOnBrokenPipe=false;
        boolean useClientServer=true;
        System.out.format("Received options: ");
        for (int i = 0; i < args.length; i++) {
            String opt = args[i];
            System.out.format("%s ", opt);
            if (opt.equals("--die-on-exit") || opt.equals("--doe") || opt.equals("-d")) {
                dieOnBrokenPipe = true;
            } else if (opt.equals("--client-server") || opt.equals("--single-thread")){
                useClientServer = true;
            } else if (opt.equals("--gateway") || opt.equals("--multiple-threads")){
                useClientServer = false;
            } else if (opt.equals("-p") || opt.equals("--port") || opt.equals("--java-port")
                    || opt.equals("--jport")){
                port = parsePort(args, i, opt);
                i++;
            } else if (opt.equals("--python-port") || opt.equals("--pyport")){
                pythonPort = parsePort(args, i, opt);
                i++;
            }else{
                System.out.format("Unknown argument: %s\n\n", opt);
                usage();
                System.exit(-1);
            }
        }
        System.out.format("\n");
        JNegmasApp app = new JNegmasApp();
        if (useClientServer) {
            // app is now the gateway.entryPoint
            ClientServer server = new ClientServer(DEFAULT_JAVA_PORT, GatewayServer.defaultAddress()
                    , pythonPort,
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
            int listeningPort = server.getListeningPort();
            System.out.format("Gateway to NegMAS started at port %d listening to port %d (multiple-threads)\n"
                    , port, listeningPort);
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
