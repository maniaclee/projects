package psyco.springQuartz;

import org.springframework.stereotype.Service;
@Service("jobone")
public class MyJobOne {
    protected void myTask() {
        System.out.println("This is my task");
    }
} 