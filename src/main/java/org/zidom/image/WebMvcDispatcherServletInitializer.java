package org.zidom.image;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.zidom.image.config.WebMvcConfig;

/**
 * Spring mvc 配置
 * 
 * @author zidom
 *
 */
public class WebMvcDispatcherServletInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 
	 * root 容器配置
	 * 
	 * @see org.springframework.web.servlet.support.
	 *      AbstractAnnotationConfigDispatcherServletInitializer
	 *      #getRootConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	/**
	 * 使用默认
	 * 
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/**
	 * 配置DispaterServlet路径
	 * 
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
