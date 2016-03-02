/*
 * Copyright 2004 ThoughtWorks, Inc. Licensed under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.virtusa.isq.vtaf.aspects;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Timer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.openqa.selenium.WebDriverException;

import com.virtusa.isq.vtaf.recovery.RecoveryThreadTask;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;

/**
 * The Class AspectClass.
 */
@Aspect
public class AspectClass {

    /** The threshold timeout. */
    static final int TIMEOUT = 120000;

    /** The threshold timeout. */
    private long thresholdTimeout = TIMEOUT;

    /** The recovery. */
    private RecoveryThreadTask recovery;

    /** The timer. */
    private Timer timer = new Timer();

    /** The caller. */
    private SeleniumTestBase caller;

    /** The recovery method names. */
    private String[] recoveryMethodNames;

    /** The onerror method names. */
    private String[] onerrorMethodNames;

    /**
     * Inits the recovery thread click.
     * 
     * @param joinPoint
     *            the join point
     */
    @Around("call(void org.openqa.selenium.WebElement.click()) && (withincode(void SeleniumTestBase.doClick(..)))")
    public final void initRecoveryThreadClick(
            final ProceedingJoinPoint joinPoint) {
        advice(joinPoint);
    }

    /**
     * Inits the recovery thread type.
     * 
     * @param joinPoint
     *            the join point
     */
    @Around("call(void org.openqa.selenium.WebElement.sendKeys(..)) && (withincode(void SeleniumTestBase.doType(..)))")
    public final void initRecoveryThreadType(final ProceedingJoinPoint joinPoint) {
        advice(joinPoint);
    }

    /**
     * Inits the recovery thread open.
     * 
     * @param joinPoint
     *            the join point
     */
    @Around("call(void org.openqa.selenium.WebDriver.get(String)) && (withincode(void SeleniumTestBase.doOpen(..)))")
    public final void initRecoveryThreadOpen(final ProceedingJoinPoint joinPoint) {
        advice(joinPoint);
    }

    /**
     * Inits the recovery thread click at.
     * 
     * @param joinPoint
     *            the join point
     */
    @Around("call(void org.openqa.selenium.interactions.Action.perform()) && "
            + "(withincode(void SeleniumTestBase.doClickAt(..)))")
    public final void initRecoveryThreadClickAt(
            final ProceedingJoinPoint joinPoint) {
        advice(joinPoint);
    }

    /**
     * Inits the recovery thread double click.
     * 
     * @param joinPoint
     *            the join point
     */
    @Around("call(void org.openqa.selenium.interactions.Action.perform()) && "
            + "(withincode(void SeleniumTestBase.doDoubleClick(..)))")
    public final void initRecoveryThreadDoubleClick(
            final ProceedingJoinPoint joinPoint) {
        advice(joinPoint);
    }

    /**
     * Inits the recovery thread double click at.
     * 
     * @param joinPoint
     *            the join point
     */
    @Around("call(void org.openqa.selenium.interactions.Action.perform()) && "
            + "(withincode(void SeleniumTestBase.doDoubleClickAt(..)))")
    public final void initRecoveryThreadDoubleClickAt(
            final ProceedingJoinPoint joinPoint) {
        advice(joinPoint);
    }

    /**
     * Advice the joinpoint.
     * 
     * @param joinPoint
     *            the join point
     */
    public final void advice(final ProceedingJoinPoint joinPoint) {

        caller = (SeleniumTestBase) joinPoint.getThis();
        try {
            initiateRecoveryThread(caller, onerrorMethodNames);
            joinPoint.proceed();
            cancelRecoveryThread();
        } catch (WebDriverException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the recovery method names.
     * 
     * @param joinPoint
     *            the join point
     * 
     */
    @Before("@annotation(org.testng.annotations.Test)")
    public final void getRecoveryMethodNames(final JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method m = ms.getMethod();
        VTAFRecoveryMethods recoveryAnnot =
                m.getAnnotation(VTAFRecoveryMethods.class);
        if (recoveryAnnot != null) {
            recoveryMethodNames = recoveryAnnot.recoveryMethods();
            onerrorMethodNames = recoveryAnnot.onerrorMethods();
            System.out.println(Arrays.asList(recoveryMethodNames));
        }
    }

    /**
     * Check tc failed.
     * 
     * @param isTcfailed
     *            the is tcfailed
     */
    @AfterReturning(pointcut = "execution(* *.getTestCaseFailedStatus(..))", returning = "isTcfailed")
    public final void checkTCFailed(final boolean isTcfailed) {

        if (isTcfailed) {
            RecoveryThreadTask recoveryTask =
                    new RecoveryThreadTask(caller, recoveryMethodNames);
            recoveryTask.run();
            recoveryTask.cancel();
        }
    }

    /**
     * Initiate recovery thread.
     * 
     * @param callers
     *            the caller
     * @param recoveryMethodName
     *            the recovery method names
     */
    private void initiateRecoveryThread(final SeleniumTestBase callers,
            final String[] recoveryMethodName) {
        recovery = new RecoveryThreadTask(callers, recoveryMethodName);
        timer.schedule(recovery, thresholdTimeout);
    }

    /**
     * Cancel recovery thread.
     */
    private void cancelRecoveryThread() {
        recovery.cancel();
    }
}
