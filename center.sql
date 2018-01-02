CREATE TABLE `device` (
  `id` bigint(18) NOT NULL COMMENT '统一ID',
  `binding` int(11) NOT NULL DEFAULT '0' COMMENT '1，绑定；0，不绑定',
  `create_time` datetime NOT NULL COMMENT '入库时间',
  `first_Login_Time` datetime DEFAULT NULL COMMENT '第一次登录时间，留存计算使用',
  `channal_id` varchar(45) DEFAULT NULL COMMENT '渠道号',
  `imei` varchar(45) DEFAULT NULL,
  `imsi` varchar(45) DEFAULT NULL,
  `serialno` varchar(45) DEFAULT NULL,
  `phoneno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表'

CREATE TABLE `script` (
  `id` int(11) NOT NULL COMMENT '脚本编号',
  `type` int(11) DEFAULT NULL COMMENT '脚本类型',
  `play_time` float DEFAULT NULL COMMENT '播放时长',
  `location` varchar(45) DEFAULT NULL COMMENT '脚本地址',
  `comment` varchar(200) DEFAULT NULL COMMENT '脚本说明',
  `create_time` datetime DEFAULT NULL COMMENT '脚本创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='脚本表'

CREATE TABLE `task` (
  `id` varchar(20) NOT NULL COMMENT '任务流水号',
  `device_id` bigint(18) NOT NULL COMMENT '设备编号',
  `operation` int(11) NOT NULL COMMENT '操作 1，注册；2，登录；3，其他',
  `script_id` int(11) DEFAULT NULL COMMENT '对应脚本号',
  `download_url` varchar(100) DEFAULT NULL COMMENT '下载地址',
  `status` int(11) DEFAULT NULL COMMENT '状态：0，新建；1，执行中；2，执行成功，3，执行失败',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间，Server端生成任务的时间',
  `valid_time` datetime DEFAULT NULL COMMENT '生效时间',
  `invalid_time` datetime DEFAULT NULL COMMENT '失效时间',
  `execute_time` datetime DEFAULT NULL COMMENT '执行时间，对方调用接口开始执行的时间。',
  `result_time` datetime DEFAULT NULL COMMENT '结果时间，得到对方返回结果的时间。',
  `ip` varchar(45) DEFAULT NULL COMMENT '执行任务的IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务表'