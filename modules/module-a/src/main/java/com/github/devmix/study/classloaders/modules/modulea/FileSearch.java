package com.github.devmix.study.classloaders.modules.modulea;

import com.github.devmix.study.classloaders.modules.modulea.api.SearchApi;

/**
 * @author Sergey Grachev
 */
public class FileSearch implements SearchApi {

    @Override
    public String execute(final String text) {
        return name() + ": " + text;
    }

    public String name() {
        return this.getClass().getSimpleName();
    }
}
