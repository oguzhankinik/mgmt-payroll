package com.kinik.mgmt.payroll.exception;

import java.text.MessageFormat;

/**
 * This exception class is provide handling predefined custom extension.
 *
 * @author oguzhankinik
 */
public class CodedException extends RuntimeException {

    private static final long serialVersionUID = -8265239511433790315L;

    public CodedException(Throwable throwCause) {
        super(throwCause);
    }

    public CodedException(String msg, Object... params) {
        this(msg, null, params);
    }

    public CodedException(String msg, Throwable throwCause, Object... params) {
        super(MessageFormat.format(msg, params), throwCause);
    }

    public CodedException(Enum<?> enumCode, Object... params) {
        this(enumCode, null, params);
    }

    public CodedException(Enum<?> enumCode, Throwable throwCause, Object... params) {
        super(generateMsg(enumCode, params), throwCause);
    }

    private static String generateMsg(Enum<?> enumCode, Object... params) {
        String enumMsg = MessageFormat.format(enumCode.toString(), params);
        return enumMsg;
    }

}