package greekn.io.connect;

import greekn.io.response.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static greekn.io.response.ResHelper.ok;


/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-19 0:18
 * @package greekn.io.datasource
 * @modified Greekn
 * @description
 */
@RestController
@RequestMapping("/connect")
@ResponseBody
public class ConnectController {

    @PostMapping("/create")
    public String create() {
        return null;
    }

    @Autowired
    private ConnectClient connectClient;

    @PostMapping("/ping")
    public Res ping(@RequestBody ConnectDto connect) {
        connectClient.connectToClient(connect);
        return ok();
    }

}
