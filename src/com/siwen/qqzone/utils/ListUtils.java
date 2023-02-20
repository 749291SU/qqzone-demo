package com.siwen.qqzone.utils;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.utils
 * @className: ListUtils
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 10:04 PM
 * @version: 1.0
 */

public class ListUtils {
    private ListUtils() {}

    public static boolean listIsEmpty(List list) {
        return list == null || list.isEmpty();
    }
}
