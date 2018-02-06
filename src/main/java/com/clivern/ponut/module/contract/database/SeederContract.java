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
import com.clivern.ponut.database.contract.Seeder;
import com.clivern.ponut.exception.SeedNotFound;

/**
 * Database Seeders Service Interface
 *
 * @since 1.0.0
 */
public interface SeederContract {

   /**
     * Set Seeder
     *
     * @param  seeder
     */
    public void setSeeder(Seeder seeder);

    /**
     * Run Seeders
     *
     * @param direction
     * @return Boolean
     */
    public Boolean runSeeders(String direction);

    /**
     * Run Seeder
     *
     * @param  key
     * @param direction
     * @return Boolean
     */
    public Boolean runSeeder(String key, String direction);

    /**
     * Get Seeders
     *
     * @param direction
     * @return Map
     */
    public Map<String, String> getSeeders(String direction);

    /**
     * Get Seeder
     *
     * @param  key
     * @return String
     */
    public String getSeeder(String key) throws SeedNotFound;
}