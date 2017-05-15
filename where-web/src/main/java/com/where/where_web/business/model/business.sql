--商家管理表的创建


--创建商品分类表
create table goods_category(
	id number(9) primary key,  --商品分类id
	name varchar2(20) unique , --商品分类名,而且名字必须唯一
	sort number(5),             --商品分类排序
	shop_id number(9),
	constraint fk_goods_category_shop foreign key(shop_id) references shop(id) on delete cascade    --外键
);

--商品分类表序列
create sequence seq_goods_category
	increment by 1
	start with 1
	maxvalue 999999999;
--商品分类表触发器
create or replace trigger tri_goods_category
	before insert on goods_category for each row
	begin
		if :new.id is null then
		select seq_goods_category.nextval into :new.id from dual;
		end if;
	end;
	/
	
--创建评论表
create table comments(
	id number(9) primary key,--评论表id
	content varchar2(100),  --评论内容
	comment_time varchar2(20) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),--评论时间,该类型原本为dateTamp
	                                               --后因为dateTamp时间类型不容易数据处理，改为varchar2类型
	users_id number(9) not null, --关联用户表id
	shop_id number(9),
	constraint fk_shop_comment  foreign key(shop_id) references shop(id)--外键
	constraint fk_users_comment  foreign key(users_id) references users(id)--外键
);

--评论表序列
create sequence seq_comments
	increment by 1
	start with 1
	maxvalue 999999999;
--评论表触发器
create or replace trigger tri_comments
	before insert on comments for each row
	begin
		if :new.id is null then
		select seq_comments.nextval into :new.id from dual;
		end if;
	end;
	/
	
--创建商品表
create table goods(
	id number(9) primary key,--商品表id
	name varchar2(20) unique,--商品名
	price number(5,2),       --商品价格
	sort number(5),          --商品排序
	repertory varchar2(10),   --商品库存
	goods_category_id number(9),  --关联商品分类表id
	shop_id number(9),
	constraint fk_goods_shop foreign key(shop_id) references shop(id) on delete cascade    --外键
	constraint fk_goods_category foreign key(goods_category_id) references goods_category(id)--外键
);

--商品表序列
create sequence seq_goods
	increment by 1
	start with 1
	maxvalue 999999999;
--商品表触发器
create or replace trigger tri_goods
	before insert on goods for each row
	begin
		if :new.id is null then
		select seq_goods.nextval into :new.id from dual;
		end if;
	end;
	/
	
--创建店铺表
create table shop(
	id number(9) primary key,
	name varchar2(40),
	status varchar2(10),
	address varchar2(100),
	business_id number(5),
	constraint fk_shop_business foreign key(business_id) references business(id) on delete cascade --外键
);
--创建店铺表序列	
create sequence seq_shop
	increment by 1
	start with 1
	nocache
	maxvalue 999999999;
--店铺表触发器	
create or replace trigger tri_shop
	before insert on shop for each row
	begin
		if :new.id is null then
		select seq_shop.nextval into :new.id from dual;
		end if;
	end;
	/
	
--商铺分类表由后台管理员管理	
create table shop_category(
	id number(9) primary key,
	name varchar2(40),
	sort number(5)
);
create sequence seq_shop_category
	increment by 1
	start with 1
	nocache
	maxvalue 999999999;
create or replace trigger tri_shop_category
	before insert on shop_category for each row
	begin
		if :new.id is null then
		select seq_shop_category.nextval into :new.id from dual;
		end if;
	end;
	/
	
	
--商铺和商铺分类的中间表
create table shop_category_shop(
	id number(9) primary key,
	shop_category_id number(9),
	shop_id number(9),
	constraint fk_shop_category_shop foreign key(shop_category_id) references shop_category(id) on delete cascade
);

create sequence seq_shop_category_shop
	increment by 1
	start with 1
	nocache
	maxvalue 999999999;
create or replace trigger tri_shop_category_shop
	before insert on shop_category_shop for each row
	begin
		if :new.id is null then
		select seq_shop_category_shop.nextval into :new.id from dual;
		end if;
	end;
	/
	
	
--店铺图片表
create table shop_picture(
	id number(9) primary key,
	name varchar2(40),
	url varchar2(100),
	file_size number(9),
	suffix_name varchar2(10),
	shop_id number(9),
	constraint fk_shop_picture foreign key(shop_id) references shop(id) on delete cascade
);
create sequence seq_shop_picture
	increment by 1
	start with 1
	nocache
	maxvalue 999999999;
create or replace trigger tri_shop_picture
	before insert on shop_picture for each row
	begin
		if :new.id is null then
		select seq_shop_picture.nextval into :new.id from dual;
		end if;
	end;
	/
	
--店铺地址表
create table shop_address(
	id number(9) primary key,
	province varchar2(20),
	city varchar2(20),
	county varchar2(20),
	specific_address varchar2(100),
	coordinate varchar2(40),
	shop_id number(9),
	constraint fk_shop_address foreign key(shop_id) references shop(id) on delete cascade
);
create sequence seq_shop_address
	increment by 1
	start with 1
	nocache
	maxvalue 999999999;
create or replace trigger tri_shop_address
	before insert on shop_address for each row
	begin
		if :new.id is null then
		select seq_shop_address.nextval into :new.id from dual;
		end if;
	end;
	/
	
--创建地区表
create table area(
	id number(9) primary key,
	code number(9),
	parentcode number(9),
	name varchar2(50),
	Levelcount number(9),
	Latitude varchar2(50),
	Longitude varchar2(50)
);


--创建订单表
create table orders(
	id number(9) primary key,
	order_time varchar2(20) default to_char(sysdate,'yyyy-mm-dd'),
	status number(5),
	total_price number(8,2),
	users_id number(9),
	delivery_address_id number(9),
	remarks varchar2(100),
	business_id number(9),
	constraint fk_order_users foreign key(users_id) references users(id),
	constraint fk_order_business foreign key(business_id) references business(id)
);


create sequence seq_orders
	increment by 1
	start with 1
	nocache
	maxvalue 999999999;
create or replace trigger tri_orders
	before insert on orders for each row
	begin
		if :new.id is null then
		select seq_orders.nextval into :new.id from dual;
		end if;
	end;
	/
	










	
		