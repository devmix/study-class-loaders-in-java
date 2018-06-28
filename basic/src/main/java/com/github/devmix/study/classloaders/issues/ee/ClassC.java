package com.github.devmix.study.classloaders.issues.ee;

/**
 * @author Sergey Grachev
 */
public class ClassC {

//    @Inject
    private ClassB classB;

    public ClassA invoke() {
        return classB.invoke();
    }
}
