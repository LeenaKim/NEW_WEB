-- 댓글 테이블 생성
 create table t_reply (
    no number(5) primary key,
    board_no number(5) not null,
    content varchar2(1000) not null,
    writer varchar2(200) not null,
    reg_date date default sysdate, 
    constraint t_reply_board_no_fk foreign key(board_no)
    references t_board(no)
    );
    
    -- 댓글 시퀀스 생성
    create sequence seq_t_reply_no nocache;
    
    commit;-- 댓글 테이블 생성

-- t_board 테이블에 댓글카운트 컬럼 추가 
alter table t_board 
    add reply_cnt number(5) default 0;
    
select * from t_reply;

truncate table t_reply;

select * from t_board;