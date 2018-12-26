drop table sys_base_config;
create table sys_base_config
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    system_name character varying(200),
    copyright character varying(200),
    web_site character varying(255),
    allow_upload_image character varying(200),
    allow_upload_file character varying(200),
    allow_upload_media character varying(200),
    allow_upload_flash character varying(100),
    keywords character varying(500),
    description character varying(500),
    primary key (id)
) with (oids = false);
comment on table sys_base_config is '数字字典';
comment on column sys_base_config.id is '流水号';
comment on column sys_base_config.create_time is '创建时间';
comment on column sys_base_config.update_time is '更新时间';
comment on column sys_base_config.flag is '标记';
comment on column sys_base_config.status is '状态';
comment on column sys_base_config.system_name is '系统名称';
comment on column sys_base_config.copyright is '版本所有';
comment on column sys_base_config.web_site is '网址';
comment on column sys_base_config.allow_upload_image is '允许上传的图片扩展名';
comment on column sys_base_config.allow_upload_file is '允许上传的文件扩展名';
comment on column sys_base_config.allow_upload_media is '允许上传的媒体扩展名';
comment on column sys_base_config.allow_upload_flash is '允许上传的FLASH扩展名';
comment on column sys_base_config.keywords is '关键字，多个用英文“,”分隔';
comment on column sys_base_config.description is '描述，网站（系统描述）';


drop table sys_login_log;
create table sys_login_log
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    username character varying(50),
    ip_address character varying(50),
    request_time timestamp without time zone,
    sessionid character varying(50),
    device_type character varying(50),
    browser_type character varying(50),
    login_state boolean,
    caption character varying(300),
    primary key (id)
) with (oids = false);
comment on table sys_login_log is '数字字典';
comment on column sys_login_log.id is '流水号';
comment on column sys_login_log.create_time is '创建时间';
comment on column sys_login_log.update_time is '更新时间';
comment on column sys_login_log.flag is '标记';
comment on column sys_login_log.status is '状态';
comment on column sys_login_log.username is '用户名';
comment on column sys_login_log.ip_address is 'IP地址';
comment on column sys_login_log.request_time is '请求时间';
comment on column sys_login_log.sessionid is '会话ID';
comment on column sys_login_log.device_type is '设备类型';
comment on column sys_login_log.browser_type is '浏览器类型';
comment on column sys_login_log.login_state is '登录状态';
comment on column sys_login_log.caption is '备注';

drop table base_dictionary;
create table base_dictionary
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    code character varying(50) not null,
    name character varying(50) not null,
    caption character varying(300),
    show_state boolean default false,
    primary key (id)
) with (oids = false);
comment on table base_dictionary is '数字字典';
comment on column base_dictionary.id is '流水号';
comment on column base_dictionary.create_time is '创建时间';
comment on column base_dictionary.update_time is '更新时间';
comment on column base_dictionary.flag is '标记';
comment on column base_dictionary.status is '状态';
comment on column base_dictionary.code is '字典编号';
comment on column base_dictionary.name is '字典名称';
comment on column base_dictionary.caption is '备注';
comment on column base_dictionary.show_state is '显示状态';

drop table base_dictionary_item;
create table base_dictionary_item
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    dictionary_id uuid,
    item_text character varying(50) not null,
    item_value character varying(50) not null,
    show_state boolean default false,
    serial_number integer default 0,
    primary key (id),
    foreign key (dictionary_id) references base_dictionary(id)
) with (oids = false);
comment on table base_dictionary_item is '数字字典选项';
comment on column base_dictionary_item.id is '流水号';
comment on column base_dictionary_item.create_time is '创建时间';
comment on column base_dictionary_item.update_time is '更新时间';
comment on column base_dictionary_item.flag is '标记';
comment on column base_dictionary_item.status is '状态';
comment on column base_dictionary_item.dictionary_id is '所属字典ID';
comment on column base_dictionary_item.item_text is '选项文本';
comment on column base_dictionary_item.item_value is '选项值';
comment on column base_dictionary_item.show_state is '显示状态';
comment on column base_dictionary_item.serial_number is '排序序号';

drop table department;
create table department
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    category integer,
    code character varying(50) not null,
    name character varying(50) not null,
    phone character varying(15),
    boss_id uuid,
    boss_name character varying(50),
    parent_id uuid,
    primary key (id),
    foreign key (parent_id) references department(id)
) with (oids = false);
comment on table department is '部门信息';
comment on column department.id is '流水号';
comment on column department.create_time is '创建时间';
comment on column department.update_time is '更新时间';
comment on column department.flag is '标记';
comment on column department.status is '状态';
comment on column department.category is '分类：1单位，2部门，3组';
comment on column department.code is '部门编号';
comment on column department.name is '部门名称';
comment on column department.phone is '部门电话';
comment on column department.boss_id is '负责人ID';
comment on column department.boss_name is '负责人姓名';
comment on column department.parent_id is '上级ID';

drop table employee_account;
create table employee_account
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    department_id uuid,
    position_id uuid,
    code character varying(50) not null,
    full_name character varying(50) not null,
    login_password character(40),
    lock_state boolean,
    primary key (id),
    foreign key (department_id) references department(id),
    foreign key (position_id) references base_position(id)
) with (oids = false);

