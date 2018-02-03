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

import com.clivern.ponut.route.Web;
import com.clivern.ponut.route.Api;
import com.clivern.ponut.controller.console.Mapper;
import com.clivern.ponut.model.Option;

import org.pmw.tinylog.*;
import org.pmw.tinylog.Logger;
import org.pmw.tinylog.writers.*;
import com.typesafe.config.*;
import com.clivern.ponut.module.service.utils.ConfigService;
import com.clivern.ponut.module.service.utils.LoggerService;
import com.clivern.ponut.module.service.database.DatabaseService;

import io.ebean.Ebean;
import io.ebean.CallableSql;
import io.ebean.RawSql;
import io.ebean.RawSqlBuilder;

public class App {

    public static void main(String[] args)
    {
        if( args.length > 0 ){
            Mapper.call(args);
        }else{

            (new App()).testLogger();
            new App().ebeanTest();
            Web.call();
            Api.call();
        }
    }

    public void testLogger()
    {
        Config config = ConfigService.instance().load();
        new LoggerService(config).config();
        Logger.info(config.getString("database.username"));
    }

    public void ebeanTest()
    {
        new DatabaseService(ConfigService.instance().load()).config();

        String sql1 = "DROP TABLE IF EXISTS options;";
        CallableSql cs1 = Ebean.createCallableSql(sql1);
        Ebean.execute(cs1);

        String sql2 = "CREATE TABLE IF NOT EXISTS options (`id` int NOT NULL AUTO_INCREMENT,`key` varchar(60) NOT NULL,`value` text NOT NULL,`autoload` varchar(5) NOT NULL,PRIMARY KEY (`id`),KEY `key` (`key`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";
        CallableSql cs2 = Ebean.createCallableSql(sql2);
        Ebean.execute(cs2);

        Option option = new Option("Key1", "Value1", "On1");
        option.save();
    }
}