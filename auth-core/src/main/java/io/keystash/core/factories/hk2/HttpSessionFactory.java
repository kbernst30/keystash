package io.keystash.core.factories.hk2;

import org.glassfish.hk2.api.Factory;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpSessionFactory implements Factory<HttpSession> {

    private final HttpServletRequest request;

    @Inject
    public HttpSessionFactory(Provider<HttpServletRequest> requestProvider) {
        this.request = requestProvider.get();
    }

    @Override
    public HttpSession provide() {
        return request.getSession();
    }

    @Override
    public void dispose(HttpSession httpSession) {}
}