comment on table employee_account is '员工基本信息';
comment on column employee_account.id is '流水号';
comment on column employee_account.create_time is '创建时间';
comment on column employee_account.update_time is '更新时间';
comment on column employee_account.flag is '标记';
comment on column employee_account.department_id is '所属部门ID';
comment on column employee_account.position_id is '所属职务ID';
comment on column employee_account.code is '员工编号';
comment on column employee_account.full_name is '员工姓名';
comment on column employee_account.login_password is '登录密码';
comment on column employee_account.lock_state is '锁定状态';

drop table base_position;
create table base_position
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    code character varying(50) not null,
    name character varying(50) not null,
    caption character varying(300),
    show_state boolean default false,
    serial_number integer default 0,
    primary key (id)
) with (oids = false);
comment on table base_position is '职位信息';
comment on column base_position.id is '流水号';
comment on column base_position.create_time is '创建时间';
comment on column base_position.update_time is '更新时间';
comment on column base_position.flag is '标记';
comment on column base_position.code is '职位编号';
comment on column base_position.name is '职位姓名';
comment on column base_position.caption is '备注';
comment on column base_position.show_state is '显示状态';
comment on column base_position.serial_number is '排序序号';

drop table employee_position;
create table employee_position
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    employee_id uuid,
    position_id uuid,
    primary key (id),
    unique (employee_id, position_id),
    foreign key (employee_id) references employee_account(id),
    foreign key (position_id) references base_position(id)
) with (oids = false);
comment on table employee_position is '员工职位';
comment on column employee_position.id is '流水号';
comment on column employee_position.create_time is '创建时间';
comment on column employee_position.update_time is '更新时间';
comment on column employee_position.flag is '标记';
comment on column employee_position.employee_id is '所属员工ID';
comment on column employee_position.position_id is '所属职位ID';

drop table sys_role;
create table sys_role
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    code character varying(50) not null,
    name character varying(50) not null,
    caption character varying(300),
    show_state boolean default false,
    serial_number integer default 0,
    primary key (id)
) with (oids = false);
comment on table sys_role is '角色信息';
comment on column sys_role.id is '流水号';
comment on column sys_role.create_time is '创建时间';
comment on column sys_role.update_time is '更新时间';
comment on column sys_role.flag is '标记';
comment on column sys_role.code is '角色编号';
comment on column sys_role.name is '角色姓名';
comment on column sys_role.caption is '备注';
comment on column sys_role.show_state is '显示状态';
comment on column sys_role.serial_number is '排序序号';

drop table employee_role;
create table employee_role
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    employee_id uuid,
    role_id uuid,
    primary key (id),
    unique (employee_id, role_id),
    foreign key (employee_id) references employee_account(id),
    foreign key (role_id) references sys_role(id)
) with (oids = false);
comment on table employee_role is '员工角色';
comment on column employee_role.id is '流水号';
comment on column employee_role.create_time is '创建时间';
comment on column employee_role.update_time is '更新时间';
comment on column employee_role.flag is '标记';
comment on column employee_role.status is '状态';
comment on column employee_role.employee_id is '所属员工ID';
comment on column employee_role.role_id is '所属角色ID';

drop table sys_menu;
create table sys_menu
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    code character varying(50) not null,
    name character varying(50) not null,
    href character varying(255),
    category integer,
    icon character varying(100),
    css_class character varying(255),
    css_style character varying(255),
    caption character varying(300),
    show_state boolean default false,
    serial_number integer default 0,
    parent_id uuid,
    primary key (id),
    foreign key (parent_id) references sys_menu(id)
) with (oids = false);
comment on table sys_menu is '系统菜单';
comment on column sys_menu.id is '流水号';
comment on column sys_menu.create_time is '创建时间';
comment on column sys_menu.update_time is '更新时间';
comment on column sys_menu.flag is '标记';
comment on column sys_menu.code is '菜单编号';
comment on column sys_menu.name is '菜单名称';
comment on column sys_menu.href is '链接地址';
comment on column sys_menu.category is '类型：1菜单，2权限';
comment on column sys_menu.icon is '图标';
comment on column sys_menu.css_class is 'html的class属性';
comment on column sys_menu.css_style is 'html的style属性';
comment on column sys_menu.show_state is '显示状态';
comment on column sys_menu.serial_number is '排序序号';
comment on column sys_menu.parent_id is '所属父级ID';

drop table sys_role_menu;
create table sys_role_menu
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    role_id uuid,
    menu_id uuid,
    primary key (id),
    unique (role_id, menu_id),
    foreign key (role_id) references sys_role(id),
    foreign key (menu_id) references sys_menu(id)
) with (oids = false);
comment on table sys_role_menu is '菜色菜单';
comment on column sys_role_menu.id is '流水号';
comment on column sys_role_menu.create_time is '创建时间';
comment on column sys_role_menu.update_time is '更新时间';
comment on column sys_role_menu.flag is '标记';
comment on column sys_role_menu.role_id is '所属角色ID';
comment on column sys_role_menu.menu_id is '所属菜单ID';

drop table sys_role_position;
create table sys_role_position
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    role_id uuid,
    position_id uuid,
    primary key (id),
    unique (role_id, position_id),
    foreign key (role_id) references sys_role(id),
    foreign key (position_id) references base_position(id)
) with (oids = false);
comment on table sys_role_position is '系统角色职务';
comment on column sys_role_position.id is '流水号';
comment on column sys_role_position.create_time is '创建时间';
comment on column sys_role_position.update_time is '更新时间';
comment on column sys_role_position.flag is '标记';
comment on column sys_role_position.role_id is '所属角色ID';
comment on column sys_role_position.position_id is '所属角色ID';

