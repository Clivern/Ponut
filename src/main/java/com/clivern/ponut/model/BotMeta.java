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
package com.clivern.ponut.model;

import io.ebean.Model;
import javax.persistence.Id;
import io.ebean.annotation.NotNull;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Bots Meta Model
 *
 * @since 1.0.0
 */
@Entity
@Table(name="botsMeta")
public class BotMeta extends Model {

    @Id
    Integer id;

    @NotNull
    Integer botId;

    @NotNull
    String key;

    @NotNull
    String value;

    @NotNull
    String created;

    @NotNull
    String updated;

    /**
     * Class Constructor
     *
     * @param  botId
     * @param  key
     * @param  value
     * @param  created
     * @param  updated
     */
    public BotMeta(Integer botId, String key, String value, String created, String updated)
    {
    	this.botId = botId;
        this.key = key;
        this.value = value;
        this.created = created;
        this.updated = updated;
    }

    /**
     * Set ID
     *
     * @param id
     */
    public void setId(Integer id)
    {
      this.id = id;
    }

    /**
     * Set Bot ID
     *
     * @param botId
     */
    public void setBotId(Integer botId)
    {
      this.botId = botId;
    }

    /**
     * Set Key
     *
     * @param key
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * Set Value
     *
     * @param value
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * Set Created
     *
     * @param created
     */
    public void setCreated(String created)
    {
        this.created = created;
    }

    /**
     * Set Updated
     *
     * @param updated
     */
    public void setUpdated(String updated)
    {
        this.updated = updated;
    }

    /**
     * Get ID
     *
     * @return Integer
     */
    public Integer getId()
    {
      return this.id;
    }

    /**
     * Get Bot ID
     *
     * @return Integer
     */
    public Integer getBotId()
    {
      return this.botId;
    }

    /**
     * Get Key
     *
     * @return String
     */
    public String getKey()
    {
        return this.key;
    }

    /**
     * Get Value
     *
     * @return String
     */
    public String getValue()
    {
        return this.value;
    }

    /**
     * Get Created
     *
     * @return String
     */
    public String getCreated()
    {
        return this.created;
    }

    /**
     * Get Updated
     *
     * @return String
     */
    public String getUpdated()
    {
        return this.updated;
    }
}