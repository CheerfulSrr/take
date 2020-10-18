package greekn.io.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-18 18:09
 * @package greekn.io.context
 * @modified Greekn
 * @description
 */
@Configuration
@ComponentScan(
        basePackages = "greekn.io"
        , excludeFilters = @ComponentScan.Filter(classes = Controller.class)
)
public class ApplicationContextConfig {
}