drop table teacher;
create table teacher
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    full_name character varying(50) not null,
    title character varying(50),
    image character varying(100),
    introduction character varying(500),
    description text,
    primary key (id)
) with (oids = false);
comment on table teacher is '教师';
comment on column teacher.id is '流水号';
comment on column teacher.create_time is '创建时间';
comment on column teacher.update_time is '更新时间';
comment on column teacher.flag is '标记';
comment on column teacher.full_name is '姓名';
comment on column teacher.title is '职称';
comment on column teacher.image is '相片';
comment on column teacher.introduction is '简介';
comment on column teacher.description is '描述';

drop table course_type;
create table course_type
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    code character varying(50) not null,
    name character varying(50) not null,
    caption character varying(255),
    parent_id uuid,
    primary key (id),
    foreign key (parent_id) references course_type(id)
) with (oids = false);
comment on table course_type is '课程类型';
comment on column course_type.id is '流水号';
comment on column course_type.create_time is '创建时间';
comment on column course_type.update_time is '更新时间';
comment on column course_type.flag is '标记';
comment on column course_type.code is '编号';
comment on column course_type.name is '名称';
comment on column course_type.caption is '备注';
comment on column course_type.parent_id is '所属课程类型ID';

drop table course;
create table course
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    type_id uuid,
    teacher_id uuid,
    code character varying(50) not null,
    name character varying(200) not null,
    introduction character varying(500),
    description text,
    primary key (id),
    foreign key (type_id) references course_type(id),
    foreign key (teacher_id) references teacher(id)
) with (oids = false);
comment on table course is '课程';
comment on column course.id is '流水号';
comment on column course.create_time is '创建时间';
comment on column course.update_time is '更新时间';
comment on column course.flag is '标记';
comment on column course.type_id is '类型ID';
comment on column course.teacher_id is '教师ID';
comment on column course.code is '编号';
comment on column course.name is '名称';
comment on column course.introduction is '介绍';
comment on column course.description is '描述';

drop table course_video;
create table course_video
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    name character varying(200) not null,
    image character varying(100) not null,
    file_name character varying(300),
    file_path character varying(150),
    file_type character varying(10),
    file_size bigint,
    upload_time timestamp without time zone,
    introduction character varying(500),
    description text,
    primary key (id),
    foreign key (course_id) references course(id)
) with (oids = false);
comment on table course_video is '课程视频';
comment on column course_video.id is '流水号';
comment on column course_video.create_time is '创建时间';
comment on column course_video.update_time is '更新时间';
comment on column course_video.flag is '标记';
comment on column course_video.course_id is '课程ID';
comment on column course_video.name is '视频名称';
comment on column course_video.image is '视频图片';
comment on column course_video.file_name is '文件名称';
comment on column course_video.file_path is '文件路径';
comment on column course_video.file_type is '文件类型';
comment on column course_video.file_size is '文件大小';
comment on column course_video.upload_time is '上传时间';
comment on column course_video.introduction is '介绍';
comment on column course_video.description is '描述';

drop table course_attachment;
create table course_attachment
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    file_name character varying(300),
    file_path character varying(100),
    file_type character varying(10),
    file_size bigint,
    upload_time timestamp without time zone,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id)
) with (oids = false);
comment on table course_attachment is '课程视频';
comment on column course_attachment.id is '流水号';
comment on column course_attachment.create_time is '创建时间';
comment on column course_attachment.update_time is '更新时间';
comment on column course_attachment.flag is '标记';
comment on column course_attachment.course_id is '课程ID';
comment on column course_attachment.video_id is '视频ID';
comment on column course_attachment.file_name is '文件名称';
comment on column course_attachment.file_path is '文件路径';
comment on column course_attachment.file_type is '文件类型';
comment on column course_attachment.file_size is '文件大小';
comment on column course_attachment.upload_time is '上传时间';

drop table employee_course_study;
create table employee_course_study
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    employee_id uuid,
    course_id uuid,
    video_id uuid,
    study_time timestamp without time zone,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (employee_id) references employee_account(id),
    foreign key (video_id) references course_video(id)
) with (oids = false);
comment on table employee_course_study is '课程练习题';
comment on column employee_course_study.id is '流水号';
comment on column employee_course_study.create_time is '创建时间';
comment on column employee_course_study.update_time is '更新时间';
comment on column employee_course_study.flag is '标记';
comment on column employee_course_study.employee_id is '员工ID';
comment on column employee_course_study.course_id is '课程ID';
comment on column employee_course_study.video_id is '视频ID';
comment on column employee_course_study.study_time is '学习时间';

drop table employee_course_study_list;
create table employee_course_study_list
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    employee_id uuid,
    course_id uuid,
    video_id uuid,
    study_time timestamp without time zone,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (employee_id) references employee_account(id),
    foreign key (video_id) references course_video(id)
) with (oids = false);
comment on table employee_course_study is '课程练习题';
comment on column employee_course_study.id is '流水号';
comment on column employee_course_study.create_time is '创建时间';
comment on column employee_course_study.update_time is '更新时间';
comment on column employee_course_study.flag is '标记';
comment on column employee_course_study.employee_id is '员工ID';
comment on column employee_course_study.course_id is '课程ID';
comment on column employee_course_study.video_id is '视频ID';
comment on column employee_course_study.study_time is '学习时间';
comment on column employee_course_study.study_amount is '学习次数';

