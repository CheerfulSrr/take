package greekn.io.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-18 18:00
 * @package greekn.io.web
 * @modified Greekn
 * @description
 */
public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebMvcConfig.class };
    }

    /**
     * DispatchServlet映射
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
}
