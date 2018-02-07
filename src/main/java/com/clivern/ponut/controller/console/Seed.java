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

import com.clivern.ponut.module.service.database.SeederService;
import com.clivern.ponut.module.service.database.DatabaseService;
import com.clivern.ponut.database.seed.*;

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

            SeederService seederService = new SeederService(DatabaseService.instance());
            seederService.setSeeder(new OptionSeeder());
            seederService.setSeeder(new MigrationSeeder());
            seederService.setSeeder(new BotSeeder());
            seederService.setSeeder(new BotMetaSeeder());
            seederService.runSeeders("up");

        }else if( this.data.equals("down") ){

            SeederService seederService = new SeederService(DatabaseService.instance());
            seederService.setSeeder(new OptionSeeder());
            seederService.setSeeder(new MigrationSeeder());
            seederService.setSeeder(new BotSeeder());
            seederService.setSeeder(new BotMetaSeeder());
            seederService.runSeeders("down");

        }else if( this.data.contains("up") ){

            SeederService seederService = new SeederService(DatabaseService.instance());
            seederService.setSeeder(new OptionSeeder());
            seederService.setSeeder(new MigrationSeeder());
            seederService.setSeeder(new BotSeeder());
            seederService.setSeeder(new BotMetaSeeder());
            seederService.runSeeder(this.data, "up");

        }else if( this.data.contains("down") ){

            SeederService seederService = new SeederService(DatabaseService.instance());
            seederService.setSeeder(new OptionSeeder());
            seederService.setSeeder(new MigrationSeeder());
            seederService.setSeeder(new BotSeeder());
            seederService.setSeeder(new BotMetaSeeder());
            seederService.runSeeder(this.data, "down");

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