DROP TABLE admin_user;
CREATE TABLE admin_user(
   	ID           int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
   	staff_id     varchar(20) DEFAULT NULL COMMENT '员工工号',
   	username     varchar(10) DEFAULT NULL COMMENT '用户姓名',
   	msisdn       varchar(20) DEFAULT NULL COMMENT '手机号',
   	email        varchar(40) DEFAULT NULL COMMENT '邮箱',
   	admin_pwd    varchar(100) DEFAULT NULL COMMENT '管理员登录密码',
   	salt varchar(10) DEFAULT NULL COMMENT '密码哈希的加盐',
   	department   varchar(20) DEFAULT NULL COMMENT '部门',
   	position     varchar(20) DEFAULT NULL COMMENT '职位',
   	user_role    tinyint DEFAULT NULL COMMENT '用户角色（0|系统管理员1条，1|统一认证管理员，2|企业管理员）',
   	create_id 	 int UNSIGNED DEFAULT NULL COMMENT '创建者',
   	update_id 	 int UNSIGNED DEFAULT NULL COMMENT '更新者',
  	create_time  datetime DEFAULT NULL COMMENT '创建时间',
  	update_time  datetime DEFAULT NULL COMMENT '更新时间',
  	is_deleted 	 tinyint DEFAULT NULL COMMENT '删除标识，0|未删除，1|删除',
 	PRIMARY KEY (ID)
) 	ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='管理员表';













