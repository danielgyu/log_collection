package com.hismayfly.restlog;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface LogRepository extends MongoRepository<LogMessage, String> {
}
