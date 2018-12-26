--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: act_evt_log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_evt_log (
    log_nr_ integer NOT NULL,
    type_ character varying(64),
    proc_def_id_ character varying(64),
    proc_inst_id_ character varying(64),
    execution_id_ character varying(64),
    task_id_ character varying(64),
    time_stamp_ timestamp without time zone NOT NULL,
    user_id_ character varying(255),
    data_ bytea,
    lock_owner_ character varying(255),
    lock_time_ timestamp without time zone,
    is_processed_ smallint DEFAULT 0
);


ALTER TABLE public.act_evt_log OWNER TO postgres;

--
-- Name: act_evt_log_log_nr__seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.act_evt_log_log_nr__seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.act_evt_log_log_nr__seq OWNER TO postgres;

--
-- Name: act_evt_log_log_nr__seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.act_evt_log_log_nr__seq OWNED BY public.act_evt_log.log_nr_;


--
-- Name: act_ge_bytearray; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ge_bytearray (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    name_ character varying(255),
    deployment_id_ character varying(64),
    bytes_ bytea,
    generated_ boolean
);


ALTER TABLE public.act_ge_bytearray OWNER TO postgres;

--
-- Name: act_ge_property; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ge_property (
    name_ character varying(64) NOT NULL,
    value_ character varying(300),
    rev_ integer
);


ALTER TABLE public.act_ge_property OWNER TO postgres;

