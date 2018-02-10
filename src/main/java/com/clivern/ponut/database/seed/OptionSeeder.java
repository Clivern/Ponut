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
 * Options Table Seeder
 *
 * @since 1.0.0
 */
public class OptionSeeder extends Seeder {

    protected String tableName = "options";

    /**
     * Set Create Queries
     */
    public void up()
    {
        this.seeds.put("01-up_insert1_into_options_table", String.format("INSERT INTO %s (`key`, `value`, `autoload`) VALUES ('app_name', 'Ponut', 'on');", this.tableName));
    }

    /**
     * Set Drop Queries
     */
    public void down()
    {
        this.seeds.put("01-down_insert1_into_options_table", String.format("DELETE FROM %s WHERE `key` =  'app_name';", this.tableName));
    }
}