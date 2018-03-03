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
package com.clivern.ponut.module.contract.core.entity;

import java.util.Map;
import java.util.List;
import java.lang.IllegalArgumentException;
import com.clivern.ponut.model.MigrationModel;

/**
 * Migration Entity Contract Interface
 *
 * @since 1.0.0
 */
public interface MigrationContract {

    /**
     * Get Migration By ID
     *
     * @param id the migration id
     * @return MigrationModel an instance of migration model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public MigrationModel getOneById(Integer id) throws IllegalArgumentException;

    /**
     * Get Migration By Key
     *
     * @param key the migration key
     * @return MigrationModel an instance of migration model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public MigrationModel getOneByKey(String key) throws IllegalArgumentException;

    /**
     * Create a New Migration
     *
     * @param item a list of migration data
     * @return Boolean whether migration saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException;

    /**
     * Create Many Migrations
     *
     * @param items a list of migrations data
     * @return Boolean whether migrations saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createMany(List<Map<String, String>> items) throws IllegalArgumentException;

    /**
     * Delete a Migration
     *
     * @param item a migration to delete
     * @return Boolean whether migration deleted or not
     */
    public Boolean deleteOne(MigrationModel item);

}