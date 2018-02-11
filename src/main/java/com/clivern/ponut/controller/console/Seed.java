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

import org.pmw.tinylog.Logger;
import com.clivern.ponut.database.seed.*;
import com.clivern.ponut.module.service.utils.ColorsService;
import com.clivern.ponut.module.service.database.SeederService;
import com.clivern.ponut.module.service.database.DatabaseService;

/**
 * Seed Command
 *
 * @since 1.0.0
 */
public class Seed {

    private String data;

    /**
     * Class Constructor
     *
     * @param  data
     */
    public Seed(String data)
    {
        this.data = data;
    }

    /**
     * Run Seed Command According To Data Parameter
     */
    public void run()
    {
        if( this.data.equals("up") ){

            Logger.info("Start Registering Seeds..");
            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_RESET);
            SeederService seederService = new SeederService(DatabaseService.instance());

            Logger.info("Register Option Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new OptionSeeder());

            Logger.info("Register Migration Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new MigrationSeeder());

            Logger.info("Register Bot Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotSeeder());

            Logger.info("Register BotMeta Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotMetaSeeder());

            Logger.info("Start Running Up Seeds..");
            System.out.println(ColorsService.ANSI_PURPLE + "Start Running Up Seeds.." + ColorsService.ANSI_RESET);

            try {
                Boolean status = seederService.runSeeders("up");
                if( status ){
                    Logger.info("Up Seeds Completed Successfully!");
                    System.out.println("\n" + ColorsService.ANSI_GREEN + "Up Seeds Completed Successfully!" + ColorsService.ANSI_RESET);
                }else{
                    Logger.error("Something Goes Wrong While Running Up Seeds! Check The Logs For Further Informations.");
                    System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running Up Seeds! Check The Logs For Further Informations." + ColorsService.ANSI_RESET);
                }
            }catch ( Exception e) {
                Logger.error("Error While Running Command [ $.. seed " + this.data + " ]. Reason [ " + e.getMessage() + " ]");
            }

        }else if( this.data.equals("down") ){

            Logger.info("Start Registering Seeds..");
            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_RESET);
            SeederService seederService = new SeederService(DatabaseService.instance());

            Logger.info("Register Option Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new OptionSeeder());

            Logger.info("Register Migration Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new MigrationSeeder());

            Logger.info("Register Bot Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotSeeder());

            Logger.info("Register BotMeta Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotMetaSeeder());

            Logger.info("Start Running Down Seeds..");
            System.out.println(ColorsService.ANSI_PURPLE + "Start Running Down Seeds.." + ColorsService.ANSI_RESET);

            try {
                Boolean status = seederService.runSeeders("down");
                if( status ){
                    Logger.info("Down Seeds Completed Successfully!");
                    System.out.println("\n" + ColorsService.ANSI_GREEN + "Down Seeds Completed Successfully!" + ColorsService.ANSI_RESET);
                }else{
                    Logger.error("Something Goes Wrong While Running Down Seeds! Check The Logs For Further Informations.");
                    System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running Down Seeds! Check The Logs For Further Informations." + ColorsService.ANSI_RESET);
                }
            }catch ( Exception e) {
                Logger.error("Error While Running Command [ $.. seed " + this.data + " ]. Reason [ " + e.getMessage() + " ]");
            }

        }else if( this.data.contains("up") ){

            Logger.info("Start Registering Seeds..");
            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_RESET);
            SeederService seederService = new SeederService(DatabaseService.instance());

            Logger.info("Register Option Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new OptionSeeder());

            Logger.info("Register Migration Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new MigrationSeeder());

            Logger.info("Register Bot Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotSeeder());

            Logger.info("Register BotMeta Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotMetaSeeder());

            Logger.info("Start Running " + this.data + " Seed..");
            System.out.println(ColorsService.ANSI_PURPLE + "Start Running " + this.data + " Seed.." + ColorsService.ANSI_RESET);

            try {
                Boolean status = seederService.runSeeder(this.data, "up");
                if( status ){
                    Logger.info(this.data + " Seed Completed Successfully!");
                    System.out.println("\n" + ColorsService.ANSI_GREEN + this.data + " Seed Completed Successfully!" + ColorsService.ANSI_RESET);
                }else{
                    Logger.error("Something Goes Wrong While Running " + this.data + " Seed! Check The Logs For Further Informations.");
                    System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running " + this.data + " Seed! Check The Logs For Further Informations." + ColorsService.ANSI_RESET);
                }
            }catch ( Exception e) {
                Logger.error("Error While Running Command [ $.. seed " + this.data + " ]. Reason [ " + e.getMessage() + " ]");
            }

        }else if( this.data.contains("down") ){

            Logger.info("Start Registering Seeds..");
            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_RESET);
            SeederService seederService = new SeederService(DatabaseService.instance());

            Logger.info("Register Option Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new OptionSeeder());

            Logger.info("Register Migration Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new MigrationSeeder());

            Logger.info("Register Bot Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotSeeder());

            Logger.info("Register BotMeta Seeds");
            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_RESET);
            seederService.setSeeder(new BotMetaSeeder());

            Logger.info("Start Running " + this.data + " Seed..");
            System.out.println(ColorsService.ANSI_PURPLE + "Start Running " + this.data + " Seed.." + ColorsService.ANSI_RESET);

            try {
                Boolean status = seederService.runSeeder(this.data, "down");
                if( status ){
                    Logger.info(this.data + " Seed Completed Successfully!");
                    System.out.println("\n" + ColorsService.ANSI_GREEN + this.data + " Seed Completed Successfully!" + ColorsService.ANSI_RESET);
                }else{
                    Logger.error("Something Goes Wrong While Running " + this.data + " Seed! Check The Logs For Further Informations.");
                    System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running " + this.data + " Seed! Check The Logs For Further Informations." + ColorsService.ANSI_RESET);
                }
            }catch ( Exception e) {
                Logger.error("Error While Running Command [ $.. seed " + this.data + " ]. Reason [ " + e.getMessage() + " ]");
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