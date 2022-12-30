package com.solvd.helperClasses;

import com.solvd.exceptions.ReflectionException;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTask {
    private static final Logger LOGGER = Logger.getLogger(ReflectionTask.class);

    public static void showReflectionTaskResult() throws ReflectionException {
        try {
            Class<?> c = Class.forName("com.solvd.entity.user.Admin");
            Constructor<?>[] constructor = c.getConstructors();
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getMethods();
            Arrays.stream(fields).toList().forEach(LOGGER::info);
            System.out.println();
            Arrays.stream(constructor).toList().forEach(LOGGER::info);
            System.out.println();
            Arrays.stream(methods).toList().forEach(LOGGER::info);
            Class<?> cSuperclass = c.getSuperclass();
            System.out.println();
            LOGGER.info(cSuperclass.getName());
            Object v = c.getConstructor().newInstance();
            LOGGER.info(v);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error(e);
            throw new ReflectionException();
        }
    }
}
