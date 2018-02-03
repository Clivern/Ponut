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
import com.clivern.ponut.database.contract.Seeder;
import com.clivern.ponut.module.contract.database.SeederContract;

/**
 * Database Seeders Service
 *
 * @since 1.0.0
 */
public class SeederService implements SeederContract {

    /**
     * Set Seeder
     *
     * @param  seeder
     * @return Boolean
     */
    public Boolean setSeeder(Seeder seeder)
    {
        //#
        return false;
    }

    /**
     * Run Seeders
     *
     * @return Boolean
     */
    public Boolean runSeeders()
    {
        //#
        return false;
    }

    /**
     * Run Seeder
     *
     * @param  key
     * @return Boolean
     */
    public Boolean runSeeder(String key)
    {
        //#
        return false;
    }

    /**
     * Get Seeders
     *
     * @return Map
     */
    public Map<String, String> getSeeders()
    {
        //#
        return new HashMap<String, String>();
    }

    /**
     * Get Seeder
     *
     * @param  key
     * @return String
     */
    public String getSeeder(String key)
    {
        //#
        return "";
    }
}