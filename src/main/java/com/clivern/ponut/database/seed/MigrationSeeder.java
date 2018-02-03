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

import com.clivern.ponut.database.contract.Seeder;

/**
 * Migrations Table Seeder
 *
 * @since 1.0.0
 */
public class MigrationSeeder extends Seeder {

    protected String tableName = "migrations";

    protected Integer order = 1;

    /**
     * Set Create Queries
     */
    public void up()
    {
        //#
    }

    /**
     * Set Drop Queries
     */
    public void down()
    {
        //#
    }
}