package org.tuma.bo;

import java.io.Serializable;

public class RemoteResponse<T> implements Serializable {

    public static final int SUCCESS = 200;
    public static final int FAILURE = 500;
    public static final int ILLEGAL_PARAMETER = 501;
    public static final int EXCEPTION = 400;
    public static final int UNAUTHORIZED = 401;
    private static final String SUCCESS_INFO = "success";
    private static final long serialVersionUID = -6747065168469554620L;

    private Long queryId;
    private boolean hasNext;
    private int code;
    private String msg;
    private T data;

    public RemoteResponse() {
    }

    public RemoteResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RemoteResponse(RemoteResponse.Builder<T> builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.data = builder.data;
        this.queryId = builder.queryId;
        this.hasNext = builder.hasNext;
    }

    public static <T> RemoteResponse.Builder<T> custom() {
        return new RemoteResponse.Builder();
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public Long getQueryId() {
        return this.queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public boolean getHasNext() {
        return this.hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String toString() {
        return "RemoteResponse{code=" + this.code + ", msg='" + this.msg + '\'' + ", data=" + this.data + '}';
    }

    public static <T> RemoteResponse<T> success() {
        RemoteResponse remoteResponse = new RemoteResponse();
        remoteResponse.code = 200;
        remoteResponse.msg = "success";
        remoteResponse.data = Boolean.TRUE;
        return remoteResponse;
    }

    public RemoteResponse<T> failure(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public RemoteResponse<T> failure() {
        this.code = 500;
        this.msg = "server error";
        return this;
    }

    public static class Builder<T> {
        private int code;
        private String msg;
        private T data;
        private Long queryId;
        private boolean hasNext;

        public Builder() {
        }

        public RemoteResponse.Builder setCode(int val) {
            this.code = val;
            return this;
        }

        public RemoteResponse.Builder setSuccess() {
            this.code = 200;
            this.msg = "success";
            return this;
        }

        public RemoteResponse.Builder setFailure(String msg) {
            this.code = 500;
            this.msg = msg;
            return this;
        }

        public RemoteResponse.Builder setException(String msg) {
            this.code = 400;
            this.msg = msg;
            return this;
        }

        public RemoteResponse.Builder setIllegalParameter(String msg) {
            this.code = 501;
            this.msg = msg;
            return this;
        }

        public RemoteResponse.Builder setMsg(String val) {
            this.msg = val;
            return this;
        }

        public RemoteResponse.Builder setData(T val) {
            this.data = val;
            return this;
        }

        public RemoteResponse.Builder setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
            return this;
        }

        public RemoteResponse.Builder setQueryId(Long queryId) {
            this.queryId = queryId;
            return this;
        }

        public RemoteResponse<T> build() {
            return new RemoteResponse(this);
        }
    }

}
