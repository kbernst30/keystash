package io.keystash.common.models.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Types that represent mapping of error type to appropriate error messages
 */
public final class ErrorType {

    @AllArgsConstructor
    public enum Authentication implements AbstractError {

        MISSING_CREDENTIALS("missing_credentials", "You must specify email and password."),
        INVALID_CREDENTIALS("invalid_credentials", "Username or password was incorrect. Please double check your credentials."),
        SERVER_ERROR("server_error", "An unknown error occurred"),
        UNKNOWN_ACCOUNT("unknown_account", "No user was found for email %s.");

        @Getter private final String error;
        @Getter private final String message;
    }

    @AllArgsConstructor
    public enum OAuth2 implements AbstractError {
        EXPIRED_ACCESS_TOKEN("invalid_token", "Access token was expired"),
        GRANT_TYPE_NOT_ALLOWED("unauthorized_client", "Client [%s] is not authorized to request authorization of type [%s]"),
        MISSING_CLIENT_ID("invalid_request", "a valid client_id must be provided"),
        MISSING_REDIRECT_URI("invalid_request", "a valid redirect_uri must be provided"),
        NON_ABSOLUTE_REDIRECT_URI("invalid_request", "redirect_uri must be absolute"),
        INVALID_ACCESS_TOKEN("invalid_token", "Access token was missing or otherwise malformed"),
        INVALID_AUTHORIZATION_CODE("invalid_request", "Code [%s] is invalid for client_id [%s]"),
        INVALID_CLIENT("invalid_client", "the client credentials supplied are not valid"),
        INVALID_GRANT("invalid_grant", "The requested grant_type is not supported"),
        INVALID_IMPLICIT_GRANT("invalid_grant", "Implicit grant_type cannot be used in this way"),
        INVALID_PARAMETER("invalid_request", "%s was invalid or otherwise malformed"),
        INVALID_REFRESH_TOKEN("invalid_request", "Refresh token was either invalid or expired"),
        INVALID_SCOPE("invalid_scope", "Requested scope was invalid for client_id [%s]: %s"),
        REDIRECT_URI_HAS_FRAGMENT("invalid_request", "redirect_uri must not contain fragments"),
        SERVER_ERROR("server_error", "An unknown error occurred"),
        UNAUTHORIZED_SCOPE("invalid_scope", "[%s] scope(s) are required to access this resource"),
        UNKNOWN_CLIENT_ID("invalid_request", "No client exists for given client_id: %s"),
        UNKNOWN_REDIRECT_URI("invalid_request", "The requested redirect_uri is not registered for this client."),
        UNKNOWN_USER("invalid_request", "Username and password credentials are invalid."),
        UNSUPPORTED_RESPONSE_TYPE("unsupported_response_type", "response_type must be one of 'code' or 'token'");

        @Getter private final String error;
        @Getter private final String message;
    }

    @AllArgsConstructor
    public enum OpenIdConnect implements AbstractError {

        INVALID_NONE_PROMPT_USAGE("invalid_request_object", "Prompt values cannot contain \"none\" along with other values"),
        INVALID_REQUEST_OBJECT("invalid_request_object", "The request object for OpenID connect was missing or otherwise malformed"),
        LOGIN_REQUIRED("login_required", "Login is required to access this resource."),
        MISSING_REQUIRED_PARAMETER("invalid_request_object", "Parameter [%s] is required for OpenID Connect authentication requests"),
        SERVER_ERROR("server_error", "An unknown error occurred"),
        UNKNOWN_USER_INFO("invalid_request", "UserInfo requested for an unknown user");

        @Getter private final String error;
        @Getter private final String message;
    }

    public interface AbstractError {
        String getError();
        String getMessage();
    }

}
