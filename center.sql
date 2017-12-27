CREATE TABLE `center`.`device` (
  `id` BIGINT(18) NOT NULL COMMENT '统一ID',
  `binding` INT NOT NULL DEFAULT 0 COMMENT '1，绑定；0，不绑定',
  `create_time` DATETIME NOT NULL COMMENT '入库时间',
  `first_login_time` DATETIME NULL COMMENT '第一次登录时间，留存计算使用',
  `channal_ld` VARCHAR(45) NULL COMMENT '渠道号',
  PRIMARY KEY (`id`))
COMMENT = '设备表';




CREATE TABLE `center`.`task` (
  `id` VARCHAR(20) NOT NULL COMMENT '任务流水号',
  `device_id` BIGINT(18) NOT NULL COMMENT '设备编号',
  `operation` INT NOT NULL COMMENT '操作 1，注册；2，登录；3，其他',
  `script_id` INT NULL COMMENT '对应脚本号',
  `download_url` VARCHAR(45) NULL COMMENT '下载地址',
  `status` INT NULL COMMENT '状态：0，新建；1，执行中；2，执行成功，3，执行失败',
  `create_time` DATETIME NULL COMMENT '创建时间，Server端生成任务的时间',
  `valid_time` DATETIME NULL COMMENT '生效时间',
  `invalid_time` DATETIME NULL COMMENT '失效时间',
  `execute_time` DATETIME NULL COMMENT '执行时间，对方调用接口开始执行的时间。',
  `result_time` DATETIME NULL COMMENT '结果时间，得到对方返回结果的时间。',
  `ip` VARCHAR(45) NULL COMMENT '执行任务的IP',
  PRIMARY KEY (`id`))
COMMENT = '任务表';



CREATE TABLE `center`.`script` (
  `id` INT NOT NULL COMMENT '脚本编号',
  `type` INT NULL COMMENT '脚本类型',
  `play_time` FLOAT NULL COMMENT '播放时长',
  `location` VARCHAR(45) NULL COMMENT '脚本地址',
  `comment` VARCHAR(200) NULL COMMENT '脚本说明',
  `create_time` DATETIME NULL COMMENT '脚本创建时间',
  PRIMARY KEY (`id`))
COMMENT = '脚本表';
