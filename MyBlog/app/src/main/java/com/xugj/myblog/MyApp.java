package com.xugj.myblog;

import android.app.Application;

import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.mindpipe.android.logging.log4j.LogConfigurator;


/**
 * Created by xugj on 2018/03/12.
 */


public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        configLog();
        Logger log = LoggerFactory.getLogger(MyApp.class);
        log.info("My Application Created");

    }

    private void configLog() {
        LogConfigurator logConfigurator = new LogConfigurator();

        logConfigurator.setUseLogCatAppender(true);
        logConfigurator.setUseFileAppender(false);
        logConfigurator.setLogCatPattern("%d{yyyy-MM-dd HH:mm:ss} [%p] %m%n");
        logConfigurator.setRootLevel(Level.DEBUG);
        logConfigurator.setLevel("org.apache", Level.ERROR);

        logConfigurator.setImmediateFlush(true);
        logConfigurator.configure();
    }
}