--
-- Name: act_hi_actinst; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_actinst (
    id_ character varying(64) NOT NULL,
    proc_def_id_ character varying(64) NOT NULL,
    proc_inst_id_ character varying(64) NOT NULL,
    execution_id_ character varying(64) NOT NULL,
    act_id_ character varying(255) NOT NULL,
    task_id_ character varying(64),
    call_proc_inst_id_ character varying(64),
    act_name_ character varying(255),
    act_type_ character varying(255) NOT NULL,
    assignee_ character varying(255),
    start_time_ timestamp without time zone NOT NULL,
    end_time_ timestamp without time zone,
    duration_ bigint,
    delete_reason_ character varying(4000),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_hi_actinst OWNER TO postgres;

--
-- Name: act_hi_attachment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_attachment (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    user_id_ character varying(255),
    name_ character varying(255),
    description_ character varying(4000),
    type_ character varying(255),
    task_id_ character varying(64),
    proc_inst_id_ character varying(64),
    url_ character varying(4000),
    content_id_ character varying(64),
    time_ timestamp without time zone
);


ALTER TABLE public.act_hi_attachment OWNER TO postgres;

--
-- Name: act_hi_comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_comment (
    id_ character varying(64) NOT NULL,
    type_ character varying(255),
    time_ timestamp without time zone NOT NULL,
    user_id_ character varying(255),
    task_id_ character varying(64),
    proc_inst_id_ character varying(64),
    action_ character varying(255),
    message_ character varying(4000),
    full_msg_ bytea
);


ALTER TABLE public.act_hi_comment OWNER TO postgres;

--
-- Name: act_hi_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_detail (
    id_ character varying(64) NOT NULL,
    type_ character varying(255) NOT NULL,
    proc_inst_id_ character varying(64),
    execution_id_ character varying(64),
    task_id_ character varying(64),
    act_inst_id_ character varying(64),
    name_ character varying(255) NOT NULL,
    var_type_ character varying(64),
    rev_ integer,
    time_ timestamp without time zone NOT NULL,
    bytearray_id_ character varying(64),
    double_ double precision,
    long_ bigint,
    text_ character varying(4000),
    text2_ character varying(4000)
);


ALTER TABLE public.act_hi_detail OWNER TO postgres;

--
-- Name: act_hi_identitylink; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_identitylink (
    id_ character varying(64) NOT NULL,
    group_id_ character varying(255),
    type_ character varying(255),
    user_id_ character varying(255),
    task_id_ character varying(64),
    proc_inst_id_ character varying(64)
);


ALTER TABLE public.act_hi_identitylink OWNER TO postgres;

--
-- Name: act_hi_procinst; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_procinst (
    id_ character varying(64) NOT NULL,
    proc_inst_id_ character varying(64) NOT NULL,
    business_key_ character varying(255),
    proc_def_id_ character varying(64) NOT NULL,
    start_time_ timestamp without time zone NOT NULL,
    end_time_ timestamp without time zone,
    duration_ bigint,
    start_user_id_ character varying(255),
    start_act_id_ character varying(255),
    end_act_id_ character varying(255),
    super_process_instance_id_ character varying(64),
    delete_reason_ character varying(4000),
    tenant_id_ character varying(255) DEFAULT ''::character varying,
    name_ character varying(255)
);


ALTER TABLE public.act_hi_procinst OWNER TO postgres;

--
-- Name: act_hi_taskinst; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_taskinst (
    id_ character varying(64) NOT NULL,
    proc_def_id_ character varying(64),
    task_def_key_ character varying(255),
    proc_inst_id_ character varying(64),
    execution_id_ character varying(64),
    name_ character varying(255),
    parent_task_id_ character varying(64),
    description_ character varying(4000),
    owner_ character varying(255),
    assignee_ character varying(255),
    start_time_ timestamp without time zone NOT NULL,
    claim_time_ timestamp without time zone,
    end_time_ timestamp without time zone,
    duration_ bigint,
    delete_reason_ character varying(4000),
    priority_ integer,
    due_date_ timestamp without time zone,
    form_key_ character varying(255),
    category_ character varying(255),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_hi_taskinst OWNER TO postgres;

--
-- Name: act_hi_varinst; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_hi_varinst (
    id_ character varying(64) NOT NULL,
    proc_inst_id_ character varying(64),
    execution_id_ character varying(64),
    task_id_ character varying(64),
    name_ character varying(255) NOT NULL,
    var_type_ character varying(100),
    rev_ integer,
    bytearray_id_ character varying(64),
    double_ double precision,
    long_ bigint,
    text_ character varying(4000),
    text2_ character varying(4000),
    create_time_ timestamp without time zone,
    last_updated_time_ timestamp without time zone
);


ALTER TABLE public.act_hi_varinst OWNER TO postgres;

--
-- Name: act_id_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_id_group (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    name_ character varying(255),
    type_ character varying(255)
);


ALTER TABLE public.act_id_group OWNER TO postgres;

--
-- Name: act_id_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_id_info (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    user_id_ character varying(64),
    type_ character varying(64),
    key_ character varying(255),
    value_ character varying(255),
    password_ bytea,
    parent_id_ character varying(255)
);


ALTER TABLE public.act_id_info OWNER TO postgres;

--
-- Name: act_id_membership; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_id_membership (
    user_id_ character varying(64) NOT NULL,
    group_id_ character varying(64) NOT NULL
);


ALTER TABLE public.act_id_membership OWNER TO postgres;

--
-- Name: act_id_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_id_user (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    first_ character varying(255),
    last_ character varying(255),
    email_ character varying(255),
    pwd_ character varying(255),
    picture_id_ character varying(64)
);


ALTER TABLE public.act_id_user OWNER TO postgres;

--
-- Name: act_procdef_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_procdef_info (
    id_ character varying(64) NOT NULL,
    proc_def_id_ character varying(64) NOT NULL,
    rev_ integer,
    info_json_id_ character varying(64)
);


ALTER TABLE public.act_procdef_info OWNER TO postgres;

--
-- Name: act_re_deployment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_re_deployment (
    id_ character varying(64) NOT NULL,
    name_ character varying(255),
    category_ character varying(255),
    key_ character varying(255),
    tenant_id_ character varying(255) DEFAULT ''::character varying,
    deploy_time_ timestamp without time zone,
    engine_version_ character varying(255)
);


ALTER TABLE public.act_re_deployment OWNER TO postgres;

--
-- Name: act_re_model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_re_model (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    name_ character varying(255),
    key_ character varying(255),
    category_ character varying(255),
    create_time_ timestamp without time zone,
    last_update_time_ timestamp without time zone,
    version_ integer,
    meta_info_ character varying(4000),
    deployment_id_ character varying(64),
    editor_source_value_id_ character varying(64),
    editor_source_extra_value_id_ character varying(64),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_re_model OWNER TO postgres;

--
-- Name: act_re_procdef; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_re_procdef (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    category_ character varying(255),
    name_ character varying(255),
    key_ character varying(255) NOT NULL,
    version_ integer NOT NULL,
    deployment_id_ character varying(64),
    resource_name_ character varying(4000),
    dgrm_resource_name_ character varying(4000),
    description_ character varying(4000),
    has_start_form_key_ boolean,
    has_graphical_notation_ boolean,
    suspension_state_ integer,
    tenant_id_ character varying(255) DEFAULT ''::character varying,
    engine_version_ character varying(255)
);


ALTER TABLE public.act_re_procdef OWNER TO postgres;

--
-- Name: act_ru_deadletter_job; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_deadletter_job (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    type_ character varying(255) NOT NULL,
    exclusive_ boolean,
    execution_id_ character varying(64),
    process_instance_id_ character varying(64),
    proc_def_id_ character varying(64),
    exception_stack_id_ character varying(64),
    exception_msg_ character varying(4000),
    duedate_ timestamp without time zone,
    repeat_ character varying(255),
    handler_type_ character varying(255),
    handler_cfg_ character varying(4000),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_ru_deadletter_job OWNER TO postgres;

--
-- Name: act_ru_event_subscr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_event_subscr (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    event_type_ character varying(255) NOT NULL,
    event_name_ character varying(255),
    execution_id_ character varying(64),
    proc_inst_id_ character varying(64),
    activity_id_ character varying(64),
    configuration_ character varying(255),
    created_ timestamp without time zone NOT NULL,
    proc_def_id_ character varying(64),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_ru_event_subscr OWNER TO postgres;

--
-- Name: act_ru_execution; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_execution (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    proc_inst_id_ character varying(64),
    business_key_ character varying(255),
    parent_id_ character varying(64),
    proc_def_id_ character varying(64),
    super_exec_ character varying(64),
    root_proc_inst_id_ character varying(64),
    act_id_ character varying(255),
    is_active_ boolean,
    is_concurrent_ boolean,
    is_scope_ boolean,
    is_event_scope_ boolean,
    is_mi_root_ boolean,
    suspension_state_ integer,
    cached_ent_state_ integer,
    tenant_id_ character varying(255) DEFAULT ''::character varying,
    name_ character varying(255),
    start_time_ timestamp without time zone,
    start_user_id_ character varying(255),
    lock_time_ timestamp without time zone,
    is_count_enabled_ boolean,
    evt_subscr_count_ integer,
    task_count_ integer,
    job_count_ integer,
    timer_job_count_ integer,
    susp_job_count_ integer,
    deadletter_job_count_ integer,
    var_count_ integer,
    id_link_count_ integer
);


ALTER TABLE public.act_ru_execution OWNER TO postgres;

--
-- Name: act_ru_identitylink; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_identitylink (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    group_id_ character varying(255),
    type_ character varying(255),
    user_id_ character varying(255),
    task_id_ character varying(64),
    proc_inst_id_ character varying(64),
    proc_def_id_ character varying(64)
);


ALTER TABLE public.act_ru_identitylink OWNER TO postgres;

--
-- Name: act_ru_job; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_job (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    type_ character varying(255) NOT NULL,
    lock_exp_time_ timestamp without time zone,
    lock_owner_ character varying(255),
    exclusive_ boolean,
    execution_id_ character varying(64),
    process_instance_id_ character varying(64),
    proc_def_id_ character varying(64),
    retries_ integer,
    exception_stack_id_ character varying(64),
    exception_msg_ character varying(4000),
    duedate_ timestamp without time zone,
    repeat_ character varying(255),
    handler_type_ character varying(255),
    handler_cfg_ character varying(4000),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_ru_job OWNER TO postgres;

--
-- Name: act_ru_suspended_job; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_suspended_job (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    type_ character varying(255) NOT NULL,
    exclusive_ boolean,
    execution_id_ character varying(64),
    process_instance_id_ character varying(64),
    proc_def_id_ character varying(64),
    retries_ integer,
    exception_stack_id_ character varying(64),
    exception_msg_ character varying(4000),
    duedate_ timestamp without time zone,
    repeat_ character varying(255),
    handler_type_ character varying(255),
    handler_cfg_ character varying(4000),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_ru_suspended_job OWNER TO postgres;

--
-- Name: act_ru_task; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_task (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    execution_id_ character varying(64),
    proc_inst_id_ character varying(64),
    proc_def_id_ character varying(64),
    name_ character varying(255),
    parent_task_id_ character varying(64),
    description_ character varying(4000),
    task_def_key_ character varying(255),
    owner_ character varying(255),
    assignee_ character varying(255),
    delegation_ character varying(64),
    priority_ integer,
    create_time_ timestamp without time zone,
    due_date_ timestamp without time zone,
    category_ character varying(255),
    suspension_state_ integer,
    tenant_id_ character varying(255) DEFAULT ''::character varying,
    form_key_ character varying(255),
    claim_time_ timestamp without time zone
);


ALTER TABLE public.act_ru_task OWNER TO postgres;

--
-- Name: act_ru_timer_job; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_timer_job (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    type_ character varying(255) NOT NULL,
    lock_exp_time_ timestamp without time zone,
    lock_owner_ character varying(255),
    exclusive_ boolean,
    execution_id_ character varying(64),
    process_instance_id_ character varying(64),
    proc_def_id_ character varying(64),
    retries_ integer,
    exception_stack_id_ character varying(64),
    exception_msg_ character varying(4000),
    duedate_ timestamp without time zone,
    repeat_ character varying(255),
    handler_type_ character varying(255),
    handler_cfg_ character varying(4000),
    tenant_id_ character varying(255) DEFAULT ''::character varying
);


ALTER TABLE public.act_ru_timer_job OWNER TO postgres;

--
-- Name: act_ru_variable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act_ru_variable (
    id_ character varying(64) NOT NULL,
    rev_ integer,
    type_ character varying(255) NOT NULL,
    name_ character varying(255) NOT NULL,
    execution_id_ character varying(64),
    proc_inst_id_ character varying(64),
    task_id_ character varying(64),
    bytearray_id_ character varying(64),
    double_ double precision,
    long_ bigint,
    text_ character varying(4000),
    text2_ character varying(4000)
);


ALTER TABLE public.act_ru_variable OWNER TO postgres;

--
-- Name: base_dictionary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.base_dictionary (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    code character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    caption character varying(300),
    show_state boolean DEFAULT false
);


ALTER TABLE public.base_dictionary OWNER TO postgres;

--
-- Name: TABLE base_dictionary; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.base_dictionary IS '数字字典';


--
-- Name: COLUMN base_dictionary.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.id IS '流水号';


--
-- Name: COLUMN base_dictionary.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.create_time IS '创建时间';


--
-- Name: COLUMN base_dictionary.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.update_time IS '更新时间';


--
-- Name: COLUMN base_dictionary.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.flag IS '标记';


--
-- Name: COLUMN base_dictionary.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.status IS '状态';


--
-- Name: COLUMN base_dictionary.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.code IS '字典编号';


--
-- Name: COLUMN base_dictionary.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.name IS '字典名称';


--
-- Name: COLUMN base_dictionary.caption; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.caption IS '备注';


--
-- Name: COLUMN base_dictionary.show_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary.show_state IS '显示状态';


--
-- Name: base_dictionary_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.base_dictionary_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    dictionary_id uuid,
    item_text character varying(50) NOT NULL,
    item_value character varying(50) NOT NULL,
    show_state boolean DEFAULT false,
    serial_number integer DEFAULT 0
);


ALTER TABLE public.base_dictionary_item OWNER TO postgres;

--
-- Name: TABLE base_dictionary_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.base_dictionary_item IS '数字字典选项';


--
-- Name: COLUMN base_dictionary_item.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.id IS '流水号';


--
-- Name: COLUMN base_dictionary_item.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.create_time IS '创建时间';


--
-- Name: COLUMN base_dictionary_item.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.update_time IS '更新时间';


--
-- Name: COLUMN base_dictionary_item.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.flag IS '标记';


--
-- Name: COLUMN base_dictionary_item.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.status IS '状态';


--
-- Name: COLUMN base_dictionary_item.dictionary_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.dictionary_id IS '所属字典ID';


--
-- Name: COLUMN base_dictionary_item.item_text; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.item_text IS '选项文本';


--
-- Name: COLUMN base_dictionary_item.item_value; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.item_value IS '选项值';


--
-- Name: COLUMN base_dictionary_item.show_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.show_state IS '显示状态';


--
-- Name: COLUMN base_dictionary_item.serial_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_dictionary_item.serial_number IS '排序序号';


--
-- Name: base_position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.base_position (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    code character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    caption character varying(300),
    show_state boolean DEFAULT false,
    serial_number integer DEFAULT 0
);


ALTER TABLE public.base_position OWNER TO postgres;

--
-- Name: TABLE base_position; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.base_position IS '职位信息';


--
-- Name: COLUMN base_position.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.id IS '流水号';


--
-- Name: COLUMN base_position.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.create_time IS '创建时间';


--
-- Name: COLUMN base_position.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.update_time IS '更新时间';


--
-- Name: COLUMN base_position.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.flag IS '标记';


--
-- Name: COLUMN base_position.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.code IS '职位编号';


--
-- Name: COLUMN base_position.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.name IS '职位姓名';


--
-- Name: COLUMN base_position.caption; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.caption IS '备注';


--
-- Name: COLUMN base_position.show_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.show_state IS '显示状态';


--
-- Name: COLUMN base_position.serial_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.base_position.serial_number IS '排序序号';


--
-- Name: course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    type_id uuid,
    teacher_id uuid,
    code character varying(50) NOT NULL,
    name character varying(200) NOT NULL,
    introduction character varying(500),
    description text
);


ALTER TABLE public.course OWNER TO postgres;

--
-- Name: TABLE course; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course IS '课程';


--
-- Name: COLUMN course.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.id IS '流水号';


--
-- Name: COLUMN course.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.create_time IS '创建时间';


--
-- Name: COLUMN course.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.update_time IS '更新时间';


--
-- Name: COLUMN course.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.flag IS '标记';


--
-- Name: COLUMN course.type_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.type_id IS '类型ID';


--
-- Name: COLUMN course.teacher_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.teacher_id IS '教师ID';


--
-- Name: COLUMN course.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.code IS '编号';


--
-- Name: COLUMN course.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.name IS '名称';


--
-- Name: COLUMN course.introduction; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.introduction IS '介绍';


--
-- Name: COLUMN course.description; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.description IS '描述';


--
-- Name: course_attachment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_attachment (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    file_name character varying(300),
    file_path character varying(100),
    file_type character varying(10),
    file_size bigint,
    upload_time timestamp without time zone
);


ALTER TABLE public.course_attachment OWNER TO postgres;

--
-- Name: TABLE course_attachment; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_attachment IS '课程视频';


--
-- Name: COLUMN course_attachment.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.id IS '流水号';


--
-- Name: COLUMN course_attachment.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.create_time IS '创建时间';


--
-- Name: COLUMN course_attachment.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.update_time IS '更新时间';


--
-- Name: COLUMN course_attachment.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.flag IS '标记';


--
-- Name: COLUMN course_attachment.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.course_id IS '课程ID';


--
-- Name: COLUMN course_attachment.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.video_id IS '视频ID';


--
-- Name: COLUMN course_attachment.file_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.file_name IS '文件名称';


--
-- Name: COLUMN course_attachment.file_path; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.file_path IS '文件路径';


--
-- Name: COLUMN course_attachment.file_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.file_type IS '文件类型';


--
-- Name: COLUMN course_attachment.file_size; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.file_size IS '文件大小';


--
-- Name: COLUMN course_attachment.upload_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_attachment.upload_time IS '上传时间';


--
-- Name: course_examination; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_examination (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    title character varying(1000),
    category integer DEFAULT 1,
    score integer DEFAULT 1
);


ALTER TABLE public.course_examination OWNER TO postgres;

--
-- Name: TABLE course_examination; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_examination IS '课程考试题';


--
-- Name: COLUMN course_examination.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.id IS '流水号';


--
-- Name: COLUMN course_examination.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.create_time IS '创建时间';


--
-- Name: COLUMN course_examination.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.update_time IS '更新时间';


--
-- Name: COLUMN course_examination.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.flag IS '标记';


--
-- Name: COLUMN course_examination.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.course_id IS '课程ID';


--
-- Name: COLUMN course_examination.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.video_id IS '视频ID';


--
-- Name: COLUMN course_examination.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.title IS '标题';


--
-- Name: COLUMN course_examination.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.category IS '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';


--
-- Name: COLUMN course_examination.score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination.score IS '分值';


--
-- Name: course_examination_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_examination_analysis (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    content text
);


ALTER TABLE public.course_examination_analysis OWNER TO postgres;

--
-- Name: TABLE course_examination_analysis; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_examination_analysis IS '课程考试题解析';


--
-- Name: COLUMN course_examination_analysis.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.id IS '流水号';


--
-- Name: COLUMN course_examination_analysis.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.create_time IS '创建时间';


--
-- Name: COLUMN course_examination_analysis.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.update_time IS '更新时间';


--
-- Name: COLUMN course_examination_analysis.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.flag IS '标记';


--
-- Name: COLUMN course_examination_analysis.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.course_id IS '课程ID';


--
-- Name: COLUMN course_examination_analysis.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.video_id IS '视频ID';


--
-- Name: COLUMN course_examination_analysis.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.exercise_id IS '考试题ID';


--
-- Name: COLUMN course_examination_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.content IS '解析内容';


--
-- Name: course_examination_answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_examination_answer (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    content text
);


ALTER TABLE public.course_examination_answer OWNER TO postgres;

--
-- Name: TABLE course_examination_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_examination_answer IS '课程考试题参考答案（主观题）';


--
-- Name: COLUMN course_examination_answer.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.id IS '流水号';


--
-- Name: COLUMN course_examination_answer.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.create_time IS '创建时间';


--
-- Name: COLUMN course_examination_answer.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.update_time IS '更新时间';


--
-- Name: COLUMN course_examination_answer.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.flag IS '标记';


--
-- Name: COLUMN course_examination_answer.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.course_id IS '课程ID';


--
-- Name: COLUMN course_examination_answer.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.video_id IS '视频ID';


--
-- Name: COLUMN course_examination_answer.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.exercise_id IS '考试题ID';


--
-- Name: COLUMN course_examination_answer.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_answer.content IS '解析内容';


--
-- Name: course_examination_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_examination_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    title character varying(1000),
    is_answer boolean DEFAULT false
);


ALTER TABLE public.course_examination_item OWNER TO postgres;

--
-- Name: TABLE course_examination_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_examination_item IS '课程考试题选择';


--
-- Name: COLUMN course_examination_item.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.id IS '流水号';


--
-- Name: COLUMN course_examination_item.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.create_time IS '创建时间';


--
-- Name: COLUMN course_examination_item.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.update_time IS '更新时间';


--
-- Name: COLUMN course_examination_item.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.flag IS '标记';


--
-- Name: COLUMN course_examination_item.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.course_id IS '课程ID';


--
-- Name: COLUMN course_examination_item.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.video_id IS '视频ID';


--
-- Name: COLUMN course_examination_item.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.exercise_id IS '考试题ID';


--
-- Name: COLUMN course_examination_item.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.title IS '标题';


--
-- Name: COLUMN course_examination_item.is_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.is_answer IS '是否参考答案';


--
-- Name: course_exercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_exercise (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    title character varying(1000),
    category integer DEFAULT 1,
    score integer DEFAULT 1
);


ALTER TABLE public.course_exercise OWNER TO postgres;

--
-- Name: TABLE course_exercise; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_exercise IS '课程练习题';


--
-- Name: COLUMN course_exercise.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.id IS '流水号';


--
-- Name: COLUMN course_exercise.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.create_time IS '创建时间';


--
-- Name: COLUMN course_exercise.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.update_time IS '更新时间';


--
-- Name: COLUMN course_exercise.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.flag IS '标记';


--
-- Name: COLUMN course_exercise.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.course_id IS '课程ID';


--
-- Name: COLUMN course_exercise.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.video_id IS '视频ID';


--
-- Name: COLUMN course_exercise.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.title IS '标题';


--
-- Name: COLUMN course_exercise.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.category IS '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';


--
-- Name: COLUMN course_exercise.score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise.score IS '分值';


--
-- Name: course_exercise_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_exercise_analysis (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    content text
);


ALTER TABLE public.course_exercise_analysis OWNER TO postgres;

--
-- Name: TABLE course_exercise_analysis; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_exercise_analysis IS '课程练习题解析';


--
-- Name: COLUMN course_exercise_analysis.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.id IS '流水号';


--
-- Name: COLUMN course_exercise_analysis.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.create_time IS '创建时间';


--
-- Name: COLUMN course_exercise_analysis.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.update_time IS '更新时间';


--
-- Name: COLUMN course_exercise_analysis.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.flag IS '标记';


--
-- Name: COLUMN course_exercise_analysis.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.course_id IS '课程ID';


--
-- Name: COLUMN course_exercise_analysis.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.video_id IS '视频ID';


--
-- Name: COLUMN course_exercise_analysis.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.exercise_id IS '练习题ID';


--
-- Name: COLUMN course_exercise_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_analysis.content IS '解析内容';


--
-- Name: course_exercise_answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_exercise_answer (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    content text
);


ALTER TABLE public.course_exercise_answer OWNER TO postgres;

--
-- Name: TABLE course_exercise_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_exercise_answer IS '课程练习题参考答案（主观题）';


--
-- Name: COLUMN course_exercise_answer.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.id IS '流水号';


--
-- Name: COLUMN course_exercise_answer.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.create_time IS '创建时间';


--
-- Name: COLUMN course_exercise_answer.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.update_time IS '更新时间';


--
-- Name: COLUMN course_exercise_answer.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.flag IS '标记';


--
-- Name: COLUMN course_exercise_answer.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.course_id IS '课程ID';


--
-- Name: COLUMN course_exercise_answer.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.video_id IS '视频ID';


--
-- Name: COLUMN course_exercise_answer.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.exercise_id IS '练习题ID';


--
-- Name: COLUMN course_exercise_answer.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_answer.content IS '解析内容';


--
-- Name: course_exercise_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_exercise_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    title character varying(1000),
    is_answer boolean DEFAULT false
);


ALTER TABLE public.course_exercise_item OWNER TO postgres;

--
-- Name: TABLE course_exercise_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_exercise_item IS '课程练习题选择';


--
-- Name: COLUMN course_exercise_item.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.id IS '流水号';


--
-- Name: COLUMN course_exercise_item.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.create_time IS '创建时间';


--
-- Name: COLUMN course_exercise_item.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.update_time IS '更新时间';


--
-- Name: COLUMN course_exercise_item.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.flag IS '标记';


--
-- Name: COLUMN course_exercise_item.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.course_id IS '课程ID';


--
-- Name: COLUMN course_exercise_item.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.video_id IS '视频ID';


--
-- Name: COLUMN course_exercise_item.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.exercise_id IS '练习题ID';


--
-- Name: COLUMN course_exercise_item.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.title IS '标题';


--
-- Name: COLUMN course_exercise_item.is_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_exercise_item.is_answer IS '是否参考答案';


--
-- Name: course_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_type (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    code character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    caption character varying(255),
    parent_id uuid
);


ALTER TABLE public.course_type OWNER TO postgres;

--
-- Name: TABLE course_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_type IS '课程类型';


--
-- Name: COLUMN course_type.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.id IS '流水号';


--
-- Name: COLUMN course_type.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.create_time IS '创建时间';


--
-- Name: COLUMN course_type.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.update_time IS '更新时间';


--
-- Name: COLUMN course_type.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.flag IS '标记';


--
-- Name: COLUMN course_type.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.code IS '编号';


--
-- Name: COLUMN course_type.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.name IS '名称';


--
-- Name: COLUMN course_type.caption; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.caption IS '备注';


--
-- Name: COLUMN course_type.parent_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_type.parent_id IS '所属课程类型ID';


--
-- Name: course_video; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_video (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    name character varying(200) NOT NULL,
    image character varying(100) NOT NULL,
    file_name character varying(300),
    file_path character varying(100),
    file_type character varying(10),
    file_size bigint,
    upload_time timestamp without time zone,
    introduction character varying(500),
    description text
);


ALTER TABLE public.course_video OWNER TO postgres;

--
-- Name: TABLE course_video; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_video IS '课程视频';


--
-- Name: COLUMN course_video.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.id IS '流水号';


--
-- Name: COLUMN course_video.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.create_time IS '创建时间';


--
-- Name: COLUMN course_video.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.update_time IS '更新时间';


--
-- Name: COLUMN course_video.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.flag IS '标记';


--
-- Name: COLUMN course_video.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.course_id IS '课程ID';


--
-- Name: COLUMN course_video.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.name IS '视频名称';


--
-- Name: COLUMN course_video.image; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.image IS '视频图片';


--
-- Name: COLUMN course_video.file_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.file_name IS '文件名称';


--
-- Name: COLUMN course_video.file_path; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.file_path IS '文件路径';


--
-- Name: COLUMN course_video.file_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.file_type IS '文件类型';


--
-- Name: COLUMN course_video.file_size; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.file_size IS '文件大小';


--
-- Name: COLUMN course_video.upload_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.upload_time IS '上传时间';


--
-- Name: COLUMN course_video.introduction; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.introduction IS '介绍';


--
-- Name: COLUMN course_video.description; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_video.description IS '描述';


--
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    category integer,
    code character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    phone character varying(15),
    boss_id uuid,
    boss_name character varying(50),
    parent_id uuid
);


ALTER TABLE public.department OWNER TO postgres;

--
-- Name: TABLE department; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.department IS '部门信息';


--
-- Name: COLUMN department.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.id IS '流水号';


--
-- Name: COLUMN department.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.create_time IS '创建时间';


--
-- Name: COLUMN department.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.update_time IS '更新时间';


--
-- Name: COLUMN department.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.flag IS '标记';


--
-- Name: COLUMN department.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.status IS '状态';


--
-- Name: COLUMN department.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.category IS '分类：1单位，2部门，3组';


--
-- Name: COLUMN department.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.code IS '部门编号';


--
-- Name: COLUMN department.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.name IS '部门名称';


--
-- Name: COLUMN department.phone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.phone IS '部门电话';


--
-- Name: COLUMN department.boss_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.boss_id IS '负责人ID';


--
-- Name: COLUMN department.boss_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.boss_name IS '负责人姓名';


--
-- Name: COLUMN department.parent_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.department.parent_id IS '上级ID';


--
-- Name: employee_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_account (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    department_id uuid,
    code character varying(50) NOT NULL,
    full_name character varying(50) NOT NULL,
    login_password character(40),
    lock_state boolean,
    position_id uuid
);


ALTER TABLE public.employee_account OWNER TO postgres;

--
-- Name: TABLE employee_account; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_account IS '员工基本信息';


--
-- Name: COLUMN employee_account.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.id IS '流水号';


--
-- Name: COLUMN employee_account.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.create_time IS '创建时间';


--
-- Name: COLUMN employee_account.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.update_time IS '更新时间';


--
-- Name: COLUMN employee_account.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.flag IS '标记';


--
-- Name: COLUMN employee_account.department_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.department_id IS '所属部门ID';


--
-- Name: COLUMN employee_account.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.code IS '员工编号';


--
-- Name: COLUMN employee_account.full_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.full_name IS '员工姓名';


--
-- Name: COLUMN employee_account.login_password; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.login_password IS '登录密码';


--
-- Name: COLUMN employee_account.lock_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.lock_state IS '锁定状态';


--
-- Name: COLUMN employee_account.position_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_account.position_id IS '职务ID';


--
-- Name: employee_course_exercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_course_exercise (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    employee_id uuid,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    answer_state boolean DEFAULT false
);


ALTER TABLE public.employee_course_exercise OWNER TO postgres;

--
-- Name: TABLE employee_course_exercise; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_course_exercise IS '课程练习题';


--
-- Name: COLUMN employee_course_exercise.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.id IS '流水号';


--
-- Name: COLUMN employee_course_exercise.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.create_time IS '创建时间';


--
-- Name: COLUMN employee_course_exercise.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.update_time IS '更新时间';


--
-- Name: COLUMN employee_course_exercise.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.flag IS '标记';


--
-- Name: COLUMN employee_course_exercise.employee_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.employee_id IS '员工ID';


--
-- Name: COLUMN employee_course_exercise.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.course_id IS '课程ID';


--
-- Name: COLUMN employee_course_exercise.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.video_id IS '视频ID';


--
-- Name: COLUMN employee_course_exercise.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.exercise_id IS '练习题题目ID';


--
-- Name: COLUMN employee_course_exercise.answer_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.answer_state IS '作答状态';


--
-- Name: employee_course_exercise_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_course_exercise_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    employee_id uuid,
    course_id uuid,
    video_id uuid,
    exercise_id uuid,
    item_id uuid
);


ALTER TABLE public.employee_course_exercise_item OWNER TO postgres;

--
-- Name: TABLE employee_course_exercise_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_course_exercise_item IS '课程练习题';


--
-- Name: COLUMN employee_course_exercise_item.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.id IS '流水号';


--
-- Name: COLUMN employee_course_exercise_item.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.create_time IS '创建时间';


--
-- Name: COLUMN employee_course_exercise_item.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.update_time IS '更新时间';


--
-- Name: COLUMN employee_course_exercise_item.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.flag IS '标记';


--
-- Name: COLUMN employee_course_exercise_item.employee_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.employee_id IS '员工ID';


--
-- Name: COLUMN employee_course_exercise_item.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.course_id IS '课程ID';


--
-- Name: COLUMN employee_course_exercise_item.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.video_id IS '视频ID';


--
-- Name: COLUMN employee_course_exercise_item.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.exercise_id IS '练习题题目ID';


--
-- Name: COLUMN employee_course_exercise_item.item_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.item_id IS '练习题选项ID';


--
-- Name: employee_course_study; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_course_study (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    employee_id uuid,
    course_id uuid,
    video_id uuid,
    study_time timestamp without time zone,
    study_amount integer DEFAULT 0
);


ALTER TABLE public.employee_course_study OWNER TO postgres;

--
-- Name: TABLE employee_course_study; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_course_study IS '课程练习题';


--
-- Name: COLUMN employee_course_study.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.id IS '流水号';


--
-- Name: COLUMN employee_course_study.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.create_time IS '创建时间';


--
-- Name: COLUMN employee_course_study.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.update_time IS '更新时间';


--
-- Name: COLUMN employee_course_study.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.flag IS '标记';


--
-- Name: COLUMN employee_course_study.employee_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.employee_id IS '员工ID';


--
-- Name: COLUMN employee_course_study.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.course_id IS '课程ID';


--
-- Name: COLUMN employee_course_study.video_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.video_id IS '视频ID';


--
-- Name: COLUMN employee_course_study.study_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.study_time IS '学习时间';


--
-- Name: COLUMN employee_course_study.study_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_study.study_amount IS '学习次数';


--
-- Name: employee_position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_position (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    employee_id uuid,
    position_id uuid
);


ALTER TABLE public.employee_position OWNER TO postgres;

--
-- Name: TABLE employee_position; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_position IS '员工职位';


--
-- Name: COLUMN employee_position.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_position.id IS '流水号';


--
-- Name: COLUMN employee_position.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_position.create_time IS '创建时间';


--
-- Name: COLUMN employee_position.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_position.update_time IS '更新时间';


--
-- Name: COLUMN employee_position.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_position.flag IS '标记';


--
-- Name: COLUMN employee_position.employee_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_position.employee_id IS '所属员工ID';


--
-- Name: COLUMN employee_position.position_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_position.position_id IS '所属职位ID';


--
-- Name: employee_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_role (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    employee_id uuid,
    role_id uuid
);


ALTER TABLE public.employee_role OWNER TO postgres;

--
-- Name: TABLE employee_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_role IS '员工角色';


--
-- Name: COLUMN employee_role.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_role.id IS '流水号';


--
-- Name: COLUMN employee_role.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_role.create_time IS '创建时间';


--
-- Name: COLUMN employee_role.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_role.update_time IS '更新时间';


--
-- Name: COLUMN employee_role.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_role.flag IS '标记';


--
-- Name: COLUMN employee_role.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_role.status IS '状态';


--
-- Name: COLUMN employee_role.employee_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_role.employee_id IS '所属员工ID';


--
-- Name: COLUMN employee_role.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_role.role_id IS '所属角色ID';


--
-- Name: examination_course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_course (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    paper_id uuid,
    content text
);


ALTER TABLE public.examination_course OWNER TO postgres;

--
-- Name: TABLE examination_course; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.examination_course IS '考试课程';


--
-- Name: COLUMN examination_course.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_course.id IS '流水号';


--
-- Name: COLUMN examination_course.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_course.create_time IS '创建时间';


--
-- Name: COLUMN examination_course.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_course.update_time IS '更新时间';


--
-- Name: COLUMN examination_course.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_course.flag IS '标记';


--
-- Name: COLUMN examination_course.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_course.course_id IS '课程ID';


--
-- Name: COLUMN examination_course.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_course.paper_id IS '考卷ID';


--
-- Name: examination_paper; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_paper (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    title character varying(300),
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    total_score integer DEFAULT 100,
    pass_score integer DEFAULT 60,
    duration integer DEFAULT 120,
    test_state integer DEFAULT 1,
    test_amount integer DEFAULT 1,
    single_type integer DEFAULT 1,
    single_amount integer,
    multi_type integer DEFAULT 1,
    multi_amount integer,
    check_type integer DEFAULT 1,
    check_amount integer,
    fill_type integer DEFAULT 1,
    fill_amount integer
);


ALTER TABLE public.examination_paper OWNER TO postgres;

--
-- Name: TABLE examination_paper; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.examination_paper IS '课程考试题参考答案（主观题）';


--
-- Name: COLUMN examination_paper.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.id IS '流水号';


--
-- Name: COLUMN examination_paper.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.create_time IS '创建时间';


--
-- Name: COLUMN examination_paper.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.update_time IS '更新时间';


--
-- Name: COLUMN examination_paper.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.flag IS '标记';


--
-- Name: COLUMN examination_paper.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.title IS '标题';


--
-- Name: COLUMN examination_paper.start_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.start_time IS '开始时间';


--
-- Name: COLUMN examination_paper.end_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.end_time IS '结束时间';


--
-- Name: COLUMN examination_paper.duration; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.duration IS '时长（单位：分钟）';


--
-- Name: COLUMN examination_paper.test_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.test_state IS '考试（测试）状态，1未开始，2已开始，3暂停中，4停止，5结束，6作废，7关闭';


--
-- Name: COLUMN examination_paper.test_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.test_amount IS '考试次数（补考次数）';


--
-- Name: COLUMN examination_paper.single_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.single_type IS '单选题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_paper.single_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.single_amount IS '单选题数量';


--
-- Name: COLUMN examination_paper.multi_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.multi_type IS '多选题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_paper.multi_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.multi_amount IS '多选题数量';


--
-- Name: COLUMN examination_paper.check_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.check_type IS '不定项选择题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_paper.check_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.check_amount IS '不定项选择题数量';


--
-- Name: COLUMN examination_paper.fill_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.fill_type IS '填空题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_paper.fill_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.fill_amount IS '填空题数量';


--
-- Name: examination_question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_question (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    paper_id uuid,
    question_id uuid,
    question_title character varying(1000),
    category integer DEFAULT 1,
    score integer DEFAULT 1
);


ALTER TABLE public.examination_question OWNER TO postgres;

--
-- Name: TABLE examination_question; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.examination_question IS '课程考试题';


--
-- Name: COLUMN examination_question.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.id IS '流水号';


--
-- Name: COLUMN examination_question.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.create_time IS '创建时间';


--
-- Name: COLUMN examination_question.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.update_time IS '更新时间';


--
-- Name: COLUMN examination_question.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.flag IS '标记';


--
-- Name: COLUMN examination_question.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.paper_id IS '考卷ID';


--
-- Name: COLUMN examination_question.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.question_id IS '试题ID';


--
-- Name: COLUMN examination_question.question_title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.question_title IS '试题标题';


--
-- Name: COLUMN examination_question.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.category IS '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';


--
-- Name: COLUMN examination_question.score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.score IS '分值';


--
-- Name: examination_question_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_question_analysis (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    paper_id uuid,
    question_id uuid,
    question_title character varying(1000),
    content text
);


ALTER TABLE public.examination_question_analysis OWNER TO postgres;

--
-- Name: TABLE examination_question_analysis; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.examination_question_analysis IS '课程考试题解析';


--
-- Name: COLUMN examination_question_analysis.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.id IS '流水号';


--
-- Name: COLUMN examination_question_analysis.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.create_time IS '创建时间';


--
-- Name: COLUMN examination_question_analysis.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.update_time IS '更新时间';


--
-- Name: COLUMN examination_question_analysis.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.flag IS '标记';


--
-- Name: COLUMN examination_question_analysis.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.paper_id IS '考卷ID';


--
-- Name: COLUMN examination_question_analysis.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.question_id IS '考题ID';


--
-- Name: COLUMN examination_question_analysis.question_title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.question_title IS '标题ID';


--
-- Name: COLUMN examination_question_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.content IS '解析内容';


--
-- Name: examination_question_answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_question_answer (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    paper_id uuid,
    question_id uuid,
    content text
);


ALTER TABLE public.examination_question_answer OWNER TO postgres;

--
-- Name: TABLE examination_question_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.examination_question_answer IS '课程考试题参考答案（主观题）';


--
-- Name: COLUMN examination_question_answer.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_answer.id IS '流水号';


--
-- Name: COLUMN examination_question_answer.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_answer.create_time IS '创建时间';


--
-- Name: COLUMN examination_question_answer.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_answer.update_time IS '更新时间';


--
-- Name: COLUMN examination_question_answer.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_answer.flag IS '标记';


--
-- Name: COLUMN examination_question_answer.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_answer.paper_id IS '考卷ID';


--
-- Name: COLUMN examination_question_answer.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_answer.question_id IS '考题ID';


--
-- Name: COLUMN examination_question_answer.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_answer.content IS '参考内容';


--
-- Name: examination_question_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_question_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    paper_id uuid,
    question_id uuid,
    title character varying(1000),
    is_answer boolean DEFAULT false
);


