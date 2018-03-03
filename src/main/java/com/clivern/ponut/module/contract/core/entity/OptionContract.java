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
import com.clivern.ponut.model.OptionModel;

/**
 * Option Entity Contract Interface
 *
 * @since 1.0.0
 */
public interface OptionContract {

    /**
     * Get Option By ID
     *
     * @param id the option id
     * @return OptionModel an instance of option model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public OptionModel getOneById(Integer id) throws IllegalArgumentException;

    /**
     * Get Option By Key
     *
     * @param key the option key
     * @return OptionModel an instance of option model
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public OptionModel getOneByKey(String key) throws IllegalArgumentException;

    /**
     * Get Many Options By Key
     *
     * @param key the option key
     * @return List a list of options
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<OptionModel> getManyByKey(String key) throws IllegalArgumentException;

    /**
     * Get Many Options By Autoload
     *
     * @param autoload the option autoload value
     * @return List a list of options
     * @throws IllegalArgumentException in case invalid parameters passed
     */
    public List<OptionModel> getManyByAutoload(String autoload) throws IllegalArgumentException;

    /**
     * Update Option Value By ID
     *
     * @param value Option Value
     * @param id Option Id
     * @return Boolean whether option updated or not
     */
    public Boolean updateOneValueById(String value, Integer id);

    /**
     * Update Option Value By Key
     *
     * @param value Option Value
     * @param key Option Key
     * @return Boolean whether option updated or not
     */
    public Boolean updateOneValueByKey(String value, String key);

    /**
     * Create a new option
     *
     * @param item a list of option data
     * @return Boolean whether option saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createOne(Map<String, String> item) throws IllegalArgumentException;

    /**
     * Create many options
     *
     * @param items a list of options data
     * @return Boolean whether option saved or not
     * @throws IllegalArgumentException in case invalid arguments provided
     */
    public Boolean createMany(List<Map<String, String>> items) throws IllegalArgumentException;

    /**
     * Delete an Option
     *
     * @param item an option to delete
     * @return Boolean whether option deleted or not
     */
    public Boolean deleteOne(OptionModel item);

    /**
     * Delete Many Options
     *
     * @param items a list of options to delete
     * @return Boolean whether options deleted or not
     */
    public Boolean deleteMany(List<OptionModel> items);

}