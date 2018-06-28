package com.github.devmix.study.classloaders.issues.ee;

/**
 * @author Sergey Grachev
 */
public class ClassB {

    public ClassA invoke() {
        return new ClassA();
    }
}
