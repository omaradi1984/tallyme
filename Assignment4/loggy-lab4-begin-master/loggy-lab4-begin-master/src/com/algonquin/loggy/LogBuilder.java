package com.algonquin.loggy;

import java.util.Date;
import java.util.UUID;

public interface LogBuilder {

	LogBuilder withName(String name);

	LogBuilder withDescription(String description);

	LogBuilder withDate(Date date);

	LogBuilder withUuid(UUID uuid);

	LogBuilder withCode(String code);

	LogBuilder withAttachment(File attachment);

}