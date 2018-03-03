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
import com.clivern.ponut.model.BotMetaModel;
import com.clivern.ponut.module.contract.core.entity.BotMetaContract;

/**
 * BotMeta Entity Class
 *
 * @since 1.0.0
 */
public class BotMetaEntity implements BotMetaContract {

    /**
     * Get Meta By ID
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * BotMetaModel botMeta = botMetaEntity.getOneById(4);
     * if( botMeta != null ){
     *   botMeta.getId();
     *   botMeta.getBotId();
     *   botMeta.getKey();
     *   botMeta.getValue();
     *   botMeta.getCreated();
     *   botMeta.getUpdated();
     * }
     * </pre>
     *
     * @param id the meta id
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneById(Integer id) throws IllegalArgumentException
    {
        if (id.equals("")) {
            Logger.error("Error! Meta id is required.");
            throw new IllegalArgumentException("Error! Meta id is required.");
        }

        BotMetaModel item = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("id", id)
            .findOne();

        return item;
    }

    /**
     * Get Meta By Key
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * BotMetaModel botMeta = botMetaEntity.getOneByKey("_key");
     * if( botMeta != null ){
     *   botMeta.getId();
     *   botMeta.getBotId();
     *   botMeta.getKey();
     *   botMeta.getValue();
     *   botMeta.getCreated();
     *   botMeta.getUpdated();
     * }
     * </pre>
     *
     * @param key the meta key
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByKey(String key) throws IllegalArgumentException
    {
        if (key.trim().equals("")) {
            Logger.error("Error! Meta key is required.");
            throw new IllegalArgumentException("Error! Meta key is required.");
        }

        BotMetaModel item = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("key", key.trim())
            .findOne();

        return item;
    }

    /**
     * Get Meta By Bot Id
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * BotMetaModel botMeta = botMetaEntity.getOneByBotId(3);
     * if( botMeta != null ){
     *   botMeta.getId();
     *   botMeta.getBotId();
     *   botMeta.getKey();
     *   botMeta.getValue();
     *   botMeta.getCreated();
     *   botMeta.getUpdated();
     * }
     * </pre>
     *
     * @param botId the meta bot id
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByBotId(Integer botId) throws IllegalArgumentException
    {
        if (botId == null || botId <= 0) {
            Logger.error("Error! Meta Bot Id is required.");
            throw new IllegalArgumentException("Error! Meta Bot Id is required.");
        }

        BotMetaModel item = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("botId", botId)
            .findOne();

        return item;
    }

    /**
     * Get Meta By Value
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * BotMetaModel botMeta = botMetaEntity.getOneByValue("_value");
     * if( botMeta != null ){
     *   botMeta.getId();
     *   botMeta.getBotId();
     *   botMeta.getKey();
     *   botMeta.getValue();
     *   botMeta.getCreated();
     *   botMeta.getUpdated();
     * }
     * </pre>
     *
     * @param value the meta value
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByValue(String value) throws IllegalArgumentException
    {
        if (value.trim().equals("")) {
            Logger.error("Error! Meta value is required.");
            throw new IllegalArgumentException("Error! Meta value is required.");
        }

        BotMetaModel item = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("value", value.trim())
            .findOne();

        return item;
    }

    /**
     * Get Meta By Key and Bot Id
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * BotMetaModel botMeta = botMetaEntity.getOneByKeyAndBotId(3, "_key");
     * if( botMeta != null ){
     *   botMeta.getId();
     *   botMeta.getBotId();
     *   botMeta.getKey();
     *   botMeta.getValue();
     *   botMeta.getCreated();
     *   botMeta.getUpdated();
     * }
     * </pre>
     *
     * @param botId the meta bot id
     * @param key the meta key
     * @return BotMetaModel an instance of bot meta model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public BotMetaModel getOneByKeyAndBotId(Integer botId, String key) throws IllegalArgumentException
    {
        if (key.trim().equals("") || botId == null || botId <= 0) {
            Logger.error("Error! Meta key and bot id are required.");
            throw new IllegalArgumentException("Error! Meta key and bot id are required.");
        }

        BotMetaModel item = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("botId", botId)
            .eq("key", key.trim())
            .findOne();

        return item;
    }

    /**
     * Get Many Metas By Key
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * List<BotMetaModel> botsMetas =  botMetaEntity.getManyByKey("_key");
     * </pre>
     *
     * @param key the bot meta key
     * @return List a list of bots metas
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotMetaModel> getManyByKey(String key) throws IllegalArgumentException
    {
        if (key.trim().equals("")) {
            Logger.error("Error! Meta key is required.");
            throw new IllegalArgumentException("Error! Meta key is required.");
        }

        List<BotMetaModel> items = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("key", key.trim())
            .findList();

        return items;
    }

    /**
     * Get Many Metas By Key and Bot Id
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * List<BotMetaModel> botsMetas =  botMetaEntity.getManyByBotIdAndKey(3, "_key");
     * </pre>
     *
     * @param botId the bot id
     * @param key the bot meta key
     * @return List a list of Metas
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotMetaModel> getManyByBotIdAndKey(Integer botId, String key) throws IllegalArgumentException
    {
        if (key.trim().equals("") || botId == null || botId <= 0) {
            Logger.error("Error! Meta key and bot id are required.");
            throw new IllegalArgumentException("Error! Meta key and bot id are required.");
        }

        List<BotMetaModel> items = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("botId", botId)
            .eq("key", key.trim())
            .findList();

        return items;
    }

    /**
     * Get Many Metas By Bot Id
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * List<BotMetaModel> botsMetas =  botMetaEntity.getManyByBotId(3);
     * </pre>
     *
     * @param botId the bot id
     * @return List a list of bots metas
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<BotMetaModel> getManyByBotId(Integer botId) throws IllegalArgumentException
    {
        if (botId == null || botId <= 0) {
            Logger.error("Error! Meta bot id is required.");
            throw new IllegalArgumentException("Error! Meta bot id is required.");
        }

        List<BotMetaModel> items = Ebean.find(BotMetaModel.class)
            .select("*")
            .where()
            .eq("botId", botId)
            .findList();

        return items;
    }

    /**
     * Create a New Meta
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * Map<String, String> item = new HashMap<String, String>();
     * item.put("botId", "_value");
     * item.put("key", "_value");
     * item.put("value", "_value");
     * item.put("created", "_value");
     * item.put("updated", "_value");
     * Boolean status = botMetaEntity.createOne(item);
     * </pre>
     *
     * @param item a list of metas
     * @return Boolean whether meta saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException
    {
        Boolean status = true;
        Date todaysDate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if( !item.containsKey("key") || !item.containsKey("value") || !item.containsKey("botId") ){
            Logger.error("Error! Meta key, value and bot id are required.");
            throw new IllegalArgumentException("Error! Meta key, value and bot id are required.");
        }

        BotMetaModel botMetaModel = new BotMetaModel(
            Integer.parseInt(item.get("botId")),
            item.get("key").trim(),
            item.get("value").trim(),
            (item.containsKey("created") && !item.get("created").trim().equals("")) ? item.get("created").trim() : df.format(todaysDate),
            (item.containsKey("updated") && !item.get("updated").trim().equals("")) ? item.get("updated").trim() : df.format(todaysDate)
        );

        botMetaModel.save();
        status &= (botMetaModel.getId() > 0) ? true : false;

        return status;
    }

    /**
     * Create Many Metas
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * List<Map<String, String>> items = new ArrayList<Map<String, String>>();
     *
     * Map<String, String> item1 = new HashMap<String, String>();
     * item1.put("botId", "_value");
     * item1.put("key", "_value");
     * item1.put("value", "_value");
     * item1.put("created", "_value");
     * item1.put("updated", "_value");
     *
     * Map<String, String> item2 = new HashMap<String, String>();
     * item2.put("botId", "_value");
     * item2.put("key", "_value");
     * item2.put("value", "_value");
     * item2.put("created", "_value");
     * item2.put("updated", "_value");
     *
     * items.add(item1);
     * items.add(item2);
     *
     * Boolean status = botMetaEntity.createMany(items);
     * </pre>
     *
     * @param items a list of metas data
     * @return Boolean whether metas saved or not
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
     * Delete a Meta
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * BotMetaModel botMeta = botMetaEntity.getOneByKeyAndBotId(3, "_meta_key");
     * if( botMeta != null ){
     *   botMetaEntity.deleteOne(botMeta);
     * }
     * </pre>
     * @param botMeta a meta to delete
     * @return Boolean whether meta deleted or not
     */
    public Boolean deleteOne(BotMetaModel botMeta)
    {
        return Ebean.deletePermanent(botMeta);
    }

    /**
     * Delete Metas
     *
     * <pre>
     * BotMetaEntity botMetaEntity = new BotMetaEntity();
     * List<BotMetaModel> botMetas =  botMetaEntity.getManyByBotId(3);
     * botMetaEntity.deleteMany(botMetas);
     * </pre>
     *
     * @param items a list of metas to delete
     * @return Boolean whether metas deleted or not
     */
    public Boolean deleteMany(List<BotMetaModel> items)
    {
        Boolean status = true;

        for(BotMetaModel item : items){
            status &= this.deleteOne(item);
        }

        return status;
    }
}