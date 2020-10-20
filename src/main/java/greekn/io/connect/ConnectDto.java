package greekn.io.connect;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-20 13:04
 * @package greekn.io.connect
 * @modified Greekn
 * @description
 */
@Data
public class ConnectDto {

    private final String schema = "redis://";

    private String host;
    private Integer port;
    private String auth;
    private String name;

    public String toUri() {
        StringBuilder builder = new StringBuilder();
        if (auth != null) {
            builder.append(auth).append("@");
        }
        builder.append(host).append(":");
        builder.append(port).append("/").append(0);
        return builder.toString();
    }

}
