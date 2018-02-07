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
import javax.persistence.Column;

/**
 * Migrations Model
 *
 * @since 1.0.0
 */

@Table(name="migrations")
@Entity
public class MigrationModel extends BaseModel {

    @NotNull
    @Column(name="`key`")
    String key;

    @NotNull
    @Column(name="`created`")
    String created;

    @NotNull
    @Column(name="`updated`")
    String updated;

    /**
     * Class Constructor
     *
     * @param  key
     * @param  created
     * @param  updated
     */
    public MigrationModel(String key, String created, String updated)
    {
        this.key = key;
        this.created = created;
        this.updated = updated;
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
     * Get Key
     *
     * @return String
     */
    public String getKey()
    {
        return this.key;
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