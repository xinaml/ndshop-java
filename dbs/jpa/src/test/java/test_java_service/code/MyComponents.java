package test_java_service.code;

import org.ndshop.dbs.jpa.boot.initializer.Components;
import org.ndshop.dbs.jpa.boot.initializer.EntityToScan;
import org.springframework.stereotype.Component;

/**
 * Created by lgq on 16-11-18.
 */
@Component
public class MyComponents extends Components implements EntityToScan{
    @Override
    public String[] entityScan() {
        return new String[]{"test_java_service.code.entity"};
    }
}
