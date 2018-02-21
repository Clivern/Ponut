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
import com.clivern.ponut.model.OptionModel;
import com.clivern.ponut.module.contract.core.entity.OptionContract;

/**
 * Option Entity Class
 *
 * @since 1.0.0
 */
public class OptionEntity implements OptionContract {

    /**
     * Get Option By ID
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * OptionModel option = optionEntity.getOneById(4);
     * if( option != null ){
     *   Logger.info(option.getId());
     *   Logger.info(option.getKey());
     *   Logger.info(option.getValue());
     *   Logger.info(option.getAutoload());
     *   Logger.info(optionEntity.deleteOne(option));
     * }
     * </pre>
     *
     * @param id the option id
     * @return OptionModel an instance of option model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public OptionModel getOneById(Integer id) throws IllegalArgumentException
    {
        if (id.equals("")) {
            Logger.error("Error! Option id is required.");
            throw new IllegalArgumentException("Error! Option id is required.");
        }

        OptionModel item = Ebean.find(OptionModel.class)
            .select("*")
            .where()
            .eq("id", id)
            .findOne();

        return item;
    }

    /**
     * Get Option By Key
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * OptionModel option = optionEntity.getOneByKey("op_key");
     * if( option != null ){
     *   Logger.info(option.getId());
     *   Logger.info(option.getKey());
     *   Logger.info(option.getValue());
     *   Logger.info(option.getAutoload());
     *   Logger.info(optionEntity.deleteOne(option));
     * }
     * </pre>
     *
     * @param key the option key
     * @return OptionModel an instance of option model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public OptionModel getOneByKey(String key) throws IllegalArgumentException
    {
        if (key.equals("")) {
            Logger.error("Error! Option key is required.");
            throw new IllegalArgumentException("Error! Option key is required.");
        }

        OptionModel item = Ebean.find(OptionModel.class)
            .select("*")
            .where()
            .eq("key", key)
            .findOne();

        return item;
    }

    /**
     * Get Many Options By Key
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * List<OptionModel> options =  optionEntity.getManyByKey("op_duplicate_key");
     * </pre>
     *
     * @param key the option key
     * @return List a list of options
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<OptionModel> getManyByKey(String key) throws IllegalArgumentException
    {
        if (key.equals("")) {
            Logger.error("Error! Option key is required.");
            throw new IllegalArgumentException("Error! Option key is required.");
        }

        List<OptionModel> items = Ebean.find(OptionModel.class)
            .select("*")
            .where()
            .eq("key", key)
            .findList();

        return items;
    }

    /**
     * Get Many Options By Autoload
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * List<OptionModel> options =  optionEntity.getManyByAutoload("on");
     * </pre>
     *
     * @param autoload the option autoload value
     * @return List a list of options
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<OptionModel> getManyByAutoload(String autoload) throws IllegalArgumentException
    {
        if (autoload.equals("")) {
            Logger.error("Error! Option autoload is required.");
            throw new IllegalArgumentException("Error! Option autoload is required.");
        }

        List<OptionModel> items = Ebean.find(OptionModel.class)
            .select("*")
            .where()
            .eq("autoload", autoload)
            .findList();

        return items;
    }

    /**
     * Update Option Value By ID
     *
     * @param value Option Value
     * @param id Option Id
     * @return Boolean whether option updated or not
     */
    public Boolean updateOneValueById(String value, Integer id)
    {
        Integer optionsUpdated = Ebean.update(OptionModel.class)
                .set("value", value)
                .where().eq("id", id)
                .update();

        return (optionsUpdated > 0) ? true : false;
    }

    /**
     * Update Option Value By Key
     *
     * @param value Option Value
     * @param key Option Key
     * @return Boolean whether option updated or not
     */
    public Boolean updateOneValueByKey(String value, String key)
    {
        Integer optionsUpdated = Ebean.update(OptionModel.class)
                .set("value", value)
                .where().eq("key", key)
                .update();

        return (optionsUpdated > 0) ? true : false;
    }

    /**
     * Create a new option
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * Map<String, String> item = new HashMap<String, String>();
     * item.put("key", "_new_key");
     * item.put("value", "_new_value");
     * item.put("autoload", "off");
     * Boolean status = optionEntity.createOne(item);
     * </pre>
     *
     * @param item a list of option data
     * @return Boolean whether option saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException
    {
        Boolean status = true;

        if( !item.containsKey("key") || !item.containsKey("value") ){
            Logger.error("Error! Option key and value are required.");
            throw new IllegalArgumentException("Error! Option key and value are required.");
        }
        if( item.get("key").trim().equals("") ){
            Logger.error("Error! Option key must not equal empty.");
            throw new IllegalArgumentException("Error! Option key must not equal empty.");
        }

        OptionModel optionModel = new OptionModel(
            item.get("key").trim(),
            item.get("value").trim(),
            (item.containsKey("autoload") && (item.get("key").trim().equals("on") || item.get("key").trim().equals("off")) ) ? item.get("autoload").trim() : "off"
        );
        optionModel.save();
        status &= (optionModel.getId() > 0) ? true : false;

        return status;
    }

    /**
     * Create many options
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * List<Map<String, String>> items = new ArrayList<Map<String, String>>();
     *
     * Map<String, String> item1 = new HashMap<String, String>();
     * item1.put("key", "item1_key");
     * item1.put("value", "item1_value");
     * item1.put("autoload", "off");
     *
     * Map<String, String> item2 = new HashMap<String, String>();
     * item2.put("key", "item2_key");
     * item2.put("value", "item2_value");
     * item2.put("autoload", "off");
     *
     * items.add(item1);
     * items.add(item2);
     *
     * Boolean status = optionEntity.createMany(items);
     * </pre>
     *
     * @param items a list of options data
     * @return Boolean whether options saved or not
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
     * Delete an Option
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * OptionModel option = optionEntity.getOneById(4);
     * if( option != null ){
     *   Logger.info(optionEntity.deleteOne(option));
     * }
     * </pre>
     * @param item an option to delete
     * @return Boolean whether option deleted or not
     */
    public Boolean deleteOne(OptionModel item)
    {
        return Ebean.deletePermanent(item);
    }

    /**
     * Delete Many Options
     *
     * <pre>
     * OptionEntity optionEntity = new OptionEntity();
     * List<OptionModel> options =  optionEntity.getManyByAutoload("off");
     * Logger.info(optionEntity.deleteMany(options));
     * </pre>
     *
     * @param items a list of options to delete
     * @return Boolean whether options deleted or not
     */
    public Boolean deleteMany(List<OptionModel> items)
    {
        Boolean status = true;

        for(OptionModel item : items){
            status &= this.deleteOne(item);
        }

        return status;
    }
}