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
import org.pmw.tinylog.Logger;
import io.ebean.Ebean;
import com.clivern.ponut.model.BotModel;
import com.clivern.ponut.module.contract.core.entity.BotContract;

/**
 * Bot Entity Class
 *
 * @since 1.0.0
 */
public class BotEntity implements BotContract {

    /**
     * Get Bot By ID
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * BotModel bot = botEntity.getOneById(4);
     * if( bot != null ){
     *   bot.getId();
     *   bot.getName();
     *   bot.getSlug();
     *   bot.getStatus();
     *   bot.getType();
     *   bot.getIsDefault();
     *   bot.getCreated();
     *   bot.getUpdated();
     * }
     * </pre>
     *
     * @param id the bot id
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneById(Integer id) throws IllegalArgumentException
    {
        if (id.equals("")) {
            Logger.error("Error! Bot id is required.");
            throw new IllegalArgumentException("Error! Bot id is required.");
        }

        BotModel item = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("id", id)
            .findOne();

        return item;
    }

    /**
     * Get Bot By Slug
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * BotModel bot = botEntity.getOneBySlug("bot_slug");
     * if( bot != null ){
     *   bot.getId();
     *   bot.getName();
     *   bot.getSlug();
     *   bot.getStatus();
     *   bot.getType();
     *   bot.getIsDefault();
     *   bot.getCreated();
     *   bot.getUpdated();
     * }
     * </pre>
     *
     * @param slug the bot slug
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneBySlug(String slug) throws IllegalArgumentException
    {
        if (slug.equals("")) {
            Logger.error("Error! Bot slug is required.");
            throw new IllegalArgumentException("Error! Bot slug is required.");
        }

        BotModel item = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("slug", slug)
            .findOne();

        return item;
    }

    /**
     * Get Bot By Name
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * BotModel bot = botEntity.getOneByName("bot_name");
     * if( bot != null ){
     *   bot.getId();
     *   bot.getName();
     *   bot.getSlug();
     *   bot.getStatus();
     *   bot.getType();
     *   bot.getIsDefault();
     *   bot.getCreated();
     *   bot.getUpdated();
     * }
     * </pre>
     *
     * @param slug the bot name
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneByName(String name) throws IllegalArgumentException
    {
        if (name.equals("")) {
            Logger.error("Error! Bot name is required.");
            throw new IllegalArgumentException("Error! Bot name is required.");
        }

        BotModel item = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("name", name)
            .findOne();

        return item;
    }

    /**
     * Get Bot By Name
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * BotModel bot = botEntity.getOneByIsDefault("yes");
     * if( bot != null ){
     *   bot.getId();
     *   bot.getName();
     *   bot.getSlug();
     *   bot.getStatus();
     *   bot.getType();
     *   bot.getIsDefault();
     *   bot.getCreated();
     *   bot.getUpdated();
     * }
     * </pre>
     *
     * @param isDefault whether bot is default or not
     * @return BotModel an instance of bot model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotModel getOneByIsDefault(String isDefault) throws IllegalArgumentException
    {
        if (isDefault.equals("")) {
            Logger.error("Error! Bot is default is required.");
            throw new IllegalArgumentException("Error! Bot is default is required.");
        }

        BotModel item = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("isDefault", isDefault)
            .findOne();

        return item;
    }

    /**
     * Get Many Bots By Status
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * List<BotModel> bots =  botEntity.getManyByStatus("running");
     * </pre>
     *
     * @param status the bot status
     * @return List a list of bots
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotModel> getManyByStatus(String status) throws IllegalArgumentException
    {
        if (status.equals("")) {
            Logger.error("Error! Bot status is required.");
            throw new IllegalArgumentException("Error! Bot status is required.");
        }

        List<BotModel> items = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("status", status)
            .findList();

        return items;
    }

    /**
     * Get Many Bots By Type
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * List<BotModel> bots =  botEntity.getManyByType("slack");
     * </pre>
     *
     * @param type the bot type
     * @return List a list of bots
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotModel> getManyByType(String type) throws IllegalArgumentException
    {
        if (type.equals("")) {
            Logger.error("Error! Bot type is required.");
            throw new IllegalArgumentException("Error! Bot type is required.");
        }

        List<BotModel> items = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("status", status)
            .findList();

        return items;
    }

    /**
     * Delete a Bot
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * BotModel bot = botEntity.getOneBySlug("fred");
     * if( bot != null ){
     *   botEntity.deleteOne(bot);
     * }
     * </pre>
     * @param bot a bot to delete
     * @return Boolean whether bot deleted or not
     */
    public Boolean deleteOne(BotModel bot)
    {
        return Ebean.deletePermanent(bot);
    }

    /**
     * Delete Many Bots
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * List<BotModel> bots =  botEntity.getManyByStatus("running");
     * botEntity.deleteMany(bots);
     * </pre>
     *
     * @param items a list of bots to delete
     * @return Boolean whether bots deleted or not
     */
    public Boolean deleteMany(List<BotModel> items)
    {
        Boolean status = true;

        for(BotModel item : items){
            status &= this.deleteOne(item);
        }

        return status;
    }
}