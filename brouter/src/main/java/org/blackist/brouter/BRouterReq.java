package org.blackist.brouter;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * @author LiangLiang.Dong[liangl.dong@qq.com]
 * @since 2018/9/28
 */

public class BRouterReq {

    private String action;

    private String path;

    private Bundle param;

    private BRouterReq() {
        param = new Bundle();
    }

    /**
     * get instance of request
     *
     * @return request
     */
    public static BRouterReq build() {
        return new BRouterReq();
    }

    /**
     * set action for request
     *
     * @param action action
     * @return request
     */
    public BRouterReq action(String action) {
        this.action = action;
        return BRouterReq.this;
    }

    /**
     * set request path
     *
     * @param path request path
     * @return this
     */
    public BRouterReq path(String path) {
        if (this.param == null) {
            this.param = new Bundle();
        }
        this.path = path == null ? "" : path;
        return BRouterReq.this;
    }

    /**
     * set bundle param for request
     *
     * @param data bundle param
     * @return BRouter Request
     */
    public BRouterReq data(Bundle data) {
        if (this.param == null) {
            this.param = new Bundle();
        }
        if (data != null) {
            this.param.putAll(data);
        }
        return BRouterReq.this;
    }

    /**
     * put param into param
     *
     * @param key   key
     * @param value value
     * @return router request
     */
    public BRouterReq data(String key, Object value) {
        if (this.param == null) {
            this.param = new Bundle();
        }
        if (value == null) {
            this.param.putString(key, null);
        } else if (value instanceof String) {
            this.param.putString(key, value.toString());
        } else if (value.getClass().equals(int.class)) {
            this.param.putInt(key, (int) value);
        } else if (value.getClass().equals(boolean.class)) {
            this.param.putBoolean(key, (boolean) value);
        } else if (value.getClass().equals(float.class)) {
            this.param.putLong(key, (long) value);
        } else if (value.getClass().equals(char.class)) {
            this.param.putChar(key, (char) value);
        } else if (value.getClass().equals(short.class)) {
            this.param.putShort(key, (short) value);
        } else if (value instanceof Serializable) {
            this.param.putSerializable(key, (Serializable) value);
        } else if (value instanceof Parcelable) {
            this.param.putParcelable(key, (Parcelable) value);
        } else {
            this.param.putString(key, null);
        }

        return BRouterReq.this;
    }

    public String getAction() {
        return action;
    }

    public String getPath() {
        return path != null ? path : "";
    }

    public Bundle getParam() {
        return param;
    }
}
