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
import com.clivern.ponut.model.OptionModel;
import com.clivern.ponut.module.contract.core.entity.OptionContract;

/**
 * Option Entity Class
 *
 * @since 1.0.0
 */
public class OptionEntity implements OptionContract {

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
     * @param Map a list of option data
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
     * @param List a list of options data
     * @return Boolean whether option saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createMany(List<Map<String, String>> items) throws IllegalArgumentException
    {
        Boolean status = true;

        for(Map<String, String> item : items){
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
        }

        return status;
    }
}