drop table course_exercise;
create table course_exercise
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    title character varying(1000),
    category integer default 1,
    score integer default 1,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id)
) with (oids = false);
comment on table course_exercise is '课程练习题';
comment on column course_exercise.id is '流水号';
comment on column course_exercise.create_time is '创建时间';
comment on column course_exercise.update_time is '更新时间';
comment on column course_exercise.flag is '标记';
comment on column course_exercise.course_id is '课程ID';
comment on column course_exercise.video_id is '视频ID';
comment on column course_exercise.title is '标题';
comment on column course_exercise.category is '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';
comment on column course_exercise.score is '分值';

drop table course_exercise_analysis;
create table course_exercise_analysis
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    content text,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id),
    foreign key (exercise_id) references course_exercise(id)
) with (oids = false);
comment on table course_exercise_analysis is '课程练习题解析';
comment on column course_exercise_analysis.id is '流水号';
comment on column course_exercise_analysis.create_time is '创建时间';
comment on column course_exercise_analysis.update_time is '更新时间';
comment on column course_exercise_analysis.flag is '标记';
comment on column course_exercise_analysis.course_id is '课程ID';
comment on column course_exercise_analysis.video_id is '视频ID';
comment on column course_exercise_analysis.exercise_id is '练习题ID';
comment on column course_exercise_analysis.content is '解析内容';

drop table course_exercise_item;
create table course_exercise_item
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    title character varying(1000),
    is_answer boolean default false,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id),
    foreign key (exercise_id) references course_exercise(id)
) with (oids = false);
comment on table course_exercise_item is '课程练习题选择';
comment on column course_exercise_item.id is '流水号';
comment on column course_exercise_item.create_time is '创建时间';
comment on column course_exercise_item.update_time is '更新时间';
comment on column course_exercise_item.flag is '标记';
comment on column course_exercise_item.course_id is '课程ID';
comment on column course_exercise_item.video_id is '视频ID';
comment on column course_exercise_item.exercise_id is '练习题ID';
comment on column course_exercise_item.title is '标题';
comment on column course_exercise_item.is_answer is '是否参考答案';

drop table course_exercise_answer;
create table course_exercise_answer
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    content text,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id),
    foreign key (exercise_id) references course_exercise(id)
) with (oids = false);
comment on table course_exercise_answer is '课程练习题参考答案（主观题）';
comment on column course_exercise_answer.id is '流水号';
comment on column course_exercise_answer.create_time is '创建时间';
comment on column course_exercise_answer.update_time is '更新时间';
comment on column course_exercise_answer.flag is '标记';
comment on column course_exercise_answer.course_id is '课程ID';
comment on column course_exercise_answer.video_id is '视频ID';
comment on column course_exercise_answer.exercise_id is '练习题ID';
comment on column course_exercise_answer.content is '解析内容';

drop table employee_course_exercise;
create table employee_course_exercise
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    employee_id uuid,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    title  character varying(1000) not null,
    category integer default 1,
    score integer default 1,
    right_state boolean default false,
    primary key (id),
    foreign key (employee_id) references employee_account(id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id)
) with (oids = false);
comment on table employee_course_exercise is '员工课程练习题';
comment on column employee_course_exercise.id is '流水号';
comment on column employee_course_exercise.create_time is '创建时间';
comment on column employee_course_exercise.update_time is '更新时间';
comment on column employee_course_exercise.flag is '标记';
comment on column employee_course_exercise.employee_id is '员工ID';
comment on column employee_course_exercise.course_id is '课程ID';
comment on column employee_course_exercise.video_id is '视频ID';
comment on column employee_course_exercise.exercise_id is '练习题题目ID';
comment on column employee_course_exercise.title is '练习题题目';
comment on column employee_course_exercise.category is '练习题类型';
comment on column employee_course_exercise.score is '练习题分值';
comment on column employee_course_exercise.right_state is '答对状态';


drop table employee_course_exercise_item;
create table employee_course_exercise_item
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    exercise_id uuid,
    title character varying(1000),
    is_answer boolean default false,
    check_state boolean default false,
    primary key (id),
    foreign key (exercise_id) references employee_course_exercise(id)
) with (oids = false);
comment on table employee_course_exercise_item is '员工课程练习题答题选项';
comment on column employee_course_exercise_item.id is '流水号';
comment on column employee_course_exercise_item.create_time is '创建时间';
comment on column employee_course_exercise_item.update_time is '更新时间';
comment on column employee_course_exercise_item.flag is '标记';
comment on column employee_course_exercise_item.exercise_id is '课程练习题ID';
comment on column employee_course_exercise_item.title is '课程选项标题';
comment on column employee_course_exercise_item.is_answer is '是否为正确答案';
comment on column employee_course_exercise_item.check_state is '勾选状态';

drop table employee_course_exercise_analysis;
create table employee_course_exercise_analysis
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    exercise_id uuid,
    content text,
    primary key (id),
    foreign key (exercise_id) references employee_course_exercise(id)
) with (oids = false);
comment on table employee_course_exercise_analysis is '员工课程练习题解析';
comment on column employee_course_exercise_analysis.id is '流水号';
comment on column employee_course_exercise_analysis.create_time is '创建时间';
comment on column employee_course_exercise_analysis.update_time is '更新时间';
comment on column employee_course_exercise_analysis.flag is '标记';
comment on column employee_course_exercise_analysis.exercise_id is '练习题ID';
comment on column employee_course_exercise_analysis.content is '解析内容';

