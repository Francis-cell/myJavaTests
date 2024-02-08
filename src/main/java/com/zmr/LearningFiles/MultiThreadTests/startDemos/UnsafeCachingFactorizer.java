package com.zmr.LearningFiles.MultiThreadTests.startDemos;

import javax.annotation.concurrent.NotThreadSafe;
import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {

    private final AtomicReference<BigInteger> lastNumber =
            new AtomicReference<BigInteger>();

    private final AtomicReference<BigInteger[]> lastFactors =
            new AtomicReference<BigInteger[]>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            // encodeIntoResponse()
        }
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("1");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
