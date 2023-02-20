package com.siwen.qqzone.exceptions;

/**
 * @projectName: JavaWeb
 * @package: siwen.exceptions
 * @className: DaoException
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 1:33 PM
 * @version: 1.0
 */

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}