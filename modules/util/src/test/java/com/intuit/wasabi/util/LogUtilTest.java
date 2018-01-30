package com.intuit.wasabi.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.Marker;

import static com.intuit.wasabi.util.LogUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class LogUtilTest {

    @Test
    public void debugTest() throws Exception {
        TestLogger logger = new TestLogger();
        String msg = "application={}, user={}, profile={}, error=";
        String application = "App";
        String user = "User";
        String profile = "profile";
        Exception e = new Exception("Exception");

        debug(logger, msg, application, user, profile, e);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertThat(logger.e, is(e));

        logger = new TestLogger();

        debug(logger, msg, application, user, profile);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertNull(logger.e);
    }

    @Test
    public void debugArgOverflowTest() throws Exception {
        TestLogger logger = new TestLogger();
        String msg = "application={}, user={}, profile={}, error=";
        String application = "App";
        String user = "User";
        String profile = "profile";
        String overflow = "overflow";
        Exception e = new Exception("Exception");

        debug(logger, msg, application, user, profile, overflow, e);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertNull(logger.e);

        logger = new TestLogger();
        debug(logger, msg, application, user, profile, e, overflow);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertThat(logger.e, is(e));
    }

    @Test
    public void debugBracketOverflowTest() throws Exception {
        TestLogger logger = new TestLogger();
        String msg = "application={}, user={}, profile={}, error=";
        String application = "App";
        String user = "User";
        Exception e = new Exception("Exception");

        debug(logger, msg, application, user, e);

        assertThat(logger.msg, is("application=App, user=User, profile="+e.toString()+", error="));
        assertNull(logger.e);
    }

    @Test
    public void infoTest() throws Exception {
        TestLogger logger = new TestLogger();
        String msg = "application={}, user={}, profile={}, error=";
        String application = "App";
        String user = "User";
        String profile = "profile";
        Exception e = new Exception("Exception");

        info(logger, msg, application, user, profile, e);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertThat(logger.e, is(e));

        logger = new TestLogger();

        info(logger, msg, application, user, profile);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertNull(logger.e);
    }

    @Test
    public void warnTest() throws Exception {
        TestLogger logger = new TestLogger();
        String msg = "application={}, user={}, profile={}, error=";
        String application = "App";
        String user = "User";
        String profile = "profile";
        Exception e = new Exception("Exception");

        warn(logger, msg, application, user, profile, e);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertThat(logger.e, is(e));

        logger = new TestLogger();

        warn(logger, msg, application, user, profile);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertNull(logger.e);
    }

    @Test
    public void errorTest() throws Exception {
        TestLogger logger = new TestLogger();
        String msg = "application={}, user={}, profile={}, error=";
        String application = "App";
        String user = "User";
        String profile = "profile";
        Exception e = new Exception("Exception");

        error(logger, msg, application, user, profile, e);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertThat(logger.e, is(e));

        logger = new TestLogger();

        error(logger, msg, application, user, profile);

        assertThat(logger.msg, is("application=App, user=User, profile=profile, error="));
        assertNull(logger.e);
    }

    class TestLogger implements Logger {
        String msg;
        Exception e;

        public String getMsg(){
            return msg;
        }

        public Exception getE(){
            return e;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean isTraceEnabled() {
            return false;
        }

        @Override
        public void trace(String s) {

        }

        @Override
        public void trace(String s, Object o) {

        }

        @Override
        public void trace(String s, Object o, Object o1) {

        }

        @Override
        public void trace(String s, Object[] objects) {

        }

        @Override
        public void trace(String s, Throwable throwable) {

        }

        @Override
        public boolean isTraceEnabled(Marker marker) {
            return false;
        }

        @Override
        public void trace(Marker marker, String s) {

        }

        @Override
        public void trace(Marker marker, String s, Object o) {

        }

        @Override
        public void trace(Marker marker, String s, Object o, Object o1) {

        }

        @Override
        public void trace(Marker marker, String s, Object[] objects) {

        }

        @Override
        public void trace(Marker marker, String s, Throwable throwable) {

        }

        @Override
        public boolean isDebugEnabled() {
            return false;
        }

        @Override
        public void debug(String s) {
            msg = s;
        }

        @Override
        public void debug(String s, Object o) {
            msg = s;
            e = (Exception) o;
        }

        @Override
        public void debug(String s, Object o, Object o1) {

        }

        @Override
        public void debug(String s, Object[] objects) {

        }

        @Override
        public void debug(String s, Throwable throwable) {
            msg = s;
            e = (Exception) throwable;
        }

        @Override
        public boolean isDebugEnabled(Marker marker) {
            return false;
        }

        @Override
        public void debug(Marker marker, String s) {

        }

        @Override
        public void debug(Marker marker, String s, Object o) {

        }

        @Override
        public void debug(Marker marker, String s, Object o, Object o1) {

        }

        @Override
        public void debug(Marker marker, String s, Object[] objects) {

        }

        @Override
        public void debug(Marker marker, String s, Throwable throwable) {

        }

        @Override
        public boolean isInfoEnabled() {
            return false;
        }

        @Override
        public void info(String s) {
            msg = s;
        }

        @Override
        public void info(String s, Object o) {
            msg = s;
            e = (Exception) o;
        }

        @Override
        public void info(String s, Object o, Object o1) {

        }

        @Override
        public void info(String s, Object[] objects) {

        }

        @Override
        public void info(String s, Throwable throwable) {
            msg = s;
            e = (Exception) throwable;
        }

        @Override
        public boolean isInfoEnabled(Marker marker) {
            return false;
        }

        @Override
        public void info(Marker marker, String s) {

        }

        @Override
        public void info(Marker marker, String s, Object o) {

        }

        @Override
        public void info(Marker marker, String s, Object o, Object o1) {

        }

        @Override
        public void info(Marker marker, String s, Object[] objects) {

        }

        @Override
        public void info(Marker marker, String s, Throwable throwable) {

        }

        @Override
        public boolean isWarnEnabled() {
            return false;
        }

        @Override
        public void warn(String s) {
            msg = s;
        }

        @Override
        public void warn(String s, Object o) {
            msg = s;
            e = (Exception) o;
        }

        @Override
        public void warn(String s, Object[] objects) {

        }

        @Override
        public void warn(String s, Object o, Object o1) {

        }

        @Override
        public void warn(String s, Throwable throwable) {
            msg = s;
            e = (Exception) throwable;
        }

        @Override
        public boolean isWarnEnabled(Marker marker) {
            return false;
        }

        @Override
        public void warn(Marker marker, String s) {

        }

        @Override
        public void warn(Marker marker, String s, Object o) {

        }

        @Override
        public void warn(Marker marker, String s, Object o, Object o1) {

        }

        @Override
        public void warn(Marker marker, String s, Object[] objects) {

        }

        @Override
        public void warn(Marker marker, String s, Throwable throwable) {

        }

        @Override
        public boolean isErrorEnabled() {
            return false;
        }

        @Override
        public void error(String s) {
            msg = s;
        }

        @Override
        public void error(String s, Object o) {
            msg = s;
            e = (Exception) o;
        }

        @Override
        public void error(String s, Object o, Object o1) {

        }

        @Override
        public void error(String s, Object[] objects) {

        }

        @Override
        public void error(String s, Throwable throwable) {
            msg = s;
            e = (Exception) throwable;
        }

        @Override
        public boolean isErrorEnabled(Marker marker) {
            return false;
        }

        @Override
        public void error(Marker marker, String s) {

        }

        @Override
        public void error(Marker marker, String s, Object o) {

        }

        @Override
        public void error(Marker marker, String s, Object o, Object o1) {

        }

        @Override
        public void error(Marker marker, String s, Object[] objects) {

        }

        @Override
        public void error(Marker marker, String s, Throwable throwable) {

        }
    }
}
