package com.zmr.ImportantComponents.RequestCode;

/**
 * http 请求编码信息
 */
public enum RequestCode {
    // --------------------2xx--------------------
    /** <p> 表示从客户端发来的请求在服务器端被正确处理 </p> */
    OK("200", "OK"),
    /** <p> 请求已经被实现，⽽且有⼀个新的资源已经依据请求的需要⽽建⽴; </p>
     <p> 通常是在POST请求，或是某些PUT请求之后创建了内容, 进行的返回的响应; </p> */
    CREATED("201", "Created"),
    /** <p> 请求服务器已接受，但是尚未处理，不保证完成请求; </p>
     <p> 适合异步任务或者说需要处理时间比较长的请求，避免HTTP连接一直占用; </p> */
    ACCEPTED("202", "Accepted"),
    /** <p> 表示请求成功，但响应报⽂不含实体的主体部分 </p> */
    NO_CONTENT("204", "No content"),
    /** <p> 进⾏的是范围请求, 表示服务器已经成功处理了部分 GET 请求; </p>
     <p> 响应头中会包含获取的内容范围 (常用于分段下载); </p> */
    PARTIAL_CONTENT("206", "Partial Content"),


    // --------------------3xx--------------------
    /**
     * <p> 永久性重定向，表示资源已被分配了新的 URL </p>
     * <p> 比如，我们访问 http://www.baidu.com 会跳转到 https://www.baidu.com </p>
     */
    MOVED_PERMANENTLY("301", "Moved Permanently"),
    /**
     * <p> 临时性重定向，表示资源临时被分配了新的 URL, 支持搜索引擎优化 </p>
     * <p> 首页, 个人中心, 遇到了需要登录才能操作的内容, 重定向 到 登录页 </p>
     */
    FOUND("302", "Found"),
    /**
     * <p> 对于POST请求，它表示请求已经被处理，客户端可以接着使用GET方法去请求Location里的URI。 </p>
     */
    SEE_OTHER("303", "See Other"),
    /**
     * <p> 自从上次请求后，请求的网页内容未修改过。 </p>
     * <p> 服务器返回此响应时，不会返回网页内容。(协商缓存) </p>
     */
    NOT_MODIFIED("304", "Not Modified"),
    /**
     * <p> 对于POST请求，表示请求还没有被处理，客户端应该向Location里的URI重新发起POST请求。 </p>
     * <p> 不对请求做额外处理, 正常发送请求, 请求location中的url地址 </p>
     */
    TEMPORARY_REDIRECT("307", "Temporary Redirect"),

    // --------------------4xx--------------------
    /**
     * <p> 请求报⽂存在语法错误(（传参格式不正确） </p>
     */
    BAD_REQUEST("400", "Bad Request"),
    /**
     * <p> 权限认证未通过(没有权限) </p>
     */
    UNAUTHORIZED("401", "UnAuthorized"),
    /**
     * <p> 表示对请求资源的访问被服务器拒绝 </p>
     */
    FORBIDDEN("403", "Forbidden"),
    /**
     * <p> 表示在服务器上没有找到请求的资源 </p>
     */
    NOT_FOUND("404", "Not Found"),
    /**
     * <p> 客户端请求超时 </p>
     */
    REQUEST_TIMEOUT("408", "Request Timeout"),
    /**
     * <p> 请求的资源可能引起冲突 </p>
     */
    CONFLICT("409", "Conflict"),

    // --------------------5xx--------------------
    /**
     * <p> 表示服务器端在执⾏请求时发⽣了错误 </p>
     */
    INTERNAL_SEVER_ERROR("500", "Internal Sever Error"),
    /**
     * <p> 请求超出服务器能⼒范围，例如服务器不⽀持当前请求所需要的某个功能， </p>
     * <p> 或者请求是服务器不⽀持的某个⽅法 </p>
     */
    NOT_IMPLEMENTED("501", "Not Implemented"),
    /**
     * <p> 表明服务器暂时处于超负载或正在停机维护，⽆法处理请求 </p>
     */
    SERVICE_UNAVAILABLE("503", "Service Unavailable"),
    /**
     * <p> 服务器不⽀持，或者拒绝⽀持在请求中使⽤的 HTTP 版本 </p>
     */
    HTTP_VERSION_NOT_SUPPORTED("505", "Http Version Not Supported");

    private String code;
    private String description;

    RequestCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
