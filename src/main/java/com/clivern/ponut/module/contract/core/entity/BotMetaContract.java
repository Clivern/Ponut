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
import com.clivern.ponut.model.BotMetaModel;

/**
 * BotMeta Entity Contract Interface
 *
 * @since 1.0.0
 */
public interface BotMetaContract {


    /**
     * Get Meta By ID
     *
     * @param id the meta id
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneById(Integer id) throws IllegalArgumentException;

    /**
     * Get Meta By Key
     *
     * @param key the meta key
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByKey(String key) throws IllegalArgumentException;

    /**
     * Get Meta By Bot Id
     *
     * @param botId the meta bot id
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByBotId(Integer botId) throws IllegalArgumentException;

    /**
     * Get Meta By Value
     *
     * @param value the meta value
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByValue(String value) throws IllegalArgumentException;

    /**
     * Get Meta By Key and Bot Id
     *
     * @param botId the meta bot id
     * @param key the meta key
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByKeyAndBotId(Integer botId, String key) throws IllegalArgumentException;

    /**
     * Get Many Metas By Key
     *
     * @param key the bot meta key
     * @return List a list of bots metas
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotMetaModel> getManyByKey(String key) throws IllegalArgumentException;

    /**
     * Get Many Metas By Key and Bot Id
     *
     * @param botId the bot id
     * @param key the bot meta key
     * @return List a list of Metas
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotMetaModel> getManyByBotIdAndKey(Integer botId, String key) throws IllegalArgumentException;

    /**
     * Get Many Metas By Bot Id
     *
     * @param botId the bot id
     * @return List a list of bots metas
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotMetaModel> getManyByBotId(Integer botId) throws IllegalArgumentException;

    /**
     * Create a New Meta
     *
     * @param item a list of metas
     * @return Boolean whether meta saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException;

    /**
     * Create Many Metas
     *
     * @param items a list of metas data
     * @return Boolean whether metas saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createMany(List<Map<String, String>> items) throws IllegalArgumentException;

    /**
     * Delete a Meta
     *
     * @param botMeta a meta to delete
     * @return Boolean whether meta deleted or not
     */
    public Boolean deleteOne(BotMetaModel botMeta);

    /**
     * Delete Metas
     *
     * @param items a list of metas to delete
     * @return Boolean whether metas deleted or not
     */
    public Boolean deleteMany(List<BotMetaModel> items);

}