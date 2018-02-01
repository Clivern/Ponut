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

import java.util.HashMap;
import java.util.Map;
import com.clivern.ponut.exception.MigrationNotFound;

/**
 * Options Table Migrations
 *
 * @since 1.0.0
 */
public class Option {

	protected Map<String, String> migrations = new HashMap<String, String>();

	protected String tableName = "Options";

	/**
	 * Set Create Queries
	 */
	public void up()
	{
		this.migrations.put("01_up_create_options_table", String.format("CREATE TABLE IF NOT EXISTS `%s` (id bigint auto_increment not null, key varchar(60) not null, value varchar(250) not null, autoload varchar(10) not null, constraint pk_options primary key (id));", this.tableName));
	}

	/**
	 * Set Drop Queries
	 */
	public void down()
	{
		this.migrations.put("01_down_drop_options_table", String.format("DROP TABLE IF EXISTS %s;", this.tableName));
	}

	/**
	 * Get All Queries
	 *
	 * @return Map
	 */
	public Map<String, String> getMigrations()
	{
		return this.migrations;
	}

	/**
	 * Get Specific Query
	 *
	 * @param  key
	 * @return String
	 * @throws MigrationNotFound
	 */
	public String getMigration(String key) throws MigrationNotFound
	{
        if( this.migrations.containsKey(key) ){
            return this.migrations.get(key);
        }

        throw new MigrationNotFound("Migration Not Found!");
	}
}