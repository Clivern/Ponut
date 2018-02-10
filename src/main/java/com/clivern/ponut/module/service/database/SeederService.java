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
import com.clivern.ponut.database.contract.Seeder;
import com.clivern.ponut.module.contract.database.SeederContract;
import com.clivern.ponut.exception.SeedNotFound;
import com.clivern.ponut.module.contract.database.DatabaseContract;
import org.pmw.tinylog.Logger;

/**
 * Database Seeders Service
 *
 * @since 1.0.0
 */
public class SeederService implements SeederContract {

    protected Map<String, String> upSeeders = new HashMap<String, String>();

    protected Map<String, String> downSeeders = new HashMap<String, String>();

    protected DatabaseContract databaseContract;

    /**
     * Seeder Service Constructor
     *
     * @param  databaseContract
     */
    public SeederService(DatabaseContract databaseContract)
    {
        this.databaseContract = databaseContract;
    }

    /**
     * Set Seeder
     *
     * @param  seeder
     * @return Boolean
     */
    public void setSeeder(Seeder seeder)
    {
        seeder.up();
        seeder.down();

        HashMap<String, String> seeders = (HashMap<String, String>) seeder.getSeeds();

        for (Map.Entry<String, String> entry : seeders.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if( key.contains("up_") ){
                this.upSeeders.put(key, value);
            }else{
                this.downSeeders.put(key, value);
            }
        }
    }

    /**
     * Run Seeders
     *
     * @param direction
     * @return Boolean
     */
    public Boolean runSeeders(String direction)
    {
        if( !this.databaseContract.isConnected() ){
            return false;
        }

        Boolean status = true;
        this.upSeeders = this.sortSeeders(this.upSeeders);
        this.downSeeders = this.sortSeeders(this.downSeeders);

        if( direction.equals("up") ){
            for (Map.Entry<String, String> entry : this.upSeeders.entrySet()){
                status &= this.runSeeder(entry.getKey(), "up");
            }
        }else if(direction.equals("down")){
            for (Map.Entry<String, String> entry : this.downSeeders.entrySet()){
                status &= this.runSeeder(entry.getKey(), "down");
            }
        }

        return status;
    }

    /**
     * Run Seeder
     *
     * @param  key
     * @param direction
     * @return Boolean
     */
    public Boolean runSeeder(String key, String direction)
    {
        if( !this.databaseContract.isConnected() ){
            return false;
        }

        if( this.upSeeders.containsKey(key) && direction.equals("up") ){

            return this.databaseContract.execute(this.upSeeders.get(key));

        }else if( this.downSeeders.containsKey(key) && direction.equals("down") ){

            return this.databaseContract.execute(this.downSeeders.get(key));

        }

        return false;
    }

    /**
     * Get Seeders
     *
     * @param direction
     * @return Map
     */
    public Map<String, String> getSeeders(String direction)
    {
        this.upSeeders = this.sortSeeders(this.upSeeders);
        this.downSeeders = this.sortSeeders(this.downSeeders);

        if( direction.equals("up") ){
            return this.upSeeders;
        }else if(direction.equals("down")){
            return this.downSeeders;
        }else{
            return this.upSeeders;
        }
    }

    /**
     * Get Seeder
     *
     * @param  key
     * @return String
     */
    public String getSeeder(String key) throws SeedNotFound
    {
        if( this.upSeeders.containsKey(key) ){
            return this.upSeeders.get(key);
        }else if( this.downSeeders.containsKey(key) ){
            return this.downSeeders.get(key);
        }

        throw new SeedNotFound(String.format("%s Seed Not Found!", key));
    }

    /**
     * Sort Seeders
     *
     * @param  seeds
     * @return Map
     */
    private Map<String, String> sortSeeders(Map<String, String> seeds)
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
        treeMap.putAll(seeds);
        return treeMap;
    }
}