CREATE TABLE IF NOT EXISTS public.quizquestion
(
    id bigserial not null primary key,
    question text,
    image text
);

CREATE TABLE IF NOT EXISTS public.quizresponse
(
    id bigserial not null primary key,
    response integer NOT NULL,
    description text ,
    question_id bigint,
    CONSTRAINT id FOREIGN KEY (question_id)
        REFERENCES public.quizquestion (id) MATCH SIMPLE
);
alter table quizquestion add column response_id bigint;
alter table quizquestion add constraint response_id foreign key (response_id) references quizresponse (id);
update quizquestion set question='Preta Gil' where id=31;

CREATE TABLE IF NOT EXISTS public.userresponse
(
    id bigserial not null primary key,
    response_id bigint,
    question_id bigint,
    CONSTRAINT userresponse_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES public.quizquestion (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT userresponse_response_id_fkey FOREIGN KEY (response_id)
        REFERENCES public.quizresponse (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

insert into quizresponse (response, description) values (1, 'negro');
insert into quizresponse (response, description) values (2, 'pardo');
insert into quizresponse (response, description) values (3, 'branco');
insert into quizresponse (response, description) values (4, 'indígena');