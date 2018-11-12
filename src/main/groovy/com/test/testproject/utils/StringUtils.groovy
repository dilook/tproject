package com.test.testproject.utils

import org.apache.commons.lang3.RandomStringUtils

/**
 * Утлииты для работы со строкаим
 */
class StringUtils {

    /**
     * Метод возвращает рандомную строку из букв
     * @param length - длина возвращаемой строки
     * @param range - список используемых символов, по дефлоту используются заглавные и строчные буквы английского алфавита + цифры
     * @return - рандомная строка
     */
    static def getRandomString(int length, def range = ('A'..'Z') + ('a'..'z') + ('0'..'9')) {
        String charset = range.join()
        String randomString = RandomStringUtils.random(length, charset.toCharArray())
        return randomString
    }


    /**
     * Метод возвращает рандомную строку из цифр
     * @param length - длина возвращаемой строки
     * @param range - список используемых символов, по дефлоту используются 0-9
     * @return - рандомная строка
     */
    static def getIntString(int length, def range = ('0'..'9')) {
        String charset = range.join()
        String randomIntString = RandomStringUtils.random(length, charset.toCharArray())
        return randomIntString
    }
}
