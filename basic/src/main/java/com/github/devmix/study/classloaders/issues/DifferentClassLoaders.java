package com.github.devmix.study.classloaders.issues;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sergey Grachev
 */
public class DifferentClassLoaders {

    private static final Logger LOG = LoggerFactory.getLogger(DifferentClassLoaders.class);

    public static void main(final String[] args) throws Exception {
        final Class<?> classA = Logger.class.getClassLoader().loadClass(DifferentClassLoaders.class.getName());
        final Class<?> classB = new OtherClassLoader().loadClass(DifferentClassLoaders.class.getName());

        final Object instanceA = classA.newInstance();
        final Object instanceB = classB.newInstance();

        LOG.info("A: {}", classA);
        LOG.info("B: {}", classB);
        LOG.info("isAssignableFrom(A): {}", DifferentClassLoaders.class.isAssignableFrom(classA));
        LOG.info("isInstance(A): {}", DifferentClassLoaders.class.isInstance(instanceA));
        LOG.info("isAssignableFrom(B): {}", DifferentClassLoaders.class.isAssignableFrom(classB));
        LOG.info("isInstance(B): {}", DifferentClassLoaders.class.isInstance(instanceB));

        ((DifferentClassLoaders) instanceA).hello();

        try {
            ((DifferentClassLoaders) instanceB).hello();
        } catch (final ClassCastException e) {
            LOG.info(e.getMessage());
        }
    }

    public void hello() {
        LOG.info("Hello");
    }

    public static final class OtherClassLoader extends ClassLoader {

        @Override
        public Class<?> loadClass(final String name) throws ClassNotFoundException {
            if (name.equalsIgnoreCase(DifferentClassLoaders.class.getName())) {
                final InputStream resource = this.getClass().getResourceAsStream("/" + name.replaceAll("\\.", "/") + ".class");
                try {
                    final byte[] b = IOUtils.toByteArray(resource);
                    return defineClass(name, b, 0, b.length);
                } catch (final IOException e) {
                    throw new ClassNotFoundException(e.getMessage(), e);
                }
            }
            return super.loadClass(name);
        }
    }
}
