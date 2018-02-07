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
package com.clivern.ponut.controller.console;

import com.clivern.ponut.module.service.database.MigrationService;
import com.clivern.ponut.module.service.database.DatabaseService;
import com.clivern.ponut.database.migration.*;

/**
 * Migrate Command
 *
 * @since 1.0.0
 */
public class Migrate {

    private String data;

    /**
     * Class Constructor
     *
     * @param  data
     */
    public Migrate(String data)
    {
        this.data = data;
    }

    /**
     * Run Migrate Command According To Data Parameter
     */
    public void run()
    {
        if( this.data.equals("up") ){

            MigrationService migrationService = new MigrationService(DatabaseService.instance());
            migrationService.setMigration(new OptionTable());
            migrationService.setMigration(new BotMetaTable());
            migrationService.setMigration(new BotTable());
            migrationService.setMigration(new MigrationTable());
            migrationService.runMigrations("up");

        }else if( this.data.equals("down") ){

            MigrationService migrationService = new MigrationService(DatabaseService.instance());
            migrationService.setMigration(new OptionTable());
            migrationService.setMigration(new BotMetaTable());
            migrationService.setMigration(new BotTable());
            migrationService.setMigration(new MigrationTable());
            migrationService.runMigrations("down");

        }else if( this.data.contains("up") ){

            MigrationService migrationService = new MigrationService(DatabaseService.instance());
            migrationService.setMigration(new OptionTable());
            migrationService.setMigration(new BotMetaTable());
            migrationService.setMigration(new BotTable());
            migrationService.setMigration(new MigrationTable());
            migrationService.runMigration(this.data, "up");

        }else if( this.data.contains("down") ){

            MigrationService migrationService = new MigrationService(DatabaseService.instance());
            migrationService.setMigration(new OptionTable());
            migrationService.setMigration(new BotMetaTable());
            migrationService.setMigration(new BotTable());
            migrationService.setMigration(new MigrationTable());
            migrationService.runMigration(this.data, "down");

        }
    }

    /**
     * Command Help Info
     */
    public static void help()
    {
        System.out.println("Help Here....");
    }
}