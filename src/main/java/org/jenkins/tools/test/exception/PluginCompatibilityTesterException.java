package org.jenkins.tools.test.exception;

public class PluginCompatibilityTesterException extends Exception {

    public PluginCompatibilityTesterException(String message) {
        super(message);
    }

    public PluginCompatibilityTesterException(String message, Throwable cause) {
        super(message, cause);
    }

    public PluginCompatibilityTesterException(Throwable cause) {
        super(cause);
    }
}