drop table course_examination;
create table course_examination
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    title character varying(1000),
    category integer default 1,
    score integer default 1,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id)
) with (oids = false);
comment on table course_examination is '课程考试';
comment on column course_examination.id is '流水号';
comment on column course_examination.create_time is '创建时间';
comment on column course_examination.update_time is '更新时间';
comment on column course_examination.flag is '标记';
comment on column course_examination.course_id is '课程ID';
comment on column course_examination.video_id is '视频ID';
comment on column course_examination.title is '标题';
comment on column course_examination.category is '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';
comment on column course_examination.score is '分值';

drop table course_examination_analysis;
create table course_examination_analysis
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    examination_id uuid,
    content text,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id),
    foreign key (examination_id) references course_examination(id)
) with (oids = false);
comment on table course_examination_analysis is '课程考试题解析';
comment on column course_examination_analysis.id is '流水号';
comment on column course_examination_analysis.create_time is '创建时间';
comment on column course_examination_analysis.update_time is '更新时间';
comment on column course_examination_analysis.flag is '标记';
comment on column course_examination_analysis.course_id is '课程ID';
comment on column course_examination_analysis.video_id is '视频ID';
comment on column course_examination_analysis.examination_id is '考试题ID';
comment on column course_examination_analysis.content is '解析内容';

drop table course_examination_item;
create table course_examination_item
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    video_id uuid,
    examination_id uuid,
    title character varying(1000),
    is_answer boolean default false,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (video_id) references course_video(id),
    foreign key (examination_id) references course_examination(id)
) with (oids = false);
comment on table course_examination_item is '课程考试题选择';
comment on column course_examination_item.id is '流水号';
comment on column course_examination_item.create_time is '创建时间';
comment on column course_examination_item.update_time is '更新时间';
comment on column course_examination_item.flag is '标记';
comment on column course_examination_item.course_id is '课程ID';
comment on column course_examination_item.video_id is '视频ID';
comment on column course_examination_item.examination_id is '考试题ID';
comment on column course_examination_item.title is '标题';
comment on column course_examination_item.is_answer is '是否参考答案';

drop table examination_paper;
create table examination_paper
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid,
    test_type integer default 0,
    test_state integer default 0,
    test_amount integer default 2,
    duration integer,
    title character varying(300),
    question_amount integer,
    question_type integer,
    total_score integer default 100,
    pass_score integer default 60,
    single_amount integer,
    multi_amount integer,
    judge_amount integer,
    check_amount integer,
    fill_amount integer,
    primary key (id),
    foreign key (course_id) references course(id)
) with (oids = false);
comment on table examination_paper is '课程考试题参考答案（主观题）';
comment on column examination_paper.id is '流水号';
comment on column examination_paper.create_time is '创建时间';
comment on column examination_paper.update_time is '更新时间';
comment on column examination_paper.flag is '标记';
comment on column examination_paper.status is '状态';
comment on column examination_paper.course_id is '课程ID';
comment on column examination_paper.test_type is '考试类型：1自动考试，2统一考试';
comment on column examination_paper.test_state is '考试状态：1等待考试，2开始考试，3结束考试';
comment on column examination_paper.test_amount is '考试次数（补考次数）';
comment on column examination_paper.duration is '时长';
comment on column examination_paper.title is '标题';
comment on column examination_paper.question_amount is '考题总数';
comment on column examination_paper.question_type is '考题分配：1随机分配题型数量，2自行分配题型数量';
comment on column examination_paper.single_amount is '单选题数量';
comment on column examination_paper.multi_amount is '多选题数量';
comment on column examination_paper.judge_amount is '判断题数量';
comment on column examination_paper.check_amount is '不定项选择题数量';
comment on column examination_paper.fill_amount is '填空题数量';

drop table examination_question;
create table examination_question
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    paper_id uuid,
    title character varying(1000),
    category integer default 1,
    score integer default 1,
    primary key (id),
    foreign key (paper_id) references examination_paper(id)
) with (oids = false);
comment on table examination_question is '课程考试题';
comment on column examination_question.id is '流水号';
comment on column examination_question.create_time is '创建时间';
comment on column examination_question.update_time is '更新时间';
comment on column examination_question.flag is '标记';
comment on column examination_question.paper_id is '考卷ID';
comment on column examination_question.title is '试题标题';
comment on column examination_question.category is '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';
comment on column examination_question.score is '分值';

drop table examination_question_analysis;
create table examination_question_analysis
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    question_id uuid,
    content text,
    primary key (id),
    foreign key (question_id) references examination_question(id)
) with (oids = false);
comment on table examination_question_analysis is '课程考试题解析';
comment on column examination_question_analysis.id is '流水号';
comment on column examination_question_analysis.create_time is '创建时间';
comment on column examination_question_analysis.update_time is '更新时间';
comment on column examination_question_analysis.flag is '标记';
comment on column examination_question_analysis.question_id is '考题ID';
comment on column examination_question_analysis.content is '解析内容';

