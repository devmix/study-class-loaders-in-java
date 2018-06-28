package com.github.devmix.study.classloaders.modules.modulea.api;

import com.github.devmix.study.classloaders.modules.modulea.FileSearch;

/**
 * @author Sergey Grachev
 */
public class SearchFactory {
    public static SearchApi createFileSearch() {
        return new FileSearch();
    }
}
