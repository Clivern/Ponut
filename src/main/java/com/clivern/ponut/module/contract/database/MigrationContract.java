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
package com.clivern.ponut.module.contract.database;

import java.util.Map;
import com.clivern.ponut.database.contract.Migration;

/**
 * Database Migrations Service Interface
 *
 * @since 1.0.0
 */
public interface MigrationContract {

	/**
	 * Set Migration
	 *
	 * @param  migration
	 * @return Boolean
	 */
	abstract public Boolean setMigration(Migration migration);

	/**
	 * Run Migrations
	 *
	 * @return Boolean
	 */
	abstract public Boolean runMigrations();

	/**
	 * Run Migration
	 *
	 * @param  key
	 * @return Boolean
	 */
	abstract public Boolean runMigration(String key);

	/**
	 * Get Migrations
	 *
	 * @return Map
	 */
	abstract public Map<String, String> getMigrations();

	/**
	 * Get Migration
	 *
	 * @param  key
	 * @return String
	 */
	abstract public String getMigration(String key);
}