drop table examination_question_item;
create table examination_question_item
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    question_id uuid,
    title character varying(1000),
    is_answer boolean default false,
    primary key (id),
    foreign key (question_id) references examination_question(id)
) with (oids = false);
comment on table examination_question_item is '课程考试题选择';
comment on column examination_question_item.id is '流水号';
comment on column examination_question_item.create_time is '创建时间';
comment on column examination_question_item.update_time is '更新时间';
comment on column examination_question_item.flag is '标记';
comment on column examination_question_item.status is '状态';
comment on column examination_question_item.question_id is '考题ID';
comment on column examination_question_item.title is '标题';
comment on column examination_question_item.is_answer is '是否参考答案';

drop table employee_examination_paper;
create table employee_examination_paper
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    paper_id uuid,
    paper_title character varying(300),
    employee_id uuid,
    employee_name character varying(50),
    course_id uuid,
    course_name  character varying(300),
    test_type integer default 0,
    test_state integer default 0,
    test_amount integer default 1,
    duration integer,
    question_amount integer,
    question_type integer,
    total_score integer default 100,
    pass_score integer default 60,
    test_score integer default 0,
    pass_state boolean default false,
    single_amount integer,
    multi_amount integer,
    judge_amount integer,
    check_amount integer,
    fill_amount integer,
    join_state integer,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    submit_time timestamp without time zone,
    primary key (id)
) with (oids = false);
comment on table employee_examination_paper is '员工考卷';
comment on column employee_examination_paper.id is '流水号';
comment on column employee_examination_paper.create_time is '创建时间';
comment on column employee_examination_paper.update_time is '更新时间';
comment on column employee_examination_paper.flag is '标记';
comment on column employee_examination_paper.status is '标记';
comment on column employee_examination_paper.paper_id is '考卷ID';
comment on column employee_examination_paper.paper_title is '考卷ID';
comment on column employee_examination_paper.employee_id is '员工ID';
comment on column employee_examination_paper.employee_name is '员工姓名';
comment on column employee_examination_paper.course_id is '课程ID';
comment on column employee_examination_paper.course_name is '课程名称';
comment on column employee_examination_paper.test_type is '考试类型：1自动考试，2统一考试';
comment on column employee_examination_paper.test_state is '考试状态：1等待考试，2开始考试，3暂停考试，4考试作废';
comment on column employee_examination_paper.test_amount is '考试次数（补考次数）';
comment on column employee_examination_paper.duration is '时长';
comment on column employee_examination_paper.question_amount is '考题总数';
comment on column employee_examination_paper.question_type is '考题分配：1随机分配题型数量，2自行分配题型数量';
comment on column employee_examination_paper.total_score is '总分数';
comment on column employee_examination_paper.pass_score is '合格分数';
comment on column employee_examination_paper.test_score is '考试成绩（测试成绩）';
comment on column employee_examination_paper.pass_state is '通过状态：1及格，2不及格';
comment on column employee_examination_paper.single_amount is '单选题数量';
comment on column employee_examination_paper.multi_amount is '多选题数量';
comment on column employee_examination_paper.judge_amount is '判断题数量';
comment on column employee_examination_paper.check_amount is '不定项选择题数量';
comment on column employee_examination_paper.fill_amount is '填空题数量';
comment on column employee_examination_paper.join_state is '参与状态：1正常，2缺考';
comment on column employee_examination_paper.start_time is '开考时间';
comment on column employee_examination_paper.end_time is '结束时间';
comment on column employee_examination_paper.submit_time is '交卷时间';

drop table employee_examination_question;
create table employee_examination_question
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    paper_id uuid,
    question_id uuid,
    title varchar(1000),
    category integer,
    score integer,
    answer_state integer default 1,
    right_state boolean default false,
    primary key (id),
    foreign key (paper_id) references employee_examination_paper(id)
) with (oids = false);
comment on table employee_examination_question is '考生考卷问题作答';
comment on column employee_examination_question.id is '流水号';
comment on column employee_examination_question.create_time is '创建时间';
comment on column employee_examination_question.update_time is '更新时间';
comment on column employee_examination_question.flag is '标记';
comment on column employee_examination_question.status is '状态';
comment on column employee_examination_question.paper_id is '考卷ID';
comment on column employee_examination_question.question_id is '考题ID';
comment on column employee_examination_question.title is '考题标题';
comment on column employee_examination_question.category is '考题类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';
comment on column employee_examination_question.score is '考题分数';
comment on column employee_examination_question.answer_state is '作答状态：1未作答，2作答标记，3已作答';
comment on column employee_examination_question.right_state is '回答正确状态';

drop table employee_examination_question_analysis;
create table employee_examination_question_analysis
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    question_id uuid,
    content text,
    primary key (id),
    foreign key (question_id) references employee_examination_question(id)
) with (oids = false);
comment on table employee_examination_question_analysis is '员工考试题解析';
comment on column employee_examination_question_analysis.id is '流水号';
comment on column employee_examination_question_analysis.create_time is '创建时间';
comment on column employee_examination_question_analysis.update_time is '更新时间';
comment on column employee_examination_question_analysis.flag is '标记';
comment on column employee_examination_question_analysis.status is '状态';
comment on column employee_examination_question_analysis.question_id is '考题ID';
comment on column employee_examination_question_analysis.content is '解析内容';

