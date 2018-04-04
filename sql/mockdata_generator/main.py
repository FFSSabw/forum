# coding: utf-8
import random
from sqlalchemy import Column, String, create_engine
from sqlalchemy.orm import sessionmaker
from faker import Factory
from myblog_entity import *

class mockDataGenerator():

    def __init__(self, language):
        self.fake = Factory().create(language)

    def random_phone_number(self):
        return self.fake.phone_number()

    def random_name(self):
        return self.fake.name()

    def random_address(self):
        return self.fake.addres()

    def random_email(self):
        return self.fake.email()

    def random_ipv4(self):
        return self.fake.ipv4()

    def random_str(self, min_chars = 0, max_chars = 8):
        return self.fake.pystr(min_chars = min_chars, max_chars = max_chars)

    def random_text(self):
        return self.fake.text()

    def random_timestamp(self):
        return self.fake.unix_time(end_datetime=None)

    def random_int(self):
        return self.fake.pyint()

    def random_bool(self):
        return self.fake.pybool()

    def random_description(self):
        return self.fake.paragraph(nb_sentences=3, variable_nb_sentences=True, ext_word_list=None)

    def random_title(self):
        return self.fake.sentence(nb_words=6, variable_nb_words=True, ext_word_list=None)

    def random_type(self):
        i = random.randint(0, 10)
        if i == 0:
            type_ = '前端'
        else:
            type_ = '后端'

        return type_

if __name__ == '__main__':
    engine = create_engine('mysql+pymysql://root:tobebest@localhost:3306/myblog?charset=utf8')
    DBSession = sessionmaker(bind=engine)
    session = DBSession()

    gen = mockDataGenerator('en_US')

    for i in range(100):
        temp = Article(authorId = 100001,
                        title = gen.random_title(),
                        createAt = gen.random_timestamp(),
                        modifyAt = gen.random_timestamp(),
                        description = gen.random_description(),
                        content = gen.random_text(),
                        status = gen.random_bool(),
                        clicks = gen.random_int(),
                        categories = gen.random_type(),
                        tags = 'python,java,后端',
                        allowComment = gen.random_bool())
        print(temp)
        session.add(temp)

    session.commit()
    session.close()