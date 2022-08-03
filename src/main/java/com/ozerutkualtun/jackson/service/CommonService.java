package com.ozerutkualtun.jackson.service;

import com.ozerutkualtun.jackson.model.TypeEnum;
import com.ozerutkualtun.jackson.model.User;

public interface CommonService {

    String serializeTypeEnumWithValueUsingJsonValue(TypeEnum typeEnum);

    String serializeUserUsingJsonRootName(User user);
}