ALTER TABLE public.examination_question_item OWNER TO postgres;

--
-- Name: TABLE examination_question_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.examination_question_item IS '课程考试题选择';


--
-- Name: COLUMN examination_question_item.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.id IS '流水号';


--
-- Name: COLUMN examination_question_item.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.create_time IS '创建时间';


--
-- Name: COLUMN examination_question_item.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.update_time IS '更新时间';


--
-- Name: COLUMN examination_question_item.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.flag IS '标记';


--
-- Name: COLUMN examination_question_item.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.paper_id IS '考卷ID';


--
-- Name: COLUMN examination_question_item.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.question_id IS '考题ID';


--
-- Name: COLUMN examination_question_item.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.title IS '标题';


--
-- Name: COLUMN examination_question_item.is_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.is_answer IS '是否参考答案';


--
-- Name: sys_login_log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_login_log (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    username character varying(50),
    ip_address character varying(50),
    request_time timestamp without time zone,
    sessionid character varying(50),
    device_type character varying(50),
    browser_type character varying(200),
    login_state boolean,
    caption character varying(300)
);


ALTER TABLE public.sys_login_log OWNER TO postgres;

--
-- Name: TABLE sys_login_log; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_login_log IS '数字字典';


--
-- Name: COLUMN sys_login_log.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.id IS '流水号';


--
-- Name: COLUMN sys_login_log.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.create_time IS '创建时间';


--
-- Name: COLUMN sys_login_log.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.update_time IS '更新时间';


--
-- Name: COLUMN sys_login_log.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.flag IS '标记';


--
-- Name: COLUMN sys_login_log.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.status IS '状态';


--
-- Name: COLUMN sys_login_log.username; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.username IS '用户名';


--
-- Name: COLUMN sys_login_log.ip_address; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.ip_address IS 'IP地址';


--
-- Name: COLUMN sys_login_log.request_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.request_time IS '请求时间';


--
-- Name: COLUMN sys_login_log.sessionid; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.sessionid IS '会话ID';


--
-- Name: COLUMN sys_login_log.device_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.device_type IS '设备类型';


--
-- Name: COLUMN sys_login_log.browser_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.browser_type IS '浏览器类型';


--
-- Name: COLUMN sys_login_log.login_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.login_state IS '登录状态';


--
-- Name: COLUMN sys_login_log.caption; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_login_log.caption IS '备注';


--
-- Name: sys_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_menu (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    code character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    href character varying(255),
    category integer,
    icon character varying(100),
    css_class character varying(255),
    css_style character varying(255),
    caption character varying(300),
    show_state boolean DEFAULT false,
    serial_number integer DEFAULT 0,
    parent_id uuid
);


ALTER TABLE public.sys_menu OWNER TO postgres;

--
-- Name: TABLE sys_menu; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_menu IS '系统菜单';


--
-- Name: COLUMN sys_menu.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.id IS '流水号';


--
-- Name: COLUMN sys_menu.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.create_time IS '创建时间';


--
-- Name: COLUMN sys_menu.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.update_time IS '更新时间';


--
-- Name: COLUMN sys_menu.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.flag IS '标记';


--
-- Name: COLUMN sys_menu.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.code IS '菜单编号';


--
-- Name: COLUMN sys_menu.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.name IS '菜单名称';


--
-- Name: COLUMN sys_menu.href; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.href IS '链接地址';


--
-- Name: COLUMN sys_menu.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.category IS '类型：1菜单，2权限';


--
-- Name: COLUMN sys_menu.icon; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.icon IS '图标';


--
-- Name: COLUMN sys_menu.css_class; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.css_class IS 'html的class属性';


--
-- Name: COLUMN sys_menu.css_style; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.css_style IS 'html的style属性';


--
-- Name: COLUMN sys_menu.show_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.show_state IS '显示状态';


--
-- Name: COLUMN sys_menu.serial_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.serial_number IS '排序序号';


--
-- Name: COLUMN sys_menu.parent_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_menu.parent_id IS '所属父级ID';


--
-- Name: sys_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_role (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    code character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    caption character varying(300),
    show_state boolean DEFAULT false,
    serial_number integer DEFAULT 0
);


ALTER TABLE public.sys_role OWNER TO postgres;

--
-- Name: TABLE sys_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_role IS '角色信息';


--
-- Name: COLUMN sys_role.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.id IS '流水号';


--
-- Name: COLUMN sys_role.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.create_time IS '创建时间';


--
-- Name: COLUMN sys_role.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.update_time IS '更新时间';


--
-- Name: COLUMN sys_role.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.flag IS '标记';


--
-- Name: COLUMN sys_role.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.code IS '角色编号';


--
-- Name: COLUMN sys_role.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.name IS '角色姓名';


--
-- Name: COLUMN sys_role.caption; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.caption IS '备注';


--
-- Name: COLUMN sys_role.show_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.show_state IS '显示状态';


--
-- Name: COLUMN sys_role.serial_number; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role.serial_number IS '排序序号';


--
-- Name: sys_role_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_role_menu (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    role_id uuid,
    menu_id uuid
);


ALTER TABLE public.sys_role_menu OWNER TO postgres;

--
-- Name: TABLE sys_role_menu; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_role_menu IS '菜色菜单';


--
-- Name: COLUMN sys_role_menu.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.id IS '流水号';


--
-- Name: COLUMN sys_role_menu.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.create_time IS '创建时间';


--
-- Name: COLUMN sys_role_menu.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.update_time IS '更新时间';


--
-- Name: COLUMN sys_role_menu.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.flag IS '标记';


--
-- Name: COLUMN sys_role_menu.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.role_id IS '所属角色ID';


--
-- Name: COLUMN sys_role_menu.menu_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_menu.menu_id IS '所属菜单ID';


--
-- Name: sys_role_position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_role_position (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    role_id uuid,
    position_id uuid
);


ALTER TABLE public.sys_role_position OWNER TO postgres;

--
-- Name: TABLE sys_role_position; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_role_position IS '系统角色职务';


--
-- Name: COLUMN sys_role_position.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_position.id IS '流水号';


--
-- Name: COLUMN sys_role_position.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_position.create_time IS '创建时间';


--
-- Name: COLUMN sys_role_position.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_position.update_time IS '更新时间';


--
-- Name: COLUMN sys_role_position.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_position.flag IS '标记';


--
-- Name: COLUMN sys_role_position.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_position.role_id IS '所属角色ID';


--
-- Name: COLUMN sys_role_position.position_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_role_position.position_id IS '所属角色ID';


--
-- Name: teacher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teacher (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    full_name character varying(50) NOT NULL,
    title character varying(50),
    image character varying(100),
    introduction character varying(500),
    description text
);


ALTER TABLE public.teacher OWNER TO postgres;

--
-- Name: TABLE teacher; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.teacher IS '教师';


--
-- Name: COLUMN teacher.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.id IS '流水号';


--
-- Name: COLUMN teacher.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.create_time IS '创建时间';


--
-- Name: COLUMN teacher.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.update_time IS '更新时间';


--
-- Name: COLUMN teacher.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.flag IS '标记';


--
-- Name: COLUMN teacher.full_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.full_name IS '姓名';


--
-- Name: COLUMN teacher.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.title IS '职称';


--
-- Name: COLUMN teacher.image; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.image IS '相片';


--
-- Name: COLUMN teacher.introduction; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.introduction IS '简介';


--
-- Name: COLUMN teacher.description; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.teacher.description IS '描述';


--
-- Name: act_evt_log log_nr_; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_evt_log ALTER COLUMN log_nr_ SET DEFAULT nextval('public.act_evt_log_log_nr__seq'::regclass);


--
-- Data for Name: act_evt_log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_evt_log (log_nr_, type_, proc_def_id_, proc_inst_id_, execution_id_, task_id_, time_stamp_, user_id_, data_, lock_owner_, lock_time_, is_processed_) FROM stdin;
\.


--
-- Data for Name: act_ge_bytearray; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ge_bytearray (id_, rev_, name_, deployment_id_, bytes_, generated_) FROM stdin;
\.


--
-- Data for Name: act_ge_property; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ge_property (name_, value_, rev_) FROM stdin;
schema.version	6.0.0.4	1
schema.history	create(6.0.0.4)	1
next.dbid	1	1
cfg.execution-related-entities-count	false	1
\.


