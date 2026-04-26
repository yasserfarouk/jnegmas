package jnegmas;

import org.junit.Test;

import static org.junit.Assert.*;

interface MyInterface{
    void hello();
}
class PyCallerExample extends PyCaller<MyInterface> implements  MyInterface{
    public void hello(){
        System.out.println("hello");
    }
}

public class PyCallerTest {



    @Test
    public void gettingClassInfo(){
        PyCallerExample example = new PyCallerExample();
        assertEquals(example.myInterface, MyInterface.class);
    }
    @Test
    public void setPythonShadow() {
    }

    @Test
    public void getPythonShadow() {
    }

    @Test
    public void createPythonShadow() {
    }
}