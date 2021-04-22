package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Member1;
import org.zerock.guestbook.entity.Member2;

public interface Member2Repository extends JpaRepository<Member2, Long>
, QuerydslPredicateExecutor<Member2>{


}