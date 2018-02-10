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
package com.clivern.ponut.database.migration;

import com.clivern.ponut.database.contract.Migration;

/**
 * Bots Table Migrations
 *
 * @since 1.0.0
 */
public class BotTable extends Migration {

    protected String tableName = "bots";

    /**
     * Set Create Queries
     */
    public void up()
    {
        this.migrations.put("03-up_create_bots_table", String.format("CREATE TABLE IF NOT EXISTS %s (\n" +
            "`id` int NOT NULL AUTO_INCREMENT,\n" +
            "`name` varchar(50) NOT NULL,\n" +
            "`slug` varchar(80) NOT NULL,\n" +
            "`status` varchar(20) NOT NULL,\n" +
            "`type` varchar(20) NOT NULL,\n" +
            "`isDefault` varchar(20) NOT NULL,\n" +
            "`created` datetime NOT NULL,\n" +
            "`updated` datetime NOT NULL,\n" +
            "PRIMARY KEY (`id`),\n" +
            "KEY `slug` (`slug`)\n" +
        ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;", this.tableName));
    }

    /**
     * Set Drop Queries
     */
    public void down()
    {
        this.migrations.put("03-down_create_bots_table", String.format("DROP TABLE IF EXISTS %s;", this.tableName));
    }
}