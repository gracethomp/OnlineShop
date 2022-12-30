package com.solvd;

import com.solvd.connectionPool.ConnectionPool;
import com.solvd.connectionPool.connectionPoolFuture.ConnectionPoolFuture;
import com.solvd.entity.user.stuff.ClothingSizes;
import com.solvd.exceptions.ConnectionPoolException;
import com.solvd.exceptions.ReflectionException;
import com.solvd.helperClasses.LambdaTask;
import com.solvd.helperClasses.PolymorphismTask;
import com.solvd.helperClasses.ReflectionTask;
import com.solvd.linkedList.MyLinkedList;
import com.solvd.threads.MyThreadExtension;
import com.solvd.threads.MyThreadImplementation;


public class Main {
    public static void main(String[] args) throws ConnectionPoolException, ReflectionException {
        WordsCounter.countWords("src/main/resources/text.txt");

        MyLinkedList.testLinkedList();
        System.out.println('\n');

        ClothingSizes.printSizesInfo();
        System.out.println('\n');

        //polymorphism with interface
        PolymorphismTask.showPolymorphismInterfaceExample();
        System.out.println('\n');

        //polymorphism with abstract class
        PolymorphismTask.showPolymorphismClassExample();
        System.out.println('\n');

        LambdaTask.showLambdaTask();
        System.out.println('\n');

        ReflectionTask.showReflectionTaskResult();
        System.out.println('\n');

        //ConnectionPool.doTest();
        //ConnectionPoolFuture.doTest();

        Thread thread = new MyThreadExtension();
        thread.start();

        Thread thread1 = new Thread(new MyThreadImplementation());
        thread1.start();
    }
}