drop table employee_examination_question_item;
create table employee_examination_question_item
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    question_id uuid,
    title character varying(1000),
    is_answer boolean default false,
    check_state boolean default false,
    primary key (id),
    foreign key (question_id) references employee_examination_question(id)
) with (oids = false);
comment on table employee_examination_question_item is '员工试题作答';
comment on column employee_examination_question_item.id is '流水号';
comment on column employee_examination_question_item.create_time is '创建时间';
comment on column employee_examination_question_item.update_time is '更新时间';
comment on column employee_examination_question_item.flag is '标记';
comment on column employee_examination_question_item.status is '状态';
comment on column employee_examination_question_item.question_id is '试题ID';
comment on column employee_examination_question_item.title is '答题项标题';
comment on column employee_examination_question_item.is_answer is '是否为参考答案';
comment on column employee_examination_question_item.check_state is '选择状态';

drop table examination_config;
create table examination_config
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    duration integer,
    test_type integer,
    paper_type integer,
    test_amount integer default 2,
    question_type integer,
    question_amount integer,
    total_score integer default 100,
    pass_score integer default 60,
    single_amount integer,
    multi_amount integer,
    judge_amount integer,
    check_amount integer,
    fill_amount integer,
    primary key (id)
) with (oids = false);
comment on table examination_config is '考试';
comment on column examination_config.id is '流水号';
comment on column examination_config.create_time is '创建时间';
comment on column examination_config.update_time is '更新时间';
comment on column examination_config.flag is '标记';
comment on column examination_config.status is '状态';
comment on column examination_config.duration is '考试时长（单位：分钟）';
comment on column examination_config.test_type is '考试类型：1课程学习完成后自动考试，2由教师统计安排统计';
comment on column examination_config.paper_type is '考卷类型：1系统随机出卷，2由教师自行出卷';
comment on column examination_config.total_score is '总成绩';
comment on column examination_config.pass_score is '合格成绩';
comment on column examination_config.test_amount is '补考次数';
comment on column examination_config.question_amount is '考题总数';
comment on column examination_config.question_type is '考题分配：1自动分配，2自行分配';
comment on column examination_config.test_amount is '考试次数（补考次数）';
comment on column examination_config.single_amount is '单选题数量';
comment on column examination_config.multi_amount is '多选题数量';
comment on column examination_config.judge_amount is '判断题数量';
comment on column examination_config.check_amount is '不定项选择题数量';
comment on column examination_config.fill_amount is '填空题数量';

drop table certificate;
create table certificate
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    name character varying(300),
    department character varying(300),
    official_seal character varying(50),
    grade integer default 0,
    primary key (id)
) with (oids = false);
comment on table certificate is '证书';
comment on column certificate.id is '流水号';
comment on column certificate.create_time is '创建时间';
comment on column certificate.update_time is '更新时间';
comment on column certificate.flag is '标记';
comment on column certificate.name is '名称';
comment on column certificate.department is '发证机构';
comment on column certificate.official_seal is '机构公章';
comment on column certificate.grade is '等级';

drop table course_certificate;
create table course_certificate
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid not null,
    certificate_id uuid not null,
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (certificate_id) references certificate(id)
) with (oids = false);
comment on table course_certificate is '课程证书';
comment on column course_certificate.id is '流水号';
comment on column course_certificate.create_time is '创建时间';
comment on column course_certificate.update_time is '更新时间';
comment on column course_certificate.flag is '标记';
comment on column course_certificate.status is '状态';
comment on column course_certificate.course_id is '课程ID';
comment on column course_certificate.certificate_id is '证书ID';

drop table employee_certificate;
create table employee_certificate
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    employee_id uuid not null,
    employee_name character varying(50),
    employee_sex integer,
    employee_born date,
    identity_code character varying(18),
    certificate_id uuid not null,
    certificate_code character varying(25),
    certificate_name character varying(1000),
    certificate_date date,
    seal_photo character varying(50),
    organization_code character varying(50),
    organization_name character varying(300),
    teacher_id uuid,
    teacher_name character varying(50),
    primary key (id),
    foreign key (employee_id) references employee_account(id),
    foreign key (certificate_id) references certificate(id)
) with (oids = false);
comment on table employee_certificate is '员工证书';
comment on column employee_certificate.id is '流水号';
comment on column employee_certificate.create_time is '创建时间';
comment on column employee_certificate.update_time is '更新时间';
comment on column employee_certificate.flag is '标记';
comment on column employee_certificate.status is '状态';
comment on column employee_certificate.employee_id is '员工ID';
comment on column employee_certificate.employee_name is '员工姓名';
comment on column employee_certificate.employee_sex is '员工性别';
comment on column employee_certificate.employee_born is '员工出生日期';
comment on column employee_certificate.identity_code is '员工身份证号';
comment on column employee_certificate.certificate_id is '证书ID';
comment on column employee_certificate.certificate_code is '证书编号';
comment on column employee_certificate.certificate_name is '证书名称';
comment on column employee_certificate.certificate_date is '证书日期';
comment on column employee_certificate.seal_photo is '公章图片地址';
comment on column employee_certificate.organization_code is '机构编号';
comment on column employee_certificate.organization_name is '机构名称';
comment on column employee_certificate.teacher_id is '证明人ID';
comment on column employee_certificate.teacher_name is '证明人姓名';

