package com.virtusa.isq.vtaf.recovery;

import java.util.ArrayList;
import java.util.Timer;

/**
 * The Class RecoveryTimer.
 */
public class RecoveryTimer extends Timer {

    /** The recovery methods. */
    private ArrayList<String> recoveryMethods = null;

    /**
     * Clean recovery methods.
     */
    public final void cleanRecoveryMethods() {
        recoveryMethods = new ArrayList<String>();
    }

    /**
     * Adds the recovery methods.
     * 
     * @param methodName
     *            the method name
     */
    public final void addRecoveryMethods(final String methodName) {

        if (recoveryMethods == null) {
            recoveryMethods = new ArrayList<String>();
        }
        recoveryMethods.add(methodName);
    }
}
