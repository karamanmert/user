package com.karamanmert.user.service.spec;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public interface Validator<T> {

    void isValidForCreate(T t);

    void isValidForUpdate(T t);
}
