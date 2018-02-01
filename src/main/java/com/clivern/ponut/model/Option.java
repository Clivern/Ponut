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
 * Options Model
 *
 * @since 1.0.0
 */
@Entity
@Table(name="options")
public class Option extends Model {

    @Id
    Integer id;

    @NotNull
    String key;

    @NotNull
    String value;

    @NotNull
    String autoload;

    /**
     * Class Constructor
     *
     * @param  key
     * @param  value
     * @param  autoload
     */
    public Option(String key, String value, String autoload)
    {
        this.key = key;
        this.value = value;
        this.autoload = autoload;
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
     * Set Autoload Value
     *
     * @param autoload
     */
    public void setAutoload(String autoload)
    {
        this.autoload = autoload;
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
     * Get Autoload Value
     *
     * @return String
     */
    public String getAutoload()
    {
        return this.autoload;
    }
}