create table store_paper
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    show_state boolean default false,
    course_id uuid not null,
    title character varying(1000) not null,
    duration integer,
    question_amount integer,
    total_score integer,
    pass_score integer,
    test_amount integer default 2,
    editor_id uuid,
    editor_name character varying(50),
    edit_state integer,
    edit_time timestamp without time zone,
    auditor_id uuid,
    auditor_name character varying(50),
    audit_state integer,
    audit_time timestamp without time zone,
    auditor_mind character varying(500),
    primary key (id),
    foreign key (course_id) references course(id)
) with (oids = false);
comment on table store_paper is '题库试卷';
comment on column store_paper.id is '流水号';
comment on column store_paper.create_time is '创建时间';
comment on column store_paper.flag is '标记';
comment on column store_paper.status is '状态';
comment on column store_paper.show_state is '显示状态';
comment on column store_paper.course_id is '课程ID';
comment on column store_paper.title is '标题';
comment on column store_paper.duration is '时长（单位：分钟）';
comment on column store_paper.question_amount is '题目总数';
comment on column store_paper.total_score is '总分数';
comment on column store_paper.pass_score is '合格分数';
comment on column store_paper.test_amount is '补考次数';
comment on column store_paper.editor_id is '编辑人ID';
comment on column store_paper.editor_name is '编辑人姓名';
comment on column store_paper.edit_state is '编辑状态：1草稿，2定稿';
comment on column store_paper.edit_time is '编辑时间';
comment on column store_paper.auditor_id is '审核人ID';
comment on column store_paper.auditor_name is '审核人名称';
comment on column store_paper.audit_state is '审核状态，1待审核，2通过，3不通过';
comment on column store_paper.auditor_mind is '审核意见';

drop table store_question;
create table store_question
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    paper_id uuid,
    title character varying(1000),
    category integer default 1,
    score integer default 1,
    primary key (id),
    foreign key (paper_id) references store_paper(id)
) with (oids = false);
comment on table store_question is '课程考试题';
comment on column store_question.id is '流水号';
comment on column store_question.create_time is '创建时间';
comment on column store_question.update_time is '更新时间';
comment on column store_question.flag is '标记';
comment on column store_question.paper_id is '考卷ID';
comment on column store_question.title is '试题标题';
comment on column store_question.category is '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';
comment on column store_question.score is '分值';

drop table store_question_analysis;
create table store_question_analysis
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    question_id uuid,
    content text,
    primary key (id),
    foreign key (question_id) references store_question(id)
) with (oids = false);
comment on table store_question_analysis is '课程考试题解析';
comment on column store_question_analysis.id is '流水号';
comment on column store_question_analysis.create_time is '创建时间';
comment on column store_question_analysis.update_time is '更新时间';
comment on column store_question_analysis.flag is '标记';
comment on column store_question_analysis.question_id is '考题ID';
comment on column store_question_analysis.content is '解析内容';

drop table store_question_item;
create table store_question_item
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    question_id uuid,
    title character varying(1000),
    is_answer boolean default false,
    primary key (id),
    foreign key (question_id) references store_question(id)
) with (oids = false);
comment on table store_question_item is '课程考试题选择';
comment on column store_question_item.id is '流水号';
comment on column store_question_item.create_time is '创建时间';
comment on column store_question_item.update_time is '更新时间';
comment on column store_question_item.flag is '标记';
comment on column store_question_item.status is '状态';
comment on column store_question_item.question_id is '考题ID';
comment on column store_question_item.title is '标题';
comment on column store_question_item.is_answer is '是否参考答案';

drop table sys_sequence ;
create table sys_sequence
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    seq_code varchar(300),
    seq_name varchar(300),
    seq_value integer,
    primary key (id),
    unique (seq_code)
) with (oids = false);
comment on table sys_sequence is '课程考试题选择';
comment on column sys_sequence.id is '流水号';
comment on column sys_sequence.create_time is '创建时间';
comment on column sys_sequence.update_time is '更新时间';
comment on column sys_sequence.flag is '标记';
comment on column sys_sequence.status is '状态';
comment on column sys_sequence.seq_code is '序号编号';
comment on column sys_sequence.seq_name is '序号名称';
comment on column sys_sequence.seq_value is '序号值';

drop table employee_examination_apply;
create table employee_examination_apply
(
    id uuid not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean default true,
    status boolean default true,
    course_id uuid not null,
    employee_id uuid not null,
    apply_time timestamp without time zone,
    auditor_id uuid,
    auditor_name character varying(50),
    audit_state integer,
    audit_time timestamp without time zone,
    auditor_mind character varying(500),
    primary key (id),
    foreign key (course_id) references course(id),
    foreign key (employee_id) references employee_account(id)
) with (oids = false);
comment on table employee_examination_apply is '补考申请';
comment on column employee_examination_apply.id is '流水号';
comment on column employee_examination_apply.create_time is '创建时间';
comment on column employee_examination_apply.flag is '标记';
comment on column employee_examination_apply.status is '状态';
comment on column employee_examination_apply.course_id is '课程ID';
comment on column employee_examination_apply.employee_id is '申请人';
comment on column employee_examination_apply.apply_time is '申请时间';
comment on column employee_examination_apply.auditor_id is '审核人ID';
comment on column employee_examination_apply.auditor_name is '审核人名称';
comment on column employee_examination_apply.audit_state is '审核状态，1待审核，2通过，3不通过';
comment on column employee_examination_apply.auditor_mind is '审核意见';