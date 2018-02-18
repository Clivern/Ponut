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

    //public OptionModel getOne(Map<String, String> where) throws IllegalArgumentException;

    //public List<OptionModel> getMany(Map<String, String> where) throws IllegalArgumentException;

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

    //public Boolean updateOne(Map<String, String> where, Map<String, String> data) throws IllegalArgumentException;

    //public Boolean updateOne(OptionModel item, Map<String, String> data) throws IllegalArgumentException;

    //public Boolean deleteOne(Map<String, String> where) throws IllegalArgumentException;

    //public Boolean deleteMany(Map<String, String> where) throws IllegalArgumentException;

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