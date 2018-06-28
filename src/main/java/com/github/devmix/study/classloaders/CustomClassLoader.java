package com.github.devmix.study.classloaders;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Sergey Grachev
 */
public class CustomClassLoader extends ClassLoader {

    private static final String CLASS_NAME = "com.github.devmix.study.classloaders.ExternalClass";

    public static void main(final String[] args) throws Exception {
        final Class<?> c = new CustomClassLoader().loadClass(CLASS_NAME);
        final Method m = c.getMethod("hello");
        final Object o = c.newInstance();
        m.invoke(o);
    }

    @Override
    public Class<?> loadClass(final String name) throws ClassNotFoundException {
        if (name.equalsIgnoreCase(CLASS_NAME)) {
            return loadClassExternal(name);
        }
        return super.loadClass(name);
    }

    private Class<?> loadClassExternal(final String name) throws ClassNotFoundException {
        try {
            final byte[] b = FileUtils.readFileToByteArray(new File("compiled", "ExternalClass.class"));
            return defineClass(name, b, 0, b.length);
        } catch (final IOException e) {
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }
}
