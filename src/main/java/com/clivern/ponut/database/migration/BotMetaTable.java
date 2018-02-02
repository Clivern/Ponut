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
 * Bot Meta Table Migrations
 *
 * @since 1.0.0
 */
public class BotMetaTable extends Migration  {

	protected String tableName = "botsMeta";
	protected String relationTable = "bots";

	/**
	 * Set Create Queries
	 */
	public void up()
	{
		this.migrations.put("01_up_create_bots_meta_table", String.format("CREATE TABLE IF NOT EXISTS `%s` (
			`id` int NOT NULL AUTO_INCREMENT,
			`botId` int NOT NULL,
			`key` varchar(60) NOT NULL,
			`value` text NOT NULL,
  			`created` datetime NOT NULL,
  			`updated` datetime NOT NULL,
			PRIMARY KEY (`id`),
			KEY `key` (`key`),
			FOREIGN KEY (`botId`) REFERENCES %s(`id`)
		) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;", this.tableName, this.relationTable));
	}

	/**
	 * Set Drop Queries
	 */
	public void down()
	{
		this.migrations.put("01_down_drop_bots_meta_table", String.format("DROP TABLE IF EXISTS %s;", this.tableName));
	}
}