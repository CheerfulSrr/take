package greekn.io.response;

import static greekn.io.response.Res.response;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-19 13:52
 * @package greekn.io.response
 * @modified Greekn
 * @description
 */
public class ResHelper<T> {

    public static <T> Res<T> ok() {
        return (Res<T>) response(200).build();
    }

}
