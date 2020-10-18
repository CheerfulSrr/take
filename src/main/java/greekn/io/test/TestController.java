package greekn.io.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-18 18:15
 * @package greekn.io.test
 * @modified Greekn
 * @description
 */
@Controller
public class TestController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
