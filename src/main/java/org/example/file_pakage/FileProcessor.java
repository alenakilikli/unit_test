package org.example.file_pakage;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.example.annotations.FileResource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

public class FileProcessor {

    @SneakyThrows
    public void fileReader(Object object) {

        Field[] fields = Class.class.getDeclaredFields();
        for (Field f : fields) {
            FileResource fr = f.getAnnotation(FileResource.class);
            try {
                String str = FileUtils.readFileToString(new File(fr.value()), Charset.defaultCharset());
                f.setAccessible(true);
                f.set(object, str);

            } catch (IOException e) {
                if (f.getAnnotation(FileResource.class).nullIfError()) {
                    f.set(object, null);
                }
            }

        }

    }
}
