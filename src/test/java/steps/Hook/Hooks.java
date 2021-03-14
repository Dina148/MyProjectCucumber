package steps.Hook;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        System.out.println("Hook - Before Annotation");
    }

    @After
    public void after(){
        System.out.println("Hook - After Annotation");
    }

}
