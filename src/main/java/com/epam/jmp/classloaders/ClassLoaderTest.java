package com.epam.jmp.classloaders;

/**
 * Created by Aleksei_Okhrimenko on 28.02.2017.
 */
public class ClassLoaderTest extends CustomClassLoader {
    public static void main(String[] args) {
        CustomClassLoader classLoader = new CustomClassLoader();
        classLoader.invokeClassMethod("com.epam.jmp.classloaders.classes.Hello", "say");
        classLoader.invokeClassMethod("com.epam.jmp.classloaders.classes.Print", "print");
    }
}
