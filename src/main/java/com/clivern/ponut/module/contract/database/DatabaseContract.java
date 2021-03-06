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

import io.ebean.CallableSql;
import com.typesafe.config.*;

/**
 * Database Service Interface
 *
 * @since 1.0.0
 */
public interface DatabaseContract {

    /**
     * Config Database Connection
     *
     * @param config
     */
    public void config(Config config);

    /**
     * Execute Custom SQL Query
     *
     * @param  sql
     * @return Boolean
     */
    public Boolean execute(String sql);

    /**
     * Execute Custom SQL Query
     *
     * @param  sql
     * @return Boolean
     */
    public Boolean execute(CallableSql sql);

    /**
     * Check if DB Connected
     *
     * @return Boolean
     */
    public Boolean isConnected();
}