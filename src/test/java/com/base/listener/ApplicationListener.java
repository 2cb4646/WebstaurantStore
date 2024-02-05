package com.base.listener;

import com.base.decorator.ChromeDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class ApplicationListener implements ISuiteListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);


    SimpleDateFormat format = new SimpleDateFormat("HH::mm::ss");

    Date date, date1;

    @Override
    public void onStart(ISuite suite){
        date = new Date(System.currentTimeMillis());
    }

    @Override
    public void onFinish(ISuite suite){
        date1 = new Date(System.currentTimeMillis());

        long diff  =date1.getTime() - date.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        LOGGER.info("------------------------------------------------------------------\n");
        LOGGER.info("Total Runtime:      " + diffMinutes + " minutes  " + diffSeconds + " seconds");

    }

}
