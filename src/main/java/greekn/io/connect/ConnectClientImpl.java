package greekn.io.connect;

import io.lettuce.core.RedisClient;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-20 13:07
 * @package greekn.io.connect
 * @modified Greekn
 * @description
 */
@Service
public class ConnectClientImpl implements ConnectClient {
    @Override
    public void connectToClient(ConnectDto connectDto) {
        try {
            RedisClient.create(connectDto.toUri()).connect();
        } catch (Exception e) {

        }
    }
}
