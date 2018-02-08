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

import com.clivern.ponut.database.migration.*;
import com.clivern.ponut.module.service.utils.ColorsService;
import com.clivern.ponut.module.service.database.MigrationService;
import com.clivern.ponut.module.service.database.DatabaseService;

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

            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Migrations.." + ColorsService.ANSI_PURPLE);
            MigrationService migrationService = new MigrationService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register OptionTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new OptionTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMetaTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotMetaTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register MigrationTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new MigrationTable());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running Up Migrations.." + ColorsService.ANSI_PURPLE);
            Boolean status = migrationService.runMigrations("up");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + "Up Migrations Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running Up Migrations! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
            }

        }else if( this.data.equals("down") ){

            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Migrations.." + ColorsService.ANSI_PURPLE);
            MigrationService migrationService = new MigrationService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register OptionTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new OptionTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMetaTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotMetaTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register MigrationTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new MigrationTable());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running Down Migrations.." + ColorsService.ANSI_PURPLE);
            Boolean status = migrationService.runMigrations("down");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + "Down Migrations Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running Down Migrations! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
            }

        }else if( this.data.contains("up") ){

            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Migrations.." + ColorsService.ANSI_PURPLE);
            MigrationService migrationService = new MigrationService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register OptionTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new OptionTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMetaTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotMetaTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register MigrationTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new MigrationTable());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running " + this.data + " Migration.." + ColorsService.ANSI_PURPLE);
            Boolean status = migrationService.runMigration(this.data, "up");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + this.data + " Migration Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running " + this.data + " Migration! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
            }

        }else if( this.data.contains("down") ){

            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Migrations.." + ColorsService.ANSI_PURPLE);
            MigrationService migrationService = new MigrationService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register OptionTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new OptionTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMetaTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotMetaTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new BotTable());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register MigrationTable Migrations" + ColorsService.ANSI_PURPLE);
            migrationService.setMigration(new MigrationTable());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running " + this.data + " Migration.." + ColorsService.ANSI_PURPLE);
            Boolean status = migrationService.runMigration(this.data, "down");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + this.data + " Migration Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running " + this.data + " Migration! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
            }
        }
    }

    /**
     * Get Command Help Info
     */
    public static void help()
    {
        System.out.println("Help Here....");
    }
}