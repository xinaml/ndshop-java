package org.ndshop.user.register.boot;

import org.ndshop.dbs.jpa.boot.initializer.Components;
import org.springframework.stereotype.Component;

/**
 * Created by lgq on 16-10-13.
 */
@Component
public class MyComponents extends Components {

    @Override
    public String[] scanPackages() {
        return new String[]{"org.ndshop.user.common"};
    }


}
