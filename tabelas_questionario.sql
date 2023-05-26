create table QuizQuestion(id bigserial not null primary key, responseId integer references QuizResponse(id));
create table QuizResponse(id bigserial not null primary key, response integer not null);

update quizquestion set question='Preta Gil' where id=31;