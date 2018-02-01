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

import java.util.HashMap;
import java.util.Map;
import com.clivern.ponut.exception.SeedNotFound;

/**
 * BotsMeta Table Seeds
 *
 * @since 1.0.0
 */
public class BotMeta {

	protected Map<String, String> seeds = new HashMap<String, String>();

	protected String tableName = "botsMeta";

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

	/**
	 * Get All Queries
	 *
	 * @return Map
	 */
	public Map<String, String> getSeeds()
	{
		return this.seeds;
	}

	/**
	 * Get Specific Query
	 *
	 * @param  key
	 * @return String
	 * @throws SeedNotFound
	 */
	public String getSeed(String key) throws SeedNotFound
	{
        if( this.seeds.containsKey(key) ){
            return this.seeds.get(key);
        }

        throw new SeedNotFound(String.format("%s Seed Not Found!", key));
	}
}