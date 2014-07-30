package org.zidom.image.service;

/**
 * @author zidom
 *
 * @param <T>
 */
public interface ImageArgsParser<T> {

	T parse(String args);

}
