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

import com.typesafe.config.*;
import java.io.File;
import com.clivern.ponut.module.contract.utils.ConfigContract;

/**
 * Config Service
 *
 * @since 1.0.0
 */
public class ConfigService implements ConfigContract {

    protected Config config;

    protected String configFile = "config/app.conf";

    private static ConfigService instance;


    protected ConfigService()
    {
        // Exists only to defeat instantiation.
    }

    /**
     * Get Instance or A new one
     *
     * @return ConfigService
     */
    public static ConfigService instance()
    {
        if(instance == null) {
            instance = new ConfigService();
        }

        return instance;
    }

    /**
     * Load Configs
     */
    public Config load()
    {
        if( this.config == null ){
            this.config = ConfigFactory.load(ConfigFactory.parseFile(new File(this.configFile)));
        }

        return this.config;
    }
}