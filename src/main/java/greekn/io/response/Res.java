package greekn.io.response;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-19 13:38
 * @package greekn.io.response
 * @modified Greekn
 * @description
 */
public class Res<T> implements Serializable {

    private T data;
    private Integer status;
    private String msg;
    private Date time;

    public Res() {
        this.time = new Date();
    }

    private Res(ResBuilder<T> builder) {
        this();
    }

    public static <T> ResBuilder<T> response(int status) {
        return new ResBuilder<>(status);
    }

    public static class ResBuilder<T> {
        private T data;
        final private int status;
        private String msg;

        public ResBuilder(int status) {
            this.status = status;
        }

        public ResBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResBuilder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Res<T> build() {
            return new Res<>(this);
        }

    }

}
