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
-- Name: certificate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.certificate (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    name character varying(300),
    department character varying(300),
    official_seal character varying(50),
    grade integer DEFAULT 0
);


ALTER TABLE public.certificate OWNER TO postgres;

--
-- Name: TABLE certificate; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.certificate IS '证书';


--
-- Name: COLUMN certificate.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.id IS '流水号';


--
-- Name: COLUMN certificate.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.create_time IS '创建时间';


--
-- Name: COLUMN certificate.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.update_time IS '更新时间';


--
-- Name: COLUMN certificate.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.flag IS '标记';


--
-- Name: COLUMN certificate.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.name IS '名称';


--
-- Name: COLUMN certificate.department; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.department IS '发证机构';


--
-- Name: COLUMN certificate.official_seal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.official_seal IS '机构公章';


--
-- Name: COLUMN certificate.grade; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.certificate.grade IS '等级';


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
    description text,
    test_type integer,
    test_state integer,
    test_amount integer DEFAULT 1,
    duration integer,
    question_amount integer,
    question_type integer,
    single_amount integer,
    multi_amount integer,
    judge_amount integer,
    check_amount integer,
    fill_amount integer,
    total_score integer,
    pass_score integer
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
-- Name: COLUMN course.test_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.test_type IS '考试类型：1自动考试，2统一考试';


--
-- Name: COLUMN course.test_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.test_state IS '考试状态：1等待考试，2开始考试，3结束考试';


--
-- Name: COLUMN course.test_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.test_amount IS '考试次数（补考次数）';


--
-- Name: COLUMN course.question_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.question_amount IS '考题总数';


--
-- Name: COLUMN course.question_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.question_type IS '考题分配：1随机分配题型数量，2自行分配题型数量';


--
-- Name: COLUMN course.single_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.single_amount IS '单选题数量';


--
-- Name: COLUMN course.multi_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.multi_amount IS '多选择题数量';


--
-- Name: COLUMN course.judge_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.judge_amount IS '判断题数量';


--
-- Name: COLUMN course.check_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.check_amount IS '不定项选择题数量';


--
-- Name: COLUMN course.fill_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.fill_amount IS '填空题数量';


--
-- Name: COLUMN course.total_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.total_score IS '总分';


--
-- Name: COLUMN course.pass_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course.pass_score IS '合格分数';


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
-- Name: course_certificate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course_certificate (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid NOT NULL,
    certificate_id uuid NOT NULL
);


ALTER TABLE public.course_certificate OWNER TO postgres;

--
-- Name: TABLE course_certificate; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.course_certificate IS '课程证书';


--
-- Name: COLUMN course_certificate.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_certificate.id IS '流水号';


--
-- Name: COLUMN course_certificate.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_certificate.create_time IS '创建时间';


--
-- Name: COLUMN course_certificate.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_certificate.update_time IS '更新时间';


--
-- Name: COLUMN course_certificate.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_certificate.flag IS '标记';


--
-- Name: COLUMN course_certificate.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_certificate.status IS '状态';


--
-- Name: COLUMN course_certificate.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_certificate.course_id IS '课程ID';


--
-- Name: COLUMN course_certificate.certificate_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_certificate.certificate_id IS '证书ID';


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
    examination_id uuid,
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
-- Name: COLUMN course_examination_analysis.examination_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.examination_id IS '考试题ID';


--
-- Name: COLUMN course_examination_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_analysis.content IS '解析内容';


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
    examination_id uuid,
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
-- Name: COLUMN course_examination_item.examination_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.course_examination_item.examination_id IS '考试题ID';


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
    title character varying(1000) NOT NULL,
    category integer DEFAULT 1,
    score integer DEFAULT 1,
    right_state boolean DEFAULT false
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
-- Name: COLUMN employee_course_exercise.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.title IS '练习题题目';


--
-- Name: COLUMN employee_course_exercise.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.category IS '练习题类型';


--
-- Name: COLUMN employee_course_exercise.score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.score IS '练习题分值';


--
-- Name: COLUMN employee_course_exercise.right_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise.right_state IS '答对状态';


--
-- Name: employee_course_exercise_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_course_exercise_analysis (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    exercise_id uuid,
    content text
);


ALTER TABLE public.employee_course_exercise_analysis OWNER TO postgres;

--
-- Name: TABLE employee_course_exercise_analysis; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_course_exercise_analysis IS '员工课程练习题解析';


--
-- Name: COLUMN employee_course_exercise_analysis.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_analysis.id IS '流水号';


--
-- Name: COLUMN employee_course_exercise_analysis.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_analysis.create_time IS '创建时间';


--
-- Name: COLUMN employee_course_exercise_analysis.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_analysis.update_time IS '更新时间';


--
-- Name: COLUMN employee_course_exercise_analysis.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_analysis.flag IS '标记';


--
-- Name: COLUMN employee_course_exercise_analysis.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_analysis.exercise_id IS '练习题ID';


--
-- Name: COLUMN employee_course_exercise_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_analysis.content IS '解析内容';


--
-- Name: employee_course_exercise_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_course_exercise_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    exercise_id uuid,
    title character varying(1000),
    is_answer boolean DEFAULT false,
    check_state boolean DEFAULT false
);


ALTER TABLE public.employee_course_exercise_item OWNER TO postgres;

--
-- Name: TABLE employee_course_exercise_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_course_exercise_item IS '员工课程练习题答题选项';


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
-- Name: COLUMN employee_course_exercise_item.exercise_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.exercise_id IS '课程练习题ID';


--
-- Name: COLUMN employee_course_exercise_item.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.title IS '课程选项标题';


--
-- Name: COLUMN employee_course_exercise_item.is_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.is_answer IS '是否为正确答案';


--
-- Name: COLUMN employee_course_exercise_item.check_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_course_exercise_item.check_state IS '勾选状态';


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
    study_time timestamp without time zone
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
-- Name: employee_examination_paper; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_examination_paper (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    paper_id uuid,
    paper_title character varying(300),
    employee_id uuid,
    employee_name character varying(50),
    course_id uuid,
    course_name character varying(300),
    test_type integer DEFAULT 0,
    test_state integer DEFAULT 0,
    test_amount integer DEFAULT 1,
    duration integer,
    question_amount integer,
    question_type integer,
    total_score integer DEFAULT 100,
    pass_score integer DEFAULT 60,
    test_score integer DEFAULT 0,
    pass_state boolean DEFAULT false,
    single_amount integer,
    multi_amount integer,
    judge_amount integer,
    check_amount integer,
    fill_amount integer,
    join_state integer,
    start_time timestamp without time zone,
    end_time timestamp without time zone,
    submit_time timestamp without time zone
);


ALTER TABLE public.employee_examination_paper OWNER TO postgres;

--
-- Name: TABLE employee_examination_paper; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_examination_paper IS '员工考卷';


--
-- Name: COLUMN employee_examination_paper.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.id IS '流水号';


--
-- Name: COLUMN employee_examination_paper.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.create_time IS '创建时间';


--
-- Name: COLUMN employee_examination_paper.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.update_time IS '更新时间';


--
-- Name: COLUMN employee_examination_paper.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.flag IS '标记';


--
-- Name: COLUMN employee_examination_paper.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.status IS '标记';


--
-- Name: COLUMN employee_examination_paper.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.paper_id IS '考卷ID';


--
-- Name: COLUMN employee_examination_paper.paper_title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.paper_title IS '考卷ID';


--
-- Name: COLUMN employee_examination_paper.employee_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.employee_id IS '员工ID';


--
-- Name: COLUMN employee_examination_paper.employee_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.employee_name IS '员工姓名';


--
-- Name: COLUMN employee_examination_paper.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.course_id IS '课程ID';


--
-- Name: COLUMN employee_examination_paper.course_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.course_name IS '课程名称';


--
-- Name: COLUMN employee_examination_paper.test_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.test_type IS '考试类型：1自动考试，2统一考试';


--
-- Name: COLUMN employee_examination_paper.test_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.test_state IS '考试状态：1等待考试，2开始考试，3暂停考试，4考试作废';


--
-- Name: COLUMN employee_examination_paper.test_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.test_amount IS '考试次数（补考次数）';


--
-- Name: COLUMN employee_examination_paper.duration; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.duration IS '时长';


--
-- Name: COLUMN employee_examination_paper.question_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.question_amount IS '考题总数';


--
-- Name: COLUMN employee_examination_paper.question_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.question_type IS '考题分配：1随机分配题型数量，2自行分配题型数量';


--
-- Name: COLUMN employee_examination_paper.total_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.total_score IS '总分数';


--
-- Name: COLUMN employee_examination_paper.pass_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.pass_score IS '合格分数';


--
-- Name: COLUMN employee_examination_paper.test_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.test_score IS '考试成绩（测试成绩）';


--
-- Name: COLUMN employee_examination_paper.pass_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.pass_state IS '通过状态：1及格，2不及格';


--
-- Name: COLUMN employee_examination_paper.single_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.single_amount IS '单选题数量';


--
-- Name: COLUMN employee_examination_paper.multi_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.multi_amount IS '多选题数量';


--
-- Name: COLUMN employee_examination_paper.judge_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.judge_amount IS '判断题数量';


--
-- Name: COLUMN employee_examination_paper.check_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.check_amount IS '不定项选择题数量';


--
-- Name: COLUMN employee_examination_paper.fill_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.fill_amount IS '填空题数量';


--
-- Name: COLUMN employee_examination_paper.join_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.join_state IS '参与状态：1正常，2缺考';


--
-- Name: COLUMN employee_examination_paper.start_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.start_time IS '开考时间';


--
-- Name: COLUMN employee_examination_paper.end_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.end_time IS '结束时间';


--
-- Name: COLUMN employee_examination_paper.submit_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_paper.submit_time IS '交卷时间';


--
-- Name: employee_examination_question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_examination_question (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    paper_id uuid,
    question_id uuid,
    title character varying(1000),
    category integer DEFAULT 1,
    score integer DEFAULT 1,
    answer_state integer DEFAULT 1,
    right_state boolean DEFAULT false
);


ALTER TABLE public.employee_examination_question OWNER TO postgres;

--
-- Name: TABLE employee_examination_question; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_examination_question IS '员工考卷试题';


--
-- Name: COLUMN employee_examination_question.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.id IS '流水号';


--
-- Name: COLUMN employee_examination_question.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.create_time IS '创建时间';


--
-- Name: COLUMN employee_examination_question.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.update_time IS '更新时间';


--
-- Name: COLUMN employee_examination_question.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.flag IS '标记';


--
-- Name: COLUMN employee_examination_question.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.status IS '标记';


--
-- Name: COLUMN employee_examination_question.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.paper_id IS '考卷ID';


--
-- Name: COLUMN employee_examination_question.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.question_id IS '考题ID';


--
-- Name: COLUMN employee_examination_question.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.title IS '试题标题';


--
-- Name: COLUMN employee_examination_question.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.category IS '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';


--
-- Name: COLUMN employee_examination_question.score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.score IS '分值';


--
-- Name: COLUMN employee_examination_question.answer_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.answer_state IS '作答状态：1未作答，2作答标记，3已作答';


--
-- Name: COLUMN employee_examination_question.right_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question.right_state IS '回答正确状态';


--
-- Name: employee_examination_question_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_examination_question_analysis (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    question_id uuid,
    content text
);


ALTER TABLE public.employee_examination_question_analysis OWNER TO postgres;

--
-- Name: TABLE employee_examination_question_analysis; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_examination_question_analysis IS '员工考试题解析';


--
-- Name: COLUMN employee_examination_question_analysis.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_analysis.id IS '流水号';


--
-- Name: COLUMN employee_examination_question_analysis.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_analysis.create_time IS '创建时间';


--
-- Name: COLUMN employee_examination_question_analysis.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_analysis.update_time IS '更新时间';


--
-- Name: COLUMN employee_examination_question_analysis.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_analysis.flag IS '标记';


--
-- Name: COLUMN employee_examination_question_analysis.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_analysis.status IS '状态';


--
-- Name: COLUMN employee_examination_question_analysis.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_analysis.question_id IS '考题ID';


--
-- Name: COLUMN employee_examination_question_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_analysis.content IS '解析内容';


--
-- Name: employee_examination_question_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee_examination_question_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    question_id uuid,
    title character varying(1000),
    is_answer boolean DEFAULT false,
    check_state boolean DEFAULT false
);


ALTER TABLE public.employee_examination_question_item OWNER TO postgres;

--
-- Name: TABLE employee_examination_question_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.employee_examination_question_item IS '员工试题作答';


--
-- Name: COLUMN employee_examination_question_item.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.id IS '流水号';


--
-- Name: COLUMN employee_examination_question_item.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.create_time IS '创建时间';


--
-- Name: COLUMN employee_examination_question_item.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.update_time IS '更新时间';


--
-- Name: COLUMN employee_examination_question_item.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.flag IS '标记';


--
-- Name: COLUMN employee_examination_question_item.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.status IS '状态';


--
-- Name: COLUMN employee_examination_question_item.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.question_id IS '试题ID';


--
-- Name: COLUMN employee_examination_question_item.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.title IS '答题项标题';


--
-- Name: COLUMN employee_examination_question_item.is_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.is_answer IS '是否为参考答案';


--
-- Name: COLUMN employee_examination_question_item.check_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.employee_examination_question_item.check_state IS '选择状态';


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
-- Name: examination_config; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_config (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    duration integer,
    test_type integer,
    paper_type integer,
    test_amount integer DEFAULT 2,
    question_type integer,
    question_amount integer,
    total_score integer DEFAULT 100,
    pass_score integer DEFAULT 60,
    single_type integer DEFAULT 1,
    single_amount integer,
    multi_type integer DEFAULT 1,
    multi_amount integer,
    judge_type integer DEFAULT 1,
    judge_amount integer,
    check_type integer DEFAULT 1,
    check_amount integer,
    fill_type integer DEFAULT 1,
    fill_amount integer
);


ALTER TABLE public.examination_config OWNER TO postgres;

--
-- Name: TABLE examination_config; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.examination_config IS '考试';


--
-- Name: COLUMN examination_config.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.id IS '流水号';


--
-- Name: COLUMN examination_config.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.create_time IS '创建时间';


--
-- Name: COLUMN examination_config.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.update_time IS '更新时间';


--
-- Name: COLUMN examination_config.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.flag IS '标记';


--
-- Name: COLUMN examination_config.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.status IS '状态';


--
-- Name: COLUMN examination_config.duration; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.duration IS '考试时长（单位：分钟）';


--
-- Name: COLUMN examination_config.test_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.test_type IS '考试类型：1课程学习完成后自动考试，2由教师统计安排统计';


--
-- Name: COLUMN examination_config.paper_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.paper_type IS '考卷类型：1系统随机出卷，2由教师自行出卷';


--
-- Name: COLUMN examination_config.test_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.test_amount IS '考试次数（补考次数）';


--
-- Name: COLUMN examination_config.question_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.question_type IS '考题分配：1自动分配，2自行分配';


--
-- Name: COLUMN examination_config.question_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.question_amount IS '考题总数';


--
-- Name: COLUMN examination_config.total_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.total_score IS '总成绩';


--
-- Name: COLUMN examination_config.pass_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.pass_score IS '合格成绩';


--
-- Name: COLUMN examination_config.single_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.single_type IS '单选题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_config.single_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.single_amount IS '单选题数量';


--
-- Name: COLUMN examination_config.multi_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.multi_type IS '多选题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_config.multi_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.multi_amount IS '多选题数量';


--
-- Name: COLUMN examination_config.judge_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.judge_type IS '判断题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_config.judge_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.judge_amount IS '判断题数量';


--
-- Name: COLUMN examination_config.check_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.check_type IS '不定项选择题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_config.check_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.check_amount IS '不定项选择题数量';


--
-- Name: COLUMN examination_config.fill_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.fill_type IS '填空题类型：1随机数量，2固定数量';


--
-- Name: COLUMN examination_config.fill_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_config.fill_amount IS '填空题数量';


--
-- Name: examination_paper; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_paper (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    course_id uuid,
    test_type integer DEFAULT 0,
    test_state integer DEFAULT 0,
    test_amount integer DEFAULT 2,
    duration integer,
    title character varying(300),
    question_amount integer,
    question_type integer,
    total_score integer DEFAULT 100,
    pass_score integer DEFAULT 60,
    single_amount integer,
    multi_amount integer,
    judge_amount integer,
    check_amount integer,
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
-- Name: COLUMN examination_paper.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.status IS '状态';


--
-- Name: COLUMN examination_paper.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.course_id IS '课程ID';


--
-- Name: COLUMN examination_paper.test_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.test_type IS '考试类型：1自动考试，2统一考试';


--
-- Name: COLUMN examination_paper.test_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.test_state IS '考试状态：1等待考试，2开始考试，3结束考试';


--
-- Name: COLUMN examination_paper.test_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.test_amount IS '考试次数（补考次数）';


--
-- Name: COLUMN examination_paper.duration; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.duration IS '时长';


--
-- Name: COLUMN examination_paper.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.title IS '标题';


--
-- Name: COLUMN examination_paper.question_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.question_amount IS '考题总数';


--
-- Name: COLUMN examination_paper.question_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.question_type IS '考题分配：1随机分配题型数量，2自行分配题型数量';


--
-- Name: COLUMN examination_paper.single_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.single_amount IS '单选题数量';


--
-- Name: COLUMN examination_paper.multi_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.multi_amount IS '多选题数量';


--
-- Name: COLUMN examination_paper.judge_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.judge_amount IS '判断题数量';


--
-- Name: COLUMN examination_paper.check_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_paper.check_amount IS '不定项选择题数量';


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
    title character varying(1000),
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
-- Name: COLUMN examination_question.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question.title IS '试题标题';


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
    question_id uuid,
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
-- Name: COLUMN examination_question_analysis.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.question_id IS '考题ID';


--
-- Name: COLUMN examination_question_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_analysis.content IS '解析内容';


--
-- Name: examination_question_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examination_question_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
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
-- Name: COLUMN examination_question_item.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.examination_question_item.status IS '状态';


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
-- Name: store_paper; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.store_paper (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    show_state boolean DEFAULT false,
    course_id uuid NOT NULL,
    title character varying(1000) NOT NULL,
    duration integer,
    question_amount integer,
    total_score integer,
    pass_score integer,
    test_amount integer DEFAULT 2,
    editor_id uuid,
    editor_name character varying(50),
    edit_state integer,
    edit_time timestamp without time zone,
    auditor_id uuid,
    auditor_name character varying(50),
    audit_state integer,
    audit_time timestamp without time zone,
    auditor_mind character varying(500)
);


ALTER TABLE public.store_paper OWNER TO postgres;

--
-- Name: TABLE store_paper; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.store_paper IS '题库试卷';


--
-- Name: COLUMN store_paper.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.id IS '流水号';


--
-- Name: COLUMN store_paper.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.create_time IS '创建时间';


--
-- Name: COLUMN store_paper.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.flag IS '标记';


--
-- Name: COLUMN store_paper.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.status IS '状态';


--
-- Name: COLUMN store_paper.show_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.show_state IS '显示状态';


--
-- Name: COLUMN store_paper.course_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.course_id IS '课程ID';


--
-- Name: COLUMN store_paper.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.title IS '标题';


--
-- Name: COLUMN store_paper.duration; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.duration IS '时长（单位：分钟）';


--
-- Name: COLUMN store_paper.question_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.question_amount IS '题目总数';


--
-- Name: COLUMN store_paper.total_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.total_score IS '总分数';


--
-- Name: COLUMN store_paper.pass_score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.pass_score IS '合格分数';


--
-- Name: COLUMN store_paper.test_amount; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.test_amount IS '补考次数';


--
-- Name: COLUMN store_paper.editor_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.editor_id IS '编辑人ID';


--
-- Name: COLUMN store_paper.editor_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.editor_name IS '编辑人姓名';


--
-- Name: COLUMN store_paper.edit_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.edit_state IS '编辑状态：1草稿，2定稿';


--
-- Name: COLUMN store_paper.edit_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.edit_time IS '编辑时间';


--
-- Name: COLUMN store_paper.auditor_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.auditor_id IS '审核人ID';


--
-- Name: COLUMN store_paper.auditor_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.auditor_name IS '审核人名称';


--
-- Name: COLUMN store_paper.audit_state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.audit_state IS '审核状态，1待审核，2通过，3不通过';


--
-- Name: COLUMN store_paper.auditor_mind; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_paper.auditor_mind IS '审核意见';


--
-- Name: store_question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.store_question (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    paper_id uuid,
    title character varying(1000),
    category integer DEFAULT 1,
    score integer DEFAULT 1
);


ALTER TABLE public.store_question OWNER TO postgres;

--
-- Name: TABLE store_question; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.store_question IS '课程考试题';


--
-- Name: COLUMN store_question.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.id IS '流水号';


--
-- Name: COLUMN store_question.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.create_time IS '创建时间';


--
-- Name: COLUMN store_question.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.update_time IS '更新时间';


--
-- Name: COLUMN store_question.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.flag IS '标记';


--
-- Name: COLUMN store_question.paper_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.paper_id IS '考卷ID';


--
-- Name: COLUMN store_question.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.title IS '试题标题';


--
-- Name: COLUMN store_question.category; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.category IS '类型：1单选题，2多选题，3不定项选择题，4判断题，5填空题，6主观题';


--
-- Name: COLUMN store_question.score; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question.score IS '分值';


--
-- Name: store_question_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.store_question_analysis (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    question_id uuid,
    content text
);


ALTER TABLE public.store_question_analysis OWNER TO postgres;

--
-- Name: TABLE store_question_analysis; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.store_question_analysis IS '课程考试题解析';


--
-- Name: COLUMN store_question_analysis.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_analysis.id IS '流水号';


--
-- Name: COLUMN store_question_analysis.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_analysis.create_time IS '创建时间';


--
-- Name: COLUMN store_question_analysis.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_analysis.update_time IS '更新时间';


--
-- Name: COLUMN store_question_analysis.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_analysis.flag IS '标记';


--
-- Name: COLUMN store_question_analysis.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_analysis.question_id IS '考题ID';


--
-- Name: COLUMN store_question_analysis.content; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_analysis.content IS '解析内容';


--
-- Name: store_question_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.store_question_item (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    question_id uuid,
    title character varying(1000),
    is_answer boolean DEFAULT false
);


ALTER TABLE public.store_question_item OWNER TO postgres;

--
-- Name: TABLE store_question_item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.store_question_item IS '课程考试题选择';


--
-- Name: COLUMN store_question_item.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.id IS '流水号';


--
-- Name: COLUMN store_question_item.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.create_time IS '创建时间';


--
-- Name: COLUMN store_question_item.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.update_time IS '更新时间';


--
-- Name: COLUMN store_question_item.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.flag IS '标记';


--
-- Name: COLUMN store_question_item.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.status IS '状态';


--
-- Name: COLUMN store_question_item.question_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.question_id IS '考题ID';


--
-- Name: COLUMN store_question_item.title; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.title IS '标题';


--
-- Name: COLUMN store_question_item.is_answer; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.store_question_item.is_answer IS '是否参考答案';


--
-- Name: sys_base_config; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sys_base_config (
    id uuid NOT NULL,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    flag boolean DEFAULT true,
    status boolean DEFAULT true,
    system_name character varying(200),
    copyright character varying(200),
    web_site character varying(255),
    allow_upload_image character varying(200),
    allow_upload_file character varying(200),
    allow_upload_media character varying(200),
    allow_upload_flash character varying(100),
    keywords character varying(500),
    description character varying(500)
);


ALTER TABLE public.sys_base_config OWNER TO postgres;

--
-- Name: TABLE sys_base_config; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.sys_base_config IS '数字字典';


--
-- Name: COLUMN sys_base_config.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.id IS '流水号';


--
-- Name: COLUMN sys_base_config.create_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.create_time IS '创建时间';


--
-- Name: COLUMN sys_base_config.update_time; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.update_time IS '更新时间';


--
-- Name: COLUMN sys_base_config.flag; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.flag IS '标记';


--
-- Name: COLUMN sys_base_config.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.status IS '状态';


--
-- Name: COLUMN sys_base_config.system_name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.system_name IS '系统名称';


--
-- Name: COLUMN sys_base_config.copyright; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.copyright IS '版本所有';


--
-- Name: COLUMN sys_base_config.web_site; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.web_site IS '网址';


--
-- Name: COLUMN sys_base_config.allow_upload_image; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.allow_upload_image IS '允许上传的图片扩展名';


--
-- Name: COLUMN sys_base_config.allow_upload_file; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.allow_upload_file IS '允许上传的文件扩展名';


--
-- Name: COLUMN sys_base_config.allow_upload_media; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.allow_upload_media IS '允许上传的媒体扩展名';


--
-- Name: COLUMN sys_base_config.allow_upload_flash; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.allow_upload_flash IS '允许上传的FLASH扩展名';


--
-- Name: COLUMN sys_base_config.keywords; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.keywords IS '关键字，多个用英文“,”分隔';


--
-- Name: COLUMN sys_base_config.description; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.sys_base_config.description IS '描述，网站（系统描述）';


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
    introduction character varying(1000),
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
-- Data for Name: certificate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.certificate (id, create_time, update_time, flag, status, name, department, official_seal, grade) FROM stdin;
b61ba6c0-dec1-11e8-a899-08d40c3d2417	2018-11-03 01:07:00.012	2018-11-03 01:23:50.314	f	f	软件工程师	\N	\N	\N
\.


--
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course (id, create_time, update_time, flag, status, type_id, teacher_id, code, name, introduction, description, test_type, test_state, test_amount, duration, question_amount, question_type, single_amount, multi_amount, judge_amount, check_amount, fill_amount, total_score, pass_score) FROM stdin;
c60c5b40-dfea-11e8-bed3-08d40c3d2417	2018-11-04 12:33:27.284	2018-11-17 20:05:58.127	t	t	a7b02b20-dfe7-11e8-b67d-08d40c3d2417	23b06360-dfe4-11e8-8e1e-08d40c3d2417	ISO14001-2005	ISO14001环境管理体系	ISO 14001 是环境管理体系认证的代号。ISO 14000 系列标准是由国际标准化组织制订的环境管理体系标准。是针对全球性的环境污染和生态破坏越来越严重，臭氧层破坏、全球气候变暖、生物多样性的消失等重大环境问题威胁着人类未来生存和发展，顺应国际环境保护的需求，依据国际经济贸易发展的需要而制定的。	<p>ISO 14001 是环境管理体系认证的代号。ISO 14000 系列标准是由国际标准化组织制订的环境管理体系标准。是针对全球性的环境污染和生态破坏越来越严重，臭氧层破坏、全球气候变暖、生物多样性的消失等重大环境问题威胁着人类未来生存和发展，顺应国际环境保护的需求，依据国际经济贸易发展的需要而制定的。</p><p>目录</p><p>1 标准目录</p><p>2 环境管理</p><p>3 产生背景</p><p>4 意义</p><p>5 异同</p><p>6 标准分类</p><p>7 制定基础</p><p>8 具备条件</p><p>9 关键原则</p><p>10 贸易影响</p><p>11 国外情况</p><p>12 实施动态</p><p>13 环境管理</p><p>14 九大步骤</p><p>15 影响</p><p>标准目录</p><p>前言</p><p>引言</p><p>1、范围</p><p>2、规范性引用文件</p><p>3、术语和定义</p><p>4、环境管理体系要求</p><p>4.1总要求</p><p>4.2环境方针</p><p>4.3策划</p><p>4.3.1环境因素</p><p>4.3.2法律法规和其他要求</p><p>4.3.3目标、指标和方案</p><p>4.4实施与运行</p><p>4.4.1资源、作用、职责和权限</p><p>ISO14001标准</p><p>ISO14001标准</p><p>4.4.2能力、培训和意识</p><p>4.4.3信息交流</p><p>4.4.4文件</p><p>4.4.5文件控制</p><p>4.4.6运行控制</p><p>4.4.7应急准备和响应</p><p>4.5检查</p><p>4.5.1监测和测量</p><p>4.5.2合规性评价</p><p>4.5.3不符合、纠正措施和预防措施</p><p>4.5.4记录控制</p><p>4.5.5内部审核</p><p>4.6管理评审</p><p>环境管理</p><p>1、范围</p><p>本标准规定了对环境管理体系的要求，使一个组织能够根据法律法规和它应遵守的其他要求，以及关于重要环境因素的信息，制定和实施环境方针与目标。它适用于那些组织确定为能够控制，或有可能施加影响的环境因素。但标准本身并未提出具体的环境绩效准则。</p><p>本标准适用于任何有下列愿望的组织：</p><p>a) 建立、实施、保持并改进环境管理体系；</p><p>b) 使自己确信能符合所声明的环境方针；</p><p>c) 通过下列方式展示对本标准的符合；</p><p>1） 进行自我评价和自我声明；</p><p>2） 寻求组织的相关方（如顾客）对其符合性予以确认；</p><p>3） 寻求外部对它的自我声明予以确认；</p><p>4） 寻求外部组织对其环境管理进行认证/注册。</p><p>本标准规定的所有要求都能纳入任何一个环境管理。其应用程度取决于诸如组织的环境方针、它的活动、产品和服务的性质、以及它的运行场所及条件等因素。本标准还在附录A中对如何使用本标准提供了资料性的指南。</p><p>2、引用标准</p><p>无引用标准。保留本章是为了使本版中的章节号和前一版（GB/T24001－1996）保持一致。</p><p>3、术语和定义</p><p>下列术语和定义适用于本标准：</p><p>3.1</p><p>审核员auditor</p><p>有能力实施审核的人员。</p><p>[GB/T19000－2008，3.9.9]</p><p>3.2</p><p>持续改进continual improvement</p><p>不断对环境管理体系（3.8）进行强化的过程，目的是根据组织（3.16）的环境方针（3.11），实现对环境绩效（3.10）的改进。</p><p>注：该过程不必同时发生于活动的所有方面。</p><p>3.3</p><p>纠正措施corrective action</p><p>为消除已发现的不符合（3.15）的原因所采取的措施。</p><p>3.4</p><p>文件document</p><p>信息及其承载媒介。</p><p>注1：媒介可以是纸张，计算机磁盘、光盘或其他电子媒体，照片或标准样品，或它们的组合。</p><p>注2：摘纺自GB/T19000－2008，3.7.2。</p><p>3.5</p><p>环境environment</p><p>组织（3.16）运行活动的外部存在，包括空气、水、土地、自然资源、植物、动物、人，以及它们之间的相互关系。</p><p>注：从这一意义上，外部存在从组织（3.16）内延伸到全球系统。</p><p>3.6</p><p>环境因素 environment factors</p><p>一个组织（3.16）的活动、产品和服务中能与环境（3.5）发生相互作用的要素。</p><p>注：重要环境因素是指具有或能够产生重大环境影响的环境因素。</p><p>3.7</p><p>环境影响 environment effect</p><p>全部或部分地由组织（3.16）的环境因素（3.6）给环境（3.5）造成的任何有害或有益的变化。</p><p>3.8</p><p>环境管理体系environmental management system(EMS)</p><p>组织（3.16）管理体系的一部分，用来制定和实施其环境方针（3.11），并管理其环境因素（3.6）。</p><p>注1：管理体系是用来建立方针和目标，并进而实现这些目标的一系列相互关联的要素的集合。</p><p>注2：管理体系包括组织结构、策划活动、职责、惯例、程序（3.19）、过程和资源。</p><p>3.9</p><p>环境目标environmental objective</p><p>组织（3.16）依据其环境方针（3.11）规定的自己所要实现的总体环境目的。</p><p>3.10</p><p>环境绩效environmental　performance</p><p>组织（3.16）对其环境因素（3.6）进行管理所取得的可测量结果。</p><p>注：在环境管理体系条件下，可对照组织（3.16）的环境方针（3.11）、环境目标（3.9）、环境指标（3.12）及其他环境绩效要求对结果进行测量。</p><p>3.11</p><p>环境方针environmental　policy</p><p>由最高管理者就组织（3.16）的环境绩效（3.10）正式表述的总体意图和方向。</p><p>注：环境方针为采取措施，以及建立环境目标（3.9）和环境指标（3.12）提供了一个框架。</p><p>3.12</p><p>环境指标environmental　target</p><p>由环境目标（3.9）产生，为实现环境目标所须规定并满足的具体的绩效要求，它们可适用于整个组织（3.16）或其局部。</p><p>3.13</p><p>相关方interested party</p><p>关注组织（3.16）的环境绩效（3.10）或受其环境绩效影响的个人或团体。</p><p>3.14</p><p>内部审核internal audit</p><p>客观地获取审核证据并予以评价，以判定组织（3.16）对其设定的环境管理体系审核准则满足程度的系统的、独立的、形成文件的过程。</p><p>注：在许多情况下，特别是对于小型组织，独立性可通过与所审核活动无责任关系来体现。</p><p>3.15</p><p>不符合non-conformity</p><p>未满足要求。</p><p>[GB/T19000－2008，3.6.2]</p><p>注：此术语在GB/T19000－2000中为“不合格（不符合）”。</p><p>3.16</p><p>组织organization</p><p>具有自身职能和行政管理的公司、集团公司、商行、企事业单位、政府机构、社团或其结合体，或上述单位中具有自身职能和行政管理的一部分，无论其是否有法人资格，国有或私营。</p><p>注：对于拥有一个以上运行单位的组织，可以把一个运行单位视为一个组织。</p><p>3.17</p><p>预防措施preventive action</p><p>为消除潜在不符合（3.15）原因所采取的措施。</p><p>3.18</p><p>污染预防prevention of pollution</p><p>为了降低有害的环境影响（3.7）而采用（或综合采用）过程、惯例、技术、材料、产品、服务或能源以避免、减少或控制任何类型的污染物或废物的产生、排放或废弃。</p><p>注：污染预防可包括源削减或消除，过程、产品或服务的更改，资源的有效利用，材料或能源替代，再利用、回收、再循环、再生和处理。</p><p>3.19</p><p>程序procedure</p><p>为进行某项活动或过程所规定的途径。</p><p>注1：程序可以形成文件，也可以不形成文件。</p><p>注2：摘编自GB/T19000－2008中3.4.5</p><p>3.20</p><p>记录record</p><p>阐明已取得的结果或提供所从事活动的证据的文件（3.4）。</p><p>注：摘编自GB/T19000－2008中3.7.6条改写。</p><p>4环境管理体系要求</p><p>4.1总要求</p><p>组织应根据本标准的要求建立实施、保持和持续改进环境管理体系，确定如何实现这些要求，并形成文件。</p><p>组织应界定环境管理体系的范围，并形成文件。</p><p>4.2环境方针</p><p>最高管理者应确定本组织的环境方针，并在界定的环境管理体系范围内，确保其：</p><p>a）适合于组织活动、产品和服务的性质、规模和环境影响；</p><p>b）包括对持续改进和污染预防的承诺。</p><p>C）包括对遵守与其环境因素有关的适用法律法规要求和其他要求的承诺；</p><p>d）提供建立和评审环境目标和指标的框架；</p><p>e）形成文件，付诸实施，并予以保持；</p><p>f）传达到所有为组织或代表组织工作的人员；</p><p>g）可为公众所获取。</p><p>4.3策划</p><p>4.3.1环境因素</p><p>组织应建立、实施并保持一个或多个程序，用来：</p><p>a）识别其环境管理体系覆盖范围内的活动、产品和服务中能够控制、或能够施加影响的环境因素，此时应考虑到已纳入计划的或新的开发、新的或修改的活动、产品和服务等因素；</p><p>b）确定对环境具有、或可能具有重大影响的因素（即重要环境因素）。</p><p>组织应将这些信息形成文件并及时更新。</p><p>组织应确保在建立、实施和保持环境管理体系时，对重要环境因素加以考虑。</p><p>4.3.2法律法规和其他要求</p><p>组织应建立、实施并保持一个或多个程序，用来</p><p>a）识别适用于其活动、产品和服务中环境因素的法律法规和其他应遵守的要求，并建立获取这些要求的渠道；</p><p>b）确定这些要求如何应用于组织的环境因素。</p><p>组织应确保在建立、实施和保持环境管理体系时，对这些适用的法律法规和其他要求加以考虑。</p><p>4.3.3目标、指标和方案</p><p>组织应对其内部有关职能和层次，建立、实施并保持形成文件的环境目标和指标。</p><p>如可行，目标和指标应可测量。目标和指标应符合环境方针，并包括对污染预防、持续改进和遵守适用的法律法规及其他要求的承诺。</p><p>组织在建立和评审目标和指标时，应考虑法律法规和其他要求，以及自身的重要环境因素。此外，还应考虑可选的技术方案，财务、运行和经营要求，以及相关方的观点。</p><p>组织应制定、实施并保持一个或多个用于实现其目标和指标的方案，其中应包括：</p><p>a）规定组织内各有关职能和层次实现目标和指标的职责；</p><p>b）实现目标和指标的方法和时间表。</p><p>4.4实施与运行</p><p>4.4.1资源、作用、职责和权限</p><p>管理者应确保为环境管理体系的建立、实施、保持和改进提供必要的资源。资源包括人力资源专项技能、组织的基础设施、以及技术和财力资源。</p><p>为便于环境管理工作的有效开展，应对作用、职责和权限做出明确规定，形成文件，并予以传达。</p><p>组织的最高管理者应任命专门的管理者代表，无论他（们）是否还负有其他方面的责任，应明确规定其作用、职责和权限，以便：</p><p>a）确保按照本标准的要求建立、实施和保持环境管理体系；</p><p>b）向最高管理者报告环境管理体系的运行情况以供评审，并提出改进建议。</p><p>4.4.2能力、培训和意识</p><p>组织应确保所有为它或代表它从事被确定为可能具有重大环境影响的工作的人员，都具备相应的能力。该能力基于必要的教育、培训或经历。组织应保存相关的记录。</p><p>组织应确定与其环境因素和环境管理体系有关的培训需求并提供培训，或采取其他措施来满足这些需求。应保存相关的记录。</p><p>组织应建立、实施并保持一个或多个程序，使为它或代表它工作的人员都意识到：</p><p>a）符合环境方针与程序和符合环境管理体系要求的重要性；</p><p>b）他们工作中的重要环境因素和实际的或潜在的环境影响，以及个人工作的改进所能带来的环境效益；</p><p>c）他们在实现与环境管理体系要求符合性方面的作用与职责；</p><p>d）偏离规定的运行程序的潜在后果。</p><p>4.4.3信息交流</p><p>组织应建立、实施并保持一个或多个程序，用于有关其环境因素和环境管理体系的：</p><p>a）组织内部各层次和职能间的信息交流；</p><p>b）与外部相关方联络的接收、形成文件和回应。</p><p>组织应决定是否应其重要环境因素与外界进行信息交流，并将决定形成文件。如决定进行外部交流，就应规定交流的方式并予以实施。</p><p>4.4.4文件</p><p>环境管理体系文件应包括：</p><p>a）环境方针、目标和指标；</p><p>b）对环境管理体系的覆盖范围的描述；</p><p>c）对环境管理体系主要要素及其相互作用的描述，以及相关文件的查询途径；</p><p>d）本标准要求的文件，包括记录；</p><p>e）组织为确保对涉及重要环境因素的过程进行有效策划、运行和控制所需的文件和记录。</p><p>4.4.5文件控制</p><p>应对本标准和环境管理体系所要求的文件进行控制。记录是一种特殊的文件，应该按照4.5.4的要求进行控制。</p><p>组织应建立、实施并保持一个或多个程序，以规定：</p><p>a）在文件发布前进行审批，确保其充分性和适宜性；</p><p>b）必要时对文件进行评审和更新，并重新审批；</p><p>c）确保对文件的更改和现行修订状态做出标识；</p><p>d）确保在使用处能得到适用文件的有关版本；</p><p>e）确保文件字迹清楚，标识明确；</p><p>f）确保对策划和运行环境管理体系所需的外部文件做出标识，并对其发放予以控制；</p><p>g）防止对过期文件的非预期使用。如须将其保留，要做出适当的标识。</p><p>4.4.6运行控制</p><p>组织应根据其方针、目标和指标，识别和策划与所确定的重要环境因素有关的运行，以确保它们通过下列方式在规定的条件下进行：</p><p>a) 建立、实施并保持一个或多个形成文件的程序，以控制因缺乏程序文件而导致偏离环境方针、目标和指标的情况；</p><p>b）在程序中规定运行准则；</p><p>c）对于组织使用的产品和服务中所确定的重要环境因素，应建立、实施并保持程序，并将适用的程序和要求通报供方及合同方。</p><p>4.4.7应急准备和响应</p><p>组织应建立、实施并保持一个或多个程序，用于识别可能对环境造成影响的潜在的紧急情况和事故，并规定响应措施。</p><p>组织应对实际发生的紧急情况和事故作出响应，并预防或减少随之产生的有害环境影响。</p><p>组织应定期评审其应急准备和响应程序。必要时对其进行修订，特别是当事故或紧急情况发生后。</p><p>可行时，组织还应定期试验上述程序。</p><p>4.5检查</p><p>4.5.1监测和测量</p><p>组织应建立、实施并保持一个或多个程序，对可能具有重大环境影响的运行的关键特性进行例行监测和测量。程序中应规定将监测环境绩效、适用的运行控制、目标和指标符合情况的信息形成文件。</p><p>组织应确保所使用的监测和测量设备经过校准或验证，并予以妥善维护。且应保存相关的记录。</p><p>4.5.2合规性评价</p><p>4.5.2.1</p><p>为了履行遵守法律法规要求的承诺，组织应建立、实施并保持一个或多个程序，以定期评价对适用法律法规的遵守情况。</p><p>组织应保存对上述定期评价结果的记录。</p><p>4.5.2.2</p><p>组织应评价对其他要求的遵守情况。这可以和4.5.2.1中所要求的评价一起进行，也可以另外制定程序，分别进行评价。</p><p>组织应保存上述定期评价结果的记录。</p><p>4.5.3不符合、纠正措施和预防措施</p><p>组织应建立、实施并保持一个或多个程序，用来处理实际或潜在的不符合，采取纠正措施和预防措施。程序中应规定以下方面的要求：</p><p>a）识别和纠正不符合，并采取措施减少所造成的环境影响；</p><p>b）对不符合进行调查，确定其产生原因，并采取措施避免再度发生；</p><p>c）评价采取措施以预防不符合的需求；实施所制定的适当措施，以避免不符合的发生；</p><p>d）记录采取纠正措施和预防措施的结果；</p><p>e）评审所采取的纠正措施和预防措施的有效性。</p><p>所采取的措施应与问题和环境影响的严重程度相符。</p><p>组织应确保对环境管理文件进行必要的更改。</p><p>4.5.4记录控制</p><p>组织应根据需要，建立并保持必要的记录，用来证实对环境管理体系和本标准要求的符合，以及所实现的结果。</p><p>组织应建立、实施并保持一个或多个程序，用于记录的标识、存放、保护、检索、留存和处置。</p><p>环境记录应字迹清楚，标识明确，并具有可追溯性。</p><p>4.5.5内部审核</p><p>组织应确保按照计划的时间间隔对管理体系进行内部审核。目的是：</p><p>a）判定环境管理体系</p><p>1） 是否符合组织对环境管理工作的预定安排和本标准的要求；</p><p>2） 是否得到了恰当的实施和保持。</p><p>b）向管理者报告审核结果。</p><p>组织应策划、制定、实施和保持一个或多个审核方案，此时，应考虑到相关运行的环境重要性和以前的审核结果。</p><p>应建立、实施和保持一个或多个审核程序，用来规定：</p><p>——策划和实施审核及报告审核结果、保存相关记录的职责和要求；</p><p>——审核准则、范围、频次和方法。</p><p>审核员的选择和审核的实施均应确保审核过程的客观性和公正性。</p><p>4.6管理评审</p><p>最高管理者应按计划的时间间隔，对组织的环境管理体系进行评审，以确保其持续适宜、充分性和有效性。评审应包括评价改进的机会和对环境管理体系进行和修改的需求，包括环境方针、环境目标和指标的修改需求。应保存管理评审记录。</p><p>管理评审的输入应包括：</p><p>a）内部审核和合规性评价的结果；</p><p>b）来自外部相关方的交流信息，包括抱怨；</p><p>c）组织的环境绩效；</p><p>d）目标和指标的实现程度；</p><p>e）纠正和预防措施的状况；</p><p>f）以前管理评审的后续措施；</p><p>g）客观环境的变化，包括与组织环境因素有关的法律法规和其他要求有关的发展变化；</p><p>h）改进建议。</p><p>管理评审的输出应包括为实现持续改进的承诺而作出的，与环境方针、目标、指标以及其他环境管理体系要素的修改有关的决策和行动。</p><p>产生背景</p><p>1972年，联合国在瑞典斯德戈尔摩召开了人类环境大会。大会成立了一个独立的委员会，即“世界环境与发展委员会”。该委员会承担重新评估环境与发展关系的调查研究任务，历时若干年，在考证大量素材后，于1987年出版了“我们共同未来”的报告，这篇报告首次引入了“持续发展”的观念，敦</p><p>证书样本</p><p>证书样本</p><p>促工业界建立有效的环境管理体系。这份报告一颁布即得到了50多个国家领导的支持，他们联合呼吁召开世界性会议专题讨论和制定行动纲领。</p><p>从80年代起，美国和西欧的一些公司为了响应持续发展的号召，减少污染，提高在公众的形象以获得商品经营支持，开始建立各自的环境管理方式，这是环境管理体系的雏形。1985年荷兰率先提出建立企业环境管理体系的概念，1988年试行实施，1990年进入标准化和许可证制度。1990年欧盟在慕尼黑的环境圆桌会议上专门讨论了环境审核问题。英国也在质量体系标准（BS750）基础上，制定BS7750环境管理体系。英国的BS7750和欧盟的环境审核实施后，欧洲的许多国家纷纷开展认证活动，由第三方予以证明企业的环境绩效。这些实践活动奠定了ISO14000系列标准产生的基础。</p><p>1992年在巴西里约热内卢召开“环境与发展”大会，183个国家和70多个国际组织出席会议，通过了“21世纪议程”等文件。这次大会的召开，标志全球谋求可持续发展的时代开始了。各国政府领导、科学家和公众认识到要实现可持续发展的目标，就必须改变工业污染控制的战略，从加强环境管理入手，建立污染预防（清洁生产）的新观念。通过企业的“自我决策、自我管理”方式，把环境管理融于企业全面管理之中。</p><p>为此国际标准化组织（ISO）于1993年6月成立了ISO/TC207环境管理技术委员会正式开展环境管理系列标准的制定工作，规范企业和社会团体等所有组织的活动、产品和服务的环境行为，支持全球的环境保护工作。</p><p>ISO 14000 是国际标准化组织（ISO）第207技术委员会（TC207）从1993年开始制定的一系列环境管理国际标准，它包括了环境管理体系（EMS）、环境管理体系审核（EA）、环境标志（EL）生命周期评价（LCA）、环境绩效评价（EPE）、术语和定义（T&amp;D）等国际环境管理领域的研究与实践的焦点问题，向各国政府及各类组织提供统一、一致的环境管理体系、产品的国际标准和严格、规范的审核认证办法。</p><p>环境管理体系是全面管理体系的组成部分，包括制定、实施、实现、评审、和维护环境方针所需的组织结构、策划、活动、职责、操作惯例、程序、过程和资源。</p><p>ISO14001伴随着本世纪中期爆发于一些发达国家的公害事件，人类开始认识到环境问题的出现及其严重性。环境污染与公害事件的产生使人们从治理污染的过程中逐步认识到，要有效的保护环境，人类社会必须对自身的经济发展行为加强管理。因此世界各国纷纷制定各类法律法规和环境标准,并试图通过诸如许可证等手段强制企业执行这些法律法规和标准来改善环境。</p><p>正是在这种环境管理国际大趋势下，考虑到各国、各地区、各组织采用的环境管理手段工具及相应的标准要求不一致，可能会为一些国家制造新的“保护主义”和技术壁垒提供条件，从而对国际贸易产生影响，国际标准化组织（ISO）认识到自己的责任和机会，并为响应联合国实施可持续发展的号召，于1993年6月成立了ISO/TC207环境管理技术委员会，正式开展环境管理标准的制定工作，期望通过环境管理工具的标准化工作，规范企业和社会团体等组织的自愿环境管理活动，促进组织环境绩效的改进，支持全球的可持续发展和环境保护工作。</p><p>意义</p><p>企业实施ISO14001标准是节约能源，降低消耗，变废为宝，减少环保支出，降低成本的需要。 通过建立和实施环境管理体系，能减少污染物的产生、排放，促进废物回收利用，节约能源，节约原材料，避免了罚款和排污费，从而降低成本。</p><p>许多国家明确规定生产产品的企业应通过ISO14001认证，未通过ISO14001认证已成为企业争取国内更大的市场份额以及进行国际贸易的技术障碍，因此只有实施ISO14001环境管理体系，以此提高企业综合管理水平和改善企业形象，降低环境风险，企业才能更好地占领国内外市场。</p><p>企业走向良性和长期发展的需要 通过ISO14001标准认证，可以有效地促进企业环境与经济的协调持续发展，使企业走向良性和长期发展的道路。是履行社会责任的需要 当前环境污染给人类生存造成了极大威胁，引起世界各国的关注。保护人类赖以生存的环境是全世界全社会的责任，每个企业都有责任为使环境影响最小化而努力。 它可以减少由于污染事故或违反法律、法规所造成的环境风险。增加企业获得优惠信贷和保险政策的机会。</p><p>ISO 14000系列标准归根结底是一套管理性质的标准。它是工业发达国家环境管理经验的结晶，在制定国家标准时又考虑了不同国家的情况，尽量使标准能普通适用。</p><p>·ISO 14001标准对企业的积极影响主要体现在以下几个方面：</p><p>·树立企业形象，提高企业的知名度</p><p>·促使企业自觉遵守环境法律、法规</p><p>·促使企业在其生产、经营、服务及其他活动中考虑其对环境的影响，减少环境负荷</p><p>·使企业获得进入国际市场的“绿色通行证”</p><p>·增强企业员工的环境意识</p><p>·促使企业节约能源，再生利用废弃物，降低经营成本</p><p>·促使企业加强环境管理</p><p>异同</p><p>海报</p><p>海报</p><p>环境管理体系运行模式环境管理体系围绕环境方针的要求展开环境管理、管理的内容包括制定环境方针、实施并实现环境方针所要求的相关内容、对环境方针的实施情况与实现程度进行评审、并予以保持等。环境管理所涉及的管理要素包括组织结构、计划活动、职责、惯例、程序、过程和资源等，这些管理要素与企业生产管理、人事管理、财务管理是类似，没有本质区别，ISO 14001标准将它们系统化、结构化，提出如下的环境管理模式（见下图）。</p><p>这一环境管理体系模式遵循了传统的PDCA管理模式：规划（PLAN）、实施（DO）、检查（CHECK）和改进（ACTION），即规划出管理活动要达到的目的和遵循的原则；在实施阶段实现目标并在实施过程中体现以上工作原则；检查和发现问题，及时采取纠正措施，以保证实施与实现过程不会偏离原有目标与原则，实现过程与结果的改进提高。</p><p>与ISO9000标准的异同</p><p>首先，两套标准都是ISO组织制订的针对管理方面的标准，都是国际贸易中消除贸易壁垒的有效手段。</p><p>其次，两套标准的要素有相同或相似之处。（见下表）</p><p>再次，两套标准最大的区别在于面向的对象不同，ISO9000标准是对顾客承诺，ISO14001标准是对政府、社会和众多相关方（包括股东、贷款方、保险等等）ISO9000标准缺乏有效的外部监督机制，而实施ISO14000标准的同时，就要接受政府、执法当局、社会公众和各相关方的监督。</p><p>最后，在体系中，两套标准部分内容和体系的思路上有着本质的不同，包括环境识别、重要环境评价与控制，适用环境法律、法规的识别、获取、遵循状况评价和跟踪最新法规，环境目标指标方案的制定的实施完成，以期达到预防污染、节能降耗、提高资源能源利用率，最终达到环境行为的持续改进的目的。ISO14000 ISO9000</p><p>宣传</p><p>宣传</p><p>ISO是世界上最大的非政府性国际标准化组织，也是当今世界上规模最大的国际科学技术组织之一。它成立于1947年2月，该国际组织的主要工作之一就是制定各行业的国际标准，协调世界范围的标准化工作。自成立以来，已制定并颁发了许多国际标准，其下设若干技术委员会，其中第176技术委员会在1987年成功地制定和颁布了ISO9000族质量管理体系标准，在世界范围内引起了巨大的反响。</p><p>ISO/TC207是国际标准化组织于1993年6月成立的一个技术委员会，专门负责制定环境管理方面的国际标准，即ISO14000系列标准，其编号为TC207，即ISO/TC207环境管理技术委员会。该技术委员会下设六个分技术委员会（SC）和一个特别工作组(WG1）：</p><p>·SC1环境管理体系标准英国为分委员会秘书长所在国</p><p>·SC2环境审核荷兰为分委员会秘书处所在国</p><p>·SC3环境标志澳大利亚为分委员会秘书处所在国</p><p>·SC4环境行为评价美国为分委员会秘书长所在国</p><p>标准分类</p><p>海报</p><p>海报</p><p>ISO14000系列标准是国际标准化组织ISO/TC207负责起草的一份国际标准。ISO14000是一个系列的环境管理标准，它包括了环境管理体系、环境审核、环境标志、生命周期分析等国际环境管理领域内的许多焦点问题，旨在指导各类组织（企业、公司）取得表现正确的环境行为。ISO给14000系列标准共预留100个标准号。该系列标准共分七个系列。ISO14000系列标准 标准号分配表</p><p>名 称 标准号</p><p>SC1 环境管理体系（EMS） 14001－14009</p><p>SC2 环境审核（EA） 14010-14019</p><p>SC3 环境标志（EL） 14020-14029</p><p>SC4 环境行为评价（EPE） 14030-14039</p><p>SC5生命周期评估（LCA） 14040-14049</p><p>SC6 术语和定义（T&amp;D） 14050-14059</p><p>WG1 产品标准中的环境指标 14060</p><p>备用 14061-14100</p><p>ISO14001 2004标准</p><p>ISO14000做为一个多标准组合系统，按标准性质分三类：</p><p>第一类：基础标准——术语标准。</p><p>第二类：基础标准——环境管理体系、规范、原则、应用指南。</p><p>第三类：支持技术类标准（工具），包括：</p><p>①环境审核；</p><p>②环境标志；</p><p>③环境行为评价；</p><p>④生命周期评估。</p><p>如按标准的功能，可以分为两类：</p><p>第一类：评价组织</p><p>①环境管理体系；</p><p>②环境行为评价；</p><p>③环境审核。</p><p>第二类：评价产品</p><p>①生命周期评估；</p><p>②环境标志；</p><p>③产品标准中的环境指标。</p><p>ISO14001标准</p><p>制定基础</p><p>欧美一些大公司在80年代就已开始自发制定公司的环境政策，委托外部的环境咨询公司来调查他们的环境绩效，并对外公布调查结果（这可以认为环境审核的前身）。以此证明他们优良的环境管理和引以为自豪的环境绩效。他们的做法得到了公众对公司的理解，也赢得广泛认可，公司也相应地获得经济与环境效益。为了推行这种做法，到1990年末，欧洲制定了两个有关计划，为公司提供环境管理的办法，使其不必为证明环境信誉而各自采取单独行动。第一个计划为BS7750，由英国标准所制定第二个计划是欧盟的环境管理系统，称为生态管理和审核法案（Eco-Management and Audit Scheme,EMAS），其大部分内容来源于BS7750。很多公司试用这些标准后，取得了较好的环境效益和经济效益。这两个标准在欧洲得到较好的推广和实施。</p><p>同时，世界上其他国家也开始按照BS7750和EMAS的条款，并参照该国的法规的标准，建立环境管理体系。</p><p>另外一项具有基础性意义的行动则是1987年ISO颁布的世界上第一套管理系列标准――ISO9000“质量管理与质量保证”取得了成功。许多国家和地区对ISO9000系列标准极为重视，积极建立企业质量管理体系并获得第三方认证，以此作为开展国际贸易进入国际市场的优势条件之一。ISO9000的成功经验证明国际标准中设立管理系列标准的可行性和巨大进步意义。因此，ISO在成功制定ISO9000系列的基础上，开始着手制定标准序号为14000的系列环境管理标准。因此可以说欧洲发达国家积极推行的BS7750、EMAS以及ISO9000的成功经验是ISO14000系列的基础。</p><p>具备条件</p><p>1、具有相对独立管理职能的经济技术开发区、高新技术开发区、风景（名胜）旅游区。</p><p>2、本区具有统一的管理机构，例如：管理委员会（简称管委会）。并具有一定的政府行政职能。</p><p>3、本区管委会依据国家环境保护法律、法规、环境环境标准和ISO14001标准建立了环境管理体系。</p><p>4、环境保护目标责任制，国家环境保护模范城市环境综合整治定量考核中的相关目标、指标和“一控双达标”目标有可能的就列入环境管理体系目标、指标中。</p><p>5、环境管理体系运行6个月以上，并通过中国环境管理体系认证机构认可委员会认可的认证机构的认证。</p><p>ISO14001审核员中国为什么实施ISO14000系列标准建立了什么管理机构？职责是什么？　为了统一领导中国的ISO14000认证工作，国务院于1997年4月21日，国办函[1997]27号文件批准同意成立中国环境管理体系认证指导委员会（简称指委会），并于1997年5月27日召开了成立大会。指导委员会的成立标志着中国推行ISO14000系列标准工作又迈出了新的一步。</p><p>指导委员会由国家环境保护局局长担任主任，国家技术监督局副局长担任第一副主任，国家商检局、国家计委、经贸委的有关领导担任副主任。</p><p>委员会由33个部门和单位的代表组成。</p><p>指导委员会下设中国的环境管理体系认证机构的认可的认证注册机构，从体制上和制度上为中国的ISO14000认证工作提供保证，也为认证/注册的国际互认奠定基础，从而使中国环境管理体系认证工作做到“一套标准，一种制度和一种证书”。</p><p>指导委员会办公室的具体工作由国家环保局科技标准司标准管理处承担。</p><p>ISO14001培训资料</p><p>关键原则</p><p>经充分协商，ISO/TC207对制定ISO14000系列标准规定了七条关键的原则：</p><p>1、ISO14000系列标准应具有真实性和非欺骗性</p><p>2、产品和服务和环境影响的评价方法和信息应意义准确，并且是可检验的；</p><p>3、评价、试验方法不能采用非标准方法，而必须采用ISO标准、地区标准、国家标准或其他技术上能保证再现性的标准试验方法</p><p>4、应具有公开性和透明度，但不应损害机密的商业信息；</p><p>5、非歧视性；</p><p>6、能进行特殊的有效的信息传递和教育培训</p><p>7、应不产生贸易壁垒，保证国内、国外的一致性。</p><p>贸易影响</p><p>ISO/TC207在制定ISO14000时的指导思想之一是：“不增加并努力消除贸易壁垒，无论对环境好还是环境差的地区”。</p><p>客观上ISO14000系列标准统一了环境管理体系的基本要求，使那些以此制造贸易壁垒的国家有所收敛；标准要求各国公开其有关体系、产品标准和认证方法，为其贸易伙伴提供便利条件，有助于消除贸易壁垒。</p><p>另一方面，ISO14000系列标准的实施又是另一种壁垒，它对那些信息不通，行动缓慢的国家和组织将造成实际上的贸易障碍。各发达国家对ISO14000系列标准持臭味相投态度，在标准尚为草案时就开始了试点认证工作，并做好了标准正式发布后的国内转换工作；发达国家也以环境为借口向发展中国家提出了要求。因而，发展中国家要摆脱其受控制的地位就必须迅速着手开展ISO14000实施工作。从这一意义上说，ISO14000的认证是通向未来国际贸易市场的通行证。</p><p>事实上，环境问题在国际贸易中的地位日益明显，环境已与安全、卫生等方面的因素联结起来，形成了严重的技术贸易壁垒。这种壁垒是各国为保护其国内人民和国内市场而刻意制造的，是难以消除的。</p><p>ISO14001程序文件</p><p>国外情况</p><p>据报导，ISO14001、ISO14010－14014可能被列入现有的美国环境法规条文中，由此美国一些大的跨国公司已迅速制定ISO14000认证计划；澳大利亚、瑞士和土耳其已经采用ISO14000标准，日本通产省也已要求日本本土的公司于1996年底前做好实施ISO14000系列标准的准备工作，据报道日本已有200个企业通过认证。欧盟可能会制定一个中间性文件，以解释ISO14000系列标准与欧盟的EMAS间的联系，它还可能将ISO14000系列标准认为欧盟标准。加拿大每一个城市都成立了推行ISO14000办公室，加拿大已有56家大公司通过了ISO14000认证。在亚洲，ISO14000系列标准是解决亚洲环境执法问题的良药。许多国家在制定有效的环保法律方面或是在执行法律方面存在令人头痛的问题，ISO14000系列标准要求组织内部建立环境管理体系，而且要求组织必须符合所在国的环境法律、法规，这就为组织提供了一种符合方法。菲律宾委托欧盟的一些咨询公司开展培训，仅1995年――1996年已举办了二十余期ISO14000系列标准的审核员培训。英国环境审核师注册协会已受理了大批经过培训的技术人员的申请，已有数百人获得审核师与助理审核师的资格证书，这部分人员将活跃于世界各国，积极从事ISO14000系列的工作。环境管理体系认证数量：现状与未来预测</p><p>国家/地区 EMS认证（1996年底） 预计1999年底达到</p><p>日本 200 3800</p><p>韩国65（1997年2月止） 1000</p><p>中国台湾34 1400</p><p>泰国7（1997年2月止） 140</p><p>香港2 740</p><p>新加坡6 1200</p><p>中国 4 500</p><p>马来西亚5 700</p><p>印度尼西亚 2 125</p><p>菲律宾 1 100</p><p>印度 7 1000</p><p>澳大利亚 约40</p><p>（澳、新两国共） 8800</p><p>新西兰1700</p><p>英国 261 5200</p><p>ISO14001 1996标准&quot;</p><p>实施动态</p><p>一、ISO14001标准实施的国际动态</p><p>ISO14001系列标准自制订之初便受到世界各国和地区的普遍关注。ISO14001标准是ISO14000系列标准的龙头标准，也是唯一可供认使用的标准，自1996年9月1日ISO14001标准正式颁布。至今，全球已有22000多家组织获得了ISO14001标准认证。</p><p>二、中国实施ISO14001标准动态随着ISO14001标准在中国的试点和全面推广，截至2001年5月，全国共约有700多家各类企业获得认证注册。</p><p>苏州新区作为国内第一个区域性建立ISO14001环境管理体系的组织，已于1999年8月通过认证。到目前为止，国内通过认证的区域还有大连经济技术开发区、上海金桥开发区、无锡新区、天津经济技术开发区、秦皇岛经济技术开发区等。台湾国立中山大学是全世界首座通过ISO14001认证的大学。</p><p>ISO14001咨询</p><p>ISO14001环境管理体系标准在区域内实施的目的有哪些?　ISO14001标准实施的目的是帮助组织实现环境目标与经济目标的统一，支持环境保护和污染预防，这是国际标准化组织起草和实施这一系列标准的根本出发点，也应成为区域实施标准、建立体系的最终目标。标准不仅是为了强调区域应该达到什么要求，更主要是为区域建立一个不断持续改进的管理体系。标准的实施同时有助于消除国际贸易中各国就环境问题而设置的非关税壁垒，这种贸易障碍已在近几年成为世界关注的焦点问题，并且正在成为最大的非关税壁垒，阻碍着发展中国家向发达国家产品的输出。这一国际标准的出台，将改变这一领域的各自为政的局面，形成以各国法律、法规为基础的环境管理标准，为发展中国家在体系的建立与认证方面提供了较大空间，同时也为发展中国家的企业环境行为提出了较高的目标，创造了跟上国际环境管理发展形势的契机。</p><p>ISO14001培训</p><p>15、ISO14001的主要内容是什么?</p><p>ISO14001中文名称是环境管理体系——规范及使用指南，于1996年9月正式颁布第一版，现行为2004年版。</p><p>ISO14001是组织规划、实施、检查、评审环境管理运作系统的规范性标准（见图），该系统包含五大部分，17个要素。五大部分内容概括如下：</p><p>五大部分是指：</p><p>①环境方针</p><p>②规划</p><p>③实施与运行</p><p>④检查与纠正措施</p><p>⑤管理评审</p><p>这五个基本部分包含了环境管理体系的建立过程和建立后有计划地评审及持续改进的循环，以保证组织内部环境管理体系的不断完善和提高。</p><p>17个要素是指：</p><p>1、环境方针</p><p>2、环境因素</p><p>3、法律与其他要求</p><p>4、目标和指标</p><p>5、环境管理方案</p><p>6、机构和职责</p><p>7、培训、意识与能力</p><p>8、信息交流</p><p>9、环境管理体系文件</p><p>10、文件管理</p><p>11、运行控制</p><p>12、应急准备和响应</p><p>13、监测</p><p>14、不符合、纠正与预防措施</p><p>15、记录</p><p>16、环境管理体系审核</p><p>17、管理评审</p><p>给出环境管理体系的一级要素和二级要素图表。要素名称 一级要素 二级要素</p><p>（一）环境方针 1、环境方针</p><p>（二）规划（策划） 2、环境因素3、法律和其他要求4、目标和指标5、环境管理方案</p><p>（三）实施和运行 6、机构和职责7、培训、意识和能力8、信息交流9、环境管 理体系文件10、文件控制11、运行控制12、应急准备和响应</p><p>（四）检查和纠正措施 13、监测和测量14、不符合、纠正与预防措施15、记录16、环境管理体系审核</p><p>（五）管理评审 17、管理评审</p><p>环境管理</p><p>根据ISO14001的3．5定义：环境管理体系是一个组织内全面管理体系的组成部分，它包括为制定、实施、实现、评审和保持环境方针所需的组织机构、规划活动、机构职责、惯例、程序、过程和资源。还包括组织的环境方针、目标和指标等管理方面的内容。</p><p>可以这样描述环境管理体系：这是一个组织有计划，而且协调动作的管理活动，其中有规范的动作程序，文件化的控制机制。它通过有明确职责、义务的组织结构来贯彻落实，目的在于防止对环境的不利影响。</p><p>环境管理体系是一项内部管理工具，旨在帮助组织实现自身设定的环境表现水平，并不断地改进环境行为，不断达到更新更佳的高度。</p><p>海报</p><p>海报</p><p>ISO14001VCD</p><p>17、一个组织实施环境管理体系会达到什么效果?</p><p>当组织建立了环境管理体系之后，通过管理活动程序、建立规范化文件和记录等措施可以协调不同的职能部门之间的关系，并可以达到下列目的：</p><p>①建立一个良好的环境方针和环境管理基础；</p><p>②有利于找出并控制重大的环境因素和影响；</p><p>③有利于识别有关的环境法规要求与现行状况的差距；</p><p>④减少由于污染事故或违反法律法规所造成的环境影响；</p><p>⑤建立组织内污染防止优先序列，并为实现污染预防目标而努力；</p><p>⑥可以提高监测环境的能力和评价该体系的效率，包括促进体系的改进和调整，以适应新的和不断变化的情况的要求；</p><p>⑦由于改善环境从而带来许多重要的商业、环境机会。</p><p>总之，环境管理体系将有助于组织系统化地处理环境问题，并将环境保护和企业经营结合起来，使之成为企业日常运行和经营策略的一个部分。</p><p>九大步骤</p><p>ISO14001与ISO9001从体系上具有一定相似之处，环境审核的方法与质量认证的方法也较为相似，实施并通过了ISO9000认证的组织在建立其环境管理体系的过程中，从形式上容易接受ISO14001标准的要求，另一方面，我国于80年代推行了环境标志与清洁生产审计，这对ISO14001的推广实施也有一定的促进作用。那么如何建立环境管理体系，</p><p>1.最高管理者决定</p><p>环境管理体系的建立和实施需要组织人、财、物等资源，因此，必须首先得到最高管理者（层）的明确承诺和支持，同时，由最高管理者任命环境管理者代表，授权其负责建立和维护体系，保证此项工作的领导作用。</p><p>2.建立完整的组织机构</p><p>组建一个推进环境管理体系建立和维护的领导班和工作组企业应在原有组织机构的基础，组建一个由各有关职能和生产部门负责人组成的领导班对此项工作进行协调和管理，此外由某个部门（如负责环保工作的部门）为主体，其它有关部门的有关人员参加，组成一个工作组，承担具体工作。明确各个部门的职责，形成一个完整的组织机构，保证该工作的顺利开展。</p><p>3.人员培训</p><p>对企业有关人员进行培训，包括环境意识、标准、内审员和与建立体系有关的，如初始环境评审和文件编写方法和要求等多方面的培训，使企业人员了解和有能力从事环境管理体系的建立实施与维护工作。</p><p>4.初始环境评审</p><p>是对组织环境现状的初始调查，包括正确识别企业活动、产品、服务中产生的环境因素，并判别出具有和可能具有重大影响的重要环境因素；识别组织应遵守的法律和其它要求；评审组织的现行管理体系和制度，如环境管理、质量管理、行政管理等，以及如何与ISO14001标准相结合。</p><p>5.体系策划</p><p>在初始环境评审的基础上，对环境管理体系的建立进行策划，以确保环境管理体系的建立有明确要求。</p><p>6.文件编写</p><p>同ISO9000一样，ISO14001环境管理体系要求文件化，可分为手册、程序文件、作业指导书等层次。企业应根据ISO14001标准的要求，结合自身的特点和基础编制出一套适合的体系文件，满足体系有效运行的要求。</p><p>7.体系试运行</p><p>体系文件完稿并正式颁布，该体系按文件的要求开始试运行。其目的是通过体系实际运行，发现文件和实际实施中存在的问题，并加以整改，使体系逐步达到适用性、有效性和充分性。</p><p>8.企业内部审核</p><p>根据ISO14001标准的要求，企业应对体系的运行情况进行审核。由经过培训的内审员通过企业的活动、服务和产品对标准各要素的执行情况进行审核、发现问题，及时纠正。</p><p>9.管理评审</p><p>根据标准的要求，在内审的基础上，由最高管理者组织有关人员对环境管理体系从宏观上进行评审，以把握体系的持续适用性、有效性和充分性。</p><p>影响</p><p>1996年，ISO首批颁布了与环境管理体系及其审核有关的5个标准，引起了各国政府和产业界的高度重视。到1997年底，标准颁布仅一年时间，全世界就有1491家企业通过ISO14001标准的认证；到1998年底，这一数字达到5017家；到1999年底，通过认证的企业已超过一万家。中国政府对环境管理工作十分重视，已经颁布的五个标准，均已等同转化为国家标准，它们分别是：GB/T24001-1996 idt ISO14001 环境管理体系规范及使用指南 GB/T24004-1996 idt ISO14004 环境管理体系原则、体系和支持技术指南 GB/T24010-1996 idt ISO14010 环境审核体系通用原则 GB/T24011-1996 idt ISO14011 环境审核体系审核程序环境管理体系审核 GB/T24012-1996 idt ISO14012 环境审核体系环境审核员资格要求 其中，ISO14001是这一系列标准的核心，它不仅是对建立环境管理体系建立和对环境管理体系进行审核或评审的依据，也是制定ISO14000系列其他标准的依据。ISO14000系列标准的重要特点是，首先，该标准不是强制的，而是自愿采用的。ISO14000 系列标准借鉴了ISO9000 标准的成功经验，使标准具有广泛适用性和灵活性，它可适用于任何类型与规模，处于不同地理、文化和社会条件下的组织。ISO14000系列标准同ISO9000标准有很好的兼容性，使企业在采用ISO14000系列标准时，能与原有的管理体系有效协调。“预防为主”是贯穿ISO14000系列标准的主导思想，它要求企业必须承诺污染预防，并在体系中加以落实。持续改进是ISO14000系列标准的灵魂，组织通过实施标准，建立起不断改进的机制，在持续改进中，实现自己对社会的承诺，最终达到改善环境绩效的目的。推行ISO14000系列标准，有利于提高全民族的环境意识，树立可持续发展的思想；有利于提高人民的遵法、守法意识和环境法规的贯彻实施；有利于调动企业防治环境污染的主动性，促进企业不断改进环境管理工作；有利于推动资源和能源的节约，实现其合理利用；有利于实现各国间环境认证的双边和多边认证，消除技术性贸易壁垒。</p><p>获取证书</p><p>第一阶段，建立并实施ISO14001环境管理体系阶段。</p><p>ISO14001</p><p>ISO14001</p><p>这一阶段，组织应建立并实施ISO14001环境管理体系，从形式上符合ISO14001标准的要求。</p><p>第二，要做好初始环境评审。这项工作是对组织的环境管理情况进行评价，总结经验，找出存在的主要环境问题并分析其风险，以确定控制方法和将来的改进方向。一般来说，要做初始环境评审，先应组建由从事环保、生产、技术、设备等各方面的人员组成工作组。工作组要完成法律法规的识别和评价，环境因素的识别和评价，现有环境管理制度和ISO14001标准差距的评价，并形成初始环境评审报告。</p><p>第三，要完成环境管理体系策划工作。所谓的环境管理体系策划，就是根据初始环境评审的结果和组织的经济技术实力，制定环境方针；确定环境管理体系构架；确定组织机构与职责；制定目标、指标、环境管理方案；确定哪些环境活动需要制定运行控制程序。</p><p>第四，编制体系文件。ISO14001环境管理体系是一个文件化的环境管理体系，需编制环境管理手册、程序文件、作业指导书等。</p><p>第五，运行环境管理体系。环境管理体系文件编制完成，正式颁布，就标志着环境管理体系已经建立并投入运行。</p><p>第二阶段，认证取证阶段。</p><p>经过内审和管理评审，组织如果确认其环境管理体系基本符合ISO14001标准要求，对组织适用性较好，且运行充分、有效，可向已获得中国环境管理体系认证机构认可委员会认可有认证资格的认证机构（查询可登录环认委网站：提出认证申请并签定认证合同，进入ISO14001环境管理体系认证审核阶段。</p><p>认证模式</p><p>ISO14001标准认证模式</p><p>ISO14001标准由环境方针、策划、实施与运行、检查和纠正、管理评审等5个部分的17个要素构成，各要素之间有机结合，紧密联系，形成PDCA循环的管理体系，并确保企业的环境行为持续改善。·ISO14000标准的特点</p><p>注意体系的完整性，是一套科学的环境管理软件</p><p>强调对法律法规的符合性，但对环境行为不作具体规定</p><p>强调污染预防，持续改进</p><p>要求对组织的活动进行全过程控制</p><p>广泛适用于各类组织</p><p>与ISO9000标准有很强的兼容性</p>	1	3	1	120	100	1	0	0	0	\N	\N	100	60
09d63050-ea52-11e8-bf1d-08d40c3d2417	2018-11-17 18:17:50.805	2018-11-17 20:05:30.433	t	t	a7b02b20-dfe7-11e8-b67d-08d40c3d2417	6b741f70-dfe4-11e8-8e1e-08d40c3d2417	IATF 16949	IATF 16949	IATF 16949	<p>IATF 16949</p>	1	3	1	120	100	1	0	0	0	\N	\N	100	60
57c95860-dfe8-11e8-b67d-08d40c3d2417	2018-11-04 12:16:03.302	2018-11-18 21:20:34.642	t	t	a7b02b20-dfe7-11e8-b67d-08d40c3d2417	6b741f70-dfe4-11e8-8e1e-08d40c3d2417	ISO9001-2005	ISO9001质量管理体系	ISO9001是ISO9000族标准所包括的一组质量管理体系核心标准之一。ISO9000族标准是国际标准化组织（ISO）在1994年提出的概念，是指“由ISO/Tc176（国际标准化组织质量管理和质量保证技术委员会）制定的国际标准。	<p>ISO9001是ISO9000族标准所包括的一组质量管理体系核心标准之一。ISO9000族标准是国际标准化组织（ISO）在1994年提出的概念，是指“由ISO/Tc176（国际标准化组织质量管理和质量保证技术委员会）制定的国际标准。</p><p>目录</p><p>1 概念</p><p>2 发展</p><p>3 原则</p><p>4 作用</p><p>概念</p><p>ISO9001用于证实组织具有提供满足顾客要求和适用法规要求的产品的能力，目的在于增进顾客满意度。随着商品经济的不断扩大和日益国际化，为提高产品的信誉、减少重复检验、削弱和消除贸易技术壁垒、维护生产者、经销者、用户和消费者各方权益，这个第三认证方不受产销双方经济利益支配，公证、科学，是各国对产品和企业进行质量评价和监督的通行证；作为顾客对供方质量体系审核的依据；企业有满足其订购产品技术要求的能力。</p><p>凡是通过认证的企业，在各项管理系统整合上已达到了国际标准，表明企业能持续稳定地向顾客提供预期和满意的合格产品。站在消费者的角度，公司以顾客为中心，能满足顾客需求，达到顾客满意，不诱导消费者.</p><p>发展</p><p>ISO9000族标准是国际标准化组织(ISO)于1987年颁布的在全世界范围内通用的关于质量管理和质量保证方面的系列标准。1994年，国际标准化组织对其进行了全面的修改，并重新颁布实施。2000年，ISO对ISO9000系列标准进行了重大改版。</p><p>ISO9000标准的由来</p><p>1.质量管理的理论与实践发展的产物</p><p>随着质量管理的理论与实践的发展，许多国家和企业为了保证产品质量，选择和控制供应商，纷纷制定国家或公司标准，对公司内部和供方的质量活动制定质量体系要求，产生了质量保证标准。</p><p>2.国际贸易的迅速发展的产物</p><p>随着国际贸易的迅速发展，为了适应产品和资本流动的国际化趋势，寻求消除国际贸易中技术壁垒的措施，ISO/TC176组织各国专家在总结各国质量管理经验的基础上，制定了ISO9000系列国际标准。</p><p>ISO9000族标准2000版的修订过程</p><p>1998年02月WD—工作组草案</p><p>1998年09月CD1—委员会草案（1版）</p><p>1999年02月CD2—委员会草案（2版）</p><p>1999年11月DIS—标准草案</p><p>2000年09月FDIS—最终标准草案</p><p>2000年12月ISO—国际标准</p><p>为什么要修订ISO9000族标准?</p><p>国际标准一般都应在5年左右修订.ISO9000标准从1987年首次发布到1994年第一次修订相隔7年,1994版至今又经过了5年.现行1994版ISO9001标准的20个要素结构模式将相互关联的过程分离,没有体现出现代管理的“过程”概念。</p><p>1994版ISO9001标准内容过分趋向于硬件制造业。其他行业应用不便。</p><p>由于1994版ISO9000族基本标准（ISO9000-1、ISO9001、ISO9004）存在缺陷，造成ISO9000族中指南性标准数量迅速膨胀.</p><p>1994版ISO9001标准的重点是保证提供合格产品的能力，未明确规定满足顾客的需要和期望。</p><p>ISO9001:1994仅限于维持规定的质量保证能力，没有强调通过持续改进，不断提高企业经营业绩。</p><p>现行的94版与其它的管理体系（ISO14000,OHSAS18000等）不容易整合。</p><p>ISO9000:2000版标准结构</p><p>——ISO9000标准描述了质量管理体系的概念并规定了其专用术语</p><p>——ISO9001标准规定了质量管理体系要求，在组织需要证实其提供满足顾客和适用法规要求的产品的能力时使用</p><p>——ISO9004标准为质量管理体系，包括促使组织顾客和其他利益方满意的持续改进过程提供指南</p><p>——ISO19011为管理和实施环境审核和质量审核提供指南</p><p>上述标准构成了一组密切相关的质量管理体系标准，有利于国内和国际贸易中的相互理解。</p><p>ISO9000系列标准的用途?</p><p>一个机构可依据ISO9000标准建立、实施和改进其质量体系，并可作为机构间（第二方认证）或外部认证机构（第三方认证）的认证依据。该系列标准目前已被90多个国家等同或等效采用，是全世界最通用的国际标准，在全球产生了广泛深刻的影响。</p><p>实施ISO9000的好处?</p><p>☆ISO9000为企业提供了一种具有科学性的质量管理和质量保证方法和手段，可用以提高内部管理水平。</p><p>☆使企业内部各类人员的职责明确，避免推诿扯皮，减少领导的麻烦。</p><p>☆文件化的管理体系使全部质量工作有可知性、可见性和可查性，通过培训使员工更理解质量的重要性及对其工作的要求。</p><p>☆可以使产品质量得到根本的保证。</p><p>☆可以降低企业的各种管理成本和损失成本，提高效益。</p><p>☆为客户和潜在的客户提供信心。</p><p>☆提高企业的形象，增加了竞争的实力。</p><p>☆满足市场准入的要求。</p><p>ISO9000的含义</p><p>ISO---国际标准化组织的缩写。该组织负责制订和发布非电工类的国际标准。该组织发布的标准均冠以“ISO”的字头。</p><p>9000---标准的代号，ISO将9000下的编号分配给与质量管理和质量保证的有关标准。事实上，与质量管理和质量保证有关的标准的范围已突破了9000系列的代号范围，如ISO1000系列标准和ISO8402，他们共同构成了创造奇迹的ISO9000族国际标准。</p><p><br/></p><p>原则</p><p>原则一：以顾客为关注焦点</p><p>原则二：领导作用</p><p>原则三：全员参与</p><p>原则四：过程方法</p><p>原则五：持续改进</p><p>原则六：循证决策</p><p>原则七：关系管理</p><p><br/></p><p>作用</p><p>1、强化品质管理，提高企业效益。</p><p>2、增强客户信心，扩大市场份额，在产品品质竞争中永远立于不败之地。</p><p>3、提高全员质量意识，改善企业文化。</p><p>4、第三方认证，提供最广泛的认可，节省了第二方审核的精力和费用。</p><p>5、有效地避免产品责任。</p><p>6、获得了国际贸易&quot;通行证&quot;，消除了国际贸易壁垒。</p><p>7、法律责任减免：如更容易的许可，更少的检查以及简化的报告要求等。</p><p>8、公众形象及社会关系，为消费者选择提供信心。</p>	1	2	1	90	70	1	0	0	0	\N	\N	90	80
\.


--
-- Data for Name: course_attachment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_attachment (id, create_time, update_time, flag, status, course_id, video_id, file_name, file_path, file_type, file_size, upload_time) FROM stdin;
ba10c690-f058-11e8-957f-08d40c3d2417	2018-11-25 10:20:50.425	2018-11-25 10:20:50.425	t	t	57c95860-dfe8-11e8-b67d-08d40c3d2417	b9dc2200-f058-11e8-957f-08d40c3d2417	7.tar.gz	/uploads/file/2018/11/25/1020387660039283.gz	gz	498613	2018-11-25 10:20:38.808
\.


--
-- Data for Name: course_certificate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_certificate (id, create_time, update_time, flag, status, course_id, certificate_id) FROM stdin;
\.


--
-- Data for Name: course_examination; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_examination (id, create_time, update_time, flag, status, course_id, video_id, title, category, score) FROM stdin;
\.


--
-- Data for Name: course_examination_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_examination_analysis (id, create_time, update_time, flag, status, course_id, video_id, examination_id, content) FROM stdin;
\.


--
-- Data for Name: course_examination_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_examination_item (id, create_time, update_time, flag, status, course_id, video_id, examination_id, title, is_answer) FROM stdin;
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
a7b02b20-dfe7-11e8-b67d-08d40c3d2417	2018-11-04 12:11:07.858	2018-11-04 12:26:44.091	t	t	gltx	管理体系	\N	\N
\.


--
-- Data for Name: course_video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.course_video (id, create_time, update_time, flag, status, course_id, name, image, file_name, file_path, file_type, file_size, upload_time, introduction, description) FROM stdin;
b9dc2200-f058-11e8-957f-08d40c3d2417	2018-11-25 10:20:50.08	2018-11-25 10:20:50.08	t	t	57c95860-dfe8-11e8-b67d-08d40c3d2417	第一章	/uploads/image/2018/11/25/1018445442864263.png	QQ视频20160820164749.mp4	/uploads/media/2018/11/25/1019198779231807.mp4	mp4	6733339	2018-11-25 10:19:19.311	地	<p>dfadf</p>
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

COPY public.employee_course_exercise (id, create_time, update_time, flag, status, employee_id, course_id, video_id, exercise_id, title, category, score, right_state) FROM stdin;
\.


--
-- Data for Name: employee_course_exercise_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_course_exercise_analysis (id, create_time, update_time, flag, status, exercise_id, content) FROM stdin;
\.


--
-- Data for Name: employee_course_exercise_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_course_exercise_item (id, create_time, update_time, flag, status, exercise_id, title, is_answer, check_state) FROM stdin;
\.


--
-- Data for Name: employee_course_study; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_course_study (id, create_time, update_time, flag, status, employee_id, course_id, video_id, study_time) FROM stdin;
ce0b8590-f058-11e8-957f-08d40c3d2417	2018-11-25 10:21:23.945	2018-11-25 10:21:23.945	t	t	2884ffc0-9a31-11e8-be60-4cedfb4009ed	57c95860-dfe8-11e8-b67d-08d40c3d2417	b9dc2200-f058-11e8-957f-08d40c3d2417	2018-11-25 10:21:23.944
b0a85020-f231-11e8-af1d-08d40c3d2417	2018-11-27 18:46:26.594	2018-11-27 18:46:26.594	t	t	2884ffc0-9a31-11e8-be60-4cedfb4009ed	57c95860-dfe8-11e8-b67d-08d40c3d2417	b9dc2200-f058-11e8-957f-08d40c3d2417	2018-11-27 18:46:26.594
\.


--
-- Data for Name: employee_examination_paper; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_examination_paper (id, create_time, update_time, flag, status, paper_id, paper_title, employee_id, employee_name, course_id, course_name, test_type, test_state, test_amount, duration, question_amount, question_type, total_score, pass_score, test_score, pass_state, single_amount, multi_amount, judge_amount, check_amount, fill_amount, join_state, start_time, end_time, submit_time) FROM stdin;
\.


--
-- Data for Name: employee_examination_question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_examination_question (id, create_time, update_time, flag, status, paper_id, question_id, title, category, score, answer_state, right_state) FROM stdin;
\.


--
-- Data for Name: employee_examination_question_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_examination_question_analysis (id, create_time, update_time, flag, status, question_id, content) FROM stdin;
\.


--
-- Data for Name: employee_examination_question_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee_examination_question_item (id, create_time, update_time, flag, status, question_id, title, is_answer, check_state) FROM stdin;
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
-- Data for Name: examination_config; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_config (id, create_time, update_time, flag, status, duration, test_type, paper_type, test_amount, question_type, question_amount, total_score, pass_score, single_type, single_amount, multi_type, multi_amount, judge_type, judge_amount, check_type, check_amount, fill_type, fill_amount) FROM stdin;
79358660-ea59-11e8-8c84-08d40c3d2417	2018-11-17 19:11:04.134	2018-11-17 19:22:36.747	t	t	100	1	1	1	1	100	100	60	1	\N	1	\N	1	\N	\N	\N	\N	\N
\.


--
-- Data for Name: examination_paper; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_paper (id, create_time, update_time, flag, status, course_id, test_type, test_state, test_amount, duration, title, question_amount, question_type, total_score, pass_score, single_amount, multi_amount, judge_amount, check_amount, fill_amount) FROM stdin;
\.


--
-- Data for Name: examination_question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_question (id, create_time, update_time, flag, status, paper_id, title, category, score) FROM stdin;
\.


--
-- Data for Name: examination_question_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_question_analysis (id, create_time, update_time, flag, status, question_id, content) FROM stdin;
\.


--
-- Data for Name: examination_question_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examination_question_item (id, create_time, update_time, flag, status, question_id, title, is_answer) FROM stdin;
\.


--
-- Data for Name: store_paper; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.store_paper (id, create_time, update_time, flag, status, show_state, course_id, title, duration, question_amount, total_score, pass_score, test_amount, editor_id, editor_name, edit_state, edit_time, auditor_id, auditor_name, audit_state, audit_time, auditor_mind) FROM stdin;
08e857a0-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:08:34.586	2018-11-25 20:32:58.483	t	t	t	c60c5b40-dfea-11e8-bed3-08d40c3d2417	GB/T 19001—2015标准考试题（A）	90	70	90	80	1	2884ffc0-9a31-11e8-be60-4cedfb4009ed	管理员	2	2018-11-18 01:25:43.885	2884ffc0-9a31-11e8-be60-4cedfb4009ed	管理员	2	2018-11-25 00:00:00	通过
506cd110-eae1-11e8-a812-08d40c3d2417	2018-11-18 11:23:27.265	2018-11-25 20:36:52.059	t	t	t	57c95860-dfe8-11e8-b67d-08d40c3d2417	GB/T 19001—2015标准考试题（B）	90	70	90	80	1	2884ffc0-9a31-11e8-be60-4cedfb4009ed	管理员	2	2018-11-18 11:23:42.753	2884ffc0-9a31-11e8-be60-4cedfb4009ed	管理员	2	2018-11-25 00:00:00	同意出此卷
45ab5910-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:32:00.161	2018-11-25 20:41:07.91	t	t	t	57c95860-dfe8-11e8-b67d-08d40c3d2417	GB/T 19001—2015标准考试题（C）	90	70	90	80	1	2884ffc0-9a31-11e8-be60-4cedfb4009ed	管理员	1	2018-11-18 13:32:00.161	2884ffc0-9a31-11e8-be60-4cedfb4009ed	管理员	2	2018-11-25 00:00:00	同意
\.


--
-- Data for Name: store_question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.store_question (id, create_time, update_time, flag, status, paper_id, title, category, score) FROM stdin;
6e350360-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:47:12.022	2018-11-18 00:47:12.022	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO9001：2015标准，关于生产和服务提供，以下属于新增加的要求是：（ ）	1	1
8f395070-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:07.415	2018-11-18 00:48:07.415	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	2015版新标准中提到的质量管理原则不包括（ ）	1	1
94500e50-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:12:28.469	2018-11-18 00:12:28.469	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	风险是一种不确定性的影响，可能是积极影响也可能是消极影响。（ ）	4	1
ec18be20-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:14:55.746	2018-11-18 00:14:55.746	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织可以在知情决策后保留风险。（ ）	4	1
0385c080-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:15:35.048	2018-11-18 00:15:35.048	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	最高管理者对质量管理体系的有效性负有责任。（ ）	4	1
1c81ee60-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:16:16.966	2018-11-18 00:16:16.966	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO9001：2015标准要求，关于能力是指在组织控制下的人员都应具备必要的能力。（ ）	4	1
364f7600-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:00.256	2018-11-18 00:17:00.256	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织应明确质量管理体系的边界和适用性，以确定其范围。（ ）	4	1
465ef110-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:27.201	2018-11-18 00:17:27.201	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	设计和开发的评审、验证和确认具有不同的目的，他们只可以按适合组织的方式单独进行。（ ）	4	1
5ef4e310-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:08.449	2018-11-18 00:18:08.449	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	新版标准中对外部提供过程、产品和服务的控制不包括外包过程。（ ）	4	1
6f019f00-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:35.376	2018-11-18 00:18:35.376	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	新版标准未有区分文件和记录的要求，统一明确为文件化信息。（ ）	4	1
82072890-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:07.289	2018-11-18 00:19:07.289	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织的质量管理体系文件化信息只包括 本标准要求的。（ ）	4	1
98709da0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:44.89	2018-11-18 00:19:44.89	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	员工是一种特殊的资源，因为他们不仅不会被损耗掉，而且具有提升胜任能力的潜力。（ ）	4	1
b1c46160-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:20:27.382	2018-11-18 00:20:27.382	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	“知识”也是一种资源，也是产品实现的支持过程。（ ）	4	1
c630f500-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:01.648	2018-11-18 00:21:01.648	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO9001：2015标准，对于交付后才发现的不合格输出，组织应立即通知顾客。（ ）	4	1
d7a2e640-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:30.916	2018-11-18 00:21:30.916	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	除非得到顾客的批准，否则在策划的安排已圆满完成之前，不应向顾客放行产品和服务。（ ）	4	1
02017500-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:22:42	2018-11-18 00:22:42	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	顾客现场不属于顾客财产。（ ）	4	1
15b82620-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:15.074	2018-11-18 00:23:15.074	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	本标准所规定的质量管理体系要求是对产品和服务要求的补充。（ ）	4	1
277fd880-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:44.904	2018-11-18 00:23:44.904	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	在确定提供给顾客的产品和服务的要求时，组织不必满足其组织声称的要求。（ ）	4	1
39a5d780-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:24:15.352	2018-11-18 00:24:15.352	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	2015版标准不允许设立管理者代表。（ ）	4	1
589f8780-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:07.32	2018-11-18 00:25:07.32	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	顾客仅指组织外部的接受产品的组织或个人。（ ）	4	1
66eda380-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:31.32	2018-11-18 00:25:31.32	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	纠正措施应与已发生不符合的影响相适应 。（ ）	4	1
9557f680-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:26:49.192	2018-11-18 00:26:49.192	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	2015版标准不再要求针对潜在不符合原因采取预防措施。（ ）	4	1
21923f70-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:30:44.455	2018-11-18 00:30:44.455	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO9001:2015标准，关于“基于风险的思维”，以下说法正确的是（ ）	1	1
4610e630-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:31:45.683	2018-11-18 00:31:45.683	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	不属于风险和机遇方面所做的策划是（ ）。	1	1
61ea9180-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:32:32.408	2018-11-18 00:32:32.408	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	以下描述中，关于质量管理体系策划未包括（ ）。	1	1
7a9c48e0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:33:13.838	2018-11-18 00:33:13.838	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO 9001:2015标准，关于“领导作用”，以下说法正确的是（ ）。	1	1
9ebbdfb0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:14.443	2018-11-18 00:34:14.443	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	ISO 9001:2015标准7.3条款特指人员意识，要求组织应确保其控制范围内相关工作人员知晓（ ）。	1	1
b6fe8190-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:55.145	2018-11-18 00:34:55.145	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	ISO 9001:2015标准要求，设计和开发输入应完整、清楚，是为了（ ）。	1	1
e006cf20-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:36:03.986	2018-11-18 00:36:03.986	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	以下不属于“设计和开发输入”应考虑的内容的是（ ）。	1	1
0e717040-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:37:21.86	2018-11-18 00:37:21.86	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	以下哪种外部供方提供的过程、产品和服务不需要按8.4的要求控制：（ ）	1	1
2be14bf0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:38:11.247	2018-11-18 00:38:11.247	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织应对所确定的策划和运行质量管理体系所需的来自外部的形成文件的信息进行适当的（ ），并予以保护，防止意外更改。	1	1
5d1ee330-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:39:33.859	2018-11-18 00:39:33.859	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织的质量管理体系文件化信息应包括：（ ）	1	1
7786fd20-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:40:18.162	2018-11-18 00:40:18.162	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	关于组织的利益相关方对组织的质量管理体系的需求和期望，以下说法正确的是（ ）	1	1
92409270-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:02.999	2018-11-18 00:41:02.999	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	（ ）属于ISO 9001:2015标准要求组织确定、提供维护信息和通讯技术。	1	1
b0547650-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:53.461	2018-11-18 00:41:53.461	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	ISO 9001:2015标准7.14“过程运行环境”可以包括（ ）	1	1
c829d770-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:42:33.447	2018-11-18 00:42:33.447	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织在确定与其目标和战略方向相关并影响其实现质量管理体系预期结果的各种外部和内部因素。可以不考虑下列哪个因素	1	1
ec70f370-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:43:34.311	2018-11-18 00:43:34.311	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织的知识是指组织从其经验中获得的特定的知识，是实现组织目标所使用的共享信息。其中内部来源的知识可以是（ ）。	1	1
090192b0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:44:22.235	2018-11-18 00:44:22.235	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO 9001:2015标准8.7条款以下正确表述的是，不合格输出控制的目的是（ ）。	1	1
27f0e270-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:14.135	2018-11-18 00:45:14.135	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO9001：2015标准，以下正确的是（ ）	1	1
40bbee30-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:55.731	2018-11-18 00:45:55.731	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	纠正措施应与（ ）相适应。	1	1
593b7200-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:46:36.832	2018-11-18 00:46:36.832	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据ISO 9001:2015标准9.1.1条款，以下错误的是（ ）。	1	1
a39edf30-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:41.635	2018-11-18 00:48:41.635	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	GB/T19001-2015标准中持续改进活动包括（ ）	1	1
c1397460-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:49:31.302	2018-11-18 00:49:31.302	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	关于质量管理体系评价的说法正确的是（ ）	1	1
d5284c80-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:04.744	2018-11-18 00:50:04.744	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	监视顾客关于组织是否满足其要求的感受的方法包括（ ）。	1	1
efdd4df0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:49.551	2018-11-18 00:50:49.551	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	GB/T19001-2015标准要求最高管理者应按策划的时间间隔评审质量管理体系，以确保其持续的( )。	1	1
07807b80-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:51:29.208	2018-11-18 00:51:29.208	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	依据GB/T19001-2015标准8.5.2，以下说法正确的是（ ）	1	1
1df6e8e0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:06.894	2018-11-18 00:52:06.894	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	顾客提供的财产可以是( )。	1	1
32621cf0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:41.151	2018-11-18 00:52:41.151	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	防护涉及的对象是( )。	1	1
52389860-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:53:34.566	2018-11-18 00:53:34.566	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	以下哪些属于分析和评价的内容？	1	1
699aec60-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:54:13.798	2018-11-18 00:54:13.798	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	文件发布前的评审和批准目的是( )。	1	1
adedebb0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:08.427	2018-11-18 00:56:08.427	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	组织确定需要应对的风险和机会的目的是：（ ）	2	2
c834c200-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:52.512	2018-11-18 00:56:52.512	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	根据ISO9001：2015关于组织的角色、职责和权限 ，以下说法正确的是：（ ）	2	2
e4ecbf60-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:57:40.694	2018-11-18 00:57:58.025	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	确定质量管理体系范围以下说法正确的是：（ ）	2	2
14052cb0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:58:59.707	2018-11-18 00:58:59.707	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	设计和开发输出结果可以包括（ ）。	2	2
2a6a8310-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:59:37.281	2018-11-18 00:59:37.281	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	ISO 9001:2015标准指出对外部供方的信息，在沟通之前所确定的要求是充分的，其沟通内容包括（ ）。	2	2
44711c10-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:00:20.945	2018-11-18 01:00:20.945	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	不同组织的质量管理体系文件多少与详细程度，根据（ ）可以不同。	2	2
5dffed00-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:03.824	2018-11-18 01:01:03.824	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	过程的合适的环境可以是人为因素和物理因素的组合，包括： （ ）	2	2
73c580f0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:40.351	2018-11-18 01:01:40.351	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	以下哪些是动作环境的心理因素： （ ）	2	2
8b7f6ad0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:02:20.157	2018-11-18 01:02:20.157	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	通过以下（ ）等相关因素有助于理解组织内部环境	2	2
b0add990-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:03:22.537	2018-11-18 01:03:22.537	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	外部知识可包括 ：（ ）	2	2
c8474320-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:02.13	2018-11-18 01:04:02.13	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	对不合格进行处理和采取纠正措施及组织应保留有关（ ）形成文件的信息作为证据。	2	2
e3af8f00-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:48.112	2018-11-18 01:04:48.112	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	根据2015 版中9.1.3条款， 组织应分析和评价来自监视、测量以及其他来源的适合数据和信息分析结果应用于评价：（ ）	2	2
fe8eadb0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:05:33.195	2018-11-18 01:05:33.195	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	服务的提供可涉及 （ ）	2	2
2a7d2b40-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:06:46.9	2018-11-18 01:06:46.9	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	为确定产品交付后的活动的实施程度，组织应考虑： （ ）	2	2
85e43780-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:20.248	2018-11-18 01:09:20.248	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	与顾客沟通的内容包括（ ）	2	2
9c1f2280-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:57.544	2018-11-18 01:09:57.544	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	GB/T19001-2015标准8.2条款中的顾客要求包括( )。	2	2
b1046890-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:10:32.601	2018-11-18 01:10:32.601	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	交付后活动可包括( )。	2	2
ccd70f00-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:11:19.28	2018-11-18 01:11:19.28	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	若顾客或外部供方的财产发生丢失、损坏或发现不适用情况，组织应（ ）	2	2
ec67f5f0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:12:12.239	2018-11-18 01:12:12.239	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	管理评审的输入应包括( )。	2	2
055e0950-ea8c-11e8-a812-08d40c3d2417	2018-11-18 01:12:54.118	2018-11-18 01:12:54.118	t	t	08e857a0-ea83-11e8-a812-08d40c3d2417	与外部供方沟通的信息包括（ ）	2	2
7c2702c0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:31:50.124	2018-11-18 11:31:50.124	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	组织可以在知情决策后保留风险。 （ ）	4	1
911597a0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:25.242	2018-11-18 11:32:25.242	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	组织所采取的应对风险和机遇的措施都应与其对产品和服务符合性的潜在影响相适应。 （ ）	4	1
9cba8ca0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:44.778	2018-11-18 11:32:44.778	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	组织的质量管理体系范围应可获取但并不一定要保持文件化信息（ ）	4	1
adce3140-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:13.428	2018-11-18 11:33:13.428	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	设计和开发的评审、验证和确认具有不同的目的，他们只可以按适合组织的方式单独进行。（ ）	4	1
bdadc2b0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:40.059	2018-11-18 11:33:40.059	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	新版标准中对外部提供过程、产品和服务的控制不包括外包过程。 （ ）	4	1
c9eb7540-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:00.596	2018-11-18 11:34:00.596	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	新版标准未有区分文件和记录的要求，统一明确为文件化信息 （ ）	4	1
d6fc0830-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:22.515	2018-11-18 11:34:22.515	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	顾客现场不属于顾客财产（ ）	4	1
e5030910-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:46.049	2018-11-18 11:34:46.049	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	本标准所规定的质量管理体系要求是对产品和服务要求的补充（ ）	4	1
f243acb0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:08.283	2018-11-18 11:35:08.283	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	标准要求内审每年应进行一次（ ）	4	1
fd41da60-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:26.726	2018-11-18 11:35:26.726	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	依据ISO9001：2015标准要求，关于意识是指在组织控制下的人员都应意识到不符合质量管理体系要求可能引发的后果（ ）	4	1
09300d60-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:35:46.742	2018-11-18 11:35:46.742	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	对所有不合格品均应采取纠正措施（ ）	4	1
1a7151b0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:15.691	2018-11-18 11:36:15.691	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	对顾客满意的监视应采用顾客调查表的方式（ ）	4	1
23e24fb0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:31.531	2018-11-18 11:36:31.531	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	风险是一种不确定性的影响，确定风险是进行质量管理体系策划的基础。	4	1
2e5e7c20-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:49.122	2018-11-18 11:36:49.122	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	最高管理者对质量管理体系的有效性负有责任 （ ）	4	1
388b9e30-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:06.195	2018-11-18 11:37:06.195	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	在生产和服务提供的每个阶段都应有相应的验证活动（ ）	4	1
471ba530-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:30.627	2018-11-18 11:37:30.627	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	管理评审的目的是确保质量管理体系持续的保持适宜性、充分性和有效性，并与组织的战略方向一致（ ）	4	1
5488fe20-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:53.154	2018-11-18 11:37:53.154	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	组织的环境包括需要考虑的正面和负面要素或条件（ ）	4	1
5f7af6d0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:38:11.517	2018-11-18 11:38:11.517	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	质量目标应考虑适用的要求，且可量化（ ）	4	1
713d2af0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:38:41.311	2018-11-18 11:39:04.32	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	ISO9001-2015标准不要求统一各组织的质量管理体系的架构（）	4	1
b85be8e0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:15.598	2018-11-18 12:52:15.598	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	不属于风险和机遇方面所做的策划是（ ）	1	1
d6e185e0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:41:31.838	2018-11-18 12:50:04.221	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	相关方会对组织持续提供符合顾客要求和适用法律法规要求的产品和服务的能力产生影响或潜在影响（ ）	4	1
d21a7c60-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:58.79	2018-11-18 12:52:58.79	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	机遇可能导致新的实践，推出新产品，开发新客户，建立合作伙伴关系，使新技术以及其他理想的和可行的情况，用来应对（ ）的需求。	1	1
ead58290-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:53:40.281	2018-11-18 12:53:40.281	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下描述中，关于质量管理体系策划未包括（ ）。	1	1
0c6b3a30-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:54:36.627	2018-11-18 12:54:36.627	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	依据ISO 9001:2015标准，以下说法正确的是（ ）。	1	1
23513240-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:15.044	2018-11-18 12:55:15.044	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	一个生产型上市企业，下列不属于组织控制范围内从事影响质量绩效工作的人员有（ ）。	1	1
3bff1910-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:56.449	2018-11-18 12:55:56.449	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下不属于“设计和开发输入”应考虑的内容的是（ ）。	1	1
55be21c0-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:56:39.644	2018-11-18 12:56:39.644	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下哪种外部供方提供的过程、产品和服务不需要按8.4的要求控制： （ ）	1	1
77d71320-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:57:36.85	2018-11-18 12:57:36.85	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	组织的质量管理体系文件化信息应包括：（ ）	1	1
8dc87200-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:13.664	2018-11-18 12:58:13.664	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	在编制和更新文件时，组织应确保适当的 （ ）	1	1
a51bd1e0-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:52.798	2018-11-18 12:58:52.798	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	关于组织的利益相关方对组织的质量管理体系的需求和期望，以下说法正确的是（ ）	1	1
bbd89710-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:59:30.945	2018-11-18 12:59:30.945	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	ISO 9001:2015标准7.14“过程运行环境”可以包括（ ）	1	1
d0446760-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:05.206	2018-11-18 13:00:05.206	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	资源包括： （ ）	1	1
e7469a00-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:43.808	2018-11-18 13:00:43.808	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	知识包括： （ ）	1	1
071f5f60-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:01:37.238	2018-11-18 13:01:37.238	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	对不合格输出的控制，不包括： （ ）	1	1
1d863c60-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:14.822	2018-11-18 13:02:14.822	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	依据GB/T19001-2015标准，不合格输出的控制适用于（ ）	1	1
36c7fec0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:57.196	2018-11-18 13:02:57.196	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	纠正措施应与（ ）相适应。	1	1
4c0f13e0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:03:32.894	2018-11-18 13:03:32.894	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	依据ISO9001：2015标准10.3条款，改进的例子可包括（ ）	1	1
64252780-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:13.304	2018-11-18 13:04:13.304	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	关于分析和评价的说法正确的是（ ）	1	1
767e9290-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:44.089	2018-11-18 13:04:44.089	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	在对质量管理体系的变更进行策划，应保持质量管理体系的( )。	1	1
8b193b10-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:18.657	2018-11-18 13:05:18.657	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下哪些能体现“以顾客为关注焦点”的原则？	1	1
a0ba7e20-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:54.946	2018-11-18 13:05:54.946	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	对组织面临的内部和外部因素，组织应（ ）	1	1
b366eb30-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:26.275	2018-11-18 13:06:26.275	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	下列( )对产品质量特性没有直接影响。	1	1
c7670160-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:59.83	2018-11-18 13:06:59.83	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	关于过程运行环境说法正确的是（ ）	1	1
d93a7390-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:29.737	2018-11-18 13:07:29.737	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	为了确保测量结果有效、可靠，GB/T19001标准要求对测量设备应实施以下控制( )。	1	1
ea006d60-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:57.878	2018-11-18 13:07:57.878	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	基础设施不包括( )。	1	1
0049fe60-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:08:35.27	2018-11-18 13:08:35.27	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	为确保设计和开发的输出满足输入的要求应进行( )。	1	1
14d627f0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:09.743	2018-11-18 13:09:09.743	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	餐厅的厨师都有健康证是在满足( )。	1	1
2a4389c0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:45.692	2018-11-18 13:09:45.692	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	在一个生产型企业，下列不属于从事影响质量管理体系绩效和有效性工作的人员有( )。	1	1
3e3ff670-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:19.223	2018-11-18 13:10:19.223	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	生产和销售调味品应取得食品许可证这是在满足( )要求。	1	1
4ee1c670-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:47.127	2018-11-18 13:10:47.127	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下属于GB/T19001-2015标准7.2条款获取人员能力的措施？（ ）	1	1
880a30e0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:12:23.022	2018-11-18 13:12:23.022	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	组织确定需要应对的风险和机会的目的是： （ ）	2	2
af49f370-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:13:28.871	2018-11-18 13:13:28.871	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	ISO9001:2015 要求组织确定与质量管理相关的内部和外部沟通的需求，包括： （ ）	2	2
cc261aa0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:14:17.29	2018-11-18 13:14:17.29	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	确定质量管理体系范围以下说法正确的是：（ ）	2	2
e8c5ae00-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:05.312	2018-11-18 13:15:05.312	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	设计和开发输出结果可以包括（ ）。	2	2
ffa404f0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:43.679	2018-11-18 13:15:43.679	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	ISO 9001:2015标准指出对外部供方的信息，在沟通之前所确定的要求是充分的，其沟通内容包括（ ）。	2	2
15468080-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:16:19.976	2018-11-18 13:16:19.976	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	适用时，组织应实施以下活动对文件化信息进行控制：（ ）	2	2
2d8e7990-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:17:00.713	2018-11-18 13:17:00.713	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	过程的合适的环境可以是人为因素和物理因素的组合，包括： （ ）	2	2
52ee0a70-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:03.415	2018-11-18 13:18:03.415	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	为确定产品交付后的活动的实施程度，组织应考虑： （ ）	2	2
6a8af670-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:43.031	2018-11-18 13:18:43.031	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下哪些属于GB/T19001-2015标准中所说的“机遇”？（ ）	2	2
7e128140-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:15.796	2018-11-18 13:19:15.796	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	策划如何实现质量目标时应确定（）	2	2
94fd0d30-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:54.243	2018-11-18 13:19:54.243	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下哪些是最高管理者“领导作用”的体现？( )	2	2
ae5c69b0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:20:36.811	2018-11-18 13:20:36.811	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下哪些是领导作用的体现？()	2	2
c63c2b10-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:16.865	2018-11-18 13:21:16.865	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	关于“适用性”，以下说法正确的是（ ）	2	2
dc62cac0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:54.028	2018-11-18 13:21:54.028	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	ISO9001:2015标准对“形成文件的信息”的要求主要有（ ）	2	2
0271d580-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:22:57.88	2018-11-18 13:22:57.88	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	组织在策划质量管理体系的变更时，应考虑到（ ）	2	2
23114640-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:23:52.612	2018-11-18 13:23:52.612	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下哪些应保留形成文件的信息？（ ）	2	2
45f2ded0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:24:51.133	2018-11-18 13:24:51.133	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	以下哪种情况的顾客要求不是以文件形式提出的？( )	2	2
5ffb9ab0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:25:34.811	2018-11-18 13:25:34.811	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	关于设计和开发控制，正确的是（ ）	2	2
799d3050-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:17.813	2018-11-18 13:26:17.813	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	关于形成文件的信息的控制，说法正确的是（ ）	2	2
90a70410-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:56.465	2018-11-18 13:26:56.465	t	t	506cd110-eae1-11e8-a812-08d40c3d2417	要求指“明示的、通常隐含的或必须履行的需求或期望”，下列说法正确的是( )。	2	2
e20570c0-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:22.476	2018-11-18 13:36:22.476	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	风险是一种不确定性的影响，可能是积极影响也可能是消极影响 （ ）	4	1
ead91d50-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:37.285	2018-11-18 13:36:37.285	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织所采取的应对风险和机遇的措施都应与其对产品和服务符合性的潜在影响相适应。 （ ）	4	1
f44c8c50-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:53.141	2018-11-18 13:36:53.141	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	最高管理者对质量管理体系的有效性负有责任 （ ）	4	1
fdee5e50-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:37:09.301	2018-11-18 13:37:09.301	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	依据ISO9001：2015标准要求，关于能力是指在组织控制下的人员都应具备必要的能力（ ）	4	1
06f88430-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:24.467	2018-11-18 13:37:24.467	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织的质量管理体系范围应可获取但并不一定要保持文件化信息（ ）	4	1
1260be50-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:43.605	2018-11-18 13:37:43.605	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	设计和开发的评审、验证和确认具有不同的目的，他们只可以按适合组织的方式单独进行。（ ）	4	1
1e74efe0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:03.87	2018-11-18 13:38:03.87	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	新版标准中对外部提供过程、产品和服务的控制不包括外包过程。 （ ）	4	1
23445240-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:11.94	2018-11-18 13:38:11.94	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织的质量管理体系文件化信息只包括 本标准要求的 （ ）	4	1
2de062c0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:29.74	2018-11-18 13:38:29.74	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	顾客现场不属于顾客财产（ ）	4	1
362033c0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:43.58	2018-11-18 13:38:43.58	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	本标准所规定的质量管理体系要求是对产品和服务要求的补充（ ）	4	1
3e3b65c0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:57.18	2018-11-18 13:38:57.18	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	发现测量设备不符合预期用途时，应确定当时测量结果的有效性是否受到不利影响（ ）	4	1
4979d0c0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:16.044	2018-11-18 13:39:16.044	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	应对风险和机遇的措施应与其对于产品和服务符合性的潜在影响相适应（ ）	4	1
5418a060-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:33.862	2018-11-18 13:39:33.862	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	在承诺向顾客提供产品和服务之时，评审与产品和服务有关的要求（ ）	4	1
6091ae40-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:54.788	2018-11-18 13:39:54.788	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	识别和控制不合格品是为了防止其非预期的使用或交付（ ）	4	1
6b525dc0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:12.828	2018-11-18 13:40:12.828	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织应确定顾客满意信息的获取、监视和评审方法（ ）	4	1
756e8fe0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:29.79	2018-11-18 13:40:29.79	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	处置不合格产生的后果（影响）是纠正措施不可缺少的一部分（ ）	4	1
83added0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:53.693	2018-11-18 13:40:53.693	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织的环境将影响其实现质量管理体系预期结果（ ）	4	1
97b288e0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:27.278	2018-11-18 13:41:27.278	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织应确定哪些相关方与质量管理体系有关，以及相关的要求（ ）	4	1
a262e4b0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:45.211	2018-11-18 13:41:45.211	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	在质量管理体系过程中整合并实施应对风险和机遇的措施（ ）	4	1
aa38a940-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:58.356	2018-11-18 13:41:58.356	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	内审每年应进行一次（ ）	4	1
0cfffbf0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:44:44.079	2018-11-18 13:44:44.079	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	机遇可能导致新的实践，推出新产品，开发新客户，建立合作伙伴关系，使新技术以及其他理想的和可行的情况，用来应对（ ）的需求。	1	1
239e63b0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:45:22.027	2018-11-18 13:45:22.027	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	质量管理体系（ ）时，组织应考虑到4.1所描述的因素和4.2所提及的要求，确定需要应对的风险和机遇。	1	1
3e3555d0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:46:06.637	2018-11-18 13:46:06.637	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下描述中，关于质量管理体系策划未包括（ ）。	1	1
5f6b8850-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:02.357	2018-11-18 13:47:02.357	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	一个生产型上市企业，下列不属于组织控制范围内从事影响质量绩效工作的人员有（ ）。	1	1
73e7fa70-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:36.727	2018-11-18 13:47:36.727	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	ISO 9001:2015标准7.3条款特指人员意识，要求组织应确保其控制范围内相关工作人员知晓（ ）。	1	1
8803fd10-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:10.465	2018-11-18 13:48:10.465	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	依据ISO 9001:2015标准8.3.4条款，以下错误的是（ ）。	1	1
9d3feea0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:46.09	2018-11-18 13:48:46.09	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	ISO 9001:2015标准要求，设计和开发输入应完整、清楚，是为了（ ）。	1	1
b7ff0230-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:49:30.963	2018-11-18 13:49:30.963	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下哪种外部供方提供的过程、产品和服务不需要按8.4的要求控制： （ ）	1	1
cac22b90-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:02.441	2018-11-18 13:50:02.441	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	在编制和更新文件时，组织应确保适当的 （ ）	1	1
e0983a40-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:39.076	2018-11-18 13:50:39.076	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	应对所保存的作为符合性证据的形成文件的信息予以保护，防止非预期的( )	1	1
0229d330-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:51:35.395	2018-11-18 13:51:35.395	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	关于组织的利益相关方对组织的质量管理体系的需求和期望，以下说法正确的是	1	1
166a74d0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:09.373	2018-11-18 13:52:09.373	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	资源包括： （ ）	1	1
2ad7f2d0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:43.645	2018-11-18 13:52:43.645	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	（ ）属于ISO 9001:2015标准要求组织确定、提供维护信息和通讯技术。	1	1
3dc8e2f0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:15.423	2018-11-18 13:53:15.423	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	依据ISO9001：2015标准10.3条款，改进的例子可包括（ ）	1	1
51b80930-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:48.867	2018-11-18 13:53:48.867	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	依据ISO9001：2015标准，以下正确的是（ ）	1	1
66419ab0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:23.323	2018-11-18 13:54:23.323	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	根据GB/T19001-2015，设计和开发评审的目的是( )。	1	1
782b5400-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:53.376	2018-11-18 13:54:53.376	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	产品标识的目的是( )。	1	1
8a4c22e0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:23.79	2018-11-18 13:55:23.79	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	未经过最终检测的产品( )。	1	1
9edb80c0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:58.284	2018-11-18 13:55:58.284	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	在有( )的场合，组织应控制输出的惟一性标识。	1	1
c25e3b50-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:56:57.861	2018-11-18 13:56:57.861	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下属于纠正措施的是( )。	1	1
db35f140-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:57:39.54	2018-11-18 13:57:39.54	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	监视顾客关于组织是否满足其要求的的感受的方法不包括（ ）。	1	1
ee7b9110-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:58:11.873	2018-11-18 13:58:11.873	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	对输出的防护不包括( )。	1	1
032ea390-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:58:46.601	2018-11-18 13:58:46.601	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	GB/T19001-2015标准中要求的法律法规是指()。	1	1
178712f0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:59:20.735	2018-11-18 13:59:20.735	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	GB/T19001-2015标准对哪些人员的能力提出要求？（ ）	1	1
2fc5bd30-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:01.411	2018-11-18 14:00:01.411	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	为证实军队作战服是否满足作战、训练的使用要求而在演练时试穿考察是( )。	1	1
4389b4c0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:34.572	2018-11-18 14:00:34.572	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织应基于（ ）确定外部供方的评价、选择、绩效监视 以及再评价的准则，并加以实施。	1	1
5abb34c0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:13.484	2018-11-18 14:01:13.484	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	过程运行环境可包括（ ）	1	1
6d1fea70-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:44.343	2018-11-18 14:01:44.343	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	质量管理体系形成文件的信息的多少与详略程度取决于（ ）	1	1
7f91e690-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:15.289	2018-11-18 14:02:15.289	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	顾客可以采用( )提出与产品有关的要求。	1	1
93614fd0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:48.525	2018-11-18 14:02:48.525	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	在质量管理体系中人员的能力，应从以下( )方面体现和评价。	1	1
d2339e20-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:04:33.922	2018-11-18 14:04:33.922	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织确定需要应对的风险和机会的目的是： （ ）	2	2
ef0e65c0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:05:22.332	2018-11-18 14:05:22.332	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	确定质量管理体系范围以下说法正确的是：（ ）	2	2
09a0c400-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:06.912	2018-11-18 14:06:06.912	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	ISO9001:2015 要求组织确定与质量管理相关的内部和外部沟通的需求，包括： （ ）	2	2
289fcb30-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:58.915	2018-11-18 14:06:58.915	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	设计和开发输出结果可以包括（ ）。	2	2
3c272ef0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:07:31.679	2018-11-18 14:07:31.679	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	ISO 9001:2015标准指出对外部供方的信息，在沟通之前所确定的要求是充分的，其沟通内容包括（ ）。	2	1
9d3d9d50-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:10:14.565	2018-11-18 14:10:14.565	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	不同组织的质量管理体系文件多少与详细程度，根据（ ）可以不同。	2	2
c2348150-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:11:16.581	2018-11-18 14:11:16.581	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下哪些是动作环境的心理因素： （ ）	2	2
e3e33f30-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:13.091	2018-11-18 14:12:13.091	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	管理评审应( )。	2	2
fad4f710-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:51.585	2018-11-18 14:12:51.585	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下哪些可以作为改进活动的示例？（ ）	2	2
133c37f0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:13:32.527	2018-11-18 14:13:32.527	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	关于纠正措施，说法正确的是（ ）	2	2
25d34840-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:03.716	2018-11-18 14:14:03.716	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织应保留关于不合格的形成文件的信息包括（ ）	2	2
3a4dbe90-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:38.073	2018-11-18 14:14:38.073	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	顾客或外部供方的财产，可以包括（ ）	2	2
509f8cf0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:15:15.519	2018-11-18 14:15:39.965	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	监视顾客感受的方法包括（ ）	2	2
800074f0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:16:35.007	2018-11-18 14:16:35.007	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	在策划的安排已圆满完成之前，放行产品和交付服务应( )。	2	2
a1b8a8b0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:17:31.579	2018-11-18 14:17:31.579	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下哪些是顾客财产? ( )	2	2
b89726b0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:18:09.947	2018-11-18 14:18:09.947	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下属于2015标准8.4 外部提供的过程、产品和服务的控制范围的是（ ）	2	2
d71d2d50-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:01.157	2018-11-18 14:19:01.157	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	应利用分析结果评价（ ）	2	2
eaef2ea0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:34.41	2018-11-18 14:19:34.41	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	确定是否存在持续改进的需求或机会，应考虑（ ）	2	2
ffb4dec0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:20:09.26	2018-11-18 14:20:09.26	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	以下哪些方面体现了质量管理体系的绩效和有效性？（ ）	2	2
14fba5c0-eafa-11e8-a812-08d40c3d2417	2018-11-18 14:20:44.956	2018-11-18 14:20:44.956	t	t	45ab5910-eaf3-11e8-a812-08d40c3d2417	组织在确定交付后活动的覆盖范围和程度时，应考虑的因素有（）	2	2
\.


--
-- Data for Name: store_question_analysis; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.store_question_analysis (id, create_time, update_time, flag, status, question_id, content) FROM stdin;
713d7910-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:38:41.313	2018-11-18 11:39:04.332	t	t	713d2af0-eae3-11e8-a812-08d40c3d2417	\N
9452a660-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:12:28.486	2018-11-18 00:12:28.486	t	t	94500e50-ea83-11e8-a812-08d40c3d2417	\N
ec18be21-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:14:55.746	2018-11-18 00:14:55.746	t	t	ec18be20-ea83-11e8-a812-08d40c3d2417	\N
03865cc0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:15:35.052	2018-11-18 00:15:35.052	t	t	0385c080-ea84-11e8-a812-08d40c3d2417	\N
1c828aa0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:16:16.97	2018-11-18 00:16:16.97	t	t	1c81ee60-ea84-11e8-a812-08d40c3d2417	\N
36501240-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:00.26	2018-11-18 00:17:00.26	t	t	364f7600-ea84-11e8-a812-08d40c3d2417	\N
465f8d50-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:27.205	2018-11-18 00:17:27.205	t	t	465ef110-ea84-11e8-a812-08d40c3d2417	\N
5ef57f50-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:08.453	2018-11-18 00:18:08.453	t	t	5ef4e310-ea84-11e8-a812-08d40c3d2417	\N
6f023b40-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:35.38	2018-11-18 00:18:35.38	t	t	6f019f00-ea84-11e8-a812-08d40c3d2417	\N
8207c4d0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:07.293	2018-11-18 00:19:07.293	t	t	82072890-ea84-11e8-a812-08d40c3d2417	\N
9877c990-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:44.937	2018-11-18 00:19:44.937	t	t	98709da0-ea84-11e8-a812-08d40c3d2417	\N
b1c4fda0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:20:27.386	2018-11-18 00:20:27.386	t	t	b1c46160-ea84-11e8-a812-08d40c3d2417	\N
c6325490-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:01.657	2018-11-18 00:21:01.657	t	t	c630f500-ea84-11e8-a812-08d40c3d2417	\N
d7a41ec0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:30.924	2018-11-18 00:21:30.924	t	t	d7a2e640-ea84-11e8-a812-08d40c3d2417	\N
02017501-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:22:42	2018-11-18 00:22:42	t	t	02017500-ea85-11e8-a812-08d40c3d2417	\N
15b8c260-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:15.078	2018-11-18 00:23:15.078	t	t	15b82620-ea85-11e8-a812-08d40c3d2417	\N
278074c0-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:44.908	2018-11-18 00:23:44.908	t	t	277fd880-ea85-11e8-a812-08d40c3d2417	\N
39a673c0-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:24:15.356	2018-11-18 00:24:15.356	t	t	39a5d780-ea85-11e8-a812-08d40c3d2417	\N
58a1f880-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:07.336	2018-11-18 00:25:07.336	t	t	589f8780-ea85-11e8-a812-08d40c3d2417	\N
66ee3fc0-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:31.324	2018-11-18 00:25:31.324	t	t	66eda380-ea85-11e8-a812-08d40c3d2417	\N
955892c0-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:26:49.196	2018-11-18 00:26:49.196	t	t	9557f680-ea85-11e8-a812-08d40c3d2417	\N
2192dbb0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:30:44.459	2018-11-18 00:30:44.459	t	t	21923f70-ea86-11e8-a812-08d40c3d2417	\N
4612baf0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:31:45.695	2018-11-18 00:31:45.695	t	t	4610e630-ea86-11e8-a812-08d40c3d2417	\N
61eb2dc0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:32:32.412	2018-11-18 00:32:32.412	t	t	61ea9180-ea86-11e8-a812-08d40c3d2417	\N
7a9ce520-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:33:13.842	2018-11-18 00:33:13.842	t	t	7a9c48e0-ea86-11e8-a812-08d40c3d2417	\N
9ebbdfb1-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:14.443	2018-11-18 00:34:14.443	t	t	9ebbdfb0-ea86-11e8-a812-08d40c3d2417	\N
b6ff1dd0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:55.149	2018-11-18 00:34:55.149	t	t	b6fe8190-ea86-11e8-a812-08d40c3d2417	\N
e006cf21-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:36:03.986	2018-11-18 00:36:03.986	t	t	e006cf20-ea86-11e8-a812-08d40c3d2417	\N
0e720c80-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:37:21.864	2018-11-18 00:37:21.864	t	t	0e717040-ea87-11e8-a812-08d40c3d2417	\N
2be1e830-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:38:11.251	2018-11-18 00:38:11.251	t	t	2be14bf0-ea87-11e8-a812-08d40c3d2417	\N
5d201bb0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:39:33.867	2018-11-18 00:39:33.867	t	t	5d1ee330-ea87-11e8-a812-08d40c3d2417	\N
77879960-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:40:18.166	2018-11-18 00:40:18.166	t	t	7786fd20-ea87-11e8-a812-08d40c3d2417	\N
92412eb0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:03.003	2018-11-18 00:41:03.003	t	t	92409270-ea87-11e8-a812-08d40c3d2417	\N
b056e750-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:53.477	2018-11-18 00:41:53.477	t	t	b0547650-ea87-11e8-a812-08d40c3d2417	\N
c82a73b0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:42:33.451	2018-11-18 00:42:33.451	t	t	c829d770-ea87-11e8-a812-08d40c3d2417	\N
ec718fb0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:43:34.315	2018-11-18 00:43:34.315	t	t	ec70f370-ea87-11e8-a812-08d40c3d2417	\N
09022ef0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:44:22.239	2018-11-18 00:44:22.239	t	t	090192b0-ea88-11e8-a812-08d40c3d2417	\N
27f0e271-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:14.135	2018-11-18 00:45:14.135	t	t	27f0e270-ea88-11e8-a812-08d40c3d2417	\N
40bc8a70-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:55.735	2018-11-18 00:45:55.735	t	t	40bbee30-ea88-11e8-a812-08d40c3d2417	\N
593c3550-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:46:36.837	2018-11-18 00:46:36.837	t	t	593b7200-ea88-11e8-a812-08d40c3d2417	\N
6e359fa0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:47:12.026	2018-11-18 00:47:12.026	t	t	6e350360-ea88-11e8-a812-08d40c3d2417	\N
8f39ecb0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:07.419	2018-11-18 00:48:07.419	t	t	8f395070-ea88-11e8-a812-08d40c3d2417	\N
a3a288b0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:41.659	2018-11-18 00:48:41.659	t	t	a39edf30-ea88-11e8-a812-08d40c3d2417	\N
c13a10a0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:49:31.306	2018-11-18 00:49:31.306	t	t	c1397460-ea88-11e8-a812-08d40c3d2417	\N
d52abd80-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:04.76	2018-11-18 00:50:04.76	t	t	d5284c80-ea88-11e8-a812-08d40c3d2417	\N
efddea30-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:49.555	2018-11-18 00:50:49.555	t	t	efdd4df0-ea88-11e8-a812-08d40c3d2417	\N
078117c0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:51:29.212	2018-11-18 00:51:29.212	t	t	07807b80-ea89-11e8-a812-08d40c3d2417	\N
1df78520-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:06.898	2018-11-18 00:52:06.898	t	t	1df6e8e0-ea89-11e8-a812-08d40c3d2417	\N
3262b930-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:41.155	2018-11-18 00:52:41.155	t	t	32621cf0-ea89-11e8-a812-08d40c3d2417	\N
523934a0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:53:34.57	2018-11-18 00:53:34.57	t	t	52389860-ea89-11e8-a812-08d40c3d2417	\N
699b88a0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:54:13.802	2018-11-18 00:54:13.802	t	t	699aec60-ea89-11e8-a812-08d40c3d2417	\N
adee60e0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:08.43	2018-11-18 00:56:08.43	t	t	adedebb0-ea89-11e8-a812-08d40c3d2417	\N
c8353730-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:52.515	2018-11-18 00:56:52.515	t	t	c834c200-ea89-11e8-a812-08d40c3d2417	\N
e4ed3490-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:57:40.697	2018-11-18 00:57:58.052	t	t	e4ecbf60-ea89-11e8-a812-08d40c3d2417	\N
14057ad0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:58:59.709	2018-11-18 00:58:59.709	t	t	14052cb0-ea8a-11e8-a812-08d40c3d2417	\N
2a6af840-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:59:37.284	2018-11-18 00:59:37.284	t	t	2a6a8310-ea8a-11e8-a812-08d40c3d2417	\N
44719140-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:00:20.948	2018-11-18 01:00:20.948	t	t	44711c10-ea8a-11e8-a812-08d40c3d2417	\N
5e006230-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:03.827	2018-11-18 01:01:03.827	t	t	5dffed00-ea8a-11e8-a812-08d40c3d2417	\N
73c5f620-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:40.354	2018-11-18 01:01:40.354	t	t	73c580f0-ea8a-11e8-a812-08d40c3d2417	\N
8b8e10d0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:02:20.253	2018-11-18 01:02:20.253	t	t	8b7f6ad0-ea8a-11e8-a812-08d40c3d2417	\N
b0ae27b0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:03:22.539	2018-11-18 01:03:22.539	t	t	b0add990-ea8a-11e8-a812-08d40c3d2417	\N
c847b850-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:02.133	2018-11-18 01:04:02.133	t	t	c8474320-ea8a-11e8-a812-08d40c3d2417	\N
e3afdd20-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:48.114	2018-11-18 01:04:48.114	t	t	e3af8f00-ea8a-11e8-a812-08d40c3d2417	\N
fe8f22e0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:05:33.198	2018-11-18 01:05:33.198	t	t	fe8eadb0-ea8a-11e8-a812-08d40c3d2417	\N
2a7d2b41-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:06:46.9	2018-11-18 01:06:46.9	t	t	2a7d2b40-ea8b-11e8-a812-08d40c3d2417	\N
85e4acb0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:20.251	2018-11-18 01:09:20.251	t	t	85e43780-ea8b-11e8-a812-08d40c3d2417	\N
9c1f97b0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:57.547	2018-11-18 01:09:57.547	t	t	9c1f2280-ea8b-11e8-a812-08d40c3d2417	\N
b104ddc0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:10:32.604	2018-11-18 01:10:32.604	t	t	b1046890-ea8b-11e8-a812-08d40c3d2417	\N
ccd7ab40-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:11:19.284	2018-11-18 01:11:19.284	t	t	ccd70f00-ea8b-11e8-a812-08d40c3d2417	\N
ec686b20-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:12:12.242	2018-11-18 01:12:12.242	t	t	ec67f5f0-ea8b-11e8-a812-08d40c3d2417	\N
055e7e80-ea8c-11e8-a812-08d40c3d2417	2018-11-18 01:12:54.12	2018-11-18 01:12:54.12	t	t	055e0950-ea8c-11e8-a812-08d40c3d2417	\N
7c2777f0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:31:50.127	2018-11-18 11:31:50.127	t	t	7c2702c0-eae2-11e8-a812-08d40c3d2417	\N
911597a1-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:25.242	2018-11-18 11:32:25.242	t	t	911597a0-eae2-11e8-a812-08d40c3d2417	\N
9cbb01d0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:44.781	2018-11-18 11:32:44.781	t	t	9cba8ca0-eae2-11e8-a812-08d40c3d2417	\N
adce7f60-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:13.43	2018-11-18 11:33:13.43	t	t	adce3140-eae2-11e8-a812-08d40c3d2417	\N
bdae10d0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:40.061	2018-11-18 11:33:40.061	t	t	bdadc2b0-eae2-11e8-a812-08d40c3d2417	\N
c9ebea70-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:00.599	2018-11-18 11:34:00.599	t	t	c9eb7540-eae2-11e8-a812-08d40c3d2417	\N
d6fc5650-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:22.517	2018-11-18 11:34:22.517	t	t	d6fc0830-eae2-11e8-a812-08d40c3d2417	\N
e5035730-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:46.051	2018-11-18 11:34:46.051	t	t	e5030910-eae2-11e8-a812-08d40c3d2417	\N
f24421e0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:08.286	2018-11-18 11:35:08.286	t	t	f243acb0-eae2-11e8-a812-08d40c3d2417	\N
fd422880-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:26.728	2018-11-18 11:35:26.728	t	t	fd41da60-eae2-11e8-a812-08d40c3d2417	\N
09308290-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:35:46.745	2018-11-18 11:35:46.745	t	t	09300d60-eae3-11e8-a812-08d40c3d2417	\N
1a71c6e0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:15.694	2018-11-18 11:36:15.694	t	t	1a7151b0-eae3-11e8-a812-08d40c3d2417	\N
23e29dd0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:31.533	2018-11-18 11:36:31.533	t	t	23e24fb0-eae3-11e8-a812-08d40c3d2417	\N
2e5eca40-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:49.124	2018-11-18 11:36:49.124	t	t	2e5e7c20-eae3-11e8-a812-08d40c3d2417	\N
388bec50-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:06.197	2018-11-18 11:37:06.197	t	t	388b9e30-eae3-11e8-a812-08d40c3d2417	\N
471c4170-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:30.631	2018-11-18 11:37:30.631	t	t	471ba530-eae3-11e8-a812-08d40c3d2417	\N
54894c40-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:53.156	2018-11-18 11:37:53.156	t	t	5488fe20-eae3-11e8-a812-08d40c3d2417	\N
5f8b2370-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:38:11.623	2018-11-18 11:38:11.623	t	t	5f7af6d0-eae3-11e8-a812-08d40c3d2417	\N
d6e1fb10-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:41:31.841	2018-11-18 12:50:04.221	t	t	d6e185e0-eae3-11e8-a812-08d40c3d2417	\N
b85c5e10-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:15.601	2018-11-18 12:52:15.601	t	t	b85be8e0-eaed-11e8-a812-08d40c3d2417	\N
d21aca80-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:58.792	2018-11-18 12:52:58.792	t	t	d21a7c60-eaed-11e8-a812-08d40c3d2417	\N
ead7cc80-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:53:40.296	2018-11-18 12:53:40.296	t	t	ead58290-eaed-11e8-a812-08d40c3d2417	\N
0c704340-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:54:36.66	2018-11-18 12:54:36.66	t	t	0c6b3a30-eaee-11e8-a812-08d40c3d2417	\N
2351a770-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:15.047	2018-11-18 12:55:15.047	t	t	23513240-eaee-11e8-a812-08d40c3d2417	\N
3bff4020-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:56.45	2018-11-18 12:55:56.45	t	t	3bff1910-eaee-11e8-a812-08d40c3d2417	\N
55be96f0-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:56:39.647	2018-11-18 12:56:39.647	t	t	55be21c0-eaee-11e8-a812-08d40c3d2417	\N
77d73a30-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:57:36.851	2018-11-18 12:57:36.851	t	t	77d71320-eaee-11e8-a812-08d40c3d2417	\N
8dc8e730-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:13.667	2018-11-18 12:58:13.667	t	t	8dc87200-eaee-11e8-a812-08d40c3d2417	\N
a51c6e20-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:52.802	2018-11-18 12:58:52.802	t	t	a51bd1e0-eaee-11e8-a812-08d40c3d2417	\N
bbd8e530-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:59:30.947	2018-11-18 12:59:30.947	t	t	bbd89710-eaee-11e8-a812-08d40c3d2417	\N
d044dc90-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:05.209	2018-11-18 13:00:05.209	t	t	d0446760-eaee-11e8-a812-08d40c3d2417	\N
e746c110-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:43.809	2018-11-18 13:00:43.809	t	t	e7469a00-eaee-11e8-a812-08d40c3d2417	\N
072049c0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:01:37.244	2018-11-18 13:01:37.244	t	t	071f5f60-eaef-11e8-a812-08d40c3d2417	\N
1d868a80-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:14.824	2018-11-18 13:02:14.824	t	t	1d863c60-eaef-11e8-a812-08d40c3d2417	\N
36c84ce0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:57.198	2018-11-18 13:02:57.198	t	t	36c7fec0-eaef-11e8-a812-08d40c3d2417	\N
4c0f6200-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:03:32.896	2018-11-18 13:03:32.896	t	t	4c0f13e0-eaef-11e8-a812-08d40c3d2417	\N
64266000-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:13.312	2018-11-18 13:04:13.312	t	t	64252780-eaef-11e8-a812-08d40c3d2417	\N
767f07c0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:44.092	2018-11-18 13:04:44.092	t	t	767e9290-eaef-11e8-a812-08d40c3d2417	\N
8b198930-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:18.659	2018-11-18 13:05:18.659	t	t	8b193b10-eaef-11e8-a812-08d40c3d2417	\N
a0bcef20-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:54.962	2018-11-18 13:05:54.962	t	t	a0ba7e20-eaef-11e8-a812-08d40c3d2417	\N
b366eb31-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:26.275	2018-11-18 13:06:26.275	t	t	b366eb30-eaef-11e8-a812-08d40c3d2417	\N
c7677690-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:59.833	2018-11-18 13:06:59.833	t	t	c7670160-eaef-11e8-a812-08d40c3d2417	\N
d94f5b20-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:29.874	2018-11-18 13:07:29.874	t	t	d93a7390-eaef-11e8-a812-08d40c3d2417	\N
ea0d1790-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:57.961	2018-11-18 13:07:57.961	t	t	ea006d60-eaef-11e8-a812-08d40c3d2417	\N
004c4850-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:08:35.285	2018-11-18 13:08:35.285	t	t	0049fe60-eaf0-11e8-a812-08d40c3d2417	\N
14d871e0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:09.758	2018-11-18 13:09:09.758	t	t	14d627f0-eaf0-11e8-a812-08d40c3d2417	\N
2a43fef0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:45.695	2018-11-18 13:09:45.695	t	t	2a4389c0-eaf0-11e8-a812-08d40c3d2417	\N
3e424060-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:19.238	2018-11-18 13:10:19.238	t	t	3e3ff670-eaf0-11e8-a812-08d40c3d2417	\N
4ee1c671-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:47.127	2018-11-18 13:10:47.127	t	t	4ee1c670-eaf0-11e8-a812-08d40c3d2417	\N
880a7f00-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:12:23.024	2018-11-18 13:12:23.024	t	t	880a30e0-eaf0-11e8-a812-08d40c3d2417	\N
af49f371-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:13:28.871	2018-11-18 13:13:28.871	t	t	af49f370-eaf0-11e8-a812-08d40c3d2417	\N
cc288ba0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:14:17.306	2018-11-18 13:14:17.306	t	t	cc261aa0-eaf0-11e8-a812-08d40c3d2417	\N
e8c81f00-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:05.328	2018-11-18 13:15:05.328	t	t	e8c5ae00-eaf0-11e8-a812-08d40c3d2417	\N
ffa47a20-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:43.682	2018-11-18 13:15:43.682	t	t	ffa404f0-eaf0-11e8-a812-08d40c3d2417	\N
1548f180-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:16:19.992	2018-11-18 13:16:19.992	t	t	15468080-eaf1-11e8-a812-08d40c3d2417	\N
2d8ec7b0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:17:00.715	2018-11-18 13:17:00.715	t	t	2d8e7990-eaf1-11e8-a812-08d40c3d2417	\N
52ee0a71-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:03.415	2018-11-18 13:18:03.415	t	t	52ee0a70-eaf1-11e8-a812-08d40c3d2417	\N
6a8b4490-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:43.033	2018-11-18 13:18:43.033	t	t	6a8af670-eaf1-11e8-a812-08d40c3d2417	\N
7e12cf60-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:15.798	2018-11-18 13:19:15.798	t	t	7e128140-eaf1-11e8-a812-08d40c3d2417	\N
94fd0d31-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:54.243	2018-11-18 13:19:54.243	t	t	94fd0d30-eaf1-11e8-a812-08d40c3d2417	\N
ae5cb7d0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:20:36.813	2018-11-18 13:20:36.813	t	t	ae5c69b0-eaf1-11e8-a812-08d40c3d2417	\N
c63c7930-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:16.867	2018-11-18 13:21:16.867	t	t	c63c2b10-eaf1-11e8-a812-08d40c3d2417	\N
dc653bc0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:54.044	2018-11-18 13:21:54.044	t	t	dc62cac0-eaf1-11e8-a812-08d40c3d2417	\N
027271c0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:22:57.884	2018-11-18 13:22:57.884	t	t	0271d580-eaf2-11e8-a812-08d40c3d2417	\N
23119460-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:23:52.614	2018-11-18 13:23:52.614	t	t	23114640-eaf2-11e8-a812-08d40c3d2417	\N
45f32cf0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:24:51.135	2018-11-18 13:24:51.135	t	t	45f2ded0-eaf2-11e8-a812-08d40c3d2417	\N
5ffb9ab1-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:25:34.811	2018-11-18 13:25:34.811	t	t	5ffb9ab0-eaf2-11e8-a812-08d40c3d2417	\N
799da580-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:17.816	2018-11-18 13:26:17.816	t	t	799d3050-eaf2-11e8-a812-08d40c3d2417	\N
90a94e00-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:56.48	2018-11-18 13:26:56.48	t	t	90a70410-eaf2-11e8-a812-08d40c3d2417	\N
e20c75a0-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:22.522	2018-11-18 13:36:22.522	t	t	e20570c0-eaf3-11e8-a812-08d40c3d2417	\N
ead96b70-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:37.287	2018-11-18 13:36:37.287	t	t	ead91d50-eaf3-11e8-a812-08d40c3d2417	\N
f44cda70-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:53.143	2018-11-18 13:36:53.143	t	t	f44c8c50-eaf3-11e8-a812-08d40c3d2417	\N
fdeed380-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:37:09.304	2018-11-18 13:37:09.304	t	t	fdee5e50-eaf3-11e8-a812-08d40c3d2417	\N
06f8f960-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:24.47	2018-11-18 13:37:24.47	t	t	06f88430-eaf4-11e8-a812-08d40c3d2417	\N
12610c70-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:43.607	2018-11-18 13:37:43.607	t	t	1260be50-eaf4-11e8-a812-08d40c3d2417	\N
1e758c20-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:03.874	2018-11-18 13:38:03.874	t	t	1e74efe0-eaf4-11e8-a812-08d40c3d2417	\N
2344c770-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:11.943	2018-11-18 13:38:11.943	t	t	23445240-eaf4-11e8-a812-08d40c3d2417	\N
2de0b0e0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:29.742	2018-11-18 13:38:29.742	t	t	2de062c0-eaf4-11e8-a812-08d40c3d2417	\N
3620a8f0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:43.583	2018-11-18 13:38:43.583	t	t	362033c0-eaf4-11e8-a812-08d40c3d2417	\N
3e3c2910-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:57.185	2018-11-18 13:38:57.185	t	t	3e3b65c0-eaf4-11e8-a812-08d40c3d2417	\N
497a1ee0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:16.046	2018-11-18 13:39:16.046	t	t	4979d0c0-eaf4-11e8-a812-08d40c3d2417	\N
5418ee80-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:33.864	2018-11-18 13:39:33.864	t	t	5418a060-eaf4-11e8-a812-08d40c3d2417	\N
6098da30-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:54.835	2018-11-18 13:39:54.835	t	t	6091ae40-eaf4-11e8-a812-08d40c3d2417	\N
6b52d2f0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:12.831	2018-11-18 13:40:12.831	t	t	6b525dc0-eaf4-11e8-a812-08d40c3d2417	\N
756ede00-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:29.792	2018-11-18 13:40:29.792	t	t	756e8fe0-eaf4-11e8-a812-08d40c3d2417	\N
83ae2cf0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:53.695	2018-11-18 13:40:53.695	t	t	83added0-eaf4-11e8-a812-08d40c3d2417	\N
97b2fe10-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:27.281	2018-11-18 13:41:27.281	t	t	97b288e0-eaf4-11e8-a812-08d40c3d2417	\N
a26359e0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:45.214	2018-11-18 13:41:45.214	t	t	a262e4b0-eaf4-11e8-a812-08d40c3d2417	\N
aa3c79d0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:58.381	2018-11-18 13:41:58.381	t	t	aa38a940-eaf4-11e8-a812-08d40c3d2417	\N
0d026cf0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:44:44.095	2018-11-18 13:44:44.095	t	t	0cfffbf0-eaf5-11e8-a812-08d40c3d2417	\N
239e63b1-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:45:22.027	2018-11-18 13:45:22.027	t	t	239e63b0-eaf5-11e8-a812-08d40c3d2417	\N
3e35cb00-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:46:06.64	2018-11-18 13:46:06.64	t	t	3e3555d0-eaf5-11e8-a812-08d40c3d2417	\N
5f6c2490-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:02.361	2018-11-18 13:47:02.361	t	t	5f6b8850-eaf5-11e8-a812-08d40c3d2417	\N
73e82180-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:36.728	2018-11-18 13:47:36.728	t	t	73e7fa70-eaf5-11e8-a812-08d40c3d2417	\N
8803fd11-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:10.465	2018-11-18 13:48:10.465	t	t	8803fd10-eaf5-11e8-a812-08d40c3d2417	\N
9d4063d0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:46.093	2018-11-18 13:48:46.093	t	t	9d3feea0-eaf5-11e8-a812-08d40c3d2417	\N
b7ff7760-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:49:30.966	2018-11-18 13:49:30.966	t	t	b7ff0230-eaf5-11e8-a812-08d40c3d2417	\N
cad08370-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:02.535	2018-11-18 13:50:02.535	t	t	cac22b90-eaf5-11e8-a812-08d40c3d2417	\N
e09999d0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:39.085	2018-11-18 13:50:39.085	t	t	e0983a40-eaf5-11e8-a812-08d40c3d2417	\N
022a9680-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:51:35.4	2018-11-18 13:51:35.4	t	t	0229d330-eaf6-11e8-a812-08d40c3d2417	\N
166ac2f0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:09.375	2018-11-18 13:52:09.375	t	t	166a74d0-eaf6-11e8-a812-08d40c3d2417	\N
2ad840f0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:43.647	2018-11-18 13:52:43.647	t	t	2ad7f2d0-eaf6-11e8-a812-08d40c3d2417	\N
3dcb53f0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:15.439	2018-11-18 13:53:15.439	t	t	3dc8e2f0-eaf6-11e8-a812-08d40c3d2417	\N
51b80931-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:48.867	2018-11-18 13:53:48.867	t	t	51b80930-eaf6-11e8-a812-08d40c3d2417	\N
6641e8d0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:23.325	2018-11-18 13:54:23.325	t	t	66419ab0-eaf6-11e8-a812-08d40c3d2417	\N
78389a70-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:53.463	2018-11-18 13:54:53.463	t	t	782b5400-eaf6-11e8-a812-08d40c3d2417	\N
8a4c9810-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:23.793	2018-11-18 13:55:23.793	t	t	8a4c22e0-eaf6-11e8-a812-08d40c3d2417	\N
9edc6b20-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:58.29	2018-11-18 13:55:58.29	t	t	9edb80c0-eaf6-11e8-a812-08d40c3d2417	\N
c25f73d0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:56:57.869	2018-11-18 13:56:57.869	t	t	c25e3b50-eaf6-11e8-a812-08d40c3d2417	\N
db363f60-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:57:39.542	2018-11-18 13:57:39.542	t	t	db35f140-eaf6-11e8-a812-08d40c3d2417	\N
ee7bdf30-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:58:11.875	2018-11-18 13:58:11.875	t	t	ee7b9110-eaf6-11e8-a812-08d40c3d2417	\N
032ef1b0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:58:46.603	2018-11-18 13:58:46.603	t	t	032ea390-eaf7-11e8-a812-08d40c3d2417	\N
178712f1-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:59:20.735	2018-11-18 13:59:20.735	t	t	178712f0-eaf7-11e8-a812-08d40c3d2417	\N
2fc63260-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:01.414	2018-11-18 14:00:01.414	t	t	2fc5bd30-eaf7-11e8-a812-08d40c3d2417	\N
438a02e0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:34.574	2018-11-18 14:00:34.574	t	t	4389b4c0-eaf7-11e8-a812-08d40c3d2417	\N
5abb82e0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:13.486	2018-11-18 14:01:13.486	t	t	5abb34c0-eaf7-11e8-a812-08d40c3d2417	\N
6d223460-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:44.358	2018-11-18 14:01:44.358	t	t	6d1fea70-eaf7-11e8-a812-08d40c3d2417	\N
7f9234b0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:15.291	2018-11-18 14:02:15.291	t	t	7f91e690-eaf7-11e8-a812-08d40c3d2417	\N
93614fd1-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:48.525	2018-11-18 14:02:48.525	t	t	93614fd0-eaf7-11e8-a812-08d40c3d2417	\N
d2339e21-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:04:33.922	2018-11-18 14:04:33.922	t	t	d2339e20-eaf7-11e8-a812-08d40c3d2417	\N
ef0eb3e0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:05:22.334	2018-11-18 14:05:22.334	t	t	ef0e65c0-eaf7-11e8-a812-08d40c3d2417	\N
09a18750-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:06.917	2018-11-18 14:06:06.917	t	t	09a0c400-eaf8-11e8-a812-08d40c3d2417	\N
28a04060-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:58.918	2018-11-18 14:06:58.918	t	t	289fcb30-eaf8-11e8-a812-08d40c3d2417	\N
3c272ef1-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:07:31.679	2018-11-18 14:07:31.679	t	t	3c272ef0-eaf8-11e8-a812-08d40c3d2417	\N
9d3f7210-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:10:14.577	2018-11-18 14:10:14.577	t	t	9d3d9d50-eaf8-11e8-a812-08d40c3d2417	\N
c234cf70-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:11:16.583	2018-11-18 14:11:16.583	t	t	c2348150-eaf8-11e8-a812-08d40c3d2417	\N
e3e38d50-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:13.093	2018-11-18 14:12:13.093	t	t	e3e33f30-eaf8-11e8-a812-08d40c3d2417	\N
fad56c40-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:51.588	2018-11-18 14:12:51.588	t	t	fad4f710-eaf8-11e8-a812-08d40c3d2417	\N
133c8610-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:13:32.529	2018-11-18 14:13:32.529	t	t	133c37f0-eaf9-11e8-a812-08d40c3d2417	\N
25d39660-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:03.718	2018-11-18 14:14:03.718	t	t	25d34840-eaf9-11e8-a812-08d40c3d2417	\N
3a4f4530-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:38.083	2018-11-18 14:14:38.083	t	t	3a4dbe90-eaf9-11e8-a812-08d40c3d2417	\N
509fdb10-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:15:15.521	2018-11-18 14:15:39.974	t	t	509f8cf0-eaf9-11e8-a812-08d40c3d2417	\N
800074f1-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:16:35.007	2018-11-18 14:16:35.007	t	t	800074f0-eaf9-11e8-a812-08d40c3d2417	\N
a1b8f6d0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:17:31.581	2018-11-18 14:17:31.581	t	t	a1b8a8b0-eaf9-11e8-a812-08d40c3d2417	\N
b8979be0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:18:09.95	2018-11-18 14:18:09.95	t	t	b89726b0-eaf9-11e8-a812-08d40c3d2417	\N
d71f9e50-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:01.173	2018-11-18 14:19:01.173	t	t	d71d2d50-eaf9-11e8-a812-08d40c3d2417	\N
eaf17890-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:34.425	2018-11-18 14:19:34.425	t	t	eaef2ea0-eaf9-11e8-a812-08d40c3d2417	\N
ffb4dec1-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:20:09.26	2018-11-18 14:20:09.26	t	t	ffb4dec0-eaf9-11e8-a812-08d40c3d2417	\N
14fbf3e0-eafa-11e8-a812-08d40c3d2417	2018-11-18 14:20:44.958	2018-11-18 14:20:44.958	t	t	14fba5c0-eafa-11e8-a812-08d40c3d2417	\N
\.


--
-- Data for Name: store_question_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.store_question_item (id, create_time, update_time, flag, status, question_id, title, is_answer) FROM stdin;
945342a0-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:12:28.49	2018-11-18 00:12:28.49	t	t	94500e50-ea83-11e8-a812-08d40c3d2417	对	t
94547b20-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:12:28.498	2018-11-18 00:12:28.498	t	t	94500e50-ea83-11e8-a812-08d40c3d2417	错	f
ec18be22-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:14:55.746	2018-11-18 00:14:55.746	t	t	ec18be20-ea83-11e8-a812-08d40c3d2417	对	t
ec18be23-ea83-11e8-a812-08d40c3d2417	2018-11-18 00:14:55.746	2018-11-18 00:14:55.746	t	t	ec18be20-ea83-11e8-a812-08d40c3d2417	错	f
0386f900-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:15:35.056	2018-11-18 00:15:35.056	t	t	0385c080-ea84-11e8-a812-08d40c3d2417	对	t
038ac990-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:15:35.081	2018-11-18 00:15:35.081	t	t	0385c080-ea84-11e8-a812-08d40c3d2417	错	f
1c845f60-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:16:16.982	2018-11-18 00:16:16.982	t	t	1c81ee60-ea84-11e8-a812-08d40c3d2417	对	f
1c84fba0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:16:16.986	2018-11-18 00:16:16.986	t	t	1c81ee60-ea84-11e8-a812-08d40c3d2417	错	t
36501241-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:00.26	2018-11-18 00:17:00.26	t	t	364f7600-ea84-11e8-a812-08d40c3d2417	对	t
36514ac0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:00.268	2018-11-18 00:17:00.268	t	t	364f7600-ea84-11e8-a812-08d40c3d2417	错	f
46602990-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:27.209	2018-11-18 00:17:27.209	t	t	465ef110-ea84-11e8-a812-08d40c3d2417	对	f
4660c5d0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:17:27.213	2018-11-18 00:17:27.213	t	t	465ef110-ea84-11e8-a812-08d40c3d2417	错	t
5ef57f51-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:08.453	2018-11-18 00:18:08.453	t	t	5ef4e310-ea84-11e8-a812-08d40c3d2417	对	f
5ef61b90-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:08.457	2018-11-18 00:18:08.457	t	t	5ef4e310-ea84-11e8-a812-08d40c3d2417	错	t
6f023b41-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:35.38	2018-11-18 00:18:35.38	t	t	6f019f00-ea84-11e8-a812-08d40c3d2417	对	t
6f02d780-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:18:35.384	2018-11-18 00:18:35.384	t	t	6f019f00-ea84-11e8-a812-08d40c3d2417	错	f
8208fd50-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:07.301	2018-11-18 00:19:07.301	t	t	82072890-ea84-11e8-a812-08d40c3d2417	对	f
82099990-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:07.305	2018-11-18 00:19:07.305	t	t	82072890-ea84-11e8-a812-08d40c3d2417	错	t
988006f0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:44.991	2018-11-18 00:19:44.991	t	t	98709da0-ea84-11e8-a812-08d40c3d2417	对	t
98818d90-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:19:45.001	2018-11-18 00:19:45.001	t	t	98709da0-ea84-11e8-a812-08d40c3d2417	错	f
b1c599e0-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:20:27.39	2018-11-18 00:20:27.39	t	t	b1c46160-ea84-11e8-a812-08d40c3d2417	对	t
b1c63620-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:20:27.394	2018-11-18 00:20:27.394	t	t	b1c46160-ea84-11e8-a812-08d40c3d2417	错	f
c6325491-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:01.657	2018-11-18 00:21:01.657	t	t	c630f500-ea84-11e8-a812-08d40c3d2417	对	f
c6336600-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:01.664	2018-11-18 00:21:01.664	t	t	c630f500-ea84-11e8-a812-08d40c3d2417	错	t
d7a41ec1-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:30.924	2018-11-18 00:21:30.924	t	t	d7a2e640-ea84-11e8-a812-08d40c3d2417	对	f
d7a4bb00-ea84-11e8-a812-08d40c3d2417	2018-11-18 00:21:30.928	2018-11-18 00:21:30.928	t	t	d7a2e640-ea84-11e8-a812-08d40c3d2417	错	t
02021140-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:22:42.004	2018-11-18 00:22:42.004	t	t	02017500-ea85-11e8-a812-08d40c3d2417	对	f
02021141-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:22:42.004	2018-11-18 00:22:42.004	t	t	02017500-ea85-11e8-a812-08d40c3d2417	错	t
15b95ea0-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:15.082	2018-11-18 00:23:15.082	t	t	15b82620-ea85-11e8-a812-08d40c3d2417	对	t
15ba9720-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:15.09	2018-11-18 00:23:15.09	t	t	15b82620-ea85-11e8-a812-08d40c3d2417	错	f
2783a910-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:44.929	2018-11-18 00:23:44.929	t	t	277fd880-ea85-11e8-a812-08d40c3d2417	对	f
27841e40-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:23:44.932	2018-11-18 00:23:44.932	t	t	277fd880-ea85-11e8-a812-08d40c3d2417	错	t
39a673c1-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:24:15.356	2018-11-18 00:24:15.356	t	t	39a5d780-ea85-11e8-a812-08d40c3d2417	对	f
39a7ac40-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:24:15.364	2018-11-18 00:24:15.364	t	t	39a5d780-ea85-11e8-a812-08d40c3d2417	错	t
58b09e80-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:07.432	2018-11-18 00:25:07.432	t	t	589f8780-ea85-11e8-a812-08d40c3d2417	对	f
58b13ac0-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:07.436	2018-11-18 00:25:07.436	t	t	589f8780-ea85-11e8-a812-08d40c3d2417	错	t
66ee3fc1-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:31.324	2018-11-18 00:25:31.324	t	t	66eda380-ea85-11e8-a812-08d40c3d2417	对	f
66eedc00-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:25:31.328	2018-11-18 00:25:31.328	t	t	66eda380-ea85-11e8-a812-08d40c3d2417	错	t
955892c1-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:26:49.196	2018-11-18 00:26:49.196	t	t	9557f680-ea85-11e8-a812-08d40c3d2417	对	f
95592f00-ea85-11e8-a812-08d40c3d2417	2018-11-18 00:26:49.2	2018-11-18 00:26:49.2	t	t	9557f680-ea85-11e8-a812-08d40c3d2417	错	t
219377f0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:30:44.463	2018-11-18 00:30:44.463	t	t	21923f70-ea86-11e8-a812-08d40c3d2417	应识别风险、并致力于消除所有风险。	f
2196ac40-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:30:44.484	2018-11-18 00:30:44.484	t	t	21923f70-ea86-11e8-a812-08d40c3d2417	最高管理者应促进对存在的风险和机遇的充分理解。	t
2196ac41-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:30:44.484	2018-11-18 00:30:44.484	t	t	21923f70-ea86-11e8-a812-08d40c3d2417	顾客的需求和期望是影响组织风险评估的唯一和最重要因素。	f
21974880-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:30:44.488	2018-11-18 00:30:44.488	t	t	21923f70-ea86-11e8-a812-08d40c3d2417	风险评估是操作层面的活动，最高管理者不必参与。	f
4612baf1-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:31:45.695	2018-11-18 00:31:45.695	t	t	4610e630-ea86-11e8-a812-08d40c3d2417	应对风险和机遇的措施	f
4613f370-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:31:45.703	2018-11-18 00:31:45.703	t	t	4610e630-ea86-11e8-a812-08d40c3d2417	如何将措施融入质量管理体系过程并实施	f
46148fb0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:31:45.707	2018-11-18 00:31:45.707	t	t	4610e630-ea86-11e8-a812-08d40c3d2417	如何评价这些措施的有效性	f
46152bf0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:31:45.711	2018-11-18 00:31:45.711	t	t	4610e630-ea86-11e8-a812-08d40c3d2417	变更的策划	t
61eb2dc1-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:32:32.412	2018-11-18 00:32:32.412	t	t	61ea9180-ea86-11e8-a812-08d40c3d2417	质量目标及其实现的策划	f
61ec6640-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:32:32.42	2018-11-18 00:32:32.42	t	t	61ea9180-ea86-11e8-a812-08d40c3d2417	改进应对风险	f
61ec6641-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:32:32.42	2018-11-18 00:32:32.42	t	t	61ea9180-ea86-11e8-a812-08d40c3d2417	制定质量方针	t
61ed9ec0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:32:32.428	2018-11-18 00:32:32.428	t	t	61ea9180-ea86-11e8-a812-08d40c3d2417	变更的策划	f
7a9d8160-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:33:13.846	2018-11-18 00:33:13.846	t	t	7a9c48e0-ea86-11e8-a812-08d40c3d2417	最高管理者应制定质量方针和质量目标	f
7a9ff260-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:33:13.862	2018-11-18 00:33:13.862	t	t	7a9c48e0-ea86-11e8-a812-08d40c3d2417	最高管理者应审批质量手册	f
7aa08ea0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:33:13.866	2018-11-18 00:33:13.866	t	t	7a9c48e0-ea86-11e8-a812-08d40c3d2417	最高管理者应支持其他管理者履行其相关领域的职责	t
7aa12ae0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:33:13.87	2018-11-18 00:33:13.87	t	t	7a9c48e0-ea86-11e8-a812-08d40c3d2417	最高管理者应合理授权相关人员为质量管理体系的有效性承担责任	f
9ebc7bf0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:14.447	2018-11-18 00:34:14.447	t	t	9ebbdfb0-ea86-11e8-a812-08d40c3d2417	员工高超技术	f
9ebd1830-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:14.451	2018-11-18 00:34:14.451	t	t	9ebbdfb0-ea86-11e8-a812-08d40c3d2417	员工对企业的贡献	f
9ebdb470-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:14.455	2018-11-18 00:34:14.455	t	t	9ebbdfb0-ea86-11e8-a812-08d40c3d2417	偏离质量管理体系要求的后果	t
9ebe50b0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:14.459	2018-11-18 00:34:14.459	t	t	9ebbdfb0-ea86-11e8-a812-08d40c3d2417	企业高质量高效益	f
b6ff1dd1-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:55.149	2018-11-18 00:34:55.149	t	t	b6fe8190-ea86-11e8-a812-08d40c3d2417	满足设计和开发输出	f
b6ffba10-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:55.153	2018-11-18 00:34:55.153	t	t	b6fe8190-ea86-11e8-a812-08d40c3d2417	满足设计和开发评审	f
b7005650-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:55.157	2018-11-18 00:34:55.157	t	t	b6fe8190-ea86-11e8-a812-08d40c3d2417	满足设计和开发的目的	t
b700f290-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:34:55.161	2018-11-18 00:34:55.161	t	t	b6fe8190-ea86-11e8-a812-08d40c3d2417	满足设计和开发控制	f
e0076b60-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:36:03.99	2018-11-18 00:36:03.99	t	t	e006cf20-ea86-11e8-a812-08d40c3d2417	适用的法律法规要求。	f
e0076b61-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:36:03.99	2018-11-18 00:36:03.99	t	t	e006cf20-ea86-11e8-a812-08d40c3d2417	产品说明书。	t
e008a3e0-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:36:03.998	2018-11-18 00:36:03.998	t	t	e006cf20-ea86-11e8-a812-08d40c3d2417	组织已经承诺实施的标准或行为准则。	f
e0094020-ea86-11e8-a812-08d40c3d2417	2018-11-18 00:36:04.002	2018-11-18 00:36:04.002	t	t	e006cf20-ea86-11e8-a812-08d40c3d2417	由于产品和服务的性质所导致的潜在失效后果。	f
0e720c81-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:37:21.864	2018-11-18 00:37:21.864	t	t	0e717040-ea87-11e8-a812-08d40c3d2417	外部供方提供的产品和服务拟融入组织的产品和服务中；	f
0e734500-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:37:21.872	2018-11-18 00:37:21.872	t	t	0e717040-ea87-11e8-a812-08d40c3d2417	外部供方代表组织直接向客户提供产品和服务；	f
0e734501-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:37:21.872	2018-11-18 00:37:21.872	t	t	0e717040-ea87-11e8-a812-08d40c3d2417	经组织决定由外部供方提供某一过程或过程的一部分。	f
0e76c770-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:37:21.895	2018-11-18 00:37:21.895	t	t	0e717040-ea87-11e8-a812-08d40c3d2417	外部供方提供的办公家具。	t
2be1e831-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:38:11.251	2018-11-18 00:38:11.251	t	t	2be14bf0-ea87-11e8-a812-08d40c3d2417	发放并使用	f
2be320b0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:38:11.259	2018-11-18 00:38:11.259	t	t	2be14bf0-ea87-11e8-a812-08d40c3d2417	标识并管理	t
2be320b1-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:38:11.259	2018-11-18 00:38:11.259	t	t	2be14bf0-ea87-11e8-a812-08d40c3d2417	授权并放行	f
2be45930-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:38:11.267	2018-11-18 00:38:11.267	t	t	2be14bf0-ea87-11e8-a812-08d40c3d2417	保持可读性	f
5d201bb1-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:39:33.867	2018-11-18 00:39:33.867	t	t	5d1ee330-ea87-11e8-a812-08d40c3d2417	本标准要求的	f
5d21f070-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:39:33.879	2018-11-18 00:39:33.879	t	t	5d1ee330-ea87-11e8-a812-08d40c3d2417	组织确定的为确保质量管理体系有效运行所需的	f
5d228cb0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:39:33.883	2018-11-18 00:39:33.883	t	t	5d1ee330-ea87-11e8-a812-08d40c3d2417	（A）+ （B）	t
5d2599f0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:39:33.903	2018-11-18 00:39:33.903	t	t	5d1ee330-ea87-11e8-a812-08d40c3d2417	以上都不对	f
778835a0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:40:18.17	2018-11-18 00:40:18.17	t	t	7786fd20-ea87-11e8-a812-08d40c3d2417	通常与顾客需求和期望是一致的，因此只要满足顾客需求和期望，其他方也可满足	f
7788d1e0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:40:18.174	2018-11-18 00:40:18.174	t	t	7786fd20-ea87-11e8-a812-08d40c3d2417	各相关方的需求和期望可作为对于持续满足顾客和法律法规要求的风险评估的输入	t
778a0a60-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:40:18.182	2018-11-18 00:40:18.182	t	t	7786fd20-ea87-11e8-a812-08d40c3d2417	当各方需求和期望有冲突时以顾客要求为准。	f
778bdf20-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:40:18.194	2018-11-18 00:40:18.194	t	t	7786fd20-ea87-11e8-a812-08d40c3d2417	以上都对。	f
9241caf0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:03.007	2018-11-18 00:41:03.007	t	t	92409270-ea87-11e8-a812-08d40c3d2417	智能化生产设备	f
92426730-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:03.011	2018-11-18 00:41:03.011	t	t	92409270-ea87-11e8-a812-08d40c3d2417	监视和测量资源	f
9244d830-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:03.027	2018-11-18 00:41:03.027	t	t	92409270-ea87-11e8-a812-08d40c3d2417	服务业网上采购	t
9244d831-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:03.027	2018-11-18 00:41:03.027	t	t	92409270-ea87-11e8-a812-08d40c3d2417	保安监控系统	f
b056e751-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:53.477	2018-11-18 00:41:53.477	t	t	b0547650-ea87-11e8-a812-08d40c3d2417	工作场所温度湿度	f
b056e752-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:53.477	2018-11-18 00:41:53.477	t	t	b0547650-ea87-11e8-a812-08d40c3d2417	半成品库的通风和防潮条件	f
b056e753-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:53.477	2018-11-18 00:41:53.477	t	t	b0547650-ea87-11e8-a812-08d40c3d2417	工作区域布置和合理性	f
b0595850-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:41:53.493	2018-11-18 00:41:53.493	t	t	b0547650-ea87-11e8-a812-08d40c3d2417	以上都是	t
c82a73b1-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:42:33.451	2018-11-18 00:42:33.451	t	t	c829d770-ea87-11e8-a812-08d40c3d2417	技术和文化	f
c82b0ff0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:42:33.455	2018-11-18 00:42:33.455	t	t	c829d770-ea87-11e8-a812-08d40c3d2417	市场和竞争	f
c82bac30-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:42:33.459	2018-11-18 00:42:33.459	t	t	c829d770-ea87-11e8-a812-08d40c3d2417	环境监测能力	t
c82ce4b0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:42:33.467	2018-11-18 00:42:33.467	t	t	c829d770-ea87-11e8-a812-08d40c3d2417	知识和绩效	f
ec718fb1-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:43:34.315	2018-11-18 00:43:34.315	t	t	ec70f370-ea87-11e8-a812-08d40c3d2417	产品标准	f
ec722bf0-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:43:34.319	2018-11-18 00:43:34.319	t	t	ec70f370-ea87-11e8-a812-08d40c3d2417	从失败和成功项目得到的经验教训	t
ec72c830-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:43:34.323	2018-11-18 00:43:34.323	t	t	ec70f370-ea87-11e8-a812-08d40c3d2417	学术交流	f
ec753930-ea87-11e8-a812-08d40c3d2417	2018-11-18 00:43:34.339	2018-11-18 00:43:34.339	t	t	ec70f370-ea87-11e8-a812-08d40c3d2417	专业会议	f
09022ef1-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:44:22.239	2018-11-18 00:44:22.239	t	t	090192b0-ea88-11e8-a812-08d40c3d2417	防止不合格品的发生	f
09053c30-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:44:22.259	2018-11-18 00:44:22.259	t	t	090192b0-ea88-11e8-a812-08d40c3d2417	防止类似不合格品的再次发生	f
0905d870-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:44:22.263	2018-11-18 00:44:22.263	t	t	090192b0-ea88-11e8-a812-08d40c3d2417	防止不合格输出的非预期使用	t
0905d871-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:44:22.263	2018-11-18 00:44:22.263	t	t	090192b0-ea88-11e8-a812-08d40c3d2417	防止不合格品的非预期使用	f
27f17eb0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:14.139	2018-11-18 00:45:14.139	t	t	27f0e270-ea88-11e8-a812-08d40c3d2417	2015版标准在对不符合进行处理和采取纠正措施后不必保持形成文件的信息	f
27f21af0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:14.143	2018-11-18 00:45:14.143	t	t	27f0e270-ea88-11e8-a812-08d40c3d2417	2015版标准在对不符合进行处理和采取纠正措施后不必保持形成文件的信息	f
27f48bf0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:14.159	2018-11-18 00:45:14.159	t	t	27f0e270-ea88-11e8-a812-08d40c3d2417	组织应保留形成文件的信息，作为纠正措施的结果的证据	t
27f48bf1-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:14.159	2018-11-18 00:45:14.159	t	t	27f0e270-ea88-11e8-a812-08d40c3d2417	以上全部	f
40bd4dc0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:55.74	2018-11-18 00:45:55.74	t	t	40bbee30-ea88-11e8-a812-08d40c3d2417	纠正	f
40bd4dc1-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:55.74	2018-11-18 00:45:55.74	t	t	40bbee30-ea88-11e8-a812-08d40c3d2417	不合格的影响	t
40bd4dc2-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:55.74	2018-11-18 00:45:55.74	t	t	40bbee30-ea88-11e8-a812-08d40c3d2417	预防措施	f
40bd4dc3-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:45:55.74	2018-11-18 00:45:55.74	t	t	40bbee30-ea88-11e8-a812-08d40c3d2417	组织规模	f
593c3551-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:46:36.837	2018-11-18 00:46:36.837	t	t	593b7200-ea88-11e8-a812-08d40c3d2417	组织应确定需要监视和测量的对象	f
593c3552-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:46:36.837	2018-11-18 00:46:36.837	t	t	593b7200-ea88-11e8-a812-08d40c3d2417	组织应确定实施监视和测量的时机	f
593c3553-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:46:36.837	2018-11-18 00:46:36.837	t	t	593b7200-ea88-11e8-a812-08d40c3d2417	组织应保存所有实施监视和测量活动形成文件的信息	t
593e7f40-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:46:36.852	2018-11-18 00:46:36.852	t	t	593b7200-ea88-11e8-a812-08d40c3d2417	组织应确定适用的监视、测量、分析和评价方法以确保结果有效	f
6e359fa1-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:47:12.026	2018-11-18 00:47:12.026	t	t	6e350360-ea88-11e8-a812-08d40c3d2417	过程运行中使用适宜的基础设施和环境；	f
6e363be0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:47:12.03	2018-11-18 00:47:12.03	t	t	6e350360-ea88-11e8-a812-08d40c3d2417	任命具备能力的人员，包括任何必要的资格；	f
6e36d820-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:47:12.034	2018-11-18 00:47:12.034	t	t	6e350360-ea88-11e8-a812-08d40c3d2417	当过程的输出不能通过后续的监测或测量加以验证时，对其满足生产和服务提供过程策划结果的能力进行确认及阶段性再确认；	f
6e394920-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:47:12.05	2018-11-18 00:47:12.05	t	t	6e350360-ea88-11e8-a812-08d40c3d2417	采取措施防止人为错误。	t
8f39ecb1-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:07.419	2018-11-18 00:48:07.419	t	t	8f395070-ea88-11e8-a812-08d40c3d2417	以顾客为关注焦点。	f
8f3a88f0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:07.423	2018-11-18 00:48:07.423	t	t	8f395070-ea88-11e8-a812-08d40c3d2417	管理的系统方法。	t
8f3bc170-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:07.431	2018-11-18 00:48:07.431	t	t	8f395070-ea88-11e8-a812-08d40c3d2417	领导作用。	f
8f3bc171-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:07.431	2018-11-18 00:48:07.431	t	t	8f395070-ea88-11e8-a812-08d40c3d2417	持续改进。	f
a3a63230-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:41.683	2018-11-18 00:48:41.683	t	t	a39edf30-ea88-11e8-a812-08d40c3d2417	改进产品和服务以满足要求	f
a3aa02c0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:41.708	2018-11-18 00:48:41.708	t	t	a39edf30-ea88-11e8-a812-08d40c3d2417	纠正、预防或减少不利影响	f
a3aebdb0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:41.739	2018-11-18 00:48:41.739	t	t	a39edf30-ea88-11e8-a812-08d40c3d2417	改进质量管理体系的绩效和有效性	f
a3aebdb1-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:48:41.739	2018-11-18 00:48:41.739	t	t	a39edf30-ea88-11e8-a812-08d40c3d2417	以上全部	t
c13aace0-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:49:31.31	2018-11-18 00:49:31.31	t	t	c1397460-ea88-11e8-a812-08d40c3d2417	应评价质量管理体系的绩效	f
c13aace1-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:49:31.31	2018-11-18 00:49:31.31	t	t	c1397460-ea88-11e8-a812-08d40c3d2417	应评价质量管理体系有效性	f
c13aace2-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:49:31.31	2018-11-18 00:49:31.31	t	t	c1397460-ea88-11e8-a812-08d40c3d2417	质量管理体系评价的结果应保持形成文件的信息	f
c13aace3-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:49:31.31	2018-11-18 00:49:31.31	t	t	c1397460-ea88-11e8-a812-08d40c3d2417	以上都对	t
d52abd81-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:04.76	2018-11-18 00:50:04.76	t	t	d5284c80-ea88-11e8-a812-08d40c3d2417	顾客会晤	f
d52d5590-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:04.777	2018-11-18 00:50:04.777	t	t	d5284c80-ea88-11e8-a812-08d40c3d2417	顾客赞扬	f
d52d5591-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:04.777	2018-11-18 00:50:04.777	t	t	d5284c80-ea88-11e8-a812-08d40c3d2417	担保索赔	f
d52e8e10-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:04.785	2018-11-18 00:50:04.785	t	t	d5284c80-ea88-11e8-a812-08d40c3d2417	以上全是	t
efddea31-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:49.555	2018-11-18 00:50:49.555	t	t	efdd4df0-ea88-11e8-a812-08d40c3d2417	符合性、实施性和有效性	f
efde8670-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:49.559	2018-11-18 00:50:49.559	t	t	efdd4df0-ea88-11e8-a812-08d40c3d2417	符合性、充分性和有效性	f
efe05b30-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:49.571	2018-11-18 00:50:49.571	t	t	efdd4df0-ea88-11e8-a812-08d40c3d2417	适宜性、充分性和有效性	t
efe0f770-ea88-11e8-a812-08d40c3d2417	2018-11-18 00:50:49.575	2018-11-18 00:50:49.575	t	t	efdd4df0-ea88-11e8-a812-08d40c3d2417	适宜性、实施性和有效性	f
0781b400-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:51:29.216	2018-11-18 00:51:29.216	t	t	07807b80-ea89-11e8-a812-08d40c3d2417	应对的有产品作好标识，以免混淆	f
0781b401-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:51:29.216	2018-11-18 00:51:29.216	t	t	07807b80-ea89-11e8-a812-08d40c3d2417	在生产和服务提供的全过程，应标识产品的监视和测量状态	t
07825040-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:51:29.22	2018-11-18 00:51:29.22	t	t	07807b80-ea89-11e8-a812-08d40c3d2417	应控制所有产品的唯一性标识	f
0784c140-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:51:29.236	2018-11-18 00:51:29.236	t	t	07807b80-ea89-11e8-a812-08d40c3d2417	以上都对	f
1df78521-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:06.898	2018-11-18 00:52:06.898	t	t	1df6e8e0-ea89-11e8-a812-08d40c3d2417	来料加工的原材料、半成品	f
1df82160-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:06.902	2018-11-18 00:52:06.902	t	t	1df6e8e0-ea89-11e8-a812-08d40c3d2417	顾客委托运输的货物	f
1dfab970-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:06.919	2018-11-18 00:52:06.919	t	t	1df6e8e0-ea89-11e8-a812-08d40c3d2417	顾客提供的设备、知识产权	f
1dfab971-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:06.919	2018-11-18 00:52:06.919	t	t	1df6e8e0-ea89-11e8-a812-08d40c3d2417	以上都是	f
3262b931-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:41.155	2018-11-18 00:52:41.155	t	t	32621cf0-ea89-11e8-a812-08d40c3d2417	成品	f
32635570-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:41.159	2018-11-18 00:52:41.159	t	t	32621cf0-ea89-11e8-a812-08d40c3d2417	半成品	f
3263f1b0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:41.163	2018-11-18 00:52:41.163	t	t	32621cf0-ea89-11e8-a812-08d40c3d2417	原材料	f
32648df0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:52:41.167	2018-11-18 00:52:41.167	t	t	32621cf0-ea89-11e8-a812-08d40c3d2417	以上全部	t
523934a1-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:53:34.57	2018-11-18 00:53:34.57	t	t	52389860-ea89-11e8-a812-08d40c3d2417	质量管理体系的绩效和有效性	f
5239d0e0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:53:34.574	2018-11-18 00:53:34.574	t	t	52389860-ea89-11e8-a812-08d40c3d2417	策划是否得到有效实施	f
523b0960-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:53:34.582	2018-11-18 00:53:34.582	t	t	52389860-ea89-11e8-a812-08d40c3d2417	针对风险和机遇所采取措施的有效性	f
523c41e0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:53:34.59	2018-11-18 00:53:34.59	t	t	52389860-ea89-11e8-a812-08d40c3d2417	以上都是	t
699b88a1-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:54:13.802	2018-11-18 00:54:13.802	t	t	699aec60-ea89-11e8-a812-08d40c3d2417	确保文件的充分性与适宜性	t
699cc120-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:54:13.81	2018-11-18 00:54:13.81	t	t	699aec60-ea89-11e8-a812-08d40c3d2417	使文件保持清晰易于识别	f
699cc121-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:54:13.81	2018-11-18 00:54:13.81	t	t	699aec60-ea89-11e8-a812-08d40c3d2417	确保文件能够及时发放	f
69a06aa0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:54:13.834	2018-11-18 00:54:13.834	t	t	699aec60-ea89-11e8-a812-08d40c3d2417	以上全部	f
adeeaf00-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:08.432	2018-11-18 00:56:08.432	t	t	adedebb0-ea89-11e8-a812-08d40c3d2417	保障质量管理体系实现期望的结果；	t
adeefd20-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:08.434	2018-11-18 00:56:08.434	t	t	adedebb0-ea89-11e8-a812-08d40c3d2417	增强理想的效果；	t
adf1bc40-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:08.452	2018-11-18 00:56:08.452	t	t	adedebb0-ea89-11e8-a812-08d40c3d2417	预防或减少非预期的影响；	t
adf20a60-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:08.454	2018-11-18 00:56:08.454	t	t	adedebb0-ea89-11e8-a812-08d40c3d2417	实现改进。	t
c8358550-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:52.517	2018-11-18 00:56:52.517	t	t	c834c200-ea89-11e8-a812-08d40c3d2417	最高管理者应任命管理者代表负责质量体系相关工作。	f
c835d370-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:52.519	2018-11-18 00:56:52.519	t	t	c834c200-ea89-11e8-a812-08d40c3d2417	最高管理者应确保相关角色的职责和权限在整个组织得到规定、沟通和理解。	t
c836bdd0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:52.525	2018-11-18 00:56:52.525	t	t	c834c200-ea89-11e8-a812-08d40c3d2417	最高管理者应规定职责和权限以确保在整个组织提高以顾客为关注焦点的意识。	t
c8397cf0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:56:52.543	2018-11-18 00:56:52.543	t	t	c834c200-ea89-11e8-a812-08d40c3d2417	最高管理者应规定职责和权限以确保对质量管理体系的变更进行策划和实施时，保持质量管理体系的完整性。	t
ef470bf0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:57:58.063	2018-11-18 00:57:58.063	t	t	e4ecbf60-ea89-11e8-a812-08d40c3d2417	如本标准的要求在确定的范围内适用，组织应采用本标准的所有要求。 	t
ef470bf1-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:57:58.063	2018-11-18 00:57:58.063	t	t	e4ecbf60-ea89-11e8-a812-08d40c3d2417	范围应说明质量管理体系所覆盖的产品和服务。	t
ef470bf2-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:57:58.063	2018-11-18 00:57:58.063	t	t	e4ecbf60-ea89-11e8-a812-08d40c3d2417	范围应对组织确定不适用于管理体系范围的本标准的要求说明正当理由。	t
ef4955e0-ea89-11e8-a812-08d40c3d2417	2018-11-18 00:57:58.078	2018-11-18 00:57:58.078	t	t	e4ecbf60-ea89-11e8-a812-08d40c3d2417	当被确定为不适用的要求不影响组织确保产品和服务的符合性以及增强顾客满意的能力或责任时，才能声称符合本标准的要求。	t
1405f000-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:58:59.712	2018-11-18 00:58:59.712	t	t	14052cb0-ea8a-11e8-a812-08d40c3d2417	图纸、产品规范、材料规范、测试要求	t
14063e20-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:58:59.714	2018-11-18 00:58:59.714	t	t	14052cb0-ea8a-11e8-a812-08d40c3d2417	过程规范、必要的生产设备细节	t
140776a0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:58:59.722	2018-11-18 00:58:59.722	t	t	14052cb0-ea8a-11e8-a812-08d40c3d2417	建筑计划和工艺计算	t
1407c4c0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:58:59.724	2018-11-18 00:58:59.724	t	t	14052cb0-ea8a-11e8-a812-08d40c3d2417	菜单、食谱、烹饪方法、服务手册	t
2a6b6d70-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:59:37.287	2018-11-18 00:59:37.287	t	t	2a6a8310-ea8a-11e8-a812-08d40c3d2417	所提供的产品、过程和服务。	t
2a6bbb90-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:59:37.289	2018-11-18 00:59:37.289	t	t	2a6a8310-ea8a-11e8-a812-08d40c3d2417	能力，包括所要求的人员资质。	t
2a6c7ee0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:59:37.294	2018-11-18 00:59:37.294	t	t	2a6a8310-ea8a-11e8-a812-08d40c3d2417	产品和服务放行的批准。	t
2a6ccd00-ea8a-11e8-a812-08d40c3d2417	2018-11-18 00:59:37.296	2018-11-18 00:59:37.296	t	t	2a6a8310-ea8a-11e8-a812-08d40c3d2417	拟在外部供方现场实施的验证或确认活动。	t
44720670-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:00:20.951	2018-11-18 01:00:20.951	t	t	44711c10-ea8a-11e8-a812-08d40c3d2417	媒体的类型	f
4472c9c0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:00:20.956	2018-11-18 01:00:20.956	t	t	44711c10-ea8a-11e8-a812-08d40c3d2417	组织的规模	t
44742950-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:00:20.965	2018-11-18 01:00:20.965	t	t	44711c10-ea8a-11e8-a812-08d40c3d2417	过程及其相互作用的复杂程度	t
44747770-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:00:20.967	2018-11-18 01:00:20.967	t	t	44711c10-ea8a-11e8-a812-08d40c3d2417	人员的能力	t
5e00d760-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:03.83	2018-11-18 01:01:03.83	t	t	5dffed00-ea8a-11e8-a812-08d40c3d2417	社会因素;	t
5e012580-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:03.832	2018-11-18 01:01:03.832	t	t	5dffed00-ea8a-11e8-a812-08d40c3d2417	心理因素	t
5e025e00-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:03.84	2018-11-18 01:01:03.84	t	t	5dffed00-ea8a-11e8-a812-08d40c3d2417	物理因素	t
5e03bd90-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:03.849	2018-11-18 01:01:03.849	t	t	5dffed00-ea8a-11e8-a812-08d40c3d2417	经济因素	f
73c64440-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:40.356	2018-11-18 01:01:40.356	t	t	73c580f0-ea8a-11e8-a812-08d40c3d2417	减轻压力	t
73c6e080-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:40.36	2018-11-18 01:01:40.36	t	t	73c580f0-ea8a-11e8-a812-08d40c3d2417	预防职业倦怠	t
73c72ea0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:40.362	2018-11-18 01:01:40.362	t	t	73c580f0-ea8a-11e8-a812-08d40c3d2417	情感保护	t
73c84010-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:01:40.369	2018-11-18 01:01:40.369	t	t	73c580f0-ea8a-11e8-a812-08d40c3d2417	安宁	f
8b9033b0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:02:20.267	2018-11-18 01:02:20.267	t	t	8b7f6ad0-ea8a-11e8-a812-08d40c3d2417	组织的价值	t
8b96c360-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:02:20.31	2018-11-18 01:02:20.31	t	t	8b7f6ad0-ea8a-11e8-a812-08d40c3d2417	文化知识	t
8b9a1ec0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:02:20.332	2018-11-18 01:02:20.332	t	t	8b7f6ad0-ea8a-11e8-a812-08d40c3d2417	管理绩效	t
8b9a6ce0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:02:20.334	2018-11-18 01:02:20.334	t	t	8b7f6ad0-ea8a-11e8-a812-08d40c3d2417	法律法规	f
b0ae75d0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:03:22.541	2018-11-18 01:03:22.541	t	t	b0add990-ea8a-11e8-a812-08d40c3d2417	标准	t
b0b3f410-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:03:22.577	2018-11-18 01:03:22.577	t	t	b0add990-ea8a-11e8-a812-08d40c3d2417	学术交流、会议	t
b0b44230-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:03:22.579	2018-11-18 01:03:22.579	t	t	b0add990-ea8a-11e8-a812-08d40c3d2417	从顾客和供方收集的知识	t
b0b49050-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:03:22.581	2018-11-18 01:03:22.581	t	t	b0add990-ea8a-11e8-a812-08d40c3d2417	知识产权	f
c8480670-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:02.135	2018-11-18 01:04:02.135	t	t	c8474320-ea8a-11e8-a812-08d40c3d2417	造成不符合责任人	f
c8485490-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:02.137	2018-11-18 01:04:02.137	t	t	c8474320-ea8a-11e8-a812-08d40c3d2417	不合格性质	t
c84917e0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:02.142	2018-11-18 01:04:02.142	t	t	c8474320-ea8a-11e8-a812-08d40c3d2417	针对不符合采取的后续措施	t
c84a9e80-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:02.152	2018-11-18 01:04:02.152	t	t	c8474320-ea8a-11e8-a812-08d40c3d2417	纠正措施的后果	t
e3b05250-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:48.117	2018-11-18 01:04:48.117	t	t	e3af8f00-ea8a-11e8-a812-08d40c3d2417	顾客满意	t
e3b0ee90-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:48.121	2018-11-18 01:04:48.121	t	t	e3af8f00-ea8a-11e8-a812-08d40c3d2417	风险和机会的应对措施的有效性	t
e3b1d8f0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:48.127	2018-11-18 01:04:48.127	t	t	e3af8f00-ea8a-11e8-a812-08d40c3d2417	外部提供方的绩效	t
e3b4e630-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:04:48.147	2018-11-18 01:04:48.147	t	t	e3af8f00-ea8a-11e8-a812-08d40c3d2417	质量管理体系绩效，有效性和改进的需求	t
fe8f7100-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:05:33.2	2018-11-18 01:05:33.2	t	t	fe8eadb0-ea8a-11e8-a812-08d40c3d2417	在需要维修的电冰箱上完成的活动	t
fe900d40-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:05:33.204	2018-11-18 01:05:33.204	t	t	fe8eadb0-ea8a-11e8-a812-08d40c3d2417	为顾客准备纳税申报单所需要的损益表	t
fe90d090-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:05:33.209	2018-11-18 01:05:33.209	t	t	fe8eadb0-ea8a-11e8-a812-08d40c3d2417	为顾客定制服装	t
fe9145c0-ea8a-11e8-a812-08d40c3d2417	2018-11-18 01:05:33.212	2018-11-18 01:05:33.212	t	t	fe8eadb0-ea8a-11e8-a812-08d40c3d2417	评价服务质量	f
2a7d2b42-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:06:46.9	2018-11-18 01:06:46.9	t	t	2a7d2b40-ea8b-11e8-a812-08d40c3d2417	法律法规要求；	t
2a7d2b43-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:06:46.9	2018-11-18 01:06:46.9	t	t	2a7d2b40-ea8b-11e8-a812-08d40c3d2417	产品和服务的潜在非预期结果；	t
2a7d2b44-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:06:46.9	2018-11-18 01:06:46.9	t	t	2a7d2b40-ea8b-11e8-a812-08d40c3d2417	产品和服务的特性、使用及预期的生命周期；	t
2a7f9c40-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:06:46.916	2018-11-18 01:06:46.916	t	t	2a7d2b40-ea8b-11e8-a812-08d40c3d2417	顾客要求；	t
2a7f9c41-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:06:46.916	2018-11-18 01:06:46.916	t	t	2a7d2b40-ea8b-11e8-a812-08d40c3d2417	顾客反馈。	t
85ea2af0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:20.288	2018-11-18 01:09:20.288	t	t	85e43780-ea8b-11e8-a812-08d40c3d2417	提供有关产品和服务的信息	t
85ee97c0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:20.316	2018-11-18 01:09:20.316	t	t	85e43780-ea8b-11e8-a812-08d40c3d2417	处理问询、合同或订单，包括变更	t
85ef0cf0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:20.319	2018-11-18 01:09:20.319	t	t	85e43780-ea8b-11e8-a812-08d40c3d2417	获取有关产品和服务的顾客反馈，包括顾客抱怨	t
85f8d0f0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:20.383	2018-11-18 01:09:20.383	t	t	85e43780-ea8b-11e8-a812-08d40c3d2417	处置或控制顾客财产	t
9c1fe5d0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:57.549	2018-11-18 01:09:57.549	t	t	9c1f2280-ea8b-11e8-a812-08d40c3d2417	顾客规定的要求	t
9c205b00-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:57.552	2018-11-18 01:09:57.552	t	t	9c1f2280-ea8b-11e8-a812-08d40c3d2417	产品的包装要求	f
9c216c70-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:57.559	2018-11-18 01:09:57.559	t	t	9c1f2280-ea8b-11e8-a812-08d40c3d2417	隐含的要求	t
9c21e1a0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:09:57.562	2018-11-18 01:09:57.562	t	t	9c1f2280-ea8b-11e8-a812-08d40c3d2417	法规	f
b1052be0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:10:32.606	2018-11-18 01:10:32.606	t	t	b1046890-ea8b-11e8-a812-08d40c3d2417	担保条款规定的措施	t
b1066460-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:10:32.614	2018-11-18 01:10:32.614	t	t	b1046890-ea8b-11e8-a812-08d40c3d2417	合同义务(例如，维护服务)	t
b106d990-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:10:32.617	2018-11-18 01:10:32.617	t	t	b1046890-ea8b-11e8-a812-08d40c3d2417	附加服务(例如，回收或最终处置)	t
b108d560-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:10:32.63	2018-11-18 01:10:32.63	t	t	b1046890-ea8b-11e8-a812-08d40c3d2417	合同评审	f
ccd7f960-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:11:19.286	2018-11-18 01:11:19.286	t	t	ccd70f00-ea8b-11e8-a812-08d40c3d2417	向顾客或外部供方报告	t
ccda1c40-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:11:19.3	2018-11-18 01:11:19.3	t	t	ccd70f00-ea8b-11e8-a812-08d40c3d2417	赔偿	f
ccda6a60-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:11:19.302	2018-11-18 01:11:19.302	t	t	ccd70f00-ea8b-11e8-a812-08d40c3d2417	保留相关形成文件的信息	t
ccdab880-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:11:19.304	2018-11-18 01:11:19.304	t	t	ccd70f00-ea8b-11e8-a812-08d40c3d2417	采取纠正措施	f
ec68e050-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:12:12.245	2018-11-18 01:12:12.245	t	t	ec67f5f0-ea8b-11e8-a812-08d40c3d2417	有关质量管理体系绩效和有效性的信息	t
ec690760-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:12:12.246	2018-11-18 01:12:12.246	t	t	ec67f5f0-ea8b-11e8-a812-08d40c3d2417	资源的充分性	t
ec69f1c0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:12:12.252	2018-11-18 01:12:12.252	t	t	ec67f5f0-ea8b-11e8-a812-08d40c3d2417	应对风险和机遇所采取措施的有效性	t
ec6a3fe0-ea8b-11e8-a812-08d40c3d2417	2018-11-18 01:12:12.254	2018-11-18 01:12:12.254	t	t	ec67f5f0-ea8b-11e8-a812-08d40c3d2417	改进的机会	f
055ecca0-ea8c-11e8-a812-08d40c3d2417	2018-11-18 01:12:54.122	2018-11-18 01:12:54.122	t	t	055e0950-ea8c-11e8-a812-08d40c3d2417	所提供的过程、产品和服务的要求	t
055f8ff0-ea8c-11e8-a812-08d40c3d2417	2018-11-18 01:12:54.127	2018-11-18 01:12:54.127	t	t	055e0950-ea8c-11e8-a812-08d40c3d2417	对供方人员能力的要求	t
055fde10-ea8c-11e8-a812-08d40c3d2417	2018-11-18 01:12:54.129	2018-11-18 01:12:54.129	t	t	055e0950-ea8c-11e8-a812-08d40c3d2417	对外部供方绩效的控制和监视要求	t
0560c870-ea8c-11e8-a812-08d40c3d2417	2018-11-18 01:12:54.135	2018-11-18 01:12:54.135	t	t	055e0950-ea8c-11e8-a812-08d40c3d2417	组织或其顾客拟在外部供方现场实施的验证或确认活动	t
7c281430-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:31:50.131	2018-11-18 11:31:50.131	t	t	7c2702c0-eae2-11e8-a812-08d40c3d2417	对	t
7c286250-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:31:50.133	2018-11-18 11:31:50.133	t	t	7c2702c0-eae2-11e8-a812-08d40c3d2417	错	f
911597a2-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:25.242	2018-11-18 11:32:25.242	t	t	911597a0-eae2-11e8-a812-08d40c3d2417	对	t
911597a3-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:25.242	2018-11-18 11:32:25.242	t	t	911597a0-eae2-11e8-a812-08d40c3d2417	错	f
9cbb28e0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:44.782	2018-11-18 11:32:44.782	t	t	9cba8ca0-eae2-11e8-a812-08d40c3d2417	对	f
9cbc1340-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:32:44.788	2018-11-18 11:32:44.788	t	t	9cba8ca0-eae2-11e8-a812-08d40c3d2417	错	t
adcecd80-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:13.432	2018-11-18 11:33:13.432	t	t	adce3140-eae2-11e8-a812-08d40c3d2417	对	f
adcf1ba0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:13.434	2018-11-18 11:33:13.434	t	t	adce3140-eae2-11e8-a812-08d40c3d2417	错	t
bdae5ef0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:40.063	2018-11-18 11:33:40.063	t	t	bdadc2b0-eae2-11e8-a812-08d40c3d2417	对	f
bdaf9770-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:33:40.071	2018-11-18 11:33:40.071	t	t	bdadc2b0-eae2-11e8-a812-08d40c3d2417	错	t
c9ec3890-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:00.601	2018-11-18 11:34:00.601	t	t	c9eb7540-eae2-11e8-a812-08d40c3d2417	对	t
c9ec86b0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:00.603	2018-11-18 11:34:00.603	t	t	c9eb7540-eae2-11e8-a812-08d40c3d2417	错	f
d6fca470-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:22.519	2018-11-18 11:34:22.519	t	t	d6fc0830-eae2-11e8-a812-08d40c3d2417	对	f
d6fd19a0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:22.522	2018-11-18 11:34:22.522	t	t	d6fc0830-eae2-11e8-a812-08d40c3d2417	错	t
e503cc60-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:46.054	2018-11-18 11:34:46.054	t	t	e5030910-eae2-11e8-a812-08d40c3d2417	对	t
e5041a80-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:34:46.056	2018-11-18 11:34:46.056	t	t	e5030910-eae2-11e8-a812-08d40c3d2417	错	f
f2449710-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:08.289	2018-11-18 11:35:08.289	t	t	f243acb0-eae2-11e8-a812-08d40c3d2417	对	f
f2455a60-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:08.294	2018-11-18 11:35:08.294	t	t	f243acb0-eae2-11e8-a812-08d40c3d2417	错	t
fd4276a0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:26.73	2018-11-18 11:35:26.73	t	t	fd41da60-eae2-11e8-a812-08d40c3d2417	对	t
fd42ebd0-eae2-11e8-a812-08d40c3d2417	2018-11-18 11:35:26.733	2018-11-18 11:35:26.733	t	t	fd41da60-eae2-11e8-a812-08d40c3d2417	错	f
0930d0b0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:35:46.747	2018-11-18 11:35:46.747	t	t	09300d60-eae3-11e8-a812-08d40c3d2417	对	f
09311ed0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:35:46.749	2018-11-18 11:35:46.749	t	t	09300d60-eae3-11e8-a812-08d40c3d2417	错	t
1a723c10-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:15.697	2018-11-18 11:36:15.697	t	t	1a7151b0-eae3-11e8-a812-08d40c3d2417	对	f
1a72d850-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:15.701	2018-11-18 11:36:15.701	t	t	1a7151b0-eae3-11e8-a812-08d40c3d2417	错	t
23e2ebf0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:31.535	2018-11-18 11:36:31.535	t	t	23e24fb0-eae3-11e8-a812-08d40c3d2417	对	t
23e3af40-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:31.54	2018-11-18 11:36:31.54	t	t	23e24fb0-eae3-11e8-a812-08d40c3d2417	错	f
2e5f6680-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:49.128	2018-11-18 11:36:49.128	t	t	2e5e7c20-eae3-11e8-a812-08d40c3d2417	对	t
2e6029d0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:36:49.133	2018-11-18 11:36:49.133	t	t	2e5e7c20-eae3-11e8-a812-08d40c3d2417	错	f
388c1360-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:06.198	2018-11-18 11:37:06.198	t	t	388b9e30-eae3-11e8-a812-08d40c3d2417	对	f
388cafa0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:06.202	2018-11-18 11:37:06.202	t	t	388b9e30-eae3-11e8-a812-08d40c3d2417	错	t
471c8f90-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:30.633	2018-11-18 11:37:30.633	t	t	471ba530-eae3-11e8-a812-08d40c3d2417	对	t
471d52e0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:30.638	2018-11-18 11:37:30.638	t	t	471ba530-eae3-11e8-a812-08d40c3d2417	错	f
54899a60-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:53.158	2018-11-18 11:37:53.158	t	t	5488fe20-eae3-11e8-a812-08d40c3d2417	对	t
5489e880-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:37:53.16	2018-11-18 11:37:53.16	t	t	5488fe20-eae3-11e8-a812-08d40c3d2417	错	f
5f8b7190-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:38:11.625	2018-11-18 11:38:11.625	t	t	5f7af6d0-eae3-11e8-a812-08d40c3d2417	对	f
5f8b98a0-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:38:11.626	2018-11-18 11:38:11.626	t	t	5f7af6d0-eae3-11e8-a812-08d40c3d2417	错	t
7ef76b60-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:39:04.342	2018-11-18 11:39:04.342	t	t	713d2af0-eae3-11e8-a812-08d40c3d2417	对	t
7ef7e090-eae3-11e8-a812-08d40c3d2417	2018-11-18 11:39:04.345	2018-11-18 11:39:04.345	t	t	713d2af0-eae3-11e8-a812-08d40c3d2417	错	f
6a0fa8c0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:50:04.236	2018-11-18 12:50:04.236	t	t	d6e185e0-eae3-11e8-a812-08d40c3d2417	对	t
6a0fa8c1-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:50:04.236	2018-11-18 12:50:04.236	t	t	d6e185e0-eae3-11e8-a812-08d40c3d2417	错	f
b85cfa50-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:15.605	2018-11-18 12:52:15.605	t	t	b85be8e0-eaed-11e8-a812-08d40c3d2417	应对风险和机遇的措施	f
b86055b0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:15.627	2018-11-18 12:52:15.627	t	t	b85be8e0-eaed-11e8-a812-08d40c3d2417	如何将措施融入质量管理体系过程并实施	f
b860a3d0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:15.629	2018-11-18 12:52:15.629	t	t	b85be8e0-eaed-11e8-a812-08d40c3d2417	如何评价这些措施的有效性	f
b860f1f0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:15.631	2018-11-18 12:52:15.631	t	t	b85be8e0-eaed-11e8-a812-08d40c3d2417	变更的策划	t
d21b18a0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:58.794	2018-11-18 12:52:58.794	t	t	d21a7c60-eaed-11e8-a812-08d40c3d2417	组织	f
d21bb4e0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:58.798	2018-11-18 12:52:58.798	t	t	d21a7c60-eaed-11e8-a812-08d40c3d2417	顾客	f
d21cc650-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:58.805	2018-11-18 12:52:58.805	t	t	d21a7c60-eaed-11e8-a812-08d40c3d2417	组织或其顾客	t
d21d3b80-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:52:58.808	2018-11-18 12:52:58.808	t	t	d21a7c60-eaed-11e8-a812-08d40c3d2417	组织和其顾客	f
ead7cc81-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:53:40.296	2018-11-18 12:53:40.296	t	t	ead58290-eaed-11e8-a812-08d40c3d2417	质量目标及其实现的策划	f
ead7cc82-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:53:40.296	2018-11-18 12:53:40.296	t	t	ead58290-eaed-11e8-a812-08d40c3d2417	改进应对风险	f
ead7cc83-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:53:40.296	2018-11-18 12:53:40.296	t	t	ead58290-eaed-11e8-a812-08d40c3d2417	制定质量方针	t
eadb00d0-eaed-11e8-a812-08d40c3d2417	2018-11-18 12:53:40.317	2018-11-18 12:53:40.317	t	t	ead58290-eaed-11e8-a812-08d40c3d2417	变更的策划	f
0c706a50-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:54:36.661	2018-11-18 12:54:36.661	t	t	0c6b3a30-eaee-11e8-a812-08d40c3d2417	最高管理者应支持各职能管理者在自己职责范围内的领导作用	t
0c710690-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:54:36.665	2018-11-18 12:54:36.665	t	t	0c6b3a30-eaee-11e8-a812-08d40c3d2417	最高管理者应在各职能区域发挥其领导作用，各职能管理者应对此予以支持	f
0c7154b0-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:54:36.667	2018-11-18 12:54:36.667	t	t	0c6b3a30-eaee-11e8-a812-08d40c3d2417	最高管理者应为各管理职能区域设立管理者代表，以支持这些职能区域的质量管理体系	f
0c726620-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:54:36.674	2018-11-18 12:54:36.674	t	t	0c6b3a30-eaee-11e8-a812-08d40c3d2417	最高管理者应确保各职能区域分别建立质量方针	f
2351f590-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:15.049	2018-11-18 12:55:15.049	t	t	23513240-eaee-11e8-a812-08d40c3d2417	股票持有人	t
23521ca0-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:15.05	2018-11-18 12:55:15.05	t	t	23513240-eaee-11e8-a812-08d40c3d2417	文件资料管理人员	f
23521ca1-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:15.05	2018-11-18 12:55:15.05	t	t	23513240-eaee-11e8-a812-08d40c3d2417	售后服务人员	f
23521ca2-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:15.05	2018-11-18 12:55:15.05	t	t	23513240-eaee-11e8-a812-08d40c3d2417	产品的设计开发人员	f
3bff8e40-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:56.452	2018-11-18 12:55:56.452	t	t	3bff1910-eaee-11e8-a812-08d40c3d2417	适用的法律法规要求。	f
3c005190-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:56.457	2018-11-18 12:55:56.457	t	t	3bff1910-eaee-11e8-a812-08d40c3d2417	产品说明书。	t
3c03d400-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:56.48	2018-11-18 12:55:56.48	t	t	3bff1910-eaee-11e8-a812-08d40c3d2417	组织已经承诺实施的标准或行为准则。	f
3c042220-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:55:56.482	2018-11-18 12:55:56.482	t	t	3bff1910-eaee-11e8-a812-08d40c3d2417	由于产品和服务的性质所导致的潜在失效后果。	f
55bf0c20-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:56:39.65	2018-11-18 12:56:39.65	t	t	55be21c0-eaee-11e8-a812-08d40c3d2417	外部供方提供的产品和服务拟融入组织的产品和服务中；	f
55bf5a40-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:56:39.652	2018-11-18 12:56:39.652	t	t	55be21c0-eaee-11e8-a812-08d40c3d2417	外部供方代表组织直接向客户提供产品和服务；	f
55bfa860-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:56:39.654	2018-11-18 12:56:39.654	t	t	55be21c0-eaee-11e8-a812-08d40c3d2417	经组织决定由外部供方提供某一过程或过程的一部分。	f
55c092c0-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:56:39.66	2018-11-18 12:56:39.66	t	t	55be21c0-eaee-11e8-a812-08d40c3d2417	外部供方提供的办公家具。	t
77d73a31-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:57:36.851	2018-11-18 12:57:36.851	t	t	77d71320-eaee-11e8-a812-08d40c3d2417	本标准要求的	f
77d73a32-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:57:36.851	2018-11-18 12:57:36.851	t	t	77d71320-eaee-11e8-a812-08d40c3d2417	组织确定的为确保质量管理体系有效运行所需的	f
77d73a33-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:57:36.851	2018-11-18 12:57:36.851	t	t	77d71320-eaee-11e8-a812-08d40c3d2417	（A）+ （B)	t
77da9590-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:57:36.873	2018-11-18 12:57:36.873	t	t	77d71320-eaee-11e8-a812-08d40c3d2417	以上都不对	f
8dc8e731-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:13.667	2018-11-18 12:58:13.667	t	t	8dc87200-eaee-11e8-a812-08d40c3d2417	标识和说明（例如：标题、日期、作者、文件编号等）；	f
8dc8e732-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:13.667	2018-11-18 12:58:13.667	t	t	8dc87200-eaee-11e8-a812-08d40c3d2417	格式（例如：语言、软件版本、图示）和媒介（例如：纸质、电子）；	f
8dc8e733-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:13.667	2018-11-18 12:58:13.667	t	t	8dc87200-eaee-11e8-a812-08d40c3d2417	评审和批准以确保适宜性和充分性。	f
8dc8e734-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:13.667	2018-11-18 12:58:13.667	t	t	8dc87200-eaee-11e8-a812-08d40c3d2417	以上全部	t
a51cbc40-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:52.804	2018-11-18 12:58:52.804	t	t	a51bd1e0-eaee-11e8-a812-08d40c3d2417	他们通常与顾客需求和期望是一致的，因此只要满足顾客需求和期望，其他方也可满足。	f
a51d7f90-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:52.809	2018-11-18 12:58:52.809	t	t	a51bd1e0-eaee-11e8-a812-08d40c3d2417	各相关方的需求和期望可作为对于持续满足顾客和法律法规要求的风险评估的输入。	t
a51ff090-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:52.825	2018-11-18 12:58:52.825	t	t	a51bd1e0-eaee-11e8-a812-08d40c3d2417	当各方需求和期望有冲突时以顾客要求为准。	f
a5203eb0-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:58:52.827	2018-11-18 12:58:52.827	t	t	a51bd1e0-eaee-11e8-a812-08d40c3d2417	以上都对。	f
bbd93350-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:59:30.949	2018-11-18 12:59:30.949	t	t	bbd89710-eaee-11e8-a812-08d40c3d2417	工作场所温度湿度	f
bbd9a880-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:59:30.952	2018-11-18 12:59:30.952	t	t	bbd89710-eaee-11e8-a812-08d40c3d2417	半成品库的通风和防潮条件	f
bbd9cf90-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:59:30.953	2018-11-18 12:59:30.953	t	t	bbd89710-eaee-11e8-a812-08d40c3d2417	工作区域布置和合理性	f
bbdae100-eaee-11e8-a812-08d40c3d2417	2018-11-18 12:59:30.96	2018-11-18 12:59:30.96	t	t	bbd89710-eaee-11e8-a812-08d40c3d2417	以上都是	t
d04503a0-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:05.21	2018-11-18 13:00:05.21	t	t	d0446760-eaee-11e8-a812-08d40c3d2417	人力资源、组织知识；	f
d04503a1-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:05.21	2018-11-18 13:00:05.21	t	t	d0446760-eaee-11e8-a812-08d40c3d2417	基础设施和监视和测量资源；	f
d04503a2-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:05.21	2018-11-18 13:00:05.21	t	t	d0446760-eaee-11e8-a812-08d40c3d2417	过程环境；	f
d04503a3-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:05.21	2018-11-18 13:00:05.21	t	t	d0446760-eaee-11e8-a812-08d40c3d2417	（A）+（B）+（C）	t
e746c111-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:43.809	2018-11-18 13:00:43.809	t	t	e7469a00-eaee-11e8-a812-08d40c3d2417	知识产权和课程学习等方面的信息;	f
e746c112-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:43.809	2018-11-18 13:00:43.809	t	t	e7469a00-eaee-11e8-a812-08d40c3d2417	从失败和成功案例里学习;	f
e746c113-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:43.809	2018-11-18 13:00:43.809	t	t	e7469a00-eaee-11e8-a812-08d40c3d2417	在顾客或供方获得的信息;	f
e7493210-eaee-11e8-a812-08d40c3d2417	2018-11-18 13:00:43.825	2018-11-18 13:00:43.825	t	t	e7469a00-eaee-11e8-a812-08d40c3d2417	以上全部。	t
07221e80-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:01:37.256	2018-11-18 13:01:37.256	t	t	071f5f60-eaef-11e8-a812-08d40c3d2417	退回或停止供应产品和提供服务;	f
07268b50-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:01:37.285	2018-11-18 13:01:37.285	t	t	071f5f60-eaef-11e8-a812-08d40c3d2417	通知顾客；	f
0726d970-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:01:37.287	2018-11-18 13:01:37.287	t	t	071f5f60-eaef-11e8-a812-08d40c3d2417	经授权进行返修、降级、继续使用、放行；	f
072cf3f0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:01:37.327	2018-11-18 13:01:37.327	t	t	071f5f60-eaef-11e8-a812-08d40c3d2417	延长服务时间或重新提供服务。	t
1d86ffb0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:14.827	2018-11-18 13:02:14.827	t	t	1d863c60-eaef-11e8-a812-08d40c3d2417	产品交付前发生不合格品	f
1d879bf0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:14.831	2018-11-18 13:02:14.831	t	t	1d863c60-eaef-11e8-a812-08d40c3d2417	产品交付之后发现的不合格产品	f
1d885f40-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:14.836	2018-11-18 13:02:14.836	t	t	1d863c60-eaef-11e8-a812-08d40c3d2417	在服务提供期间或之后发现的不合格服务	f
1d88ad60-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:14.838	2018-11-18 13:02:14.838	t	t	1d863c60-eaef-11e8-a812-08d40c3d2417	以上都是	t
36c89b00-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:57.2	2018-11-18 13:02:57.2	t	t	36c7fec0-eaef-11e8-a812-08d40c3d2417	纠正	f
36c8e920-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:57.202	2018-11-18 13:02:57.202	t	t	36c7fec0-eaef-11e8-a812-08d40c3d2417	不合格的影响	t
36c9fa90-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:57.209	2018-11-18 13:02:57.209	t	t	36c7fec0-eaef-11e8-a812-08d40c3d2417	预防措施	f
36cc92a0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:02:57.226	2018-11-18 13:02:57.226	t	t	36c7fec0-eaef-11e8-a812-08d40c3d2417	组织规模	f
4c0fb020-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:03:32.898	2018-11-18 13:03:32.898	t	t	4c0f13e0-eaef-11e8-a812-08d40c3d2417	纠正，纠正措施	f
4c10e8a0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:03:32.906	2018-11-18 13:03:32.906	t	t	4c0f13e0-eaef-11e8-a812-08d40c3d2417	持续改进	f
4c1136c0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:03:32.908	2018-11-18 13:03:32.908	t	t	4c0f13e0-eaef-11e8-a812-08d40c3d2417	突变，创新和重组	f
4c122120-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:03:32.914	2018-11-18 13:03:32.914	t	t	4c0f13e0-eaef-11e8-a812-08d40c3d2417	以上均是	t
6426ae20-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:13.314	2018-11-18 13:04:13.314	t	t	64252780-eaef-11e8-a812-08d40c3d2417	分析和评价的输入来自监视和测量的输出	f
64277170-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:13.319	2018-11-18 13:04:13.319	t	t	64252780-eaef-11e8-a812-08d40c3d2417	分析和评价的结果可能发现改进的需求或机会	f
642834c0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:13.324	2018-11-18 13:04:13.324	t	t	64252780-eaef-11e8-a812-08d40c3d2417	进行数据分析应考虑使用统计技术	f
642882e0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:13.326	2018-11-18 13:04:13.326	t	t	64252780-eaef-11e8-a812-08d40c3d2417	以上都对	t
767f55e0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:44.094	2018-11-18 13:04:44.094	t	t	767e9290-eaef-11e8-a812-08d40c3d2417	符合性	f
7680b570-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:44.103	2018-11-18 13:04:44.103	t	t	767e9290-eaef-11e8-a812-08d40c3d2417	完整性	t
76821500-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:44.112	2018-11-18 13:04:44.112	t	t	767e9290-eaef-11e8-a812-08d40c3d2417	适宜性	f
76821501-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:04:44.112	2018-11-18 13:04:44.112	t	t	767e9290-eaef-11e8-a812-08d40c3d2417	充分性	f
8b19d750-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:18.661	2018-11-18 13:05:18.661	t	t	8b193b10-eaef-11e8-a812-08d40c3d2417	确定、理解并持续满足顾客要求以及适用的法律法规要求	f
8b1a7390-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:18.665	2018-11-18 13:05:18.665	t	t	8b193b10-eaef-11e8-a812-08d40c3d2417	确定和应对能够影响产品、服务符合性以及増强顾客满意能力的风险和机遇	f
8b1ac1b0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:18.667	2018-11-18 13:05:18.667	t	t	8b193b10-eaef-11e8-a812-08d40c3d2417	始终致力于増强顾客满意	f
8b1bfa30-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:18.675	2018-11-18 13:05:18.675	t	t	8b193b10-eaef-11e8-a812-08d40c3d2417	以上都是	t
a0bcef21-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:54.962	2018-11-18 13:05:54.962	t	t	a0ba7e20-eaef-11e8-a812-08d40c3d2417	确定	f
a0bcef22-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:54.962	2018-11-18 13:05:54.962	t	t	a0ba7e20-eaef-11e8-a812-08d40c3d2417	监视	f
a0bf6020-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:54.978	2018-11-18 13:05:54.978	t	t	a0ba7e20-eaef-11e8-a812-08d40c3d2417	评审	f
a0bf8730-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:05:54.979	2018-11-18 13:05:54.979	t	t	a0ba7e20-eaef-11e8-a812-08d40c3d2417	以上都是	t
b366eb32-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:26.275	2018-11-18 13:06:26.275	t	t	b366eb30-eaef-11e8-a812-08d40c3d2417	产品的设计开发人员	f
b366eb33-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:26.275	2018-11-18 13:06:26.275	t	t	b366eb30-eaef-11e8-a812-08d40c3d2417	产品的生产制造人员	f
b366eb34-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:26.275	2018-11-18 13:06:26.275	t	t	b366eb30-eaef-11e8-a812-08d40c3d2417	产品质量的检验员	t
b366eb35-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:26.275	2018-11-18 13:06:26.275	t	t	b366eb30-eaef-11e8-a812-08d40c3d2417	工艺设计人员	f
c7679da0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:59.834	2018-11-18 13:06:59.834	t	t	c7670160-eaef-11e8-a812-08d40c3d2417	组织应确定、提供并维护过程运行所需要的环境，以获得合格产品和服务	f
c76812d0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:59.837	2018-11-18 13:06:59.837	t	t	c7670160-eaef-11e8-a812-08d40c3d2417	过程运行环境可能是人文因素与物理因素的结合	f
c7692440-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:59.844	2018-11-18 13:06:59.844	t	t	c7670160-eaef-11e8-a812-08d40c3d2417	不同组织，因提供的产品和服务不同，过程运行所需的环境也是不同的	f
c76a83d0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:06:59.853	2018-11-18 13:06:59.853	t	t	c7670160-eaef-11e8-a812-08d40c3d2417	以上都对	t
d959e270-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:29.943	2018-11-18 13:07:29.943	t	t	d93a7390-eaef-11e8-a812-08d40c3d2417	建立测量设备台帐	f
d962e320-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:30.002	2018-11-18 13:07:30.002	t	t	d93a7390-eaef-11e8-a812-08d40c3d2417	编制测量设备周检计划	f
d9688870-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:30.039	2018-11-18 13:07:30.039	t	t	d93a7390-eaef-11e8-a812-08d40c3d2417	按照规定的时间间隔或在使用前进行校准和（或）检定（验证）	t
d9688871-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:30.039	2018-11-18 13:07:30.039	t	t	d93a7390-eaef-11e8-a812-08d40c3d2417	以上全部	f
ea12e3f0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:57.999	2018-11-18 13:07:57.999	t	t	ea006d60-eaef-11e8-a812-08d40c3d2417	建筑物	f
ea1b2150-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:58.053	2018-11-18 13:07:58.053	t	t	ea006d60-eaef-11e8-a812-08d40c3d2417	信息系统	f
ea1e55a0-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:58.074	2018-11-18 13:07:58.074	t	t	ea006d60-eaef-11e8-a812-08d40c3d2417	供方的运输设施	t
ea1e55a1-eaef-11e8-a812-08d40c3d2417	2018-11-18 13:07:58.074	2018-11-18 13:07:58.074	t	t	ea006d60-eaef-11e8-a812-08d40c3d2417	过程设备的软件	f
004c4851-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:08:35.285	2018-11-18 13:08:35.285	t	t	0049fe60-eaf0-11e8-a812-08d40c3d2417	设计和开发评审	f
004eb950-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:08:35.301	2018-11-18 13:08:35.301	t	t	0049fe60-eaf0-11e8-a812-08d40c3d2417	设计和开发验证	t
004f0770-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:08:35.303	2018-11-18 13:08:35.303	t	t	0049fe60-eaf0-11e8-a812-08d40c3d2417	设计和开发确认	f
004fa3b0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:08:35.307	2018-11-18 13:08:35.307	t	t	0049fe60-eaf0-11e8-a812-08d40c3d2417	设计和开发的策划	f
14d871e1-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:09.758	2018-11-18 13:09:09.758	t	t	14d627f0-eaf0-11e8-a812-08d40c3d2417	顾客规定的要求	f
14d871e2-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:09.758	2018-11-18 13:09:09.758	t	t	14d627f0-eaf0-11e8-a812-08d40c3d2417	顾客虽然没有明示，但规定的用途或已知的预期用途所必须的要求	f
14d871e3-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:09.758	2018-11-18 13:09:09.758	t	t	14d627f0-eaf0-11e8-a812-08d40c3d2417	与产品有关的法律法规要求	t
14dba630-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:09.779	2018-11-18 13:09:09.779	t	t	14d627f0-eaf0-11e8-a812-08d40c3d2417	组织确定的任何附加要求	f
2a444d10-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:45.697	2018-11-18 13:09:45.697	t	t	2a4389c0-eaf0-11e8-a812-08d40c3d2417	股东	t
2a449b30-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:45.699	2018-11-18 13:09:45.699	t	t	2a4389c0-eaf0-11e8-a812-08d40c3d2417	文件资料管理人员	f
2a453770-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:45.703	2018-11-18 13:09:45.703	t	t	2a4389c0-eaf0-11e8-a812-08d40c3d2417	售后服务人员	f
2a4621d0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:09:45.709	2018-11-18 13:09:45.709	t	t	2a4389c0-eaf0-11e8-a812-08d40c3d2417	产品设计开发人员	f
3e4351d0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:19.245	2018-11-18 13:10:19.245	t	t	3e3ff670-eaf0-11e8-a812-08d40c3d2417	与产品有关的法律法规要求	t
3e4351d1-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:19.245	2018-11-18 13:10:19.245	t	t	3e3ff670-eaf0-11e8-a812-08d40c3d2417	顾客规定的要求	f
3e45c2d0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:19.261	2018-11-18 13:10:19.261	t	t	3e3ff670-eaf0-11e8-a812-08d40c3d2417	组织确定的任何附加要求	f
3e45c2d1-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:19.261	2018-11-18 13:10:19.261	t	t	3e3ff670-eaf0-11e8-a812-08d40c3d2417	顾客虽然没有明示，但规定用途或己知的预期用途所必需的要求	f
4ee4fac0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:47.148	2018-11-18 13:10:47.148	t	t	4ee1c670-eaf0-11e8-a812-08d40c3d2417	对在职人员进行培训、辅导	f
4ee4fac1-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:47.148	2018-11-18 13:10:47.148	t	t	4ee1c670-eaf0-11e8-a812-08d40c3d2417	重新分配工作	f
4ee76bc0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:47.164	2018-11-18 13:10:47.164	t	t	4ee1c670-eaf0-11e8-a812-08d40c3d2417	招聘具备能力的人员	f
4ee76bc1-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:10:47.164	2018-11-18 13:10:47.164	t	t	4ee1c670-eaf0-11e8-a812-08d40c3d2417	以上都是	t
880aa610-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:12:23.025	2018-11-18 13:12:23.025	t	t	880a30e0-eaf0-11e8-a812-08d40c3d2417	保障质量管理体系实现期望的结果；	t
880af430-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:12:23.027	2018-11-18 13:12:23.027	t	t	880a30e0-eaf0-11e8-a812-08d40c3d2417	增强理想的效果；	t
880b6960-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:12:23.03	2018-11-18 13:12:23.03	t	t	880a30e0-eaf0-11e8-a812-08d40c3d2417	预防或减少非预期的影响；	t
880c53c0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:12:23.036	2018-11-18 13:12:23.036	t	t	880a30e0-eaf0-11e8-a812-08d40c3d2417	实现改进。	t
af49f372-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:13:28.871	2018-11-18 13:13:28.871	t	t	af49f370-eaf0-11e8-a812-08d40c3d2417	沟通内容；	t
af4b5300-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:13:28.88	2018-11-18 13:13:28.88	t	t	af49f370-eaf0-11e8-a812-08d40c3d2417	沟通时机；	t
af4efc80-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:13:28.904	2018-11-18 13:13:28.904	t	t	af49f370-eaf0-11e8-a812-08d40c3d2417	沟通人员；	t
af4f4aa0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:13:28.906	2018-11-18 13:13:28.906	t	t	af49f370-eaf0-11e8-a812-08d40c3d2417	沟通对象；	t
af4f98c0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:13:28.908	2018-11-18 13:13:28.908	t	t	af49f370-eaf0-11e8-a812-08d40c3d2417	沟通的负责人；	t
cc2b71d0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:14:17.325	2018-11-18 13:14:17.325	t	t	cc261aa0-eaf0-11e8-a812-08d40c3d2417	如本标准的要求在确定的范围内适用，组织应采用本标准的所有要求。	t
cc2b98e0-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:14:17.326	2018-11-18 13:14:17.326	t	t	cc261aa0-eaf0-11e8-a812-08d40c3d2417	范围应说明质量管理体系所覆盖的产品和服务。	t
cc2c0e10-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:14:17.329	2018-11-18 13:14:17.329	t	t	cc261aa0-eaf0-11e8-a812-08d40c3d2417	范围应对组织确定不适用于管理体系范围的本标准的要求说明正当理由。	t
cc2c0e11-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:14:17.329	2018-11-18 13:14:17.329	t	t	cc261aa0-eaf0-11e8-a812-08d40c3d2417	当被确定为不适用的要求不影响组织确保产品和服务的符合性以及增强顾客满意的能力或责任时，才能声称符合本标准的要求。	t
e8c81f01-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:05.328	2018-11-18 13:15:05.328	t	t	e8c5ae00-eaf0-11e8-a812-08d40c3d2417	图纸、产品规范、材料规范、测试要求	t
e8c81f02-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:05.328	2018-11-18 13:15:05.328	t	t	e8c5ae00-eaf0-11e8-a812-08d40c3d2417	过程规范、必要的生产设备细节	t
e8c81f03-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:05.328	2018-11-18 13:15:05.328	t	t	e8c5ae00-eaf0-11e8-a812-08d40c3d2417	建筑计划和工艺计算	t
e8c81f04-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:05.328	2018-11-18 13:15:05.328	t	t	e8c5ae00-eaf0-11e8-a812-08d40c3d2417	菜单、食谱、烹饪方法、服务手册	t
ffa4a130-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:43.683	2018-11-18 13:15:43.683	t	t	ffa404f0-eaf0-11e8-a812-08d40c3d2417	所提供的产品、过程和服务。	t
ffa53d70-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:43.687	2018-11-18 13:15:43.687	t	t	ffa404f0-eaf0-11e8-a812-08d40c3d2417	能力，包括所要求的人员资质。	t
ffa56480-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:43.688	2018-11-18 13:15:43.688	t	t	ffa404f0-eaf0-11e8-a812-08d40c3d2417	产品和服务放行的批准。	t
ffa78760-eaf0-11e8-a812-08d40c3d2417	2018-11-18 13:15:43.702	2018-11-18 13:15:43.702	t	t	ffa404f0-eaf0-11e8-a812-08d40c3d2417	拟在外部供方现场实施的验证或确认活动。	t
15493fa0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:16:19.994	2018-11-18 13:16:19.994	t	t	15468080-eaf1-11e8-a812-08d40c3d2417	分发、获取、检索和使用；	t
154a02f0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:16:19.999	2018-11-18 13:16:19.999	t	t	15468080-eaf1-11e8-a812-08d40c3d2417	储存、保护，包括保持清晰；	t
154a5110-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:16:20.001	2018-11-18 13:16:20.001	t	t	15468080-eaf1-11e8-a812-08d40c3d2417	更改的控制（如：版本控制）；	t
154b1460-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:16:20.006	2018-11-18 13:16:20.006	t	t	15468080-eaf1-11e8-a812-08d40c3d2417	保留和处置。	t
2d8f15d0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:17:00.717	2018-11-18 13:17:00.717	t	t	2d8e7990-eaf1-11e8-a812-08d40c3d2417	社会因素	t
2d8f63f0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:17:00.719	2018-11-18 13:17:00.719	t	t	2d8e7990-eaf1-11e8-a812-08d40c3d2417	心理因素	t
2d900030-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:17:00.723	2018-11-18 13:17:00.723	t	t	2d8e7990-eaf1-11e8-a812-08d40c3d2417	物理因素	t
2d90ea90-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:17:00.729	2018-11-18 13:17:00.729	t	t	2d8e7990-eaf1-11e8-a812-08d40c3d2417	经济因素	f
52ee0a72-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:03.415	2018-11-18 13:18:03.415	t	t	52ee0a70-eaf1-11e8-a812-08d40c3d2417	法律法规要求；	t
52ee0a73-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:03.415	2018-11-18 13:18:03.415	t	t	52ee0a70-eaf1-11e8-a812-08d40c3d2417	产品和服务的潜在非预期结果；	t
52ee0a74-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:03.415	2018-11-18 13:18:03.415	t	t	52ee0a70-eaf1-11e8-a812-08d40c3d2417	产品和服务的特性、使用及预期的生命周期；	t
52ee0a75-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:03.415	2018-11-18 13:18:03.415	t	t	52ee0a70-eaf1-11e8-a812-08d40c3d2417	顾客要求；	t
52f2ec70-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:03.447	2018-11-18 13:18:03.447	t	t	52ee0a70-eaf1-11e8-a812-08d40c3d2417	顾客反馈	t
6a8b92b0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:43.035	2018-11-18 13:18:43.035	t	t	6a8af670-eaf1-11e8-a812-08d40c3d2417	采用新实践	t
6a8c7d10-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:43.041	2018-11-18 13:18:43.041	t	t	6a8af670-eaf1-11e8-a812-08d40c3d2417	推出新产品	t
6a8ccb30-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:43.043	2018-11-18 13:18:43.043	t	t	6a8af670-eaf1-11e8-a812-08d40c3d2417	开辟新市场	t
6a904da0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:18:43.066	2018-11-18 13:18:43.066	t	t	6a8af670-eaf1-11e8-a812-08d40c3d2417	赢得新客户	t
7e12cf61-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:15.798	2018-11-18 13:19:15.798	t	t	7e128140-eaf1-11e8-a812-08d40c3d2417	采取的措施及所需要的资源	t
7e12cf62-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:15.798	2018-11-18 13:19:15.798	t	t	7e128140-eaf1-11e8-a812-08d40c3d2417	相关职责	t
7e12cf63-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:15.798	2018-11-18 13:19:15.798	t	t	7e128140-eaf1-11e8-a812-08d40c3d2417	时间要求	t
7e12cf64-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:15.798	2018-11-18 13:19:15.798	t	t	7e128140-eaf1-11e8-a812-08d40c3d2417	如何评价结果	t
94ff7e30-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:54.259	2018-11-18 13:19:54.259	t	t	94fd0d30-eaf1-11e8-a812-08d40c3d2417	确保质量管理体系要求融入与组织的业务过程	t
94ff7e31-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:54.259	2018-11-18 13:19:54.259	t	t	94fd0d30-eaf1-11e8-a812-08d40c3d2417	促进使用过程方法和基于风险的思维	t
94ff7e32-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:54.259	2018-11-18 13:19:54.259	t	t	94fd0d30-eaf1-11e8-a812-08d40c3d2417	确保获得质量管理体系所需的资源	t
94ff7e33-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:19:54.259	2018-11-18 13:19:54.259	t	t	94fd0d30-eaf1-11e8-a812-08d40c3d2417	推动改进	t
ae5d05f0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:20:36.815	2018-11-18 13:20:36.815	t	t	ae5c69b0-eaf1-11e8-a812-08d40c3d2417	确定职责、权限	t
ae5d5410-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:20:36.817	2018-11-18 13:20:36.817	t	t	ae5c69b0-eaf1-11e8-a812-08d40c3d2417	实施内审	f
ae614bb0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:20:36.843	2018-11-18 13:20:36.843	t	t	ae5c69b0-eaf1-11e8-a812-08d40c3d2417	确保质量方针、质量目标的制定	t
ae6199d0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:20:36.845	2018-11-18 13:20:36.845	t	t	ae5c69b0-eaf1-11e8-a812-08d40c3d2417	确保资源的获得	t
c63cc750-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:16.869	2018-11-18 13:21:16.869	t	t	c63c2b10-eaf1-11e8-a812-08d40c3d2417	ISO9001:2015标准不再使用“删减”一词，表明标准的所有要求均应实施	f
c63d8aa0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:16.874	2018-11-18 13:21:16.874	t	t	c63c2b10-eaf1-11e8-a812-08d40c3d2417	组织可根据其规模和复杂程度、所采用的管理模式、活动领域以及所面临风险性质，对相关要求的适用性进行评审	t
c63dd8c0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:16.876	2018-11-18 13:21:16.876	t	t	c63c2b10-eaf1-11e8-a812-08d40c3d2417	标准规定了组织确定某项要求不适用于其质量管理体系范围内过程的条件	t
c64070d0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:16.893	2018-11-18 13:21:16.893	t	t	c63c2b10-eaf1-11e8-a812-08d40c3d2417	只有不实施某项要求不会对提供合格的产品和服务造成不利影响，组织才能决定该要求不适用	t
dc653bc1-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:54.044	2018-11-18 13:21:54.044	t	t	dc62cac0-eaf1-11e8-a812-08d40c3d2417	支持过程运行所需的文件	t
dc653bc2-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:54.044	2018-11-18 13:21:54.044	t	t	dc62cac0-eaf1-11e8-a812-08d40c3d2417	确认其过程按策划进行所需的文件	t
dc67acc0-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:54.06	2018-11-18 13:21:54.06	t	t	dc62cac0-eaf1-11e8-a812-08d40c3d2417	第三方认证所需的文件	f
dc67acc1-eaf1-11e8-a812-08d40c3d2417	2018-11-18 13:21:54.06	2018-11-18 13:21:54.06	t	t	dc62cac0-eaf1-11e8-a812-08d40c3d2417	满足法定要求所需的文件	f
0272bfe0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:22:57.886	2018-11-18 13:22:57.886	t	t	0271d580-eaf2-11e8-a812-08d40c3d2417	变更目的及其潜在后果	t
02741f70-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:22:57.895	2018-11-18 13:22:57.895	t	t	0271d580-eaf2-11e8-a812-08d40c3d2417	质量管理体系的充分性	f
02746d90-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:22:57.897	2018-11-18 13:22:57.897	t	t	0271d580-eaf2-11e8-a812-08d40c3d2417	资源的可获得性	t
02757f00-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:22:57.904	2018-11-18 13:22:57.904	t	t	0271d580-eaf2-11e8-a812-08d40c3d2417	责任和权限的分配或再分配	t
2311e280-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:23:52.616	2018-11-18 13:23:52.616	t	t	23114640-eaf2-11e8-a812-08d40c3d2417	监视和测量资源满足使用要求的证据	t
2312cce0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:23:52.622	2018-11-18 13:23:52.622	t	t	23114640-eaf2-11e8-a812-08d40c3d2417	在组织控制下从事影响质量管理体系绩效和有效性工作的人员的能力的证据	t
23131b00-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:23:52.624	2018-11-18 13:23:52.624	t	t	23114640-eaf2-11e8-a812-08d40c3d2417	基础设施的维护信息	f
2314c8b0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:23:52.635	2018-11-18 13:23:52.635	t	t	23114640-eaf2-11e8-a812-08d40c3d2417	描述产品和服务变更的评审结果、有权变更的人员以及评审引起的任何必要措施	t
45f37b10-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:24:51.137	2018-11-18 13:24:51.137	t	t	45f2ded0-eaf2-11e8-a812-08d40c3d2417	顾客当面口头提出	t
45f41750-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:24:51.141	2018-11-18 13:24:51.141	t	t	45f2ded0-eaf2-11e8-a812-08d40c3d2417	顾客以发短信提出	f
45f74ba0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:24:51.162	2018-11-18 13:24:51.162	t	t	45f2ded0-eaf2-11e8-a812-08d40c3d2417	在饭店顾客点菜，服务员在菜单上记录	t
45f799c0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:24:51.164	2018-11-18 13:24:51.164	t	t	45f2ded0-eaf2-11e8-a812-08d40c3d2417	顾客打电话预定宾馆房间	t
5ffb9ab2-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:25:34.811	2018-11-18 13:25:34.811	t	t	5ffb9ab0-eaf2-11e8-a812-08d40c3d2417	设计和开发控制活动包括设计评审、验证、确认	t
5ffb9ab3-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:25:34.811	2018-11-18 13:25:34.811	t	t	5ffb9ab0-eaf2-11e8-a812-08d40c3d2417	对设计评审、验证和确认过程中确定的问题应采取必要措施	t
5ffb9ab4-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:25:34.811	2018-11-18 13:25:34.811	t	t	5ffb9ab0-eaf2-11e8-a812-08d40c3d2417	应保留设计评审、验证和确认的形成文件的信息	t
5ffb9ab5-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:25:34.811	2018-11-18 13:25:34.811	t	t	5ffb9ab0-eaf2-11e8-a812-08d40c3d2417	设计评审、验证和确认的目的不一样，应单独进行	f
799dcc90-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:17.817	2018-11-18 13:26:17.817	t	t	799d3050-eaf2-11e8-a812-08d40c3d2417	无论何时何处需要这些信息，均可获得并适用	t
799e1ab0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:17.819	2018-11-18 13:26:17.819	t	t	799d3050-eaf2-11e8-a812-08d40c3d2417	予以妥善保护（如：防止失密、不当使用或不完整）	t
79a100e0-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:17.838	2018-11-18 13:26:17.838	t	t	799d3050-eaf2-11e8-a812-08d40c3d2417	形成文件的信息应分发到需要的场所	f
79a14f00-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:17.84	2018-11-18 13:26:17.84	t	t	799d3050-eaf2-11e8-a812-08d40c3d2417	应对所保存的作为符合性证据的形成文件的信息予以保护，防止非预期的更改	t
90a94e01-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:56.48	2018-11-18 13:26:56.48	t	t	90a70410-eaf2-11e8-a812-08d40c3d2417	明示的”可以理解为是规定的要求	t
90abe610-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:56.497	2018-11-18 13:26:56.497	t	t	90a70410-eaf2-11e8-a812-08d40c3d2417	“通常隐含的”是指组织、顾客和其他相关的惯例或一般做法，所考虑的需求或期望是不言而喻的	t
90ac3430-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:56.499	2018-11-18 13:26:56.499	t	t	90a70410-eaf2-11e8-a812-08d40c3d2417	“必须履行的”是指顾客或相关方要求的或有强制性标准要求的	f
90ac8250-eaf2-11e8-a812-08d40c3d2417	2018-11-18 13:26:56.501	2018-11-18 13:26:56.501	t	t	90a70410-eaf2-11e8-a812-08d40c3d2417	要求可以由不同的相关方提出，不同的相关方对同一产品的要求可能是不相同的	t
e2126910-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:22.561	2018-11-18 13:36:22.561	t	t	e20570c0-eaf3-11e8-a812-08d40c3d2417	对	t
e212b730-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:22.563	2018-11-18 13:36:22.563	t	t	e20570c0-eaf3-11e8-a812-08d40c3d2417	错	f
ead99280-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:37.288	2018-11-18 13:36:37.288	t	t	ead91d50-eaf3-11e8-a812-08d40c3d2417	对	t
eada55d0-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:37.293	2018-11-18 13:36:37.293	t	t	ead91d50-eaf3-11e8-a812-08d40c3d2417	错	f
f44d0180-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:53.144	2018-11-18 13:36:53.144	t	t	f44c8c50-eaf3-11e8-a812-08d40c3d2417	对	t
f44d4fa0-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:36:53.146	2018-11-18 13:36:53.146	t	t	f44c8c50-eaf3-11e8-a812-08d40c3d2417	错	f
fdef21a0-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:37:09.306	2018-11-18 13:37:09.306	t	t	fdee5e50-eaf3-11e8-a812-08d40c3d2417	对	f
fdef96d0-eaf3-11e8-a812-08d40c3d2417	2018-11-18 13:37:09.309	2018-11-18 13:37:09.309	t	t	fdee5e50-eaf3-11e8-a812-08d40c3d2417	错	t
06f94780-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:24.472	2018-11-18 13:37:24.472	t	t	06f88430-eaf4-11e8-a812-08d40c3d2417	对	f
06f9bcb0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:24.475	2018-11-18 13:37:24.475	t	t	06f88430-eaf4-11e8-a812-08d40c3d2417	错	t
12615a90-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:43.609	2018-11-18 13:37:43.609	t	t	1260be50-eaf4-11e8-a812-08d40c3d2417	对	f
1261a8b0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:37:43.611	2018-11-18 13:37:43.611	t	t	1260be50-eaf4-11e8-a812-08d40c3d2417	错	t
1e75da40-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:03.876	2018-11-18 13:38:03.876	t	t	1e74efe0-eaf4-11e8-a812-08d40c3d2417	对	f
1e76c4a0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:03.882	2018-11-18 13:38:03.882	t	t	1e74efe0-eaf4-11e8-a812-08d40c3d2417	错	t
23453ca0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:11.946	2018-11-18 13:38:11.946	t	t	23445240-eaf4-11e8-a812-08d40c3d2417	对	f
23464e10-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:11.953	2018-11-18 13:38:11.953	t	t	23445240-eaf4-11e8-a812-08d40c3d2417	错	t
2de0ff00-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:29.744	2018-11-18 13:38:29.744	t	t	2de062c0-eaf4-11e8-a812-08d40c3d2417	对	f
2de14d20-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:29.746	2018-11-18 13:38:29.746	t	t	2de062c0-eaf4-11e8-a812-08d40c3d2417	错	t
3620f710-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:43.585	2018-11-18 13:38:43.585	t	t	362033c0-eaf4-11e8-a812-08d40c3d2417	对	t
3621e170-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:43.591	2018-11-18 13:38:43.591	t	t	362033c0-eaf4-11e8-a812-08d40c3d2417	错	f
3e3c7730-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:57.187	2018-11-18 13:38:57.187	t	t	3e3b65c0-eaf4-11e8-a812-08d40c3d2417	对	f
3e3d3a80-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:38:57.192	2018-11-18 13:38:57.192	t	t	3e3b65c0-eaf4-11e8-a812-08d40c3d2417	错	t
497a6d00-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:16.048	2018-11-18 13:39:16.048	t	t	4979d0c0-eaf4-11e8-a812-08d40c3d2417	对	t
497abb20-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:16.05	2018-11-18 13:39:16.05	t	t	4979d0c0-eaf4-11e8-a812-08d40c3d2417	错	f
54193ca0-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:33.866	2018-11-18 13:39:33.866	t	t	5418a060-eaf4-11e8-a812-08d40c3d2417	对	f
541a4e10-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:33.873	2018-11-18 13:39:33.873	t	t	5418a060-eaf4-11e8-a812-08d40c3d2417	错	t
6098da31-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:54.835	2018-11-18 13:39:54.835	t	t	6091ae40-eaf4-11e8-a812-08d40c3d2417	对	t
609c0e80-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:39:54.856	2018-11-18 13:39:54.856	t	t	6091ae40-eaf4-11e8-a812-08d40c3d2417	错	f
6b532110-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:12.833	2018-11-18 13:40:12.833	t	t	6b525dc0-eaf4-11e8-a812-08d40c3d2417	对	t
6b53e460-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:12.838	2018-11-18 13:40:12.838	t	t	6b525dc0-eaf4-11e8-a812-08d40c3d2417	错	f
756f2c20-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:29.794	2018-11-18 13:40:29.794	t	t	756e8fe0-eaf4-11e8-a812-08d40c3d2417	对	f
756fef70-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:29.799	2018-11-18 13:40:29.799	t	t	756e8fe0-eaf4-11e8-a812-08d40c3d2417	错	t
83ae5400-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:53.696	2018-11-18 13:40:53.696	t	t	83added0-eaf4-11e8-a812-08d40c3d2417	对	t
83afb390-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:40:53.705	2018-11-18 13:40:53.705	t	t	83added0-eaf4-11e8-a812-08d40c3d2417	错	f
97b34c30-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:27.283	2018-11-18 13:41:27.283	t	t	97b288e0-eaf4-11e8-a812-08d40c3d2417	对	t
97b39a50-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:27.285	2018-11-18 13:41:27.285	t	t	97b288e0-eaf4-11e8-a812-08d40c3d2417	错	f
a263a800-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:45.216	2018-11-18 13:41:45.216	t	t	a262e4b0-eaf4-11e8-a812-08d40c3d2417	对	t
a263f620-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:45.218	2018-11-18 13:41:45.218	t	t	a262e4b0-eaf4-11e8-a812-08d40c3d2417	错	f
aa3cef00-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:58.384	2018-11-18 13:41:58.384	t	t	aa38a940-eaf4-11e8-a812-08d40c3d2417	对	f
aa3d3d20-eaf4-11e8-a812-08d40c3d2417	2018-11-18 13:41:58.386	2018-11-18 13:41:58.386	t	t	aa38a940-eaf4-11e8-a812-08d40c3d2417	错	t
0d026cf1-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:44:44.095	2018-11-18 13:44:44.095	t	t	0cfffbf0-eaf5-11e8-a812-08d40c3d2417	组织	f
0d026cf2-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:44:44.095	2018-11-18 13:44:44.095	t	t	0cfffbf0-eaf5-11e8-a812-08d40c3d2417	顾客	f
0d026cf3-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:44:44.095	2018-11-18 13:44:44.095	t	t	0cfffbf0-eaf5-11e8-a812-08d40c3d2417	组织或其顾客	t
0d057a30-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:44:44.115	2018-11-18 13:44:44.115	t	t	0cfffbf0-eaf5-11e8-a812-08d40c3d2417	组织和其顾客	f
239e63b2-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:45:22.027	2018-11-18 13:45:22.027	t	t	239e63b0-eaf5-11e8-a812-08d40c3d2417	策划	t
239e63b3-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:45:22.027	2018-11-18 13:45:22.027	t	t	239e63b0-eaf5-11e8-a812-08d40c3d2417	实施	f
239e63b4-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:45:22.027	2018-11-18 13:45:22.027	t	t	239e63b0-eaf5-11e8-a812-08d40c3d2417	检查	f
239e63b5-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:45:22.027	2018-11-18 13:45:22.027	t	t	239e63b0-eaf5-11e8-a812-08d40c3d2417	改进	f
3e361920-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:46:06.642	2018-11-18 13:46:06.642	t	t	3e3555d0-eaf5-11e8-a812-08d40c3d2417	质量目标及其实现的策划	f
3e368e50-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:46:06.645	2018-11-18 13:46:06.645	t	t	3e3555d0-eaf5-11e8-a812-08d40c3d2417	改进应对风险	f
3e36dc70-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:46:06.647	2018-11-18 13:46:06.647	t	t	3e3555d0-eaf5-11e8-a812-08d40c3d2417	制定质量方针	t
3e3778b0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:46:06.651	2018-11-18 13:46:06.651	t	t	3e3555d0-eaf5-11e8-a812-08d40c3d2417	变更的策划	f
5f6c72b0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:02.363	2018-11-18 13:47:02.363	t	t	5f6b8850-eaf5-11e8-a812-08d40c3d2417	股票持有人	t
5f6d3600-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:02.368	2018-11-18 13:47:02.368	t	t	5f6b8850-eaf5-11e8-a812-08d40c3d2417	文件资料管理人员	f
5f6e6e80-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:02.376	2018-11-18 13:47:02.376	t	t	5f6b8850-eaf5-11e8-a812-08d40c3d2417	售后服务人员	f
5f6ebca0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:02.378	2018-11-18 13:47:02.378	t	t	5f6b8850-eaf5-11e8-a812-08d40c3d2417	产品的设计开发人员	f
73e82181-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:36.728	2018-11-18 13:47:36.728	t	t	73e7fa70-eaf5-11e8-a812-08d40c3d2417	员工高超技术	f
73e82182-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:36.728	2018-11-18 13:47:36.728	t	t	73e7fa70-eaf5-11e8-a812-08d40c3d2417	员工对企业的贡献	f
73e82183-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:36.728	2018-11-18 13:47:36.728	t	t	73e7fa70-eaf5-11e8-a812-08d40c3d2417	偏离质量管理体系要求的后果	t
73e82184-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:47:36.728	2018-11-18 13:47:36.728	t	t	73e7fa70-eaf5-11e8-a812-08d40c3d2417	企业高质量高效益	f
8803fd12-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:10.465	2018-11-18 13:48:10.465	t	t	8803fd10-eaf5-11e8-a812-08d40c3d2417	组织对设计和开发过程进行控制活动就是评审、验证和确认	t
8803fd13-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:10.465	2018-11-18 13:48:10.465	t	t	8803fd10-eaf5-11e8-a812-08d40c3d2417	评审的目的是评价设计和开发的结果满足要求的能力	f
8803fd14-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:10.465	2018-11-18 13:48:10.465	t	t	8803fd10-eaf5-11e8-a812-08d40c3d2417	验证的目的是确保设计和开发输出满足输入的要求	f
178983f0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:59:20.751	2018-11-18 13:59:20.751	t	t	178712f0-eaf7-11e8-a812-08d40c3d2417	组织内所有员工	f
8803fd15-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:10.465	2018-11-18 13:48:10.465	t	t	8803fd10-eaf5-11e8-a812-08d40c3d2417	确认的目的是确保产品和服务能够满足规定的使用要求或预期用途要求	f
9d40b1f0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:46.095	2018-11-18 13:48:46.095	t	t	9d3feea0-eaf5-11e8-a812-08d40c3d2417	满足设计和开发输出	f
9d410010-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:46.097	2018-11-18 13:48:46.097	t	t	9d3feea0-eaf5-11e8-a812-08d40c3d2417	满足设计和开发评审	f
9d425fa0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:46.106	2018-11-18 13:48:46.106	t	t	9d3feea0-eaf5-11e8-a812-08d40c3d2417	满足设计和开发的目的	t
9d44f7b0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:48:46.123	2018-11-18 13:48:46.123	t	t	9d3feea0-eaf5-11e8-a812-08d40c3d2417	满足设计和开发控制	f
b7ffc580-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:49:30.968	2018-11-18 13:49:30.968	t	t	b7ff0230-eaf5-11e8-a812-08d40c3d2417	外部供方提供的产品和服务拟融入组织的产品和服务中。	f
b80061c0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:49:30.972	2018-11-18 13:49:30.972	t	t	b7ff0230-eaf5-11e8-a812-08d40c3d2417	外部供方代表组织直接向客户提供产品和服务。	f
b801c150-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:49:30.981	2018-11-18 13:49:30.981	t	t	b7ff0230-eaf5-11e8-a812-08d40c3d2417	经组织决定由外部供方提供某一过程或过程的一部分。	f
b802f9d0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:49:30.989	2018-11-18 13:49:30.989	t	t	b7ff0230-eaf5-11e8-a812-08d40c3d2417	外部供方提供的办公家具。	t
cad56570-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:02.567	2018-11-18 13:50:02.567	t	t	cac22b90-eaf5-11e8-a812-08d40c3d2417	标识和说明（例如：标题、日期、作者、文件编号等）	f
cad56571-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:02.567	2018-11-18 13:50:02.567	t	t	cac22b90-eaf5-11e8-a812-08d40c3d2417	格式（例如：语言、软件版本、图示）和媒介（例如：纸质、电子）	f
cae12540-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:02.644	2018-11-18 13:50:02.644	t	t	cac22b90-eaf5-11e8-a812-08d40c3d2417	评审和批准以确保适宜性和充分性	f
cae543f0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:02.671	2018-11-18 13:50:02.671	t	t	cac22b90-eaf5-11e8-a812-08d40c3d2417	以上全部	t
e09cce20-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:39.106	2018-11-18 13:50:39.106	t	t	e0983a40-eaf5-11e8-a812-08d40c3d2417	更改	t
e0a50b80-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:39.16	2018-11-18 13:50:39.16	t	t	e0983a40-eaf5-11e8-a812-08d40c3d2417	使用	f
e0a77c80-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:39.176	2018-11-18 13:50:39.176	t	t	e0983a40-eaf5-11e8-a812-08d40c3d2417	损坏	f
e0a7caa0-eaf5-11e8-a812-08d40c3d2417	2018-11-18 13:50:39.178	2018-11-18 13:50:39.178	t	t	e0983a40-eaf5-11e8-a812-08d40c3d2417	丢失	f
022ae4a0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:51:35.402	2018-11-18 13:51:35.402	t	t	0229d330-eaf6-11e8-a812-08d40c3d2417	他们通常与顾客需求和期望是一致的，因此只要满足顾客需求和期望，其他方也可满足。	f
022ce070-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:51:35.415	2018-11-18 13:51:35.415	t	t	0229d330-eaf6-11e8-a812-08d40c3d2417	各相关方的需求和期望可作为对于持续满足顾客和法律法规要求的风险评估的输入	t
022d2e90-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:51:35.417	2018-11-18 13:51:35.417	t	t	0229d330-eaf6-11e8-a812-08d40c3d2417	当各方需求和期望有冲突时以顾客要求为准	f
022da3c0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:51:35.42	2018-11-18 13:51:35.42	t	t	0229d330-eaf6-11e8-a812-08d40c3d2417	以上都对	f
166b1110-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:09.377	2018-11-18 13:52:09.377	t	t	166a74d0-eaf6-11e8-a812-08d40c3d2417	人力资源、组织知识；	f
166b5f30-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:09.379	2018-11-18 13:52:09.379	t	t	166a74d0-eaf6-11e8-a812-08d40c3d2417	基础设施和监视和测量资源；	f
166e6c70-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:09.399	2018-11-18 13:52:09.399	t	t	166a74d0-eaf6-11e8-a812-08d40c3d2417	过程环境；	f
166ee1a0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:09.402	2018-11-18 13:52:09.402	t	t	166a74d0-eaf6-11e8-a812-08d40c3d2417	（A）+（B）+（C）	t
2ad88f10-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:43.649	2018-11-18 13:52:43.649	t	t	2ad7f2d0-eaf6-11e8-a812-08d40c3d2417	智能化生产设备	f
2ad8dd30-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:43.651	2018-11-18 13:52:43.651	t	t	2ad7f2d0-eaf6-11e8-a812-08d40c3d2417	监视和测量资源	f
2ada15b0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:43.659	2018-11-18 13:52:43.659	t	t	2ad7f2d0-eaf6-11e8-a812-08d40c3d2417	服务业网上采购	t
2adb9c50-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:52:43.669	2018-11-18 13:52:43.669	t	t	2ad7f2d0-eaf6-11e8-a812-08d40c3d2417	保安监控系统	f
3dcba210-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:15.441	2018-11-18 13:53:15.441	t	t	3dc8e2f0-eaf6-11e8-a812-08d40c3d2417	纠正，纠正措施	f
3dcc3e50-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:15.445	2018-11-18 13:53:15.445	t	t	3dc8e2f0-eaf6-11e8-a812-08d40c3d2417	持续改进	f
3dcc3e51-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:15.445	2018-11-18 13:53:15.445	t	t	3dc8e2f0-eaf6-11e8-a812-08d40c3d2417	突变，创新和重组	f
3dcc3e52-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:15.445	2018-11-18 13:53:15.445	t	t	3dc8e2f0-eaf6-11e8-a812-08d40c3d2417	以上均是	t
51b80932-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:48.867	2018-11-18 13:53:48.867	t	t	51b80930-eaf6-11e8-a812-08d40c3d2417	ISO9001：2015版标准在对不符合进行处理和采取纠正措施后不必保持形成文件的信息	f
51ba7a30-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:48.883	2018-11-18 13:53:48.883	t	t	51b80930-eaf6-11e8-a812-08d40c3d2417	组织在对不合格进行处理和采取纠正措施后，必须对策划时确定的风险和机会进行更新	f
51ba7a31-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:48.883	2018-11-18 13:53:48.883	t	t	51b80930-eaf6-11e8-a812-08d40c3d2417	组织应保留形成文件的信息，作为纠正措施的结果的证据	t
51bd1240-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:53:48.9	2018-11-18 13:53:48.9	t	t	51b80930-eaf6-11e8-a812-08d40c3d2417	以上全部	f
664236f0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:23.327	2018-11-18 13:54:23.327	t	t	66419ab0-eaf6-11e8-a812-08d40c3d2417	确定设计和开发的职责和权限	f
66425e00-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:23.328	2018-11-18 13:54:23.328	t	t	66419ab0-eaf6-11e8-a812-08d40c3d2417	确定设计和开发的职责和权限	t
66432150-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:23.333	2018-11-18 13:54:23.333	t	t	66419ab0-eaf6-11e8-a812-08d40c3d2417	确保设计和开发的输出满足输入的要求	f
66440bb0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:23.339	2018-11-18 13:54:23.339	t	t	66419ab0-eaf6-11e8-a812-08d40c3d2417	确保质量管理体系的完整性	f
783d7c70-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:53.495	2018-11-18 13:54:53.495	t	t	782b5400-eaf6-11e8-a812-08d40c3d2417	防止不同产品的混淆	t
7845b9d0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:53.549	2018-11-18 13:54:53.549	t	t	782b5400-eaf6-11e8-a812-08d40c3d2417	防止不同状态产品的误用	f
7849d880-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:53.576	2018-11-18 13:54:53.576	t	t	782b5400-eaf6-11e8-a812-08d40c3d2417	追回紧急放行的产品	f
7849ff90-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:54:53.577	2018-11-18 13:54:53.577	t	t	782b5400-eaf6-11e8-a812-08d40c3d2417	防止使用不合格产品	f
8a4dd090-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:23.801	2018-11-18 13:55:23.801	t	t	8a4c22e0-eaf6-11e8-a812-08d40c3d2417	根据以往的经验和数据分析，可以交货	f
8a4ee200-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:23.808	2018-11-18 13:55:23.808	t	t	8a4c22e0-eaf6-11e8-a812-08d40c3d2417	经顾客批准，也不能交货	f
8a4f3020-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:23.81	2018-11-18 13:55:23.81	t	t	8a4c22e0-eaf6-11e8-a812-08d40c3d2417	经授权人员批准，都可以交货	f
8a501a80-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:23.816	2018-11-18 13:55:23.816	t	t	8a4c22e0-eaf6-11e8-a812-08d40c3d2417	以上都不对	t
9edcb940-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:58.292	2018-11-18 13:55:58.292	t	t	9edb80c0-eaf6-11e8-a812-08d40c3d2417	控制要求	f
9edd0760-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:58.294	2018-11-18 13:55:58.294	t	t	9edb80c0-eaf6-11e8-a812-08d40c3d2417	可追溯性要求	t
9ede18d0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:58.301	2018-11-18 13:55:58.301	t	t	9edb80c0-eaf6-11e8-a812-08d40c3d2417	监视和测量要求	f
9ede66f0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:55:58.303	2018-11-18 13:55:58.303	t	t	9edb80c0-eaf6-11e8-a812-08d40c3d2417	顾客的要求	f
c25fe900-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:56:57.872	2018-11-18 13:56:57.872	t	t	c25e3b50-eaf6-11e8-a812-08d40c3d2417	对顾客投诉进行赔偿	f
c2608540-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:56:57.876	2018-11-18 13:56:57.876	t	t	c25e3b50-eaf6-11e8-a812-08d40c3d2417	对凉的饭菜进行加热	f
c260fa70-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:56:57.879	2018-11-18 13:56:57.879	t	t	c25e3b50-eaf6-11e8-a812-08d40c3d2417	因工人记不住过程控制有关要求而制定作业文件	t
c26455d0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:56:57.901	2018-11-18 13:56:57.901	t	t	c25e3b50-eaf6-11e8-a812-08d40c3d2417	岗前培训	f
db368d80-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:57:39.544	2018-11-18 13:57:39.544	t	t	db35f140-eaf6-11e8-a812-08d40c3d2417	市场占有率分析	f
db388950-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:57:39.557	2018-11-18 13:57:39.557	t	t	db35f140-eaf6-11e8-a812-08d40c3d2417	实施进货检验	t
db38d770-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:57:39.559	2018-11-18 13:57:39.559	t	t	db35f140-eaf6-11e8-a812-08d40c3d2417	担保索赔	f
db38fe80-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:57:39.56	2018-11-18 13:57:39.56	t	t	db35f140-eaf6-11e8-a812-08d40c3d2417	顾客赞扬	f
ee7c0640-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:58:11.876	2018-11-18 13:58:11.876	t	t	ee7b9110-eaf6-11e8-a812-08d40c3d2417	产品的防护标识	f
ee7cc990-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:58:11.881	2018-11-18 13:58:11.881	t	t	ee7b9110-eaf6-11e8-a812-08d40c3d2417	产品在生产期间的保护	f
ee7d8ce0-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:58:11.886	2018-11-18 13:58:11.886	t	t	ee7b9110-eaf6-11e8-a812-08d40c3d2417	对生产产品的设备的保护	t
ee7e9e50-eaf6-11e8-a812-08d40c3d2417	2018-11-18 13:58:11.893	2018-11-18 13:58:11.893	t	t	ee7b9110-eaf6-11e8-a812-08d40c3d2417	产品包装	f
032f3fd0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:58:46.605	2018-11-18 13:58:46.605	t	t	032ea390-eaf7-11e8-a812-08d40c3d2417	与产品有关的法律法规要求	t
032fb500-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:58:46.608	2018-11-18 13:58:46.608	t	t	032ea390-eaf7-11e8-a812-08d40c3d2417	质量法	f
0330ed80-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:58:46.616	2018-11-18 13:58:46.616	t	t	032ea390-eaf7-11e8-a812-08d40c3d2417	标准化法	f
03331060-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:58:46.63	2018-11-18 13:58:46.63	t	t	032ea390-eaf7-11e8-a812-08d40c3d2417	计量法	f
178983f1-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:59:20.751	2018-11-18 13:59:20.751	t	t	178712f0-eaf7-11e8-a812-08d40c3d2417	组织的外部供方人员	f
178983f2-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:59:20.751	2018-11-18 13:59:20.751	t	t	178712f0-eaf7-11e8-a812-08d40c3d2417	在组织控制范围内的人员	f
178983f3-eaf7-11e8-a812-08d40c3d2417	2018-11-18 13:59:20.751	2018-11-18 13:59:20.751	t	t	178712f0-eaf7-11e8-a812-08d40c3d2417	在组织控制范围内从事的工作影响质量管理体系绩效和有效性的人员	t
2fc68080-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:01.416	2018-11-18 14:00:01.416	t	t	2fc5bd30-eaf7-11e8-a812-08d40c3d2417	设计和开发评审	f
2fc743d0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:01.421	2018-11-18 14:00:01.421	t	t	2fc5bd30-eaf7-11e8-a812-08d40c3d2417	设计和开发验证	f
2fc791f0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:01.423	2018-11-18 14:00:01.423	t	t	2fc5bd30-eaf7-11e8-a812-08d40c3d2417	设计和开发确认	t
2fc91890-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:01.433	2018-11-18 14:00:01.433	t	t	2fc5bd30-eaf7-11e8-a812-08d40c3d2417	设计和开发策划	f
438a5100-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:34.576	2018-11-18 14:00:34.576	t	t	4389b4c0-eaf7-11e8-a812-08d40c3d2417	外部供方的报价	f
438aed40-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:34.58	2018-11-18 14:00:34.58	t	t	4389b4c0-eaf7-11e8-a812-08d40c3d2417	外部供方提供的要求的过程、产品或服务的能力	t
438bd7a0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:34.586	2018-11-18 14:00:34.586	t	t	4389b4c0-eaf7-11e8-a812-08d40c3d2417	外部供方是否通过了第三方认证	f
438bfeb0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:00:34.587	2018-11-18 14:00:34.587	t	t	4389b4c0-eaf7-11e8-a812-08d40c3d2417	以上都是	f
5abbf810-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:13.489	2018-11-18 14:01:13.489	t	t	5abb34c0-eaf7-11e8-a812-08d40c3d2417	社会因素	f
5abd57a0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:13.498	2018-11-18 14:01:13.498	t	t	5abb34c0-eaf7-11e8-a812-08d40c3d2417	心理因素	f
5abfefb0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:13.515	2018-11-18 14:01:13.515	t	t	5abb34c0-eaf7-11e8-a812-08d40c3d2417	物理因素	f
5ac03dd0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:13.517	2018-11-18 14:01:13.517	t	t	5abb34c0-eaf7-11e8-a812-08d40c3d2417	以上都是	t
6d225b70-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:44.359	2018-11-18 14:01:44.359	t	t	6d1fea70-eaf7-11e8-a812-08d40c3d2417	组织的规模，以及活动、过程、产品和服务的类型	f
6d231ec0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:44.364	2018-11-18 14:01:44.364	t	t	6d1fea70-eaf7-11e8-a812-08d40c3d2417	过程的复杂程度及其相互作用	f
6d231ec1-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:44.364	2018-11-18 14:01:44.364	t	t	6d1fea70-eaf7-11e8-a812-08d40c3d2417	人员的能力	f
6d231ec2-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:01:44.364	2018-11-18 14:01:44.364	t	t	6d1fea70-eaf7-11e8-a812-08d40c3d2417	以上都是	t
7f9282d0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:15.293	2018-11-18 14:02:15.293	t	t	7f91e690-eaf7-11e8-a812-08d40c3d2417	书面合同	f
7f934620-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:15.298	2018-11-18 14:02:15.298	t	t	7f91e690-eaf7-11e8-a812-08d40c3d2417	电话订货	f
7f939440-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:15.3	2018-11-18 14:02:15.3	t	t	7f91e690-eaf7-11e8-a812-08d40c3d2417	任何适宜的方式	t
7f947ea0-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:15.306	2018-11-18 14:02:15.306	t	t	7f91e690-eaf7-11e8-a812-08d40c3d2417	电子邮件	f
93614fd2-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:48.525	2018-11-18 14:02:48.525	t	t	93614fd0-eaf7-11e8-a812-08d40c3d2417	教育、培训、经历	t
93614fd3-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:48.525	2018-11-18 14:02:48.525	t	t	93614fd0-eaf7-11e8-a812-08d40c3d2417	教育、培训、经验	f
93614fd4-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:48.525	2018-11-18 14:02:48.525	t	t	93614fd0-eaf7-11e8-a812-08d40c3d2417	培训、技能、意识	f
93614fd5-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:02:48.525	2018-11-18 14:02:48.525	t	t	93614fd0-eaf7-11e8-a812-08d40c3d2417	教育、技能、经验	f
d2339e22-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:04:33.922	2018-11-18 14:04:33.922	t	t	d2339e20-eaf7-11e8-a812-08d40c3d2417	保障质量管理体系实现期望的结果；	t
d2339e23-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:04:33.922	2018-11-18 14:04:33.922	t	t	d2339e20-eaf7-11e8-a812-08d40c3d2417	增强理想的效果；	t
d2339e24-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:04:33.922	2018-11-18 14:04:33.922	t	t	d2339e20-eaf7-11e8-a812-08d40c3d2417	增强理想的效果；	t
d2339e25-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:04:33.922	2018-11-18 14:04:33.922	t	t	d2339e20-eaf7-11e8-a812-08d40c3d2417	实现改进。	t
ef0f0200-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:05:22.336	2018-11-18 14:05:22.336	t	t	ef0e65c0-eaf7-11e8-a812-08d40c3d2417	如本标准的要求在确定的范围内适用，组织应采用本标准的所有要求。	t
ef11c120-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:05:22.354	2018-11-18 14:05:22.354	t	t	ef0e65c0-eaf7-11e8-a812-08d40c3d2417	范围应说明质量管理体系所覆盖的产品和服务，	t
ef120f40-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:05:22.356	2018-11-18 14:05:22.356	t	t	ef0e65c0-eaf7-11e8-a812-08d40c3d2417	范围应对组织确定不适用于管理体系范围的本标准的要求说明正当理由。	t
ef125d60-eaf7-11e8-a812-08d40c3d2417	2018-11-18 14:05:22.358	2018-11-18 14:05:22.358	t	t	ef0e65c0-eaf7-11e8-a812-08d40c3d2417	当被确定为不适用的要求不影响组织确保产品和服务的符合性以及增强顾客满意的能力或责任时，才能声称符合本标准的要求。	t
09a1d570-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:06.919	2018-11-18 14:06:06.919	t	t	09a0c400-eaf8-11e8-a812-08d40c3d2417	沟通内容；	t
09a298c0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:06.924	2018-11-18 14:06:06.924	t	t	09a0c400-eaf8-11e8-a812-08d40c3d2417	沟通时机；	t
09a2e6e0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:06.926	2018-11-18 14:06:06.926	t	t	09a0c400-eaf8-11e8-a812-08d40c3d2417	沟通人员；	t
09a3f850-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:06.933	2018-11-18 14:06:06.933	t	t	09a0c400-eaf8-11e8-a812-08d40c3d2417	沟通对象；	t
09a41f60-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:06.934	2018-11-18 14:06:06.934	t	t	09a0c400-eaf8-11e8-a812-08d40c3d2417	沟通的负责人；	t
28a0b590-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:58.921	2018-11-18 14:06:58.921	t	t	289fcb30-eaf8-11e8-a812-08d40c3d2417	图纸、产品规范、材料规范、测试要求	t
28a19ff0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:58.927	2018-11-18 14:06:58.927	t	t	289fcb30-eaf8-11e8-a812-08d40c3d2417	过程规范、必要的生产设备细节	t
28a374b0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:58.939	2018-11-18 14:06:58.939	t	t	289fcb30-eaf8-11e8-a812-08d40c3d2417	建筑计划和工艺计算	t
28a3c2d0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:06:58.941	2018-11-18 14:06:58.941	t	t	289fcb30-eaf8-11e8-a812-08d40c3d2417	菜单、食谱、烹饪方法、服务手册	t
3c272ef2-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:07:31.679	2018-11-18 14:07:31.679	t	t	3c272ef0-eaf8-11e8-a812-08d40c3d2417	所提供的产品、过程和服务。	t
3c272ef3-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:07:31.679	2018-11-18 14:07:31.679	t	t	3c272ef0-eaf8-11e8-a812-08d40c3d2417	能力，包括所要求的人员资质。	t
3c272ef4-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:07:31.679	2018-11-18 14:07:31.679	t	t	3c272ef0-eaf8-11e8-a812-08d40c3d2417	能力，包括所要求的人员资质。	t
3c299ff0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:07:31.695	2018-11-18 14:07:31.695	t	t	3c272ef0-eaf8-11e8-a812-08d40c3d2417	拟在外部供方现场实施的验证或确认活动。	t
9d3fc030-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:10:14.579	2018-11-18 14:10:14.579	t	t	9d3d9d50-eaf8-11e8-a812-08d40c3d2417	媒体的类型	f
9d400e50-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:10:14.581	2018-11-18 14:10:14.581	t	t	9d3d9d50-eaf8-11e8-a812-08d40c3d2417	组织的规模	t
9d405c70-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:10:14.583	2018-11-18 14:10:14.583	t	t	9d3d9d50-eaf8-11e8-a812-08d40c3d2417	过程及其相互作用的复杂程度	t
9d416de0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:10:14.59	2018-11-18 14:10:14.59	t	t	9d3d9d50-eaf8-11e8-a812-08d40c3d2417	人员的能力	t
c23544a0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:11:16.586	2018-11-18 14:11:16.586	t	t	c2348150-eaf8-11e8-a812-08d40c3d2417	减轻压力	t
c235b9d0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:11:16.589	2018-11-18 14:11:16.589	t	t	c2348150-eaf8-11e8-a812-08d40c3d2417	预防职业倦怠	t
c23607f0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:11:16.591	2018-11-18 14:11:16.591	t	t	c2348150-eaf8-11e8-a812-08d40c3d2417	情感保护	t
c2391530-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:11:16.611	2018-11-18 14:11:16.611	t	t	c2348150-eaf8-11e8-a812-08d40c3d2417	安宁	f
e3e3db70-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:13.095	2018-11-18 14:12:13.095	t	t	e3e33f30-eaf8-11e8-a812-08d40c3d2417	按规定的时间间隔进行	f
e3e67380-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:13.112	2018-11-18 14:12:13.112	t	t	e3e33f30-eaf8-11e8-a812-08d40c3d2417	按策划的时间间隔进行	t
e3e6e8b0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:13.115	2018-11-18 14:12:13.115	t	t	e3e33f30-eaf8-11e8-a812-08d40c3d2417	评价质量管理体系的持续适宜性、充分性、有效性	t
e3e736d0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:13.117	2018-11-18 14:12:13.117	t	t	e3e33f30-eaf8-11e8-a812-08d40c3d2417	进行各部门的绩效考核	f
fad5e170-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:51.591	2018-11-18 14:12:51.591	t	t	fad4f710-eaf8-11e8-a812-08d40c3d2417	纠正	t
fadff390-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:51.657	2018-11-18 14:12:51.657	t	t	fad4f710-eaf8-11e8-a812-08d40c3d2417	纠正措施	t
fae1c850-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:51.669	2018-11-18 14:12:51.669	t	t	fad4f710-eaf8-11e8-a812-08d40c3d2417	突变	t
fae34ef0-eaf8-11e8-a812-08d40c3d2417	2018-11-18 14:12:51.679	2018-11-18 14:12:51.679	t	t	fad4f710-eaf8-11e8-a812-08d40c3d2417	监视和测量	f
133d4960-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:13:32.534	2018-11-18 14:13:32.534	t	t	133c37f0-eaf9-11e8-a812-08d40c3d2417	可以不考虑不合格造成的影响，采取相同程度的纠正措施	f
133d9780-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:13:32.536	2018-11-18 14:13:32.536	t	t	133c37f0-eaf9-11e8-a812-08d40c3d2417	应评审采取的纠正措施的有效性	t
133e81e0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:13:32.542	2018-11-18 14:13:32.542	t	t	133c37f0-eaf9-11e8-a812-08d40c3d2417	采取纠正措施可能导致更新策划期间确定的风险和机遇	t
133ed000-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:13:32.544	2018-11-18 14:13:32.544	t	t	133c37f0-eaf9-11e8-a812-08d40c3d2417	应保留不合格的性质以及随后所采取的措施的形成文件的信息	t
25d3e480-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:03.72	2018-11-18 14:14:03.72	t	t	25d34840-eaf9-11e8-a812-08d40c3d2417	不合格的描述	t
25d5e050-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:03.733	2018-11-18 14:14:03.733	t	t	25d34840-eaf9-11e8-a812-08d40c3d2417	所采取措施	t
25d62e70-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:03.735	2018-11-18 14:14:03.735	t	t	25d34840-eaf9-11e8-a812-08d40c3d2417	顾客的反馈	f
25d65580-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:03.736	2018-11-18 14:14:03.736	t	t	25d34840-eaf9-11e8-a812-08d40c3d2417	处置不合格的授权信息	t
3a4f6c40-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:38.084	2018-11-18 14:14:38.084	t	t	3a4dbe90-eaf9-11e8-a812-08d40c3d2417	材料、零部件、工具和设备	t
3a500880-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:38.088	2018-11-18 14:14:38.088	t	t	3a4dbe90-eaf9-11e8-a812-08d40c3d2417	顾客的场所	t
3a500881-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:38.088	2018-11-18 14:14:38.088	t	t	3a4dbe90-eaf9-11e8-a812-08d40c3d2417	知识产权	t
3a500882-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:14:38.088	2018-11-18 14:14:38.088	t	t	3a4dbe90-eaf9-11e8-a812-08d40c3d2417	个人信息	t
5f358760-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:15:39.99	2018-11-18 14:15:39.99	t	t	509f8cf0-eaf9-11e8-a812-08d40c3d2417	顾客调查表	t
5f3698d0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:15:39.997	2018-11-18 14:15:39.997	t	t	509f8cf0-eaf9-11e8-a812-08d40c3d2417	顾客对交付产品或服务的反馈	t
5f36e6f0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:15:39.999	2018-11-18 14:15:39.999	t	t	509f8cf0-eaf9-11e8-a812-08d40c3d2417	经销商报告	t
5f37f860-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:15:40.006	2018-11-18 14:15:40.006	t	t	509f8cf0-eaf9-11e8-a812-08d40c3d2417	对销售合同的评审	f
8002e5f0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:16:35.023	2018-11-18 14:16:35.023	t	t	800074f0-eaf9-11e8-a812-08d40c3d2417	得到有关授权人员的批准	t
8002e5f1-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:16:35.023	2018-11-18 14:16:35.023	t	t	800074f0-eaf9-11e8-a812-08d40c3d2417	适用时得到顾客批准	t
80052fe0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:16:35.038	2018-11-18 14:16:35.038	t	t	800074f0-eaf9-11e8-a812-08d40c3d2417	得到最高领导同意	f
80052fe1-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:16:35.038	2018-11-18 14:16:35.038	t	t	800074f0-eaf9-11e8-a812-08d40c3d2417	得到放行产品或交付服务人员的同意	f
a1b944f0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:17:31.583	2018-11-18 14:17:31.583	t	t	a1b8a8b0-eaf9-11e8-a812-08d40c3d2417	组织按顾客的要求，从顾客指定的某钢材厂购买的原材料	f
a1b9ba20-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:17:31.586	2018-11-18 14:17:31.586	t	t	a1b8a8b0-eaf9-11e8-a812-08d40c3d2417	顾客提供的用于加工产品的模具	t
a1baa480-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:17:31.592	2018-11-18 14:17:31.592	t	t	a1b8a8b0-eaf9-11e8-a812-08d40c3d2417	宾馆服务台保管的顾客的贵重物品	t
a1bacb90-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:17:31.593	2018-11-18 14:17:31.593	t	t	a1b8a8b0-eaf9-11e8-a812-08d40c3d2417	某加工厂为加工顾客产品而购买的零部件	f
b897ea00-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:18:09.952	2018-11-18 14:18:09.952	t	t	b89726b0-eaf9-11e8-a812-08d40c3d2417	采购原材料	t
b8985f30-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:18:09.955	2018-11-18 14:18:09.955	t	t	b89726b0-eaf9-11e8-a812-08d40c3d2417	OEM生产	t
b89af740-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:18:09.972	2018-11-18 14:18:09.972	t	t	b89726b0-eaf9-11e8-a812-08d40c3d2417	生产过程外包	t
b89af741-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:18:09.972	2018-11-18 14:18:09.972	t	t	b89726b0-eaf9-11e8-a812-08d40c3d2417	由同一母公司下属的兄弟公司协作	t
d71f9e51-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:01.173	2018-11-18 14:19:01.173	t	t	d71d2d50-eaf9-11e8-a812-08d40c3d2417	顾客满意程度	t
d71f9e52-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:01.173	2018-11-18 14:19:01.173	t	t	d71d2d50-eaf9-11e8-a812-08d40c3d2417	产品和服务的符合性	t
d71f9e53-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:01.173	2018-11-18 14:19:01.173	t	t	d71d2d50-eaf9-11e8-a812-08d40c3d2417	资源提供的充分性	t
d71f9e54-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:01.173	2018-11-18 14:19:01.173	t	t	d71d2d50-eaf9-11e8-a812-08d40c3d2417	外部供方的绩效	t
eaf262f0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:34.431	2018-11-18 14:19:34.431	t	t	eaef2ea0-eaf9-11e8-a812-08d40c3d2417	潜在的风险	f
eaf262f1-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:34.431	2018-11-18 14:19:34.431	t	t	eaef2ea0-eaf9-11e8-a812-08d40c3d2417	管理评审的输出	t
eaf262f2-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:34.431	2018-11-18 14:19:34.431	t	t	eaef2ea0-eaf9-11e8-a812-08d40c3d2417	合同评审的结果	f
eaf262f3-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:19:34.431	2018-11-18 14:19:34.431	t	t	eaef2ea0-eaf9-11e8-a812-08d40c3d2417	分析、评价的结果	t
ffb9c0c0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:20:09.292	2018-11-18 14:20:09.292	t	t	ffb4dec0-eaf9-11e8-a812-08d40c3d2417	顾客投诉	t
ffba0ee0-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:20:09.294	2018-11-18 14:20:09.294	t	t	ffb4dec0-eaf9-11e8-a812-08d40c3d2417	质量目标的实现程度	t
ffba8410-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:20:09.297	2018-11-18 14:20:09.297	t	t	ffb4dec0-eaf9-11e8-a812-08d40c3d2417	产品和服务发生的不合格	t
ffbaab20-eaf9-11e8-a812-08d40c3d2417	2018-11-18 14:20:09.298	2018-11-18 14:20:09.298	t	t	ffb4dec0-eaf9-11e8-a812-08d40c3d2417	管理制度的完善情况	f
14fc4200-eafa-11e8-a812-08d40c3d2417	2018-11-18 14:20:44.96	2018-11-18 14:20:44.96	t	t	14fba5c0-eafa-11e8-a812-08d40c3d2417	法律法规要求	t
14fc9020-eafa-11e8-a812-08d40c3d2417	2018-11-18 14:20:44.962	2018-11-18 14:20:44.962	t	t	14fba5c0-eafa-11e8-a812-08d40c3d2417	与产品和服务相关的潜在不期望的后果	t
14fcb730-eafa-11e8-a812-08d40c3d2417	2018-11-18 14:20:44.963	2018-11-18 14:20:44.963	t	t	14fba5c0-eafa-11e8-a812-08d40c3d2417	顾客要求	t
14ff9d60-eafa-11e8-a812-08d40c3d2417	2018-11-18 14:20:44.982	2018-11-18 14:20:44.982	t	t	14fba5c0-eafa-11e8-a812-08d40c3d2417	其产品和服务的性质、用途和预期寿命	t
\.


--
-- Data for Name: sys_base_config; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sys_base_config (id, create_time, update_time, flag, status, system_name, copyright, web_site, allow_upload_image, allow_upload_file, allow_upload_media, allow_upload_flash, keywords, description) FROM stdin;
3f7b0890-e58c-11e8-8910-08d40c3d2417	2018-11-11 16:31:55.801	2018-11-11 16:32:08.916	t	t	新咨力教育教训系统	广州新咨力信息科技有限公司	http://www.enjoystudy.com.cn	gif,jpg,jpeg,png,bmp	doc,docx,xls,xlsx,ppt,pptx,pdf,et,wps,dps,txt,xz,zip,bzip2,rar,tar,gz,gzip,bz2,7z	swf,flv,mp3,mp4,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb	swf,flv		
dcbb8cd0-ea67-11e8-bb32-08d40c3d2417	2018-11-17 20:54:04.061	2018-11-17 20:54:04.061	t	t	新咨力教育培训系统	广州新咨力信息科技有限公司	http://www.enjoystudy.com.cn	gif,jpg,jpeg,png,bmp	doc,docx,xls,xlsx,ppt,pptx,pdf,et,wps,dps,txt,xz,zip,bzip2,rar,tar,gz,gzip,bz2,7z	swf,flv,mp3,mp4,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb	swf,flv	\N	\N
d04aa350-f05c-11e8-957f-08d40c3d2417	2018-11-25 10:50:05.701	2018-11-25 10:50:05.701	t	t	内审员在线培训系统	广州新咨力信息科技有限公司	http://www.enjoystudy.com.cn	gif,jpg,jpeg,png,bmp	doc,docx,xls,xlsx,ppt,pptx,pdf,et,wps,dps,txt,xz,zip,bzip2,rar,tar,gz,gzip,bz2,7z	swf,flv,mp3,mp4,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb	swf,flv	\N	\N
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
6249e650-c6e9-11e8-b813-08d40c3d2417	2018-10-03 16:50:31.349	2018-10-03 16:50:31.349	t	t	admin	127.0.0.1	2018-10-03 16:50:31.034	034FD793A4AA4B30177D687555B9F5AB	Computer	Chrome	t	成功登录！
5d3c9b20-c6ea-11e8-b813-08d40c3d2417	2018-10-03 16:57:32.37	2018-10-03 16:57:32.37	t	t	admin	127.0.0.1	2018-10-03 16:57:32.37	8510C6CA52FCC8FB75C9D6761D1FCE0C	Computer	Chrome	t	成功登录！
8214b2e0-c6f2-11e8-8bb8-08d40c3d2417	2018-10-03 17:55:50.158	2018-10-03 17:55:50.158	t	t	admin	127.0.0.1	2018-10-03 17:55:49.88	15AAF94B892C695755AF4C1FF1B97B77	Computer	Chrome	t	成功登录！
35817450-cc4b-11e8-88e6-08d40c3d2417	2018-10-10 13:13:22.709	2018-10-10 13:13:22.709	t	t	admin	127.0.0.1	2018-10-10 13:13:22.431	0A1DCB03D61E6307BFD162937F4ECE85	Computer	Chrome	t	成功登录！
8b567780-cd69-11e8-962a-08d40c3d2417	2018-10-11 23:23:02.776	2018-10-11 23:23:02.776	t	t	admin	127.0.0.1	2018-10-11 23:23:02.439	03D22C0FF41364F6D88CCF7CA0BC6EDD	Computer	Chrome	t	成功登录！
73d404b0-d917-11e8-921b-08d40c3d2417	2018-10-26 20:05:38.555	2018-10-26 20:05:38.555	t	t	admin	127.0.0.1	2018-10-26 20:05:38.272	14719F9A6E8B038AF2B315712DD6A550	Computer	Chrome	t	成功登录！
71ddc0b0-d91c-11e8-921b-08d40c3d2417	2018-10-26 20:41:22.747	2018-10-26 20:41:22.747	t	t	admin	127.0.0.1	2018-10-26 20:41:22.746	A1FA4D486239A5026D14EA281B14C8F4	Computer	Chrome	t	成功登录！
1803ce00-d925-11e8-91ab-08d40c3d2417	2018-10-26 21:43:17.472	2018-10-26 21:43:17.472	t	t	admin	127.0.0.1	2018-10-26 21:43:17.04	CD3B04CBD34C7B343FC69297F43438F5	Computer	Chrome	t	成功登录！
07f15370-d92a-11e8-ad1f-08d40c3d2417	2018-10-26 22:18:37.991	2018-10-26 22:18:37.991	t	t	admin	127.0.0.1	2018-10-26 22:18:37.703	440B83371A60F41919CFBFF64E3A274A	Computer	Chrome	t	成功登录！
6fd47370-d92d-11e8-8cc9-08d40c3d2417	2018-10-26 22:43:00.775	2018-10-26 22:43:00.775	t	t	admin	127.0.0.1	2018-10-26 22:43:00.496	BA3AC3F5D49FA5DE5B20FF07C8C5A9FA	Computer	Chrome	t	成功登录！
f77fe570-d92d-11e8-a917-08d40c3d2417	2018-10-26 22:46:48.391	2018-10-26 22:46:48.391	t	t	admin	127.0.0.1	2018-10-26 22:46:48.057	447F02C208014125D7CDFEFC2691D90A	Computer	Chrome	t	成功登录！
6727e170-d92e-11e8-97f3-08d40c3d2417	2018-10-26 22:49:55.719	2018-10-26 22:49:55.719	t	t	admin	127.0.0.1	2018-10-26 22:49:55.402	39F96A7E4B7054AA692C1E1D3FBE61B7	Computer	Chrome	t	成功登录！
d8b828a0-d932-11e8-97f3-08d40c3d2417	2018-10-26 23:21:44.234	2018-10-26 23:21:44.234	t	t	admin	127.0.0.1	2018-10-26 23:21:44.233	01FEE3D864D4493CA9DCA7337412FE91	Computer	Chrome	f	密码错误！
df4b0cf0-d932-11e8-97f3-08d40c3d2417	2018-10-26 23:21:55.263	2018-10-26 23:21:55.263	t	t	admin	127.0.0.1	2018-10-26 23:21:55.263	01FEE3D864D4493CA9DCA7337412FE91	Computer	Chrome	t	成功登录！
53de47f0-da08-11e8-8a1a-08d40c3d2417	2018-10-28 00:49:53.647	2018-10-28 00:49:53.647	t	t	admin	127.0.0.1	2018-10-28 00:49:53.349	CCA2073DE59EB29B6515D4EC3639955F	Computer	Chrome	t	成功登录！
03d9b400-da09-11e8-8a1a-08d40c3d2417	2018-10-28 00:54:48.896	2018-10-28 00:54:48.896	t	t	admin	127.0.0.1	2018-10-28 00:54:48.896	C5ECBEC2A3DDFCE56BB3E5D61C5A65E7	Computer	Chrome	t	成功登录！
b2c4abc0-da5c-11e8-8dbd-08d40c3d2417	2018-10-28 10:53:50.588	2018-10-28 10:53:50.588	t	t	admin	127.0.0.1	2018-10-28 10:53:50.309	C4A534AF00D661D92649E70A1105CF8D	Computer	Chrome	t	成功登录！
4766dec0-da6b-11e8-8dbd-08d40c3d2417	2018-10-28 12:38:12.908	2018-10-28 12:38:12.908	t	t	admin	127.0.0.1	2018-10-28 12:38:12.907	3FA44B55909061C84BE05FDCBDEC70B0	Computer	Chrome	t	成功登录！
7b8effc0-dc00-11e8-86f5-08d40c3d2417	2018-10-30 12:58:46.588	2018-10-30 12:58:46.588	t	t	admin	127.0.0.1	2018-10-30 12:58:46.255	F067D1BAD30AC8A451A634CA2D3E8F3A	Computer	Chrome	t	成功登录！
b1233f90-dc03-11e8-94d3-08d40c3d2417	2018-10-30 13:21:44.969	2018-10-30 13:21:44.969	t	t	admin	127.0.0.1	2018-10-30 13:21:44.671	553E05BDBEE954ECB0B7346E81CB6DAD	Computer	Chrome	f	验证码不正确！
baa2bc80-dc03-11e8-94d3-08d40c3d2417	2018-10-30 13:22:00.904	2018-10-30 13:22:00.904	t	t	admin	127.0.0.1	2018-10-30 13:22:00.904	553E05BDBEE954ECB0B7346E81CB6DAD	Computer	Chrome	t	成功登录！
f0b8f300-dc05-11e8-bcb8-08d40c3d2417	2018-10-30 13:37:50.641	2018-10-30 13:37:50.641	t	t	admin	127.0.0.1	2018-10-30 13:37:50.209	78F20363D0BBFF6871212A71556A1A9D	Computer	Chrome	t	成功登录！
6a2d2c60-dc06-11e8-b954-08d40c3d2417	2018-10-30 13:41:14.406	2018-10-30 13:41:14.406	t	t	admin	127.0.0.1	2018-10-30 13:41:14.015	C73E849825A34B307D70B4C4853F50FD	Computer	Chrome	t	成功登录！
fe1d1240-dc07-11e8-9f6a-08d40c3d2417	2018-10-30 13:52:32.1	2018-10-30 13:52:32.1	t	t	admin	127.0.0.1	2018-10-30 13:52:31.778	06F922D4C42520627C257E38C6005FD2	Computer	Chrome	t	成功登录！
f0eb35b0-dc49-11e8-a0d4-08d40c3d2417	2018-10-30 21:44:36.747	2018-10-30 21:44:36.747	t	t	admin	127.0.0.1	2018-10-30 21:44:36.364	D33BC466B1EDE5AF7D453289C27D8C74	Computer	Chrome	t	成功登录！
0d7aaa30-dc4f-11e8-a11b-08d40c3d2417	2018-10-30 22:21:12.147	2018-10-30 22:21:12.147	t	t	admin	127.0.0.1	2018-10-30 22:21:11.667	899D6ADDE7345BFFD4F5844976D67FF9	Computer	Chrome	t	成功登录！
7e1816d0-dc5c-11e8-b42c-08d40c3d2417	2018-10-30 23:57:24.541	2018-10-30 23:57:24.541	t	t	admin	127.0.0.1	2018-10-30 23:57:23.916	7B48B556371685452AFFE8739E163B56	Computer	Chrome	t	成功登录！
2a85c840-dc5d-11e8-b42c-08d40c3d2417	2018-10-31 00:02:13.828	2018-10-31 00:02:13.828	t	t	admin	127.0.0.1	2018-10-31 00:02:13.827	76C52875C218F46B0CCC5AC507C8DB95	Computer	Chrome	t	成功登录！
1a0b39e0-dc5e-11e8-bf7a-08d40c3d2417	2018-10-31 00:08:55.678	2018-10-31 00:08:55.678	t	t	admin	127.0.0.1	2018-10-31 00:08:55.197	4DA1D4C32F5A1445F606E379B9113442	Computer	Chrome	t	成功登录！
529c9f00-dc5f-11e8-8856-08d40c3d2417	2018-10-31 00:17:40.08	2018-10-31 00:17:40.08	t	t	admin	127.0.0.1	2018-10-31 00:17:39.559	204C2672182F4446FA24AE0F5FC32EC0	Computer	Chrome	t	成功登录！
be7b36f0-dc5f-11e8-a5a2-08d40c3d2417	2018-10-31 00:20:41.055	2018-10-31 00:20:41.055	t	t	admin	127.0.0.1	2018-10-31 00:20:40.519	AF10D4F2310C3894E1B5F44A98A10673	Computer	Chrome	t	成功登录！
2b5a00d0-dc60-11e8-8c66-08d40c3d2417	2018-10-31 00:23:43.709	2018-10-31 00:23:43.709	t	t	admin	127.0.0.1	2018-10-31 00:23:43.213	8EA5CA756215E10F66A8F49591C5F27F	Computer	Chrome	t	成功登录！
41e8e2c0-dc61-11e8-bfa0-08d40c3d2417	2018-10-31 00:31:31.052	2018-10-31 00:31:31.052	t	t	admin	127.0.0.1	2018-10-31 00:31:30.42	3ED3187CBB75498D0246A850026A3F35	Computer	Chrome	t	成功登录！
58de5a30-dd1c-11e8-9675-08d40c3d2417	2018-10-31 22:50:45.459	2018-10-31 22:50:45.459	t	t	admin	127.0.0.1	2018-10-31 22:50:44.722	6E3D68087839A1860BCB69A69826BAC6	Computer	Chrome	t	成功登录！
dd47c090-dd1c-11e8-9675-08d40c3d2417	2018-10-31 22:54:27.609	2018-10-31 22:54:27.609	t	t	admin	127.0.0.1	2018-10-31 22:54:27.609	49BB6AE067000FC64F1F977808A99272	Computer	Chrome	t	成功登录！
3e261c10-dd2a-11e8-9675-08d40c3d2417	2018-11-01 00:30:13.585	2018-11-01 00:30:13.585	t	t	admin	127.0.0.1	2018-11-01 00:30:13.585	B39195F8CB19C6E1889FD3AEC9D6EB60	Computer	Chrome	t	成功登录！
c042d350-dd2a-11e8-9675-08d40c3d2417	2018-11-01 00:33:51.877	2018-11-01 00:33:51.877	t	t	admin	127.0.0.1	2018-11-01 00:33:51.877	F9CDF67FC5C9F9C66C229E3AD8E966F4	Computer	Chrome	t	成功登录！
f72db460-dd2b-11e8-8c01-08d40c3d2417	2018-11-01 00:42:33.51	2018-11-01 00:42:33.51	t	t	admin	127.0.0.1	2018-11-01 00:42:32.888	6D166DADBA6122D0332A96AC7C496612	Computer	Chrome	t	成功登录！
ed6112a0-debc-11e8-9f8b-08d40c3d2417	2018-11-03 00:32:45.258	2018-11-03 00:32:45.258	t	t	admin	127.0.0.1	2018-11-03 00:32:44.6	6F6648FFEBBBA97EB5BB0D964101859C	Computer	Chrome	t	成功登录！
227cf8b0-dec1-11e8-a899-08d40c3d2417	2018-11-03 01:02:52.347	2018-11-03 01:02:52.347	t	t	admin	127.0.0.1	2018-11-03 01:02:51.827	90E2FA72A2EA205619F2C180122561EF	Computer	Chrome	t	成功登录！
6565eb40-dec2-11e8-ab83-08d40c3d2417	2018-11-03 01:11:54.101	2018-11-03 01:11:54.101	t	t	admin	127.0.0.1	2018-11-03 01:11:53.498	BCB974DF39D510EF8A78530807DFEB2B	Computer	Chrome	t	成功登录！
66de5a70-dec2-11e8-ab83-08d40c3d2417	2018-11-03 01:11:56.567	2018-11-03 01:11:56.567	t	t	admin	127.0.0.1	2018-11-03 01:11:56.362	BCB974DF39D510EF8A78530807DFEB2B	Computer	Chrome	t	成功登录！
0645e120-df2f-11e8-9a29-08d40c3d2417	2018-11-03 14:09:29.65	2018-11-03 14:09:29.65	t	t	admin	127.0.0.1	2018-11-03 14:09:28.855	EAE4FDC1A10EBA63CC2ED506C615D163	Computer	Chrome	t	成功登录！
b5be6c20-df30-11e8-9303-08d40c3d2417	2018-11-03 14:21:33.538	2018-11-03 14:21:33.538	t	t	admin	127.0.0.1	2018-11-03 14:21:32.893	82C03D67191B4278B9300B622BCB4A54	Computer	Chrome	t	成功登录！
a9dd1e80-df3d-11e8-9812-08d40c3d2417	2018-11-03 15:54:17.064	2018-11-03 15:54:17.064	t	t	admin	127.0.0.1	2018-11-03 15:54:16.387	F97B1E7D8F7E9A827D3EFE50D4BD1EA2	Computer	Chrome	t	成功登录！
927d1f00-df3e-11e8-833f-08d40c3d2417	2018-11-03 16:00:47.344	2018-11-03 16:00:47.344	t	t	admin	127.0.0.1	2018-11-03 16:00:46.736	9D7D0E87EDFE21C181ACEE43BF434DD2	Computer	Chrome	t	成功登录！
fcf1edc0-df3e-11e8-922e-08d40c3d2417	2018-11-03 16:03:45.948	2018-11-03 16:03:45.948	t	t	admin	127.0.0.1	2018-11-03 16:03:45.376	56F885D7D15CD960B588F526C1121EAB	Computer	Chrome	t	成功登录！
599cebb0-df3f-11e8-8a8e-08d40c3d2417	2018-11-03 16:06:21.419	2018-11-03 16:06:21.419	t	t	admin	127.0.0.1	2018-11-03 16:06:20.848	3AED169A6C0558AC12D3030AC3084B32	Computer	Chrome	t	成功登录！
a6202ba0-df3f-11e8-b2e0-08d40c3d2417	2018-11-03 16:08:29.786	2018-11-03 16:08:29.786	t	t	admin	127.0.0.1	2018-11-03 16:08:29.093	FC2C0C4FDD04B991616EFD7B1DC616B3	Computer	Chrome	t	成功登录！
a5a2f310-df44-11e8-b5a9-08d40c3d2417	2018-11-03 16:44:16.449	2018-11-03 16:44:16.449	t	t	admin	127.0.0.1	2018-11-03 16:44:15.945	11D85ADAD6C35BE7054071AAB2F54634	Computer	Chrome	t	成功登录！
225b9720-df47-11e8-8e75-08d40c3d2417	2018-11-03 17:02:04.69	2018-11-03 17:02:04.69	t	t	admin	127.0.0.1	2018-11-03 17:02:04.081	0F1D046E1D2CF4BD2E61339B3E768669	Computer	Chrome	t	成功登录！
c62da9b0-df4c-11e8-8e52-08d40c3d2417	2018-11-03 17:42:27.019	2018-11-03 17:42:27.019	t	t	admin	127.0.0.1	2018-11-03 17:42:26.454	1E63B42FDEFBC06062E44036FF1B57EE	Computer	Chrome	t	成功登录！
36e3ba50-df4d-11e8-a4d0-08d40c3d2417	2018-11-03 17:45:36.117	2018-11-03 17:45:36.117	t	t	admin	127.0.0.1	2018-11-03 17:45:35.323	2054C34DD38A14A8CFFD27AFD1C4FAFA	Computer	Chrome	t	成功登录！
3f8abc20-df4e-11e8-8872-08d40c3d2417	2018-11-03 17:53:00.13	2018-11-03 17:53:00.13	t	t	admin	127.0.0.1	2018-11-03 17:52:59.649	A78180BAC81A652E25B7F3B417821EC3	Computer	Chrome	f	验证码不正确！
44ef80b0-df4e-11e8-8872-08d40c3d2417	2018-11-03 17:53:09.179	2018-11-03 17:53:09.179	t	t	admin	127.0.0.1	2018-11-03 17:53:09.179	A78180BAC81A652E25B7F3B417821EC3	Computer	Chrome	t	成功登录！
c09b1700-df4f-11e8-ba9e-08d40c3d2417	2018-11-03 18:03:46.16	2018-11-03 18:03:46.16	t	t	admin	127.0.0.1	2018-11-03 18:03:45.388	A5A86EF92D8FE6637BA45A39144EC957	Computer	Chrome	t	成功登录！
34b3b390-df50-11e8-9d27-08d40c3d2417	2018-11-03 18:07:00.937	2018-11-03 18:07:00.937	t	t	admin	127.0.0.1	2018-11-03 18:07:00.499	7F9D11A42B470F81155824B5EB803E83	Computer	Chrome	t	成功登录！
a3054fe0-df67-11e8-9d27-08d40c3d2417	2018-11-03 20:54:44.446	2018-11-03 20:54:44.446	t	t	admin	127.0.0.1	2018-11-03 20:54:44.445	08BBF459D8091C94B5184F2F6A980F96	Computer	Chrome	t	成功登录！
a91f5f10-df85-11e8-82a4-08d40c3d2417	2018-11-04 00:29:39.585	2018-11-04 00:29:39.585	t	t	admin	127.0.0.1	2018-11-04 00:29:38.942	4EAFDC419325FDA6696DCA3DF13B9FAE	Computer	Chrome	t	成功登录！
6e51c920-dfd2-11e8-8a66-08d40c3d2417	2018-11-04 09:39:12.178	2018-11-04 09:39:12.178	t	t	admin	127.0.0.1	2018-11-04 09:39:11.727	088C0F83426D34B20BA903F707BE8937	Computer	Chrome	t	成功登录！
376f64d0-dfd7-11e8-8a66-08d40c3d2417	2018-11-04 10:13:27.581	2018-11-04 10:13:27.581	t	t	admin	127.0.0.1	2018-11-04 10:13:27.581	4EEB830490A5A849B9E88637F4F3B2B4	Computer	Chrome	t	成功登录！
e48711e0-dfd7-11e8-bc4f-08d40c3d2417	2018-11-04 10:18:17.982	2018-11-04 10:18:17.982	t	t	admin	127.0.0.1	2018-11-04 10:18:17.471	F4B277BC6DD579F1835C11633F3A5FC3	Computer	Chrome	t	成功登录！
ec0c0840-dfe0-11e8-a412-08d40c3d2417	2018-11-04 11:22:56.068	2018-11-04 11:22:56.068	t	t	admin	127.0.0.1	2018-11-04 11:22:55.644	62F4E14527B71CC4ECF363A5F5044399	Computer	Chrome	t	成功登录！
6267a510-dfe3-11e8-8e1e-08d40c3d2417	2018-11-04 11:40:33.633	2018-11-04 11:40:33.633	t	t	admin	127.0.0.1	2018-11-04 11:40:33.095	F32B9D0AD3DAEC671F8862640888784A	Computer	Chrome	t	成功登录！
cf521cd0-dfe5-11e8-b67d-08d40c3d2417	2018-11-04 11:57:55.357	2018-11-04 11:57:55.357	t	t	admin	127.0.0.1	2018-11-04 11:57:54.81	690D7A6DC4B2939A73AADED278335305	Computer	Chrome	t	成功登录！
04d852e0-dfe9-11e8-bed3-08d40c3d2417	2018-11-04 12:20:53.646	2018-11-04 12:20:53.646	t	t	admin	127.0.0.1	2018-11-04 12:20:52.905	E026AC2F3CCB5567279A2BD229DDD1ED	Computer	Chrome	t	成功登录！
30ade810-e027-11e8-b376-08d40c3d2417	2018-11-04 19:45:55.985	2018-11-04 19:45:55.985	t	t	admin	127.0.0.1	2018-11-04 19:45:55.551	3743097A039A39C1819C58F886B010DE	Computer	Chrome	t	成功登录！
7f89e0e0-e02e-11e8-91bd-08d40c3d2417	2018-11-04 20:38:14.766	2018-11-04 20:38:14.766	t	t	admin	127.0.0.1	2018-11-04 20:38:14.34	4B9A6F9FD4A488DA863A5A899E49DFB0	Computer	Chrome	t	成功登录！
807eabb0-e02f-11e8-b2f6-08d40c3d2417	2018-11-04 20:45:25.867	2018-11-04 20:45:25.867	t	t	admin	127.0.0.1	2018-11-04 20:45:25.365	76FD49D3A863ADD4AB605C377AA7859C	Computer	Chrome	t	成功登录！
b09ef6a0-e030-11e8-ab80-08d40c3d2417	2018-11-04 20:53:56.106	2018-11-04 20:53:56.106	t	t	admin	127.0.0.1	2018-11-04 20:53:55.618	0432698DA42908AEECA6630A8AEADA3A	Computer	Chrome	t	成功登录！
5d93bcf0-e032-11e8-b01d-08d40c3d2417	2018-11-04 21:05:55.775	2018-11-04 21:05:55.775	t	t	admin	127.0.0.1	2018-11-04 21:05:55.252	5788E46F9A174D019070ED315B53908F	Computer	Chrome	t	成功登录！
43cca880-e033-11e8-a8e5-08d40c3d2417	2018-11-04 21:12:22.024	2018-11-04 21:12:22.024	t	t	admin	127.0.0.1	2018-11-04 21:12:21.59	F5A3128FA89240197C4FEBD1E3676EC6	Computer	Chrome	t	成功登录！
9973b0d0-e033-11e8-b4b2-08d40c3d2417	2018-11-04 21:14:45.725	2018-11-04 21:14:45.725	t	t	admin	127.0.0.1	2018-11-04 21:14:45.295	6BE3881C05A80EDDC2B47DD46BD669E5	Computer	Chrome	t	成功登录！
3a7253e0-e040-11e8-a4b3-08d40c3d2417	2018-11-04 22:45:09.79	2018-11-04 22:45:09.79	t	t	admin	127.0.0.1	2018-11-04 22:45:09.424	6DFE2F60AA3949E06CC39706965A57AE	Computer	Chrome	t	成功登录！
d7365b80-e041-11e8-8ba2-08d40c3d2417	2018-11-04 22:56:42.296	2018-11-04 22:56:42.296	t	t	admin	127.0.0.1	2018-11-04 22:56:41.852	597DC81061BB70D0F7C99B0384AF4392	Computer	Chrome	f	验证码不正确！
dc5c4250-e041-11e8-8ba2-08d40c3d2417	2018-11-04 22:56:50.933	2018-11-04 22:56:50.933	t	t	admin	127.0.0.1	2018-11-04 22:56:50.932	597DC81061BB70D0F7C99B0384AF4392	Computer	Chrome	t	成功登录！
2a674c00-e048-11e8-baf0-08d40c3d2417	2018-11-04 23:41:58.848	2018-11-04 23:41:58.848	t	t	admin	127.0.0.1	2018-11-04 23:41:58.49	C799BC981F15AB004D82376D712FD360	Computer	Chrome	t	成功登录！
dbbe0dd0-e102-11e8-b881-08d40c3d2417	2018-11-05 21:58:22.765	2018-11-05 21:58:22.765	t	t	admin	127.0.0.1	2018-11-05 21:58:22.326	C68E898571EA721D68E6F9FB12A04A91	Computer	Chrome	t	成功登录！
dc489a90-e102-11e8-b881-08d40c3d2417	2018-11-05 21:58:23.673	2018-11-05 21:58:23.673	t	t	admin	127.0.0.1	2018-11-05 21:58:23.63	C68E898571EA721D68E6F9FB12A04A91	Computer	Chrome	t	成功登录！
737f8a00-e305-11e8-aae5-08d40c3d2417	2018-11-08 11:21:58.688	2018-11-08 11:21:58.688	t	t	admin	127.0.0.1	2018-11-08 11:21:58.206	767313E8A7CAC727A0C252BE8CFD6450	Computer	Chrome	t	成功登录！
3997e300-e41d-11e8-b2f5-08d40c3d2417	2018-11-09 20:44:40.624	2018-11-09 20:44:40.624	t	t	admin	127.0.0.1	2018-11-09 20:44:40.27	70F90FCE19E1D17740F47C4937E96B3E	Computer	Chrome	t	成功登录！
a2823550-e58a-11e8-add3-08d40c3d2417	2018-11-11 16:20:22.949	2018-11-11 16:20:22.949	t	t	admin	127.0.0.1	2018-11-11 16:20:22.503	C0D3CA2E597D5A2C46DE505CA14A0FAB	Computer	Chrome	t	成功登录！
95ef4160-e58b-11e8-8910-08d40c3d2417	2018-11-11 16:27:11.35	2018-11-11 16:27:11.35	t	t	admin	127.0.0.1	2018-11-11 16:27:10.798	898B1ACF648A670E212D4321F48D2520	Computer	Chrome	t	成功登录！
5ad93060-e58e-11e8-a8ca-08d40c3d2417	2018-11-11 16:47:00.71	2018-11-11 16:47:00.71	t	t	admin	127.0.0.1	2018-11-11 16:47:00.38	EE4BE9A63485434E76F6DBDB27B85CC5	Computer	Chrome	t	成功登录！
3b5cbad0-e599-11e8-a8ca-08d40c3d2417	2018-11-11 18:04:52.349	2018-11-11 18:04:52.349	t	t	admin	127.0.0.1	2018-11-11 18:04:52.349	EF7D25634F3E9A5A6269EEA80E8A54BF	Computer	Chrome	t	成功登录！
d08c9370-e74a-11e8-9435-08d40c3d2417	2018-11-13 21:48:34.727	2018-11-13 21:48:34.727	t	t	admin	127.0.0.1	2018-11-13 21:48:34.071	C74CF7CD63EEB1DFB998439931F251B8	Computer	Chrome	t	成功登录！
432bcca0-ea4f-11e8-b1de-08d40c3d2417	2018-11-17 17:57:58.506	2018-11-17 17:57:58.506	t	t	admin	127.0.0.1	2018-11-17 17:57:58.072	E6AF51021C72045613E87487DEB96BBE	Computer	Chrome	t	成功登录！
c6a14b30-ea51-11e8-bf1d-08d40c3d2417	2018-11-17 18:15:58.051	2018-11-17 18:15:58.051	t	t	admin	127.0.0.1	2018-11-17 18:15:57.662	806F286CEFE88DCAC114B3534FA51370	Computer	Chrome	t	成功登录！
c7354dd0-ea51-11e8-bf1d-08d40c3d2417	2018-11-17 18:15:59.021	2018-11-17 18:15:59.021	t	t	admin	127.0.0.1	2018-11-17 18:15:59.021	806F286CEFE88DCAC114B3534FA51370	Computer	Chrome	t	成功登录！
d6d31e80-ea55-11e8-a0e4-08d40c3d2417	2018-11-17 18:45:03.208	2018-11-17 18:45:03.208	t	t	admin	127.0.0.1	2018-11-17 18:45:02.802	EA54AE64025A7F75A24507BBD659FC9A	Computer	Chrome	t	成功登录！
ea65baf0-ea57-11e8-8c84-08d40c3d2417	2018-11-17 18:59:55.04	2018-11-17 18:59:55.04	t	t	admin	127.0.0.1	2018-11-17 18:59:54.592	D1A1ABD324A7D77ABDC5615C120D1208	Computer	Chrome	t	成功登录！
320f7470-ea5a-11e8-80bc-08d40c3d2417	2018-11-17 19:16:14.263	2018-11-17 19:16:14.263	t	t	admin	127.0.0.1	2018-11-17 19:16:13.886	5E4F9609DA5BE24E190E71181518A821	Computer	Chrome	t	成功登录！
388cf4a0-ea5d-11e8-bd0d-08d40c3d2417	2018-11-17 19:37:53.642	2018-11-17 19:37:53.642	t	t	admin	127.0.0.1	2018-11-17 19:37:53.237	824619EC1F834611209AB3D01D588950	Computer	Chrome	t	成功登录！
39493fc0-ea5d-11e8-bd0d-08d40c3d2417	2018-11-17 19:37:54.876	2018-11-17 19:37:54.876	t	t	admin	127.0.0.1	2018-11-17 19:37:54.876	824619EC1F834611209AB3D01D588950	Computer	Chrome	t	成功登录！
6739c780-ea60-11e8-94df-08d40c3d2417	2018-11-17 20:00:40.44	2018-11-17 20:00:40.44	t	t	admin	127.0.0.1	2018-11-17 20:00:40.041	AF29EBF715DD2B896437C8AE9E063E25	Computer	Chrome	t	成功登录！
cb4073d0-ea67-11e8-bb32-08d40c3d2417	2018-11-17 20:53:34.733	2018-11-17 20:53:34.733	t	t	admin	127.0.0.1	2018-11-17 20:53:34.324	9E60B300B7DDCECC5AB78FD5E0F358B5	Computer	Chrome	f	验证码不正确！
d2263310-ea67-11e8-bb32-08d40c3d2417	2018-11-17 20:53:46.306	2018-11-17 20:53:46.306	t	t	admin	127.0.0.1	2018-11-17 20:53:46.305	9E60B300B7DDCECC5AB78FD5E0F358B5	Computer	Chrome	t	成功登录！
837bff00-ea68-11e8-a274-08d40c3d2417	2018-11-17 20:58:43.824	2018-11-17 20:58:43.824	t	t	admin	127.0.0.1	2018-11-17 20:58:43.372	4FCB5A167BC0A5FD086AE41EF62B68B9	Computer	Chrome	t	成功登录！
9c6ece50-ea79-11e8-b80f-08d40c3d2417	2018-11-17 23:01:07.125	2018-11-17 23:01:07.125	t	t	admin	127.0.0.1	2018-11-17 23:01:06.764	0879152AB95079B794BED6A64F644CA6	Computer	Chrome	t	成功登录！
6f3bff00-ea7b-11e8-8316-08d40c3d2417	2018-11-17 23:14:10.288	2018-11-17 23:14:10.288	t	t	admin	127.0.0.1	2018-11-17 23:14:09.923	D92EA059D015DC0F4C6CC90D4D4FE118	Computer	Chrome	t	成功登录！
d59b01f0-ea7c-11e8-b146-08d40c3d2417	2018-11-17 23:24:11.535	2018-11-17 23:24:11.535	t	t	admin	127.0.0.1	2018-11-17 23:24:11.151	EFDC772505C733CB30B846BF88D80EC4	Computer	Chrome	t	成功登录！
1ddd3cd0-ea7d-11e8-a965-08d40c3d2417	2018-11-17 23:26:12.765	2018-11-17 23:26:12.765	t	t	admin	127.0.0.1	2018-11-17 23:26:12.421	1803FC82B83E8640C68D112A20B8FD7A	Computer	Chrome	t	成功登录！
63871cc0-ea81-11e8-97a9-08d40c3d2417	2018-11-17 23:56:47.628	2018-11-17 23:56:47.628	t	t	admin	127.0.0.1	2018-11-17 23:56:47.269	1F2006D31096233BECA7F3690A069075	Computer	Chrome	t	成功登录！
359c3d80-ea82-11e8-a812-08d40c3d2417	2018-11-18 00:02:40.088	2018-11-18 00:02:40.088	t	t	admin	127.0.0.1	2018-11-18 00:02:39.644	F625753B852D6C01F1DF2AB689250251	Computer	Chrome	t	成功登录！
fe526430-eadb-11e8-a812-08d40c3d2417	2018-11-18 10:45:22.035	2018-11-18 10:45:22.035	t	t	admin	127.0.0.1	2018-11-18 10:45:22.035	A24B7E2F3183863AEE291F30AED2A723	Computer	Chrome	t	成功登录！
f6a378d0-eaec-11e8-a812-08d40c3d2417	2018-11-18 12:46:50.589	2018-11-18 12:46:50.589	t	t	admin	127.0.0.1	2018-11-18 12:46:50.583	4DCA78ECE75B060AF620B43E98E65C57	Computer	Chrome	t	成功登录！
859d2d10-eb33-11e8-90c8-08d40c3d2417	2018-11-18 21:11:55.233	2018-11-18 21:11:55.233	t	t	admin	127.0.0.1	2018-11-18 21:11:54.844	B513B66AE41431EB4B49424A7311371A	Computer	Chrome	t	成功登录！
fb813ad0-eb33-11e8-89c5-08d40c3d2417	2018-11-18 21:15:13.021	2018-11-18 21:15:13.021	t	t	admin	127.0.0.1	2018-11-18 21:15:12.606	B4C7B1ACFDC9F89388357CFE41127E5C	Computer	Chrome	t	成功登录！
82745950-eb34-11e8-b892-08d40c3d2417	2018-11-18 21:18:59.429	2018-11-18 21:18:59.429	t	t	admin	127.0.0.1	2018-11-18 21:18:59.037	2B07297DA1982CCC9CED078FCB8E376D	Computer	Chrome	t	成功登录！
c5742610-f055-11e8-957f-08d40c3d2417	2018-11-25 09:59:41.041	2018-11-25 09:59:41.041	t	t	admin	127.0.0.1	2018-11-25 09:59:40.66	20B05A48EDD07EC5AC78C51D877EAFB3	Computer	Chrome	t	成功登录！
25cea200-f057-11e8-957f-08d40c3d2417	2018-11-25 10:09:32.192	2018-11-25 10:09:32.192	t	t	admin	127.0.0.1	2018-11-25 10:09:32.192	E092B26C7AAFC70E60EE148D763C0BE0	Computer	Chrome	t	成功登录！
df55f4d0-f05c-11e8-957f-08d40c3d2417	2018-11-25 10:50:30.941	2018-11-25 10:50:30.941	t	t	admin	127.0.0.1	2018-11-25 10:50:30.941	61B54C435A1A87C198F637A81B37D8A0	Computer	Chrome	t	成功登录！
f045a6d0-f095-11e8-b068-08d40c3d2417	2018-11-25 17:39:00.67	2018-11-25 17:39:00.67	t	t	admin	127.0.0.1	2018-11-25 17:39:00.262	B0C194F38361F33FB7D8BE4D8FB7BC5E	Computer	Chrome	t	成功登录！
30fc48b0-f09a-11e8-b068-08d40c3d2417	2018-11-25 18:09:27.227	2018-11-25 18:09:27.227	t	t	admin	127.0.0.1	2018-11-25 18:09:27.226	B0C194F38361F33FB7D8BE4D8FB7BC5E	Computer	Chrome	t	成功登录！
c9d95220-f09b-11e8-8027-08d40c3d2417	2018-11-25 18:20:53.186	2018-11-25 18:20:53.186	t	t	admin	127.0.0.1	2018-11-25 18:20:52.768	FA64C7366F039F3D462005C6579D66D5	Computer	Chrome	t	成功登录！
fe26a820-f0a0-11e8-8027-08d40c3d2417	2018-11-25 18:58:08.418	2018-11-25 18:58:08.418	t	t	admin	127.0.0.1	2018-11-25 18:58:08.418	FA64C7366F039F3D462005C6579D66D5	Computer	Chrome	t	成功登录！
8b3693c0-f0a5-11e8-b407-08d40c3d2417	2018-11-25 19:30:43.068	2018-11-25 19:30:43.068	t	t	admin	127.0.0.1	2018-11-25 19:30:42.712	42A8AE0FECBEB70AF5EA35465DCBE003	Computer	Chrome	t	成功登录！
02d5f0a0-f0a7-11e8-87ed-08d40c3d2417	2018-11-25 19:41:13.258	2018-11-25 19:41:13.258	t	t	admin	127.0.0.1	2018-11-25 19:41:12.837	3F1F779C919267ED84A0B995A7815BFE	Computer	Chrome	t	成功登录！
48a18960-f0ab-11e8-95a4-08d40c3d2417	2018-11-25 20:11:48.342	2018-11-25 20:11:48.342	t	t	admin	127.0.0.1	2018-11-25 20:11:47.972	B7FC3298C6D496F20776FD2E3470CCE9	Computer	Chrome	t	成功登录！
ad9f9da0-f229-11e8-8f4b-08d40c3d2417	2018-11-27 17:49:05.53	2018-11-27 17:49:05.53	t	t	admin	127.0.0.1	2018-11-27 17:49:05.053	BC3593BFBBDA1D29E5C832676FEE5450	Computer	Chrome	t	成功登录！
8b0f0710-f230-11e8-af1d-08d40c3d2417	2018-11-27 18:38:14.017	2018-11-27 18:38:14.017	t	t	admin	127.0.0.1	2018-11-27 18:38:13.313	6793A8425E3E88910675C137AD782359	Computer	Chrome	t	成功登录！
8bb1afb0-f230-11e8-af1d-08d40c3d2417	2018-11-27 18:38:15.083	2018-11-27 18:38:15.083	t	t	admin	127.0.0.1	2018-11-27 18:38:15.082	6793A8425E3E88910675C137AD782359	Computer	Chrome	t	成功登录！
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
30f3f880-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:19:45.16	2018-10-02 01:19:45.16	t	t	xxzx-jsgl	老师管理	/manage/study/teacher/index.jhtml	1	\N	\N	\N	\N	t	22	974add90-c57d-11e8-bd7f-08d40c3d2417
57cf05d0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:20:50.349	2018-10-02 01:20:50.349	t	t	xxzx-jsgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	30f3f880-c59e-11e8-a4be-08d40c3d2417
6563bce0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:21:13.134	2018-10-02 01:21:13.134	t	t	xxzx-jsgl-add	添加	\N	2	\N	\N	\N	\N	t	32	30f3f880-c59e-11e8-a4be-08d40c3d2417
6fe8c2f0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:21:30.783	2018-10-02 01:21:30.783	t	t	xxzx-jsgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	30f3f880-c59e-11e8-a4be-08d40c3d2417
7aca40e0-c59e-11e8-a4be-08d40c3d2417	2018-10-02 01:21:49.038	2018-10-02 01:21:49.038	t	t	xxzx-jsgl-del	删除	\N	2	\N	\N	\N	\N	t	34	30f3f880-c59e-11e8-a4be-08d40c3d2417
e2067da0-c611-11e8-ac0d-08d40c3d2417	2018-10-02 15:07:54.362	2018-10-02 15:08:38.195	t	t	xxzx-kcgl	课程管理	/manage/study/course/index.jhtml	1	\N	\N	\N	\N	t	23	974add90-c57d-11e8-bd7f-08d40c3d2417
16922e70-c612-11e8-ac0d-08d40c3d2417	2018-10-02 15:09:22.519	2018-10-02 15:09:22.519	t	t	xxzx-kcgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	e2067da0-c611-11e8-ac0d-08d40c3d2417
98cfaa20-da08-11e8-8a1a-08d40c3d2417	2018-10-28 00:51:49.314	2018-10-28 00:52:14.304	t	t	xxzx-lxtgl	练习题管理	/manage/study/exercise/index.jhtml	1	\N	\N	\N	\N	t	24	974add90-c57d-11e8-bd7f-08d40c3d2417
c92d41a0-da08-11e8-8a1a-08d40c3d2417	2018-10-28 00:53:10.458	2018-10-28 00:53:10.458	t	t	xxzx-lxtgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	98cfaa20-da08-11e8-8a1a-08d40c3d2417
d5a760f0-da08-11e8-8a1a-08d40c3d2417	2018-10-28 00:53:31.391	2018-10-28 00:53:31.391	t	t	xxzx-lxtgl-add	添加	\N	2	\N	\N	\N	\N	t	32	98cfaa20-da08-11e8-8a1a-08d40c3d2417
e9b11410-da08-11e8-8a1a-08d40c3d2417	2018-10-28 00:54:05.009	2018-10-28 00:54:05.009	t	t	xxzx-lxtgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	98cfaa20-da08-11e8-8a1a-08d40c3d2417
f529c8f0-da08-11e8-8a1a-08d40c3d2417	2018-10-28 00:54:24.255	2018-10-28 00:54:24.255	t	t	xxzx-lxtgl-del	删除	\N	2	\N	\N	\N	\N	t	34	98cfaa20-da08-11e8-8a1a-08d40c3d2417
b738b910-dc5c-11e8-b42c-08d40c3d2417	2018-10-30 23:59:00.385	2018-10-30 23:59:21.729	t	t	xxzx-kstgl	考试题管理	/manage/study/examination/index.jhtml	1	\N	\N	\N	\N	t	25	974add90-c57d-11e8-bd7f-08d40c3d2417
f6b02100-dc5c-11e8-b42c-08d40c3d2417	2018-10-31 00:00:46.864	2018-10-31 00:00:46.864	t	t	xxzx-kstgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	b738b910-dc5c-11e8-b42c-08d40c3d2417
00fbc790-dc5d-11e8-b42c-08d40c3d2417	2018-10-31 00:01:04.137	2018-10-31 00:01:04.137	t	t	xxzx-kstgl-add	添加	\N	2	\N	\N	\N	\N	t	32	b738b910-dc5c-11e8-b42c-08d40c3d2417
09959f70-dc5d-11e8-b42c-08d40c3d2417	2018-10-31 00:01:18.567	2018-10-31 00:01:18.567	t	t	xxzx-kstgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	b738b910-dc5c-11e8-b42c-08d40c3d2417
1454a140-dc5d-11e8-b42c-08d40c3d2417	2018-10-31 00:01:36.596	2018-10-31 00:01:36.596	t	t	xxzx-kstgl-del	删除	\N	2	\N	\N	\N	\N	t	34	b738b910-dc5c-11e8-b42c-08d40c3d2417
8b8b11d0-dd1c-11e8-9675-08d40c3d2417	2018-10-31 22:52:10.477	2018-10-31 22:52:10.477	t	t	xxzx-kcspxx	课程视频学习	/manage/study/course-study/index.jhtml	1	\N	\N	\N	\N	t	26	974add90-c57d-11e8-bd7f-08d40c3d2417
ae08df80-dd1c-11e8-9675-08d40c3d2417	2018-10-31 22:53:08.344	2018-10-31 22:53:08.344	t	t	xxzx-kcspxx-sel	查看	\N	2	\N	\N	\N	\N	t	31	8b8b11d0-dd1c-11e8-9675-08d40c3d2417
cc1fd0a0-dd1c-11e8-9675-08d40c3d2417	2018-10-31 22:53:58.826	2018-10-31 22:53:58.826	t	t	xxzx-kcspxx-view	学习	\N	2	\N	\N	\N	\N	t	32	8b8b11d0-dd1c-11e8-9675-08d40c3d2417
b86a9dc0-dd2a-11e8-9675-08d40c3d2417	2018-11-01 00:33:38.716	2018-11-01 00:33:38.716	t	t	xxzx-kcxxqk-sel	查看	\N	2	\N	\N	\N	\N	t	31	99d554e0-dd2a-11e8-9675-08d40c3d2417
99d554e0-dd2a-11e8-9675-08d40c3d2417	2018-11-01 00:32:47.406	2018-11-01 00:48:45.778	t	t	xxzx-kcxxqk	课程学习情况	/manage/study/course-study/course-index.jhtml	1	\N	\N	\N	\N	t	27	974add90-c57d-11e8-bd7f-08d40c3d2417
10f643c0-debd-11e8-9f8b-08d40c3d2417	2018-11-03 00:33:44.956	2018-11-03 00:33:44.956	t	t	rzzx	认证中心	\N	1	\N	\N	\N	\N	t	14	\N
974add90-c57d-11e8-bd7f-08d40c3d2417	2018-10-01 21:26:23.465	2018-11-03 00:34:24.087	t	t	xxzx	学习中心	\N	1	\N	\N	\N	\N	t	13	\N
b964b410-debd-11e8-9f8b-08d40c3d2417	2018-11-03 00:38:27.537	2018-11-03 00:38:27.537	t	t	rzzx-zssz	证书设置	/manage/study/certificate/index.jhtml	1	\N	\N	\N	\N	t	21	10f643c0-debd-11e8-9f8b-08d40c3d2417
dee64be0-debd-11e8-9f8b-08d40c3d2417	2018-11-03 00:39:30.462	2018-11-03 00:39:30.462	t	t	rzzx-zssz-sel	查看	\N	2	\N	\N	\N	\N	t	31	b964b410-debd-11e8-9f8b-08d40c3d2417
ef1276b0-debd-11e8-9f8b-08d40c3d2417	2018-11-03 00:39:57.595	2018-11-03 00:39:57.595	t	t	rzzx-zssz-add	添加	\N	2	\N	\N	\N	\N	t	32	b964b410-debd-11e8-9f8b-08d40c3d2417
fe7de990-debd-11e8-9f8b-08d40c3d2417	2018-11-03 00:40:23.465	2018-11-03 00:40:23.465	t	t	rzzx-zssz-edit	编辑	\N	2	\N	\N	\N	\N	t	33	b964b410-debd-11e8-9f8b-08d40c3d2417
0b7b42a0-debe-11e8-9f8b-08d40c3d2417	2018-11-03 00:40:45.258	2018-11-03 00:40:45.258	t	t	rzzx-zssz-del	删除	\N	2	\N	\N	\N	\N	t	34	b964b410-debd-11e8-9f8b-08d40c3d2417
de265a60-df85-11e8-82a4-08d40c3d2417	2018-11-04 00:31:08.55	2018-11-04 00:31:08.55	t	t	kxzx	考试中心	\N	1	\N	\N	\N	\N	t	15	\N
0d43d0c0-df86-11e8-82a4-08d40c3d2417	2018-11-04 00:32:27.596	2018-11-04 00:32:27.596	t	t	kxzx-kcks-test	考试	\N	2	\N	\N	\N	\N	t	31	0050d7f0-df86-11e8-82a4-08d40c3d2417
573d6d70-e027-11e8-b376-08d40c3d2417	2018-11-04 19:47:00.679	2018-11-04 19:47:48.808	t	t	sjgl	试卷管理	\N	1	\N	\N	\N	\N	t	16	\N
9d30af40-e027-11e8-b376-08d40c3d2417	2018-11-04 19:48:58.036	2018-11-04 19:48:58.036	t	t	sjgl-kjgl	考卷管理	/manage/study/store-paper/paper-index.jhtml	1	\N	\N	\N	\N	t	21	573d6d70-e027-11e8-b376-08d40c3d2417
ab0a5e90-e027-11e8-b376-08d40c3d2417	2018-11-04 19:49:21.273	2018-11-04 19:49:21.273	t	t	sjgl-kjgl-sel	查询	\N	2	\N	\N	\N	\N	t	31	9d30af40-e027-11e8-b376-08d40c3d2417
bab6f920-e027-11e8-b376-08d40c3d2417	2018-11-04 19:49:47.57	2018-11-04 19:49:47.57	t	t	sjgl-kjgl-add	添加	\N	2	\N	\N	\N	\N	t	32	9d30af40-e027-11e8-b376-08d40c3d2417
c3ab9b30-e027-11e8-b376-08d40c3d2417	2018-11-04 19:50:02.595	2018-11-04 19:50:02.595	t	t	sjgl-kjgl-edit	编辑	\N	2	\N	\N	\N	\N	t	33	9d30af40-e027-11e8-b376-08d40c3d2417
ce5b33b0-e027-11e8-b376-08d40c3d2417	2018-11-04 19:50:20.523	2018-11-04 19:50:20.523	t	t	sjgl-kjgl-del	删除	\N	2	\N	\N	\N	\N	t	34	9d30af40-e027-11e8-b376-08d40c3d2417
ec5d1190-e58a-11e8-add3-08d40c3d2417	2018-11-11 16:22:26.857	2018-11-11 16:22:26.857	t	t	xtgl-xtsz-edit	编辑	\N	2	\N	\N	\N	\N	t	31	d2b4ec40-e58a-11e8-add3-08d40c3d2417
d2b4ec40-e58a-11e8-add3-08d40c3d2417	2018-11-11 16:21:43.812	2018-11-11 16:23:20.663	t	t	xtgl-xtsz	系统设置	/manage/system/sys-base-config/edit.jhtml	1	\N	\N	\N	\N	t	24	8da95cc0-9b17-11e8-a3d3-4cedfb4009ed
7244b250-ea53-11e8-bf1d-08d40c3d2417	2018-11-17 18:27:55.509	2018-11-17 18:27:55.509	t	t	ksgl	考试管理	\N	1	\N	\N	\N	\N	t	17	\N
d82c7ee0-ea53-11e8-bf1d-08d40c3d2417	2018-11-17 18:30:46.478	2018-11-17 18:30:46.478	t	t	ksgl-kssz	考试设置	/manage/study/examination-config/edit.jhtml	1	\N	\N	\N	\N	t	21	7244b250-ea53-11e8-bf1d-08d40c3d2417
e78fb460-ea53-11e8-bf1d-08d40c3d2417	2018-11-17 18:31:12.294	2018-11-17 18:31:12.294	t	t	ksgl-kssz-edit	编辑	\N	2	\N	\N	\N	\N	t	31	d82c7ee0-ea53-11e8-bf1d-08d40c3d2417
483d14d0-ea61-11e8-94df-08d40c3d2417	2018-11-17 20:06:57.949	2018-11-17 20:06:57.949	t	t	ksgl-kcksgl	课程考试管理	/manage/study/course/examination.jhtml	1	\N	\N	\N	\N	t	22	7244b250-ea53-11e8-bf1d-08d40c3d2417
58f7eb10-ea61-11e8-94df-08d40c3d2417	2018-11-17 20:07:26.018	2018-11-17 20:07:26.018	t	t	ksgl-kcksgl-edit	编辑	\N	2	\N	\N	\N	\N	t	31	483d14d0-ea61-11e8-94df-08d40c3d2417
0050d7f0-df86-11e8-82a4-08d40c3d2417	2018-11-04 00:32:05.871	2018-11-17 23:15:11.722	t	t	kxzx-kcks	课程考试	/manage/study/employee-examination/course-index.jhtml	1	\N	\N	\N	\N	t	21	de265a60-df85-11e8-82a4-08d40c3d2417
73a604d0-f09a-11e8-b068-08d40c3d2417	2018-11-25 18:11:19.069	2018-11-25 18:11:19.069	t	t	sjgl-kjsh	考卷审核	/manage/study/store-paper/audit-index.jhtml	1	\N	\N	\N	\N	t	22	573d6d70-e027-11e8-b376-08d40c3d2417
b378fa40-f09a-11e8-b068-08d40c3d2417	2018-11-25 18:13:06.148	2018-11-25 18:13:06.148	t	t	sjgl-kjsh-sel	查询	\N	2	\N	\N	\N	\N	t	31	73a604d0-f09a-11e8-b068-08d40c3d2417
c1152b60-f09a-11e8-b068-08d40c3d2417	2018-11-25 18:13:28.982	2018-11-25 18:13:28.982	t	t	sjgl-kjsh-edit	审核	\N	2	\N	\N	\N	\N	t	32	73a604d0-f09a-11e8-b068-08d40c3d2417
92015400-f231-11e8-af1d-08d40c3d2417	2018-11-27 18:45:35.168	2018-11-27 18:45:35.168	t	t	kcgl	课程管理	\N	1	\N	\N	\N	\N	t	13	\N
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
e62d9f80-dfe3-11e8-8e1e-08d40c3d2417	2018-11-04 11:44:14.712	2018-11-04 11:44:14.712	t	t	刘娟	\N	/uploads/image/2018/11/4/1144111487891125.jpg	化学工程与工艺， 学士学位\r\nCCAA注册的质量/环境/职业健康与安全审核员、高级咨询师。\r\n8年大型制造企业体系管理经验，独立推行ISO9001、ISO14001及OHSAS18001管理体系；独立开发体系管理类课件，并组织培训；\r\n现从事企业管理咨询工作， 致力于企业可持续发展和绿色生产力促进。负责培训与辅导工作。\r\n个人特点与工作简历\r\n专长：\r\n在制造业的质量管理、体系管理等方面具有丰富的实战经验\r\n具有较强的沟通和协调能力\r\n擅长企业的流程再造管理，对流程运作原理有很深刻的理解。\r\n擅长高级审核技巧的训练\r\n对企业体系策划和文件梳理方面有丰富的实战经验。\r\n咨询辅导：当日事当日闭的行事风格。另有耐心、具有强的沟通和协调能力。\r\n讲课风格：通俗易懂、语言生动诙谐；通过案例讲解，让枯燥难懂的专业知识变得易于理解\r\n企业经历：本人曾于某大型企业负责多体系的推进和维护工作，先后负责体系的策划、文件编写及内审员培训等工作；后在某认证机构从事认证审核、培训的工作，目前从事培训与咨询工作。\r\n经手案例\r\n中山欧科电子\r\n新宝电器\r\n深圳科立达\r\n东莞佰利\r\n中山泰腾照明	<p>化学工程与工艺， 学士学位</p><p>CCAA注册的质量/环境/职业健康与安全审核员、高级咨询师。</p><p>8年大型制造企业体系管理经验，独立推行ISO9001、ISO14001及OHSAS18001管理体系；独立开发体系管理类课件，并组织培训；</p><p>现从事企业管理咨询工作， 致力于企业可持续发展和绿色生产力促进。负责培训与辅导工作。</p><p>个人特点与工作简历</p><p>专长：</p><p>在制造业的质量管理、体系管理等方面具有丰富的实战经验</p><p>具有较强的沟通和协调能力</p><p>擅长企业的流程再造管理，对流程运作原理有很深刻的理解。</p><p>擅长高级审核技巧的训练</p><p>对企业体系策划和文件梳理方面有丰富的实战经验。</p><p>咨询辅导：当日事当日闭的行事风格。另有耐心、具有强的沟通和协调能力。</p><p>讲课风格：通俗易懂、语言生动诙谐；通过案例讲解，让枯燥难懂的专业知识变得易于理解</p><p>企业经历：本人曾于某大型企业负责多体系的推进和维护工作，先后负责体系的策划、文件编写及内审员培训等工作；后在某认证机构从事认证审核、培训的工作，目前从事培训与咨询工作。</p><p>经手案例</p><p>中山欧科电子</p><p>新宝电器</p><p>深圳科立达</p><p>东莞佰利</p><p>中山泰腾照明</p>
23b06360-dfe4-11e8-8e1e-08d40c3d2417	2018-11-04 11:45:57.91	2018-11-04 11:45:57.91	t	t	张锁	\N	/uploads/image/2018/11/4/1145530444222919.jpg	职位：高级讲师、咨询项目经理、高级审核员\r\n经手案例：\r\n一汽大众 \r\n五羊本田 \r\n富士康 \r\n美的\r\n中兴通讯\r\n三菱电机\r\n佛上科勒\r\n广日电梯\r\n白云化工\r\n东丽塑料精密（中山）\r\n专长： \r\n在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验 \r\n具有较强的沟通和协调能力\r\n擅长企业的流程再造管理，对流程运作原理有很深刻的理解\r\n擅长高级审核技巧的训练\r\n对企业有害物质的管理方面有丰富的实战经验\r\n能力领域：\r\n企业供应链管理研究\r\n流程优化及绩效改善\r\n有害物质管理\r\n高级审核技巧\r\n企业知识体系管理\r\n企业培训系统\r\n企业经历：本人曾于某上市公司先后负责质量管理，及各类管理体系的领导工作，后在莱因TUV从事认证\r\n核、培训的工作，目前从事培训与咨询工作\r\n工作经验：20年工作经验，10年工厂管理工作经验，10年认证审核、综合管理咨询及培工作经验\r\n咨询辅导：当日事当日闭的行事风格。另有耐心、具有强的沟通和协调能力\r\n讲课风格：通俗易懂、语言生动诙谐；通过案例讲解，让枯燥难懂的专业知识变得易于理解	<p>职位：高级讲师、咨询项目经理、高级审核员</p><p>经手案例：</p><p>一汽大众&nbsp;</p><p>五羊本田&nbsp;</p><p>富士康&nbsp;</p><p>美的</p><p>中兴通讯</p><p>三菱电机</p><p>佛上科勒</p><p>广日电梯</p><p>白云化工</p><p>东丽塑料精密（中山）</p><p>专长：&nbsp;</p><p>在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验&nbsp;</p><p>具有较强的沟通和协调能力</p><p>擅长企业的流程再造管理，对流程运作原理有很深刻的理解</p><p>擅长高级审核技巧的训练</p><p>对企业有害物质的管理方面有丰富的实战经验</p><p>能力领域：</p><p>企业供应链管理研究</p><p>流程优化及绩效改善</p><p>有害物质管理</p><p>高级审核技巧</p><p>企业知识体系管理</p><p>企业培训系统</p><p>企业经历：本人曾于某上市公司先后负责质量管理，及各类管理体系的领导工作，后在莱因TUV从事认证</p><p>核、培训的工作，目前从事培训与咨询工作</p><p>工作经验：20年工作经验，10年工厂管理工作经验，10年认证审核、综合管理咨询及培工作经验</p><p>咨询辅导：当日事当日闭的行事风格。另有耐心、具有强的沟通和协调能力</p><p>讲课风格：通俗易懂、语言生动诙谐；通过案例讲解，让枯燥难懂的专业知识变得易于理解&nbsp;</p><p><br/></p>
6b741f70-dfe4-11e8-8e1e-08d40c3d2417	2018-11-04 11:47:58.311	2018-11-04 11:47:58.311	t	t	古清飞	\N	/uploads/image/2018/11/4/1147276784535143.jpg	古清飞: 笔名道易，男，47岁，天津大学工学硕士，BIS国内最早的审核员。从事企业咨询辅导18年，咨询辅导的企业超过300家\r\n专长： \r\n在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验 \r\n具有强大的沟通和协调能力 \r\n擅长企业的流程再造管理，对流程运作原理有很深刻的理解\r\n咨询辅导：当日事当日闭的行事风格。另有耐心、具有强大沟通和协调能力\r\n讲课风格：通俗易懂、语言生动诙谐；通过案例讲解，让枯燥难懂的专业知识变得易于理解\r\n经手案例：\r\n同维电子\r\n康佳电子 \r\n榄菊集团\r\n澳雪国际等\r\n三菱电机（广州）压缩机\r\n佛山科勒\r\n白云化工\r\n东丽塑料精密（中山）\r\n广州开发区管委会\r\n日丰企业集团	<p>古清飞: 笔名道易，男，47岁，天津大学工学硕士，BIS国内最早的审核员。从事企业咨询辅导18年，咨询辅导的企业超过300家</p><p>专长：&nbsp;</p><p>在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验&nbsp;</p><p>具有强大的沟通和协调能力&nbsp;</p><p>擅长企业的流程再造管理，对流程运作原理有很深刻的理解</p><p>咨询辅导：当日事当日闭的行事风格。另有耐心、具有强大沟通和协调能力</p><p>讲课风格：通俗易懂、语言生动诙谐；通过案例讲解，让枯燥难懂的专业知识变得易于理解</p><p>经手案例：</p><p>同维电子</p><p>康佳电子&nbsp;</p><p>榄菊集团</p><p>澳雪国际等</p><p>三菱电机（广州）压缩机</p><p>佛山科勒</p><p>白云化工</p><p>东丽塑料精密（中山）</p><p>广州开发区管委会</p><p>日丰企业集团</p><p><br/></p>
98639240-dfe4-11e8-8e1e-08d40c3d2417	2018-11-04 11:49:13.7	2018-11-04 11:49:13.7	t	t	计红琰	\N	/uploads/image/2018/11/4/1148433811840520.jpg	计红琰 本人97年大学毕业后（获学士学位），曾于香港某上市公司负责内审工作，并在其上海办事处负责国内部分业务；后在中山一家大型制造公司负责采购、生管工作；再在一家灯饰公司负责销售、管理及客服工作；现在在广州新咨力信息科技有限公司从事业务及项目管理工作。本人有较强的沟通协调能力，在销售、管理及客服方面具有丰富的工作经验。	<p>计红琰 本人97年大学毕业后（获学士学位），曾于香港某上市公司负责内审工作，并在其上海办事处负责国内部分业务；后在中山一家大型制造公司负责采购、生管工作；再在一家灯饰公司负责销售、管理及客服工作；现在在广州新咨力信息科技有限公司从事业务及项目管理工作。本人有较强的沟通协调能力，在销售、管理及客服方面具有丰富的工作经验。</p>
cf17c860-dfe4-11e8-8e1e-08d40c3d2417	2018-11-04 11:50:45.478	2018-11-04 11:50:45.478	t	t	方敬丰	\N	/uploads/image/2018/11/4/1150320972556541.jpg	新咨力高级讲师、高级咨询师、工业分析工程师、经济师、清洁生产审核师。\r\n广东省劳模，国家高新技术企业高管，25年质量管理实战经验，多体系（ISO9001、ISO14001、OHSAS18001、ISO/TS16949、QC080000）管理专家；\r\n辅导过富仕康、三井化学、佛山科勒、东丽塑料（中山）等多家知名企业	<p>新咨力高级讲师、高级咨询师、工业分析工程师、经济师、清洁生产审核师。</p><p>广东省劳模，国家高新技术企业高管，25年质量管理实战经验，多体系（ISO9001、ISO14001、OHSAS18001、ISO/TS16949、QC080000）管理专家；</p><p>辅导过富仕康、三井化学、佛山科勒、东丽塑料（中山）等多家知名企业</p>
4928b6f0-dfe5-11e8-8e1e-08d40c3d2417	2018-11-04 11:54:10.271	2018-11-04 11:58:03.337	t	t	涂绍华	\N	/uploads/image/2018/11/4/115240253530845.jpg	高级讲师、高级咨询师、ISO13485项目经理\r\n20年质量管理实战经验，多体系管理专家。 \r\n曾任医疗器械行业高新技术企业品质经理、汽车行业企业生产部长，对质量管理理论与实践、人员培训有较强的能力。\r\n个人特点与工作简历\r\n专长：\r\n在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验\r\n擅长医疗器械行业及汽车行业体系标准及工具类课程的讲解，有丰富的实战经验。\r\n擅长企业体系策划和流程再造管理，对流程运作原理有很深刻的理解。\r\n咨询辅导：细心周到，工作作风严谨高效、诚信务实，\r\n讲课风格：深入浅出、活泼生动、极富激情深受企业和学员欢迎。\r\n个人简介及经历：曾就职于医疗器械行业企业佛山南海建泰铝制品有限公司担任品质经理，汽车行业企业担任生产部长，有丰富的生产制造、质量、管理体系统的实战经验，对ISO13485&IATF16949质量管理体系、五大核心工具运用及培训、工厂流程再造有丰富的实战、推广、应用经验和十多年以上的工作经历；\r\n经手案例\r\n南海建泰铝制品有限公司\r\n东升机械制造有限公司\r\n三井化学\r\n格力电器\r\n富士康\r\n佛山科勒\r\n东丽塑料精密（中山）\r\n广州开发区管委会	<p>高级讲师、高级咨询师、ISO13485项目经理</p><p>20年质量管理实战经验，多体系管理专家。&nbsp;</p><p>曾任医疗器械行业高新技术企业品质经理、汽车行业企业生产部长，对质量管理理论与实践、人员培训有较强的能力。</p><p>个人特点与工作简历</p><p>专长：</p><p>在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验</p><p>擅长医疗器械行业及汽车行业体系标准及工具类课程的讲解，有丰富的实战经验。</p><p>擅长企业体系策划和流程再造管理，对流程运作原理有很深刻的理解。</p><p>咨询辅导：细心周到，工作作风严谨高效、诚信务实，</p><p>讲课风格：深入浅出、活泼生动、极富激情深受企业和学员欢迎。</p><p>个人简介及经历：曾就职于医疗器械行业企业佛山南海建泰铝制品有限公司担任品质经理，汽车行业企业担任生产部长，有丰富的生产制造、质量、管理体系统的实战经验，对ISO13485&amp;IATF16949质量管理体系、五大核心工具运用及培训、工厂流程再造有丰富的实战、推广、应用经验和十多年以上的工作经历；</p><p>经手案例</p><p>南海建泰铝制品有限公司</p><p>东升机械制造有限公司</p><p>三井化学</p><p>格力电器</p><p>富士康</p><p>佛山科勒</p><p>东丽塑料精密（中山）</p><p>广州开发区管委会</p>
10cca7c0-dfe6-11e8-b67d-08d40c3d2417	2018-11-04 11:59:45.212	2018-11-04 11:59:45.212	t	t	赵群娃	\N	/uploads/image/2018/11/4/1159173973445498.jpg	高级讲师、高级咨询师、六西格玛黑带、美国卡特彼勒全球供应链推广的生产系统（CPS）项目领导人BB+。\r\n曾担任生产、工程，质量等高级管理。有丰富的工程技术、生产制造、质量、管理体系统的实战经验，对IATF16949汽车质量管理体系、五大核心工具运用及培训、6SIGEMA、工厂流程再造有丰富的实战、推广、应用经验和十年以上的工作经历；\r\n个人特点与工作简历\r\n专长：\r\n在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验\r\n擅长汽车行业体系标准及工具类课程的讲解，在汽车行业有丰富的实战经验。\r\n擅长企业体系策划和流程再造管理，对流程运作原理有很深刻的理解。\r\n咨询辅导：细心周到，工作作风严谨高效、诚信务实，\r\n讲课风格：深入浅出、活泼生动、极富激情深受企业和学员欢迎。\r\n个人简介及经历：曾就职于美国TUSON（中国）工厂，曾担任生产、工程，质量等高级管理。有丰富的工程技术、生产制造、质量、管理体系统的实战经验，对IATF16949汽车质量管理体系、五大核心工具运用及培训、6SIGEMA、工厂流程再造有丰富的实战、推广、应用经验和十年以上的工作经历；\r\n经手案例\r\n深圳信恳智能电子股份\r\n东莞康驰实业有	<p>高级讲师、高级咨询师、六西格玛黑带、美国卡特彼勒全球供应链推广的生产系统（CPS）项目领导人BB+。</p><p>曾担任生产、工程，质量等高级管理。有丰富的工程技术、生产制造、质量、管理体系统的实战经验，对IATF16949汽车质量管理体系、五大核心工具运用及培训、6SIGEMA、工厂流程再造有丰富的实战、推广、应用经验和十年以上的工作经历；</p><p>个人特点与工作简历</p><p>专长：</p><p>在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验</p><p>擅长汽车行业体系标准及工具类课程的讲解，在汽车行业有丰富的实战经验。</p><p>擅长企业体系策划和流程再造管理，对流程运作原理有很深刻的理解。</p><p>咨询辅导：细心周到，工作作风严谨高效、诚信务实，</p><p>讲课风格：深入浅出、活泼生动、极富激情深受企业和学员欢迎。</p><p>个人简介及经历：曾就职于美国TUSON（中国）工厂，曾担任生产、工程，质量等高级管理。有丰富的工程技术、生产制造、质量、管理体系统的实战经验，对IATF16949汽车质量管理体系、五大核心工具运用及培训、6SIGEMA、工厂流程再造有丰富的实战、推广、应用经验和十年以上的工作经历；</p><p>经手案例</p><p>深圳信恳智能电子股份</p><p>东莞康驰实业有限公司</p><p>东铭新能源股份</p><p>富日挂车</p><p>日本东洋旺和</p><p>深圳STEYR</p><p>秦人金属</p><p>深圳欧陆通(6sigema)</p><p>中山赛特奥生活科技</p>
7df83210-dfe6-11e8-b67d-08d40c3d2417	2018-11-04 12:02:48.369	2018-11-04 12:02:48.369	t	t	郭松平	\N	/uploads/image/2018/11/4/12273553146730.jpg	成都科技大学， 学士学位，高级讲师、高级咨询师。\r\n十多年工厂工作经历，历任工程师、部门经理、总监等职位， 从事过产品设计开发、品质管理、生产管理。8年的审核与咨询培训工作经历，服务客户超过500家。\r\n现从事企业管理咨询工作， 致力于企业可持续发展和绿色生产力促进。 任公司运营总监，负责公司整体市场策略以及运营管理\r\n个人特点与工作简历\r\n专长：\r\n在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验\r\n擅长汽车行业体系标准及工具类课程的讲解，在汽车行业有丰富的实战经验。\r\n擅长企业体系策划和流程再造管理，对流程运作原理有很深刻的理解。\r\n擅长在制造业推行班组安全生产标准化体系（班组安全生产六大模块）\r\n咨询辅导：\r\n细心周到，工作作风严谨高效、诚信务实，\r\n讲课风格：\r\n深入浅出、活泼生动、极富激情深受企业和学员欢迎。\r\n个人简介及经历：\r\n从事企业实务工作十余年，曾任钜熙实业（台资）人力资源部经理、办公室主任；广州汽车集团（国企）品质部经理；新维顾问公司经理。全面从事企业管理与经营改善研究与实践，人事培训及人力资源开发。从事管理顾问已九年有余，辅导过电子、电器、五金、机械、建筑、食品、纺织、鞋业、	<p>成都科技大学， 学士学位，高级讲师、高级咨询师。</p><p>十多年工厂工作经历，历任工程师、部门经理、总监等职位， 从事过产品设计开发、品质管理、生产管理。8年的审核与咨询培训工作经历，服务客户超过500家。</p><p>现从事企业管理咨询工作， 致力于企业可持续发展和绿色生产力促进。 任公司运营总监，负责公司整体市场策略以及运营管理</p><p>个人特点与工作简历</p><p>专长：</p><p>在制造业的质量管理、生产管理、项目管理等方面具有丰富的实战经验</p><p>擅长汽车行业体系标准及工具类课程的讲解，在汽车行业有丰富的实战经验。</p><p>擅长企业体系策划和流程再造管理，对流程运作原理有很深刻的理解。</p><p>擅长在制造业推行班组安全生产标准化体系（班组安全生产六大模块）</p><p>咨询辅导：</p><p>细心周到，工作作风严谨高效、诚信务实，</p><p>讲课风格：</p><p>深入浅出、活泼生动、极富激情深受企业和学员欢迎。</p><p>个人简介及经历：</p><p>从事企业实务工作十余年，曾任钜熙实业（台资）人力资源部经理、办公室主任；广州汽车集团（国企）品质部经理；新维顾问公司经理。全面从事企业管理与经营改善研究与实践，人事培训及人力资源开发。从事管理顾问已九年有余，辅导过电子、电器、五金、机械、建筑、食品、纺织、鞋业、汽车、玩具、服装、家具等行业推行ISO9000、IATF16949、ISO14000、SA8000、HACCP、OHSAS18000、3C等体系认证，及企业策划、现场改善、专题培训近500家企业。其咨询辅导和培训深入浅出、活泼生动、细心周到，工作作风严谨高效、诚信务实，深受企业和学员欢迎。</p><p>三井化学</p><p>1.格力电器</p><p>2.富士康</p><p>3.佛山科勒</p><p>4.东丽塑料精密（中山）</p><p>5.广州开发区管委会</p>
add241b0-dfe6-11e8-b67d-08d40c3d2417	2018-11-04 12:04:08.651	2018-11-04 12:04:08.651	t	t	万小青	\N	/uploads/image/2018/11/4/123363535754080.jpg	万小青: 机械制造及自动化专业工学士、企业管理专业硕士、工商管理专业硕士、国家注册企业培训师 \r\n企业管理课题培训经历\r\n十多年各类型企业中层、高管任职工作经历，积累了丰富的管理实战经验注重于企业的实际管理、可操作性研究。数百多场次的企业培训和公开演讲，为企业的可持续发展提供了有效的实务帮助，赢得了业界良好的口碑和赞誉。\r\n讲课风格：培训课题内容充实实用透彻，课程操作性强，善于运用讲故事启发，课程视角独到，生动风趣\r\n经手案例：\r\n广州华鑫科技、广东雅利高实业、中山市明峰服饰、江苏泰州良帅服饰、中山市法丹奴服饰、广东宝丽雅实业集团、顺德小太阳砂磨材料、顺徳美威包装品有限公司、北京建侬体育用品、中山宝路易服饰、广东华纶集团、中山利达针织集团、广东步步高电子工业有限公司、珠海正大康地、珠海姗拉娜化妆品、中山市东华印艺、中山市创星电器、中山市强力电器、中山市开利达电机、中山市DIC色料有限公司（日资）、中山泰星纸袋制品有限公司（日资）、中山万雄厨卫等行业知名企业	<p>万小青: 机械制造及自动化专业工学士、企业管理专业硕士、工商管理专业硕士、国家注册企业培训师&nbsp;</p><p>企业管理课题培训经历</p><p>十多年各类型企业中层、高管任职工作经历，积累了丰富的管理实战经验注重于企业的实际管理、可操作性研究。数百多场次的企业培训和公开演讲，为企业的可持续发展提供了有效的实务帮助，赢得了业界良好的口碑和赞誉。</p><p>讲课风格：培训课题内容充实实用透彻，课程操作性强，善于运用讲故事启发，课程视角独到，生动风趣</p><p>经手案例：</p><p>广州华鑫科技、广东雅利高实业、中山市明峰服饰、江苏泰州良帅服饰、中山市法丹奴服饰、广东宝丽雅实业集团、顺德小太阳砂磨材料、顺徳美威包装品有限公司、北京建侬体育用品、中山宝路易服饰、广东华纶集团、中山利达针织集团、广东步步高电子工业有限公司、珠海正大康地、珠海姗拉娜化妆品、中山市东华印艺、中山市创星电器、中山市强力电器、中山市开利达电机、中山市DIC色料有限公司（日资）、中山泰星纸袋制品有限公司（日资）、中山万雄厨卫等行业知名企业</p><p><br/></p>
08eb06e0-dfe7-11e8-b67d-08d40c3d2417	2018-11-04 12:06:41.486	2018-11-04 12:06:41.486	t	t	胡长海	\N	/uploads/image/2018/11/4/126183744122594.jpg	新咨力高级讲师、技术专家，CCAA/IATF/IECQ注册主任审核员（ISO9000/TS16949/QC080000/ISO14000/OHSAS18000）-《突破ISO9000－新质量管理　高财务收益》作者，学士学位，历任日本JSP工程塑料工程主管、PBSE高级培训主管、美国雄狮远东集团QA经理和运营总监、曼顿顾问机构咨询经理、KSR认证机构华南区域经理、TUV Rheinland产品经理、BSI客户经理、OQS华南区域经理。\r\n职业专长：\r\n-系统运营解决方案\r\n-生产现场管理和改进\r\n-供应链管理战略\r\n-质量成本与零缺陷\r\n-培训体系建设\r\n-ISO9000/TS1949/QC080000内审员课程\r\n部分培训和项目实施客户例举：\r\n西安瑞联（绩效改善）、中兴通讯（HSPM-深圳、南京、西安）、赛龙通信(QMS/HSPM)、富士康（HSPM/QMS/C-TPAT）、天马微电子（HSPM/TS16949-上海、深圳、武汉）、航天光电（QMS/EMS/OHSAS/HSPM）、Nvidia（QMS/HSPM）、莱尔德电子（TS16949）、Ｍattel(高级审核技巧)、联创汽车电子（TS16949/核心工具）、上汽通用SGM（过程方法与审核技巧）、上汽集团（TS16949/过程方法）、Goodyear固特异(TS16949/过程方法－大连工厂)等。	<p>新咨力高级讲师、技术专家，CCAA/IATF/IECQ注册主任审核员（ISO9000/TS16949/QC080000/ISO14000/OHSAS18000）-《突破ISO9000－新质量管理　高财务收益》作者，学士学位，历任日本JSP工程塑料工程主管、PBSE高级培训主管、美国雄狮远东集团QA经理和运营总监、曼顿顾问机构咨询经理、KSR认证机构华南区域经理、TUV Rheinland产品经理、BSI客户经理、OQS华南区域经理。</p><p>职业专长：</p><p>-系统运营解决方案</p><p>-生产现场管理和改进</p><p>-供应链管理战略</p><p>-质量成本与零缺陷</p><p>-培训体系建设</p><p>-ISO9000/TS1949/QC080000内审员课程</p><p>部分培训和项目实施客户例举：</p><p>西安瑞联（绩效改善）、中兴通讯（HSPM-深圳、南京、西安）、赛龙通信(QMS/HSPM)、富士康（HSPM/QMS/C-TPAT）、天马微电子（HSPM/TS16949-上海、深圳、武汉）、航天光电（QMS/EMS/OHSAS/HSPM）、Nvidia（QMS/HSPM）、莱尔德电子（TS16949）、Ｍattel(高级审核技巧)、联创汽车电子（TS16949/核心工具）、上汽通用SGM（过程方法与审核技巧）、上汽集团（TS16949/过程方法）、Goodyear固特异(TS16949/过程方法－大连工厂)等。</p>
448c87a0-dfe7-11e8-b67d-08d40c3d2417	2018-11-04 12:08:21.53	2018-11-04 12:08:21.53	t	t	龙辉	\N	/uploads/image/2018/11/4/127541007819164.jpg	新咨力技术专家，国际汽车工业TS16949主任审核员，国际航空、航天及国防工业AS9100审核员，国家注册质量，环境，职业健康安全管理体系高级审核员，产品认证高级检查员；2000年出版《2000版ISO9001转换实务精编》，至今已出版5本管理体系专著。	<p>新咨力技术专家，国际汽车工业TS16949主任审核员，国际航空、航天及国防工业AS9100审核员，国家注册质量，环境，职业健康安全管理体系高级审核员，产品认证高级检查员；2000年出版《2000版ISO9001转换实务精编》，至今已出版5本管理体系专著。</p>
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
-- Name: certificate certificate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificate
    ADD CONSTRAINT certificate_pkey PRIMARY KEY (id);


--
-- Name: course_attachment course_attachment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_attachment
    ADD CONSTRAINT course_attachment_pkey PRIMARY KEY (id);


--
-- Name: course_certificate course_certificate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_certificate
    ADD CONSTRAINT course_certificate_pkey PRIMARY KEY (id);


--
-- Name: course_examination_analysis course_examination_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_pkey PRIMARY KEY (id);


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
-- Name: employee_course_exercise_analysis employee_course_exercise_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_analysis
    ADD CONSTRAINT employee_course_exercise_analysis_pkey PRIMARY KEY (id);


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
-- Name: employee_examination_paper employee_examination_paper_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_examination_paper
    ADD CONSTRAINT employee_examination_paper_pkey PRIMARY KEY (id);


--
-- Name: employee_examination_question_analysis employee_examination_question_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_examination_question_analysis
    ADD CONSTRAINT employee_examination_question_analysis_pkey PRIMARY KEY (id);


--
-- Name: employee_examination_question_item employee_examination_question_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_examination_question_item
    ADD CONSTRAINT employee_examination_question_item_pkey PRIMARY KEY (id);


--
-- Name: employee_examination_question employee_examination_question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_examination_question
    ADD CONSTRAINT employee_examination_question_pkey PRIMARY KEY (id);


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
-- Name: examination_config examination_config_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_config
    ADD CONSTRAINT examination_config_pkey PRIMARY KEY (id);


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
-- Name: store_paper store_paper_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_paper
    ADD CONSTRAINT store_paper_pkey PRIMARY KEY (id);


--
-- Name: store_question_analysis store_question_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_question_analysis
    ADD CONSTRAINT store_question_analysis_pkey PRIMARY KEY (id);


--
-- Name: store_question_item store_question_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_question_item
    ADD CONSTRAINT store_question_item_pkey PRIMARY KEY (id);


--
-- Name: store_question store_question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_question
    ADD CONSTRAINT store_question_pkey PRIMARY KEY (id);


--
-- Name: sys_base_config sys_base_config_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sys_base_config
    ADD CONSTRAINT sys_base_config_pkey PRIMARY KEY (id);


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
-- Name: course_certificate course_certificate_certificate_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_certificate
    ADD CONSTRAINT course_certificate_certificate_id_fkey FOREIGN KEY (certificate_id) REFERENCES public.certificate(id);


--
-- Name: course_certificate course_certificate_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_certificate
    ADD CONSTRAINT course_certificate_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_examination_analysis course_examination_analysis_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: course_examination_analysis course_examination_analysis_examination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_examination_id_fkey FOREIGN KEY (examination_id) REFERENCES public.course_examination(id);


--
-- Name: course_examination_analysis course_examination_analysis_video_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_analysis
    ADD CONSTRAINT course_examination_analysis_video_id_fkey FOREIGN KEY (video_id) REFERENCES public.course_video(id);


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
-- Name: course_examination_item course_examination_item_examination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course_examination_item
    ADD CONSTRAINT course_examination_item_examination_id_fkey FOREIGN KEY (examination_id) REFERENCES public.course_examination(id);


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
-- Name: employee_course_exercise_analysis employee_course_exercise_analysis_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_analysis
    ADD CONSTRAINT employee_course_exercise_analysis_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.employee_course_exercise(id);


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
-- Name: employee_course_exercise_item employee_course_exercise_item_exercise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_course_exercise_item
    ADD CONSTRAINT employee_course_exercise_item_exercise_id_fkey FOREIGN KEY (exercise_id) REFERENCES public.employee_course_exercise(id);


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
-- Name: employee_examination_question_analysis employee_examination_question_analysis_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_examination_question_analysis
    ADD CONSTRAINT employee_examination_question_analysis_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.employee_examination_question(id);


--
-- Name: employee_examination_question_item employee_examination_question_item_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_examination_question_item
    ADD CONSTRAINT employee_examination_question_item_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.employee_examination_question(id);


--
-- Name: employee_examination_question employee_examination_question_paper_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee_examination_question
    ADD CONSTRAINT employee_examination_question_paper_id_fkey FOREIGN KEY (paper_id) REFERENCES public.employee_examination_paper(id);


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
-- Name: examination_paper examination_paper_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_paper
    ADD CONSTRAINT examination_paper_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: examination_question_analysis examination_question_analysis_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examination_question_analysis
    ADD CONSTRAINT examination_question_analysis_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.examination_question(id);


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
-- Name: store_paper store_paper_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_paper
    ADD CONSTRAINT store_paper_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: store_question_analysis store_question_analysis_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_question_analysis
    ADD CONSTRAINT store_question_analysis_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.store_question(id);


--
-- Name: store_question_item store_question_item_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_question_item
    ADD CONSTRAINT store_question_item_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.store_question(id);


--
-- Name: store_question store_question_paper_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store_question
    ADD CONSTRAINT store_question_paper_id_fkey FOREIGN KEY (paper_id) REFERENCES public.store_paper(id);


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

