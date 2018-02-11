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
 * BotsMeta Table Seeder
 *
 * @since 1.0.0
 */
public class BotMetaSeeder extends Seeder {

    protected String tableName = "botsMeta";

    /**
     * Set Create Queries
     */
    public void up()
    {
        Date todaysDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.seeds.put("04-up_insert1_into_botsmeta_table", String.format("INSERT INTO %s " +
            "(`botId`, `key`, `value`, `created`, `updated`) VALUES" +
            "(1, 'bot_verify_token', 'Verify Token Goes Here', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_page_access_token', 'Page Access Token Goes Here', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_console_status', 'false', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_console_level', 'OFF', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_file_status', 'false', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_file_level', 'OFF', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_file_path', 'app.log', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_file_limit', '1', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_file_count', '200000', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(1, 'bot_log_file_append', 'true', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "');",
        this.tableName));

        this.seeds.put("05-up_insert2_into_botsmeta_table", String.format("INSERT INTO %s " +
            "(`botId`, `key`, `value`, `created`, `updated`) VALUES " +
            "(2, 'bot_client_id', '', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_client_secret', '', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_scope', 'reminders:read reminders:write', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_redirect_uri', 'https://2484683b.ngrok.io/oauth', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_state_type', 'vary', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_state', 'Yuiw625372ndhjdbsse', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_team', '', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_verification_token', '', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_console_status', 'false', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_console_level', 'OFF', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_file_status', 'false', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_file_level', 'OFF', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_file_path', 'app.log', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_file_limit', '1', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_file_count', '200000', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "')," +
            "(2, 'bot_log_file_append', 'false', '" + df.format(todaysDate) + "', '" + df.format(todaysDate) + "');",
        this.tableName));

    }

    /**
     * Set Drop Queries
     */
    public void down()
    {
        this.seeds.put("02-down_insert1_into_botsmeta_table", String.format("DELETE FROM %s WHERE `botId` =  1;", this.tableName));
        this.seeds.put("03-down_insert2_into_botsmeta_table", String.format("DELETE FROM %s WHERE `botId` =  2;", this.tableName));
    }
}