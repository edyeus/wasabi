package com.intuit.wasabi.util;

import org.slf4j.Logger;

public class LogUtil {
    public static void trace(Logger logger, String str, Object... args){
        int i=0;

        while(str.contains("{}") && args.length>=i){
            str = str.replaceFirst("\\{\\}", args[i].toString());
            i++;
        }

        if (args.length>i && args[i] instanceof Exception) logger.trace(str, args[i]);
        else logger.trace(str);
    }

    public static void debug(Logger logger, String str, Object... args){
        int i=0;

        while(str.contains("{}") && args.length>=i){
            str = str.replaceFirst("\\{\\}", args[i].toString());
            i++;
        }

        if (args.length>i && args[i] instanceof Exception) logger.debug(str, args[i]);
        else logger.debug(str);
    }

    public static void info(Logger logger, String str, Object... args){
        int i=0;

        while(str.contains("{}") && args.length>=i){
            str = str.replaceFirst("\\{\\}", args[i].toString());
            i++;
        }

        if (args.length>i && args[i] instanceof Exception) logger.info(str, args[i]);
        else logger.info(str);
    }

    public static void warn(Logger logger, String str, Object... args){
        int i=0;

        while(str.contains("{}") && args.length>=i){
            str = str.replaceFirst("\\{\\}", args[i].toString());
            i++;
        }

        if (args.length>i && args[i] instanceof Exception) logger.warn(str, args[i]);
        else logger.warn(str);
    }

    public static void error(Logger logger, String str, Object... args){
        int i=0;

        while(str.contains("{}") && args.length>=i){
            str = str.replaceFirst("\\{\\}", args[i].toString());
            i++;
        }

        if (args.length>i && args[i] instanceof Exception) logger.error(str, args[i]);
        else logger.error(str);
    }
}
