# coding: utf-8
from sqlalchemy import Column, Integer, String, Text, text, Boolean
from sqlalchemy.ext.declarative import declarative_base


Base = declarative_base()
metadata = Base.metadata


class Article(Base):
    __tablename__ = 'Article'

    id = Column(Integer, primary_key=True)
    authorId = Column(Integer, primary_key=True)
    title = Column(String(128), nullable=False)
    createAt = Column(Integer, nullable=False)
    modifyAt = Column(Integer, nullable=False)
    description = Column(Text, nullable=False)
    content = Column(Text, nullable=False)
    status = Column(Integer, nullable=False)
    clicks = Column(Integer, nullable=False)
    tags = Column(String(512))
    categories = Column(String(64))
    allowComment = Column(Boolean)
    clicks = Column(Integer)


class Comment(Base):
    __tablename__ = 'Comment'

    id = Column(Integer, primary_key=True)
    authorId = Column(Integer, nullable=False)
    parentId = Column(Integer, nullable=False)
    articleId = Column(Integer, nullable=False)
    floor = Column(Integer, nullable=False)
    createAt = Column(Integer, nullable=False)
    content = Column(Text, nullable=False)


class LocalAuth(Base):
    __tablename__ = 'LocalAuth'

    id = Column(Integer, primary_key=True)
    roleId = Column(Integer, nullable=False, server_default=text("'0'"))
    username = Column(String(64), nullable=False, unique=True)
    password = Column(String(256), nullable=False)


class Role(Base):
    __tablename__ = 'Role'

    id = Column(Integer, primary_key=True)
    name = Column(String(32), nullable=False)


class User(Base):
    __tablename__ = 'User'

    id = Column(Integer, primary_key=True)
    username = Column(String(64), nullable=False, unique=True)
    description = Column(String(1024))
    location = Column(String(512))
    registerBy = Column(String(16))
