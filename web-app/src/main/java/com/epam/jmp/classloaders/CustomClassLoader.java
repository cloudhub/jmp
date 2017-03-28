package com.epam.jmp.classloaders;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Aleksei_Okhrimenko on 28.02.2017.
 */
public class CustomClassLoader extends ClassLoader {

    public void invokeClassMethod(String className, String methodName) {

        try {
            // create new classloader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // load target class using its name
            Class loadedClass = classLoader.loadClass(className);
            System.out.println("Loaded class name: " + loadedClass.getName());

            // create new instance from the loaded class
            Constructor constructor = loadedClass.getConstructor();
            Object loadedClassObject = constructor.newInstance();

            // getting the target method from the loaded class and invoke it using its name
            Method method = loadedClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(loadedClassObject);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
