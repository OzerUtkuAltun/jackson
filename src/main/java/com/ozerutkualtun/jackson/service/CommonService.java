package com.ozerutkualtun.jackson.service;

import com.ozerutkualtun.jackson.model.EventWithSerializer;
import com.ozerutkualtun.jackson.model.TypeEnum;
import com.ozerutkualtun.jackson.model.User;
import com.ozerutkualtun.jackson.model.Water;

public interface CommonService {

    String serializeTypeEnumWithValueUsingJsonValue(TypeEnum typeEnum);

    String serializeUserUsingJsonRootName(User user);

    String serializeEventWithDateSerializerUsingJsonSerialize();

    User deserializeUserUsingJacksonInject();

    Water deserializeWaterUsingJsonSetter(String json);

    EventWithSerializer deserializeEventWithDateSerializerUsingJsonDeserialize(String json);

}