--
-- Data for Name: act_hi_actinst; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_actinst (id_, proc_def_id_, proc_inst_id_, execution_id_, act_id_, task_id_, call_proc_inst_id_, act_name_, act_type_, assignee_, start_time_, end_time_, duration_, delete_reason_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_hi_attachment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_attachment (id_, rev_, user_id_, name_, description_, type_, task_id_, proc_inst_id_, url_, content_id_, time_) FROM stdin;
\.


--
-- Data for Name: act_hi_comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_comment (id_, type_, time_, user_id_, task_id_, proc_inst_id_, action_, message_, full_msg_) FROM stdin;
\.


--
-- Data for Name: act_hi_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_detail (id_, type_, proc_inst_id_, execution_id_, task_id_, act_inst_id_, name_, var_type_, rev_, time_, bytearray_id_, double_, long_, text_, text2_) FROM stdin;
\.


--
-- Data for Name: act_hi_identitylink; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_identitylink (id_, group_id_, type_, user_id_, task_id_, proc_inst_id_) FROM stdin;
\.


--
-- Data for Name: act_hi_procinst; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_procinst (id_, proc_inst_id_, business_key_, proc_def_id_, start_time_, end_time_, duration_, start_user_id_, start_act_id_, end_act_id_, super_process_instance_id_, delete_reason_, tenant_id_, name_) FROM stdin;
\.


--
-- Data for Name: act_hi_taskinst; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_taskinst (id_, proc_def_id_, task_def_key_, proc_inst_id_, execution_id_, name_, parent_task_id_, description_, owner_, assignee_, start_time_, claim_time_, end_time_, duration_, delete_reason_, priority_, due_date_, form_key_, category_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_hi_varinst; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_hi_varinst (id_, proc_inst_id_, execution_id_, task_id_, name_, var_type_, rev_, bytearray_id_, double_, long_, text_, text2_, create_time_, last_updated_time_) FROM stdin;
\.


--
-- Data for Name: act_id_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_id_group (id_, rev_, name_, type_) FROM stdin;
\.


--
-- Data for Name: act_id_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_id_info (id_, rev_, user_id_, type_, key_, value_, password_, parent_id_) FROM stdin;
\.


--
-- Data for Name: act_id_membership; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_id_membership (user_id_, group_id_) FROM stdin;
\.


--
-- Data for Name: act_id_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_id_user (id_, rev_, first_, last_, email_, pwd_, picture_id_) FROM stdin;
\.


--
-- Data for Name: act_procdef_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_procdef_info (id_, proc_def_id_, rev_, info_json_id_) FROM stdin;
\.


--
-- Data for Name: act_re_deployment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_re_deployment (id_, name_, category_, key_, tenant_id_, deploy_time_, engine_version_) FROM stdin;
\.


--
-- Data for Name: act_re_model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_re_model (id_, rev_, name_, key_, category_, create_time_, last_update_time_, version_, meta_info_, deployment_id_, editor_source_value_id_, editor_source_extra_value_id_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_re_procdef; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_re_procdef (id_, rev_, category_, name_, key_, version_, deployment_id_, resource_name_, dgrm_resource_name_, description_, has_start_form_key_, has_graphical_notation_, suspension_state_, tenant_id_, engine_version_) FROM stdin;
\.


--
-- Data for Name: act_ru_deadletter_job; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_deadletter_job (id_, rev_, type_, exclusive_, execution_id_, process_instance_id_, proc_def_id_, exception_stack_id_, exception_msg_, duedate_, repeat_, handler_type_, handler_cfg_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_ru_event_subscr; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_event_subscr (id_, rev_, event_type_, event_name_, execution_id_, proc_inst_id_, activity_id_, configuration_, created_, proc_def_id_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_ru_execution; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_execution (id_, rev_, proc_inst_id_, business_key_, parent_id_, proc_def_id_, super_exec_, root_proc_inst_id_, act_id_, is_active_, is_concurrent_, is_scope_, is_event_scope_, is_mi_root_, suspension_state_, cached_ent_state_, tenant_id_, name_, start_time_, start_user_id_, lock_time_, is_count_enabled_, evt_subscr_count_, task_count_, job_count_, timer_job_count_, susp_job_count_, deadletter_job_count_, var_count_, id_link_count_) FROM stdin;
\.


--
-- Data for Name: act_ru_identitylink; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_identitylink (id_, rev_, group_id_, type_, user_id_, task_id_, proc_inst_id_, proc_def_id_) FROM stdin;
\.


--
-- Data for Name: act_ru_job; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_job (id_, rev_, type_, lock_exp_time_, lock_owner_, exclusive_, execution_id_, process_instance_id_, proc_def_id_, retries_, exception_stack_id_, exception_msg_, duedate_, repeat_, handler_type_, handler_cfg_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_ru_suspended_job; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_suspended_job (id_, rev_, type_, exclusive_, execution_id_, process_instance_id_, proc_def_id_, retries_, exception_stack_id_, exception_msg_, duedate_, repeat_, handler_type_, handler_cfg_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_ru_task; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_task (id_, rev_, execution_id_, proc_inst_id_, proc_def_id_, name_, parent_task_id_, description_, task_def_key_, owner_, assignee_, delegation_, priority_, create_time_, due_date_, category_, suspension_state_, tenant_id_, form_key_, claim_time_) FROM stdin;
\.


--
-- Data for Name: act_ru_timer_job; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_timer_job (id_, rev_, type_, lock_exp_time_, lock_owner_, exclusive_, execution_id_, process_instance_id_, proc_def_id_, retries_, exception_stack_id_, exception_msg_, duedate_, repeat_, handler_type_, handler_cfg_, tenant_id_) FROM stdin;
\.


--
-- Data for Name: act_ru_variable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act_ru_variable (id_, rev_, type_, name_, execution_id_, proc_inst_id_, task_id_, bytearray_id_, double_, long_, text_, text2_) FROM stdin;
\.


--
-- Data for Name: base_dictionary; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.base_dictionary (id, create_time, update_time, flag, status, code, name, caption, show_state) FROM stdin;
32bb7c70-b1f2-11e8-9e21-08d40c3d2417	2018-09-07 00:30:42.615	2018-09-07 00:38:36.941	t	t	sex	性别	\N	t
\.


--
-- Data for Name: base_dictionary_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.base_dictionary_item (id, create_time, update_time, flag, status, dictionary_id, item_text, item_value, show_state, serial_number) FROM stdin;
4d84fad0-b1f3-11e8-b769-08d40c3d2417	2018-09-07 00:38:37.053	2018-09-07 00:38:37.053	t	t	32bb7c70-b1f2-11e8-9e21-08d40c3d2417	男	male	t	1
4d8b8a80-b1f3-11e8-b769-08d40c3d2417	2018-09-07 00:38:37.096	2018-09-07 00:38:37.096	t	t	32bb7c70-b1f2-11e8-9e21-08d40c3d2417	女	female	t	1
\.


--
-- Data for Name: base_position; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.base_position (id, create_time, update_time, flag, status, code, name, caption, show_state, serial_number) FROM stdin;
ce07eaf0-b6a3-11e8-93b6-08d40c3d2417	2018-09-12 23:52:08.735	2018-09-12 23:52:08.735	t	t	1001	董事长	\N	t	0
e8fd29b0-b6a3-11e8-93b6-08d40c3d2417	2018-09-12 23:52:53.963	2018-09-12 23:52:53.963	t	t	1002	副董事长	\N	t	0
18296d20-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:54:13.106	2018-09-12 23:54:13.106	t	t	1003	总经理	\N	t	0
33ae1aa0-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:54:59.274	2018-09-12 23:54:59.274	t	t	1005	总裁	\N	t	0
4d29ffd0-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:55:42.029	2018-09-12 23:55:42.029	t	t	1006	副总裁	\N	t	0
6c2bed30-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:56:34.051	2018-09-12 23:56:34.051	t	t	1004	副总经理	\N	t	0
b0133260-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:58:27.974	2018-09-12 23:58:27.974	t	t	1007	人力资源总监	\N	t	0
b94be250-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:58:43.445	2018-09-12 23:58:43.445	t	t	1008	财务总监	\N	t	0
c68496b0-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:59:05.627	2018-09-12 23:59:05.627	t	t	1009	营销总监	\N	t	0
d8938b40-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:59:35.924	2018-09-12 23:59:35.924	t	t	1010	市场总监	\N	t	0
e53aae00-b6a4-11e8-93b6-08d40c3d2417	2018-09-12 23:59:57.152	2018-09-12 23:59:57.152	t	t	1011	销售总监	\N	t	0
f76c1eb0-b6a4-11e8-93b6-08d40c3d2417	2018-09-13 00:00:27.675	2018-09-13 00:00:27.675	t	t	1012	生产总监	\N	t	0
02ff6070-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:00:47.095	2018-09-13 00:01:00.724	t	t	1013	运营总监	\N	t	0
19637e50-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:01:24.661	2018-09-13 00:01:24.661	t	t	1014	技术总监	\N	t	0
32162010-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:02:06.097	2018-09-13 00:02:06.097	t	t	1015	总经理助理	\N	t	0
7b80d560-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:04:09.27	2018-09-13 00:04:09.27	t	t	1017	人力资源助理	\N	t	0
701d2f20-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:03:50.162	2018-09-13 00:04:29.204	t	t	1016	人力资源专员	\N	t	0
976fdd70-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:04:56.135	2018-09-13 00:04:56.135	t	t	1018	招聘主管	\N	t	0
a2635cc0-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:05:14.508	2018-09-13 00:05:14.508	t	t	1019	员工培训与发展主管	\N	t	0
ad237000-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:05:32.544	2018-09-13 00:05:32.544	t	t	1020	培训师	\N	t	0
c28a9040-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:06:08.452	2018-09-13 00:06:08.452	t	t	1021	培训专员	\N	t	0
e0689710-b6a5-11e8-93b6-08d40c3d2417	2018-09-13 00:06:58.561	2018-09-13 00:06:58.561	t	t	1022	绩效考核主管	\N	t	0
\.


--
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course (id, create_time, update_time, flag, status, type_id, teacher_id, code, name, introduction, description) FROM stdin;
\.


--
-- Data for Name: course_attachment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_attachment (id, create_time, update_time, flag, status, course_id, video_id, file_name, file_path, file_type, file_size, upload_time) FROM stdin;
\.


--
-- Data for Name: course_examination; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_examination (id, create_time, update_time, flag, status, course_id, video_id, title, category, score) FROM stdin;
\.


--
-- Data for Name: course_examination_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_examination_analysis (id, create_time, update_time, flag, status, course_id, video_id, exercise_id, content) FROM stdin;
\.


--
-- Data for Name: course_examination_answer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_examination_answer (id, create_time, update_time, flag, status, course_id, video_id, exercise_id, content) FROM stdin;
\.


--
-- Data for Name: course_examination_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_examination_item (id, create_time, update_time, flag, status, course_id, video_id, exercise_id, title, is_answer) FROM stdin;
\.


--
-- Data for Name: course_exercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_exercise (id, create_time, update_time, flag, status, course_id, video_id, title, category, score) FROM stdin;
\.


--
-- Data for Name: course_exercise_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_exercise_analysis (id, create_time, update_time, flag, status, course_id, video_id, exercise_id, content) FROM stdin;
\.


--
-- Data for Name: course_exercise_answer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_exercise_answer (id, create_time, update_time, flag, status, course_id, video_id, exercise_id, content) FROM stdin;
\.


--
-- Data for Name: course_exercise_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_exercise_item (id, create_time, update_time, flag, status, course_id, video_id, exercise_id, title, is_answer) FROM stdin;
\.


--
-- Data for Name: course_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_type (id, create_time, update_time, flag, status, code, name, caption, parent_id) FROM stdin;
f59cf370-c58b-11e8-965d-08d40c3d2417	2018-10-01 23:09:14.663	2018-10-01 23:09:14.663	t	t	jsjzy	计算机专业	\N	\N
0ef28bf0-c58c-11e8-965d-08d40c3d2417	2018-10-01 23:09:57.167	2018-10-01 23:09:57.167	t	t	jsjrj	计算机软件	\N	f59cf370-c58b-11e8-965d-08d40c3d2417
3bc17e70-c58c-11e8-965d-08d40c3d2417	2018-10-01 23:11:12.343	2018-10-01 23:11:12.343	t	t	jsjcxsj	计算机程序设计	\N	0ef28bf0-c58c-11e8-965d-08d40c3d2417
519717f0-c58c-11e8-965d-08d40c3d2417	2018-10-01 23:11:48.975	2018-10-01 23:11:48.975	t	t	sjk	数据库	\N	0ef28bf0-c58c-11e8-965d-08d40c3d2417
\.


--
-- Data for Name: course_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_video (id, create_time, update_time, flag, status, course_id, name, image, file_name, file_path, file_type, file_size, upload_time, introduction, description) FROM stdin;
\.


--
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (id, create_time, update_time, flag, status, category, code, name, phone, boss_id, boss_name, parent_id) FROM stdin;
62bd5580-b82b-11e8-b255-08d40c3d2417	2018-09-14 22:35:11.448	2018-09-14 22:35:11.448	t	t	2	1001	行政部	\N	\N	\N	\N
d6053490-b82b-11e8-b255-08d40c3d2417	2018-09-14 22:38:24.857	2018-09-14 22:38:24.857	t	t	2	1002	人事部	\N	\N	\N	\N
048711c0-b82d-11e8-be6b-08d40c3d2417	2018-09-14 22:46:52.38	2018-09-14 22:46:52.38	t	t	2	1003	生产部	\N	\N	\N	\N
6df37130-b82d-11e8-a766-08d40c3d2417	2018-09-14 22:49:49.251	2018-09-14 22:49:49.251	t	t	2	1004	A组	\N	\N	\N	048711c0-b82d-11e8-be6b-08d40c3d2417
1f530bb0-b82f-11e8-b0b3-08d40c3d2417	2018-09-14 23:01:56.331	2018-09-14 23:01:56.331	f	f	2	1005	B组	\N	\N	\N	\N
379b04c0-b82f-11e8-b0b3-08d40c3d2417	2018-09-14 23:02:37.068	2018-09-14 23:02:37.068	t	t	2	1005	B组	\N	\N	\N	048711c0-b82d-11e8-be6b-08d40c3d2417
7374de20-b830-11e8-983a-08d40c3d2417	2018-09-14 23:11:26.978	2018-09-14 23:11:26.978	t	t	2	1007	C组	\N	\N	\N	048711c0-b82d-11e8-be6b-08d40c3d2417
d5156740-b834-11e8-b9af-08d40c3d2417	2018-09-14 23:42:48.756	2018-09-14 23:42:48.756	t	t	2	1008	后勤部	\N	\N	\N	\N
64d4ffe0-bc26-11e8-a0d8-08d40c3d2417	2018-09-20 00:09:32.126	2018-09-20 00:09:57.899	t	t	1	1000	广州新咨力科技有限公司	\N	\N	\N	\N
9fe3b680-bc26-11e8-a0d8-08d40c3d2417	2018-09-20 00:11:11.208	2018-09-20 00:11:11.208	t	t	2	1010	研发中心	\N	\N	\N	64d4ffe0-bc26-11e8-a0d8-08d40c3d2417
c0246570-bc26-11e8-a0d8-08d40c3d2417	2018-09-20 00:12:05.319	2018-09-20 00:12:05.319	t	t	2	1012	商学院	\N	\N	\N	64d4ffe0-bc26-11e8-a0d8-08d40c3d2417
\.


--
-- Data for Name: employee_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_account (id, create_time, update_time, flag, status, department_id, code, full_name, login_password, lock_state, position_id) FROM stdin;
2884ffc0-9a31-11e8-be60-4cedfb4009ed	2018-08-07 21:33:36.570827	2018-08-07 21:33:36.570827	t	t	\N	admin	管理员	7c4a8d09ca3762af61e59520943dc26494f8941b	t	\N
13e9f8b0-c4dc-11e8-980f-08d40c3d2417	2018-10-01 02:10:14.075	2018-10-01 02:10:14.075	t	t	d6053490-b82b-11e8-b255-08d40c3d2417	1001	杜永生	7c4a8d09ca3762af61e59520943dc26494f8941b	f	e0689710-b6a5-11e8-93b6-08d40c3d2417
39fc5ed0-c4dc-11e8-980f-08d40c3d2417	2018-10-01 02:11:17.949	2018-10-01 02:11:17.949	t	t	62bd5580-b82b-11e8-b255-08d40c3d2417	1002	李敏婷	7c4a8d09ca3762af61e59520943dc26494f8941b	t	701d2f20-b6a5-11e8-93b6-08d40c3d2417
7eae1ff0-c4dc-11e8-980f-08d40c3d2417	2018-10-01 02:13:13.199	2018-10-01 02:13:13.199	t	t	c0246570-bc26-11e8-a0d8-08d40c3d2417	1003	黄琳	7c4a8d09ca3762af61e59520943dc26494f8941b	t	ad237000-b6a5-11e8-93b6-08d40c3d2417
102b9bb0-c4dd-11e8-980f-08d40c3d2417	2018-10-01 02:17:17.291	2018-10-01 02:17:17.291	t	t	379b04c0-b82f-11e8-b0b3-08d40c3d2417	1004	叶丽娥	7c4a8d09ca3762af61e59520943dc26494f8941b	t	32162010-b6a5-11e8-93b6-08d40c3d2417
5f137f90-c4dd-11e8-b1ed-08d40c3d2417	2018-10-01 02:19:29.673	2018-10-01 02:19:29.673	t	t	7374de20-b830-11e8-983a-08d40c3d2417	1005	刘伟良	7c4a8d09ca3762af61e59520943dc26494f8941b	f	19637e50-b6a5-11e8-93b6-08d40c3d2417
e4b62940-c4dd-11e8-b05f-08d40c3d2417	2018-10-01 02:23:13.876	2018-10-01 02:23:13.876	t	t	9fe3b680-bc26-11e8-a0d8-08d40c3d2417	1006	潘狄娜	7c4a8d09ca3762af61e59520943dc26494f8941b	t	b94be250-b6a4-11e8-93b6-08d40c3d2417
\.


--
-- Data for Name: employee_course_exercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_course_exercise (id, create_time, update_time, flag, status, employee_id, course_id, video_id, exercise_id, answer_state) FROM stdin;
\.


--
-- Data for Name: employee_course_exercise_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_course_exercise_item (id, create_time, update_time, flag, status, employee_id, course_id, video_id, exercise_id, item_id) FROM stdin;
\.


--
-- Data for Name: employee_course_study; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_course_study (id, create_time, update_time, flag, status, employee_id, course_id, video_id, study_time, study_amount) FROM stdin;
\.


--
-- Data for Name: employee_position; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_position (id, create_time, update_time, flag, status, employee_id, position_id) FROM stdin;
e4b6c580-c4dd-11e8-b05f-08d40c3d2417	2018-10-01 02:23:13.88	2018-10-01 02:23:13.88	t	t	e4b62940-c4dd-11e8-b05f-08d40c3d2417	b94be250-b6a4-11e8-93b6-08d40c3d2417
\.


--
-- Data for Name: employee_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_role (id, create_time, update_time, flag, status, employee_id, role_id) FROM stdin;
\.


--
-- Data for Name: examination_course; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_course (id, create_time, update_time, flag, status, course_id, paper_id, content) FROM stdin;
\.


--
-- Data for Name: examination_paper; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_paper (id, create_time, update_time, flag, status, title, start_time, end_time, total_score, pass_score, duration, test_state, test_amount, single_type, single_amount, multi_type, multi_amount, check_type, check_amount, fill_type, fill_amount) FROM stdin;
\.


--
-- Data for Name: examination_question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_question (id, create_time, update_time, flag, status, paper_id, question_id, question_title, category, score) FROM stdin;
\.


--
-- Data for Name: examination_question_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_question_analysis (id, create_time, update_time, flag, status, paper_id, question_id, question_title, content) FROM stdin;
\.


--
-- Data for Name: examination_question_answer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_question_answer (id, create_time, update_time, flag, status, paper_id, question_id, content) FROM stdin;
\.


--
-- Data for Name: examination_question_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_question_item (id, create_time, update_time, flag, status, paper_id, question_id, title, is_answer) FROM stdin;
\.


--
-- Data for Name: sys_login_log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sys_login_log (id, create_time, update_time, flag, status, username, ip_address, request_time, sessionid, device_type, browser_type, login_state, caption) FROM stdin;
cae566a0-9a46-11e8-9a02-4cedfb4009ed	2018-08-07 21:35:47.722	2018-08-07 21:35:47.722	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 21:35:47.72	588D83992A5406A03A7FFB497397C748	Computer	Internet Explorer 11	f	用户名不存在系统！
2620eeb0-9a4a-11e8-be6b-4cedfb4009ed	2018-08-07 21:59:49.275	2018-08-07 21:59:49.275	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 21:59:49.226	C9CA1A104E48B036507438588C7B9200	Computer	Internet Explorer 11	f	验证失败！
4db7aae0-9a4a-11e8-be6b-4cedfb4009ed	2018-08-07 22:00:55.694	2018-08-07 22:00:55.694	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 22:00:55.694	C9CA1A104E48B036507438588C7B9200	Computer	Internet Explorer 11	f	验证失败！
a6b642a0-9a4a-11e8-a4b4-4cedfb4009ed	2018-08-07 22:03:25.002	2018-08-07 22:03:25.002	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 22:03:24.954	21B16764AF6D3239818C482CA65FAF50	Computer	Internet Explorer 11	f	密码错误！
b5e94060-9a4a-11e8-a4b4-4cedfb4009ed	2018-08-07 22:03:50.502	2018-08-07 22:03:50.502	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 22:03:50.502	21B16764AF6D3239818C482CA65FAF50	Computer	Internet Explorer 11	t	成功登录！
225b8cd0-9a4b-11e8-a4b4-4cedfb4009ed	2018-08-07 22:06:52.445	2018-08-07 22:06:52.445	t	t	test1	0:0:0:0:0:0:0:1	2018-08-07 22:06:52.445	C35E81621A19C689809250AC8F916A00	Computer	Firefox	f	用户名不存在系统！
3f03d2c0-9a4b-11e8-a4b4-4cedfb4009ed	2018-08-07 22:07:40.524	2018-08-07 22:07:40.524	t	t	test1	0:0:0:0:0:0:0:1	2018-08-07 22:07:40.524	69E0AF5C7F614A193B6ECE574C934B79	Computer	Microsoft Edge	f	用户名不存在系统！
62c236c0-9a4b-11e8-a4b4-4cedfb4009ed	2018-08-07 22:08:40.492	2018-08-07 22:08:40.492	t	t	舰桥3	0:0:0:0:0:0:0:1	2018-08-07 22:08:40.492	B2198B816DB2F9A100ACAB8834EC04F3	Computer	Opera	f	用户名不存在系统！
2f09c990-9a4d-11e8-8f6c-4cedfb4009ed	2018-08-07 22:21:32.713	2018-08-07 22:21:32.713	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 22:21:32.666	B17882DB99B4FF02BFE0298ACE3A6891	Computer	Internet Explorer 11	t	成功登录！
559d4690-9a4d-11e8-9ce6-4cedfb4009ed	2018-08-07 22:22:37.433	2018-08-07 22:22:37.433	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 22:22:37.387	78045EAFCFE259C8E2B3CAF73EF14600	Computer	Firefox	t	成功登录！
ae1c4d10-9a58-11e8-a729-4cedfb4009ed	2018-08-07 23:43:50.369	2018-08-07 23:43:50.369	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 23:43:50.321	C28443D7190F9EAA293D6569AE794EBA	Computer	Internet Explorer 11	t	成功登录！
5491ac80-9a59-11e8-badb-4cedfb4009ed	2018-08-07 23:48:29.641	2018-08-07 23:48:29.641	t	t	admin	0:0:0:0:0:0:0:1	2018-08-07 23:48:29.592	06A94254A6FD0412E56779EE0AB3B612	Computer	Internet Explorer 11	t	成功登录！
289ee1d0-9a5c-11e8-8de5-4cedfb4009ed	2018-08-08 00:08:44.397	2018-08-08 00:08:44.397	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 00:08:44.34	60D119158977ACDF49ED82E44BE31959	Computer	Internet Explorer 11	t	成功登录！
9fe6cfe0-9a5d-11e8-9b02-4cedfb4009ed	2018-08-08 00:19:14.014	2018-08-08 00:19:14.014	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 00:19:13.966	9E99229AED45968AD9D7855764C8A7DE	Computer	Internet Explorer 11	t	成功登录！
bd827680-9a5d-11e8-9b02-4cedfb4009ed	2018-08-08 00:20:03.688	2018-08-08 00:20:03.688	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 00:20:03.688	9E99229AED45968AD9D7855764C8A7DE	Computer	Internet Explorer 11	t	成功登录！
bc713820-9a5e-11e8-8bc6-4cedfb4009ed	2018-08-08 00:27:11.394	2018-08-08 00:27:11.394	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 00:27:11.345	DA656A077263E0AF9FE8CF767E24362E	Computer	Chrome	t	成功登录！
a3f90320-9a65-11e8-a527-4cedfb4009ed	2018-08-08 01:16:36.818	2018-08-08 01:16:36.818	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 01:16:36.737	E73D1E054BA9EB651788CB6FB16ED283	Computer	Chrome	t	成功登录！
d1604a80-9b14-11e8-9916-4cedfb4009ed	2018-08-08 22:10:34.92	2018-08-08 22:10:34.92	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:10:34.857	AE62C18EA078BC1E34A0CEBFF156EA5C	Computer	Chrome	f	验证码不正确！
d4881760-9b14-11e8-9916-4cedfb4009ed	2018-08-08 22:10:40.214	2018-08-08 22:10:40.214	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:10:40.214	AE62C18EA078BC1E34A0CEBFF156EA5C	Computer	Chrome	t	成功登录！
84601cf0-9b15-11e8-9418-4cedfb4009ed	2018-08-08 22:15:35.231	2018-08-08 22:15:35.231	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:15:35.184	2AF9125AC5BA42956BEBE4CAF381D6AC	Computer	Chrome	t	成功登录！
e2798280-9b16-11e8-a3d3-4cedfb4009ed	2018-08-08 22:25:22.6	2018-08-08 22:25:22.6	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:25:22.552	65B0AAEF045A9DC3E4F0E71845AA63B5	Computer	Opera	t	成功登录！
0a39ca40-9b18-11e8-8d53-4cedfb4009ed	2018-08-08 22:33:38.788	2018-08-08 22:33:38.788	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:33:38.741	0AF6680B8F3291DC711B88790BD0D49A	Computer	Opera	f	密码错误！
0f797aa0-9b18-11e8-8d53-4cedfb4009ed	2018-08-08 22:33:47.594	2018-08-08 22:33:47.594	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:33:47.594	0AF6680B8F3291DC711B88790BD0D49A	Computer	Opera	t	成功登录！
9acd8240-9b18-11e8-b69c-4cedfb4009ed	2018-08-08 22:37:41.348	2018-08-08 22:37:41.348	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:37:41.302	21828286B9328AA122B90E60442600BB	Computer	Chrome	t	成功登录！
03969cd0-9b19-11e8-b69c-4cedfb4009ed	2018-08-08 22:40:37.149	2018-08-08 22:40:37.149	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:40:37.149	03DF02F40D013EBAC7EFA9D7C0BFB70D	Computer	Opera	t	成功登录！
69f3e780-9b19-11e8-a2f7-4cedfb4009ed	2018-08-08 22:43:28.888	2018-08-08 22:43:28.888	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:43:28.82	756F14C470A349F7C0B21EEF91F29716	Computer	Opera	t	成功登录！
ca893f00-9b19-11e8-a215-4cedfb4009ed	2018-08-08 22:46:10.928	2018-08-08 22:46:10.928	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:46:10.846	01CE0D884557191C430F7F5816590A83	Computer	Opera	t	成功登录！
72dd97a0-9b1a-11e8-9128-4cedfb4009ed	2018-08-08 22:50:53.338	2018-08-08 22:50:53.338	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:50:53.253	8B4183A01CCA540D387E6EC7045DE5FF	Computer	Opera	t	成功登录！
da254250-9b1a-11e8-9128-4cedfb4009ed	2018-08-08 22:53:46.613	2018-08-08 22:53:46.613	t	t	admin	0:0:0:0:0:0:0:1	2018-08-08 22:53:46.612	AB547575675F2AD036A7E106E8A8CC85	Computer	Chrome	t	成功登录！
8d65da10-9f07-11e8-a264-4cedfb4009ed	2018-08-13 22:45:42.065	2018-08-13 22:45:42.065	t	t	admin	0:0:0:0:0:0:0:1	2018-08-13 22:45:42.018	3DDB0F5E6A1CB3A927AEE65F35A5D4E5	Computer	Chrome	t	成功登录！
44f4d190-9f08-11e8-96c4-4cedfb4009ed	2018-08-13 22:50:50.025	2018-08-13 22:50:50.025	t	t	admin	0:0:0:0:0:0:0:1	2018-08-13 22:50:49.978	1F46FAD59B0C9C7267F33C0F05492BDB	Computer	Chrome	f	密码错误！
4c7f3540-9f08-11e8-96c4-4cedfb4009ed	2018-08-13 22:51:02.676	2018-08-13 22:51:02.676	t	t	admin	0:0:0:0:0:0:0:1	2018-08-13 22:51:02.676	1F46FAD59B0C9C7267F33C0F05492BDB	Computer	Chrome	t	成功登录！
3e404990-9f0a-11e8-bca3-4cedfb4009ed	2018-08-13 23:04:57.769	2018-08-13 23:04:57.769	t	t	admin	0:0:0:0:0:0:0:1	2018-08-13 23:04:57.714	097FA7DE1181C0E57EDD08DF448C53F9	Computer	Chrome	t	成功登录！
024a1c50-9f0e-11e8-bca3-4cedfb4009ed	2018-08-13 23:31:55.157	2018-08-13 23:31:55.157	t	t	admin	0:0:0:0:0:0:0:1	2018-08-13 23:31:55.156	3434311E8C8F8C28FD04AE8E84AAC0A4	Computer	Opera	t	成功登录！
b081e290-9f12-11e8-ad50-4cedfb4009ed	2018-08-14 00:05:25.433	2018-08-14 00:05:25.433	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 00:05:25.386	2E20984D1EC537AB3C9D4EF11714EB3C	Computer	Chrome	t	成功登录！
0d4b5b60-9fcb-11e8-a6d8-4cedfb4009ed	2018-08-14 22:05:08.502	2018-08-14 22:05:08.502	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 22:05:08.454	A3C9DA86277328308BC0A06016DB20A1	Computer	Chrome	t	成功登录！
956841f0-9fcd-11e8-8192-4cedfb4009ed	2018-08-14 22:23:15.855	2018-08-14 22:23:15.855	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 22:23:15.806	91D67F281137F9DEC932AC48A3AE0774	Computer	Opera	t	成功登录！
6ec53f20-9fce-11e8-a3a0-4cedfb4009ed	2018-08-14 22:29:20.53	2018-08-14 22:29:20.53	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 22:29:20.482	27B3708EA77335CB0BA486F68577277F	Computer	Chrome	t	成功登录！
3b52f820-9fcf-11e8-8674-4cedfb4009ed	2018-08-14 22:35:03.715	2018-08-14 22:35:03.715	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 22:35:03.641	D24AB4C7B074C4E9E336B90DBDDA2A68	Computer	Chrome	t	成功登录！
25760440-9fd2-11e8-ac54-4cedfb4009ed	2018-08-14 22:55:55.524	2018-08-14 22:55:55.524	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 22:55:55.474	9BD676AA5356D1F4D859024DB9B20507	Computer	Chrome	f	密码错误！
2a8a85f0-9fd2-11e8-ac54-4cedfb4009ed	2018-08-14 22:56:04.047	2018-08-14 22:56:04.047	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 22:56:04.047	9BD676AA5356D1F4D859024DB9B20507	Computer	Chrome	t	成功登录！
0faf7400-9fd4-11e8-a94b-4cedfb4009ed	2018-08-14 23:09:37.984	2018-08-14 23:09:37.984	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 23:09:37.933	51D10FF061185C026D3CAB66DDF3C1A7	Computer	Chrome	t	成功登录！
78c07790-9fd5-11e8-83f2-4cedfb4009ed	2018-08-14 23:19:43.753	2018-08-14 23:19:43.753	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 23:19:43.701	3430BA92306BDF6D1A78C75AD176FA56	Computer	Chrome	t	成功登录！
b7889740-9fd6-11e8-be42-4cedfb4009ed	2018-08-14 23:28:38.58	2018-08-14 23:28:38.58	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 23:28:38.53	AD73E4B43F5FB19227593357F6A6D1C9	Computer	Chrome	t	成功登录！
05574d80-9fd8-11e8-96f0-4cedfb4009ed	2018-08-14 23:37:58.616	2018-08-14 23:37:58.616	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 23:37:58.559	4DE06E775AFC2363B6FAAF024988B8AA	Computer	Chrome	t	成功登录！
9092d930-9fda-11e8-90f3-4cedfb4009ed	2018-08-14 23:56:11.203	2018-08-14 23:56:11.203	t	t	admin	0:0:0:0:0:0:0:1	2018-08-14 23:56:11.154	4B71A406B0A866EF0092584A99D6C94A	Computer	Chrome	t	成功登录！
37556e40-9fdb-11e8-a17a-4cedfb4009ed	2018-08-15 00:00:50.98	2018-08-15 00:00:50.98	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:00:50.929	83244C9BBA9527927A85001D99BAE216	Computer	Chrome	t	成功登录！
b7f808a0-9fdb-11e8-9c29-4cedfb4009ed	2018-08-15 00:04:26.794	2018-08-15 00:04:26.794	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:04:26.741	7C2282A608A8E7FE37C39B194D0C6B23	Computer	Chrome	t	成功登录！
f9faaf50-9fdb-11e8-a1c0-4cedfb4009ed	2018-08-15 00:06:17.541	2018-08-15 00:06:17.541	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:06:17.492	788D37ACD208100ED4647B4DCB5E44BD	Computer	Chrome	t	成功登录！
c847a480-9fdc-11e8-882c-4cedfb4009ed	2018-08-15 00:12:03.657	2018-08-15 00:12:03.657	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:12:03.604	60E5DCCA0B44E705DDAE03444F23687D	Computer	Chrome	t	成功登录！
c847cb90-9fdc-11e8-882c-4cedfb4009ed	2018-08-15 00:12:03.657	2018-08-15 00:12:03.657	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:12:03.604	60E5DCCA0B44E705DDAE03444F23687D	Computer	Chrome	t	成功登录！
5b310c50-9fdd-11e8-bf6b-4cedfb4009ed	2018-08-15 00:16:10.133	2018-08-15 00:16:10.133	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:16:10.08	72880E2AB3A689D3AF0DB377441266FB	Computer	Chrome	t	成功登录！
abf33900-9fde-11e8-a40b-4cedfb4009ed	2018-08-15 00:25:35.12	2018-08-15 00:25:35.12	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:25:35.06	531B9E28D6E367E6B41464D83A86BEF1	Computer	Chrome	t	成功登录！
3976cad0-9fdf-11e8-839a-4cedfb4009ed	2018-08-15 00:29:32.542	2018-08-15 00:29:32.542	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:29:32.485	576B56EBBF6A4CE3EABBF53ED42A856C	Computer	Chrome	t	成功登录！
0e03f070-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:35:29.143	2018-08-15 00:35:29.143	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:35:29.088	04C0C0C7E0AECDBB4758FF4070D83032	Computer	Chrome	t	成功登录！
575fbc30-9fe1-11e8-8968-4cedfb4009ed	2018-08-15 00:44:41.715	2018-08-15 00:44:41.715	t	t	admin	0:0:0:0:0:0:0:1	2018-08-15 00:44:41.714	386E7B01CF8BE23BA5F1B74BAA697ED3	Computer	Chrome	t	成功登录！
67e0dc80-add1-11e8-8c5c-08d40c3d2417	2018-09-01 18:25:53.736	2018-09-01 18:25:53.736	t	t	admin	0:0:0:0:0:0:0:1	2018-09-01 18:25:53.473	31EE6741468FF832EDCDA61A1FCDEE15	Computer	Chrome	t	成功登录！
a1604b20-add2-11e8-b1a4-4cedfb4009ed	2018-09-01 18:34:39.698	2018-09-01 18:34:39.698	t	t	admin	0:0:0:0:0:0:0:1	2018-09-01 18:34:39.651	BA680D4AC1D2340086CF57A3CB1AECDC	Computer	Chrome	t	成功登录！
1567b760-add8-11e8-9dac-08d40c3d2417	2018-09-01 19:13:41.846	2018-09-01 19:13:41.846	t	t	admin	0:0:0:0:0:0:0:1	2018-09-01 19:13:41.577	3C96CB48015F40405ACC17075F72056D	Computer	Chrome	t	成功登录！
a801f120-ae01-11e8-9b8e-08d40c3d2417	2018-09-02 00:11:17.17	2018-09-02 00:11:17.17	t	t	admin	0:0:0:0:0:0:0:1	2018-09-02 00:11:16.889	15069D30CDAC6B7432EBCBFE0B8F4E24	Computer	Chrome	t	成功登录！
56687a70-ae04-11e8-89e0-08d40c3d2417	2018-09-02 00:30:28.759	2018-09-02 00:30:28.759	t	t	admin	0:0:0:0:0:0:0:1	2018-09-02 00:30:28.545	286D29D2EEA5A5B68CEBF175BE026C68	Computer	Chrome	f	密码错误！
5f51aad0-ae04-11e8-89e0-08d40c3d2417	2018-09-02 00:30:43.709	2018-09-02 00:30:43.709	t	t	admin	0:0:0:0:0:0:0:1	2018-09-02 00:30:43.708	286D29D2EEA5A5B68CEBF175BE026C68	Computer	Chrome	t	成功登录！
b27849d0-ae04-11e8-aaf0-08d40c3d2417	2018-09-02 00:33:03.213	2018-09-02 00:33:03.213	t	t	admin	127.0.0.1	2018-09-02 00:33:02.999	ED4D4DF260B2F386DBA20ED5BC00EDDC	Computer	Chrome	t	成功登录！
daad2fe0-ae06-11e8-bf8f-08d40c3d2417	2018-09-02 00:48:29.662	2018-09-02 00:48:29.662	t	t	admin	127.0.0.1	2018-09-02 00:48:29.43	85A9964A51AA3EB52A9E03F044FC37A8	Computer	Chrome	f	密码错误！
dfe84c60-ae06-11e8-bf8f-08d40c3d2417	2018-09-02 00:48:38.438	2018-09-02 00:48:38.438	t	t	admin	127.0.0.1	2018-09-02 00:48:38.438	85A9964A51AA3EB52A9E03F044FC37A8	Computer	Chrome	t	成功登录！
00baae00-ae49-11e8-bf8f-08d40c3d2417	2018-09-02 08:42:00.288	2018-09-02 08:42:00.288	t	t	admin	127.0.0.1	2018-09-02 08:42:00.288	E529AB8219BC6AA1BD0091ED7252E86F	Computer	Chrome	t	成功登录！
fa01b350-b1e6-11e8-b1d4-08d40c3d2417	2018-09-06 23:10:22.981	2018-09-06 23:10:22.981	t	t	admin	127.0.0.1	2018-09-06 23:10:22.71	0C196E9AFA5DFA2B7B36802804CE4705	Computer	Chrome	f	密码错误！
ff904700-b1e6-11e8-b1d4-08d40c3d2417	2018-09-06 23:10:32.304	2018-09-06 23:10:32.304	t	t	admin	127.0.0.1	2018-09-06 23:10:32.302	0C196E9AFA5DFA2B7B36802804CE4705	Computer	Chrome	t	成功登录！
0e731700-b1e9-11e8-a65d-08d40c3d2417	2018-09-06 23:25:16.272	2018-09-06 23:25:16.272	t	t	admin	127.0.0.1	2018-09-06 23:25:16.046	52604EFAD907FC0071BE16196F2CB0EC	Computer	Chrome	t	成功登录！
35e7c4e0-b1ec-11e8-82c1-08d40c3d2417	2018-09-06 23:47:50.959	2018-09-06 23:47:50.959	t	t	admin	127.0.0.1	2018-09-06 23:47:50.695	38C2F14E274D14CDC921486199347216	Computer	Chrome	t	成功登录！
afd2b4e0-b1ec-11e8-9be1-08d40c3d2417	2018-09-06 23:51:15.502	2018-09-06 23:51:15.502	t	t	admin	127.0.0.1	2018-09-06 23:51:15.285	B3AB9007516F43E613DFCFAF49BC3B55	Computer	Chrome	t	成功登录！
91186590-b1f1-11e8-9e21-08d40c3d2417	2018-09-07 00:26:11.433	2018-09-07 00:26:11.433	t	t	admin	127.0.0.1	2018-09-07 00:26:11.221	89BC2E6E5AE4CBEF690C6F6C6E583F74	Computer	Chrome	t	成功登录！
3449c820-b1f3-11e8-b769-08d40c3d2417	2018-09-07 00:37:54.722	2018-09-07 00:37:54.722	t	t	admin	127.0.0.1	2018-09-07 00:37:54.493	69AD7D28CF9B129D21D0C474BAFBEB60	Computer	Chrome	t	成功登录！
9f067fe0-b1f4-11e8-b076-08d40c3d2417	2018-09-07 00:48:03.294	2018-09-07 00:48:03.294	t	t	admin	127.0.0.1	2018-09-07 00:48:03.034	AAC673788753581EC7B7ED1F3AF6A0AA	Computer	Chrome	t	成功登录！
9ff86320-b698-11e8-9fd3-08d40c3d2417	2018-09-12 22:32:06.994	2018-09-12 22:32:06.994	t	t	admin	127.0.0.1	2018-09-12 22:32:06.647	7A3FB836C166DCF1E5F65680B647130F	Computer	Chrome	t	成功登录！
a525d920-b69a-11e8-bb48-08d40c3d2417	2018-09-12 22:46:34.674	2018-09-12 22:46:34.674	t	t	admin	127.0.0.1	2018-09-12 22:46:34.384	4AA3104D97049515510ED1775BB7B2C8	Computer	Chrome	t	成功登录！
4b872970-b69d-11e8-aa50-08d40c3d2417	2018-09-12 23:05:32.807	2018-09-12 23:05:32.807	t	t	admin	127.0.0.1	2018-09-12 23:05:32.561	B99D8B4269B1C01286E77A974125645E	Computer	Chrome	t	成功登录！
01d5b1b0-b69e-11e8-b1f0-08d40c3d2417	2018-09-12 23:10:38.667	2018-09-12 23:10:38.667	t	t	admin	127.0.0.1	2018-09-12 23:10:38.276	CB71EA6D37E3EB76D89D4F0AB0C4BB12	Computer	Chrome	t	成功登录！
f5214120-b6a0-11e8-ad13-08d40c3d2417	2018-09-12 23:31:45.842	2018-09-12 23:31:45.842	t	t	admin	127.0.0.1	2018-09-12 23:31:45.418	4D4027B673EF4341CF6BE913AEE222FB	Computer	Chrome	t	成功登录！
d0297d50-b6a1-11e8-817d-08d40c3d2417	2018-09-12 23:37:53.317	2018-09-12 23:37:53.317	t	t	admin	127.0.0.1	2018-09-12 23:37:52.986	556F1A98F3A0E5705CE62D41797DE551	Computer	Chrome	t	成功登录！
4f0b7bf0-b6a2-11e8-93b6-08d40c3d2417	2018-09-12 23:41:26.192	2018-09-12 23:41:26.192	t	t	admin	127.0.0.1	2018-09-12 23:41:25.687	65D2D7767C29D6648B75EE56D4C7B1AA	Computer	Chrome	t	成功登录！
d9bfd970-b6a8-11e8-8ccb-08d40c3d2417	2018-09-13 00:28:15.879	2018-09-13 00:28:15.879	t	t	admin	127.0.0.1	2018-09-13 00:28:15.471	2FB0867BADA33B8A6A62113872A22A9B	Computer	Chrome	t	成功登录！
7e675970-b727-11e8-af1d-08d40c3d2417	2018-09-13 15:34:48.711	2018-09-13 15:34:48.711	t	t	admin	127.0.0.1	2018-09-13 15:34:48.4	D1D6B8EAC5895961E66530A8135BA78A	Computer	Chrome	t	成功登录！
cb4144e0-b727-11e8-b9fd-08d40c3d2417	2018-09-13 15:36:57.646	2018-09-13 15:36:57.646	t	t	admin	127.0.0.1	2018-09-13 15:36:57.268	4B696317BD67DE343D41C335B398970B	Computer	Chrome	t	成功登录！
fa2442f0-b72a-11e8-b686-08d40c3d2417	2018-09-13 15:59:44.799	2018-09-13 15:59:44.799	t	t	admin	127.0.0.1	2018-09-13 15:59:44.532	5957F408F360E29BAFD89E543091DB78	Computer	Chrome	t	成功登录！
4484ad70-b72c-11e8-989a-08d40c3d2417	2018-09-13 16:08:59.079	2018-09-13 16:08:59.079	t	t	admin	127.0.0.1	2018-09-13 16:08:58.791	35F4EA37F7EA0906FEB0270B001612DC	Computer	Chrome	t	成功登录！
6c900090-b730-11e8-bd27-08d40c3d2417	2018-09-13 16:38:44.249	2018-09-13 16:38:44.249	t	t	admin	127.0.0.1	2018-09-13 16:38:43.922	0EF9D6DC4268AB6D08D237C8987CCCA3	Computer	Chrome	t	成功登录！
2d7d9f30-b734-11e8-82ba-08d40c3d2417	2018-09-13 17:05:36.419	2018-09-13 17:05:36.419	t	t	admin	127.0.0.1	2018-09-13 17:05:36.133	C9C1965D48FD7C454CEC760975E01A9C	Computer	Chrome	t	成功登录！
9f380070-b734-11e8-a462-08d40c3d2417	2018-09-13 17:08:47.223	2018-09-13 17:08:47.223	t	t	admin	127.0.0.1	2018-09-13 17:08:46.95	F9E9EC67E76E07CCD3F97556C656C56E	Computer	Chrome	t	成功登录！
6a8b2120-b736-11e8-8945-08d40c3d2417	2018-09-13 17:21:37.842	2018-09-13 17:21:37.842	t	t	admin	127.0.0.1	2018-09-13 17:21:37.597	BB0B9287D6A2E9D0D431819A86A66A27	Computer	Chrome	t	成功登录！
a2a80690-b808-11e8-a8e8-08d40c3d2417	2018-09-14 18:26:26.297	2018-09-14 18:26:26.297	t	t	admin	127.0.0.1	2018-09-14 18:26:26.007	BEC1E2757F1AF622461467D900E62553	Computer	Chrome	f	验证码不正确！
aab507c0-b808-11e8-a8e8-08d40c3d2417	2018-09-14 18:26:39.804	2018-09-14 18:26:39.804	t	t	admin	127.0.0.1	2018-09-14 18:26:39.803	BEC1E2757F1AF622461467D900E62553	Computer	Chrome	t	成功登录！
35880770-b828-11e8-b888-08d40c3d2417	2018-09-14 22:12:27.111	2018-09-14 22:12:27.111	t	t	admin	127.0.0.1	2018-09-14 22:12:26.768	89DC5F070225EA913668F7006EB8A60C	Computer	Chrome	t	成功登录！
62d5aa60-b829-11e8-b829-08d40c3d2417	2018-09-14 22:20:52.614	2018-09-14 22:20:52.614	t	t	admin	127.0.0.1	2018-09-14 22:20:52.364	D04D6023535C5BFB39D4CEF1722D86C3	Computer	Chrome	t	成功登录！
4e92fb00-b82b-11e8-b255-08d40c3d2417	2018-09-14 22:34:37.616	2018-09-14 22:34:37.616	t	t	admin	127.0.0.1	2018-09-14 22:34:37.359	736DEAAAFC831A73ABDBA7C47582C95E	Computer	Chrome	t	成功登录！
30dd9560-b82c-11e8-b82c-08d40c3d2417	2018-09-14 22:40:57.27	2018-09-14 22:40:57.27	t	t	admin	127.0.0.1	2018-09-14 22:40:57.022	F1F1667A05BFD957F57C59E5DFC5805C	Computer	Chrome	t	成功登录！
717624c0-b82c-11e8-827c-08d40c3d2417	2018-09-14 22:42:45.644	2018-09-14 22:42:45.644	t	t	admin	127.0.0.1	2018-09-14 22:42:45.409	905312E3AAFDA2013EBCB92C1CCAF416	Computer	Chrome	t	成功登录！
d997b4b0-b82c-11e8-be6b-08d40c3d2417	2018-09-14 22:45:40.347	2018-09-14 22:45:40.347	t	t	admin	127.0.0.1	2018-09-14 22:45:40.093	B3B8F16061684B002855E197539CD294	Computer	Chrome	t	成功登录！
4e7b9080-b82d-11e8-a766-08d40c3d2417	2018-09-14 22:48:56.456	2018-09-14 22:48:56.456	t	t	admin	127.0.0.1	2018-09-14 22:48:56.16	B373E27FE2B2E925CA33599E1FA02D2C	Computer	Chrome	t	成功登录！
71b4a270-b82e-11e8-86ae-08d40c3d2417	2018-09-14 22:57:05.047	2018-09-14 22:57:05.047	t	t	admin	127.0.0.1	2018-09-14 22:57:04.746	574A649BEEFF986DD64A6A836DDFA9A3	Computer	Chrome	t	成功登录！
05c1f0d0-b82f-11e8-b0b3-08d40c3d2417	2018-09-14 23:01:13.437	2018-09-14 23:01:13.437	t	t	admin	127.0.0.1	2018-09-14 23:01:13.177	DBC4E4D134EF3974FB2DE16397481B78	Computer	Chrome	t	成功登录！
10dc1580-b830-11e8-983a-08d40c3d2417	2018-09-14 23:08:41.56	2018-09-14 23:08:41.56	t	t	admin	127.0.0.1	2018-09-14 23:08:41.294	7F3BDA81F8717A716C34CE563FEA57CF	Computer	Chrome	t	成功登录！
85e49ae0-b831-11e8-9f80-08d40c3d2417	2018-09-14 23:19:07.407	2018-09-14 23:19:07.407	t	t	admin	127.0.0.1	2018-09-14 23:19:07.103	B3D9982D8ABBEB45AFFCE3E296C49511	Computer	Chrome	t	成功登录！
910ca240-b832-11e8-a9bf-08d40c3d2417	2018-09-14 23:26:35.62	2018-09-14 23:26:35.62	t	t	admin	127.0.0.1	2018-09-14 23:26:35.369	94A536D5201C2D30C14CECF1C36B72C2	Computer	Chrome	t	成功登录！
fd44af60-b833-11e8-9f9d-08d40c3d2417	2018-09-14 23:36:46.678	2018-09-14 23:36:46.678	t	t	admin	127.0.0.1	2018-09-14 23:36:46.386	7BFE4EE0909BCB3DD4A645E245E8AF13	Computer	Chrome	t	成功登录！
70bf1020-b834-11e8-b9af-08d40c3d2417	2018-09-14 23:40:00.418	2018-09-14 23:40:00.418	t	t	admin	127.0.0.1	2018-09-14 23:40:00.127	358859B148DAEDB1B77743FC52CC6899	Computer	Chrome	t	成功登录！
2271e720-bbcd-11e8-b772-08d40c3d2417	2018-09-19 13:30:35.538	2018-09-19 13:30:35.538	t	t	admin	0:0:0:0:0:0:0:1	2018-09-19 13:30:35.287	7CE5BD67D5E263EF0F4DEAFCC6822CBA	Computer	Chrome	t	成功登录！
aeaeaed0-bbd2-11e8-b7c7-08d40c3d2417	2018-09-19 14:10:18.301	2018-09-19 14:10:18.301	t	t	admin	127.0.0.1	2018-09-19 14:10:18.001	FF3CB2E11D9B1E5A03F3C527EE01042C	Computer	Chrome	t	成功登录！
d4f6be90-bc0c-11e8-9c8c-08d40c3d2417	2018-09-19 21:06:33.337	2018-09-19 21:06:33.337	t	t	admin	127.0.0.1	2018-09-19 21:06:33.072	154355B86884CAE3226EF9D8EF5592A1	Computer	Chrome	t	成功登录！
e2f9ece0-bc22-11e8-8bfb-08d40c3d2417	2018-09-19 23:44:25.775	2018-09-19 23:44:25.775	t	t	admin	127.0.0.1	2018-09-19 23:44:25.532	A084AF21AEF2088FDC922CEBE714E6F8	Computer	Chrome	t	成功登录！
03ef33e0-bc25-11e8-a0d8-08d40c3d2417	2018-09-19 23:59:40.062	2018-09-19 23:59:40.062	t	t	admin	127.0.0.1	2018-09-19 23:59:39.76	EECFF3D85981D6F290237A3D5491ED38	Computer	Chrome	t	成功登录！
b60bd3f0-c4c5-11e8-a029-08d40c3d2417	2018-09-30 23:30:07.663	2018-09-30 23:30:07.663	t	t	admin	0:0:0:0:0:0:0:1	2018-09-30 23:30:07.348	4139CD4F9B18009CD689C69C8C15BB73	Computer	Chrome	f	密码错误！
bf709cf0-c4c5-11e8-a029-08d40c3d2417	2018-09-30 23:30:23.423	2018-09-30 23:30:23.423	t	t	admin	0:0:0:0:0:0:0:1	2018-09-30 23:30:23.423	4139CD4F9B18009CD689C69C8C15BB73	Computer	Chrome	t	成功登录！
c3c1d930-c4c6-11e8-acfb-08d40c3d2417	2018-09-30 23:37:40.163	2018-09-30 23:37:40.163	t	t	admin	127.0.0.1	2018-09-30 23:37:39.915	34CBAAA48757293592AE0C220F4DFC95	Computer	Chrome	t	成功登录！
05c53ad0-c4d5-11e8-a7ca-08d40c3d2417	2018-10-01 01:19:43.869	2018-10-01 01:19:43.869	t	t	admin	127.0.0.1	2018-10-01 01:19:43.451	4534E3E623D826EE702351E05CF708D3	Computer	Chrome	f	验证失败！
0b823180-c4d5-11e8-a7ca-08d40c3d2417	2018-10-01 01:19:53.496	2018-10-01 01:19:53.496	t	t	admin	127.0.0.1	2018-10-01 01:19:53.495	4534E3E623D826EE702351E05CF708D3	Computer	Chrome	f	验证失败！
15ac1f40-c4d5-11e8-a7ca-08d40c3d2417	2018-10-01 01:20:10.548	2018-10-01 01:20:10.548	t	t	admin	127.0.0.1	2018-10-01 01:20:10.548	4534E3E623D826EE702351E05CF708D3	Computer	Chrome	f	验证失败！
76cf85f0-c4d5-11e8-8663-08d40c3d2417	2018-10-01 01:22:53.519	2018-10-01 01:22:53.519	t	t	admin	127.0.0.1	2018-10-01 01:22:53.253	5D97FF51A187F9E2CF41CF77D73139E1	Computer	Chrome	t	成功登录！
bdb5abe0-c4d8-11e8-980f-08d40c3d2417	2018-10-01 01:46:20.958	2018-10-01 01:46:20.958	t	t	admin	127.0.0.1	2018-10-01 01:46:20.659	DCF5DD6E83856571901FA9608D61EF08	Computer	Chrome	t	成功登录！
3f93fdc0-c4dd-11e8-b1ed-08d40c3d2417	2018-10-01 02:18:36.829	2018-10-01 02:18:36.829	t	t	admin	127.0.0.1	2018-10-01 02:18:36.545	795C103B4F3BB3ADFE3B9E7B9D24FABC	Computer	Chrome	t	成功登录！
c53f5a00-c4dd-11e8-b05f-08d40c3d2417	2018-10-01 02:22:21.088	2018-10-01 02:22:21.088	t	t	admin	127.0.0.1	2018-10-01 02:22:20.818	329EFB42450478D24072EBA868C2F544	Computer	Chrome	t	成功登录！
0be3fdc0-c51b-11e8-b05f-08d40c3d2417	2018-10-01 09:40:58.908	2018-10-01 09:40:58.908	t	t	admin	127.0.0.1	2018-10-01 09:40:58.908	991CCE4F8286597B9A7853AF58DB2B91	Computer	Chrome	t	成功登录！
6daa5b30-c51b-11e8-b05f-08d40c3d2417	2018-10-01 09:43:42.947	2018-10-01 09:43:42.947	t	t	admin	127.0.0.1	2018-10-01 09:43:42.947	5768F94521441EE25B53F0E703606DC3	Computer	Chrome	t	成功登录！
e5b84dd0-c51b-11e8-849b-08d40c3d2417	2018-10-01 09:47:04.365	2018-10-01 09:47:04.365	t	t	admin	127.0.0.1	2018-10-01 09:47:04.129	24D063A96F145B8F12EE13F9F0CF2BA8	Computer	Chrome	t	成功登录！
09acffe0-c523-11e8-849b-08d40c3d2417	2018-10-01 10:38:11.166	2018-10-01 10:38:11.166	t	t	admin	127.0.0.1	2018-10-01 10:38:11.165	B3B9B8B651AE2FD744AEB881915C7CEC	Computer	Chrome	t	成功登录！
ebef7200-c525-11e8-849b-08d40c3d2417	2018-10-01 10:58:49.76	2018-10-01 10:58:49.76	t	t	admin	127.0.0.1	2018-10-01 10:58:49.759	B3B9B8B651AE2FD744AEB881915C7CEC	Computer	Chrome	t	成功登录！
27f18950-c526-11e8-849b-08d40c3d2417	2018-10-01 11:00:30.437	2018-10-01 11:00:30.437	t	t	admin	127.0.0.1	2018-10-01 11:00:30.437	2FB4BC712AFE60321A0247F45BDEB645	Computer	Chrome	t	成功登录！
6e7e4c00-c526-11e8-849b-08d40c3d2417	2018-10-01 11:02:28.8	2018-10-01 11:02:28.8	t	t	admin	127.0.0.1	2018-10-01 11:02:28.8	2FB4BC712AFE60321A0247F45BDEB645	Computer	Chrome	t	成功登录！
a1af00b0-c526-11e8-849b-08d40c3d2417	2018-10-01 11:03:54.683	2018-10-01 11:03:54.683	t	t	admin	127.0.0.1	2018-10-01 11:03:54.683	98BC9CBFB52A82FB06D2F0A98572BF6F	Computer	Chrome	t	成功登录！
3f196730-c538-11e8-be07-08d40c3d2417	2018-10-01 13:10:00.227	2018-10-01 13:10:00.227	t	t	admin	127.0.0.1	2018-10-01 13:09:59.914	B01C01FEB56529BA11735D85B0696D2E	Computer	Chrome	t	成功登录！
af9aca10-c576-11e8-be07-08d40c3d2417	2018-10-01 20:36:57.777	2018-10-01 20:36:57.777	t	t	admin	127.0.0.1	2018-10-01 20:36:57.776	A1CBCCE36141144AE4F80D42360E607B	Computer	Chrome	t	成功登录！
49190340-c57d-11e8-bd7f-08d40c3d2417	2018-10-01 21:24:12.276	2018-10-01 21:24:12.276	t	t	admin	127.0.0.1	2018-10-01 21:24:12.001	628CF3F86CE5DE91025C5403DECDA6AB	Computer	Chrome	t	成功登录！
4edfc880-c57e-11e8-bd7f-08d40c3d2417	2018-10-01 21:31:31.464	2018-10-01 21:31:31.464	t	t	admin	127.0.0.1	2018-10-01 21:31:31.464	2BDCF181DE2A1C1C22767D41F914BF9C	Computer	Chrome	t	成功登录！
b630fe30-c580-11e8-b36d-08d40c3d2417	2018-10-01 21:48:43.795	2018-10-01 21:48:43.795	t	t	admin	127.0.0.1	2018-10-01 21:48:43.546	C436FF263BD0206A0AA1ECF0017441FD	Computer	Chrome	t	成功登录！
131c2ab0-c587-11e8-965d-08d40c3d2417	2018-10-01 22:34:16.667	2018-10-01 22:34:16.667	t	t	admin	127.0.0.1	2018-10-01 22:34:16.359	E2FB97C5FBAEAE3D62F2F11B45B5B777	Computer	Chrome	t	成功登录！
03764f70-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:18:28.839	2018-10-02 01:18:28.839	t	t	admin	127.0.0.1	2018-10-02 01:18:28.525	B3E0779AE0F2683004EED9991FFD2074	Computer	Chrome	t	成功登录！
99d94da0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:22:41.146	2018-10-02 01:22:41.146	t	t	admin	127.0.0.1	2018-10-02 01:22:41.146	9C657F544EE2809786611735F53443B1	Computer	Chrome	t	成功登录！
247d22a0-c5a0-11e8-9435-08d40c3d2417	2018-10-02 01:33:43.242	2018-10-02 01:33:43.242	t	t	admin	127.0.0.1	2018-10-02 01:33:42.869	F004A9F1ED68938C8648C53532569959	Computer	Chrome	t	成功登录！
be1952d0-c5a0-11e8-a355-08d40c3d2417	2018-10-02 01:38:00.957	2018-10-02 01:38:00.957	t	t	admin	127.0.0.1	2018-10-02 01:38:00.687	A0C6300B1370000A30DB3FB5505DD639	Computer	Chrome	t	成功登录！
021dc020-c5a5-11e8-bce6-08d40c3d2417	2018-10-02 02:08:33.058	2018-10-02 02:08:33.058	t	t	admin	127.0.0.1	2018-10-02 02:08:32.579	F8DD7BA60FA94F994CE41A913F9C01B7	Computer	Chrome	f	密码错误！
08342170-c5a5-11e8-bce6-08d40c3d2417	2018-10-02 02:08:43.271	2018-10-02 02:08:43.271	t	t	admin	127.0.0.1	2018-10-02 02:08:43.271	F8DD7BA60FA94F994CE41A913F9C01B7	Computer	Chrome	f	验证码不正确！
0e0f2770-c5a5-11e8-bce6-08d40c3d2417	2018-10-02 02:08:53.095	2018-10-02 02:08:53.095	t	t	admin	127.0.0.1	2018-10-02 02:08:53.094	F8DD7BA60FA94F994CE41A913F9C01B7	Computer	Chrome	t	成功登录！
05d4b560-c5ec-11e8-bce6-08d40c3d2417	2018-10-02 10:36:53.558	2018-10-02 10:36:53.558	t	t	admin	127.0.0.1	2018-10-02 10:36:53.558	CC0BD1DE3660311166BB20080071BB8C	Computer	Chrome	t	成功登录！
0745a650-c5f3-11e8-bce6-08d40c3d2417	2018-10-02 11:27:02.453	2018-10-02 11:27:02.453	t	t	admin	127.0.0.1	2018-10-02 11:27:02.452	8736222441B2799655F927577B8E3B5B	Computer	Chrome	t	成功登录！
7c3edee0-c5f3-11e8-be95-08d40c3d2417	2018-10-02 11:30:18.702	2018-10-02 11:30:18.702	t	t	admin	127.0.0.1	2018-10-02 11:30:18.429	6F64D8856F50F179C0AEF17868D4863D	Computer	Chrome	t	成功登录！
d355ea90-c5f6-11e8-9cbe-08d40c3d2417	2018-10-02 11:54:13.305	2018-10-02 11:54:13.305	t	t	admin	127.0.0.1	2018-10-02 11:54:12.96	F760D576E627F8CFE3908D006F683780	Computer	Chrome	t	成功登录！
df2cda20-c5f8-11e8-8dda-08d40c3d2417	2018-10-02 12:08:52.162	2018-10-02 12:08:52.162	t	t	admin	127.0.0.1	2018-10-02 12:08:51.896	2C319487E66EEEF001353429286D588D	Computer	Chrome	t	成功登录！
35d111b0-c5fa-11e8-bbdd-08d40c3d2417	2018-10-02 12:18:27.019	2018-10-02 12:18:27.019	t	t	admin	127.0.0.1	2018-10-02 12:18:26.704	D06DB2446A8D2495D4B5D24EF443520C	Computer	Chrome	t	成功登录！
99c21750-c5fa-11e8-a899-08d40c3d2417	2018-10-02 12:21:14.693	2018-10-02 12:21:14.693	t	t	admin	127.0.0.1	2018-10-02 12:21:14.354	30B7636C2F26790B0FCCD7603C93F64D	Computer	Chrome	t	成功登录！
c252f380-c611-11e8-ac0d-08d40c3d2417	2018-10-02 15:07:01.176	2018-10-02 15:07:01.176	t	t	admin	127.0.0.1	2018-10-02 15:07:00.906	5798367ED68C5D4E70A4EA28F341D3B0	Computer	Chrome	t	成功登录！
53543a60-c612-11e8-ac0d-08d40c3d2417	2018-10-02 15:11:04.454	2018-10-02 15:11:04.454	t	t	admin	127.0.0.1	2018-10-02 15:11:04.453	35D2004AC29794BA8C38795BFCE4EA97	Computer	Chrome	t	成功登录！
c115b130-c614-11e8-8676-08d40c3d2417	2018-10-02 15:28:27.587	2018-10-02 15:28:27.587	t	t	admin	127.0.0.1	2018-10-02 15:28:27.277	2D767092748BF585267E78D498B58E15	Computer	Chrome	t	成功登录！
60859460-c615-11e8-b9bf-08d40c3d2417	2018-10-02 15:32:55.078	2018-10-02 15:32:55.078	t	t	admin	127.0.0.1	2018-10-02 15:32:54.726	038DF4158068957175B7F54979A15B12	Computer	Chrome	t	成功登录！
029f1e50-c617-11e8-a508-08d40c3d2417	2018-10-02 15:44:36.533	2018-10-02 15:44:36.533	t	t	admin	127.0.0.1	2018-10-02 15:44:36.212	B74A50BDC47D1A946BA9A53E267E6F22	Computer	Chrome	t	成功登录！
19818c90-c61a-11e8-bdb5-08d40c3d2417	2018-10-02 16:06:43.417	2018-10-02 16:06:43.417	t	t	admin	127.0.0.1	2018-10-02 16:06:43.124	795799052D0FF13799C71A21A23588A1	Computer	Chrome	t	成功登录！
a86a1ab0-c61c-11e8-95b8-08d40c3d2417	2018-10-02 16:25:02.171	2018-10-02 16:25:02.171	t	t	admin	127.0.0.1	2018-10-02 16:25:01.811	72A2EEB77AD0F1C45D48DF944FFD8524	Computer	Chrome	t	成功登录！
1609ce20-c61e-11e8-9a0b-08d40c3d2417	2018-10-02 16:35:15.586	2018-10-02 16:35:15.586	t	t	admin	127.0.0.1	2018-10-02 16:35:15.257	431CC788F1A0BA64CAD62814C86B2556	Computer	Chrome	t	成功登录！
aebf95f0-c61e-11e8-aefe-08d40c3d2417	2018-10-02 16:39:31.792	2018-10-02 16:39:31.792	t	t	admin	127.0.0.1	2018-10-02 16:39:31.523	0E5C9BF3452D9BD9ACAD132E01F93FDD	Computer	Chrome	t	成功登录！
922bf400-c61f-11e8-9e00-08d40c3d2417	2018-10-02 16:45:53.344	2018-10-02 16:45:53.344	t	t	admin	127.0.0.1	2018-10-02 16:45:52.926	5A7D96AF3D4464DCA1C8F906A6927D94	Computer	Chrome	t	成功登录！
1ce795f0-c651-11e8-8ee8-08d40c3d2417	2018-10-02 22:40:31.439	2018-10-02 22:40:31.439	t	t	admin	127.0.0.1	2018-10-02 22:40:31.154	32FA2A3D3B845A484C44F293E6C1FBBD	Computer	Chrome	f	验证码不正确！
230968f0-c651-11e8-8ee8-08d40c3d2417	2018-10-02 22:40:41.727	2018-10-02 22:40:41.727	t	t	admin	127.0.0.1	2018-10-02 22:40:41.727	32FA2A3D3B845A484C44F293E6C1FBBD	Computer	Chrome	t	成功登录！
\.


--
-- Data for Name: sys_menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sys_menu (id, create_time, update_time, flag, status, code, name, href, category, icon, css_class, css_style, caption, show_state, serial_number, parent_id) FROM stdin;
b5a993b0-9b18-11e8-b69c-4cedfb4009ed	2018-08-08 22:38:26.411	2018-08-13 23:36:39.794	t	t	xgtl-cdgl	菜单管理	/manage/system/sys-menu/index.jhtml	1	\N	\N	\N	\N	t	21	8da95cc0-9b17-11e8-a3d3-4cedfb4009ed
8da95cc0-9b17-11e8-a3d3-4cedfb4009ed	2018-08-08 22:30:09.804	2018-08-13 23:36:57.39	t	t	xtgl	系统管理	\N	1	\N	\N	\N	\N	t	11	\N
dfc9e830-9f0e-11e8-bca3-4cedfb4009ed	2018-08-13 23:38:06.771	2018-08-13 23:38:06.771	t	t	xgtl-cdgl-del	删除	\N	2	\N	\N	\N	\N	t	34	b5a993b0-9b18-11e8-b69c-4cedfb4009ed
91c670e0-9f0e-11e8-bca3-4cedfb4009ed	2018-08-13 23:35:55.886	2018-08-13 23:38:32.109	t	t	xgtl-cdgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	b5a993b0-9b18-11e8-b69c-4cedfb4009ed
5abc7670-9f0a-11e8-bca3-4cedfb4009ed	2018-08-13 23:05:45.559	2018-08-13 23:38:42.77	t	t	xgtl-cdgl-add	新增	\N	2	\N	\N	\N	\N	t	32	b5a993b0-9b18-11e8-b69c-4cedfb4009ed
c5bb23c0-9f0c-11e8-bca3-4cedfb4009ed	2018-08-13 23:23:04.06	2018-08-13 23:38:52.427	t	t	xgtl-cdgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	b5a993b0-9b18-11e8-b69c-4cedfb4009ed
661f5c90-9f0e-11e8-bca3-4cedfb4009ed	2018-08-13 23:34:42.649	2018-08-15 00:40:57.515	t	t	xtgl-jsgl	角色管理	/manage/system/sys-role/index.jhtml	1	\N	\N	\N	\N	t	22	8da95cc0-9b17-11e8-a3d3-4cedfb4009ed
fe9c7fc0-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:42:12.796	2018-08-15 00:42:12.796	t	t	xtgl-jsgl-add	添加	\N	2	\N	\N	\N	\N	t	32	661f5c90-9f0e-11e8-bca3-4cedfb4009ed
f1102d20-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:41:50.066	2018-08-15 00:42:51.835	t	t	xtgl-jsgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	661f5c90-9f0e-11e8-bca3-4cedfb4009ed
1251f860-9fe1-11e8-8968-4cedfb4009ed	2018-08-15 00:42:45.862	2018-08-15 00:43:09.517	t	t	xtgl-jsgl-del	删除	\N	2	\N	\N	\N	\N	t	34	661f5c90-9f0e-11e8-bca3-4cedfb4009ed
07cd1960-9fe1-11e8-8968-4cedfb4009ed	2018-08-15 00:42:28.214	2018-08-15 00:43:32.084	t	t	xtgl-jsgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	661f5c90-9f0e-11e8-bca3-4cedfb4009ed
20cff250-c612-11e8-ac0d-08d40c3d2417	2018-10-02 15:09:39.701	2018-10-02 15:09:39.701	t	t	xxzx-kcgl-add	添加	\N	2	\N	\N	\N	\N	t	32	e2067da0-c611-11e8-ac0d-08d40c3d2417
2aa76510-c527-11e8-849b-08d40c3d2417	2018-10-01 11:07:44.481	2018-10-01 11:10:50.535	t	t	rsgl	人事管理	\N	1	\N	\N	\N	\N	t	12	\N
bf2ddb10-c527-11e8-849b-08d40c3d2417	2018-10-01 11:11:53.665	2018-10-01 11:11:53.665	t	t	rsgl-yggl	员工管理	/manage/employee/account/index.jhtml	1	\N	\N	\N	\N	t	21	2aa76510-c527-11e8-849b-08d40c3d2417
f83a0af0-c527-11e8-849b-08d40c3d2417	2018-10-01 11:13:29.375	2018-10-01 11:13:29.375	t	t	rsgl-bmgl	部门管理	/manage/employee/department/index.jhtml	1	\N	\N	\N	\N	t	22	2aa76510-c527-11e8-849b-08d40c3d2417
2dffe970-c528-11e8-849b-08d40c3d2417	2018-10-01 11:14:59.591	2018-10-01 11:14:59.591	t	t	rsgl-yggl-sel	查询	\N	2	\N	\N	\N	\N	t	31	bf2ddb10-c527-11e8-849b-08d40c3d2417
2b4f04f0-c612-11e8-ac0d-08d40c3d2417	2018-10-02 15:09:57.311	2018-10-02 15:09:57.311	t	t	xxzx-kcgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	e2067da0-c611-11e8-ac0d-08d40c3d2417
3462eed0-c612-11e8-ac0d-08d40c3d2417	2018-10-02 15:10:12.541	2018-10-02 15:10:12.541	t	t	xxzx-kcgl-del	删除	\N	2	\N	\N	\N	\N	t	34	e2067da0-c611-11e8-ac0d-08d40c3d2417
fe81e710-c528-11e8-849b-08d40c3d2417	2018-10-01 11:20:49.409	2018-10-01 11:20:49.409	t	t	rsgl-yggl-add	添加	\N	2	\N	\N	\N	\N	t	32	bf2ddb10-c527-11e8-849b-08d40c3d2417
0fcdb2b0-c529-11e8-849b-08d40c3d2417	2018-10-01 11:21:18.427	2018-10-01 11:21:18.427	t	t	rsgl-yggl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	bf2ddb10-c527-11e8-849b-08d40c3d2417
1e3e23c0-c529-11e8-849b-08d40c3d2417	2018-10-01 11:21:42.652	2018-10-01 11:21:42.652	t	t	rsgl-yggl-del	删除	\N	2	\N	\N	\N	\N	t	34	bf2ddb10-c527-11e8-849b-08d40c3d2417
42f4f180-c529-11e8-849b-08d40c3d2417	2018-10-01 11:22:44.248	2018-10-01 11:22:44.248	t	t	rsgl-bmgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	f83a0af0-c527-11e8-849b-08d40c3d2417
52be89f0-c529-11e8-849b-08d40c3d2417	2018-10-01 11:23:10.735	2018-10-01 11:23:10.735	t	t	rsgl-bmgl-add	添加	\N	2	\N	\N	\N	\N	t	32	f83a0af0-c527-11e8-849b-08d40c3d2417
5f8eb880-c529-11e8-849b-08d40c3d2417	2018-10-01 11:23:32.232	2018-10-01 11:23:32.232	t	t	rsgl-bmgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	f83a0af0-c527-11e8-849b-08d40c3d2417
7344cd60-c529-11e8-849b-08d40c3d2417	2018-10-01 11:24:05.302	2018-10-01 11:24:05.302	t	t	rsgl-bmgl-del	删除	\N	2	\N	\N	\N	\N	t	34	f83a0af0-c527-11e8-849b-08d40c3d2417
29e9da10-c52a-11e8-849b-08d40c3d2417	2018-10-01 11:29:11.729	2018-10-01 11:29:11.729	t	t	rsgl-zwgl-sel	查询	\N	2	\N	\N	\N	\N	f	31	f515d5a0-c529-11e8-849b-08d40c3d2417
3a5a12c0-c52a-11e8-849b-08d40c3d2417	2018-10-01 11:29:39.308	2018-10-01 11:29:39.308	t	t	rsgl-zwgl-add	添加	\N	2	\N	\N	\N	\N	t	32	f515d5a0-c529-11e8-849b-08d40c3d2417
4819aa60-c52a-11e8-849b-08d40c3d2417	2018-10-01 11:30:02.374	2018-10-01 11:30:02.374	t	t	rsgl-zwgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	f515d5a0-c529-11e8-849b-08d40c3d2417
507540c0-c52a-11e8-849b-08d40c3d2417	2018-10-01 11:30:16.396	2018-10-01 11:30:37.509	t	t	rsgl-zwgl-del	删除	\N	2	\N	\N	\N	\N	t	34	f515d5a0-c529-11e8-849b-08d40c3d2417
6abdebd0-c52a-11e8-849b-08d40c3d2417	2018-10-01 11:31:00.493	2018-10-01 11:31:00.493	t	t	rsgl-zwgl-grant	授权	\N	2	\N	\N	\N	\N	t	35	f515d5a0-c529-11e8-849b-08d40c3d2417
b1dae090-c52a-11e8-849b-08d40c3d2417	2018-10-01 11:32:59.801	2018-10-01 11:32:59.801	t	t	xtgl-szzd	数字字典	/manage/system/base-dictionary/index.jhtml	1	\N	\N	\N	\N	t	23	8da95cc0-9b17-11e8-a3d3-4cedfb4009ed
cda0dcd0-c52a-11e8-849b-08d40c3d2417	2018-10-01 11:33:46.397	2018-10-01 11:33:46.397	t	t	xtgl-szzd-sel	查询	\N	2	\N	\N	\N	\N	t	31	b1dae090-c52a-11e8-849b-08d40c3d2417
0c10bfd0-c52b-11e8-849b-08d40c3d2417	2018-10-01 11:35:31.149	2018-10-01 11:35:31.149	t	t	xtgl-szzd-add	添加	\N	2	\N	\N	\N	\N	t	32	b1dae090-c52a-11e8-849b-08d40c3d2417
18e7f340-c52b-11e8-849b-08d40c3d2417	2018-10-01 11:35:52.692	2018-10-01 11:35:52.692	t	t	xtgl-szzd-edit	编辑	\N	2	\N	\N	\N	\N	f	33	b1dae090-c52a-11e8-849b-08d40c3d2417
280cc030-c52b-11e8-849b-08d40c3d2417	2018-10-01 11:36:18.099	2018-10-01 11:36:18.099	t	t	xtgl-szzd-del	删除	\N	2	\N	\N	\N	\N	t	34	b1dae090-c52a-11e8-849b-08d40c3d2417
f515d5a0-c529-11e8-849b-08d40c3d2417	2018-10-01 11:27:43.098	2018-10-01 13:13:57.767	t	t	rsgl-zwgl	职务管理	/manage/system/base-position/index.jhtml	1	\N	\N	\N	\N	t	23	2aa76510-c527-11e8-849b-08d40c3d2417
c49d7f00-c57d-11e8-bd7f-08d40c3d2417	2018-10-01 21:27:39.504	2018-10-01 21:27:39.504	t	t	xxzx-kcflgl	课程分类管理	/manage/study/course-type/index.jhtml	1	\N	\N	\N	\N	t	21	974add90-c57d-11e8-bd7f-08d40c3d2417
e3b0f890-c57d-11e8-bd7f-08d40c3d2417	2018-10-01 21:28:31.641	2018-10-01 21:28:31.641	t	t	xxzx-kcflgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	c49d7f00-c57d-11e8-bd7f-08d40c3d2417
ef9dcc00-c57d-11e8-bd7f-08d40c3d2417	2018-10-01 21:28:51.648	2018-10-01 21:28:51.648	t	t	xxzx-kcflgl-add	添加	\N	2	\N	\N	\N	\N	t	32	c49d7f00-c57d-11e8-bd7f-08d40c3d2417
fae55ec0-c57d-11e8-bd7f-08d40c3d2417	2018-10-01 21:29:10.572	2018-10-01 21:29:10.572	t	t	xxzx-kcflgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	c49d7f00-c57d-11e8-bd7f-08d40c3d2417
03f1f5a0-c57e-11e8-bd7f-08d40c3d2417	2018-10-01 21:29:25.754	2018-10-01 21:29:58.403	t	t	xxzx-kcflgl-del	删除	\N	2	\N	\N	\N	\N	t	34	c49d7f00-c57d-11e8-bd7f-08d40c3d2417
974add90-c57d-11e8-bd7f-08d40c3d2417	2018-10-01 21:26:23.465	2018-10-01 21:31:56.505	t	t	xxzx	学习中心	\N	1	\N	\N	\N	\N	t	14	\N
30f3f880-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:19:45.16	2018-10-02 01:19:45.16	t	t	xxzx-jsgl	老师管理	/manage/study/teacher/index.jhtml	1	\N	\N	\N	\N	t	22	974add90-c57d-11e8-bd7f-08d40c3d2417
57cf05d0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:20:50.349	2018-10-02 01:20:50.349	t	t	xxzx-jsgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	30f3f880-c59e-11e8-a4be-08d40c3d2417
6563bce0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:21:13.134	2018-10-02 01:21:13.134	t	t	xxzx-jsgl-add	添加	\N	2	\N	\N	\N	\N	t	32	30f3f880-c59e-11e8-a4be-08d40c3d2417
6fe8c2f0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:21:30.783	2018-10-02 01:21:30.783	t	t	xxzx-jsgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	30f3f880-c59e-11e8-a4be-08d40c3d2417
7aca40e0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:21:49.038	2018-10-02 01:21:49.038	t	t	xxzx-jsgl-del	删除	\N	2	\N	\N	\N	\N	t	34	30f3f880-c59e-11e8-a4be-08d40c3d2417
e2067da0-c611-11e8-ac0d-08d40c3d2417	2018-10-02 15:07:54.362	2018-10-02 15:08:38.195	t	t	xxzx-kcgl	课程管理	/manage/study/course/index.jhtml	1	\N	\N	\N	\N	t	23	974add90-c57d-11e8-bd7f-08d40c3d2417
16922e70-c612-11e8-ac0d-08d40c3d2417	2018-10-02 15:09:22.519	2018-10-02 15:09:22.519	t	t	xxzx-kcgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	e2067da0-c611-11e8-ac0d-08d40c3d2417
\.


--
-- Data for Name: sys_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sys_role (id, create_time, update_time, flag, status, code, name, caption, show_state, serial_number) FROM stdin;
4f4579c0-9fcf-11e8-8674-4cedfb4009ed	2018-08-14 22:35:37.18	2018-08-14 22:35:37.18	t	t	user	系统用户	\N	t	\N
f627c140-9fce-11e8-a3a0-4cedfb4009ed	2018-08-14 22:33:07.668	2018-08-15 00:38:49.094	t	t	admin	系统管理员	\N	t	\N
\.


--
-- Data for Name: sys_role_menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sys_role_menu (id, create_time, update_time, flag, status, role_id, menu_id) FROM stdin;
8533df20-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:38:49.106	2018-08-15 00:38:49.106	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	8da95cc0-9b17-11e8-a3d3-4cedfb4009ed
85347b60-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:38:49.11	2018-08-15 00:38:49.11	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	b5a993b0-9b18-11e8-b69c-4cedfb4009ed
8534f090-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:38:49.113	2018-08-15 00:38:49.113	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	91c670e0-9f0e-11e8-bca3-4cedfb4009ed
8535b3e0-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:38:49.118	2018-08-15 00:38:49.118	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	5abc7670-9f0a-11e8-bca3-4cedfb4009ed
85367730-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:38:49.123	2018-08-15 00:38:49.123	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	c5bb23c0-9f0c-11e8-bca3-4cedfb4009ed
853c1c80-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:38:49.16	2018-08-15 00:38:49.16	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	dfc9e830-9f0e-11e8-bca3-4cedfb4009ed
853cb8c0-9fe0-11e8-8968-4cedfb4009ed	2018-08-15 00:38:49.164	2018-08-15 00:38:49.164	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	661f5c90-9f0e-11e8-bca3-4cedfb4009ed
\.


--
-- Data for Name: sys_role_position; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sys_role_position (id, create_time, update_time, flag, status, role_id, position_id) FROM stdin;
32c71af0-b731-11e8-bd27-08d40c3d2417	2018-09-13 16:44:16.799	2018-09-13 16:44:16.799	t	t	4f4579c0-9fcf-11e8-8674-4cedfb4009ed	e0689710-b6a5-11e8-93b6-08d40c3d2417
38915810-b731-11e8-bd27-08d40c3d2417	2018-09-13 16:44:26.513	2018-09-13 16:44:26.513	t	t	f627c140-9fce-11e8-a3a0-4cedfb4009ed	e0689710-b6a5-11e8-93b6-08d40c3d2417
\.


--
-- Data for Name: teacher; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teacher (id, create_time, update_time, flag, status, full_name, title, image, introduction, description) FROM stdin;
\.


--
-- Name: act_evt_log_log_nr__seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.act_evt_log_log_nr__seq', 1, false);


--
-- Name: act_evt_log act_evt_log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_evt_log
    ADD CONSTRAINT act_evt_log_pkey PRIMARY KEY (log_nr_);


--
-- Name: act_ge_bytearray act_ge_bytearray_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ge_bytearray
    ADD CONSTRAINT act_ge_bytearray_pkey PRIMARY KEY (id_);


--
-- Name: act_ge_property act_ge_property_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ge_property
    ADD CONSTRAINT act_ge_property_pkey PRIMARY KEY (name_);


--
-- Name: act_hi_actinst act_hi_actinst_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_actinst
    ADD CONSTRAINT act_hi_actinst_pkey PRIMARY KEY (id_);


--
-- Name: act_hi_attachment act_hi_attachment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_attachment
    ADD CONSTRAINT act_hi_attachment_pkey PRIMARY KEY (id_);


--
-- Name: act_hi_comment act_hi_comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_comment
    ADD CONSTRAINT act_hi_comment_pkey PRIMARY KEY (id_);


--
-- Name: act_hi_detail act_hi_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_detail
    ADD CONSTRAINT act_hi_detail_pkey PRIMARY KEY (id_);


--
-- Name: act_hi_identitylink act_hi_identitylink_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_identitylink
    ADD CONSTRAINT act_hi_identitylink_pkey PRIMARY KEY (id_);


--
-- Name: act_hi_procinst act_hi_procinst_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_procinst
    ADD CONSTRAINT act_hi_procinst_pkey PRIMARY KEY (id_);


--
-- Name: act_hi_procinst act_hi_procinst_proc_inst_id__key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_procinst
    ADD CONSTRAINT act_hi_procinst_proc_inst_id__key UNIQUE (proc_inst_id_);


--
-- Name: act_hi_taskinst act_hi_taskinst_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_taskinst
    ADD CONSTRAINT act_hi_taskinst_pkey PRIMARY KEY (id_);


--
-- Name: act_hi_varinst act_hi_varinst_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_hi_varinst
    ADD CONSTRAINT act_hi_varinst_pkey PRIMARY KEY (id_);


--
-- Name: act_id_group act_id_group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_id_group
    ADD CONSTRAINT act_id_group_pkey PRIMARY KEY (id_);


--
-- Name: act_id_info act_id_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_id_info
    ADD CONSTRAINT act_id_info_pkey PRIMARY KEY (id_);


--
-- Name: act_id_membership act_id_membership_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_id_membership
    ADD CONSTRAINT act_id_membership_pkey PRIMARY KEY (user_id_, group_id_);


--
-- Name: act_id_user act_id_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_id_user
    ADD CONSTRAINT act_id_user_pkey PRIMARY KEY (id_);


--
-- Name: act_procdef_info act_procdef_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_procdef_info
    ADD CONSTRAINT act_procdef_info_pkey PRIMARY KEY (id_);


--
-- Name: act_re_deployment act_re_deployment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_re_deployment
    ADD CONSTRAINT act_re_deployment_pkey PRIMARY KEY (id_);


--
-- Name: act_re_model act_re_model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_re_model
    ADD CONSTRAINT act_re_model_pkey PRIMARY KEY (id_);


--
-- Name: act_re_procdef act_re_procdef_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_re_procdef
    ADD CONSTRAINT act_re_procdef_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_deadletter_job act_ru_deadletter_job_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_deadletter_job
    ADD CONSTRAINT act_ru_deadletter_job_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_event_subscr act_ru_event_subscr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_event_subscr
    ADD CONSTRAINT act_ru_event_subscr_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_execution act_ru_execution_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_execution
    ADD CONSTRAINT act_ru_execution_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_identitylink act_ru_identitylink_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_identitylink
    ADD CONSTRAINT act_ru_identitylink_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_job act_ru_job_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_job
    ADD CONSTRAINT act_ru_job_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_suspended_job act_ru_suspended_job_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_suspended_job
    ADD CONSTRAINT act_ru_suspended_job_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_task act_ru_task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_task
    ADD CONSTRAINT act_ru_task_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_timer_job act_ru_timer_job_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_timer_job
    ADD CONSTRAINT act_ru_timer_job_pkey PRIMARY KEY (id_);


--
-- Name: act_ru_variable act_ru_variable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_variable
    ADD CONSTRAINT act_ru_variable_pkey PRIMARY KEY (id_);


--
-- Name: act_procdef_info act_uniq_info_procdef; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_procdef_info
    ADD CONSTRAINT act_uniq_info_procdef UNIQUE (proc_def_id_);


--
-- Name: act_re_procdef act_uniq_procdef; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_re_procdef
    ADD CONSTRAINT act_uniq_procdef UNIQUE (key_, version_, tenant_id_);


--
-- Name: base_dictionary_item base_dictionary_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.base_dictionary_item
    ADD CONSTRAINT base_dictionary_item_pkey PRIMARY KEY (id);


--
-- Name: base_dictionary base_dictionary_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.base_dictionary
    ADD CONSTRAINT base_dictionary_pkey PRIMARY KEY (id);


--
-- Name: base_position base_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.base_position
    ADD CONSTRAINT base_position_pkey PRIMARY KEY (id);


--
-- Name: course_attachment course_attachment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_attachment
    ADD CONSTRAINT course_attachment_pkey PRIMARY KEY (id);


--
-- Name: course_examination_analysis course_examination_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_pkey PRIMARY KEY (id);


--
-- Name: course_examination_answer course_examination_answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_answer
    ADD CONSTRAINT course_examination_answer_pkey PRIMARY KEY (id);


--
-- Name: course_examination_item course_examination_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_item
    ADD CONSTRAINT course_examination_item_pkey PRIMARY KEY (id);


--
-- Name: course_examination course_examination_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination
    ADD CONSTRAINT course_examination_pkey PRIMARY KEY (id);


--
-- Name: course_exercise_analysis course_exercise_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_analysis
    ADD CONSTRAINT course_exercise_analysis_pkey PRIMARY KEY (id);


--
-- Name: course_exercise_answer course_exercise_answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_answer
    ADD CONSTRAINT course_exercise_answer_pkey PRIMARY KEY (id);


--
-- Name: course_exercise_item course_exercise_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_item
    ADD CONSTRAINT course_exercise_item_pkey PRIMARY KEY (id);


--
-- Name: course_exercise course_exercise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise
    ADD CONSTRAINT course_exercise_pkey PRIMARY KEY (id);


--
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- Name: course_type course_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_type
    ADD CONSTRAINT course_type_pkey PRIMARY KEY (id);


--
-- Name: course_video course_video_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_video
    ADD CONSTRAINT course_video_pkey PRIMARY KEY (id);


--
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- Name: employee_account employee_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_account
    ADD CONSTRAINT employee_account_pkey PRIMARY KEY (id);


--
-- Name: employee_course_exercise_item employee_course_exercise_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_item
    ADD CONSTRAINT employee_course_exercise_item_pkey PRIMARY KEY (id);


--
-- Name: employee_course_exercise employee_course_exercise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise
    ADD CONSTRAINT employee_course_exercise_pkey PRIMARY KEY (id);


--
-- Name: employee_course_study employee_course_study_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_study
    ADD CONSTRAINT employee_course_study_pkey PRIMARY KEY (id);


--
-- Name: employee_position employee_position_employee_id_position_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_position
    ADD CONSTRAINT employee_position_employee_id_position_id_key UNIQUE (employee_id, position_id);


--
-- Name: employee_position employee_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_position
    ADD CONSTRAINT employee_position_pkey PRIMARY KEY (id);


--
-- Name: employee_role employee_role_employee_id_role_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_role
    ADD CONSTRAINT employee_role_employee_id_role_id_key UNIQUE (employee_id, role_id);


--
-- Name: employee_role employee_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_role
    ADD CONSTRAINT employee_role_pkey PRIMARY KEY (id);


--
-- Name: examination_course examination_course_course_id_paper_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_course
    ADD CONSTRAINT examination_course_course_id_paper_id_key UNIQUE (course_id, paper_id);


--
-- Name: examination_course examination_course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_course
    ADD CONSTRAINT examination_course_pkey PRIMARY KEY (id);


--
-- Name: examination_paper examination_paper_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_paper
    ADD CONSTRAINT examination_paper_pkey PRIMARY KEY (id);


--
-- Name: examination_question_analysis examination_question_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_analysis
    ADD CONSTRAINT examination_question_analysis_pkey PRIMARY KEY (id);


--
-- Name: examination_question_answer examination_question_answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_answer
    ADD CONSTRAINT examination_question_answer_pkey PRIMARY KEY (id);


--
-- Name: examination_question_item examination_question_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_item
    ADD CONSTRAINT examination_question_item_pkey PRIMARY KEY (id);


--
-- Name: examination_question examination_question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question
    ADD CONSTRAINT examination_question_pkey PRIMARY KEY (id);


--
-- Name: sys_login_log sys_login_log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_login_log
    ADD CONSTRAINT sys_login_log_pkey PRIMARY KEY (id);


--
-- Name: sys_menu sys_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_menu
    ADD CONSTRAINT sys_menu_pkey PRIMARY KEY (id);


--
-- Name: sys_role_menu sys_role_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_menu
    ADD CONSTRAINT sys_role_menu_pkey PRIMARY KEY (id);


--
-- Name: sys_role_menu sys_role_menu_role_id_menu_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_menu
    ADD CONSTRAINT sys_role_menu_role_id_menu_id_key UNIQUE (role_id, menu_id);


--
-- Name: sys_role sys_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role
    ADD CONSTRAINT sys_role_pkey PRIMARY KEY (id);


--
-- Name: sys_role_position sys_role_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_position
    ADD CONSTRAINT sys_role_position_pkey PRIMARY KEY (id);


--
-- Name: sys_role_position sys_role_position_role_id_position_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_position
    ADD CONSTRAINT sys_role_position_role_id_position_id_key UNIQUE (role_id, position_id);


--
-- Name: teacher teacher_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_pkey PRIMARY KEY (id);


--
-- Name: act_idx_athrz_procedef; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_athrz_procedef ON public.act_ru_identitylink USING btree (proc_def_id_);


--
-- Name: act_idx_bytear_depl; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_bytear_depl ON public.act_ge_bytearray USING btree (deployment_id_);


--
-- Name: act_idx_deadletter_job_exception; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_deadletter_job_exception ON public.act_ru_deadletter_job USING btree (exception_stack_id_);


--
-- Name: act_idx_deadletter_job_execution_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_deadletter_job_execution_id ON public.act_ru_deadletter_job USING btree (execution_id_);


--
-- Name: act_idx_deadletter_job_proc_def_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_deadletter_job_proc_def_id ON public.act_ru_deadletter_job USING btree (proc_def_id_);


--
-- Name: act_idx_deadletter_job_process_instance_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_deadletter_job_process_instance_id ON public.act_ru_deadletter_job USING btree (process_instance_id_);


--
-- Name: act_idx_event_subscr; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_event_subscr ON public.act_ru_event_subscr USING btree (execution_id_);


--
-- Name: act_idx_event_subscr_config_; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_event_subscr_config_ ON public.act_ru_event_subscr USING btree (configuration_);


--
-- Name: act_idx_exe_parent; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_exe_parent ON public.act_ru_execution USING btree (parent_id_);


--
-- Name: act_idx_exe_procdef; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_exe_procdef ON public.act_ru_execution USING btree (proc_def_id_);


--
-- Name: act_idx_exe_procinst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_exe_procinst ON public.act_ru_execution USING btree (proc_inst_id_);


--
-- Name: act_idx_exe_root; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_exe_root ON public.act_ru_execution USING btree (root_proc_inst_id_);


--
-- Name: act_idx_exe_super; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_exe_super ON public.act_ru_execution USING btree (super_exec_);


--
-- Name: act_idx_exec_buskey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_exec_buskey ON public.act_ru_execution USING btree (business_key_);


--
-- Name: act_idx_hi_act_inst_end; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_act_inst_end ON public.act_hi_actinst USING btree (end_time_);


--
-- Name: act_idx_hi_act_inst_exec; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_act_inst_exec ON public.act_hi_actinst USING btree (execution_id_, act_id_);


--
-- Name: act_idx_hi_act_inst_procinst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_act_inst_procinst ON public.act_hi_actinst USING btree (proc_inst_id_, act_id_);


--
-- Name: act_idx_hi_act_inst_start; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_act_inst_start ON public.act_hi_actinst USING btree (start_time_);


--
-- Name: act_idx_hi_detail_act_inst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_detail_act_inst ON public.act_hi_detail USING btree (act_inst_id_);


--
-- Name: act_idx_hi_detail_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_detail_name ON public.act_hi_detail USING btree (name_);


--
-- Name: act_idx_hi_detail_proc_inst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_detail_proc_inst ON public.act_hi_detail USING btree (proc_inst_id_);


--
-- Name: act_idx_hi_detail_task_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_detail_task_id ON public.act_hi_detail USING btree (task_id_);


--
-- Name: act_idx_hi_detail_time; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_detail_time ON public.act_hi_detail USING btree (time_);


--
-- Name: act_idx_hi_ident_lnk_procinst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_ident_lnk_procinst ON public.act_hi_identitylink USING btree (proc_inst_id_);


--
-- Name: act_idx_hi_ident_lnk_task; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_ident_lnk_task ON public.act_hi_identitylink USING btree (task_id_);


--
-- Name: act_idx_hi_ident_lnk_user; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_ident_lnk_user ON public.act_hi_identitylink USING btree (user_id_);


--
-- Name: act_idx_hi_pro_i_buskey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_pro_i_buskey ON public.act_hi_procinst USING btree (business_key_);


--
-- Name: act_idx_hi_pro_inst_end; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_pro_inst_end ON public.act_hi_procinst USING btree (end_time_);


--
-- Name: act_idx_hi_procvar_name_type; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_procvar_name_type ON public.act_hi_varinst USING btree (name_, var_type_);


--
-- Name: act_idx_hi_procvar_proc_inst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_procvar_proc_inst ON public.act_hi_varinst USING btree (proc_inst_id_);


--
-- Name: act_idx_hi_procvar_task_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_procvar_task_id ON public.act_hi_varinst USING btree (task_id_);


--
-- Name: act_idx_hi_task_inst_procinst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_hi_task_inst_procinst ON public.act_hi_taskinst USING btree (proc_inst_id_);


--
-- Name: act_idx_ident_lnk_group; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_ident_lnk_group ON public.act_ru_identitylink USING btree (group_id_);


--
-- Name: act_idx_ident_lnk_user; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_ident_lnk_user ON public.act_ru_identitylink USING btree (user_id_);


--
-- Name: act_idx_idl_procinst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_idl_procinst ON public.act_ru_identitylink USING btree (proc_inst_id_);


--
-- Name: act_idx_job_exception; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_job_exception ON public.act_ru_job USING btree (exception_stack_id_);


--
-- Name: act_idx_job_execution_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_job_execution_id ON public.act_ru_job USING btree (execution_id_);


--
-- Name: act_idx_job_proc_def_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_job_proc_def_id ON public.act_ru_job USING btree (proc_def_id_);


--
-- Name: act_idx_job_process_instance_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_job_process_instance_id ON public.act_ru_job USING btree (process_instance_id_);


--
-- Name: act_idx_memb_group; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_memb_group ON public.act_id_membership USING btree (group_id_);


--
-- Name: act_idx_memb_user; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_memb_user ON public.act_id_membership USING btree (user_id_);


--
-- Name: act_idx_model_deployment; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_model_deployment ON public.act_re_model USING btree (deployment_id_);


--
-- Name: act_idx_model_source; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_model_source ON public.act_re_model USING btree (editor_source_value_id_);


--
-- Name: act_idx_model_source_extra; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_model_source_extra ON public.act_re_model USING btree (editor_source_extra_value_id_);


--
-- Name: act_idx_procdef_info_json; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_procdef_info_json ON public.act_procdef_info USING btree (info_json_id_);


--
-- Name: act_idx_procdef_info_proc; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_procdef_info_proc ON public.act_procdef_info USING btree (proc_def_id_);


--
-- Name: act_idx_suspended_job_exception; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_suspended_job_exception ON public.act_ru_suspended_job USING btree (exception_stack_id_);


--
-- Name: act_idx_suspended_job_execution_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_suspended_job_execution_id ON public.act_ru_suspended_job USING btree (execution_id_);


--
-- Name: act_idx_suspended_job_proc_def_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_suspended_job_proc_def_id ON public.act_ru_suspended_job USING btree (proc_def_id_);


--
-- Name: act_idx_suspended_job_process_instance_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_suspended_job_process_instance_id ON public.act_ru_suspended_job USING btree (process_instance_id_);


--
-- Name: act_idx_task_create; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_task_create ON public.act_ru_task USING btree (create_time_);


--
-- Name: act_idx_task_exec; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_task_exec ON public.act_ru_task USING btree (execution_id_);


--
-- Name: act_idx_task_procdef; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_task_procdef ON public.act_ru_task USING btree (proc_def_id_);


--
-- Name: act_idx_task_procinst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_task_procinst ON public.act_ru_task USING btree (proc_inst_id_);


--
-- Name: act_idx_timer_job_exception; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_timer_job_exception ON public.act_ru_timer_job USING btree (exception_stack_id_);


--
-- Name: act_idx_timer_job_execution_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_timer_job_execution_id ON public.act_ru_timer_job USING btree (execution_id_);


--
-- Name: act_idx_timer_job_proc_def_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_timer_job_proc_def_id ON public.act_ru_timer_job USING btree (proc_def_id_);


--
-- Name: act_idx_timer_job_process_instance_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_timer_job_process_instance_id ON public.act_ru_timer_job USING btree (process_instance_id_);


--
-- Name: act_idx_tskass_task; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_tskass_task ON public.act_ru_identitylink USING btree (task_id_);


--
-- Name: act_idx_var_bytearray; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_var_bytearray ON public.act_ru_variable USING btree (bytearray_id_);


--
-- Name: act_idx_var_exe; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_var_exe ON public.act_ru_variable USING btree (execution_id_);


--
-- Name: act_idx_var_procinst; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_var_procinst ON public.act_ru_variable USING btree (proc_inst_id_);


--
-- Name: act_idx_variable_task_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX act_idx_variable_task_id ON public.act_ru_variable USING btree (task_id_);


--
-- Name: act_ru_identitylink act_fk_athrz_procedef; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_identitylink
    ADD CONSTRAINT act_fk_athrz_procedef FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ge_bytearray act_fk_bytearr_depl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ge_bytearray
    ADD CONSTRAINT act_fk_bytearr_depl FOREIGN KEY (deployment_id_) REFERENCES public.act_re_deployment(id_);


--
-- Name: act_ru_deadletter_job act_fk_deadletter_job_exception; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_deadletter_job
    ADD CONSTRAINT act_fk_deadletter_job_exception FOREIGN KEY (exception_stack_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_ru_deadletter_job act_fk_deadletter_job_execution; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_deadletter_job
    ADD CONSTRAINT act_fk_deadletter_job_execution FOREIGN KEY (execution_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_deadletter_job act_fk_deadletter_job_proc_def; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_deadletter_job
    ADD CONSTRAINT act_fk_deadletter_job_proc_def FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ru_deadletter_job act_fk_deadletter_job_process_instance; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_deadletter_job
    ADD CONSTRAINT act_fk_deadletter_job_process_instance FOREIGN KEY (process_instance_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_event_subscr act_fk_event_exec; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_event_subscr
    ADD CONSTRAINT act_fk_event_exec FOREIGN KEY (execution_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_execution act_fk_exe_parent; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_execution
    ADD CONSTRAINT act_fk_exe_parent FOREIGN KEY (parent_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_execution act_fk_exe_procdef; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_execution
    ADD CONSTRAINT act_fk_exe_procdef FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ru_execution act_fk_exe_procinst; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_execution
    ADD CONSTRAINT act_fk_exe_procinst FOREIGN KEY (proc_inst_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_execution act_fk_exe_super; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_execution
    ADD CONSTRAINT act_fk_exe_super FOREIGN KEY (super_exec_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_identitylink act_fk_idl_procinst; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_identitylink
    ADD CONSTRAINT act_fk_idl_procinst FOREIGN KEY (proc_inst_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_procdef_info act_fk_info_json_ba; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_procdef_info
    ADD CONSTRAINT act_fk_info_json_ba FOREIGN KEY (info_json_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_procdef_info act_fk_info_procdef; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_procdef_info
    ADD CONSTRAINT act_fk_info_procdef FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ru_job act_fk_job_exception; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_job
    ADD CONSTRAINT act_fk_job_exception FOREIGN KEY (exception_stack_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_ru_job act_fk_job_execution; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_job
    ADD CONSTRAINT act_fk_job_execution FOREIGN KEY (execution_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_job act_fk_job_proc_def; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_job
    ADD CONSTRAINT act_fk_job_proc_def FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ru_job act_fk_job_process_instance; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_job
    ADD CONSTRAINT act_fk_job_process_instance FOREIGN KEY (process_instance_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_id_membership act_fk_memb_group; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_id_membership
    ADD CONSTRAINT act_fk_memb_group FOREIGN KEY (group_id_) REFERENCES public.act_id_group(id_);


--
-- Name: act_id_membership act_fk_memb_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_id_membership
    ADD CONSTRAINT act_fk_memb_user FOREIGN KEY (user_id_) REFERENCES public.act_id_user(id_);


--
-- Name: act_re_model act_fk_model_deployment; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_re_model
    ADD CONSTRAINT act_fk_model_deployment FOREIGN KEY (deployment_id_) REFERENCES public.act_re_deployment(id_);


--
-- Name: act_re_model act_fk_model_source; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_re_model
    ADD CONSTRAINT act_fk_model_source FOREIGN KEY (editor_source_value_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_re_model act_fk_model_source_extra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_re_model
    ADD CONSTRAINT act_fk_model_source_extra FOREIGN KEY (editor_source_extra_value_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_ru_suspended_job act_fk_suspended_job_exception; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_suspended_job
    ADD CONSTRAINT act_fk_suspended_job_exception FOREIGN KEY (exception_stack_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_ru_suspended_job act_fk_suspended_job_execution; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_suspended_job
    ADD CONSTRAINT act_fk_suspended_job_execution FOREIGN KEY (execution_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_suspended_job act_fk_suspended_job_proc_def; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_suspended_job
    ADD CONSTRAINT act_fk_suspended_job_proc_def FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ru_suspended_job act_fk_suspended_job_process_instance; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_suspended_job
    ADD CONSTRAINT act_fk_suspended_job_process_instance FOREIGN KEY (process_instance_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_task act_fk_task_exe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_task
    ADD CONSTRAINT act_fk_task_exe FOREIGN KEY (execution_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_task act_fk_task_procdef; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_task
    ADD CONSTRAINT act_fk_task_procdef FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ru_task act_fk_task_procinst; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_task
    ADD CONSTRAINT act_fk_task_procinst FOREIGN KEY (proc_inst_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_timer_job act_fk_timer_job_exception; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_timer_job
    ADD CONSTRAINT act_fk_timer_job_exception FOREIGN KEY (exception_stack_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_ru_timer_job act_fk_timer_job_execution; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_timer_job
    ADD CONSTRAINT act_fk_timer_job_execution FOREIGN KEY (execution_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_timer_job act_fk_timer_job_proc_def; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_timer_job
    ADD CONSTRAINT act_fk_timer_job_proc_def FOREIGN KEY (proc_def_id_) REFERENCES public.act_re_procdef(id_);


--
-- Name: act_ru_timer_job act_fk_timer_job_process_instance; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_timer_job
    ADD CONSTRAINT act_fk_timer_job_process_instance FOREIGN KEY (process_instance_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_identitylink act_fk_tskass_task; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_identitylink
    ADD CONSTRAINT act_fk_tskass_task FOREIGN KEY (task_id_) REFERENCES public.act_ru_task(id_);


--
-- Name: act_ru_variable act_fk_var_bytearray; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_variable
    ADD CONSTRAINT act_fk_var_bytearray FOREIGN KEY (bytearray_id_) REFERENCES public.act_ge_bytearray(id_);


--
-- Name: act_ru_variable act_fk_var_exe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_variable
    ADD CONSTRAINT act_fk_var_exe FOREIGN KEY (execution_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: act_ru_variable act_fk_var_procinst; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act_ru_variable
    ADD CONSTRAINT act_fk_var_procinst FOREIGN KEY (proc_inst_id_) REFERENCES public.act_ru_execution(id_);


--
-- Name: base_dictionary_item base_dictionary_item_dictionary_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.base_dictionary_item
    ADD CONSTRAINT base_dictionary_item_dictionary_id_fkey FOREIGN KEY (dictionary_id) REFERENCES public.base_dictionary(id);


--
-- Name: course_attachment course_attachment_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_attachment
    ADD CONSTRAINT course_attachment_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_attachment course_attachment_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_attachment
    ADD CONSTRAINT course_attachment_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_examination_analysis course_examination_analysis_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_examination_analysis course_examination_analysis_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_examination(id);


--
-- Name: course_examination_analysis course_examination_analysis_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_examination_answer course_examination_answer_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_answer
    ADD CONSTRAINT course_examination_answer_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_examination_answer course_examination_answer_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_answer
    ADD CONSTRAINT course_examination_answer_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_examination(id);


--
-- Name: course_examination_answer course_examination_answer_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_answer
    ADD CONSTRAINT course_examination_answer_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_examination course_examination_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination
    ADD CONSTRAINT course_examination_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_examination_item course_examination_item_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_item
    ADD CONSTRAINT course_examination_item_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_examination_item course_examination_item_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_item
    ADD CONSTRAINT course_examination_item_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_examination(id);


--
-- Name: course_examination_item course_examination_item_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_item
    ADD CONSTRAINT course_examination_item_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_examination course_examination_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination
    ADD CONSTRAINT course_examination_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_exercise_analysis course_exercise_analysis_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_analysis
    ADD CONSTRAINT course_exercise_analysis_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_exercise_analysis course_exercise_analysis_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_analysis
    ADD CONSTRAINT course_exercise_analysis_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_exercise(id);


--
-- Name: course_exercise_analysis course_exercise_analysis_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_analysis
    ADD CONSTRAINT course_exercise_analysis_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_exercise_answer course_exercise_answer_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_answer
    ADD CONSTRAINT course_exercise_answer_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_exercise_answer course_exercise_answer_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_answer
    ADD CONSTRAINT course_exercise_answer_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_exercise(id);


--
-- Name: course_exercise_answer course_exercise_answer_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_answer
    ADD CONSTRAINT course_exercise_answer_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_exercise course_exercise_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise
    ADD CONSTRAINT course_exercise_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_exercise_item course_exercise_item_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_item
    ADD CONSTRAINT course_exercise_item_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_exercise_item course_exercise_item_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_item
    ADD CONSTRAINT course_exercise_item_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_exercise(id);


--
-- Name: course_exercise_item course_exercise_item_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise_item
    ADD CONSTRAINT course_exercise_item_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course_exercise course_exercise_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_exercise
    ADD CONSTRAINT course_exercise_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: course course_teacher_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_teacher_id_fkey FOREIGN KEY (teacher_id) REFERENCES public.teacher(id);


--
-- Name: course course_type_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_type_id_fkey FOREIGN KEY (type_id) REFERENCES public.course_type(id);


--
-- Name: course_type course_type_parent_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_type
    ADD CONSTRAINT course_type_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.course_type(id);


--
-- Name: course_video course_video_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_video
    ADD CONSTRAINT course_video_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: department department_parent_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.department(id);


--
-- Name: employee_account employee_account_department_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_account
    ADD CONSTRAINT employee_account_department_id_fkey FOREIGN KEY (department_id) REFERENCES public.department(id);


--
-- Name: employee_account employee_account_position_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_account
    ADD CONSTRAINT employee_account_position_id_fkey FOREIGN KEY (position_id) REFERENCES public.base_position(id);


--
-- Name: employee_course_exercise employee_course_exercise_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise
    ADD CONSTRAINT employee_course_exercise_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: employee_course_exercise employee_course_exercise_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise
    ADD CONSTRAINT employee_course_exercise_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee_account(id);


--
-- Name: employee_course_exercise employee_course_exercise_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise
    ADD CONSTRAINT employee_course_exercise_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_exercise(id);


--
-- Name: employee_course_exercise_item employee_course_exercise_item_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_item
    ADD CONSTRAINT employee_course_exercise_item_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: employee_course_exercise_item employee_course_exercise_item_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_item
    ADD CONSTRAINT employee_course_exercise_item_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee_account(id);


--
-- Name: employee_course_exercise_item employee_course_exercise_item_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_item
    ADD CONSTRAINT employee_course_exercise_item_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.course_exercise(id);


--
-- Name: employee_course_exercise_item employee_course_exercise_item_item_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_item
    ADD CONSTRAINT employee_course_exercise_item_item_id_fkey FOREIGN KEY (item_id) REFERENCES public.course_exercise_item(id);


--
-- Name: employee_course_exercise_item employee_course_exercise_item_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_item
    ADD CONSTRAINT employee_course_exercise_item_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: employee_course_exercise employee_course_exercise_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise
    ADD CONSTRAINT employee_course_exercise_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: employee_course_study employee_course_study_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_study
    ADD CONSTRAINT employee_course_study_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: employee_course_study employee_course_study_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_study
    ADD CONSTRAINT employee_course_study_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee_account(id);


--
-- Name: employee_course_study employee_course_study_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_study
    ADD CONSTRAINT employee_course_study_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


--
-- Name: employee_position employee_position_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_position
    ADD CONSTRAINT employee_position_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee_account(id);


--
-- Name: employee_position employee_position_position_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_position
    ADD CONSTRAINT employee_position_position_id_fkey FOREIGN KEY (position_id) REFERENCES public.base_position(id);


--
-- Name: employee_role employee_role_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_role
    ADD CONSTRAINT employee_role_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employee_account(id);


--
-- Name: employee_role employee_role_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_role
    ADD CONSTRAINT employee_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.sys_role(id);


--
-- Name: examination_course examination_course_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_course
    ADD CONSTRAINT examination_course_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: examination_course examination_course_paper_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_course
    ADD CONSTRAINT examination_course_paper_id_fkey FOREIGN KEY (paper_id) REFERENCES public.examination_paper(id);


--
-- Name: examination_question_analysis examination_question_analysis_paper_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_analysis
    ADD CONSTRAINT examination_question_analysis_paper_id_fkey FOREIGN KEY (paper_id) REFERENCES public.examination_paper(id);


--
-- Name: examination_question_answer examination_question_answer_paper_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_answer
    ADD CONSTRAINT examination_question_answer_paper_id_fkey FOREIGN KEY (paper_id) REFERENCES public.examination_paper(id);


--
-- Name: examination_question_answer examination_question_answer_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_answer
    ADD CONSTRAINT examination_question_answer_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.examination_question(id);


--
-- Name: examination_question_item examination_question_item_paper_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_item
    ADD CONSTRAINT examination_question_item_paper_id_fkey FOREIGN KEY (paper_id) REFERENCES public.examination_paper(id);


--
-- Name: examination_question_item examination_question_item_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_item
    ADD CONSTRAINT examination_question_item_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.examination_question(id);


--
-- Name: examination_question examination_question_paper_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question
    ADD CONSTRAINT examination_question_paper_id_fkey FOREIGN KEY (paper_id) REFERENCES public.examination_paper(id);


--
-- Name: sys_menu sys_menu_parent_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_menu
    ADD CONSTRAINT sys_menu_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.sys_menu(id);


--
-- Name: sys_role_menu sys_role_menu_menu_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_menu
    ADD CONSTRAINT sys_role_menu_menu_id_fkey FOREIGN KEY (menu_id) REFERENCES public.sys_menu(id);


--
-- Name: sys_role_menu sys_role_menu_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_menu
    ADD CONSTRAINT sys_role_menu_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.sys_role(id);


--
-- Name: sys_role_position sys_role_position_position_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_position
    ADD CONSTRAINT sys_role_position_position_id_fkey FOREIGN KEY (position_id) REFERENCES public.base_position(id);


--
-- Name: sys_role_position sys_role_position_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_role_position
    ADD CONSTRAINT sys_role_position_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.sys_role(id);


--
-- PostgreSQL database dump complete
--

