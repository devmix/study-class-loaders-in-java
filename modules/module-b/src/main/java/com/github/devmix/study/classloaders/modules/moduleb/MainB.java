package com.github.devmix.study.classloaders.modules.moduleb;

import com.github.devmix.study.classloaders.modules.modulea.api.SearchApi;
import com.github.devmix.study.classloaders.modules.modulea.api.SearchFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Sergey Grachev
 */
public class MainB {

    public static void main(final String[] args) {
        final SearchApi search = SearchFactory.createFileSearch();

//        final com.github.devmix.study.classloaders.modules.modulea.FileSearch fileSearch
//                = new FileSearch();

        System.out.println(search.getClass());
        System.out.println(search.execute("text"));

        try {
            final Method name = search.getClass().getDeclaredMethod("name");
            System.out.println(name.invoke(search));
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
