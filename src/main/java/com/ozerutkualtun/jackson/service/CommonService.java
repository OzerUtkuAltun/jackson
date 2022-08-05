package com.ozerutkualtun.jackson.service;

import com.ozerutkualtun.jackson.model.*;

public interface CommonService {

    String serializeTypeEnumWithValueUsingJsonValue(TypeEnum typeEnum);

    String serializeUserUsingJsonRootName(User user);

    String serializeEventWithDateSerializerUsingJsonSerialize();

    User deserializeUserUsingJacksonInject();

    Water deserializeWaterUsingJsonSetter(String json);

    EventWithSerializer deserializeEventWithDateSerializerUsingJsonDeserialize(String json);

    String serializeHouse(House house);

    String serializeZooWithDog();

    String serializeZooWithCat();

    Zoo deserializeZoo();
}
