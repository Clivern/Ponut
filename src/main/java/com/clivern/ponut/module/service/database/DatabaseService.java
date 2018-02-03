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
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import org.avaje.datasource.DataSourceConfig;
import io.ebean.config.ServerConfig;
import com.clivern.ponut.module.contract.database.DatabaseContract;

/**
 * Database Service
 *
 * @since 1.0.0
 */
public class DatabaseService implements DatabaseContract {

    protected Config config;

    /**
     * Class Constructor
     *
     * @param  config
     */
    public DatabaseService(Config config)
    {
        this.config = config;
    }

    /**
     * Configure The Database
     */
    public void config()
    {
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
    }

    /**
     * Connect To Database
     *
     * @return Boolean
     */
    public Boolean connect()
    {
        return true;
    }

    /**
     * Check Database Status
     *
     * @return Boolean
     */
    public Boolean healthCheck()
    {
        return true;
    }
}