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


import io.ebean.Ebean;
import org.pmw.tinylog.Logger;
import com.typesafe.config.*;
import com.clivern.ponut.module.service.utils.ConfigService;
import com.clivern.ponut.module.service.utils.LoggerService;
import com.clivern.ponut.module.service.database.DatabaseService;
import com.clivern.ponut.module.service.database.MigrationService;

import com.clivern.ponut.module.service.database.SeederService;


import com.clivern.ponut.database.migration.OptionTable;
import com.clivern.ponut.database.migration.BotTable;
import com.clivern.ponut.database.migration.BotMetaTable;
import com.clivern.ponut.database.migration.MigrationTable;

import com.clivern.ponut.database.seed.OptionSeeder;


public class App {

    public static void main(String[] args)
    {
        if( args.length > 0 ){
            Mapper.call(args);
        }else{
            new App().config();
            new App().ebeanTest();
            Web.call();
            Api.call();
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

    /**
     * Migrations and Seeds Test
     */
    public void ebeanTest()
    {
        MigrationService migrationService = new MigrationService(DatabaseService.instance());
        migrationService.setMigration(new OptionTable());
        migrationService.setMigration(new BotMetaTable());
        migrationService.setMigration(new BotTable());
        migrationService.setMigration(new MigrationTable());
        migrationService.runMigrations("down");
        migrationService.runMigrations("up");


        SeederService seederService = new SeederService(DatabaseService.instance());
        seederService.setSeeder(new OptionSeeder());
        seederService.runSeeders("up");
        seederService.runSeeders("down");
        seederService.runSeeder("01-up_insert_into_options_table", "up");
        seederService.runSeeder("01-down_insert_into_options_table", "down");
        seederService.runSeeder("01-up_insert_into_options_table", "up");
    }
}