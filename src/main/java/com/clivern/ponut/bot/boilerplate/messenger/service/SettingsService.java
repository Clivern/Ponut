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
package com.clivern.ponut.bot.boilerplate.messenger.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import com.clivern.ponut.model.BotMetaModel;
import io.ebean.Ebean;

/**
 * Settings Service For Messenger Bot
 *
 * @since 1.0.0
 */
public class SettingsService {

    private static SettingsService instance;

    protected Map<String, String> options;

    /**
     * Class Constructor
     */
    protected SettingsService()
    {
        // Exists only to defeat instantiation.
    }

    /**
     * Get Instance or A new one
     *
     * @return SettingsService
     */
    public static SettingsService instance()
    {
        if(instance == null) {
            instance = new SettingsService();
        }

        return instance;
    }

    /**
     * Get Bot Meta Options
     *
     * @return Map
     */
    public Map<String, String> getOptions()
    {
        List<BotMetaModel> botMetas = Ebean.find(BotMetaModel.class)
            .fetch("key", "value")
            .where()
            .eq("botId", 1)
            .findList();

        Map<String, String> options = new HashMap<String, String>();
        botMetas.forEach((botMeta) -> {
            options.put(botMeta.getKey().replace("bot_", ""), botMeta.getValue());
        });

        this.options = options;

        return this.options;
    }

    /**
     * Get Bot Meta Value
     *
     * @param  key
     * @return String
     */
    public String getOption(String key)
    {
        if( this.options.containsKey(key) ){
            return this.options.get(key);
        }
        return "";
    }
}