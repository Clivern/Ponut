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
package com.clivern.ponut.database.seed;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.clivern.ponut.database.contract.Seeder;

/**
 * Bots Table Seeder
 *
 * @since 1.0.0
 */
public class BotSeeder extends Seeder {

    protected String tableName = "bots";

    /**
     * Set Create Queries
     */
    public void up()
    {
        Date todaysDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.seeds.put("02-up_insert1_into_bots_table", String.format("INSERT INTO %s (`name`, `slug`, `status`, `type`, `isDefault`, `created`, `updated`) VALUES ('Messenger', 'messenger', 'running', 'messenger_bot', 'no', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "');", this.tableName));
        this.seeds.put("03-up_insert2_into_bots_table", String.format("INSERT INTO %s (`name`, `slug`, `status`, `type`, `isDefault`, `created`, `updated`) VALUES ('Slack', 'slack', 'running', 'slack_bot', 'no', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "');", this.tableName));
    }

    /**
     * Set Drop Queries
     */
    public void down()
    {
        this.seeds.put("03-down_insert1_into_bots_table", String.format("DELETE FROM %s WHERE `slug` =  'messenger';", this.tableName));
        this.seeds.put("04-down_insert2_into_bots_table", String.format("DELETE FROM %s WHERE `slug` =  'slack';", this.tableName));
    }
}