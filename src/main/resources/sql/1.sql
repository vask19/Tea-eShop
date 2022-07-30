create sequence bucket_seq start 1 increment 1
create table bucket_products (bucket_id int8 not null, product_id int8 not null)
create table buckets (id int8 not null, user_id int4, primary key (id))
create table categories (id int8 generated by default as identity, title varchar(255), primary key (id))
create table product (id int8 generated by default as identity, details_id int8, primary key (id))
create table product_details (id int8 generated by default as identity, price float8, title varchar(255), product_id int8, primary k
    create table
        products_categories (product_id int8 not null, category_id int8 not null)
    create table users
    (id int4 generated by default as identity, is_active boolean not null, name varchar(255), password varchar(255),
    alter table if exists bucket_products add constraint FK3dwp02gip9thr6eec4qyst3r8 foreign key (product_id) references product
    alter table if exists bucket_products add constraint FKt11v7b7hocd7iprbkn3v0cui5 foreign key (bucket_id) references buckets
    alter table if exists buckets add constraint FKnl0ltaj67xhydcrfbq8401nvj foreign key (user_id) references users
    alter table if exists product add constraint FKejcghm571jmei7ai8or064bkb foreign key (details_id) references product_details
    alter table if exists product_details add constraint FKrhahp4f26x99lqf0kybcs79rb foreign key (product_id) references product
    alter table if exists products_categories add constraint FKqt6m2o5dly3luqcm00f5t4h2p foreign key (category_id) references categories
    alter table if exists products_categories add constraint FKt1s2ikavb75cb1b60jvvmjqr5 foreign key (product_id) references product