# chat

> v1.0.0

Base URLs:

* <a href="http://localhost">开发环境: http://localhost</a>

# 示例项目

## POST 聊天模块

### 请求参数

| 名称        | 位置  | 类型   | 必选 | 说明               |
| ----------- | ----- | ------ | ---- | ------------------ |
| userMessage | query | string | 是   | 用户输入的自然语言 |

> 返回示例

POST /api/chat

userMessage：你好呀！

> 成功

```json
{
    "code": 200,
    "message": null,
    "data": [
        {
            "role": "assistant",
            "content": "你好！有什么我可以帮助你的吗？"
        }
    ]
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |

### 返回数据结构

状态码 **200**

| 名称 | 类型 | 必选 | 约束 | 中文名 | 说明 |
| ---- | ---- | ---- | ---- | ------ | ---- |



## POST 表结构+聊天模块

### 请求参数

| 名称        | 位置  | 类型   | 必选 | 说明               |
| ----------- | ----- | ------ | ---- | ------------------ |
| Schema      | query | string | 是   | 表结构             |
| userMessage | query | string | 是   | 用户输入的自然语言 |

> 返回示例

POST /api/sqlchat

Schema：

```sql
create table sys_user
(
    id          bigint auto_increment comment '会员id'
        primary key,
    username    varchar(20) default ''                not null comment '用户名',
    password    varchar(32) default ''                not null comment '密码',
    name        varchar(50)                           null comment '姓名',
    phone       varchar(11)                           null comment '手机',
    head_url    varchar(200)                          null comment '头像地址',
    dept_id     bigint                                null comment '部门id',
    post_id     bigint                                null comment '岗位id',
    open_id     varchar(255)                          null comment '微信openId',
    description varchar(255)                          null comment '描述',
    status      tinyint(3)                            null comment '状态（1：正常 0：停用）',
    create_time timestamp   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted  tinyint(3)  default 0                 not null comment '删除标记（0:不可用 1:可用）',
    constraint idx_username
        unique (username)
)
    comment '用户表';
```

userMessage：查询该表的用户名有多少个

> 成功

```json
{
    "code": 200,
    "message": null,
    "data": [
        {
            "role": "assistant",
            "content": "SELECT COUNT(DISTINCT username) FROM sys_user;"
        }
    ]
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |
