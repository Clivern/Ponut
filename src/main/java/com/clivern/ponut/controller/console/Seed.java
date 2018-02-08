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


            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_PURPLE);
            SeederService seederService = new SeederService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new OptionSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new MigrationSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotMetaSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running Up Seeds.." + ColorsService.ANSI_PURPLE);
            Boolean status = seederService.runSeeders("up");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + "Up Seeds Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running Up Seeds! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
            }

        }else if( this.data.equals("down") ){

            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_PURPLE);
            SeederService seederService = new SeederService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new OptionSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new MigrationSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotMetaSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running Down Seeds.." + ColorsService.ANSI_PURPLE);
            Boolean status = seederService.runSeeders("down");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + "Down Seeds Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running Down Seeds! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
            }

        }else if( this.data.contains("up") ){

            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_PURPLE);
            SeederService seederService = new SeederService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new OptionSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new MigrationSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotMetaSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running " + this.data + " Seed.." + ColorsService.ANSI_PURPLE);
            Boolean status = seederService.runSeeder(this.data, "up");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + this.data + " Seed Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running " + this.data + " Seed! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
            }

        }else if( this.data.contains("down") ){

            System.out.println("\n" + ColorsService.ANSI_PURPLE + "Start Registering Seeds.." + ColorsService.ANSI_PURPLE);
            SeederService seederService = new SeederService(DatabaseService.instance());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Option Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new OptionSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Migration Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new MigrationSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register Bot Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "|- Register BotMeta Seeds" + ColorsService.ANSI_PURPLE);
            seederService.setSeeder(new BotMetaSeeder());

            System.out.println(ColorsService.ANSI_PURPLE + "Start Running " + this.data + " Seed.." + ColorsService.ANSI_PURPLE);
            Boolean status = seederService.runSeeder(this.data, "down");

            if( status ){
                System.out.println("\n" + ColorsService.ANSI_GREEN + this.data + " Seed Completed Successfully!" + ColorsService.ANSI_GREEN);
            }else{
                System.out.println("\n" + ColorsService.ANSI_RED + "Something Goes Wrong While Running " + this.data + " Seed! Check The Logs For Further Informations." + ColorsService.ANSI_RED);
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