/*
 * Copyright (C) 2018 Clivern <http://clivern.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.clivern.ponut.module.service.utils;

import java.util.HashMap;
import java.util.Map;
import org.pmw.tinylog.*;
import org.pmw.tinylog.Logger;
import org.pmw.tinylog.writers.*;
import com.typesafe.config.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.clivern.ponut.module.contract.utils.LoggerContract;

/**
 * Logger Service
 *
 * @since 1.0.0
 */
public class LoggerService implements LoggerContract {

    protected Config config;

    protected String logLevel = "info"; // TRACE < DEBUG < INFO < WARNING < ERROR

    protected String logFilePath = "storage/logs/";

    protected String logFileFormat = "app"; // filename or current_date (shows date.log)

    protected String logType = "file"; //file or console

    protected String currentDateFormat = "yyyy-MM-dd";

    protected Map<String, Level> logLevels = new HashMap<String, Level>();


    /**
     * Class Constructor
     *
     * @param  config
     */
    public LoggerService(Config config)
    {
        this.config = config;
    }

    /**
     * Config Logger
     */
    public void config()
    {
        this.logLevel = this.config.getString("logging.level");
        this.logFilePath = this.config.getString("logging.file_path");
        this.logFileFormat = this.config.getString("logging.file_format");
        this.logType = this.config.getString("logging.log_type");
        this.currentDateFormat = this.config.getString("logging.current_date_format");
        this.logLevels.put("trace", Level.TRACE);
        this.logLevels.put("debug", Level.DEBUG);
        this.logLevels.put("info", Level.INFO);
        this.logLevels.put("warning", Level.WARNING);
        this.logLevels.put("error", Level.ERROR);

        if( this.logType.equals("file") ){
            DateFormat dateFormat = new SimpleDateFormat(this.currentDateFormat);
            Date date = new Date();
            String logFileName = (this.logFileFormat.equals("current_date")) ? dateFormat.format(date) + ".log" : this.logFileFormat + ".log";
            Configurator.defaultConfig()
                .writer(new FileWriter(this.logFilePath + logFileName))
                .level((this.logLevels.containsKey(this.logLevel)) ? this.logLevels.get(this.logLevel) : Level.INFO)
                .activate();
        }
    }
}