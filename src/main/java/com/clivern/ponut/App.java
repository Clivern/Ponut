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
package com.clivern.ponut;

import org.pmw.tinylog.Logger;
import com.typesafe.config.Config;
import com.clivern.ponut.route.Web;
import com.clivern.ponut.route.Api;
import com.clivern.ponut.controller.console.Mapper;
import com.clivern.ponut.module.service.utils.ConfigService;
import com.clivern.ponut.module.service.utils.LoggerService;
import com.clivern.ponut.module.service.database.DatabaseService;


import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import com.clivern.ponut.module.service.core.entity.OptionEntity;
import com.clivern.ponut.model.OptionModel;

import com.clivern.ponut.module.service.utils.SlugService;

/**
 * App Class
 *
 * @since 1.0.0
 */
public class App {

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args)
    {
        new App().config();
        if( args.length > 0 ){
            Mapper.call(args);
        }else{
            Web.call();
            Api.call();
            new App().testEntity();
        }
    }

    /**
     * Config All Services
     */
    public void config()
    {
        Config config = ConfigService.instance().load();
        new LoggerService(config).config();
        DatabaseService.instance().config(config);
    }

    public void testEntity()
    {
        Logger.info(SlugService.makeSlug("Slack"));
        Logger.info(SlugService.makeSlug("MeSSenger"));
        Logger.info(SlugService.makeSlug("Slack Bot"));
        Logger.info(SlugService.makeSlug("Messenger éphémère"));
    }
}