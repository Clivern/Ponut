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

import java.util.HashMap;
import java.util.Map;
import com.clivern.ponut.database.contract.Migration;
import com.clivern.ponut.module.contract.database.MigrationContract;

/**
 * Database Migrations Service
 *
 * @since 1.0.0
 */
public class MigrationService implements MigrationContract {

    protected Map<String, String> upMigrations = new HashMap<String, String>();

    protected Map<String, String> downMigrations = new HashMap<String, String>();

    /**
     * Set Migration
     *
     * @param  migration
     * @return Boolean
     */
    public Boolean setMigration(Migration migration)
    {
        //#
        return false;
    }

    /**
     * Run Migrations
     *
     * @return Boolean
     */
    public Boolean runMigrations()
    {
        //#
        return false;
    }

    /**
     * Run Migration
     *
     * @param  key
     * @return Boolean
     */
    public Boolean runMigration(String key)
    {
        //#
        return false;
    }

    /**
     * Get Migrations
     *
     * @return Map
     */
    public Map<String, String> getMigrations()
    {
        //#
        return new HashMap<String, String>();
    }

    /**
     * Get Migration
     *
     * @param  key
     * @return String
     */
    public String getMigration(String key)
    {
        //#
        return "";
    }
}