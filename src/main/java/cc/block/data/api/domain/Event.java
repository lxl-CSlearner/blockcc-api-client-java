/*
 * Copyright (c) 2020. Block.cc Inc @ https://block.cc.
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
 *
 */

package cc.block.data.api.domain;

import cc.block.data.api.bean.OutputMessage;
import cc.block.data.api.bean.Topic;
import cc.block.data.api.domain.market.OrderBook;
import cc.block.data.api.domain.market.Price;
import cc.block.data.api.domain.market.Ticker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Objects;

/**
 * @author lijiaxing
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event<T> implements OutputMessage {

    /**
     * websocket response message code
     */
    @JsonProperty("code")
    private Integer code;

    /**
     * websocket response message
     */
    @JsonProperty("message")
    private String message;

    /**
     * websocket response topic
     */
    @JsonProperty("topic")
    private String topic;

    /**
     * websocket response data
     */
    @JsonProperty("data")
    private T data;

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", topic='" + topic + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public String toMessageString() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (data == null) {
                return mapper.writeValueAsString(this);
            }
            switch (Objects.requireNonNull(Topic.parse(this.topic)).getType()) {
                case ticker:
                    return mapper.readValue(mapper.writeValueAsString(data), Ticker.class).toString();
                case orderbook:
                    return mapper.readValue(mapper.writeValueAsString(data), OrderBook.class).toString();
                case price:
                    return mapper.readValue(mapper.writeValueAsString(data), Price.class).toString();
                default:
                    return mapper.writeValueAsString(this);
            }
        } catch (IOException e) {
            return "{}";
        }
    }
}
