package org.zerock.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember2 is a Querydsl query type for Member2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember2 extends EntityPathBase<Member2> {

    private static final long serialVersionUID = 894542478L;

    public static final QMember2 member2 = new QMember2("member2");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath email = createString("email");

    public final StringPath idno = createString("idno");

    public final NumberPath<Long> mno = createNumber("mno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QMember2(String variable) {
        super(Member2.class, forVariable(variable));
    }

    public QMember2(Path<? extends Member2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember2(PathMetadata metadata) {
        super(Member2.class, metadata);
    }

}

