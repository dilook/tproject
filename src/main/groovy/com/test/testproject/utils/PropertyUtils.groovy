package com.test.testproject.utils

import groovy.util.logging.Slf4j

import java.nio.file.Path
import java.nio.file.Paths

/**
 * Утилиты для работы с properties
 */
@Slf4j
class PropertyUtils {

    /**
     * Метод возвращает все Properties из файла setup.properties
     * @return
     */
    public static def getProperties() {
        Path currentRelativePath = Paths.get("")
        String s = currentRelativePath.toAbsolutePath().toString()
        log.debug("Current relative path is: " + s)
        def properties = new Properties()
        File propertiesFile = new File("setup.properties")
        if(!propertiesFile.exists()) {
           log.warn("File 'setup.properties' not found, will be used default values")
        }
        propertiesFile.withInputStream {
            properties.load(it)
        }

        log.debug("Properties successful loaded")
        return properties
    }

    /**
     * Получение значение свойства по имени
     * @param property
     * @return
     */
    public static String getProp(String property) {
        def prop = properties.getProperty(property)
        return prop
    }
}
