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
package com.clivern.ponut.module.service.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.TreeMap;
import io.ebean.Ebean;

import com.clivern.ponut.model.MigrationModel;
import com.clivern.ponut.database.contract.Migration;
import com.clivern.ponut.module.contract.database.MigrationContract;
import com.clivern.ponut.exception.MigrationNotFound;
import com.clivern.ponut.module.contract.database.DatabaseContract;
import com.clivern.ponut.module.service.core.entity.MigrationEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.pmw.tinylog.Logger;

/**
 * Database Migrations Service
 *
 * @since 1.0.0
 */
public class MigrationService implements MigrationContract {

    protected Map<String, String> upMigrations = new HashMap<String, String>();

    protected Map<String, String> downMigrations = new HashMap<String, String>();

    protected DatabaseContract databaseContract;

    /**
     * Migration Service Constructor
     *
     * @param  databaseContract
     */
    public MigrationService(DatabaseContract databaseContract)
    {
        this.databaseContract = databaseContract;
    }

    /**
     * Set Migration
     *
     * @param  migration
     */
    public void setMigration(Migration migration)
    {
        migration.up();
        migration.down();

        HashMap<String, String> migrations = (HashMap<String, String>) migration.getMigrations();

        for (Map.Entry<String, String> entry : migrations.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if( key.contains("up_") ){
                this.upMigrations.put(key, value);
            }else{
                this.downMigrations.put(key, value);
            }
        }
    }

    /**
     * Run Migrations
     *
     * @param direction
     * @return Boolean
     */
    public Boolean runMigrations(String direction)
    {
        if( !this.databaseContract.isConnected() ){
            return false;
        }

        Boolean status = true;
        this.upMigrations = this.sortMigrations(this.upMigrations);
        this.downMigrations = this.sortMigrations(this.downMigrations);

        if( direction.equals("up") ){
            for (Map.Entry<String, String> entry : this.upMigrations.entrySet()){
                status &= this.runMigration(entry.getKey(), "up");
            }
        }else if(direction.equals("down")){
            for (Map.Entry<String, String> entry : this.downMigrations.entrySet()){
                status &= this.runMigration(entry.getKey(), "down");
            }
        }

        return status;
    }

    /**
     * Run Migration
     *
     * @param  key
     * @param  direction
     * @return Boolean
     */
    public Boolean runMigration(String key, String direction)
    {
        if( !this.databaseContract.isConnected() ){
            return false;
        }

        this.databaseContract.execute(this.upMigrations.get("01-up_create_migrations_table"));

        if( this.upMigrations.containsKey(key) && direction.equals("up") ){
            // Check if Already run before
            String[] keyArry = key.split("-");
            String upKey = keyArry[1];

            MigrationEntity migrationEntity = new MigrationEntity();
            MigrationModel migration = migrationEntity.getOneByKey(upKey);
            if( migration != null ){
                return true;
            }
            Map<String, String> item = new HashMap<String, String>();
            item.put("key", upKey);
            migrationEntity.createOne(item);

            return this.databaseContract.execute(this.upMigrations.get(key));

        }else if( this.downMigrations.containsKey(key) && direction.equals("down") ){

            // Check if Related up run before
            String[] keyArry = key.split("-");
            String upKey = keyArry[1].replace("down_", "up_");

            MigrationModel migration = Ebean.find(MigrationModel.class).select("key").where().eq("key", upKey).findOne();
            if( migration != null ){
                Ebean.delete(migration);
                return this.databaseContract.execute(this.downMigrations.get(key));
            }

            return true;
        }

        return false;
    }

    /**
     * Get Migrations
     *
     * @param direction
     * @return Map
     */
    public Map<String, String> getMigrations(String direction)
    {

        this.upMigrations = this.sortMigrations(this.upMigrations);
        this.downMigrations = this.sortMigrations(this.downMigrations);

        if( direction.equals("up") ){
            return this.upMigrations;
        }else if(direction.equals("down")){
            return this.downMigrations;
        }else{
            return this.upMigrations;
        }
    }

    /**
     * Get Migration
     *
     * @param  key
     * @return String
     * @throws MigrationNotFound
     */
    public String getMigration(String key) throws MigrationNotFound
    {
        if( this.upMigrations.containsKey(key) ){
            return this.upMigrations.get(key);
        }else if( this.downMigrations.containsKey(key) ){
            return this.downMigrations.get(key);
        }

        throw new MigrationNotFound(String.format("%s Migration Not Found!", key));
    }

    /**
     * Sort Migrations
     *
     * @param  migrations
     * @return Map
     */
    private Map<String, String> sortMigrations(Map<String, String> migrations)
    {
        Map<String, String> treeMap = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String item1, String item2) {
                String[] itemArr1 = item1.split("-");
                String[] itemArr2 = item2.split("-");

                Integer itemInt1 = Integer.parseInt(itemArr1[0]);
                Integer itemInt2 = Integer.parseInt(itemArr2[0]);

                return itemInt1.compareTo(itemInt2);
            }
        });
        treeMap.putAll(migrations);
        return treeMap;
    }
}