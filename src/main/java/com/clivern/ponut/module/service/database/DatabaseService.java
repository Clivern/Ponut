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
package com.clivern.ponut.module.service.database;

import com.typesafe.config.*;
import io.ebean.Ebean;
import io.ebean.CallableSql;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.pmw.tinylog.Logger;
import org.avaje.datasource.DataSourceConfig;
import com.clivern.ponut.module.contract.database.DatabaseContract;

/**
 * Database Service
 *
 * @since 1.0.0
 */
public class DatabaseService implements DatabaseContract {

    protected Config config;

    private static DatabaseService instance;

    protected Boolean isDbConnected;

    /**
     * Class Constructor
     */
    protected DatabaseService()
    {
        // Exists only to defeat instantiation.
    }

    /**
     * Get Instance or A new one
     *
     * @return DatabaseService
     */
    public static DatabaseService instance()
    {
        if(instance == null) {
            instance = new DatabaseService();
        }

        return instance;
    }

    /**
     * Configure The Database
     *
     * @param config
     */
    public void config(Config config)
    {
        try {
            this.config = config;
            ServerConfig serverConfig = new ServerConfig();
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setDriver(this.config.getString("database.driver"));
            dataSourceConfig.setUsername(this.config.getString("database.username"));
            dataSourceConfig.setPassword(this.config.getString("database.password"));
            dataSourceConfig.setUrl(this.config.getString("database.url"));
            serverConfig.setName(this.config.getString("database.name"));
            serverConfig.setDataSourceConfig(dataSourceConfig);
            serverConfig.setDdlGenerate(false);
            serverConfig.setDdlRun(false);
            EbeanServer server = EbeanServerFactory.create(serverConfig);
            this.isDbConnected = true;
            Logger.info("Database Connection Established [ " + this.config.getString("database.url") + " ]");
        }catch ( Exception e) {
            this.isDbConnected = false;
            Logger.error("Error Connecting Database [ " + this.config.getString("database.url") + " ]. Reason [ " + e.getMessage() + " ]");
        }
    }

    /**
     * Execute Custom SQL Query
     *
     * @param  sql
     * @return Boolean
     */
    public Boolean execute(String sql)
    {
        if( !this.isDbConnected ){
            return false;
        }

        try {
            CallableSql callableSQL = Ebean.createCallableSql(sql);
            Ebean.execute(callableSQL);
        }catch ( Exception e) {
            Logger.error("Error While Running Database Query. Reason [ " + e.getMessage() + " ]");
        }
        return true;
    }

    /**
     * Execute Custom SQL Query
     *
     * @param  sql
     * @return Boolean
     */
    public Boolean execute(CallableSql sql)
    {
        if( !this.isDbConnected ){
            return false;
        }

        try {
            Ebean.execute(sql);
        }catch ( Exception e) {
            Logger.error("Error While Running Database Query. Reason [ " + e.getMessage() + " ]");
        }
        return true;
    }

    /**
     * Check if DB Connected
     *
     * @return Boolean
     */
    public Boolean isConnected()
    {
        return this.isDbConnected;
    }
}