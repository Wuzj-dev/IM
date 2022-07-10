/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.han.common.utils;

import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Time util
 *
 * @author Nacos
 */
@NoArgsConstructor
public class TimeUtils {
    /**
     * 获取当前时间
     * 格式类型：2015-06-25 09:13:43.561
     *
     * @return the Timestamp
     */
    public static Timestamp curTimestampCur() {
        return new java.sql.Timestamp(System.currentTimeMillis());
    }

    public static Date toDate(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return new Date(timestamp.getTime());
    }

    public static Timestamp toTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 获取当前时间
     *
     * @return the LocalDateTime
     */
    public static LocalDateTime curLocalDateTime() {
        return LocalDateTime.now();
    }


}
