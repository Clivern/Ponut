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
import com.clivern.ponut.exception.MigrationNotFound;

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
     */
    public void setMigration(Migration migration);

    /**
     * Run Migrations
     *
     * @param direction
     * @return Boolean
     */
    public Boolean runMigrations(String direction);

    /**
     * Run Migration
     *
     * @param  key
     * @return Boolean
     */
    public Boolean runMigration(String key, String direction);

    /**
     * Get Migrations
     *
     * @param direction
     * @return Map
     */
    public Map<String, String> getMigrations(String direction);

    /**
     * Get Migration
     *
     * @param  key
     * @return String
     * @throws MigrationNotFound
     */
    public String getMigration(String key) throws MigrationNotFound;

}