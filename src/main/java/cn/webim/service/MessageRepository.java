package cn.webim.service;

import cn.webim.domain.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    @Query(value = "SELECT max(id) FROM Message")
    Long findMaxMessageId();

    List<Message> findByIdGreaterThan(long createTime);
}
