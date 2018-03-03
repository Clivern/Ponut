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
import com.clivern.ponut.model.BotModel;

/**
 * Bot Entity Contract Interface
 *
 * @since 1.0.0
 */
public interface BotContract {

    /**
     * Get Bot By ID
     *
     * @param id the bot id
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneById(Integer id) throws IllegalArgumentException;

    /**
     * Get Bot By Slug
     *
     * @param slug the bot slug
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneBySlug(String slug) throws IllegalArgumentException;

    /**
     * Get Bot By Name
     *
     * @param slug the bot name
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneByName(String name) throws IllegalArgumentException;

    /**
     * Get Bot By Name
     *
     * @param isDefault whether bot is default or not
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneByIsDefault(String isDefault) throws IllegalArgumentException;

    /**
     * Get Many Bots By Status
     *
     * @param status the bot status
     * @return List a list of bots
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotModel> getManyByStatus(String status) throws IllegalArgumentException;

    /**
     * Get Many Bots By Type
     *
     * @param type the bot type
     * @return List a list of bots
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotModel> getManyByType(String type) throws IllegalArgumentException;

    /**
     * Create a New Bot
     *
     * @param item a list of bot data
     * @return Boolean whether bot saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException;

    /**
     * Create Many Bots
     *
     * @param items a list of bots data
     * @return Boolean whether bots saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createMany(List<Map<String, String>> items) throws IllegalArgumentException;

    /**
     * Delete a Bot
     *
     * @param bot a bot to delete
     * @return Boolean whether bot deleted or not
     */
    public Boolean deleteOne(BotModel bot);

    /**
     * Delete Many Bots
     *
     * @param items a list of bots to delete
     * @return Boolean whether bots deleted or not
     */
    public Boolean deleteMany(List<BotModel> items);

}