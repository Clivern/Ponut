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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.clivern.ponut.model.BotModel;
import com.clivern.ponut.module.contract.core.entity.BotContract;
import com.clivern.ponut.module.service.utils.SlugService;

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
        if (slug.trim().equals("")) {
            Logger.error("Error! Bot slug is required.");
            throw new IllegalArgumentException("Error! Bot slug is required.");
        }

        BotModel item = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("slug", slug.trim())
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
        if (name.trim().equals("")) {
            Logger.error("Error! Bot name is required.");
            throw new IllegalArgumentException("Error! Bot name is required.");
        }

        BotModel item = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("name", name.trim())
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
        if (isDefault.trim().equals("")) {
            Logger.error("Error! Bot is default is required.");
            throw new IllegalArgumentException("Error! Bot is default is required.");
        }

        BotModel item = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("isDefault", isDefault.trim())
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
        if (status.trim().equals("")) {
            Logger.error("Error! Bot status is required.");
            throw new IllegalArgumentException("Error! Bot status is required.");
        }

        List<BotModel> items = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("status", status.trim())
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
        if (type.trim().equals("")) {
            Logger.error("Error! Bot type is required.");
            throw new IllegalArgumentException("Error! Bot type is required.");
        }

        List<BotModel> items = Ebean.find(BotModel.class)
            .select("*")
            .where()
            .eq("type", type.trim())
            .findList();

        return items;
    }

    /**
     * Create a New Bot
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * Map<String, String> item = new HashMap<String, String>();
     * item.put("name", "_value");
     * item.put("slug", "_value");
     * item.put("status", "_value");
     * item.put("type", "_value");
     * item.put("isDefault", "_value");
     * item.put("created", "_value");
     * item.put("updated", "_value");
     * Boolean status = botEntity.createOne(item);
     * </pre>
     *
     * @param item a list of bot data
     * @return Boolean whether bot saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException
    {
        Boolean status = true;
        Date todaysDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if( !item.containsKey("name") || !item.containsKey("status") || !item.containsKey("type") ){
            Logger.error("Error! Bot name, status and type are required.");
            throw new IllegalArgumentException("Error! Bot name, status and type are required.");
        }

        BotModel botModel = new BotModel(
            item.get("name").trim(),
            SlugService.makeSlug(item.get("name").trim()),
            item.get("status").trim(),
            item.get("type").trim(),
            (item.containsKey("isDefault")) ? item.get("isDefault") : "no",
            (item.containsKey("created") && !item.get("created").trim().equals("")) ? item.get("created").trim() : df.format(todaysDate),
            (item.containsKey("updated") && !item.get("updated").trim().equals("")) ? item.get("updated").trim() : df.format(todaysDate)
        );

        botModel.save();
        status &= (botModel.getId() > 0) ? true : false;

        return status;
    }

    /**
     * Create Many Bots
     *
     * <pre>
     * BotEntity botEntity = new BotEntity();
     * List<Map<String, String>> items = new ArrayList<Map<String, String>>();
     *
     * Map<String, String> item1 = new HashMap<String, String>();
     * item1.put("name", "_value");
     * item1.put("slug", "_value");
     * item1.put("status", "_value");
     * item1.put("type", "_value");
     * item1.put("isDefault", "_value");
     * item1.put("created", "_value");
     * item1.put("updated", "_value");
     *
     * Map<String, String> item2 = new HashMap<String, String>();
     * item2.put("name", "_value");
     * item2.put("slug", "_value");
     * item2.put("status", "_value");
     * item2.put("type", "_value");
     * item2.put("isDefault", "_value");
     * item2.put("created", "_value");
     * item2.put("updated", "_value");
     *
     * items.add(item1);
     * items.add(item2);
     *
     * Boolean status = botEntity.createMany(items);
     * </pre>
     *
     * @param items a list of bots data
     * @return Boolean whether bots saved or not
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