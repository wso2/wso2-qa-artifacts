package com.virtusa.isq.vtaf.recovery;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.thoughtworks.selenium.SeleneseTestBaseVir;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;

/**
 * The Class RecoveryThreadTask.
 */
public class RecoveryThreadTask extends TimerTask {

    /** The caller. */
    private SeleniumTestBase caller;

    /** The recovery method names. */
    private String[] recoveryMethodNames;

    /**
     * Sets the recovery method names.
     * 
     * @param name
     *            the new recovery method names
     */
    private void setrecoveryMethodNames(final String[] name) {
        recoveryMethodNames = name;
    }

    /**
     * Instantiates a new recovery thread task.
     * 
     * @param scriptCaller
     *            the script caller
     * @param recoveryMethodName
     *            the recovery method names
     */
    public RecoveryThreadTask(final SeleniumTestBase scriptCaller,
            final String[] recoveryMethodName) {
        caller = scriptCaller;

        setrecoveryMethodNames(recoveryMethodName);
    }

    /**
     * Run.
     * 
     * @see java.util.TimerTask#run()
     */
    @Override
    public final void run() {

        if (recoveryMethodNames != null && recoveryMethodNames.length > 0) {
            Logger log = SeleneseTestBaseVir.getLog();
            System.out.println("Executing test recovery scenarios : "
                    + Arrays.asList(recoveryMethodNames));
            for (String methodFullName : recoveryMethodNames) {

                int lastIndx = methodFullName.lastIndexOf('.');

                String className = methodFullName.substring(0, lastIndx);
                String methodName =
                        methodFullName.substring(lastIndx + 1,
                                methodFullName.length());
                try {
                    Class< ? > clz = Class.forName(className);
                    Method method =
                            clz.getDeclaredMethod(methodName,
                                    SeleniumTestBase.class);
                    method.invoke(clz, caller);
                } catch (ClassNotFoundException e) {
                    log.error(e);
                } catch (NoSuchMethodException e) {
                    log.error(e);
                } catch (SecurityException e) {
                    log.error(e);
                } catch (IllegalAccessException e) {
                    log.error(e);
                } catch (IllegalArgumentException e) {
                    log.error(e);
                } catch (InvocationTargetException e) {
                    log.error(e);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }

    }

}
