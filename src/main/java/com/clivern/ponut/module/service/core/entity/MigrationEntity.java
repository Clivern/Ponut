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
package com.clivern.ponut.module.service.core.entity;

import java.util.Map;
import java.util.List;
import java.lang.IllegalArgumentException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.pmw.tinylog.Logger;
import io.ebean.Ebean;
import com.clivern.ponut.model.MigrationModel;
import com.clivern.ponut.module.contract.core.entity.MigrationContract;

/**
 * Migration Entity Class
 *
 * @since 1.0.0
 */
public class MigrationEntity implements MigrationContract {

    /**
     * Get Migration By ID
     *
     * <pre>
     * MigrationEntity migrationEntity = new MigrationEntity();
     * MigrationModel migration = migrationEntity.getOneById(4);
     * if( migration != null ){
     *   migration.getId();
     *   migration.getKey();
     *   migration.getCreated();
     *   migration.getUpdated();
     * }
     * </pre>
     *
     * @param id the migration id
     * @return MigrationModel an instance of migration model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public MigrationModel getOneById(Integer id) throws IllegalArgumentException
    {
        if (id.equals("")) {
            Logger.error("Error! Migration id is required.");
            throw new IllegalArgumentException("Error! Migration id is required.");
        }

        MigrationModel item = Ebean.find(MigrationModel.class)
            .select("*")
            .where()
            .eq("id", id)
            .findOne();

        return item;
    }

    /**
     * Get Migration By Key
     *
     * <pre>
     * MigrationEntity migrationEntity = new MigrationEntity();
     * MigrationModel migration = migrationEntity.getOneByKey("_mig_key");
     * if( migration != null ){
     *   migration.getId();
     *   migration.getKey();
     *   migration.getCreated();
     *   migration.getUpdated();
     * }
     * </pre>
     *
     * @param key the migration key
     * @return MigrationModel an instance of migration model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public MigrationModel getOneByKey(String key) throws IllegalArgumentException
    {
        if (key.equals("")) {
            Logger.error("Error! Migration key is required.");
            throw new IllegalArgumentException("Error! Migration key is required.");
        }

        MigrationModel item = Ebean.find(MigrationModel.class)
            .select("*")
            .where()
            .eq("key", key)
            .findOne();

        return item;
    }

    /**
     * Create a New Migration
     *
     * <pre>
     * MigrationEntity migrationEntity = new MigrationEntity();
     * Map<String, String> item = new HashMap<String, String>();
     * item.put("key", "_new_key");
     * Boolean status = migrationEntity.createOne(item);
     * </pre>
     *
     * @param item a list of migration data
     * @return Boolean whether migration saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException
    {
        Boolean status = true;
        Date todaysDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if( !item.containsKey("key") ){
            Logger.error("Error! Migration key is required.");
            throw new IllegalArgumentException("Error! Migration key is required.");
        }

        MigrationModel migrationModel = new MigrationModel(
            item.get("key").trim(),
            (item.containsKey("created")) ? item.get("created") : df.format(todaysDate),
            (item.containsKey("updated")) ? item.get("updated") : df.format(todaysDate)
        );

        migrationModel.save();
        status &= (migrationModel.getId() > 0) ? true : false;

        return status;
    }

    /**
     * Create Many Migrations
     *
     * <pre>
     * MigrationEntity migrationEntity = new MigrationEntity();
     * List<Map<String, String>> items = new ArrayList<Map<String, String>>();
     *
     * Map<String, String> item1 = new HashMap<String, String>();
     * item1.put("key", "_new_key1");
     *
     * Map<String, String> item2 = new HashMap<String, String>();
     * item2.put("key", "_new_key2");
     *
     * items.add(item1);
     * items.add(item2);
     *
     * Boolean status = migrationEntity.createMany(items);
     * </pre>
     *
     * @param items a list of migrations data
     * @return Boolean whether migrations saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createMany(List<Map<String, String>> items) throws IllegalArgumentException
    {
        Boolean status = true;

        for(Map<String, String> item : items){
            status &= this.createOne(item);
        }

        return status;
    }

    /**
     * Delete a Migration
     *
     * <pre>
     * MigrationEntity migrationEntity = new MigrationEntity();
     * MigrationModel migration = migrationEntity.getOneById(4);
     * if( migration != null ){
     *   migrationEntity.deleteOne(migration);
     * }
     * </pre>
     * @param item a migration to delete
     * @return Boolean whether migration deleted or not
     */
    public Boolean deleteOne(MigrationModel item)
    {
        return Ebean.deletePermanent(item);
    }
}